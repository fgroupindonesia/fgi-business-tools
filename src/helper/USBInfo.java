/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class USBInfo {

    public static void main(String[] args) {
        //for testing purposes
        //getDeviceSerialNumber("G:");
    }

    public static String getDeviceSerialNumber(String adriveLetter) {
        // command prompt in windows OS only!
        // wmic logicaldisk get description, deviceid, volumeserialnumber
        /*
        example output: 
        Description       DeviceID  VolumeSerialNumber
        Local Fixed Disk  C:        30C7A94D
        Local Fixed Disk  D:        1645F040
        CD-ROM Disc       E:
        CD-ROM Disc       F:
        Removable Disk    G:        A2444050    
         */
        adriveLetter = adriveLetter.replace("\\", "");
        String commandNa = "wmic logicaldisk get description, deviceid, volumeserialnumber";

        String hasilNa = CMDExecutor.executeCommand(commandNa);
        String getDrive = null;
        // get the line with drive letter matched
        String intoLines[] = hasilNa.split("\n");
        //System.out.println("===============");
        for (String f : intoLines) {

            //System.out.println(f);
            if (f.contains(adriveLetter)) {
                // that the line we wanted
                getDrive = f;
                System.out.println("ada " + getDrive);
                break;
            }
        }

        //System.out.println("Executing " + commandNa);
        //System.out.println("Hasilnya " + cleanUpSerial(hasilNa));
        return cleanUpSerial(getDrive, adriveLetter);
    }

    private static String cleanUpSerial(String serialFromCMD, String adriveLetter) {

        serialFromCMD = serialFromCMD.replaceAll("\\s", "");
        serialFromCMD = serialFromCMD.replace("RemovableDisk", "").replace(adriveLetter, "");
        return serialFromCMD;
    }

}
