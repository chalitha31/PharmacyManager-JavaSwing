/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import javax.swing.JFrame;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import model.MySQL;

/**
 *
 * @author chalitha
 */
public class Registration extends javax.swing.JFrame {

    /**
     * Creates new form Registration
     */
    
    
    public Registration() {
        initComponents();
        NotRegisterUser();

        loadCities();
        loadEmployee();
        loadUserTypes();
        loadgender();
    }

    public void NotRegisterUser() {

        try {

            ResultSet rs1 = MySQL.search(" SELECT *  FROM  `user_image` INNER JOIN `user_login` ON `user_login`.`id` = `user_image`.`user_id`"
                    + "WHERE NOT EXISTS (SELECT * FROM `user_login` INNER JOIN `user_registration`  WHERE `user_login`.`id` = `user_registration`.`user_id` AND `user_image`.`user_id` = `user_registration`.`user_id` "
                    + "AND `user_login`.`id` = `user_registration`.`user_id` ) AND NOT EXISTS (SELECT * FROM `user_registration`  WHERE `user_login`.`id` = `user_registration`.`user_id` )");

            DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
            dtm.setRowCount(0);

            while (rs1.next()) {

                jTable1.getColumn("image").setCellRenderer(new tableRendere());

                String imager = rs1.getString("user_image.image");

                ImageIcon imageicon = new ImageIcon(imager);

                Image Timage = imageicon.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);

                JLabel imglabel = new JLabel();

                imglabel.setIcon(new ImageIcon(Timage));

                Vector v = new Vector();
                v.add(imglabel);
                v.add(rs1.getString("user_login.name"));
                v.add(rs1.getString("user_login.username"));
                v.add(rs1.getString("user_login.contact_no"));
                dtm.addRow(v);

            }

            jTable1.setModel(dtm);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    class tableRendere implements TableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

            TableColumn tb = jTable1.getColumn("image");
            tb.setMaxWidth(60);
            jTable1.setRowHeight(60);
            return (Component) value;
        }
    }

    class table2Rendere implements TableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

            TableColumn tb = jTable2.getColumn("image");
            tb.setMaxWidth(40);
            jTable2.setRowHeight(40);
            return (Component) value;
        }
    }

    public void loadEmployee() {

        try {

            ResultSet rs = MySQL.search("SELECT `user_image`.`image` AS `image`,`user_login`.`name` AS `ename`,`user_login`.`username` AS `uname`,`user_login`.`password` AS `epassword`,\n"
                    + "`user_registration`.`nic` AS `nic`,`user_login`.`contact_no` AS `mobile`,`user_registration`.`address` AS `address`,\n"
                    + "`gender`.`name` AS `gender`,`user_type`.`name` AS `userType`,`city`.`name` AS `city`,`user_status`.`name` AS `estatus`   "
                    + "FROM `user_registration` INNER JOIN `user_login` ON `user_registration`.`user_id` =`user_login`.`id`\n"
                    + "INNER JOIN `user_image` ON `user_registration`.`user_id` = `user_image`.`user_id` INNER JOIN `gender` \n"
                    + "ON `user_registration`.`gender_id` = `gender`.`id` INNER JOIN  `user_type` ON `user_registration`.`user_type_id` = \n"
                    + "`user_type`.`id` INNER JOIN `user_status` ON `user_registration`.`user_status_id` = `user_status`.`id`\n"
                    + "INNER JOIN `city` ON `user_registration`.`city_id` = `city`.`id` WHERE `user_type`.`name` != 'Super Admin' ORDER BY `user_registration`.`user_type_id` ASC ");

            DefaultTableModel dtm = (DefaultTableModel) jTable2.getModel();
            dtm.setRowCount(0);

            while (rs.next()) {

                jTable2.getColumn("image").setCellRenderer(new table2Rendere());

                String imager = rs.getString("image");

                ImageIcon imageicon = new ImageIcon(imager);

                Image Timage = imageicon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);

                JLabel imglabel = new JLabel();

                imglabel.setIcon(new ImageIcon(Timage));

                Vector v = new Vector();
                v.add(imglabel);
                v.add(rs.getString("ename"));
                v.add(rs.getString("uname"));
                v.add(rs.getString("epassword"));
                v.add(rs.getString("nic"));
                v.add(rs.getString("mobile"));
                v.add(rs.getString("address"));
                v.add(rs.getString("gender"));
                v.add(rs.getString("userType"));
                v.add(rs.getString("city"));
                v.add(rs.getString("estatus"));
                dtm.addRow(v);
            }
            jTable2.setModel(dtm);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void loadEmployee(String text) {

        try {

            ResultSet rs = MySQL.search("SELECT `user_image`.`image` AS `image`,`user_login`.`name` AS `ename`,`user_login`.`username` AS `uname`,`user_login`.`password` AS `epassword`,\n"
                    + "`user_registration`.`nic` AS `nic`,`user_login`.`contact_no` AS `mobile`,`user_registration`.`address` AS `address`,\n"
                    + "`gender`.`name` AS `gender`,`user_type`.`name` AS `userType`,`city`.`name` AS `city`,`user_status`.`name` AS `estatus`   "
                    + "FROM `user_registration` INNER JOIN `user_login` ON `user_registration`.`user_id` =`user_login`.`id`\n"
                    + "INNER JOIN `user_image` ON `user_registration`.`user_id` = `user_image`.`user_id` INNER JOIN `gender` \n"
                    + "ON `user_registration`.`gender_id` = `gender`.`id` INNER JOIN  `user_type` ON `user_registration`.`user_type_id` = \n"
                    + "`user_type`.`id` INNER JOIN `user_status` ON `user_registration`.`user_status_id` = `user_status`.`id`\n"
                    + "INNER JOIN `city` ON `user_registration`.`city_id` = `city`.`id`  WHERE `user_type`.`name` != 'Super Admin' AND"
                    + " `user_login`.`name` LIKE '" + text + "%' OR `user_login`.`contact_no` LIKE '" + text + "%' OR `user_registration`.`nic` LIKE '" + text + "%' ORDER BY `user_registration`.`user_type_id` ASC ");

            DefaultTableModel dtm = (DefaultTableModel) jTable2.getModel();
            dtm.setRowCount(0);

            while (rs.next()) {

                jTable2.getColumn("image").setCellRenderer(new table2Rendere());

                String imager = rs.getString("image");

                ImageIcon imageicon = new ImageIcon(imager);

                Image Timage = imageicon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);

                JLabel imglabel = new JLabel();

                imglabel.setIcon(new ImageIcon(Timage));

                Vector v = new Vector();
                v.add(imglabel);
                v.add(rs.getString("ename"));
                v.add(rs.getString("uname"));
                v.add(rs.getString("epassword"));
                v.add(rs.getString("nic"));
                v.add(rs.getString("mobile"));
                v.add(rs.getString("address"));
                v.add(rs.getString("gender"));
                v.add(rs.getString("userType"));
                v.add(rs.getString("city"));
                v.add(rs.getString("estatus"));
                dtm.addRow(v);
            }
            jTable2.setModel(dtm);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void loadUserTypes() {

        try {
            ResultSet rs = MySQL.search("SELECT * FROM `user_type`");

            Vector v = new Vector();
            v.add("Select");
            while (rs.next()) {
                v.add(rs.getString("name"));
            }

            DefaultComboBoxModel dcm = new DefaultComboBoxModel(v);
            jComboBox2.setModel(dcm);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadCities() {

        try {
            ResultSet rs = MySQL.search("SELECT * FROM `city`");

            Vector v = new Vector();
            v.add("Select");

            while (rs.next()) {
                v.add(rs.getString("name"));
            }

            DefaultComboBoxModel dcm = new DefaultComboBoxModel(v);
            jComboBox1.setModel(dcm);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadgender() {

        try {
            ResultSet rs = MySQL.search("SELECT * FROM `gender`");

            Vector v = new Vector();
            v.add("Select");

            while (rs.next()) {
                v.add(rs.getString("name"));
            }

            DefaultComboBoxModel dcm = new DefaultComboBoxModel(v);
            jComboBox3.setModel(dcm);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void resetFields() {
        jLabel3.setText("");
        jLabel4.setText("");
        jLabel5.setText("");
        jLabel15.setText("");
        jLabel16.setText("");
        jLabel17.setText("");
        jLabel18.setText("");
        jLabel19.setText("");

        jTextArea1.setText("");
        jTextField1.setText("");
        jTextField2.setText("");
        jComboBox1.setSelectedIndex(0);
        jComboBox2.setSelectedIndex(0);
        jComboBox3.setSelectedIndex(0);

        jTextField2.setBorder(new MatteBorder(1, 1, 1, 1, Color.WHITE));
        jTextArea1.setBorder(new MatteBorder(1, 1, 1, 1, Color.WHITE));
        jComboBox1.setBorder(null);
        jComboBox2.setBorder(null);
        jComboBox3.setBorder(null);
        jTable1.setBorder(null);

        jTable1.clearSelection();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kGradientPanel1 = new com.k33ptoo.components.KGradientPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        kButton1 = new com.k33ptoo.components.KButton();
        kButton2 = new com.k33ptoo.components.KButton();
        jTextField2 = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        kGradientPanel1.setForeground(new java.awt.Color(255, 0, 0));
        kGradientPanel1.setkEndColor(new java.awt.Color(0, 132, 235));
        kGradientPanel1.setkGradientFocus(800);
        kGradientPanel1.setkStartColor(new java.awt.Color(255, 118, 207));
        kGradientPanel1.setOpaque(false);
        kGradientPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setBackground(new java.awt.Color(153, 204, 255));
        jTable1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "image", "Name", "User Name", "Contact No"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        kGradientPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(568, 64, -1, 205));

        jTable2.setBackground(new java.awt.Color(204, 204, 255));
        jTable2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "image", "Name", "Username", "Password", "Nic", "Contact No", "Address", "gender", "Type", "City", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.setGridColor(new java.awt.Color(102, 102, 102));
        jTable2.setOpaque(false);
        jTable2.setSelectionBackground(new java.awt.Color(255, 153, 153));
        jTable2.setShowGrid(true);
        jScrollPane2.setViewportView(jTable2);

        kGradientPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 564, 1010, 247));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Name");
        kGradientPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 120, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("User Name");
        kGradientPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 170, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        kGradientPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 110, 174, 31));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel4.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        kGradientPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 160, 174, 27));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel5.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        kGradientPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 200, 174, 29));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Contact No");
        kGradientPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 210, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Nic / Passport ");
        kGradientPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Address");
        kGradientPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 310, -1, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("City");
        kGradientPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(422, 315, -1, -1));

        jComboBox1.setBackground(new java.awt.Color(255, 51, 255));
        jComboBox1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jComboBox1.setOpaque(false);
        kGradientPanel1.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(501, 310, 176, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("User Type");
        kGradientPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(422, 381, -1, -1));

        jComboBox2.setBackground(new java.awt.Color(255, 51, 255));
        jComboBox2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        kGradientPanel1.add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(501, 378, 176, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("gender");
        kGradientPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(91, 381, -1, -1));

        jComboBox3.setBackground(new java.awt.Color(255, 51, 255));
        jComboBox3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        kGradientPanel1.add(jComboBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(158, 378, 171, -1));

        jTextArea1.setBackground(new java.awt.Color(0, 132, 235));
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(3);
        jTextArea1.setTabSize(9);
        jTextArea1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        jScrollPane3.setViewportView(jTextArea1);

        kGradientPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 300, 200, 75));

        jLabel6.setFont(new java.awt.Font("Segoe UI Semibold", 1, 36)); // NOI18N
        jLabel6.setText("<html><u>User Registration</u></html>");
        kGradientPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, -10, -1, 60));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Search User :");
        kGradientPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 539, -1, -1));

        kButton1.setForeground(new java.awt.Color(51, 51, 51));
        kButton1.setText("Change Status");
        kButton1.setFocusable(false);
        kButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        kButton1.setkHoverForeGround(new java.awt.Color(0, 0, 0));
        kButton1.setkStartColor(new java.awt.Color(255, 102, 102));
        kButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton1ActionPerformed(evt);
            }
        });
        kGradientPanel1.add(kButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 532, 160, 26));

        kButton2.setText("Update Details");
        kButton2.setToolTipText("");
        kButton2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        kButton2.setkBorderRadius(50);
        kButton2.setkEndColor(new java.awt.Color(51, 51, 255));
        kButton2.setkForeGround(new java.awt.Color(0, 0, 0));
        kButton2.setkHoverEndColor(new java.awt.Color(255, 102, 102));
        kButton2.setkHoverForeGround(new java.awt.Color(0, 0, 0));
        kButton2.setkHoverStartColor(new java.awt.Color(102, 102, 255));
        kButton2.setkStartColor(new java.awt.Color(255, 56, 127));
        kButton2.setRolloverEnabled(false);
        kButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton2ActionPerformed(evt);
            }
        });
        kGradientPanel1.add(kButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 450, 316, -1));

        jTextField2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextField2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField2KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField2KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField2KeyTyped(evt);
            }
        });
        kGradientPanel1.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(158, 315, 171, -1));

        jTextField1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextField1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 2));
        jTextField1.setOpaque(false);
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });
        kGradientPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(93, 532, 370, -1));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_subtract_30px.png"))); // NOI18N
        jButton1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        jButton1.setContentAreaFilled(false);
        jButton1.setFocusable(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        kGradientPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(956, 0, 37, 27));

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_close_26px.png"))); // NOI18N
        jButton2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        jButton2.setContentAreaFilled(false);
        jButton2.setFocusable(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        kGradientPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(993, 0, 37, -1));

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setOpaque(true);
        jLabel14.setPreferredSize(new java.awt.Dimension(2, 0));
        kGradientPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 513, 896, 2));

        jLabel15.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 51, 51));
        kGradientPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 340, 170, 13));

        jLabel16.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 51, 51));
        kGradientPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 340, 176, 13));

        jLabel17.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 51, 51));
        kGradientPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 410, 176, 13));

        jLabel18.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 51, 51));
        kGradientPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 410, 171, 13));

        jLabel19.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 51, 51));
        kGradientPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 380, 200, 13));

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(51, 51, 51));
        jLabel20.setText("∨ new employees ∨");
        kGradientPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 40, 150, -1));

        jButton3.setBackground(new java.awt.Color(255, 153, 102));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_home_50px_1.png"))); // NOI18N
        jButton3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButton3.setContentAreaFilled(false);
        jButton3.setFocusable(false);
        jButton3.setOpaque(true);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        kGradientPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 70, 60));

        jLabel21.setBackground(new java.awt.Color(255, 255, 255));
        jLabel21.setOpaque(true);
        jLabel21.setPreferredSize(new java.awt.Dimension(2, 0));
        kGradientPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 290, 896, 2));

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_add_new_26px_1.png"))); // NOI18N
        jButton4.setToolTipText("");
        jButton4.setContentAreaFilled(false);
        jButton4.setFocusable(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        kGradientPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 375, 30, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 821, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed

    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyPressed

    }//GEN-LAST:event_jTextField2KeyPressed

    private void jTextField2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyReleased
        jTextField2.setText(jTextField2.getText().toLowerCase());
    }//GEN-LAST:event_jTextField2KeyReleased

    private void jTextField2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyTyped

    }//GEN-LAST:event_jTextField2KeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.setExtendedState(JFrame.ICONIFIED);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
//        System.exit(0);
  this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

        if (evt.getClickCount() == 2) {

            int r = jTable1.getSelectedRow();

            //       String sid = jTable1.getValueAt(r, 0).toString();
            String name = jTable1.getValueAt(r, 1).toString();
            String username = jTable1.getValueAt(r, 2).toString();
            String mobile = jTable1.getValueAt(r, 3).toString();

            jLabel3.setText(name);
            jLabel4.setText(username);
            jLabel5.setText(mobile);

        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void kButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton2ActionPerformed

        String name = jLabel3.getText();
        String uname = jLabel4.getText();
        String mobile = jLabel5.getText();
        String nic = jTextField2.getText();
        String address = jTextArea1.getText();
        String type = jComboBox2.getSelectedItem().toString();
        String city = jComboBox1.getSelectedItem().toString();
        String gender = jComboBox3.getSelectedItem().toString();

        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Select User", "Warning", JOptionPane.WARNING_MESSAGE);

            jTable1.setBorder(new MatteBorder(2, 2, 2, 2, Color.RED));

        } else if (nic.isEmpty()) {
            //     JOptionPane.showMessageDialog(this, "Please Enter nic Number", "Warning", JOptionPane.WARNING_MESSAGE);

            jLabel15.setText("Please Enter  Nic Number");
            jTextField2.setBorder(new MatteBorder(2, 2, 2, 2, Color.RED));

            jLabel16.setText("");
            jLabel17.setText("");
            jLabel18.setText("");
            jLabel19.setText("");

            jTextArea1.setBorder(new MatteBorder(1, 1, 1, 1, Color.WHITE));
            jComboBox1.setBorder(null);
            jComboBox2.setBorder(null);
            jComboBox3.setBorder(null);
            jTable1.setBorder(null);

        } else if (city.equals("Select")) {
            //    JOptionPane.showMessageDialog(this, "Please Select City", "Warning", JOptionPane.WARNING_MESSAGE);

            jLabel16.setText("Please Select City");
            jComboBox1.setBorder(new MatteBorder(2, 2, 2, 2, Color.RED));

            jLabel15.setText("");
            jLabel17.setText("");
            jLabel18.setText("");
            jLabel19.setText("");

            jTextArea1.setBorder(new MatteBorder(1, 1, 1, 1, Color.WHITE));
            jTextField2.setBorder(new MatteBorder(1, 1, 1, 1, Color.WHITE));
            jComboBox2.setBorder(null);
            jComboBox3.setBorder(null);
            jTable1.setBorder(null);

        } else if (address.isEmpty()) {
            //        JOptionPane.showMessageDialog(this, "Please Enter Your Address", "Warning", JOptionPane.WARNING_MESSAGE);

            jLabel19.setText("Please Select Address");
            jTextArea1.setBorder(new MatteBorder(2, 2, 2, 2, Color.RED));

            jLabel15.setText("");
            jLabel16.setText("");
            jLabel17.setText("");
            jLabel18.setText("");

            jTextField2.setBorder(new MatteBorder(1, 1, 1, 1, Color.WHITE));
            jComboBox1.setBorder(null);
            jComboBox2.setBorder(null);
            jComboBox3.setBorder(null);
            jTable1.setBorder(null);

        } else if (gender.equals("Select")) {
            //       JOptionPane.showMessageDialog(this, "Please Select gender", "Warning", JOptionPane.WARNING_MESSAGE);

            jLabel18.setText("Please Select gender");
            jComboBox3.setBorder(new MatteBorder(2, 2, 2, 2, Color.RED));

            jLabel15.setText("");
            jLabel16.setText("");
            jLabel17.setText("");
            jLabel19.setText("");

//            jTextField1.setBorder(new MatteBorder(0, 0, 2, 0, Color.WHITE));
            jTextArea1.setBorder(new MatteBorder(1, 1, 1, 1, Color.WHITE));
            jTextField2.setBorder(new MatteBorder(1, 1, 1, 1, Color.WHITE));
            jComboBox1.setBorder(null);
            jComboBox2.setBorder(null);
            jTable1.setBorder(null);

        } else if (type.equals("Select")) {
            //      JOptionPane.showMessageDialog(this, "Please Select Type", "Warning", JOptionPane.WARNING_MESSAGE);

            jLabel17.setText("Please Select User Type");
            jComboBox2.setBorder(new MatteBorder(2, 2, 2, 2, Color.RED));

            jLabel15.setText("");
            jLabel16.setText("");
            jLabel18.setText("");
            jLabel19.setText("");

            jTextArea1.setBorder(new MatteBorder(1, 1, 1, 1, Color.WHITE));
            jTextField2.setBorder(new MatteBorder(1, 1, 1, 1, Color.WHITE));
            jComboBox1.setBorder(null);
            jComboBox3.setBorder(null);
            jTable1.setBorder(null);

        } else {

            try {

                ResultSet rs1 = MySQL.search("SELECT `id` FROM `user_login` WHERE `name` = '" + name + "' AND `username` = '" + uname + "' AND `contact_no` =  '" + mobile + "'");
                rs1.next();

                String uid = rs1.getString("id");

                ResultSet rs2 = MySQL.search("SELECT `id` FROM `user_type` WHERE `name`='" + type + "'");
                rs2.next();

                String type_id = rs2.getString("id");

                ResultSet rs3 = MySQL.search("SELECT `id` FROM `city` WHERE `name`='" + city + "'");
                rs3.next();

                String city_id = rs3.getString("id");

                ResultSet rs4 = MySQL.search("SELECT `id` FROM `gender` WHERE `name`='" + gender + "'");
                rs4.next();

                String gender_id = rs4.getString("id");

                MySQL.iud("INSERT INTO `user_registration` (`user_id`,`user_type_id`,`city_id`,`address`,`nic`,`gender_id`)  VALUES ('" + uid + "','" + type_id + "','" + city_id + "','" + address + "','" + nic + "','" + gender_id + "')");

                resetFields();
                loadEmployee();
                NotRegisterUser();

                JOptionPane.showMessageDialog(this, "Successfully added a new employee", "Success", JOptionPane.INFORMATION_MESSAGE);

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }//GEN-LAST:event_kButton2ActionPerformed

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        String text = jTextField1.getText();
        loadEmployee(text);
    }//GEN-LAST:event_jTextField1KeyReleased

    private void kButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton1ActionPerformed

        int selectedRow = jTable2.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please Select the employee", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            String nic = jTable2.getValueAt(selectedRow, 4).toString();
            String currentStatus = jTable2.getValueAt(selectedRow, 10).toString();

            int status;

            if (currentStatus.equals("Active")) {
                status = 2;
            } else {
                status = 1;
            }

            MySQL.iud("UPDATE `user_registration` SET `user_status_id`=" + status + " WHERE `nic`='" + nic + "'");

            loadEmployee();
            NotRegisterUser();

            JOptionPane.showMessageDialog(this, "User Status Updated", "Success", JOptionPane.INFORMATION_MESSAGE);

        }

    }//GEN-LAST:event_kButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
      Home h = new Home();
      h.setVisible(true);
      this.dispose();
      
        try {
              ResultSet rr = MySQL.search("SELECT * FROM `stock`");
    ExpireSoon ex = new ExpireSoon();
                        while (rr.next()) {

                            String exdate = rr.getString("exd");

                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

                            String dnow = sdf.format(new Date());

                            long lg = ChronoUnit.DAYS.between(LocalDate.parse(dnow), LocalDate.parse(exdate));

                            if ( lg <=  20  &&  lg >  5) {

                            
                                ex.setVisible(true);

                            }
                        }
        } catch (Exception e) {
            e.printStackTrace();
        }
      
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        //        ImageIcon icon = new ImageIcon("/C:/Users/sandu/OneDrive/Documents/NetBeansProjects/Pharmacy_System/build/classes/img/icons8_remove_image_128px_1.png");
        //        jLabel2.setIcon(icon);
UserType u = new UserType(this, true);
        u.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(Registration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Registration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Registration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Registration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Registration().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
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
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private com.k33ptoo.components.KButton kButton1;
    private com.k33ptoo.components.KButton kButton2;
    private com.k33ptoo.components.KGradientPanel kGradientPanel1;
    // End of variables declaration//GEN-END:variables
}
