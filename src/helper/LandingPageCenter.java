package helper;

import config.SystemPath;
import frames.LandingPageFrame;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import javafx.scene.web.WebEngine;
import javax.swing.JLabel;

/**
 *
 * @author staff
 */
public class LandingPageCenter {

    JLabel labelLoading;
    LandingPageFrame lpform;
    WebEngine webEngine;

    public void setWebEngine(WebEngine we) {
        webEngine = we;
    }

    public void setLandingPageForm(LandingPageFrame pform) {
        lpform = pform;
    }

    public void setLabelLoading(JLabel jp) {
        labelLoading = jp;
    }

    public LandingPageCenter(JLabel lp, LandingPageFrame pform) {
        labelLoading = lp;
        this.setLandingPageForm(pform);
    }

    public String getAsPath(String themeName, String fileDest) {
        return SystemPath.getFolderWorks() + themeName + "\\" + fileDest;

    }

    public void reset(String themeName) {

        System.out.println("Theme resetting...");

        String sourceFileName = getAsPath(themeName, SystemPath.BACKUP_THEME_FILE);
        String destinationFileName = getAsPath(themeName, SystemPath.INDEX_THEME_FILE);

        try (InputStream in = new FileInputStream(sourceFileName);
                OutputStream out = new FileOutputStream(destinationFileName)) {

            byte[] buffer = new byte[1024];
            int length;
            while ((length = in.read(buffer)) > 0) {
                out.write(buffer, 0, length);
            }

            System.out.println("Theme resetted successfully!");

            if (lpform != null) {
                lpform.reloadPage(themeName, true);
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error while resetting Theme " + themeName);
        }
    }

    private String getPageSource() {
        // Execute JavaScript to obtain the page source
        return (String) webEngine.executeScript("document.documentElement.outerHTML");
    }

    private void writeMainIndexChanges(String newHTML, String themeName) {

        File fileIndexTheme = new File(SystemPath.getFolderWorks() + themeName, SystemPath.getIndexFile());

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileIndexTheme.getAbsolutePath()))) {
            String content = newHTML;
            writer.write(content);
            System.out.println("Writing Changes into theme is success!");
        } catch (Exception ex) {
            ex.printStackTrace();
            System.err.println("Error saving text to file!");
        }

    }

    private void prepareEditingMode(String themeName) {

        try {
            String location = SystemPath.getFolderWorks() + themeName;
            File sourceFile = new File(location, SystemPath.getEditedFile());
            File destinationFile = new File(location, SystemPath.getIndexFile());

            // Create FileInputStream to read from the source file
            FileInputStream fis = new FileInputStream(sourceFile.getAbsolutePath());

            // Create FileOutputStream to write to the destination file
            FileOutputStream fos = new FileOutputStream(destinationFile.getAbsolutePath());

            // Create a buffer to hold the data being transferred
            byte[] buffer = new byte[4096]; // You can adjust the buffer size as needed

            int bytesRead;
            // Read from the input stream and write to the output stream
            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }

            // Close the streams
            fis.close();
            fos.close();

            System.out.println("Editing Mode is ready!");

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error when activating edit mode");
        }
    }

    private void takeOutTemporary(String themeName, String fileName) {
        File themeFolder = new File(SystemPath.getFolderWorks() + themeName);
        File filePath = new File(themeFolder.getAbsolutePath(), fileName);

        move(filePath.getAbsolutePath(), themeFolder.getParent());
    }

    private void takeInTemporary(String themeName, String fileName) {
        File themeFolder = new File(SystemPath.getFolderWorks() + themeName);
        File filePath = new File(themeFolder.getParent(), fileName);

        move(filePath.getAbsolutePath(), themeFolder.getAbsolutePath());
    }

    private void move(String fileOrigin, String destinationFolderPath) {
        try {
            // Create Path objects for source and destination
            Path sourcePath = Paths.get(fileOrigin);
            Path destinationPath = Paths.get(destinationFolderPath).resolve(sourcePath.getFileName());

            // Move the file to the destination folder
            Files.move(sourcePath, destinationPath);

            System.out.println("File moved successfully.");

        } catch (Exception e) {
            System.err.println("File already exists in the destination folder.");
        }
    }

    public void save(String themeName, File selectedFileSave) {

        String editedContent = getPageSource();
        this.writeMainIndexChanges(editedContent, themeName);

        // move out the 2 important files
        this.takeOutTemporary(themeName, SystemPath.getBackupIndexFile());
        this.takeOutTemporary(themeName, SystemPath.getEditedFile());

        //File targetDestFolder = new File(SystemPath.getFolderWorks());
        // check whether the theme is already exist?
        File themeFolder = new File(SystemPath.getFolderWorks() + themeName);
        String folderPath = themeFolder.getAbsolutePath();

        if (folderPath.isEmpty()) {
            PopupMessage.showError("Please select a folder to zip.");
            return;
        }

        File folderToZip = new File(folderPath);
        if (!folderToZip.isDirectory()) {
            PopupMessage.showError("Selected path is not a folder.");
            return;
        }

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                String zipFilePath = selectedFileSave.getAbsolutePath() + ".zip";

                try (
                        FileOutputStream fos = new FileOutputStream(zipFilePath);
                        ZipOutputStream zipOut = new ZipOutputStream(fos)) {

                    zipFile(folderToZip, folderToZip.getName(), zipOut);

                    // returning the 2 important files
                    takeInTemporary(themeName, SystemPath.getBackupIndexFile());
                    takeInTemporary(themeName, SystemPath.getEditedFile());

                    System.out.println("Folder successfully zipped to:" + zipFilePath);
                } catch (Exception ex) {
                    ex.printStackTrace();
                    System.err.println("Error when zipping files & folders!");
                }
            }
        });

        // Starting the thread
        thread.start();

    }

    private void zipFile(File fileToZip, String fileName, ZipOutputStream zipOut) throws IOException {
        if (fileToZip.isHidden()) {
            return;
        }

        if (fileToZip.isDirectory()) {
            if (fileName.endsWith("/")) {
                zipOut.putNextEntry(new ZipEntry(fileName));
                zipOut.closeEntry();
            } else {
                zipOut.putNextEntry(new ZipEntry(fileName + "/"));
                zipOut.closeEntry();
            }

            File[] children = fileToZip.listFiles();
            for (File child : children) {
                zipFile(child, fileName + "/" + child.getName(), zipOut);
            }
            return;
        }

        try (FileInputStream fis = new FileInputStream(fileToZip)) {
            ZipEntry zipEntry = new ZipEntry(fileName);
            zipOut.putNextEntry(zipEntry);

            byte[] bytes = new byte[1024];
            int length;
            while ((length = fis.read(bytes)) >= 0) {
                zipOut.write(bytes, 0, length);
            }
        }
    }

    public void grab(String themeName) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                // Code to be executed by the thread
                ZipExtractor engine = new ZipExtractor();

                if (labelLoading != null) {
                    engine.setProgressLabel(labelLoading);
                }

                if (lpform != null) {
                    engine.setLandingPageForm(lpform);
                }

                File targetDestFolder = new File(SystemPath.getFolderWorks());

                // check whether the theme is already exist?
                File themeFolder = new File(SystemPath.getFolderWorks() + themeName);

                if (!themeFolder.exists()) {
                    System.out.println("Obtaining the theme : " + themeName + " into local mode successfully!");
                    engine.unzip(engine.getFile(themeName).getAbsolutePath(), targetDestFolder.getAbsolutePath());
                } else {
                    System.out.println("The theme : " + themeName + " is already in local!");

                    // prepare the editing mode into the index
                    prepareEditingMode(themeName);
                    lpform.reloadPage(themeName, true);
                }

            }
        });

        // Starting the thread
        thread.start();
    }
}
