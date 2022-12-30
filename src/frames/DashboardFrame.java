/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frames;

/**
 *
 * @author asus
 */
public class DashboardFrame extends javax.swing.JFrame {

    /**
     * Creates new form DashboardFrame
     */
    public DashboardFrame() {
        initComponents();
    }

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
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        panelCenter = new javax.swing.JPanel();
        panelMenu = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        panelQuestions = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        labelHomeFromQuestions = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        textfieldTitleQuestions = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textareaDescriptionQuestions = new javax.swing.JTextArea();
        buttonSendQuestions = new javax.swing.JButton();
        panelBookAppMaker = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        labelHomeFromBookAppMaker = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        panelFormBuilder = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        panelUpdateManager = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        panelLicenseManager = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        panelDownloadLinkRender = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1200, 700));
        setResizable(false);
        setType(java.awt.Window.Type.POPUP);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("FGI Business Tools");
        jLabel1.setPreferredSize(new java.awt.Dimension(343, 100));
        jPanel1.add(jLabel1);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel4.setPreferredSize(new java.awt.Dimension(100, 100));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 401, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel4, java.awt.BorderLayout.EAST);

        jPanel5.setPreferredSize(new java.awt.Dimension(100, 100));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 401, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel5, java.awt.BorderLayout.WEST);

        panelCenter.setLayout(new java.awt.CardLayout());

        panelMenu.setPreferredSize(new java.awt.Dimension(100, 100));
        panelMenu.setLayout(new java.awt.GridLayout(2, 3, 25, 25));

        jButton1.setFont(new java.awt.Font("Tahoma", 2, 24)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/frames/images/blue-tag-icon.png"))); // NOI18N
        jButton1.setText("Update Manager");
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        panelMenu.add(jButton1);

        jButton2.setFont(new java.awt.Font("Tahoma", 2, 24)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/frames/images/blue-laptop-icon.png"))); // NOI18N
        jButton2.setText("License Manager");
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        panelMenu.add(jButton2);

        jButton3.setFont(new java.awt.Font("Tahoma", 2, 24)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/frames/images/blue-document-download-icon.png"))); // NOI18N
        jButton3.setText("Download Link Renderer");
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        panelMenu.add(jButton3);

        jButton4.setFont(new java.awt.Font("Tahoma", 2, 24)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/frames/images/blue-archive-icon.png"))); // NOI18N
        jButton4.setText("Form Builder");
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        panelMenu.add(jButton4);

        jButton5.setFont(new java.awt.Font("Tahoma", 2, 24)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/frames/images/blue-address-book-icon.png"))); // NOI18N
        jButton5.setText("Book App Maker");
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        panelMenu.add(jButton5);

        jButton6.setFont(new java.awt.Font("Tahoma", 2, 24)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/frames/images/blue-mail-send-icon.png"))); // NOI18N
        jButton6.setText("Questions?");
        jButton6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton6.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        panelMenu.add(jButton6);

        panelCenter.add(panelMenu, "card2");

        panelQuestions.setLayout(new java.awt.BorderLayout());

        jPanel7.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        labelHomeFromQuestions.setIcon(new javax.swing.ImageIcon(getClass().getResource("/frames/images/red-home-icon.png"))); // NOI18N
        jPanel7.add(labelHomeFromQuestions);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("> Questions");
        jPanel7.add(jLabel2);

        panelQuestions.add(jPanel7, java.awt.BorderLayout.PAGE_START);

        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("Title : ");
        jPanel6.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1185, 40));

        textfieldTitleQuestions.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        textfieldTitleQuestions.setText("  isi disini");
        textfieldTitleQuestions.setPreferredSize(new java.awt.Dimension(200, 50));
        jPanel6.add(textfieldTitleQuestions, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 650, 40));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("Description :");
        jPanel6.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 1185, 40));

        jScrollPane1.setPreferredSize(new java.awt.Dimension(123, 100));

        textareaDescriptionQuestions.setColumns(20);
        textareaDescriptionQuestions.setRows(10);
        jScrollPane1.setViewportView(textareaDescriptionQuestions);

        jPanel6.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 151, 940, 150));

        buttonSendQuestions.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        buttonSendQuestions.setText("Send");
        jPanel6.add(buttonSendQuestions, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 310, 180, 30));

        panelQuestions.add(jPanel6, java.awt.BorderLayout.CENTER);

        panelCenter.add(panelQuestions, "card3");

        panelBookAppMaker.setLayout(new java.awt.BorderLayout());

        jPanel8.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        labelHomeFromBookAppMaker.setIcon(new javax.swing.ImageIcon(getClass().getResource("/frames/images/red-home-icon.png"))); // NOI18N
        jPanel8.add(labelHomeFromBookAppMaker);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setText("> Book App Maker");
        jPanel8.add(jLabel10);

        panelBookAppMaker.add(jPanel8, java.awt.BorderLayout.PAGE_START);

        jPanel9.setLayout(new java.awt.BorderLayout());
        panelBookAppMaker.add(jPanel9, java.awt.BorderLayout.CENTER);

        panelCenter.add(panelBookAppMaker, "card4");

        panelFormBuilder.setLayout(new java.awt.BorderLayout());

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("> Form Builder");
        panelFormBuilder.add(jLabel4, java.awt.BorderLayout.PAGE_START);

        panelCenter.add(panelFormBuilder, "card5");

        panelUpdateManager.setLayout(new java.awt.BorderLayout());

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("> Update Manager");
        panelUpdateManager.add(jLabel5, java.awt.BorderLayout.PAGE_START);

        panelCenter.add(panelUpdateManager, "card6");

        panelLicenseManager.setLayout(new java.awt.BorderLayout());

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("> License Manager");
        panelLicenseManager.add(jLabel6, java.awt.BorderLayout.PAGE_START);

        panelCenter.add(panelLicenseManager, "card7");

        panelDownloadLinkRender.setLayout(new java.awt.BorderLayout());

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("> Download Link Renderer");
        panelDownloadLinkRender.add(jLabel7, java.awt.BorderLayout.PAGE_START);

        panelCenter.add(panelDownloadLinkRender, "card8");

        jPanel2.add(panelCenter, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        jPanel3.setPreferredSize(new java.awt.Dimension(1385, 60));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1253, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel3, java.awt.BorderLayout.PAGE_END);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(DashboardFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DashboardFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DashboardFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DashboardFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DashboardFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonSendQuestions;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelHomeFromBookAppMaker;
    private javax.swing.JLabel labelHomeFromQuestions;
    private javax.swing.JPanel panelBookAppMaker;
    private javax.swing.JPanel panelCenter;
    private javax.swing.JPanel panelDownloadLinkRender;
    private javax.swing.JPanel panelFormBuilder;
    private javax.swing.JPanel panelLicenseManager;
    private javax.swing.JPanel panelMenu;
    private javax.swing.JPanel panelQuestions;
    private javax.swing.JPanel panelUpdateManager;
    private javax.swing.JTextArea textareaDescriptionQuestions;
    private javax.swing.JTextField textfieldTitleQuestions;
    // End of variables declaration//GEN-END:variables
}