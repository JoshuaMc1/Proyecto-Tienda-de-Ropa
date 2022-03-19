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
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        lblHora = new javax.swing.JLabel();
        Contenedor = new javax.swing.JPanel();
        lblRol = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        lblUserImg = new javax.swing.JLabel();
        lblUserName = new javax.swing.JLabel();
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
        jPanel7 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        lblFotou = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        lnlNameu = new javax.swing.JTextField();
        lnlApellidou = new javax.swing.JTextField();
        lblDiru = new javax.swing.JTextField();
        lblEmailu = new javax.swing.JTextField();
        lblCargou = new javax.swing.JTextField();
        lblDniu = new javax.swing.JFormattedTextField();
        lblTelu = new javax.swing.JFormattedTextField();
        btnFotou = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        lblUser = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        lblUName = new javax.swing.JTextField();
        lblPassu = new javax.swing.JPasswordField();
        cbPrivu = new javax.swing.JComboBox<>();
        jPanel9 = new javax.swing.JPanel();
        btnSaveu = new javax.swing.JButton();
        btnModu = new javax.swing.JButton();
        btnDelu = new javax.swing.JButton();
        btnCleanu = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblUser = new javax.swing.JTable();
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

        jPanel2.setBackground(new java.awt.Color(29, 110, 186));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Hora:");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(722, 0, -1, 20));

        lblHora.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        lblHora.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(lblHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 0, 120, 20));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, 925, 20));

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

        lblUserName.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        lblUserName.setForeground(new java.awt.Color(255, 255, 255));
        lblUserName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUserName.setText("Juanito Alcahofas");
        lblUserName.setToolTipText("Usuario");
        jPanel4.add(lblUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 240, -1));

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

        pnlInicio.setBackground(new java.awt.Color(255, 255, 255));

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
                .addGap(232, 232, 232)
                .addComponent(jLabel7)
                .addContainerGap(374, Short.MAX_VALUE))
        );

        PPrincipal.add(pnlInicio, "crdInicio");

        pnlUser.setBackground(new java.awt.Color(255, 255, 255));
        pnlUser.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(75, 69, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Gestion de Usuarios");
        pnlUser.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 10, 930, -1));

        jPanel7.setBackground(new java.awt.Color(75, 69, 255));

        jLabel12.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("DATOS PERSONALES");

        lblFotou.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));

        jLabel13.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("DNI:");

        jLabel14.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("NOMBRE:");

        jLabel15.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("APELLIDO:");

        jLabel16.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("TELEFONO:");

        jLabel17.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("DIRECCION:");

        jLabel18.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("CORREO:");

        jLabel19.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("CARGO:");

        lblCargou.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblCargouActionPerformed(evt);
            }
        });

        try {
            lblDniu.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-####-#####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            lblTelu.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        btnFotou.setBackground(new java.awt.Color(255, 255, 255));
        btnFotou.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        btnFotou.setForeground(new java.awt.Color(75, 69, 255));
        btnFotou.setText("ABRIR FOTO");
        btnFotou.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnFotouMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnFotouMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 531, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(lblFotou, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addComponent(jLabel13))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel14))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(jLabel15))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jLabel16))
                            .addComponent(jLabel17)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(jLabel18)))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDniu, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lnlNameu, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lnlApellidou, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTelu, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDiru, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblEmailu, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(btnFotou, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel19)
                        .addGap(18, 18, 18)
                        .addComponent(lblCargou, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFotou, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel13)
                        .addGap(22, 22, 22)
                        .addComponent(jLabel14)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel15)
                        .addGap(22, 22, 22)
                        .addComponent(jLabel16)
                        .addGap(22, 22, 22)
                        .addComponent(jLabel17)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel18))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(lblDniu, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(lnlNameu, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(lnlApellidou, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(lblTelu, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(lblDiru, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(lblEmailu, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCargou, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnFotou, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pnlUser.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, 320));

        jPanel8.setBackground(new java.awt.Color(75, 69, 255));

        jLabel20.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("DATOS DE USUARIO");

        lblUser.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        lblUser.setForeground(new java.awt.Color(255, 255, 255));
        lblUser.setText("USUARIO:");

        jLabel22.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("CONTRASEÑA:");

        jLabel23.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("PRIVILEGIOS:");

        cbPrivu.setForeground(new java.awt.Color(75, 69, 255));
        cbPrivu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una opción", "Facturacion", "Inventario" }));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel23)
                    .addComponent(jLabel22)
                    .addComponent(lblUser))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblUName)
                    .addComponent(lblPassu)
                    .addComponent(cbPrivu, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(lblUser))
                    .addComponent(lblUName, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel22)
                    .addComponent(lblPassu, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel23)
                    .addComponent(cbPrivu, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pnlUser.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 50, 370, -1));

        jPanel9.setBackground(new java.awt.Color(75, 69, 255));

        btnSaveu.setBackground(new java.awt.Color(255, 255, 255));
        btnSaveu.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        btnSaveu.setForeground(new java.awt.Color(75, 69, 255));
        btnSaveu.setText("GUARDAR");
        btnSaveu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSaveuMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSaveuMouseExited(evt);
            }
        });
        btnSaveu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveuActionPerformed(evt);
            }
        });

        btnModu.setBackground(new java.awt.Color(255, 255, 255));
        btnModu.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        btnModu.setForeground(new java.awt.Color(75, 69, 255));
        btnModu.setText("MODIFICAR");
        btnModu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnModuMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnModuMouseExited(evt);
            }
        });

        btnDelu.setBackground(new java.awt.Color(255, 255, 255));
        btnDelu.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        btnDelu.setForeground(new java.awt.Color(75, 69, 255));
        btnDelu.setText("ELIMINAR");
        btnDelu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnDeluMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnDeluMouseExited(evt);
            }
        });

        btnCleanu.setBackground(new java.awt.Color(255, 255, 255));
        btnCleanu.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        btnCleanu.setForeground(new java.awt.Color(75, 69, 255));
        btnCleanu.setText("LIMPIAR");
        btnCleanu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCleanuMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCleanuMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSaveu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnModu, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCleanu, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelu, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDelu, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSaveu, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCleanu, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModu, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );

        pnlUser.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 240, 370, 128));

        jPanel10.setBackground(new java.awt.Color(75, 69, 255));

        tblUser.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        tblUser.setForeground(new java.awt.Color(0, 176, 80));
        tblUser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "USUARIO", "CORREO", "PRIVILEGIOS"
            }
        ));
        jScrollPane3.setViewportView(tblUser);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlUser.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 910, -1));

        PPrincipal.add(pnlUser, "crdUser");

        pnlRepo.setBackground(new java.awt.Color(255, 255, 255));

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
                .addContainerGap(374, Short.MAX_VALUE))
        );

        PPrincipal.add(pnlRepo, "crdRepo");

        pnlVentas.setBackground(new java.awt.Color(255, 255, 255));

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
                .addContainerGap(359, Short.MAX_VALUE))
        );

        PPrincipal.add(pnlVentas, "crdVentas");

        pnlInv.setBackground(new java.awt.Color(255, 255, 255));
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
                .addContainerGap(375, Short.MAX_VALUE))
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
                .addContainerGap(336, Short.MAX_VALUE))
        );

        PPrincipal.add(pnlCompras, "crdComp");

        jPanel1.add(PPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 30, 925, 620));
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
        Hover(btnInicio, 75, 112, 243, 255, 255, 255);
    }//GEN-LAST:event_btnInicioMouseEntered

    private void btnInicioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInicioMouseExited
        Hover(btnInicio, 255, 255, 255, 75, 69, 255);
    }//GEN-LAST:event_btnInicioMouseExited

    private void btnInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInicioActionPerformed
        newCard("crdInicio");
    }//GEN-LAST:event_btnInicioActionPerformed

    private void btnSaveuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSaveuActionPerformed

    private void lblCargouActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblCargouActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lblCargouActionPerformed

    private void btnFotouMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFotouMouseEntered
        Hover(btnFotou, 75, 112, 243, 255, 255, 255);
    }//GEN-LAST:event_btnFotouMouseEntered

    private void btnFotouMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFotouMouseExited
        Hover(btnFotou, 255, 255, 255, 75, 69, 255);
    }//GEN-LAST:event_btnFotouMouseExited

    private void btnSaveuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveuMouseEntered
        Hover(btnSaveu, 75, 112, 243, 255, 255, 255);
    }//GEN-LAST:event_btnSaveuMouseEntered

    private void btnSaveuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveuMouseExited
        Hover(btnSaveu, 255, 255, 255, 75, 69, 255);
    }//GEN-LAST:event_btnSaveuMouseExited

    private void btnDeluMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeluMouseEntered
        Hover(btnDelu, 75, 112, 243, 255, 255, 255);
    }//GEN-LAST:event_btnDeluMouseEntered

    private void btnModuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModuMouseEntered
        Hover(btnModu, 75, 112, 243, 255, 255, 255);
    }//GEN-LAST:event_btnModuMouseEntered

    private void btnModuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModuMouseExited
        Hover(btnModu, 255, 255, 255, 75, 69, 255);
    }//GEN-LAST:event_btnModuMouseExited

    private void btnDeluMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeluMouseExited
        Hover(btnDelu, 255, 255, 255, 75, 69, 255);
    }//GEN-LAST:event_btnDeluMouseExited

    private void btnCleanuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCleanuMouseEntered
        Hover(btnCleanu, 75, 112, 243, 255, 255, 255);
    }//GEN-LAST:event_btnCleanuMouseEntered

    private void btnCleanuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCleanuMouseExited
        Hover(btnCleanu, 255, 255, 255, 75, 69, 255);
    }//GEN-LAST:event_btnCleanuMouseExited

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
    private javax.swing.JButton btnCleanu;
    private javax.swing.JButton btnDelu;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnFotou;
    private javax.swing.JButton btnInicio;
    private javax.swing.JButton btnInv;
    private javax.swing.JButton btnModu;
    private javax.swing.JButton btnRepo;
    private javax.swing.JButton btnSale;
    private javax.swing.JButton btnSaveu;
    private javax.swing.JButton btnUser;
    private javax.swing.JComboBox<String> cbPrivu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField lblCargou;
    private javax.swing.JTextField lblDiru;
    private javax.swing.JFormattedTextField lblDniu;
    private javax.swing.JTextField lblEmailu;
    private javax.swing.JLabel lblFotou;
    private javax.swing.JLabel lblHora;
    private javax.swing.JPasswordField lblPassu;
    private javax.swing.JLabel lblRol;
    private javax.swing.JFormattedTextField lblTelu;
    private javax.swing.JTextField lblUName;
    private javax.swing.JLabel lblUser;
    private javax.swing.JLabel lblUserImg;
    private javax.swing.JLabel lblUserName;
    private javax.swing.JTextField lnlApellidou;
    private javax.swing.JTextField lnlNameu;
    private javax.swing.JPanel pnlCompras;
    private javax.swing.JPanel pnlInicio;
    private javax.swing.JPanel pnlInv;
    private javax.swing.JPanel pnlRepo;
    private javax.swing.JPanel pnlUser;
    private javax.swing.JPanel pnlVentas;
    private javax.swing.JTable tblUser;
    // End of variables declaration//GEN-END:variables
}
