/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frames;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 *
 * @author staff
 */
public class WindowsSkeleton extends JFrame {

    ImageIcon app_icon = new javax.swing.ImageIcon(getClass().getResource("/frames/images/fgi-case-logo.png"));

    public WindowsSkeleton() {
        windowsTheme();

    }

    public void windowsTheme() {
        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
            if ("Windows".equals(info.getName())) {
                try {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                } catch (Exception ex) {

                }
            }
        }

        setIconImage(app_icon.getImage());
    }
}
