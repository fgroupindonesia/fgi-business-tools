package helper;

/**
 *
 * @author staff
 */
import config.SystemPath;
import frames.LandingPageFrame;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

public class ZipExtractor {

    JProgressBar progressBar;
    JLabel progressLabel;
    LandingPageFrame lpform;
    String themeNameSelected;

    public ZipExtractor() {
        createFolder(SystemPath.getFolderTemplate());
    }

    public void setProgressBar(JProgressBar jp) {
        progressBar = jp;
    }

    public void setProgressLabel(JLabel jl) {
        progressLabel = jl;
    }

    public File getFile(String themeName) {
        themeNameSelected = themeName;
        return new File(SystemPath.getFolderTemplate() + themeName + ".zip");
    }

    public void setLandingPageForm(LandingPageFrame lpmform) {
        lpform = lpmform;
    }

    public void createFolder(String folderName) {
        File f = new File(folderName);
        if (!f.exists()) {
            f.mkdirs();
        }
    }

    public void unzip(String zipFilePath, String extractPath) {

        try {
            System.out.println("---------------\nExtraction started!");
            System.out.println("from " + zipFilePath + " into " + extractPath);

            JarFile jarfile = new JarFile(new File(zipFilePath)); //jar file path(here sqljdbc4.jar)
            Enumeration<JarEntry> enu = jarfile.entries();
            Enumeration<JarEntry> enuCounter = jarfile.entries();

            int totalFiles = 0;
            int currentFile = 0;

            // counting first
            while (enuCounter.hasMoreElements()) {
                JarEntry entry = enuCounter.nextElement();
                //if (!entry.isDirectory()) {
                totalFiles++;
                //}
            }

            System.out.println("We have " + totalFiles + " total files.");

            // now doing the operation work (copying etc)
            while (enu.hasMoreElements()) {
                //abc is my destination directory
                JarEntry je = enu.nextElement();

                System.out.println(je.getName());

                File fl = new File(extractPath, je.getName());
                if (!fl.exists()) {
                    fl.getParentFile().mkdirs();
                    fl = new File(extractPath, je.getName());
                }
                if (je.isDirectory()) {
                    continue;
                }

                InputStream is = jarfile.getInputStream(je);
                FileOutputStream fo = new FileOutputStream(fl);

                long fileLength = fl.length();

                byte[] buffer = new byte[4096];
                int n = 0;
                int totalBytesRead = 0;
                while (-1 != (n = is.read(buffer))) {
                    fo.write(buffer, 0, n);
                    totalBytesRead += n;

                    if (!fl.isDirectory() && fileLength != 0) {
                        int progress = (int) ((totalBytesRead * 100) / fileLength);
                        if (progressBar != null) {
                            progressBar.setValue(progress);
                        }
                    }

                    if (progressLabel != null) {
                        progressLabel.setVisible(true);
                        progressLabel.setText("|   Loading .... " + currentFile + " of " + totalFiles + ". ");
                    }

                }

                currentFile++;
                fo.close();
                is.close();
            }

            if (progressLabel != null) {
                progressLabel.setVisible(false);
            }

            System.out.println("---------------\nExtraction complete.");

            if (lpform != null) {
                lpform.reloadPage(themeNameSelected, true);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
