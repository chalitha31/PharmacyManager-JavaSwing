/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Color;
import java.awt.Font;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import java.util.regex.Pattern;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import model.MySQL;

/**
 *
 * @author chalitha
 */
public class CustomerRegistration extends javax.swing.JPanel {

    Home h;
    Invoice i;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * Creates new form CustomerRegistration
     */
    public CustomerRegistration() {
        initComponents();
        loadCities();
        loadGender();
        loadCustomer();
    }

    public CustomerRegistration(Home h) {
        initComponents();
        loadCities();
        loadGender();
        loadCustomer();
        this.h = h;
    }

    public CustomerRegistration(Invoice i) {
        initComponents();
        loadCities();
        loadGender();
        loadCustomer();
        this.i = i;
    }

    public void loadCustomer(String text) {

        try {
            ResultSet rs = MySQL.search("SELECT * FROM `customer` INNER JOIN `gender` ON `gender`.`id` = `customer`.`gender_id` "
                    + " INNER JOIN `city` ON `city`.`id` = `customer`.`city_id`  WHERE `customer`.`name` LIKE '" + text + "%'  OR  `customer`.`nic` LIKE '" + text + "%' ORDER BY `customer`.`name` ASC");

            DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
            dtm.setRowCount(0);

            JTableHeader tb = jTable1.getTableHeader();
            tb.setForeground(Color.BLACK);
            tb.setFont(new Font("Tahome", Font.BOLD, 17));

            TableColumn t = jTable1.getColumn("id");
            t.setMaxWidth(80);

            jTable1.setRowHeight(30);

            while (rs.next()) {

                Vector v = new Vector();

                v.add(rs.getString("customer.id"));
                v.add(rs.getString("customer.name"));
                v.add(rs.getString("customer.nic"));
                v.add(rs.getString("customer.contact_number"));
                v.add(rs.getString("city.name"));
                v.add(rs.getString("customer.address"));
                v.add(rs.getString("gender.name"));
                v.add(rs.getString("customer.dob"));

                dtm.addRow(v);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void loadCustomer() {

        try {
            ResultSet rs = MySQL.search("SELECT * FROM `customer` INNER JOIN `gender` ON `gender`.`id` = `customer`.`gender_id` INNER JOIN `city` ON `city`.`id` = `customer`.`city_id`");

            DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
            dtm.setRowCount(0);

            JTableHeader tb = jTable1.getTableHeader();
            tb.setForeground(Color.BLACK);
            tb.setFont(new Font("Tahome", Font.BOLD, 15));

            TableColumn t = jTable1.getColumn("id");
            t.setMaxWidth(80);

            jTable1.setRowHeight(30);

            while (rs.next()) {

                Vector v = new Vector();

                v.add(rs.getString("customer.id"));
                v.add(rs.getString("customer.name"));
                v.add(rs.getString("customer.nic"));
                v.add(rs.getString("customer.contact_number"));
                v.add(rs.getString("city.name"));
                v.add(rs.getString("customer.address"));
                v.add(rs.getString("gender.name"));
                v.add(rs.getString("customer.dob"));

                dtm.addRow(v);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void resetFields() {

        jLabel4.setText("");
        jLabel14.setText("");
        jLabel6.setText("");
        jLabel12.setText("");
        jLabel8.setText("");
        jLabel10.setText("");

        jTextField1.setBorder(new MatteBorder(1, 1, 1, 1, Color.WHITE));
        jTextField2.setBorder(new MatteBorder(1, 1, 1, 1, Color.WHITE));
        jTextField5.setBorder(new MatteBorder(1, 1, 1, 1, Color.WHITE));
        jTextField4.setBorder(new MatteBorder(1, 1, 1, 1, Color.WHITE));
        jComboBox1.setBorder(null);
        jComboBox2.setBorder(null);
        jDateChooser1.setDate(null);

        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField5.setText("");
        jTextField4.setText("");
        jComboBox1.setSelectedIndex(0);
        jComboBox2.setSelectedIndex(0);

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

    public void loadGender() {

        try {
            ResultSet rs = MySQL.search("SELECT * FROM `gender`");

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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kGradientPanel1 = new keeptoo.KGradientPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        kButton1 = new com.k33ptoo.components.KButton();
        jLabel2 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel17 = new javax.swing.JLabel();

        kGradientPanel1.setBackground(new java.awt.Color(204, 182, 183));
        kGradientPanel1.setkEndColor(new java.awt.Color(172, 171, 171));
        kGradientPanel1.setkGradientFocus(600);
        kGradientPanel1.setkStartColor(new java.awt.Color(172, 171, 171));
        kGradientPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("<html><u>Customer Registration</u></html>");
        kGradientPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 10, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_User_Menu_Female_128px.png"))); // NOI18N
        kGradientPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 50, 115, 96));

        jTable1.setBackground(new java.awt.Color(204, 204, 255));
        jTable1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Name", "Nic", "Contact No", "City", "Address", "gender", "Dob"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setSelectionBackground(new java.awt.Color(204, 255, 204));
        jTable1.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        kGradientPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 540, 1640, 450));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setText("Search :");
        kGradientPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 500, -1, -1));

        jTextField3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField3KeyReleased(evt);
            }
        });
        kGradientPanel1.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 500, 400, -1));

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Name :");

        jTextField1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        jTextField1.setOpaque(false);
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 51, 51));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Nic / Pass Port No :");

        jTextField2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        jTextField2.setOpaque(false);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 51, 51));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Contact Number :");

        jTextField5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField5.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        jTextField5.setOpaque(false);
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });
        jTextField5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField5KeyTyped(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 51, 51));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Address :");

        jTextField4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField4.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        jTextField4.setOpaque(false);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 51, 51));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("City :");

        jComboBox1.setBackground(new java.awt.Color(153, 153, 255));
        jComboBox1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 51, 51));

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_add_30px.png"))); // NOI18N
        jButton4.setToolTipText("");
        jButton4.setContentAreaFilled(false);
        jButton4.setFocusable(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Gender :");

        jComboBox2.setBackground(new java.awt.Color(153, 153, 255));
        jComboBox2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 51, 51));

        kButton1.setForeground(new java.awt.Color(0, 0, 0));
        kButton1.setText("Add New Custmer");
        kButton1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        kButton1.setkBorderRadius(30);
        kButton1.setkEndColor(new java.awt.Color(102, 102, 102));
        kButton1.setkForeGround(new java.awt.Color(0, 0, 0));
        kButton1.setkHoverEndColor(new java.awt.Color(204, 204, 255));
        kButton1.setkHoverForeGround(new java.awt.Color(0, 0, 0));
        kButton1.setkHoverStartColor(new java.awt.Color(204, 204, 255));
        kButton1.setkStartColor(new java.awt.Color(102, 102, 102));
        kButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Dob :");

        jDateChooser1.setDateFormatString("yyyy-MM-dd");
        jDateChooser1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 51, 51));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(99, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(81, 81, 81)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(78, 78, 78)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jComboBox2, 0, 141, Short.MAX_VALUE))
                                    .addComponent(jLabel13))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel2)
                                    .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(kButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(134, 134, 134)))
                .addGap(160, 160, 160))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addGap(8, 8, 8)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14)
                                .addComponent(jLabel5)
                                .addGap(8, 8, 8)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(8, 8, 8)
                                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14)
                                .addComponent(jLabel9)
                                .addGap(8, 8, 8)
                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(38, 38, 38))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(8, 8, 8)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(4, 4, 4)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel13)
                                            .addComponent(jLabel2))
                                        .addGap(7, 7, 7)
                                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jDateChooser1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(6, 6, 6)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)))
                .addComponent(kButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        kGradientPanel1.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 160, 1150, 320));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1656, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jTextField5KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField5KeyTyped
        String mobile = jTextField5.getText();
        String text = mobile + evt.getKeyChar();

        if (text.length() == 1) {
            if (!text.equals("0")) {
                evt.consume();
            }
        } else if (text.length() == 2) {
            if (!text.equals("07")) {
                evt.consume();
            }

        } else if (text.length() == 3) {
            if (!Pattern.compile("07[012345678]").matcher(text).matches()) {
                evt.consume();
            }
        } else if (text.length() <= 10) {
            if (!Pattern.compile("07[012345678][0-9]+").matcher(text).matches()) {
                evt.consume();
            }

        } else {
            evt.consume();

        }
    }//GEN-LAST:event_jTextField5KeyTyped

    private void kButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton1ActionPerformed

        String name = jTextField1.getText();
        String nic = jTextField2.getText();
        String mobile = jTextField5.getText();
        String address = jTextField4.getText();
        Date dob = jDateChooser1.getDate();
        String city = jComboBox1.getSelectedItem().toString();
        String gender = jComboBox2.getSelectedItem().toString();

        if (name.isEmpty()) {
            //           JOptionPane.showMessageDialog(this, "Please Select User", "Warning", JOptionPane.WARNING_MESSAGE);

            jTextField1.setBorder(new MatteBorder(2, 2, 2, 2, Color.RED));
            jLabel4.setText("Please Enter  Name");

            jLabel6.setText("");
            jLabel12.setText("");
            jLabel8.setText("");
            jLabel10.setText("");
            jLabel14.setText("");

            jTextField2.setBorder(new MatteBorder(1, 1, 1, 1, Color.WHITE));
            jTextField5.setBorder(new MatteBorder(1, 1, 1, 1, Color.WHITE));
            jTextField4.setBorder(new MatteBorder(1, 1, 1, 1, Color.WHITE));
            jLabel17.setText("");
            jDateChooser1.setBorder(null);
            jComboBox1.setBorder(null);
            jComboBox2.setBorder(null);

        } else if (nic.isEmpty()) {
            //     JOptionPane.showMessageDialog(this, "Please Enter nic Number", "Warning", JOptionPane.WARNING_MESSAGE);

            jLabel6.setText("Please Enter  Nic Number");
            jTextField2.setBorder(new MatteBorder(2, 2, 2, 2, Color.RED));

            jLabel4.setText("");
            jLabel12.setText("");
            jLabel8.setText("");
            jLabel10.setText("");
            jLabel14.setText("");

            jLabel17.setText("");
            jDateChooser1.setBorder(null);
            jTextField1.setBorder(new MatteBorder(1, 1, 1, 1, Color.WHITE));
            jTextField5.setBorder(new MatteBorder(1, 1, 1, 1, Color.WHITE));
            jTextField4.setBorder(new MatteBorder(1, 1, 1, 1, Color.WHITE));
            jComboBox1.setBorder(null);
            jComboBox2.setBorder(null);

        } else if (mobile.isEmpty()) {
            //      JOptionPane.showMessageDialog(this, "Please Select Type", "Warning", JOptionPane.WARNING_MESSAGE);

            jLabel12.setText("Please Enter  Mobile Number");
            jTextField5.setBorder(new MatteBorder(2, 2, 2, 2, Color.RED));

            jLabel4.setText("");
            jLabel6.setText("");
            jLabel8.setText("");
            jLabel10.setText("");
            jLabel14.setText("");

            jLabel17.setText("");
            jDateChooser1.setBorder(null);
            jTextField1.setBorder(new MatteBorder(1, 1, 1, 1, Color.WHITE));
            jTextField2.setBorder(new MatteBorder(1, 1, 1, 1, Color.WHITE));
            jTextField4.setBorder(new MatteBorder(1, 1, 1, 1, Color.WHITE));
            jComboBox1.setBorder(null);
            jComboBox2.setBorder(null);

        } else if (address.isEmpty()) {
            //        JOptionPane.showMessageDialog(this, "Please Enter Your Address", "Warning", JOptionPane.WARNING_MESSAGE);

            jLabel8.setText("Please Enter Address");
            jTextField4.setBorder(new MatteBorder(2, 2, 2, 2, Color.RED));

            jLabel4.setText("");
            jLabel6.setText("");
            jLabel12.setText("");
            jLabel10.setText("");
            jLabel14.setText("");

            jLabel17.setText("");
            jDateChooser1.setBorder(null);
            jTextField1.setBorder(new MatteBorder(1, 1, 1, 1, Color.WHITE));
            jTextField2.setBorder(new MatteBorder(1, 1, 1, 1, Color.WHITE));
            jTextField5.setBorder(new MatteBorder(1, 1, 1, 1, Color.WHITE));

            jComboBox1.setBorder(null);
            jComboBox2.setBorder(null);

        } else if (city.equals("Select")) {
            //    JOptionPane.showMessageDialog(this, "Please Select City", "Warning", JOptionPane.WARNING_MESSAGE);

            jLabel10.setText("Please Select City");
            jComboBox1.setBorder(new MatteBorder(2, 2, 2, 2, Color.RED));

            jLabel4.setText("");
            jLabel6.setText("");
            jLabel12.setText("");
            jLabel8.setText("");
            jLabel14.setText("");

            jLabel17.setText("");
            jDateChooser1.setBorder(null);
            jTextField1.setBorder(new MatteBorder(1, 1, 1, 1, Color.WHITE));
            jTextField2.setBorder(new MatteBorder(1, 1, 1, 1, Color.WHITE));
            jTextField5.setBorder(new MatteBorder(1, 1, 1, 1, Color.WHITE));
            jTextField4.setBorder(new MatteBorder(1, 1, 1, 1, Color.WHITE));

            jComboBox2.setBorder(null);

        } else if (gender.equals("Select")) {
            //       JOptionPane.showMessageDialog(this, "Please Select gender", "Warning", JOptionPane.WARNING_MESSAGE);

            jLabel14.setText("Please Select gender");
            jComboBox2.setBorder(new MatteBorder(2, 2, 2, 2, Color.RED));

            jLabel4.setText("");
            jLabel6.setText("");
            jLabel12.setText("");
            jLabel8.setText("");
            jLabel10.setText("");

            jLabel17.setText("");
            jDateChooser1.setBorder(null);
            jTextField1.setBorder(new MatteBorder(1, 1, 1, 1, Color.WHITE));
            jTextField2.setBorder(new MatteBorder(1, 1, 1, 1, Color.WHITE));
            jTextField5.setBorder(new MatteBorder(1, 1, 1, 1, Color.WHITE));
            jTextField4.setBorder(new MatteBorder(1, 1, 1, 1, Color.WHITE));
            jComboBox1.setBorder(null);

        } else if (dob == null) {
            //     JOptionPane.showMessageDialog(this, "Please Enter nic Number", "Warning", JOptionPane.WARNING_MESSAGE);

            jLabel17.setText("Please Select Your Birthaday");
            jDateChooser1.setBorder(new MatteBorder(2, 2, 2, 2, Color.RED));

            jLabel4.setText("");
            jLabel12.setText("");
            jLabel8.setText("");
            jLabel10.setText("");
            jLabel14.setText("");
            jLabel6.setText("");

            jTextField1.setBorder(new MatteBorder(1, 1, 1, 1, Color.WHITE));
            jTextField5.setBorder(new MatteBorder(1, 1, 1, 1, Color.WHITE));
            jTextField2.setBorder(new MatteBorder(1, 1, 1, 1, Color.WHITE));
            jTextField4.setBorder(new MatteBorder(1, 1, 1, 1, Color.WHITE));
            jComboBox1.setBorder(null);
            jComboBox2.setBorder(null);

        } else {

            try {

                //                ResultSet rs1 = MySQL.search("SELECT `id` FROM `user_login` WHERE `name` = '" + name + "' AND `username` = '" + uname + "' AND `contact_no` =  '" + mobile + "'");
                //                rs1.next();
                //
                //                String uid = rs1.getString("id");
                //                ResultSet rs2 = MySQL.search("SELECT `id` FROM `user_type` WHERE `name`='" + type + "'");
                //                rs2.next();
                //
                //                String type_id = rs2.getString("id");
                ResultSet rs3 = MySQL.search("SELECT `id` FROM `city` WHERE `name`='" + city + "'");
                rs3.next();

                String city_id = rs3.getString("id");

                ResultSet rs4 = MySQL.search("SELECT `id` FROM `gender` WHERE `name`='" + gender + "'");
                rs4.next();

                String gender_id = rs4.getString("id");

                MySQL.iud("INSERT INTO `customer` (`name`,`contact_number`,`city_id`,`address`,`nic`,`gender_id`,`dob`)  VALUES ('" + name + "','" + mobile + "','" + city_id + "','" + address + "','" + nic + "','" + gender_id + "','" + sdf.format(dob) + "')");

                resetFields();
                loadCustomer();

                JOptionPane.showMessageDialog(this, "Successfully added a new employee", "Success", JOptionPane.INFORMATION_MESSAGE);

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {

    }//GEN-LAST:event_kButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

        if (evt.getClickCount() == 2) {
            int r = jTable1.getSelectedRow();

            //         String pid = jTable1.getValueAt(r, 0).toString();
            String id = jTable1.getValueAt(r, 0).toString();
            String name = jTable1.getValueAt(r, 1).toString();
            String mobile = jTable1.getValueAt(r, 3).toString();
            String city = jTable1.getValueAt(r, 4).toString();
            
                try {
             ResultSet db = MySQL.search("SELECT dob,CONCAT(FLOOR((TIMESTAMPDIFF(MONTH, dob, CURDATE()) / 12)), ' YEARS') AS age FROM customer WHERE `id`='" + id + "'");
                        db.next();
                        
                        String dob = db.getString("age");

            //        grn.jLabel10.setText(pid);
            i.jLabel9.setText(id);
            i.jLabel4.setText(name);
            i.jLabel6.setText(mobile);
            i.jLabel8.setText(city);
             i.jLabel19.setText(dob);

            i.kButton1.setkStartColor(new Color(153, 153, 153));
            i.kButton1.setkEndColor(new Color(153, 153, 153));
            i.kButton1.setText("Update Customer");
            i.kButton1.setEnabled(false);

            i.jTextField1.grabFocus();
            
             } catch (Exception e) {
                        e.printStackTrace();
                    }

            Home home = (Home) SwingUtilities.getWindowAncestor(this);

            home.jPanel2.removeAll();
            home.jPanel2.add(i);
            home.jPanel2.revalidate();
            home.jPanel2.repaint();

        }

    }//GEN-LAST:event_jTable1MouseClicked

    private void jTextField3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyReleased
        String text = jTextField3.getText();
        loadCustomer(text);
    }//GEN-LAST:event_jTextField3KeyReleased

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        //        ImageIcon icon = new ImageIcon("/C:/Users/sandu/OneDrive/Documents/NetBeansProjects/Pharmacy_System/build/classes/img/icons8_remove_image_128px_1.png");
        //        jLabel2.setIcon(icon);
        //        BrandRegistration br = new BrandRegistration(this);
        //        br.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private com.k33ptoo.components.KButton kButton1;
    private keeptoo.KGradientPanel kGradientPanel1;
    // End of variables declaration//GEN-END:variables
}
