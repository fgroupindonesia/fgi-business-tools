package frames;

import config.SystemApp;
import config.SystemPath;
import helper.DBTransactions;
import helper.PopupMessage;
import helper.UIForm;
import helper.objects.UserSettings;

/**
 *
 * @author asus
 */
public class LoginFrame extends WindowsSkeleton {

    /**
     * Creates new form LoginFrame
     */
    public LoginFrame() {
        super.windowsTheme();
        initComponents();
        this.setTitle(SystemApp.APP_NAME);
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        textfield_username = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        textfield_pass = new javax.swing.JPasswordField();
        jPanel3 = new javax.swing.JPanel();
        label_forgot_pass = new javax.swing.JLabel();
        buttonLogin = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(600, 400));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 153, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(300, 356));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/frames/images/yellow-unlock-icon.png"))); // NOI18N
        jLabel1.setText("Login Cridentials");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel1.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(27, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(43, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 356, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(68, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(65, Short.MAX_VALUE)))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.WEST);

        jPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 15, 10, 15));
        jPanel2.setLayout(new java.awt.GridLayout(7, 1, 0, 5));

        jLabel2.setText("Username : ");
        jPanel2.add(jLabel2);

        textfield_username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textfield_usernameActionPerformed(evt);
            }
        });
        jPanel2.add(textfield_username);

        jLabel3.setText("Password : ");
        jPanel2.add(jLabel3);

        textfield_pass.setText("jPasswordField1");
        textfield_pass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textfield_passActionPerformed(evt);
            }
        });
        jPanel2.add(textfield_pass);

        jPanel3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        label_forgot_pass.setForeground(new java.awt.Color(0, 0, 204));
        label_forgot_pass.setText("<html><u>Forgot Password</u></html>");
        label_forgot_pass.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        label_forgot_pass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_forgot_passMouseClicked(evt);
            }
        });
        jPanel3.add(label_forgot_pass);

        buttonLogin.setText("Login");
        buttonLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLoginActionPerformed(evt);
            }
        });
        jPanel3.add(buttonLogin);

        jPanel2.add(jPanel3);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    UserSettings localUser;

    private void buttonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLoginActionPerformed

        tryLogging();


    }//GEN-LAST:event_buttonLoginActionPerformed

    private void tryLogging(){
        localUser = db.select_specific_UserSettings(1);

        if (localUser.getPass().equalsIgnoreCase(UIForm.getTextPass(textfield_pass)) && localUser.getUsername().equalsIgnoreCase(UIForm.getText(textfield_username))) {
            DashboardFrame dsh = new DashboardFrame(this);
            dsh.setVisible(true);

            this.setVisible(false);

        }else {
            PopupMessage.showError("Invalid login cridential!");
        }
    }
    
    private void textfield_usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textfield_usernameActionPerformed
       textfield_pass.requestFocus();
       textfield_pass.selectAll();
    }//GEN-LAST:event_textfield_usernameActionPerformed

    private void textfield_passActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textfield_passActionPerformed
        tryLogging();
    }//GEN-LAST:event_textfield_passActionPerformed

    private void label_forgot_passMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_forgot_passMouseClicked

        QRFrame window  = new QRFrame(this);
        window.setVisible(true);
        
        this.setVisible(false);
        
    }//GEN-LAST:event_label_forgot_passMouseClicked

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel label_forgot_pass;
    private javax.swing.JPasswordField textfield_pass;
    private javax.swing.JTextField textfield_username;
    // End of variables declaration//GEN-END:variables
}
