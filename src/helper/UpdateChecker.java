
package helper;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import config.SystemPath;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Properties;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.SwingWorker;

/**
 *
 * @author staff
 */
public class UpdateChecker {

    public final static int OPTION_EVERY_WEEK_ONCE = 2;
    public final static int OPTION_EVERY_PROGRAM_STARTS = 1;
    public final static int OPTION_OFF = 0;

    private boolean updates_ready;
    JProgressBar progressBar;
    JLabel statusLabel;
    double future_version;
    private boolean turned_off;

    public double getFuture_version() {
        return future_version;
    }

    public void setFuture_version(double n) {
        future_version = n;
    }

    public void checkNow() {

        String url = URLManager.getCheckUpdatesURL();
        String username = "admin";
        String token = "1234";
        String result = checkUpdate(url, username, token);

        // the end result is json format
        // { status: "valid", version : "2.0" }
        JsonParser parser = new JsonParser();
        JsonObject json = parser.parse(result).getAsJsonObject();

        // Get values from the JSON object
        String status = json.get("status").getAsString();
        String version = json.get("version").getAsString();

        if (null == status) {
            setUpdates_ready(false);
        } else {
            switch (status) {
                case "valid":
                    setUpdates_ready(true);
                    setFuture_version(Double.parseDouble(version));
                    break;
                case "invalid":
                    setUpdates_ready(false);
                    break;
                default:
                    setUpdates_ready(false);
                    break;
            }
        }

    }

    private boolean isThisWeekAlreadyDone() {

        boolean stat = false;
        Properties properties = null;

        try {
            properties = loadProperties("log.dat");
            String lastCheckedDateString = properties.getProperty("last-checked-date");

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

            LocalDate lastCheckedDate = LocalDate.parse(lastCheckedDateString, formatter);

            // check
            LocalDate oneWeekAgo = LocalDate.now().minusWeeks(1);
            stat = lastCheckedDate.isBefore(oneWeekAgo);

            if (!stat) {
                writeLastChecked(properties);
            }

        } catch (Exception e) {
            writeLastChecked(properties);
        }

        return stat;
    }

    private void writeLastChecked(Properties prop) {
        try {
            prop.setProperty("last-checked-date", getCurrentDateAsString());
            saveProperties(prop, "log.dat");
        } catch (Exception ex) {

        }
    }

    private static Properties loadProperties(String fileName) throws Exception {
        Properties properties = new Properties();
        try (FileInputStream input = new FileInputStream(fileName)) {
            properties.load(input);
        }
        return properties;
    }

    private static void saveProperties(Properties properties, String fileName) throws Exception {
        try (FileOutputStream output = new FileOutputStream(fileName)) {
            properties.store(output, "Doctor Visit Log");
        }
    }

    private static String getCurrentDateAsString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.now().format(formatter);
    }

    public void checkWhen(int options) {

        if (options == OPTION_EVERY_PROGRAM_STARTS) {
            checkNow();
            setTurned_off(false);
        } else if (options == OPTION_EVERY_WEEK_ONCE) {
            if (!isThisWeekAlreadyDone()) {
                checkNow();
                setTurned_off(false);
            }
        }

    }

    public int asOptions(String value) {

        if (value.equalsIgnoreCase("program_starts")) {
            return OPTION_EVERY_PROGRAM_STARTS;
        } else if (value.equalsIgnoreCase("week_once")) {
            return OPTION_EVERY_WEEK_ONCE;
        }

        return OPTION_OFF;
    }

    private String checkUpdate(String url, String username, String token) {
        StringBuilder result = new StringBuilder();

        try {
            URL checkUpdateUrl = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) checkUpdateUrl.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);

            String requestBody = "username=" + username + "&token=" + token;
            byte[] requestBodyBytes = requestBody.getBytes(StandardCharsets.UTF_8);

            try (OutputStream outputStream = connection.getOutputStream()) {
                outputStream.write(requestBodyBytes);
            }

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    result.append(line);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error while checking updates." + e.getMessage());
        }

        return result.toString().trim();
    }

    int bytesRead = 0;
    boolean downloadWorkDone = false;
    int fileSize = 0;

    public void downloadNow() {
        String fileUrl = URLManager.getDownloadUpdatesURL();
        String destinationFilePath = SystemPath.getFolderUpdates(getFuture_version());

        File folder = new File(destinationFilePath);

        if (!folder.exists()) {
            // create every folders needed
            folder.mkdirs();
        }

        SwingWorker<Void, Integer> worker = new SwingWorker<Void, Integer>() {
            @Override
            protected Void doInBackground() throws Exception {
                // prepare the variable initalizations
                fileSize = 0;
                bytesRead = 0;

                URL url = new URL(fileUrl);
                URLConnection connection = url.openConnection();
                fileSize = connection.getContentLength();

                try (InputStream in = connection.getInputStream();
                        FileOutputStream out = new FileOutputStream(destinationFilePath + "\\" + SystemPath.getSetupUpdatesFile())) {

                    byte[] buffer = new byte[1024];
                    int bytesReadThisRound;

                    while ((bytesReadThisRound = in.read(buffer)) != -1) {
                        out.write(buffer, 0, bytesReadThisRound);
                        bytesRead += bytesReadThisRound;

                        int progress = (int) ((double) bytesRead / fileSize * 100);
                        publish(progress);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

                return null;
            }

            @Override
            protected void process(java.util.List<Integer> chunks) {
                for (int progress : chunks) {

                    if (isGUIReady()) {
                        setProgressValue(progress, "Downloading... " + bytesRead / 1024 + " KB of " + fileSize / 1024 + " MB");
                    }

                }
            }

            @Override
            protected void done() {
                if (isGUIReady()) {
                    setProgressValue(100, "Download complete!");
                }
                downloadWorkDone = true;
            }

            public void setProgressValue(int percent, String message) {
                progressBar.setValue(percent);
                statusLabel.setText(message);
            }

        };

        worker.execute();
    }

    private boolean isGUIReady() {
        if (statusLabel != null && progressBar != null) {
            return true;
        }

        return false;

    }

    /**
     * @return the updates_ready
     */
    public boolean isUpdates_ready() {
        return updates_ready;
    }

    /**
     * @param updates_ready the updates_ready to set
     */
    public void setUpdates_ready(boolean updates_ready) {
        this.updates_ready = updates_ready;
    }

    /**
     * @return the turned_off
     */
    public boolean isTurned_off() {
        return turned_off;
    }

    /**
     * @param turned_off the turned_off to set
     */
    public void setTurned_off(boolean turned_off) {
        this.turned_off = turned_off;
    }
}
