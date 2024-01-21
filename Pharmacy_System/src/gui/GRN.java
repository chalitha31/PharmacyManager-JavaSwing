/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.mysql.cj.protocol.Warning;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.io.InputStream;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Vector;
import java.util.regex.Pattern;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import model.GrnReport;
import model.MySQL;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author chalitha
 */
public class GRN extends javax.swing.JPanel {

    Home h;
    Dashboard d;
    SupplierRegistration s;

    DecimalFormat df = new DecimalFormat("0.00");
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    double Totalold_bill = 0;

    int rowcon = 0;

    int m = 1;

    String sid;

    public GRN() {
        initComponents();
        loadPaymentType();

    }

    public GRN(Dashboard d) {
        initComponents();
        loadPaymentType();
        this.d = d;

    }

    public GRN(SupplierRegistration s) {
        initComponents();
        loadPaymentType();

        this.s = s;
    }

    public GRN(Home h) {
        initComponents();
        loadPaymentType();

        this.h = h;
    }

    public void UpdateTotal() {

        double total = 0;

        for (int i = 0; i < jTable1.getRowCount(); i++) {
            String t = jTable1.getValueAt(i, 10).toString();
            total = total + Double.parseDouble(t);
        }

        jLabel25.setText(df.format(total));

    }

    public void balance() {
        try {

            ResultSet rg = MySQL.search("SELECT * FROM `grn` WHERE `supplier_id` = '" + sid + "' ");
            while (rg.next()) {

                String grnid = rg.getString("id");

                ResultSet r0 = MySQL.search("SELECT * FROM `grn_payment` WHERE `grn_id` = '" + grnid + "' ");

                while (r0.next()) {

                    int old_bill = (int) r0.getLong("balance");

                    Totalold_bill = Totalold_bill + old_bill;

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void loadPaymentType() {

        try {
            ResultSet rs = MySQL.search("SELECT * FROM `payment_type`");

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

    public void resetField() {

        jLabel12.setText("None");
        jLabel18.setText("None");
        jLabel14.setText("None");
        jLabel15.setText("None");

        jTextField4.setText("");
        jTextField2.setText("");
        jTextField1.setText("");

        jLabel29.setText("");
        jTextField4.setBorder(null);

        jPanel1.setBorder(new TitledBorder(new MatteBorder(3, 3, 3, 3, Color.BLACK), "Supplier", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.TOP));
        jButton1.setBorder(new MatteBorder(2, 2, 2, 2, new Color(51, 103, 218)));
        jPanel2.setBorder(new TitledBorder(new MatteBorder(3, 3, 3, 3, Color.BLACK), "Product", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.TOP));
        jButton2.setBorder(new MatteBorder(2, 2, 2, 2, new Color(51, 103, 218)));
        jLabel10.setText("");
        jTextField1.setBorder(null);
        jLabel19.setText("");
        jTextField2.setBorder(null);

        jLabel30.setText("");
        jDateChooser1.setBorder(null);
        jLabel31.setText("");
        jDateChooser2.setBorder(null);
        jDateChooser1.setDate(null);
        jDateChooser2.setDate(null);

        jButton2.setEnabled(true);
        jButton2.setBackground(new Color(204, 204, 255));

        jButton2.setText("Select Product");

        jTextField1.grabFocus();

    }

    class tableRendere implements TableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

            TableColumn tb = jTable1.getColumn("img");
            tb.setMaxWidth(40);
            jTable1.setRowHeight(40);
            return (Component) value;
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

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel30 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jLabel31 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        kButton2 = new com.k33ptoo.components.KButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel24 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        kButton4 = new com.k33ptoo.components.KButton();

        setBackground(new java.awt.Color(204, 204, 204));
        setPreferredSize(new java.awt.Dimension(1677, 1000));

        jPanel1.setBackground(new java.awt.Color(153, 163, 177));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 0, 0)), "Supplier", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 13))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Name                     :");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("None");
        jLabel4.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("None");
        jLabel6.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Contact Number  :");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Branch                  :");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("None");
        jLabel8.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));

        jButton1.setBackground(new java.awt.Color(204, 204, 255));
        jButton1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton1.setText("Select Supplier");
        jButton1.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(51, 103, 218)));
        jButton1.setContentAreaFilled(false);
        jButton1.setOpaque(true);
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 543, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(45, 45, 45))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("<html><u>GRN</u></html>");

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 0, 0)), "Supplier", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 13))); // NOI18N

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Name      :");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("None");
        jLabel12.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("None");
        jLabel18.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Brand      :");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Category :");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("None");
        jLabel14.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));

        jButton2.setBackground(new java.awt.Color(204, 204, 255));
        jButton2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton2.setText("Select Product");
        jButton2.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(51, 103, 218)));
        jButton2.setContentAreaFilled(false);
        jButton2.setOpaque(true);
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18))
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(153, 163, 177));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 0, 0)), "Supplier", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 13))); // NOI18N

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel15.setText("Quantity");

        jTextField1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextField1.setBorder(null);
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(153, 0, 0));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel16.setText("Buying Price");

        jTextField2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextField2.setBorder(null);
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField2KeyTyped(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(153, 0, 0));

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel23.setText("Selling Price");

        jTextField4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextField4.setBorder(null);
        jTextField4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField4KeyTyped(evt);
            }
        });

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(153, 0, 0));

        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel27.setText("MFD");

        jDateChooser1.setDateFormatString("yyyy-MM-dd");
        jDateChooser1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(153, 0, 0));

        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel28.setText("EXD");

        jDateChooser2.setDateFormatString("yyyy-MM-dd");
        jDateChooser2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(153, 0, 0));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_sync_64px_1.png"))); // NOI18N
        jButton3.setContentAreaFilled(false);
        jButton3.setFocusable(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                    .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(57, 57, 57)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                    .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel23)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                            .addGap(124, 124, 124)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addGap(4, 4, 4)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addGap(4, 4, 4)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel27)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(4, 4, 4)
                        .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel28)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        kButton2.setText("Add  to GRN");
        kButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        kButton2.setkBorderRadius(13);
        kButton2.setkEndColor(new java.awt.Color(0, 153, 153));
        kButton2.setkHoverColor(new java.awt.Color(0, 0, 0));
        kButton2.setkHoverEndColor(new java.awt.Color(255, 153, 153));
        kButton2.setkHoverForeGround(new java.awt.Color(0, 0, 0));
        kButton2.setkHoverStartColor(new java.awt.Color(255, 153, 153));
        kButton2.setkStartColor(new java.awt.Color(0, 186, 140));
        kButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton2ActionPerformed(evt);
            }
        });

        jTable1.setBackground(new java.awt.Color(204, 204, 255));
        jTable1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "img", "id", "Product Name", "Brand", "Supplier Name", "Quantity", "Buying Price", "Selling Price", "MFD", "EXD", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setSelectionBackground(new java.awt.Color(255, 204, 204));
        jTable1.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(jTable1);

        jButton4.setBackground(new java.awt.Color(255, 102, 102));
        jButton4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton4.setText("Remove ");
        jButton4.setContentAreaFilled(false);
        jButton4.setOpaque(true);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(153, 153, 153));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel20.setText("Total Payment");

        jLabel25.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel25.setText("0.00");
        jLabel25.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel21.setText("Payment Method");

        jComboBox1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jComboBox1.setBorder(null);
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel24.setText("Balance");

        jLabel26.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel26.setText("0.00");
        jLabel26.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));

        jTextField3.setEditable(false);
        jTextField3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextField3.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.gray));
        jTextField3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField3KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField3KeyTyped(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel22.setText("Payment");

        kButton4.setText("Print GRN");
        kButton4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        kButton4.setkBorderRadius(32);
        kButton4.setkEndColor(new java.awt.Color(0, 153, 153));
        kButton4.setkHoverEndColor(new java.awt.Color(153, 153, 255));
        kButton4.setkHoverForeGround(new java.awt.Color(0, 0, 0));
        kButton4.setkHoverStartColor(new java.awt.Color(153, 153, 255));
        kButton4.setkStartColor(new java.awt.Color(0, 204, 153));
        kButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21)
                    .addComponent(jLabel20))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(32, 32, 32)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22)
                    .addComponent(jLabel24))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jTextField3)
                        .addGap(2, 2, 2)))
                .addGap(207, 207, 207)
                .addComponent(kButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel20)
                                .addComponent(jLabel25)
                                .addComponent(jLabel22)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel24)
                            .addComponent(jLabel26)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(kButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(797, 797, 797)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(375, 375, 375)
                                .addComponent(kButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 875, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButton4)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 572, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(6, 6, 6)))))
                        .addGap(0, 20, Short.MAX_VALUE))
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(kButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyTyped
        // TODO add your handling code here:
        String qty = jTextField1.getText();
        String text = qty + evt.getKeyChar();

        if (!Pattern.compile("[1-9][0-9]*").matcher(text).matches()) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField1KeyTyped

    private void jTextField2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyTyped
        // TODO add your handling code here:
        String price = jTextField2.getText();
        String text = price + evt.getKeyChar();

        if (!Pattern.compile("(0|0[.]|0[.][0-9]{0,2})|([1-9][0-9]*[.]?[0-9]{0,2})").matcher(text).matches()) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField2KeyTyped

    private void jTextField4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField4KeyTyped
        // TODO add your handling code here:
        String price = jTextField4.getText();
        String text = price + evt.getKeyChar();

        if (!Pattern.compile("(0|0[.]|0[.][0-9]{0,2})|([1-9][0-9]*[.]?[0-9]{0,2})").matcher(text).matches()) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField4KeyTyped

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        resetField();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void kButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton2ActionPerformed

        String sname = jLabel4.getText();
        String smobil = jLabel6.getText();
        String sbranch = jLabel8.getText();

        String pname = jLabel12.getText();
        String pbrand = jLabel18.getText();
        String pcategory = jLabel14.getText();

        String qty = jTextField1.getText();
        String buyingPrice = jTextField2.getText();

        //update
        String selling_price = jTextField4.getText();
        Date mfd = jDateChooser1.getDate();
        Date exd = jDateChooser2.getDate();

        //update
        if (sname.equals("None")) {
            JOptionPane.showMessageDialog(this, "Please Select Supplier", "Warning", JOptionPane.WARNING_MESSAGE);

            jPanel1.setBorder(new TitledBorder(new MatteBorder(3, 3, 3, 3, Color.RED), "Supplier", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.TOP));
            jButton1.setBorder(new MatteBorder(3, 3, 3, 3, Color.RED));

//            jPanel2.setBorder(new TitledBorder(new MatteBorder(3, 3, 3, 3, Color.YELLOW), "Product", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.TOP));
//            jButton2.setBorder(new MatteBorder(2, 2, 2, 2, new Color(102, 102, 255)));
            jPanel2.setBorder(new TitledBorder(new MatteBorder(3, 3, 3, 3, Color.BLACK), "Product", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.TOP));
            jButton2.setBorder(new MatteBorder(2, 2, 2, 2, new Color(51, 103, 218)));

            jLabel10.setText("");
            jTextField1.setBorder(null);
            jLabel19.setText("");
            jTextField2.setBorder(null);
            jLabel29.setText("");
            jTextField4.setBorder(null);
            jLabel30.setText("");
            jDateChooser1.setBorder(null);
            jLabel31.setText("");
            jDateChooser2.setBorder(null);

        } else if (pname.equals("None")) {
            JOptionPane.showMessageDialog(this, "Please Select Product", "Warning", JOptionPane.WARNING_MESSAGE);

            jPanel2.setBorder(new TitledBorder(new MatteBorder(3, 3, 3, 3, Color.RED), "Product", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.TOP));
            jButton2.setBorder(new MatteBorder(3, 3, 3, 3, Color.RED));

            jPanel1.setBorder(new TitledBorder(new MatteBorder(3, 3, 3, 3, Color.BLACK), "Supplier", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.TOP));
            jButton1.setBorder(new MatteBorder(2, 2, 2, 2, new Color(51, 103, 218)));

            jLabel10.setText("");
            jTextField1.setBorder(null);
            jLabel19.setText("");
            jTextField2.setBorder(null);
            jLabel29.setText("");
            jTextField4.setBorder(null);
            jLabel30.setText("");
            jDateChooser1.setBorder(null);
            jLabel31.setText("");
            jDateChooser2.setBorder(null);

        } else if (!Pattern.compile("[1-9][0-9]*").matcher(qty).matches()) {

            //        JOptionPane.showMessageDialog(this, "Invalid Quantity", "Warning", JOptionPane.WARNING_MESSAGE);
            jLabel10.setText("Invalid Quantity");
            jTextField1.setBorder(new MatteBorder(2, 2, 2, 2, Color.RED));

            jPanel1.setBorder(new TitledBorder(new MatteBorder(3, 3, 3, 3, Color.BLACK), "Supplier", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.TOP));
            jButton1.setBorder(new MatteBorder(2, 2, 2, 2, new Color(51, 103, 218)));
            jPanel2.setBorder(new TitledBorder(new MatteBorder(3, 3, 3, 3, Color.BLACK), "Product", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.TOP));
            jButton2.setBorder(new MatteBorder(2, 2, 2, 2, new Color(51, 103, 218)));

            jLabel19.setText("");
            jTextField2.setBorder(null);
            jLabel29.setText("");
            jTextField4.setBorder(null);
            jLabel30.setText("");
            jDateChooser1.setBorder(null);
            jLabel31.setText("");
            jDateChooser2.setBorder(null);

        } else if (!Pattern.compile("([1-9][0-9]*)|(([1-9][0-9]*)[.]([0]*[1-9][0-9]*))|([0][.]([0]*[1-9][0-9]*))").matcher(buyingPrice).matches()) {
            //      JOptionPane.showMessageDialog(this, "Invalid Buying Price", "Warning", JOptionPane.WARNING_MESSAGE);

            jLabel19.setText("Invalid Buying Price");
            jTextField2.setBorder(new MatteBorder(2, 2, 2, 2, Color.RED));

            jPanel1.setBorder(new TitledBorder(new MatteBorder(3, 3, 3, 3, Color.BLACK), "Supplier", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.TOP));
            jButton1.setBorder(new MatteBorder(2, 2, 2, 2, new Color(51, 103, 218)));
            jPanel2.setBorder(new TitledBorder(new MatteBorder(3, 3, 3, 3, Color.BLACK), "Product", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.TOP));
            jButton2.setBorder(new MatteBorder(2, 2, 2, 2, new Color(51, 103, 218)));
            jLabel10.setText("");
            jTextField1.setBorder(null);

            jLabel29.setText("");
            jTextField4.setBorder(null);
            jLabel30.setText("");
            jDateChooser1.setBorder(null);
            jLabel31.setText("");
            jDateChooser2.setBorder(null);

            //update
        } else if (!Pattern.compile("([1-9][0-9]*)|(([1-9][0-9]*)[.]([0]*[1-9][0-9]*))|([0][.]([0]*[1-9][0-9]*))").matcher(selling_price).matches()) {
            //      JOptionPane.showMessageDialog(this, "Invalid Selling Price", "Warning", JOptionPane.WARNING_MESSAGE);

            jLabel29.setText("Invalid Selling Price");
            jTextField4.setBorder(new MatteBorder(2, 2, 2, 2, Color.RED));

            jPanel1.setBorder(new TitledBorder(new MatteBorder(3, 3, 3, 3, Color.BLACK), "Supplier", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.TOP));
            jButton1.setBorder(new MatteBorder(2, 2, 2, 2, new Color(51, 103, 218)));
            jPanel2.setBorder(new TitledBorder(new MatteBorder(3, 3, 3, 3, Color.BLACK), "Product", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.TOP));
            jButton2.setBorder(new MatteBorder(2, 2, 2, 2, new Color(51, 103, 218)));
            jLabel10.setText("");
            jTextField1.setBorder(null);
            jLabel19.setText("");
            jTextField2.setBorder(null);

            jLabel30.setText("");
            jDateChooser1.setBorder(null);
            jLabel31.setText("");
            jDateChooser2.setBorder(null);

        } else if (Double.parseDouble(buyingPrice) >= Double.parseDouble(selling_price)) {
            JOptionPane.showMessageDialog(this, "Invalid Selling Price & Buying Price", "Warning", JOptionPane.WARNING_MESSAGE);

            jLabel29.setText("Invalid Selling Price & Buying Price");

            jPanel1.setBorder(new TitledBorder(new MatteBorder(3, 3, 3, 3, Color.BLACK), "Supplier", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.TOP));
            jButton1.setBorder(new MatteBorder(2, 2, 2, 2, new Color(51, 103, 218)));
            jPanel2.setBorder(new TitledBorder(new MatteBorder(3, 3, 3, 3, Color.BLACK), "Product", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.TOP));
            jButton2.setBorder(new MatteBorder(2, 2, 2, 2, new Color(51, 103, 218)));
            jLabel10.setText("");
            jTextField1.setBorder(null);
            jLabel19.setText("");
            jTextField2.setBorder(null);

            jLabel30.setText("");
            jDateChooser1.setBorder(null);
            jLabel31.setText("");
            jDateChooser2.setBorder(null);

        } else if (mfd == null) {
            //        JOptionPane.showMessageDialog(this, "Invalid MFD", "Warning", JOptionPane.WARNING_MESSAGE);

            jLabel30.setText("Invalid MFD");
            jDateChooser1.setBorder(new MatteBorder(2, 2, 2, 2, Color.RED));

            jPanel1.setBorder(new TitledBorder(new MatteBorder(3, 3, 3, 3, Color.BLACK), "Supplier", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.TOP));
            jButton1.setBorder(new MatteBorder(2, 2, 2, 2, new Color(51, 103, 218)));
            jPanel2.setBorder(new TitledBorder(new MatteBorder(3, 3, 3, 3, Color.BLACK), "Product", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.TOP));
            jButton2.setBorder(new MatteBorder(2, 2, 2, 2, new Color(51, 103, 218)));
            jLabel10.setText("");
            jTextField1.setBorder(null);
            jLabel19.setText("");
            jTextField2.setBorder(null);
            jLabel29.setText("");
            jTextField4.setBorder(null);

            jLabel31.setText("");
            jDateChooser2.setBorder(null);

        } else if (mfd.after(new Date())) {
            JOptionPane.showMessageDialog(this, "Invalid MFD", "Warning", JOptionPane.WARNING_MESSAGE);

            jLabel30.setText("Invalid MFD");
            //         jDateChooser1.setBorder(new MatteBorder(2, 2, 2, 2, Color.RED));

            jPanel1.setBorder(new TitledBorder(new MatteBorder(3, 3, 3, 3, Color.BLACK), "Supplier", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.TOP));
            jButton1.setBorder(new MatteBorder(2, 2, 2, 2, new Color(51, 103, 218)));
            jPanel2.setBorder(new TitledBorder(new MatteBorder(3, 3, 3, 3, Color.BLACK), "Product", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.TOP));
            jButton2.setBorder(new MatteBorder(2, 2, 2, 2, new Color(51, 103, 218)));
            jLabel10.setText("");
            jTextField1.setBorder(null);
            jLabel19.setText("");
            jTextField2.setBorder(null);
            jLabel29.setText("");
            jTextField4.setBorder(null);

            jLabel31.setText("");
            jDateChooser2.setBorder(null);

        } else if (exd == null) {
            //      JOptionPane.showMessageDialog(this, "Invalid EXD", "Warning", JOptionPane.WARNING_MESSAGE);

            jLabel31.setText("Invalid EXD");
            jDateChooser2.setBorder(new MatteBorder(2, 2, 2, 2, Color.RED));

            jPanel1.setBorder(new TitledBorder(new MatteBorder(3, 3, 3, 3, Color.BLACK), "Supplier", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.TOP));
            jButton1.setBorder(new MatteBorder(2, 2, 2, 2, new Color(51, 103, 218)));
            jPanel2.setBorder(new TitledBorder(new MatteBorder(3, 3, 3, 3, Color.BLACK), "Product", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.TOP));
            jButton2.setBorder(new MatteBorder(2, 2, 2, 2, new Color(51, 103, 218)));
            jLabel10.setText("");
            jTextField1.setBorder(null);
            jLabel19.setText("");
            jTextField2.setBorder(null);
            jLabel29.setText("");
            jTextField4.setBorder(null);
            jLabel30.setText("");
            jDateChooser1.setBorder(null);

        } else if (exd.before(new Date())) {
            JOptionPane.showMessageDialog(this, "Invalid EXD", "Warning", JOptionPane.WARNING_MESSAGE);

            jLabel31.setText("Invalid EXD");
            //      jDateChooser2.setBorder(new MatteBorder(2, 2, 2, 2, Color.RED));

            jPanel1.setBorder(new TitledBorder(new MatteBorder(3, 3, 3, 3, Color.BLACK), "Supplier", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.TOP));
            jButton1.setBorder(new MatteBorder(2, 2, 2, 2, new Color(51, 103, 218)));
            jPanel2.setBorder(new TitledBorder(new MatteBorder(3, 3, 3, 3, Color.BLACK), "Product", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.TOP));
            jButton2.setBorder(new MatteBorder(2, 2, 2, 2, new Color(51, 103, 218)));
            jLabel10.setText("");
            jTextField1.setBorder(null);
            jLabel19.setText("");
            jTextField2.setBorder(null);
            jLabel29.setText("");
            jTextField4.setBorder(null);
            jLabel30.setText("");
            jDateChooser1.setBorder(null);

            //update
        } else {

            try {

                //up
                ResultSet r = MySQL.search("SELECT  * FROM `supplier` WHERE `name` = '" + sname + "' AND `contact_no` =  '" + smobil + "' ");
                r.next();

                sid = r.getString("id");
                //up
                ResultSet rs1 = MySQL.search("SELECT  * FROM `product` WHERE `name` = '" + pname + "' AND `category_id` = (SELECT `id` FROM  `category`"
                        + " WHERE `name` = '" + pcategory + "') AND `brand_id` = (SELECT `id` FROM  `brand` WHERE `name` = '" + pbrand + "')");
                rs1.next();

                String pid = rs1.getString("id");

                DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();

                JTableHeader tb = jTable1.getTableHeader();
                tb.setForeground(Color.BLACK);
                tb.setFont(new Font("Tahome", Font.BOLD, 15));

                TableColumn t = jTable1.getColumn("id");
                t.setMaxWidth(80);

                jTable1.setRowHeight(30);

                boolean isFound = false;
                int x = -1;

                for (int i = 0; i < dtm.getRowCount(); i++) {
                    String prname = jTable1.getValueAt(i, 2).toString();
                    String prbrand = jTable1.getValueAt(i, 3).toString();

                    ResultSet rs2 = MySQL.search("SELECT * FROM `product` WHERE `name` = '" + prname + "' AND `brand_id` IN (SELECT `id` FROM `brand` WHERE `name` = '" + prbrand + "' )");
                    rs2.next();
                    String id = rs2.getString("id");

                    if (id.equals(pid)) {
                        isFound = true;
                        x = i;
                        break;
                    }
                }

                if (isFound) {

                    int option = JOptionPane.showConfirmDialog(this, "This product is already added, Do you want to update?", "Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);

                    if (option == JOptionPane.YES_OPTION) {

                        int oldQty = Integer.parseInt(jTable1.getValueAt(x, 5).toString());
                        int finalQty = oldQty + Integer.parseInt(qty);

                        jTable1.setValueAt(String.valueOf(finalQty), x, 5);
                        jTable1.setValueAt(buyingPrice, x, 6);

                        double UpdateItemTotal = finalQty * Double.parseDouble(buyingPrice);
                        jTable1.setValueAt(String.valueOf(UpdateItemTotal), x, 10);

                        UpdateTotal();
                    }

                    resetField();
                } else {

                    ResultSet rs2 = MySQL.search("SELECT * FROM `product` WHERE `name` = '" + pname + "' AND `brand_id` IN (SELECT `id` FROM `brand` WHERE `name` = '" + pbrand + "' )");
                    rs2.next();

                    String img_id = rs2.getString("image_id");

                    ResultSet rimg = MySQL.search("SELECT * FROM `product_img` WHERE `id` = '" + img_id + "'");
                    rimg.next();

                    String imager = rimg.getString("image");

                    jTable1.getColumn("img").setCellRenderer(new tableRendere());

                    ImageIcon imageicon = new ImageIcon(imager);

                    Image Timage = imageicon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);

                    JLabel imglabel = new JLabel();

                    imglabel.setIcon(new ImageIcon(Timage));

                    Vector v = new Vector();
                    v.add(imglabel);
                    v.add(m);
                    v.add(pname);
                    v.add(jLabel18.getText());
                    v.add(jLabel4.getText());
                    v.add(qty);
                    v.add(buyingPrice);

                    v.add(selling_price);
                    v.add(sdf.format(mfd));
                    v.add(sdf.format(exd));

                    double itemtotal = Integer.parseInt(qty) * Double.parseDouble(buyingPrice);
                    v.add(df.format(itemtotal));

                    dtm.addRow(v);

                    UpdateTotal();

                    resetField();
                    rowcon = jTable1.getRowCount();
                    JOptionPane.showMessageDialog(this, "Product Add To GRN", "Success", JOptionPane.INFORMATION_MESSAGE);

                }
                m = m + 1;
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }//GEN-LAST:event_kButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        int selectedRow = jTable1.getSelectedRow();

        if (selectedRow == -1) {

            //            int r = jTable1.getSelectedRow();
            JOptionPane.showMessageDialog(this, "Please Select a grn item", "Warning", JOptionPane.WARNING_MESSAGE);

        } else {

            int option = JOptionPane.showConfirmDialog(this, "Do you want to remove this item", "Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);

            if (option == JOptionPane.YES_OPTION) {

                DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
                dtm.removeRow(selectedRow);

                UpdateTotal();

                //payment
                jLabel25.setText("0.00");
                jTextField3.setText("");
                jTextField3.setEditable(false);
                jComboBox1.setSelectedIndex(0);
                jLabel26.setText("0.00");
                //payment

                rowcon = jTable1.getRowCount();
                JOptionPane.showMessageDialog(this, "GRN item removed", "Succes", JOptionPane.INFORMATION_MESSAGE);

            }
        }

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        // TODO add your handling code here:
        String text = jComboBox1.getSelectedItem().toString();

        if (text.equals("Select")) {
            jTextField3.setEditable(false);
            jTextField3.setText("");
            jLabel26.setText("0.00");
            jLabel26.setForeground(Color.BLACK);

        } else {
            jTextField3.setEditable(true);
        }
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jTextField3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyReleased

        if (jTextField3.getText().isEmpty()) {
            jLabel26.setText("0.00");
            jLabel26.setForeground(Color.BLACK);

        } else {

            String total = jLabel25.getText();
            String payment = jTextField3.getText();

            double balance = Double.parseDouble(payment) - Double.parseDouble(total);

            if (balance < 0) {

                jLabel26.setForeground(Color.RED);

            } else {

                jLabel26.setForeground(Color.GREEN);

            }

            jLabel26.setText(df.format(balance));
        }
    }//GEN-LAST:event_jTextField3KeyReleased

    private void jTextField3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyTyped
        // TODO add your handling code here:

        String price = jTextField3.getText();
        String text = price + evt.getKeyChar();

        if (!Pattern.compile("(0|0[.]|0[.][0-9]{0,2})|([1-9][0-9]*[.]?[0-9]{0,2})").matcher(text).matches()) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField3KeyTyped

    private void kButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton4ActionPerformed

        int r = jTable1.getSelectedRow();

        String paymentType = jComboBox1.getSelectedItem().toString();
        String payment = jTextField3.getText();

        if (jTable1.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "Please add product", "Warning", JOptionPane.WARNING_MESSAGE);
            jTable1.setBorder(new MatteBorder(2, 2, 2, 2, Color.RED));
            jTextField3.setBorder(new MatteBorder(1, 1, 1, 1, Color.DARK_GRAY));
            jComboBox1.setBorder(null);

        } else if (paymentType.equals("Select")) {
            JOptionPane.showMessageDialog(this, "Please Select Payment Methord", "Warning", JOptionPane.WARNING_MESSAGE);
            jTable1.setBorder(null);
            jComboBox1.setBorder(new MatteBorder(2, 2, 2, 2, Color.RED));
            jTextField3.setBorder(new MatteBorder(1, 1, 1, 1, Color.DARK_GRAY));

        } else if (!Pattern.compile("( (0)|[1-9][0-9]*)|(([1-9][0-9]*)[.]([0]*[1-9][0-9]*))|([0][.]([0]*[1-9][0-9]*))").matcher(payment).matches()) {
            JOptionPane.showMessageDialog(this, "Invalid Payment", "Warning", JOptionPane.WARNING_MESSAGE);
            jTable1.setBorder(null);
            jTextField3.setBorder(new MatteBorder(1, 1, 1, 1, Color.RED));
            jComboBox1.setBorder(null);

        } else {

            //GRN payment INSERT
            long mTime = System.currentTimeMillis();

            String uniqueId = mTime + "-" + SignIn.userId;

            SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dNow = sdf2.format(new Date());

            try {

                balance();

                MySQL.iud("INSERT INTO `grn`(`supplier_id`,`date_time`,`user_id`,`unique_id`) VALUES ('" + sid + "','" + dNow + "','" + SignIn.userId + "','" + uniqueId + "')");

                ResultSet rs = MySQL.search("SELECT * FROM `grn` WHERE `unique_id` = '" + uniqueId + "'");
                rs.next();
                String id = rs.getString("id");

                ResultSet rs2 = MySQL.search("SELECT * FROM `payment_type` WHERE `name` = '" + paymentType + "'");
                rs2.next();
                String paymentTypeId = rs2.getString("id");

                String balance = jLabel26.getText();
                String grandtotal = jLabel25.getText();

                MySQL.iud("INSERT INTO `grn_payment` (`grn_id`,`payment_type_id`,`payment`,`balance`) VALUES ('" + id + "','" + paymentTypeId + "','" + payment + "','" + balance + "')");

                Vector v = new Vector();

                //GRN Item INSERT & Stock INSERT or UPDATE
                for (int i = 0; i < jTable1.getRowCount(); i++) {

                    String pname = jTable1.getValueAt(i, 2).toString();
                    String pbrand = jTable1.getValueAt(i, 3).toString();
                    String qty = jTable1.getValueAt(i, 5).toString();
                    String sellingPrice = jTable1.getValueAt(i, 7).toString();
                    String buyingprice = jTable1.getValueAt(i, 6).toString();
                    String mfd = jTable1.getValueAt(i, 8).toString();
                    String exd = jTable1.getValueAt(i, 9).toString();

                    String Tid = jTable1.getValueAt(i, 1).toString();
                    String total = jTable1.getValueAt(i, 10).toString();
                    String sname = jTable1.getValueAt(i, 4).toString();

                    ResultSet s = MySQL.search("SELECT * FROM `supplier` WHERE `id` = '" + sid + "' AND `name` = '" + sname + "'");
                    s.next();

                    String smobile = s.getString("contact_no");
                    String semail = s.getString("email");

                    String b_id = s.getString("company_branch_id");

                    ResultSet b = MySQL.search("SELECT * FROM `company_branch` WHERE `id` = '" + b_id + "' ");
                    b.next();

                    String bname = b.getString("name");
                    String bmobile = b.getString("branch_contact_number");

                    String baddress_id = b.getString("company_branch_address_id");

                    ResultSet br = MySQL.search("SELECT * FROM `company_branch_address` WHERE `id` = '" + baddress_id + "' ");
                    br.next();

                    String baddress = br.getString("address");

                    //grn_id = id
                    //stock_id = ?
                    ResultSet rs5 = MySQL.search("SELECT  * FROM `product` WHERE `name` = '" + pname + "'  AND `brand_id` = (SELECT `id` FROM  `brand` WHERE `name` = '" + pbrand + "')");
                    rs5.next();

                    String pid = rs5.getString("id");

                    ResultSet rs3 = MySQL.search("SELECT * FROM `stock` WHERE `product_id` = '" + pid + "' AND `selling_price` = '" + sellingPrice + "' AND `mfd` = '" + mfd + "' AND `exd` = '" + exd + "'");

                    {
                        String stock_id;

                        if (rs3.next()) {
                            //Update

                            stock_id = rs3.getString("id");
                            String stock_qty = rs3.getString("quantity");

                            int updatedQty = Integer.parseInt(stock_qty) + Integer.parseInt(qty);

                            MySQL.iud("UPDATE `stock` SET `quantity` = '" + updatedQty + "' WHERE `id` = '" + stock_id + "' ");

                            //Update
                        } else {
                            //Insert

                            MySQL.iud("INSERT INTO `stock` (`product_id`,`quantity`,`selling_price`,`mfd`,`exd`) VALUES ('" + pid + "','" + qty + "','" + sellingPrice + "','" + mfd + "','" + exd + "')");

                            ResultSet rs4 = MySQL.search("SELECT * FROM `stock` WHERE `product_id` = '" + pid + "' AND `selling_price` = '" + sellingPrice + "' AND `mfd` = '" + mfd + "' AND `exd` = '" + exd + "'");
                            rs4.next();
                            stock_id = rs4.getString("id");
                        }

                        String OLD_BILL = df.format(Totalold_bill);

                        String paymentf = df.format(Double.parseDouble(payment));

                        GrnReport c = new GrnReport(uniqueId, sname, smobile, semail, bname, bmobile, baddress, id, OLD_BILL, pname, pbrand, qty, buyingprice, mfd, exd, total, paymentf, balance, grandtotal, paymentType, Tid);
                        v.add(c);
                        MySQL.iud("INSERT INTO `grn_item` (`quantity`,`buying_price`,`grn_id`,`stock_id`) VALUES ('" + qty + "','" + buyingprice + "','" + id + "','" + stock_id + "')");

                    }
                }

                // report
                //      String filePath = "src//report//pharmacy.jrxml";
                InputStream filePath = GRN.class.getResourceAsStream("/report/pharmacy.jrxml");

                JasperReport jr = JasperCompileManager.compileReport(filePath);

                HashMap parameters = new HashMap();

                JRBeanCollectionDataSource datasource = new JRBeanCollectionDataSource(v);

                JasperPrint jp = JasperFillManager.fillReport(jr, parameters, datasource);

                JasperViewer.viewReport(jp, false);
                // report

                //supplier
                jButton1.setEnabled(true);
                jButton1.setText("Select Supplier");

                jButton2.setEnabled(true);
                jButton2.setText("Select Product");

                //supplier
                //payment
                jLabel25.setText("0.00");
                jTextField3.setText("");
                jTextField3.setEditable(false);
                jComboBox1.setSelectedIndex(0);
                jLabel26.setText("0.00");
                //payment

                jLabel4.setText("None");
                jLabel6.setText("None");
                jLabel8.setText("None");
                jButton1.setEnabled(true);
                jButton1.setBackground(new Color(204, 204, 255));

                jTextField3.setBorder(new MatteBorder(1, 1, 1, 1, Color.DARK_GRAY));
                jComboBox1.setBorder(null);
                jTable1.setBorder(null);

                resetField();

                DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
                dtm.setRowCount(0);

                Totalold_bill = 0;
                JOptionPane.showMessageDialog(this, "New GRN Created", "Succes", JOptionPane.INFORMATION_MESSAGE);
                rowcon = 0;
                //GRN Item INSERT & Stock INSERT or UPDATE
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }//GEN-LAST:event_kButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        SupplierRegistration sr = new SupplierRegistration(this);

        h.jPanel2.removeAll();
        h.jPanel2.add(sr);
        h.jPanel2.revalidate();
        h.jPanel2.repaint();


    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        ProductRegistration p = new ProductRegistration(this);

        h.jPanel2.removeAll();
        h.jPanel2.add(p);
        h.jPanel2.revalidate();
        h.jPanel2.repaint();

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        if (evt.getClickCount() == 2) {

            if (rowcon > 0) {
                //        JOptionPane.showMessageDialog(this, "Invalid MFD", "Warning", JOptionPane.WARNING_MESSAGE);
                JOptionPane.showMessageDialog(this, "Complete the grn related to this supplier", "Warning", JOptionPane.WARNING_MESSAGE);

            } else {
                jButton1.setEnabled(true);
                jButton1.setBackground(new Color(204, 204, 255));

                jButton1.setText("Select Supplier");

                //       jLabel9.setText("None");
                jLabel4.setText("None");
                jLabel6.setText("None");
                jLabel8.setText("None");
            }

        }
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        if (evt.getClickCount() == 2) {
            jButton2.setEnabled(true);
            jButton2.setBackground(new Color(204, 204, 255));

            jButton2.setText("Select Product");

            //       jLabel9.setText("None");
            jLabel12.setText("None");
            jLabel18.setText("None");
            jLabel14.setText("None");

        }
    }//GEN-LAST:event_jButton2MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton jButton1;
    public javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    public javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    public javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    public javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    public javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    public javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    public javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    public javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private com.k33ptoo.components.KButton kButton2;
    private com.k33ptoo.components.KButton kButton4;
    // End of variables declaration//GEN-END:variables
}
