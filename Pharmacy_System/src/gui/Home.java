package gui;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import model.MySQL;

public class Home extends javax.swing.JFrame {

    BrandRegistration brand;
    CategoryRegistration cr;
    CompanyRegistration comr;

    ProductRegistration pr;

    public Home() {
        initComponents();
        registerButton();
        dt();
        times();

        Dashboard d = new Dashboard(this);

        jPanel2.removeAll();
        jPanel2.add(d);
        jPanel2.revalidate();
        jPanel2.repaint();

    }

    public Home(ProductRegistration pr) {
        initComponents();
        registerButton();
        dt();
        times();
        this.pr = pr;

    }
    


    public Home(CategoryRegistration cr) {
        initComponents();
        registerButton();
        dt();
        times();

    }

    public Home(CompanyRegistration comr) {
        initComponents();
        registerButton();
        dt();
        times();

    }

    public Home(BrandRegistration brand) {
        initComponents();
        registerButton();
        dt();
        times();

    }

    public ImageIcon ResizeImage(String ImagePath) {
        ImageIcon MyImage = new ImageIcon(ImagePath);
        Image img = MyImage.getImage();
        Image newImg = img.getScaledInstance(jLabel1.getWidth(), jLabel1.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    }

    public void dt() {

        Date d = new Date();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd EEE");

        String dd = sdf.format(d);
        jLabel5.setText(dd);

    }

    Timer t;
    SimpleDateFormat st;

    public void times() {

        t = new Timer(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                Date dt = new Date();
                st = new SimpleDateFormat("hh:mm:ss a");

                String t = st.format(dt);
                jLabel6.setText(t);

            }

        });

        t.start();

    }

    public void registerButton() {

        try {

            int i = SignIn.userId;

            ResultSet r = MySQL.search("SELECT * FROM `user_registration` WHERE `id` = '" + i + "' ");
            r.next();
            String ut = r.getString("user_type_id");

            ResultSet r1 = MySQL.search("SELECT * FROM `user_type` WHERE `id` = '" + ut + "' ");
            r1.next();

            String t = r1.getString("name");

            if (t.equals("Super Admin") || t.equals("Manager")) {

                jButton4.setEnabled(true);

            } else {

                jButton4.setEnabled(false);
                
            }

            String urid = r.getString("user_id");

            ResultSet ur = MySQL.search("SELECT * FROM `user_login` WHERE `id` = '" + urid + "' ");
            ur.next();

            String uname = ur.getString("name");
            //  String id = ur.getString("id");

            ResultSet im = MySQL.search("SELECT * FROM `user_image` WHERE `user_id` = '" + urid + "' ");
            im.next();

            jLabel3.setText(uname);
            jLabel2.setText(t);

            String imge = im.getString("image");
          

            jLabel1.setIcon(ResizeImage(imge));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToggleButton1 = new javax.swing.JToggleButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jButton14 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();

        jToggleButton1.setText("jToggleButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setMaximumSize(new java.awt.Dimension(1920, 1080));
        setPreferredSize(new java.awt.Dimension(1920, 1000));
        setSize(new java.awt.Dimension(0, 0));

        jPanel1.setBackground(new java.awt.Color(0, 10, 33));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 102, 102), 3, true));
        jLabel1.setOpaque(true);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 102, 102));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jButton3.setBackground(new java.awt.Color(204, 255, 255));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_Add_User_Group_Man_Man_64px copy.png"))); // NOI18N
        jButton3.setText(" Sign In  /  Sign Up");
        jButton3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 97, 92), 2, true));
        jButton3.setContentAreaFilled(false);
        jButton3.setFocusable(false);
        jButton3.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        jButton3.setOpaque(true);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(204, 255, 255));
        jButton4.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_Handshake_64px copy.png"))); // NOI18N
        jButton4.setText("Employee Registration");
        jButton4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 97, 92), 2, true));
        jButton4.setContentAreaFilled(false);
        jButton4.setFocusable(false);
        jButton4.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        jButton4.setOpaque(true);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton9.setBackground(new java.awt.Color(204, 255, 255));
        jButton9.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_company_60px copy.png"))); // NOI18N
        jButton9.setText("Product Company");
        jButton9.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 97, 92), 2, true));
        jButton9.setContentAreaFilled(false);
        jButton9.setFocusable(false);
        jButton9.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        jButton9.setOpaque(true);
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(204, 255, 255));
        jButton6.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_franchise_60px copy.png"))); // NOI18N
        jButton6.setText("Company Branch");
        jButton6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 97, 92), 2, true));
        jButton6.setContentAreaFilled(false);
        jButton6.setFocusable(false);
        jButton6.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        jButton6.setOpaque(true);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton8.setBackground(new java.awt.Color(204, 255, 255));
        jButton8.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_diversity_48px copy.png"))); // NOI18N
        jButton8.setText("Product Category");
        jButton8.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 97, 92), 2, true));
        jButton8.setContentAreaFilled(false);
        jButton8.setFocusable(false);
        jButton8.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        jButton8.setOpaque(true);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton7.setBackground(new java.awt.Color(204, 255, 255));
        jButton7.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_Brand_New_64px copy.png"))); // NOI18N
        jButton7.setText("Add New Brand");
        jButton7.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 97, 92), 2, true));
        jButton7.setContentAreaFilled(false);
        jButton7.setFocusable(false);
        jButton7.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        jButton7.setOpaque(true);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(204, 255, 255));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_medical_bag_48px copy.png"))); // NOI18N
        jButton2.setText("Add New product");
        jButton2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 97, 92), 2, true));
        jButton2.setContentAreaFilled(false);
        jButton2.setFocusable(false);
        jButton2.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        jButton2.setOpaque(true);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton11.setBackground(new java.awt.Color(204, 255, 255));
        jButton11.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_database_import_64px copy.png"))); // NOI18N
        jButton11.setText("Stock");
        jButton11.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 97, 92), 2, true));
        jButton11.setContentAreaFilled(false);
        jButton11.setFocusable(false);
        jButton11.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        jButton11.setOpaque(true);
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(204, 255, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_supplier_100px copy.png"))); // NOI18N
        jButton1.setText("Add New Supplier");
        jButton1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 97, 92), 2, true));
        jButton1.setContentAreaFilled(false);
        jButton1.setFocusable(false);
        jButton1.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        jButton1.setOpaque(true);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton10.setBackground(new java.awt.Color(204, 255, 255));
        jButton10.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_flip_chart_64px copy.png"))); // NOI18N
        jButton10.setText("GRN");
        jButton10.setToolTipText("");
        jButton10.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 97, 92), 2, true));
        jButton10.setContentAreaFilled(false);
        jButton10.setFocusable(false);
        jButton10.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        jButton10.setOpaque(true);
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(204, 255, 255));
        jButton5.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_add_trash_32px.png"))); // NOI18N
        jButton5.setText("Expire Item");
        jButton5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 97, 92), 2, true));
        jButton5.setContentAreaFilled(false);
        jButton5.setFocusable(false);
        jButton5.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        jButton5.setOpaque(true);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton12.setBackground(new java.awt.Color(204, 255, 255));
        jButton12.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_cash_receipt_80px_1 copy.png"))); // NOI18N
        jButton12.setText("Invoice");
        jButton12.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 97, 92), 2, true));
        jButton12.setContentAreaFilled(false);
        jButton12.setFocusable(false);
        jButton12.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        jButton12.setOpaque(true);
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setOpaque(true);

        jButton14.setBackground(new java.awt.Color(204, 255, 255));
        jButton14.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jButton14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_expired_64px copy.png"))); // NOI18N
        jButton14.setText("Expire Soon Item");
        jButton14.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 97, 92), 2, true));
        jButton14.setContentAreaFilled(false);
        jButton14.setFocusable(false);
        jButton14.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        jButton14.setOpaque(true);
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jButton13.setBackground(new java.awt.Color(204, 204, 255));
        jButton13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_home_page_24px.png"))); // NOI18N
        jButton13.setText("Dashboard");
        jButton13.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 0), 2, true));
        jButton13.setContentAreaFilled(false);
        jButton13.setFocusable(false);
        jButton13.setOpaque(true);
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 204, 102));
        jLabel5.setToolTipText("");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 204, 102));
        jLabel6.setToolTipText("");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton13)
                .addGap(9, 9, 9)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1331, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Wellcome s = new Wellcome();
        s.setVisible(true);
        this.dispose();
        jButton3.setBackground(new Color(153, 153, 255));
        jButton4.setBackground(new Color(204, 255, 255));
        jButton1.setBackground(new Color(204, 255, 255));
        jButton8.setBackground(new Color(204, 255, 255));
        jButton11.setBackground(new Color(204, 255, 255));
        jButton12.setBackground(new Color(204, 255, 255));
        jButton5.setBackground(new Color(204, 255, 255));
        jButton2.setBackground(new Color(204, 255, 255));
        jButton6.setBackground(new Color(204, 255, 255));
        jButton9.setBackground(new Color(204, 255, 255));
        jButton7.setBackground(new Color(204, 255, 255));
        jButton10.setBackground(new Color(204, 255, 255));
        jButton14.setBackground(new Color(204, 255, 255));

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        Registration r = new Registration();
        r.setVisible(true);
        this.dispose();
        jButton3.setBackground(new Color(204, 255, 255));
        jButton4.setBackground(new Color(153, 153, 255));
        jButton1.setBackground(new Color(204, 255, 255));
        jButton8.setBackground(new Color(204, 255, 255));
        jButton11.setBackground(new Color(204, 255, 255));
        jButton12.setBackground(new Color(204, 255, 255));
        jButton5.setBackground(new Color(204, 255, 255));
        jButton2.setBackground(new Color(204, 255, 255));
        jButton6.setBackground(new Color(204, 255, 255));
        jButton9.setBackground(new Color(204, 255, 255));
        jButton7.setBackground(new Color(204, 255, 255));
        jButton10.setBackground(new Color(204, 255, 255));
        jButton14.setBackground(new Color(204, 255, 255));
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        SupplierRegistration s = new SupplierRegistration(this);
        jPanel2.removeAll();
        jPanel2.add(s);
        jPanel2.revalidate();
        jPanel2.repaint();

        jButton3.setBackground(new Color(204, 255, 255));
        jButton4.setBackground(new Color(204, 255, 255));
        jButton1.setBackground(new Color(153, 153, 255));
        jButton8.setBackground(new Color(204, 255, 255));
        jButton11.setBackground(new Color(204, 255, 255));
        jButton12.setBackground(new Color(204, 255, 255));
        jButton5.setBackground(new Color(204, 255, 255));
        jButton2.setBackground(new Color(204, 255, 255));
        jButton6.setBackground(new Color(204, 255, 255));
        jButton9.setBackground(new Color(204, 255, 255));
        jButton7.setBackground(new Color(204, 255, 255));
        jButton10.setBackground(new Color(204, 255, 255));
        jButton14.setBackground(new Color(204, 255, 255));

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        cr = new CategoryRegistration(this);
        cr.setVisible(true);
        this.setEnabled(false);

        jPanel2.removeAll();
        //    jPanel2.add(p);
        jPanel2.revalidate();
        jPanel2.repaint();

        jButton3.setBackground(new Color(204, 255, 255));
        jButton4.setBackground(new Color(204, 255, 255));
        jButton1.setBackground(new Color(204, 255, 255));
        jButton8.setBackground(new Color(153, 153, 255));
        jButton11.setBackground(new Color(204, 255, 255));
        jButton12.setBackground(new Color(204, 255, 255));
        jButton5.setBackground(new Color(204, 255, 255));
        jButton2.setBackground(new Color(204, 255, 255));
        jButton6.setBackground(new Color(204, 255, 255));
        jButton9.setBackground(new Color(204, 255, 255));
        jButton7.setBackground(new Color(204, 255, 255));
        jButton10.setBackground(new Color(204, 255, 255));
        jButton14.setBackground(new Color(204, 255, 255));

    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        Stock st = new Stock(this);
        jPanel2.removeAll();
        jPanel2.add(st);
        jPanel2.revalidate();
        jPanel2.repaint();

        jButton3.setBackground(new Color(204, 255, 255));
        jButton4.setBackground(new Color(204, 255, 255));
        jButton1.setBackground(new Color(204, 255, 255));
        jButton8.setBackground(new Color(204, 255, 255));
        jButton11.setBackground(new Color(153, 153, 255));
        jButton12.setBackground(new Color(204, 255, 255));
        jButton5.setBackground(new Color(204, 255, 255));
        jButton2.setBackground(new Color(204, 255, 255));
        jButton6.setBackground(new Color(204, 255, 255));
        jButton9.setBackground(new Color(204, 255, 255));
        jButton7.setBackground(new Color(204, 255, 255));
        jButton10.setBackground(new Color(204, 255, 255));
        jButton14.setBackground(new Color(204, 255, 255));
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        Invoice i = new Invoice(this);
        jPanel2.removeAll();
        jPanel2.add(i);
        jPanel2.revalidate();
        jPanel2.repaint();

        jButton3.setBackground(new Color(204, 255, 255));
        jButton4.setBackground(new Color(204, 255, 255));
        jButton1.setBackground(new Color(204, 255, 255));
        jButton8.setBackground(new Color(204, 255, 255));
        jButton11.setBackground(new Color(204, 255, 255));
        jButton12.setBackground(new Color(153, 153, 255));
        jButton5.setBackground(new Color(204, 255, 255));
        jButton2.setBackground(new Color(204, 255, 255));
        jButton6.setBackground(new Color(204, 255, 255));
        jButton9.setBackground(new Color(204, 255, 255));
        jButton7.setBackground(new Color(204, 255, 255));
        jButton10.setBackground(new Color(204, 255, 255));
        jButton14.setBackground(new Color(204, 255, 255));
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
//        ExpireSoon ex = new ExpireSoon(this);
        ExpireItem ex = new ExpireItem(this);
        //      ex.setVisible(true);
        //    this.setEnabled(false);

        jPanel2.removeAll();
        jPanel2.add(ex);
        jPanel2.revalidate();
        jPanel2.repaint();

        jButton3.setBackground(new Color(204, 255, 255));
        jButton4.setBackground(new Color(204, 255, 255));
        jButton1.setBackground(new Color(204, 255, 255));
        jButton8.setBackground(new Color(204, 255, 255));
        jButton11.setBackground(new Color(204, 255, 255));
        jButton12.setBackground(new Color(204, 255, 255));
        jButton5.setBackground(new Color(153, 153, 255));
        jButton2.setBackground(new Color(204, 255, 255));
        jButton6.setBackground(new Color(204, 255, 255));
        jButton9.setBackground(new Color(204, 255, 255));
        jButton7.setBackground(new Color(204, 255, 255));
        jButton10.setBackground(new Color(204, 255, 255));
        jButton14.setBackground(new Color(204, 255, 255));

    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        ProductRegistration p = new ProductRegistration(this);
        jPanel2.removeAll();
        jPanel2.add(p);
        jPanel2.revalidate();
        jPanel2.repaint();

        jButton3.setBackground(new Color(204, 255, 255));
        jButton4.setBackground(new Color(204, 255, 255));
        jButton1.setBackground(new Color(204, 255, 255));
        jButton8.setBackground(new Color(204, 255, 255));
        jButton11.setBackground(new Color(204, 255, 255));
        jButton12.setBackground(new Color(204, 255, 255));
        jButton5.setBackground(new Color(204, 255, 255));
        jButton2.setBackground(new Color(153, 153, 255));
        jButton6.setBackground(new Color(204, 255, 255));
        jButton9.setBackground(new Color(204, 255, 255));
        jButton7.setBackground(new Color(204, 255, 255));
        jButton10.setBackground(new Color(204, 255, 255));
        jButton14.setBackground(new Color(204, 255, 255));
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed

        BrnchRegistration branch = new BrnchRegistration(this);

//                home.jPanel2.removeAll();
//                home.jPanel2.add(sr);
//                home.jPanel2.revalidate();
//               home.jPanel2.repaint(); 
        jPanel2.removeAll();
        jPanel2.add(branch);
        jPanel2.revalidate();
        jPanel2.repaint();

        jButton3.setBackground(new Color(204, 255, 255));
        jButton4.setBackground(new Color(204, 255, 255));
        jButton1.setBackground(new Color(204, 255, 255));
        jButton8.setBackground(new Color(204, 255, 255));
        jButton11.setBackground(new Color(204, 255, 255));
        jButton12.setBackground(new Color(204, 255, 255));
        jButton5.setBackground(new Color(204, 255, 255));
        jButton2.setBackground(new Color(204, 255, 255));
        jButton6.setBackground(new Color(153, 153, 255));
        jButton9.setBackground(new Color(204, 255, 255));
        jButton7.setBackground(new Color(204, 255, 255));
        jButton10.setBackground(new Color(204, 255, 255));
        jButton14.setBackground(new Color(204, 255, 255));


    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        comr = new CompanyRegistration(this);
        this.setEnabled(false);

        jPanel2.removeAll();
//            jPanel2.add(cr);
        jPanel2.revalidate();
        jPanel2.repaint();

        comr.setVisible(true);

        jButton3.setBackground(new Color(204, 255, 255));
        jButton4.setBackground(new Color(204, 255, 255));
        jButton1.setBackground(new Color(204, 255, 255));
        jButton8.setBackground(new Color(204, 255, 255));
        jButton11.setBackground(new Color(204, 255, 255));
        jButton12.setBackground(new Color(204, 255, 255));
        jButton5.setBackground(new Color(204, 255, 255));
        jButton2.setBackground(new Color(204, 255, 255));
        jButton6.setBackground(new Color(204, 255, 255));
        jButton9.setBackground(new Color(153, 153, 255));
        jButton7.setBackground(new Color(204, 255, 255));
        jButton10.setBackground(new Color(204, 255, 255));
        jButton14.setBackground(new Color(204, 255, 255));
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed

//        BrandRegistration brand = new BrandRegistration(this, true);
        brand = new BrandRegistration(this);
        this.setEnabled(false);

// BrandRegistration brand = new  BrandRegistration(, rootPaneCheckingEnabled)
        jPanel2.removeAll();
//            jPanel2.add(brand);
        jPanel2.revalidate();
        jPanel2.repaint();

        brand.setVisible(true);

        jButton3.setBackground(new Color(204, 255, 255));
        jButton4.setBackground(new Color(204, 255, 255));
        jButton1.setBackground(new Color(204, 255, 255));
        jButton8.setBackground(new Color(204, 255, 255));
        jButton11.setBackground(new Color(204, 255, 255));
        jButton12.setBackground(new Color(204, 255, 255));
        jButton5.setBackground(new Color(204, 255, 255));
        jButton2.setBackground(new Color(204, 255, 255));
        jButton6.setBackground(new Color(204, 255, 255));
        jButton9.setBackground(new Color(204, 255, 255));
        jButton7.setBackground(new Color(153, 153, 255));
        jButton10.setBackground(new Color(204, 255, 255));
        jButton14.setBackground(new Color(204, 255, 255));

    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed

        GRN grn = new GRN(this);

        jPanel2.removeAll();
        jPanel2.add(grn);
        jPanel2.revalidate();
        jPanel2.repaint();

        jButton3.setBackground(new Color(204, 255, 255));
        jButton4.setBackground(new Color(204, 255, 255));
        jButton1.setBackground(new Color(204, 255, 255));
        jButton8.setBackground(new Color(204, 255, 255));
        jButton11.setBackground(new Color(204, 255, 255));
        jButton12.setBackground(new Color(204, 255, 255));
        jButton5.setBackground(new Color(204, 255, 255));
        jButton2.setBackground(new Color(204, 255, 255));
        jButton6.setBackground(new Color(204, 255, 255));
        jButton9.setBackground(new Color(204, 255, 255));
        jButton7.setBackground(new Color(204, 255, 255));
        jButton10.setBackground(new Color(153, 153, 255));
        jButton14.setBackground(new Color(204, 255, 255));

    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        ExpireSoon ex = new ExpireSoon(this);
        ex.setVisible(true);
        this.setEnabled(false);

        jPanel2.removeAll();
        jPanel2.revalidate();
        jPanel2.repaint();

        jButton3.setBackground(new Color(204, 255, 255));
        jButton4.setBackground(new Color(204, 255, 255));
        jButton1.setBackground(new Color(204, 255, 255));
        jButton8.setBackground(new Color(204, 255, 255));
        jButton11.setBackground(new Color(204, 255, 255));
        jButton12.setBackground(new Color(204, 255, 255));
        jButton5.setBackground(new Color(204, 255, 255));
        jButton2.setBackground(new Color(204, 255, 255));
        jButton6.setBackground(new Color(204, 255, 255));
        jButton9.setBackground(new Color(204, 255, 255));
        jButton7.setBackground(new Color(204, 255, 255));
        jButton10.setBackground(new Color(204, 255, 255));
        jButton14.setBackground(new Color(153, 153, 255));
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed

        Dashboard db = new Dashboard(this);

        jPanel2.removeAll();
        jPanel2.add(db);
        jPanel2.revalidate();
        jPanel2.repaint();
    }//GEN-LAST:event_jButton13ActionPerformed

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
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JPanel jPanel2;
    private javax.swing.JToggleButton jToggleButton1;
    // End of variables declaration//GEN-END:variables
}
