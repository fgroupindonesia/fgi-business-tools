package frames.forms;

import frames.DashboardFrame;
import helper.DBTransactions;
import config.SystemPath;
import frames.WebToAPKManagerFrame;
import frames.WindowsSkeleton;
import helper.DateHelper;
import helper.UIForm;
import helper.objects.AppsProfile;
import helper.objects.DownloadLink;
import helper.objects.UserSettings;
import helper.objects.WebToAPK;
import java.awt.event.ItemEvent;
import java.util.ArrayList;

/**
 *
 * @author staff
 */
public class UserSettingsForm extends WindowsSkeleton {

    /**
     * Creates new form NewAppsProfileFrame
     */
    boolean editMode = false;
    DashboardFrame parent;
    UserSettings localData;

    private void prepareUI() {
        initComponents();
        refresh();

        label_queue_id.setVisible(false);
    }

    public UserSettingsForm() {
        prepareUI();

    }

    public UserSettingsForm(DashboardFrame parentNa) {
        parent = parentNa;
        prepareUI();
    }

    public void refresh() {

        localData = db.select_specific_UserSettings(1);
        textfield_email.setText(localData.getEmail());
        textfield_pass.setText(localData.getPass());
        textfield_username.setText(localData.getUsername());
        textfield_email.setText(localData.getEmail());

        if (localData.getRemember_me() == UIForm.VALUE_NUMERIC_SELECTED) {
            checkbox_remember_me.setSelected(true);
        }

        if (localData.getCheck_updates().contains("everyweek")) {
            radiobutton_check_updates_everyweek.setSelected(true);
        } else if (localData.getCheck_updates().contains("program_starts")) {
            radiobutton_check_updates_everystarts.setSelected(true);
        } else {
            radiobutton_check_updates_off.setSelected(true);
        }

    }

    DBTransactions db = new DBTransactions(SystemPath.DB_FILE);

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        label_queue_id = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        textfield_email = new javax.swing.JTextField();
        button_save = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        textfield_username = new javax.swing.JTextField();
        checkboxShowPass = new javax.swing.JCheckBox();
        textfield_pass = new javax.swing.JPasswordField();
        radiobutton_check_updates_everystarts = new javax.swing.JRadioButton();
        radiobutton_check_updates_everyweek = new javax.swing.JRadioButton();
        radiobutton_check_updates_off = new javax.swing.JRadioButton();
        label_queue_id1 = new javax.swing.JLabel();
        checkbox_remember_me = new javax.swing.JCheckBox();
        label_queue_id2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        setType(java.awt.Window.Type.POPUP);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label_queue_id.setText("Always Remember Me (Login):");
        getContentPane().add(label_queue_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 160, 30));

        jPanel1.setBackground(new java.awt.Color(0, 153, 255));
        jPanel1.setAlignmentX(0.0F);
        jPanel1.setAlignmentY(0.0F);
        jPanel1.setLayout(new java.awt.BorderLayout());

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("User Settings");
        jPanel1.add(jLabel5, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 410, 60));
        getContentPane().add(textfield_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, 180, -1));

        button_save.setText("Save");
        button_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_saveActionPerformed(evt);
            }
        });
        getContentPane().add(button_save, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 310, 120, 36));

        jLabel6.setText("Password :");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 70, -1));

        jLabel7.setText("Username : ");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 70, -1));
        getContentPane().add(textfield_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, 230, -1));

        checkboxShowPass.setText("Show");
        checkboxShowPass.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                checkboxShowPassItemStateChanged(evt);
            }
        });
        checkboxShowPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkboxShowPassActionPerformed(evt);
            }
        });
        getContentPane().add(checkboxShowPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 120, -1, -1));

        textfield_pass.setText("jPasswordField1");
        getContentPane().add(textfield_pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, 150, -1));

        buttonGroup1.add(radiobutton_check_updates_everystarts);
        radiobutton_check_updates_everystarts.setText("When Program Starts");
        radiobutton_check_updates_everystarts.setName("program_starts"); // NOI18N
        getContentPane().add(radiobutton_check_updates_everystarts, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, -1, -1));

        buttonGroup1.add(radiobutton_check_updates_everyweek);
        radiobutton_check_updates_everyweek.setText("Every Week Once");
        radiobutton_check_updates_everyweek.setName("week_once"); // NOI18N
        getContentPane().add(radiobutton_check_updates_everyweek, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 200, -1, -1));

        buttonGroup1.add(radiobutton_check_updates_off);
        radiobutton_check_updates_off.setText("Off");
        radiobutton_check_updates_off.setName("off"); // NOI18N
        getContentPane().add(radiobutton_check_updates_off, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 220, -1, -1));

        label_queue_id1.setText("Email : ");
        getContentPane().add(label_queue_id1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 70, -1));

        checkbox_remember_me.setText("Enable");
        getContentPane().add(checkbox_remember_me, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 250, -1, 30));

        label_queue_id2.setText("Check Future Updates :");
        getContentPane().add(label_queue_id2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 130, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    int postItem = 0;

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed

        if (parent != null) {
            parent.setEnabled(true);
            parent.toFront();
        }

    }//GEN-LAST:event_formWindowClosed

    private void button_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_saveActionPerformed

        localData.setUsername(UIForm.getText(textfield_username));
        localData.setPass(UIForm.getTextPass(textfield_pass));
        localData.setEmail(UIForm.getText(textfield_email));
        localData.setCheck_updates(UIForm.getSelectedRadioButton(radiobutton_check_updates_everystarts, radiobutton_check_updates_everyweek, radiobutton_check_updates_off));
        localData.setRemember_me(Integer.parseInt(UIForm.getCheckedValue(checkbox_remember_me, UIForm.AS_NUMERIC)));

        db.update_UserSettings(localData);

        this.dispose();

    }//GEN-LAST:event_button_saveActionPerformed

    private void checkboxShowPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkboxShowPassActionPerformed


    }//GEN-LAST:event_checkboxShowPassActionPerformed

    private void checkboxShowPassItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_checkboxShowPassItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            textfield_pass.setEchoChar((char) 0);
        } else {
            textfield_pass.setEchoChar('*');
        }
    }//GEN-LAST:event_checkboxShowPassItemStateChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UserSettingsForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserSettingsForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserSettingsForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserSettingsForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserSettingsForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton button_save;
    private javax.swing.JCheckBox checkboxShowPass;
    private javax.swing.JCheckBox checkbox_remember_me;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel label_queue_id;
    private javax.swing.JLabel label_queue_id1;
    private javax.swing.JLabel label_queue_id2;
    private javax.swing.JRadioButton radiobutton_check_updates_everystarts;
    private javax.swing.JRadioButton radiobutton_check_updates_everyweek;
    private javax.swing.JRadioButton radiobutton_check_updates_off;
    private javax.swing.JTextField textfield_email;
    private javax.swing.JPasswordField textfield_pass;
    private javax.swing.JTextField textfield_username;
    // End of variables declaration//GEN-END:variables
}
