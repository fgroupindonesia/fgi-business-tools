package helper;

import javax.swing.JOptionPane;

/**
 *
 * @author staff
 */
public class PopupMessage {

    public static void showError(String message) {

        JOptionPane.showMessageDialog(null, message, "", JOptionPane.ERROR_MESSAGE);

    }
    
      public static int showConfirmation(String question) {

       return JOptionPane.showConfirmDialog(
                null,
                question,
                "Confirmation",
                JOptionPane.YES_NO_OPTION
        );
       
    }

    public static void showInfo(String message) {

        JOptionPane.showMessageDialog(null, message, "", JOptionPane.INFORMATION_MESSAGE);

    }
    
    
}
