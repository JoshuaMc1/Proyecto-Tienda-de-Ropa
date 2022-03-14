package Modulos;

import java.awt.Color;
import javax.swing.JButton;

public class Menu extends javax.swing.JFrame {

    public Menu() {
        initComponents();
        setLocationRelativeTo(null);
        //lblRol.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Contenedor = new javax.swing.JPanel();
        lblRol = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        lblUserImg = new javax.swing.JLabel();
        lblUser = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnBuy = new javax.swing.JButton();
        btnUser = new javax.swing.JButton();
        btnRepo = new javax.swing.JButton();
        btnSale = new javax.swing.JButton();
        btnInv = new javax.swing.JButton();
        PPrincipal = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1300, 720));

        jPanel1.setBackground(new java.awt.Color(143, 6, 22));
        jPanel1.setName("PP"); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Contenedor.setBackground(new java.awt.Color(75, 69, 255));
        Contenedor.setPreferredSize(new java.awt.Dimension(240, 660));
        Contenedor.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblRol.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        lblRol.setForeground(new java.awt.Color(255, 255, 255));
        lblRol.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblRol.setText("Administrador");
        lblRol.setFocusable(false);
        lblRol.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Contenedor.add(lblRol, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 630, 160, -1));

        jPanel4.setBackground(new java.awt.Color(29, 110, 186));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblUserImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/man.png"))); // NOI18N
        jPanel4.add(lblUserImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, 110, 110));

        lblUser.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        lblUser.setForeground(new java.awt.Color(255, 255, 255));
        lblUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUser.setText("Juanito Alcahofas");
        jPanel4.add(lblUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 240, -1));

        Contenedor.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 169));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("V0.1");
        Contenedor.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 630, -1, -1));

        btnBuy.setBackground(new java.awt.Color(255, 255, 255));
        btnBuy.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        btnBuy.setForeground(new java.awt.Color(75, 69, 255));
        btnBuy.setText("Compras");
        btnBuy.setBorder(null);
        btnBuy.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnBuyMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBuyMouseExited(evt);
            }
        });
        Contenedor.add(btnBuy, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 220, 50));

        btnUser.setBackground(new java.awt.Color(255, 255, 255));
        btnUser.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        btnUser.setForeground(new java.awt.Color(75, 69, 255));
        btnUser.setText("Usuarios");
        btnUser.setBorder(null);
        btnUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnUserMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnUserMouseExited(evt);
            }
        });
        Contenedor.add(btnUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 220, 50));

        btnRepo.setBackground(new java.awt.Color(255, 255, 255));
        btnRepo.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        btnRepo.setForeground(new java.awt.Color(75, 69, 255));
        btnRepo.setText("Reportes");
        btnRepo.setBorder(null);
        btnRepo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnRepoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnRepoMouseExited(evt);
            }
        });
        Contenedor.add(btnRepo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, 220, 50));

        btnSale.setBackground(new java.awt.Color(255, 255, 255));
        btnSale.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        btnSale.setForeground(new java.awt.Color(75, 69, 255));
        btnSale.setText("Ventas");
        btnSale.setBorder(null);
        btnSale.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSaleMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSaleMouseExited(evt);
            }
        });
        Contenedor.add(btnSale, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 220, 50));

        btnInv.setBackground(new java.awt.Color(255, 255, 255));
        btnInv.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        btnInv.setForeground(new java.awt.Color(75, 69, 255));
        btnInv.setText("Inventario");
        btnInv.setBorder(null);
        btnInv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnInvMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnInvMouseExited(evt);
            }
        });
        Contenedor.add(btnInv, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 220, 50));

        jPanel1.add(Contenedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 240, -1));

        PPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        PPrincipal.setName(""); // NOI18N
        PPrincipal.setLayout(new java.awt.CardLayout());
        jPanel1.add(PPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, 1020, 660));
        PPrincipal.getAccessibleContext().setAccessibleName("");
        PPrincipal.getAccessibleContext().setAccessibleDescription("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Hover(JButton btn, int r1, int g1, int b1, int r2, int g2, int b2){
        btn.setBackground(new Color(r1, g1, b1));
        btn.setForeground(new Color(r2, g2, b2));
    }
    
    private void btnUserMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUserMouseEntered
        Hover(btnUser, 75, 112, 243, 255, 255, 255);
        /*btnUser.setBackground(new Color(75,112,243));
        btnUser.setForeground(Color.white);*/
    }//GEN-LAST:event_btnUserMouseEntered

    private void btnUserMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUserMouseExited
        Hover(btnUser, 255, 255, 255, 75, 69, 255);
        /*btnUser.setBackground(Color.white);
        btnUser.setForeground(new Color(75,69,255));*/
    }//GEN-LAST:event_btnUserMouseExited

    private void btnSaleMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaleMouseEntered
        Hover(btnSale, 75, 112, 243, 255, 255, 255);
    }//GEN-LAST:event_btnSaleMouseEntered

    private void btnSaleMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaleMouseExited
        Hover(btnSale, 255, 255, 255, 75, 69, 255);
    }//GEN-LAST:event_btnSaleMouseExited

    private void btnBuyMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuyMouseEntered
        Hover(btnBuy, 75, 112, 243, 255, 255, 255);
    }//GEN-LAST:event_btnBuyMouseEntered

    private void btnBuyMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuyMouseExited
        Hover(btnBuy, 255, 255, 255, 75, 69, 255);
    }//GEN-LAST:event_btnBuyMouseExited

    private void btnInvMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInvMouseEntered
        Hover(btnInv, 75, 112, 243, 255, 255, 255);
    }//GEN-LAST:event_btnInvMouseEntered

    private void btnInvMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInvMouseExited
        Hover(btnInv, 255, 255, 255, 75, 69, 255);
    }//GEN-LAST:event_btnInvMouseExited

    private void btnRepoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRepoMouseEntered
        Hover(btnRepo, 75, 112, 243, 255, 255, 255);
    }//GEN-LAST:event_btnRepoMouseEntered

    private void btnRepoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRepoMouseExited
        Hover(btnRepo, 255, 255, 255, 75, 69, 255);
    }//GEN-LAST:event_btnRepoMouseExited

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Contenedor;
    private javax.swing.JPanel PPrincipal;
    private javax.swing.JButton btnBuy;
    private javax.swing.JButton btnInv;
    private javax.swing.JButton btnRepo;
    private javax.swing.JButton btnSale;
    private javax.swing.JButton btnUser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lblRol;
    private javax.swing.JLabel lblUser;
    private javax.swing.JLabel lblUserImg;
    // End of variables declaration//GEN-END:variables
}
