package helper;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

/**
 *
 * @author staff
 */
public class CMDExecutor {

    public static String executeCommand(String command) {
        String hasil = null;
        try {
            ProcessBuilder processBuilder = new ProcessBuilder("cmd.exe", "/c", command);
            processBuilder.redirectErrorStream(true);

            Process process = processBuilder.start();

            // Capture the output
            InputStream inputStream = process.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuffer output = new StringBuffer();

            OutputStream child_stdin = process.getOutputStream();
            BufferedWriter child_writer = new BufferedWriter(new OutputStreamWriter(child_stdin));

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("- " + line);
                if (line.contains("ENTER") || line.contains("disk")) {
                    child_writer.write("\n");
                    child_writer.newLine();  // suggested by OP
                    child_writer.flush();

                    Robot r = new Robot();
                    r.keyPress(KeyEvent.VK_ENTER);
                }
                output.append(line).append("\n");
            }

            // Wait for the process to complete
            int exitCode = process.waitFor();

            if (exitCode != 0) {
                // Handle error if needed
                System.out.println("Command execution failed with exit code: " + exitCode);
            }

            // Close resources
            reader.close();
            inputStream.close();

            hasil = output.toString();
        } catch (Exception ex) {
            System.err.println("Error while executing command!");
        }

        return hasil;
    }
}
