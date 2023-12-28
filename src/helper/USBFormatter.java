
package helper;

/**
 *
 * @author staff
 */
public class USBFormatter {
    public static void formatNow(String driveLetter){
        // i.e: written as G:
        // passed into cmd prompt : 
        // format G: /q /fs:ntfs
        
        
        String command = "format " + driveLetter.replace("\\", "") + " /q /fs:ntfs";
        System.out.println("Executing " + command);
        String hasil = CMDExecutor.executeCommand(command);
        System.out.println("Formatting Done!");
    }
}
