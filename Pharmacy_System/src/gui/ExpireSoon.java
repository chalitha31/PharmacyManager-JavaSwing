package gui;

import java.awt.Color;
import java.awt.Font;
import java.io.InputStream;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import model.MySQL;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import net.sf.jasperreports.view.JasperViewer;

public class ExpireSoon extends javax.swing.JFrame {

    Home h;

    public ExpireSoon() {
        initComponents();
        ExpireProduct();

    }

    public ExpireSoon(Home h) {
        initComponents();
        ExpireProduct();
        this.h = h;

    }

    public void ExpireProduct() {

        try {
            DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
            dtm.setRowCount(0);

            JTableHeader tb = jTable1.getTableHeader();
            tb.setForeground(Color.BLACK);
            tb.setFont(new Font("Tahome", Font.BOLD, 15));

            TableColumn t = jTable1.getColumn("id");
            t.setMaxWidth(80);

            jTable1.setRowHeight(30);

            ResultSet r = MySQL.search("SELECT * FROM `stock`");

            while (r.next()) {

                String sid = r.getString("id");

                String exdate = r.getString("exd");

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

                String dnow = sdf.format(new Date());

                long lg = ChronoUnit.DAYS.between(LocalDate.parse(dnow), LocalDate.parse(exdate));

                if (lg <= 20 && lg > 5) {

                    ResultSet rs = MySQL.search("SELECT DISTINCT `stock`.`id`,`stock`.`exd`,`category`.`name`,`brand`.`name`,`product`.`name`,`stock`.`quantity`,"
                            + "`grn_item`.`buying_price`,`stock`.`selling_price`,`stock`.`mfd`,`stock`.`exd` FROM `stock`"
                            + " INNER JOIN `grn_item` ON `grn_item`.`stock_id` = `stock`.`id` INNER JOIN `product` ON `stock`.`product_id` =  `product`.`id` INNER JOIN `brand` "
                            + "ON `product`.`brand_id` = `brand`.`id` INNER JOIN  `product_img` ON `product`.`image_id` = `product_img`.`id` "
                            + " INNER JOIN `category` ON `product`.`category_id` = `category`.`id` WHERE `stock`.`id` = '" + sid + "' ORDER BY  `stock`.`id` ASC  "); /// `stock`.`exd` = '" + exdate + "'

                    while (rs.next()) {

                        Vector v = new Vector();

                        v.add(rs.getString("stock.id"));
                        v.add(rs.getString("product.name"));
                        v.add(rs.getString("brand.name"));
                        v.add(rs.getString("category.name"));
                        v.add(rs.getString("stock.quantity"));
                        v.add(rs.getString("grn_item.buying_price"));
                        v.add(rs.getString("stock.selling_price"));
                        v.add(rs.getString("stock.mfd"));
                        v.add(rs.getString("stock.exd"));

                        dtm.addRow(v);

                        jTable1.setModel(dtm);
                    }

                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

//        ResultSet rs = MySQL.search("SELECT DISTINCT `stock`.`id`,`stock`.`exd`,`category`.`name`,`brand`.`name`,`product`.`name`,`stock`.`quantity`,"
//                    + "`grn_item`.`buying_price`,`stock`.`selling_price`,`stock`.`mfd`,`stock`.`exd` FROM `stock` INNER JOIN `grn_item` ON `grn_item`.`stock_id` = `stock`.`id` INNER JOIN `product` ON `stock`.`product_id` =  `product`.`id` INNER JOIN `brand` "
//                    + "ON `product`.`brand_id` = `brand`.`id` INNER JOIN  `product_img` ON `product`.`image_id` = `product_img`.`id` "
//                    + " INNER JOIN `category` ON `product`.`category_id` = `category`.`id` WHERE `stock`.`exd` >= '"+expiredate+"'  ORDER BY  `stock`.`id` ASC ");
//
//             DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
//            dtm.setRowCount(0);
//        
//        while(rs.next()){
//        
//                Vector v = new Vector();
//
//                v.add(rs.getString("stock.id"));
//                v.add(rs.getString("product.name"));
//                v.add(rs.getString("brand.name"));
//                v.add(rs.getString("category.name"));
//                v.add(rs.getString("stock.quantity"));
//                v.add(rs.getString("grn_item.buying_price"));
//                v.add(rs.getString("stock.selling_price"));
//                v.add(rs.getString("stock.mfd"));
//                v.add(rs.getString("stock.exd"));
//
//                dtm.addRow(v);
//            }
//           
//            jTable1.setModel(dtm);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 140, 88));

        jTable1.setBackground(new java.awt.Color(204, 204, 255));
        jTable1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Product", "Brand", "Category", "qty", "Buying Price", "Selling Price", "MFD", "EXD"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setSelectionBackground(new java.awt.Color(255, 204, 204));
        jTable1.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jTable1.setShowGrid(true);
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("This Products Expire Date is Close");
        jLabel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 51, 255), 4, true));

        jButton9.setBackground(new java.awt.Color(0, 153, 102));
        jButton9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton9.setText("Print");
        jButton9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        jButton9.setContentAreaFilled(false);
        jButton9.setFocusable(false);
        jButton9.setOpaque(true);
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 971, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(139, 139, 139)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel1))
                    .addComponent(jButton2))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        try {

            //   String filePath = "src//report//product.jrxml";
            InputStream filePath = ExpireSoon.class.getResourceAsStream("/report/expire.jrxml");

            JasperReport jr = JasperCompileManager.compileReport(filePath);

            HashMap parameters = new HashMap();
            TableModel tm = jTable1.getModel();

            JRTableModelDataSource datasource = new JRTableModelDataSource(tm);
            //   JRBeanCollectionDataSource datasource = new JRBeanCollectionDataSource(v);

            JasperPrint jp = JasperFillManager.fillReport(jr, parameters, datasource);

            JasperViewer.viewReport(jp, false);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        //        System.exit(0);

        if (h != null) {

            h.setEnabled(true);
            h.setFocusable(true);

            Dashboard d = new Dashboard();

            h.jPanel2.removeAll();
            h.jPanel2.add(d);
            h.jPanel2.revalidate();
            h.jPanel2.repaint();
        }

        this.dispose();


    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(ExpireSoon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ExpireSoon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ExpireSoon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ExpireSoon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ExpireSoon().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
