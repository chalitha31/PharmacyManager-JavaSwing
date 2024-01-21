/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.border.MatteBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import model.MySQL;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author chalitha
 */
public class ProductRegistration extends javax.swing.JPanel {

    GRN grn;
    static String path;
    static File destinationfile;
    Home h;
    ProductDeatils prd;
    Dashboard d;

    /**
     * Creates new form ProductRegistration
     */
    public ProductRegistration() {
        initComponents();
        TableHead();
        loadBrands();
        loadCategories();
        loadProducts();
    }
      public ProductRegistration(Dashboard d) {
        initComponents();
        TableHead();
        loadBrands();
        loadCategories();
        loadProducts();
        this.d=d;
    }

    public ProductRegistration(ProductDeatils prd) {
        initComponents();
        TableHead();
        loadBrands();
        loadCategories();
        loadProducts();
        this.prd = prd;
    }

    public ProductRegistration(Home h) {
        initComponents();
        TableHead();
        loadBrands();
        loadCategories();
        loadProducts();
        this.h = h;
    }

    public ProductRegistration(GRN grn) {
        initComponents();
        TableHead();
        loadBrands();
        loadCategories();
        loadProducts();
        this.grn = grn;
    }

    public void TableHead() {

        JTableHeader tb = jTable1.getTableHeader();
        tb.setForeground(Color.BLACK);
        tb.setBackground(new Color(102, 102, 102));
        tb.setFont(new Font("Tahome", Font.BOLD, 15));

        TableColumn t = jTable1.getColumn("id");
        t.setMaxWidth(80);

        jTable1.setRowHeight(30);

    }

    public void loadProducts() {

        try {
            ResultSet rs = MySQL.search("SELECT * FROM `product` INNER JOIN `brand` ON `product`.`brand_id`=`brand`.`id` "
                    + "INNER JOIN `category` ON `product`.`category_id`=`category`.`id` INNER JOIN `product_img` ON `product`.`image_id` = `product_img`.`id`");

            DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
            dtm.setRowCount(0);

            while (rs.next()) {

                jTable1.getColumn("img").setCellRenderer(new tableRendere());

                String imager = rs.getString("product_img.image");

                ImageIcon imageicon = new ImageIcon(imager);

                Image Timage = imageicon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);

                JLabel imglabel = new JLabel();

                imglabel.setIcon(new ImageIcon(Timage));

                jTable1.getColumn("More").setCellRenderer(new tableRendere());

                JPanel pa = new JPanel();

                JButton b = new JButton("Press");

                b.setBackground(new Color(153, 153, 255));
                b.setSize(70, 22);

                b.setContentAreaFilled(false);
                b.setOpaque(true);

                pa.add(b);

                Vector v = new Vector();
                v.add(imglabel);
                v.add(rs.getString("id"));
                v.add(rs.getString("name"));
                v.add(rs.getString("brand.name"));
                v.add(rs.getString("category.name"));
                v.add(pa);
                dtm.addRow(v);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void loadProducts(String text) {

        try {
            ResultSet rs = MySQL.search("SELECT * FROM `product` INNER JOIN `brand` ON `product`.`brand_id`=`brand`.`id` "
                    + "INNER JOIN `category` ON `product`.`category_id`=`category`.`id` INNER JOIN `product_img` ON `product`.`image_id` = `product_img`.`id`"
                    + " WHERE `category`.`name` LIKE '" + text + "%' OR `brand`.`name` LIKE '" + text + "%' OR `product`.`name` LIKE '" + text + "%' OR `product`.`SideEffect` LIKE '" + text + "%' OR `product`.`discription` LIKE '" + text + "%' ORDER BY  `product`.`name` ASC ");

            DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
            dtm.setRowCount(0);

            while (rs.next()) {

                jTable1.getColumn("img").setCellRenderer(new tableRendere());

                String imager = rs.getString("product_img.image");

                ImageIcon imageicon = new ImageIcon(imager);

                Image Timage = imageicon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);

                JLabel imglabel = new JLabel();

                imglabel.setIcon(new ImageIcon(Timage));

                jTable1.getColumn("More").setCellRenderer(new tableRendere());

                JPanel pa = new JPanel();

                JButton b = new JButton("Press");

                b.setBackground(new Color(153, 153, 255));
                b.setSize(70, 22);

                b.setContentAreaFilled(false);
                b.setOpaque(true);

                pa.add(b);

                Vector v = new Vector();
                v.add(imglabel);
                v.add(rs.getString("id"));
                v.add(rs.getString("name"));
                v.add(rs.getString("brand.name"));
                v.add(rs.getString("category.name"));
                v.add(pa);

                dtm.addRow(v);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void loadBrands() {

        try {

            ResultSet rs = MySQL.search("SELECT `name` FROM `brand`");

            Vector v = new Vector();
            v.add("Select");

            while (rs.next()) {
                v.add(rs.getString("name"));
            }
            jComboBox3.setModel(new DefaultComboBoxModel(v));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void loadCategories() {

        try {

            ResultSet rs = MySQL.search("SELECT `name` FROM `category`");

            Vector v = new Vector();
            v.add("Select");

            while (rs.next()) {
                v.add(rs.getString("name"));
            }
            jComboBox4.setModel(new DefaultComboBoxModel(v));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public ImageIcon ResizeImage(String ImagePath) {
        ImageIcon MyImage = new ImageIcon(ImagePath);
        Image img = MyImage.getImage();
        Image newImg = img.getScaledInstance(jLabel2.getWidth(), jLabel2.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    }

    class tableRendere implements TableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

            TableColumn tb = jTable1.getColumn("img");
            TableColumn tbb = jTable1.getColumn("More");
            tbb.setMaxWidth(150);
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

        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        kGradientPanel2 = new com.k33ptoo.components.KGradientPanel();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        kButton1 = new com.k33ptoo.components.KButton();
        jComboBox3 = new javax.swing.JComboBox<>();
        jComboBox4 = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jLabel13 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton9 = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 204, 204));
        setPreferredSize(new java.awt.Dimension(1654, 1000));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_remove_image_128px_1.png"))); // NOI18N
        jLabel2.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(255, 255, 255)));

        jButton1.setBackground(new java.awt.Color(204, 204, 204));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setText("choose image");
        jButton1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 102, 102)));
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton1.setFocusable(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setOpaque(true);
        jLabel3.setPreferredSize(new java.awt.Dimension(2, 0));

        kGradientPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        kGradientPanel2.setkEndColor(new java.awt.Color(153, 163, 177));
        kGradientPanel2.setkGradientFocus(900);
        kGradientPanel2.setkStartColor(new java.awt.Color(153, 163, 177));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Product Name :");

        jTextField1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Brand :");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Category :");

        jLabel7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 51, 51));

        jLabel8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 51, 51));
        jLabel8.setToolTipText("");

        jLabel9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 51, 51));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_add_new_26px_1.png"))); // NOI18N
        jButton3.setToolTipText("");
        jButton3.setContentAreaFilled(false);
        jButton3.setFocusable(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_add_new_26px_1.png"))); // NOI18N
        jButton5.setToolTipText("");
        jButton5.setContentAreaFilled(false);
        jButton5.setFocusable(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Description :");

        jTextArea1.setBackground(new java.awt.Color(204, 204, 255));
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextArea1.setRows(3);
        jTextArea1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        jScrollPane1.setViewportView(jTextArea1);

        kButton1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 153, 255), 2, true));
        kButton1.setText("Add New Product");
        kButton1.setFocusable(false);
        kButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        kButton1.setkEndColor(new java.awt.Color(102, 102, 102));
        kButton1.setkHoverEndColor(new java.awt.Color(0, 184, 106));
        kButton1.setkHoverForeGround(new java.awt.Color(0, 0, 0));
        kButton1.setkStartColor(new java.awt.Color(102, 102, 102));
        kButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton1ActionPerformed(evt);
            }
        });

        jComboBox3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jComboBox4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 51, 51));
        jLabel12.setToolTipText("");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Side Effects :");

        jTextArea2.setBackground(new java.awt.Color(204, 204, 255));
        jTextArea2.setColumns(20);
        jTextArea2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextArea2.setRows(3);
        jTextArea2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        jScrollPane2.setViewportView(jTextArea2);

        jLabel13.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 51, 51));
        jLabel13.setToolTipText("");

        javax.swing.GroupLayout kGradientPanel2Layout = new javax.swing.GroupLayout(kGradientPanel2);
        kGradientPanel2.setLayout(kGradientPanel2Layout);
        kGradientPanel2Layout.setHorizontalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBox3, 0, 171, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBox4, 0, 195, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(kGradientPanel2Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 839, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 839, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(kGradientPanel2Layout.createSequentialGroup()
                        .addGap(326, 326, 326)
                        .addComponent(kButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(94, Short.MAX_VALUE))
        );
        kGradientPanel2Layout.setVerticalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)
                        .addComponent(jLabel6)
                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(kButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("<html><u>Product<u/></html>");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setText("Search :");

        jTextField2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 0, 255)));
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField2KeyReleased(evt);
            }
        });

        jTable1.setBackground(new java.awt.Color(198, 235, 244));
        jTable1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "img", "id", "Product", "Brand", "Category", "More"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setToolTipText("");
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jTable1.setOpaque(false);
        jTable1.setSelectionBackground(new java.awt.Color(255, 191, 194));
        jTable1.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jTable1.setShowGrid(true);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable1);

        jButton9.setBackground(new java.awt.Color(255, 122, 148));
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(79, 79, 79))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(118, 118, 118)))
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72)
                .addComponent(kGradientPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(142, 142, 142))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(663, 663, 663))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1617, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(1003, 1003, 1003)
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addComponent(kGradientPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(142, 142, 142)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel14))
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(407, 407, 407))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        JFileChooser file = new JFileChooser();
        //   file.setCurrentDirectory(new File(System.getProperty("user.home")));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.images", "jpg", "gif", "png", "jpeg");
        file.addChoosableFileFilter(filter);
        int result = file.showSaveDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = file.getSelectedFile();
            path = selectedFile.getAbsolutePath();
            jLabel2.setIcon(ResizeImage(path));

        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        //        ImageIcon icon = new ImageIcon("/C:/Users/sandu/OneDrive/Documents/NetBeansProjects/Pharmacy_System/build/classes/img/icons8_remove_image_128px_1.png");
        //        jLabel2.setIcon(icon);
        BrandRegistration br = new BrandRegistration(this);
        br.setVisible(true);

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        CategoryRegistration cr = new CategoryRegistration(this);
        cr.setVisible(true);

    }//GEN-LAST:event_jButton5ActionPerformed

    private void kButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton1ActionPerformed

        String name = jTextField1.getText();
        String brand = jComboBox3.getSelectedItem().toString();
        String category = jComboBox4.getSelectedItem().toString();
        String discription = jTextArea1.getText();
        String SideEffect = jTextArea2.getText();
        Icon img = jLabel2.getIcon();

        if (name.isEmpty()) {
            //         JOptionPane.showMessageDialog(this, "Plese Enter Product Name", "Warning", JOptionPane.WARNING_MESSAGE);
            jTextField1.setBorder(new MatteBorder(2, 2, 2, 2, Color.RED));
            jLabel8.setText("Please  Enter Product Name");

            jComboBox3.setBorder(null);
            jComboBox4.setBorder(null);
            jTextArea1.setBorder(new MatteBorder(1, 1, 1, 1, Color.WHITE));
            jTextArea2.setBorder(new MatteBorder(1, 1, 1, 1, Color.WHITE));

            jLabel7.setText("");
            jLabel9.setText("");
            jLabel12.setText("");
            jLabel13.setText("");

        } else if (brand.equals("Select")) {
            //  JOptionPane.showMessageDialog(this, "Plese Select Brand Name", "Warning", JOptionPane.WARNING_MESSAGE);
            jComboBox3.setBorder(new MatteBorder(2, 2, 2, 2, Color.RED));
            jLabel7.setText("Please  Select Brand Name");

            jTextField1.setBorder(new MatteBorder(1, 1, 1, 1, Color.WHITE));
            jComboBox4.setBorder(null);
            jTextArea1.setBorder(new MatteBorder(1, 1, 1, 1, Color.WHITE));
            jTextArea2.setBorder(new MatteBorder(1, 1, 1, 1, Color.WHITE));

            jLabel9.setText("");
            jLabel12.setText("");
            jLabel8.setText("");
            jLabel13.setText("");

        } else if (category.equals("Select")) {
            //    JOptionPane.showMessageDialog(this, "Plese Select Category Name", "Warning", JOptionPane.WARNING_MESSAGE);
            jComboBox4.setBorder(new MatteBorder(2, 2, 2, 2, Color.RED));
            jLabel9.setText("Please  Select Category Name");

            jTextField1.setBorder(new MatteBorder(1, 1, 1, 1, Color.WHITE));
            jComboBox3.setBorder(null);
            jTextArea1.setBorder(new MatteBorder(1, 1, 1, 1, Color.WHITE));
            jTextArea2.setBorder(new MatteBorder(1, 1, 1, 1, Color.WHITE));

            jLabel7.setText("");
            jLabel12.setText("");
            jLabel8.setText("");
            jLabel13.setText("");

        } else if (discription.isEmpty()) {
            // JOptionPane.showMessageDialog(this, "Plese Select Category Name", "Warning", JOptionPane.WARNING_MESSAGE);

            jTextField1.setBorder(new MatteBorder(1, 1, 1, 1, Color.WHITE));
            jComboBox3.setBorder(null);
            jComboBox4.setBorder(null);

            jTextArea2.setBorder(new MatteBorder(1, 1, 1, 1, Color.WHITE));

            jLabel7.setText("");
            jLabel9.setText("");
            jLabel8.setText("");
            jLabel12.setText("");

            int option = JOptionPane.showConfirmDialog(this, "Would you add a description?", "Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);

            if (option == JOptionPane.YES_OPTION) {

                jTextArea1.setBorder(new MatteBorder(2, 2, 2, 2, Color.RED));
                jLabel13.setText("Please  Enter description");

            } else {

                jTextArea1.setText("None");
                jTextArea1.setBorder(new MatteBorder(1, 1, 1, 1, Color.WHITE));
                jLabel13.setText("");

            }

        } else if (SideEffect.isEmpty()) {
            // JOptionPane.showMessageDialog(this, "Plese Select Category Name", "Warning", JOptionPane.WARNING_MESSAGE);

            jTextField1.setBorder(new MatteBorder(1, 1, 1, 1, Color.WHITE));
            jComboBox3.setBorder(null);
            jComboBox4.setBorder(null);

            jTextArea1.setBorder(new MatteBorder(1, 1, 1, 1, Color.WHITE));
            jLabel13.setText("");
            jLabel7.setText("");
            jLabel9.setText("");
            jLabel8.setText("");

            int option = JOptionPane.showConfirmDialog(this, "Would you add Side Effects??", "Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);

            if (option == JOptionPane.YES_OPTION) {

                jTextArea2.setBorder(new MatteBorder(2, 2, 2, 2, Color.RED));
                jLabel12.setText("Please  Enter Side Effects");

            } else {

                jTextArea2.setText("None");
                jTextArea2.setBorder(new MatteBorder(1, 1, 1, 1, Color.WHITE));
                jLabel12.setText("");
                kButton1.doClick();

            }

        } else {
            try {

                ResultSet rsc = MySQL.search("SELECT * FROM `category` WHERE `name` = '" + category + "'");
                rsc.next();

                String category_id = rsc.getString("id");

                ResultSet rsb = MySQL.search("SELECT * FROM `brand` WHERE `name` = '" + brand + "'");
                rsb.next();

                String brand_id = rsb.getString("id");

                ResultSet r = MySQL.search("SELECT * FROM  `product` WHERE `name` = '" + name + "' AND `category_id` = '" + category_id + "' AND `brand_id` = '" + brand_id + "' ");

                if (r.next()) {
                    JOptionPane.showMessageDialog(this, "Already exsits!", "Warning", JOptionPane.WARNING_MESSAGE);
                } else {

                    if (path == null) {

                        MySQL.iud("INSERT INTO  `product` (`category_id`,`brand_id`,`name`,`image_id`,`discription`,`SideEffect`) VALUES ('" + category_id + "','" + brand_id + "','" + name + "','" + 1 + "','" + discription + "','" + SideEffect + "')");

                    } else {

                        String newPath = "upload/product_Img";

                        File directory = new File(newPath);

                        if (!directory.exists()) {
                            directory.mkdirs();
                        }

                        File sourceFile = null;

                        String extension = path.substring(path.lastIndexOf("\\") + 1);
                        sourceFile = new File(path);

                        destinationfile = new File(newPath + "/" + extension);

                        Files.copy(sourceFile.toPath(), destinationfile.toPath(), StandardCopyOption.REPLACE_EXISTING);

                        String p = destinationfile.getAbsolutePath();

                        String imagepath = p.replace("\\", "\\\\");

                        ResultSet rsm = MySQL.search("SELECT * FROM `product_img` WHERE `image` = '" + imagepath + "'");

                        if (rsm.next()) {

                            String img_id = rsm.getString("id");

                            MySQL.iud("INSERT INTO  `product` (`category_id`,`brand_id`,`name`,`image_id`,`discription`) VALUES ('" + category_id + "','" + brand_id + "','" + name + "','" + img_id + "','" + discription + "')");

                        } else {

                            MySQL.iud("INSERT INTO `product_img`(`image`) VALUES('" + imagepath + "')");

                            ResultSet rsi = MySQL.search("SELECT * FROM `product_img` WHERE `image` = '" + imagepath + "'");
                            rsi.next();

                            String im_id = rsi.getString("id");

                            MySQL.iud("INSERT INTO  `product` (`category_id`,`brand_id`,`name`,`image_id`,`discription`) VALUES ('" + category_id + "','" + brand_id + "','" + name + "','" + im_id + "','" + discription + "')");
                        }
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

            jTextField1.setBorder(new MatteBorder(1, 1, 1, 1, Color.WHITE));
            jComboBox3.setBorder(null);
            jComboBox4.setBorder(null);
            jTextArea1.setBorder(new MatteBorder(1, 1, 1, 1, Color.WHITE));
            jTextArea2.setBorder(new MatteBorder(1, 1, 1, 1, Color.WHITE));

            jTextField1.setText("");
            jLabel7.setText("");
            jLabel9.setText("");
            jLabel12.setText("");
            jLabel13.setText("");
            jLabel8.setText("");
            jTextArea1.setText("");
            jTextArea2.setText("");

            jComboBox3.setSelectedIndex(0);
            jComboBox4.setSelectedIndex(0);
            jTextField1.grabFocus();

            path = null;

            ImageIcon icon = new ImageIcon("/C:/Users/sandu/OneDrive/Documents/NetBeansProjects/Pharmacy_System/build/classes/img/icons8_remove_image_128px_1.png");
            jLabel2.setIcon(icon);

            loadProducts();

            JOptionPane.showMessageDialog(this, "New Product Added", "Success", JOptionPane.INFORMATION_MESSAGE);

        }
    }//GEN-LAST:event_kButton1ActionPerformed

    private void jTextField2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyReleased
        String text = jTextField2.getText();
        loadProducts(text);
    }//GEN-LAST:event_jTextField2KeyReleased

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int r = jTable1.getSelectedRow();

        if (evt.getClickCount() == 2) {

            if (r == -1) {
                JOptionPane.showMessageDialog(this, "Please Select a Company", "Warning", JOptionPane.WARNING_MESSAGE);

            } else {

                if (grn != null) {
                    //         String pid = jTable1.getValueAt(r, 0).toString();
                    String pname = jTable1.getValueAt(r, 2).toString();
                    String brand = jTable1.getValueAt(r, 3).toString();
                    String category = jTable1.getValueAt(r, 4).toString();

                    //        grn.jLabel10.setText(pid);
                    grn.jLabel12.setText(pname);
                    grn.jLabel18.setText(brand);
                    grn.jLabel14.setText(category);

//                    this.dispose();
                    grn.jButton2.setText("Update Product");
                    grn.jButton2.setBackground(new Color(153, 153, 153));

                    grn.jButton2.setEnabled(false);

                    grn.jTextField1.grabFocus();

                    Home home = (Home) SwingUtilities.getWindowAncestor(this);

                    home.jPanel2.removeAll();
                    home.jPanel2.add(grn);
                    home.jPanel2.revalidate();
                    home.jPanel2.repaint();
                }
            }
        }

        int colIndex = jTable1.getSelectedColumn();
        if (evt.getClickCount() == 1) {

            if (colIndex == 5) {
                //   System.out.println(jTable1.getValueAt(r, 3).toString());

                try {
                    String pid = jTable1.getValueAt(r, 1).toString();
                    ResultSet rd = MySQL.search("SELECT * FROM `product` WHERE  `id` = '" + pid + "' ");
                    rd.next();

                    String discription = rd.getString("discription");
                    String SideEffect = rd.getString("SideEffect");
                    String pname = jTable1.getValueAt(r, 2).toString();
                    String brand = jTable1.getValueAt(r, 3).toString();
                    String category = jTable1.getValueAt(r, 4).toString();

                    prd = new ProductDeatils(h, true);

                    prd.jTextArea1.setText(discription);
                    prd.jTextArea2.setText(SideEffect);

                    prd.jLabel6.setText(pname);
                    prd.jLabel7.setText(brand);
                    prd.jLabel8.setText(category);

                    prd.jTextArea2.setEditable(false);

                    prd.jTextArea1.setEditable(false);
                    //        Home hh = (Home) SwingUtilities.getWindowAncestor(this);

                    prd.setVisible(true);

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

        }

    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        try {

            //   String filePath = "src//report//product.jrxml";
            InputStream filePath = ProductRegistration.class.getResourceAsStream("/report/product.jrxml");

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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
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
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private com.k33ptoo.components.KButton kButton1;
    private com.k33ptoo.components.KGradientPanel kGradientPanel2;
    // End of variables declaration//GEN-END:variables
}
