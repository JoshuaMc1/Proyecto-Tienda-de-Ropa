package Modulos;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import sun.applet.Main;

public class Menu extends javax.swing.JFrame{

    private String opc []={"Si", "No"};//
    private int state = 0;
    
    public Menu() {
        initComponents();
        setLocationRelativeTo(null);
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
        btnExit = new javax.swing.JButton();
        btnChange = new javax.swing.JButton();
        btnInicio = new javax.swing.JButton();
        PPrincipal = new javax.swing.JPanel();
        pnlInicio = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        pnlUser = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        pnlRepo = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        pnlVentas = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        pnlInv = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        pnlCompras = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1200, 700));
        setSize(new java.awt.Dimension(1200, 660));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(143, 6, 22));
        jPanel1.setName("PP"); // NOI18N
        jPanel1.setPreferredSize(new java.awt.Dimension(1200, 700));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Contenedor.setBackground(new java.awt.Color(75, 69, 255));
        Contenedor.setPreferredSize(new java.awt.Dimension(240, 660));
        Contenedor.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblRol.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        lblRol.setForeground(new java.awt.Color(255, 255, 255));
        lblRol.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblRol.setText("Administrador");
        lblRol.setToolTipText("Rol del Usuario");
        lblRol.setFocusable(false);
        lblRol.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Contenedor.add(lblRol, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 620, 160, -1));

        jPanel4.setBackground(new java.awt.Color(29, 110, 186));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblUserImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/man.png"))); // NOI18N
        lblUserImg.setToolTipText("Usuario");
        jPanel4.add(lblUserImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, 110, 110));

        lblUser.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        lblUser.setForeground(new java.awt.Color(255, 255, 255));
        lblUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUser.setText("Juanito Alcahofas");
        lblUser.setToolTipText("Usuario");
        jPanel4.add(lblUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 240, -1));

        Contenedor.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 169));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("V0.1");
        jLabel1.setToolTipText("Version del sistema");
        Contenedor.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 620, -1, -1));

        btnBuy.setBackground(new java.awt.Color(255, 255, 255));
        btnBuy.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        btnBuy.setForeground(new java.awt.Color(75, 69, 255));
        btnBuy.setText("Compras");
        btnBuy.setToolTipText("modulo para registrar compras de producto");
        btnBuy.setBorder(null);
        btnBuy.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnBuyMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBuyMouseExited(evt);
            }
        });
        btnBuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuyActionPerformed(evt);
            }
        });
        Contenedor.add(btnBuy, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 220, 50));

        btnUser.setBackground(new java.awt.Color(255, 255, 255));
        btnUser.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        btnUser.setForeground(new java.awt.Color(75, 69, 255));
        btnUser.setText("Usuarios");
        btnUser.setToolTipText("Modulo para gestionar los  Usuarios");
        btnUser.setBorder(null);
        btnUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnUserMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnUserMouseExited(evt);
            }
        });
        btnUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUserActionPerformed(evt);
            }
        });
        Contenedor.add(btnUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 220, 50));

        btnRepo.setBackground(new java.awt.Color(255, 255, 255));
        btnRepo.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        btnRepo.setForeground(new java.awt.Color(75, 69, 255));
        btnRepo.setText("Reportes");
        btnRepo.setToolTipText("modulo para generar reportes");
        btnRepo.setBorder(null);
        btnRepo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnRepoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnRepoMouseExited(evt);
            }
        });
        btnRepo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRepoActionPerformed(evt);
            }
        });
        Contenedor.add(btnRepo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, 220, 50));

        btnSale.setBackground(new java.awt.Color(255, 255, 255));
        btnSale.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        btnSale.setForeground(new java.awt.Color(75, 69, 255));
        btnSale.setText("Ventas");
        btnSale.setToolTipText("Modulo para realizar ventas");
        btnSale.setBorder(null);
        btnSale.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSaleMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSaleMouseExited(evt);
            }
        });
        btnSale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaleActionPerformed(evt);
            }
        });
        Contenedor.add(btnSale, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 220, 50));

        btnInv.setBackground(new java.awt.Color(255, 255, 255));
        btnInv.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        btnInv.setForeground(new java.awt.Color(75, 69, 255));
        btnInv.setText("Inventario");
        btnInv.setToolTipText("modulo para gestionar el inventario");
        btnInv.setBorder(null);
        btnInv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnInvMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnInvMouseExited(evt);
            }
        });
        btnInv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInvActionPerformed(evt);
            }
        });
        Contenedor.add(btnInv, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 220, 50));

        btnExit.setBackground(new java.awt.Color(255, 255, 255));
        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/exit.png"))); // NOI18N
        btnExit.setToolTipText("Salir");
        btnExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnExitMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnExitMouseExited(evt);
            }
        });
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        Contenedor.add(btnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 520, 64, 64));

        btnChange.setBackground(new java.awt.Color(255, 255, 255));
        btnChange.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/cambio.png"))); // NOI18N
        btnChange.setToolTipText("Cambiar Usuario");
        btnChange.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnChangeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnChangeMouseExited(evt);
            }
        });
        Contenedor.add(btnChange, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 520, 64, 64));

        btnInicio.setBackground(new java.awt.Color(255, 255, 255));
        btnInicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/inicio.png"))); // NOI18N
        btnInicio.setToolTipText("Ir a pantalla de inicio");
        btnInicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnInicioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnInicioMouseExited(evt);
            }
        });
        btnInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInicioActionPerformed(evt);
            }
        });
        Contenedor.add(btnInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 520, 64, 64));

        jPanel1.add(Contenedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 240, 640));

        PPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        PPrincipal.setName(""); // NOI18N
        PPrincipal.setPreferredSize(new java.awt.Dimension(900, 660));
        PPrincipal.setLayout(new java.awt.CardLayout());

        jLabel7.setText("Inicio");

        javax.swing.GroupLayout pnlInicioLayout = new javax.swing.GroupLayout(pnlInicio);
        pnlInicio.setLayout(pnlInicioLayout);
        pnlInicioLayout.setHorizontalGroup(
            pnlInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInicioLayout.createSequentialGroup()
                .addGap(380, 380, 380)
                .addComponent(jLabel7)
                .addContainerGap(520, Short.MAX_VALUE))
        );
        pnlInicioLayout.setVerticalGroup(
            pnlInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInicioLayout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addComponent(jLabel7)
                .addContainerGap(426, Short.MAX_VALUE))
        );

        PPrincipal.add(pnlInicio, "crdInicio");

        jLabel2.setText("Usuarios");

        javax.swing.GroupLayout pnlUserLayout = new javax.swing.GroupLayout(pnlUser);
        pnlUser.setLayout(pnlUserLayout);
        pnlUserLayout.setHorizontalGroup(
            pnlUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlUserLayout.createSequentialGroup()
                .addGap(374, 374, 374)
                .addComponent(jLabel2)
                .addContainerGap(510, Short.MAX_VALUE))
        );
        pnlUserLayout.setVerticalGroup(
            pnlUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlUserLayout.createSequentialGroup()
                .addGap(134, 134, 134)
                .addComponent(jLabel2)
                .addContainerGap(492, Short.MAX_VALUE))
        );

        PPrincipal.add(pnlUser, "crdUser");

        jLabel3.setText("report");

        javax.swing.GroupLayout pnlRepoLayout = new javax.swing.GroupLayout(pnlRepo);
        pnlRepo.setLayout(pnlRepoLayout);
        pnlRepoLayout.setHorizontalGroup(
            pnlRepoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRepoLayout.createSequentialGroup()
                .addGap(488, 488, 488)
                .addComponent(jLabel3)
                .addContainerGap(407, Short.MAX_VALUE))
        );
        pnlRepoLayout.setVerticalGroup(
            pnlRepoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRepoLayout.createSequentialGroup()
                .addGap(232, 232, 232)
                .addComponent(jLabel3)
                .addContainerGap(394, Short.MAX_VALUE))
        );

        PPrincipal.add(pnlRepo, "crdRepo");

        jLabel4.setText("sales");

        javax.swing.GroupLayout pnlVentasLayout = new javax.swing.GroupLayout(pnlVentas);
        pnlVentas.setLayout(pnlVentasLayout);
        pnlVentasLayout.setHorizontalGroup(
            pnlVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlVentasLayout.createSequentialGroup()
                .addContainerGap(546, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(355, 355, 355))
        );
        pnlVentasLayout.setVerticalGroup(
            pnlVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlVentasLayout.createSequentialGroup()
                .addGap(247, 247, 247)
                .addComponent(jLabel4)
                .addContainerGap(379, Short.MAX_VALUE))
        );

        PPrincipal.add(pnlVentas, "crdVentas");

        pnlInv.setPreferredSize(new java.awt.Dimension(1020, 600));

        jLabel5.setText("inv");

        javax.swing.GroupLayout pnlInvLayout = new javax.swing.GroupLayout(pnlInv);
        pnlInv.setLayout(pnlInvLayout);
        pnlInvLayout.setHorizontalGroup(
            pnlInvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlInvLayout.createSequentialGroup()
                .addContainerGap(521, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(390, 390, 390))
        );
        pnlInvLayout.setVerticalGroup(
            pnlInvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInvLayout.createSequentialGroup()
                .addGap(231, 231, 231)
                .addComponent(jLabel5)
                .addContainerGap(395, Short.MAX_VALUE))
        );

        PPrincipal.add(pnlInv, "crdInv");

        jLabel6.setText("buy");

        javax.swing.GroupLayout pnlComprasLayout = new javax.swing.GroupLayout(pnlCompras);
        pnlCompras.setLayout(pnlComprasLayout);
        pnlComprasLayout.setHorizontalGroup(
            pnlComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlComprasLayout.createSequentialGroup()
                .addGap(432, 432, 432)
                .addComponent(jLabel6)
                .addContainerGap(475, Short.MAX_VALUE))
        );
        pnlComprasLayout.setVerticalGroup(
            pnlComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlComprasLayout.createSequentialGroup()
                .addGap(270, 270, 270)
                .addComponent(jLabel6)
                .addContainerGap(356, Short.MAX_VALUE))
        );

        PPrincipal.add(pnlCompras, "crdComp");

        jPanel1.add(PPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, 925, 640));
        PPrincipal.getAccessibleContext().setAccessibleName("");
        PPrincipal.getAccessibleContext().setAccessibleDescription("");

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1190, 660));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Hover(JButton btn, int r1, int g1, int b1, int r2, int g2, int b2){
        btn.setBackground(new Color(r1, g1, b1));
        btn.setForeground(new Color(r2, g2, b2));
    }
    
    private void newCard(String _card){
        CardLayout card = (CardLayout)PPrincipal.getLayout();
        card.show(PPrincipal, _card);
    }
    
    private void btnUserMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUserMouseEntered
        Hover(btnUser, 75, 112, 243, 255, 255, 255);
    }//GEN-LAST:event_btnUserMouseEntered

    private void btnUserMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUserMouseExited
        Hover(btnUser, 255, 255, 255, 75, 69, 255);
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

    private void btnUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUserActionPerformed
        newCard("crdUser");
    }//GEN-LAST:event_btnUserActionPerformed

    private void btnSaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaleActionPerformed
        newCard("crdVentas");
    }//GEN-LAST:event_btnSaleActionPerformed

    private void btnBuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuyActionPerformed
        newCard("crdComp");
    }//GEN-LAST:event_btnBuyActionPerformed

    private void btnInvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInvActionPerformed
        newCard("crdInv");
    }//GEN-LAST:event_btnInvActionPerformed

    private void btnRepoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRepoActionPerformed
        newCard("crdRepo");
    }//GEN-LAST:event_btnRepoActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        int dec = JOptionPane.showOptionDialog(null,"Desea cerrar la aplicacion","Opciones",JOptionPane.YES_OPTION,JOptionPane.WARNING_MESSAGE,null,opc,opc[0]);
        if(dec == 0){
            state = 1;
            System.exit(0);
        }
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnExitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseEntered
        Hover(btnExit, 75, 112, 243, 255, 255, 255);
    }//GEN-LAST:event_btnExitMouseEntered

    private void btnExitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseExited
        Hover(btnExit, 255, 255, 255, 75, 69, 255);
    }//GEN-LAST:event_btnExitMouseExited

    private void btnChangeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnChangeMouseEntered
        Hover(btnChange, 75, 112, 243, 255, 255, 255);
    }//GEN-LAST:event_btnChangeMouseEntered

    private void btnChangeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnChangeMouseExited
        Hover(btnChange, 255, 255, 255, 75, 69, 255);
    }//GEN-LAST:event_btnChangeMouseExited

    private void btnInicioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInicioMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnInicioMouseEntered

    private void btnInicioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInicioMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnInicioMouseExited

    private void btnInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInicioActionPerformed
        newCard("crdInicio");
    }//GEN-LAST:event_btnInicioActionPerformed

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
    private javax.swing.JButton btnChange;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnInicio;
    private javax.swing.JButton btnInv;
    private javax.swing.JButton btnRepo;
    private javax.swing.JButton btnSale;
    private javax.swing.JButton btnUser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lblRol;
    private javax.swing.JLabel lblUser;
    private javax.swing.JLabel lblUserImg;
    private javax.swing.JPanel pnlCompras;
    private javax.swing.JPanel pnlInicio;
    private javax.swing.JPanel pnlInv;
    private javax.swing.JPanel pnlRepo;
    private javax.swing.JPanel pnlUser;
    private javax.swing.JPanel pnlVentas;
    // End of variables declaration//GEN-END:variables
}
