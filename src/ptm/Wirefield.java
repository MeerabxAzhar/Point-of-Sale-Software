package ptm;
import javax.swing.*;
import java.util.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import net.proteanit.sql.DbUtils;
public class Wirefield extends javax.swing.JFrame {
Connection con;
    PreparedStatement pst;
    ResultSet rs;
    DefaultTableModel d;
    Cart cart=new Cart();
 public void tbl() {
     
        try {
            pst = con.prepareStatement("select * from `wire`");
            rs = pst.executeQuery();
            ResultSetMetaData rsd = rs.getMetaData();
            d = (DefaultTableModel) tblw.getModel();
            d.setRowCount(0);
            while (rs.next()) {
                Vector v = new Vector();
                 v.add(rs.getString("Id"));
                v.add(rs.getString("Name"));
                v.add(rs.getString("Size"));
                v.add(rs.getString("Cost Price"));
                v.add(rs.getString("Whole Price"));
                v.add(rs.getString("Retail Price"));
                v.add(rs.getString("Total Quantity"));
                v.add(rs.getString("Show Room"));
                v.add(rs.getString("Godam"));
                v.add(rs.getString("Total Cost"));
                
                d.addRow(v);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Wire.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 public void Connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try {
                con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/ptm", "root", "");
            } catch (SQLException ex) {
                Logger.getLogger(Wire.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Wire.class.getName()).log(Level.SEVERE, null, ex);
        }}
    public Wirefield() {
        initComponents();
           Connect();
        tbl();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuBar1 = new java.awt.MenuBar();
        menu1 = new java.awt.Menu();
        menu2 = new java.awt.Menu();
        jPanel3 = new javax.swing.JPanel();
        btnadd = new javax.swing.JLabel();
        btnupdate = new javax.swing.JLabel();
        btnbill = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblht = new javax.swing.JLabel();
        lblaccess = new javax.swing.JLabel();
        btnwarning = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btncustomer = new javax.swing.JLabel();
        lblwire = new javax.swing.JLabel();
        txtsearch = new javax.swing.JTextField();
        lblpt = new javax.swing.JLabel();
        btncart = new javax.swing.JLabel();
        lblsp = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        name = new javax.swing.JLabel();
        size = new javax.swing.JLabel();
        cp = new javax.swing.JLabel();
        wp = new javax.swing.JLabel();
        rp = new javax.swing.JLabel();
        txtname = new javax.swing.JTextField();
        txtsize = new javax.swing.JTextField();
        txtrp = new javax.swing.JTextField();
        txtwp = new javax.swing.JTextField();
        txtsr = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        lblptbill1 = new javax.swing.JLabel();
        lblptadd11 = new javax.swing.JLabel();
        lblptupdate = new javax.swing.JLabel();
        txtcp = new javax.swing.JTextField();
        sr = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblw = new javax.swing.JTable();
        godam = new javax.swing.JLabel();
        txtgodam = new javax.swing.JTextField();
        Id = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();

        menu1.setLabel("File");
        menuBar1.add(menu1);

        menu2.setLabel("Edit");
        menuBar1.add(menu2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(0, 51, 102));
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnadd.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnadd.setForeground(new java.awt.Color(255, 255, 255));
        btnadd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-add-24.png"))); // NOI18N
        btnadd.setText("Add");
        btnadd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnaddMouseClicked(evt);
            }
        });
        jPanel3.add(btnadd, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 80, 40));

        btnupdate.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnupdate.setForeground(new java.awt.Color(255, 255, 255));
        btnupdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-available-updates-26.png"))); // NOI18N
        btnupdate.setText("Update");
        btnupdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnupdateMouseClicked(evt);
            }
        });
        jPanel3.add(btnupdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 80, 40));

        btnbill.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnbill.setForeground(new java.awt.Color(255, 255, 255));
        btnbill.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-bill-24.png"))); // NOI18N
        btnbill.setText("Bill");
        btnbill.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnbillMouseClicked(evt);
            }
        });
        jPanel3.add(btnbill, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 70, 40));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 70, 130, 630));

        jPanel1.setBackground(new java.awt.Color(0, 51, 102));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search_26px.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 30, 30, -1));

        lblht.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lblht.setForeground(new java.awt.Color(255, 255, 255));
        lblht.setText("Hand Tools");
        lblht.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblhtMouseClicked(evt);
            }
        });
        jPanel1.add(lblht, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 30, 80, -1));

        lblaccess.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lblaccess.setForeground(new java.awt.Color(255, 255, 255));
        lblaccess.setText("Accessories");
        lblaccess.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblaccessMouseClicked(evt);
            }
        });
        jPanel1.add(lblaccess, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 30, 80, -1));

        btnwarning.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-warning-24.png"))); // NOI18N
        btnwarning.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnwarningMouseClicked(evt);
            }
        });
        jPanel1.add(btnwarning, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 30, -1, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-drill-64.png"))); // NOI18N
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 70, 60));

        btncustomer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-user-24.png"))); // NOI18N
        btncustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btncustomerMouseClicked(evt);
            }
        });
        jPanel1.add(btncustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 30, -1, -1));

        lblwire.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lblwire.setForeground(new java.awt.Color(255, 255, 255));
        lblwire.setText("Wire");
        lblwire.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblwireMouseClicked(evt);
            }
        });
        jPanel1.add(lblwire, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 30, 90, -1));

        txtsearch.setBackground(new java.awt.Color(0, 51, 102));
        txtsearch.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtsearch.setForeground(new java.awt.Color(255, 255, 255));
        txtsearch.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        txtsearch.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtsearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtsearchKeyReleased(evt);
            }
        });
        jPanel1.add(txtsearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 30, 210, -1));

        lblpt.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lblpt.setForeground(new java.awt.Color(255, 255, 255));
        lblpt.setText("Power Tools");
        lblpt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblptMouseClicked(evt);
            }
        });
        jPanel1.add(lblpt, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, 90, 20));

        btncart.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-shopping-cart-24.png"))); // NOI18N
        btncart.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btncartMouseClicked(evt);
            }
        });
        jPanel1.add(btncart, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 30, 30, 30));

        lblsp.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lblsp.setForeground(new java.awt.Color(255, 255, 255));
        lblsp.setText("Spare Parts");
        lblsp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblspMouseClicked(evt);
            }
        });
        jPanel1.add(lblsp, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 30, 90, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1240, 70));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        name.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        name.setText("Name");
        jPanel2.add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 70, 20));

        size.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        size.setText("Size");
        jPanel2.add(size, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 10, 60, -1));

        cp.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        cp.setText("Cost Price");
        jPanel2.add(cp, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 10, 70, -1));

        wp.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        wp.setText("Whole Price");
        jPanel2.add(wp, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, 80, -1));

        rp.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        rp.setText("Retail Price");
        jPanel2.add(rp, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 50, 70, -1));

        txtname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnameActionPerformed(evt);
            }
        });
        jPanel2.add(txtname, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, 160, -1));

        txtsize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsizeActionPerformed(evt);
            }
        });
        jPanel2.add(txtsize, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 10, 160, -1));
        jPanel2.add(txtrp, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 50, 160, -1));
        jPanel2.add(txtwp, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 50, 160, -1));
        jPanel2.add(txtsr, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 60, 160, -1));

        jPanel5.setBackground(new java.awt.Color(0, 51, 102));
        jPanel5.setForeground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblptbill1.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lblptbill1.setForeground(new java.awt.Color(255, 255, 255));
        lblptbill1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-bill-24.png"))); // NOI18N
        lblptbill1.setText("Bill");
        jPanel5.add(lblptbill1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 130, 40));

        lblptadd11.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lblptadd11.setForeground(new java.awt.Color(255, 255, 255));
        lblptadd11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-add-24.png"))); // NOI18N
        lblptadd11.setText("Add");
        jPanel5.add(lblptadd11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 130, 40));

        lblptupdate.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lblptupdate.setForeground(new java.awt.Color(255, 255, 255));
        lblptupdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-available-updates-26.png"))); // NOI18N
        lblptupdate.setText("Update");
        jPanel5.add(lblptupdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 130, 40));

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 70, 130, 630));
        jPanel2.add(txtcp, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 10, 160, -1));

        sr.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        sr.setText("Show Room");
        jPanel2.add(sr, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 60, -1, -1));

        tblw.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tblw.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Name", "Size", "Cost Price", "Whole Price", "Retail Price", "Total Cost", "Show Room", "Godam", "Total Quantity"
            }
        ));
        tblw.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tblw.setShowHorizontalLines(true);
        tblw.setShowVerticalLines(true);
        tblw.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblwMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblw);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 1080, 420));

        godam.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        godam.setText("Godam");
        jPanel2.add(godam, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, 70, -1));
        jPanel2.add(txtgodam, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 90, 160, -1));

        Id.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        Id.setText("Id");
        jPanel2.add(Id, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 90, 50, 20));
        jPanel2.add(txtid, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 90, 160, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 1110, 630));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnameActionPerformed

    private void txtsizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsizeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsizeActionPerformed

    private void txtsearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtsearchKeyReleased
               String txt=txtsearch.getText();
          try {
               if (txt.matches("^[a-zA-Z0-9]+$")) {
    // Search by ID
    String query = "SELECT * FROM `wire` WHERE `Id` = '" + txt + "'";
    pst = con.prepareStatement(query);
              rs=pst.executeQuery();
              tblw.setModel(DbUtils.resultSetToTableModel(rs));
              }
               if(txt.matches("^[a-zA-Z]+$"))
              {
              String query="SELECT * FROM `wire` Where `Name` LIKE '%"+txt+"%'";
                pst=con.prepareStatement(query);
              rs=pst.executeQuery();
              tblw.setModel(DbUtils.resultSetToTableModel(rs));
              }
               if (txt.isEmpty()) {
    String query = "SELECT * FROM `wire`";
    pst = con.prepareStatement(query);
    rs = pst.executeQuery();
    tblw.setModel(DbUtils.resultSetToTableModel(rs));}
          }catch (SQLException ex) {
            Logger.getLogger(Wire.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtsearchKeyReleased

    private void btnaddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnaddMouseClicked
        try {
              String Id = txtid.getText();
            String ItemName = txtname.getText();
           
            String Size = txtsize.getText();
            String WholeSale = txtwp.getText();
            String RSale = txtrp.getText();
            String CostPrice = txtcp.getText();
            String ShowRoom = txtsr.getText();
            String Godam = txtgodam.getText();
           
            int TotalQuantity = Integer.parseInt(txtsr.getText()) + Integer.parseInt(txtgodam.getText());
            Double TotalCost = Double.parseDouble(txtcp.getText()) * TotalQuantity;
            pst = con.prepareStatement("INSERT INTO `wire`(`Id`, `Name`, `Size`, `Cost Price`, `Whole Price`, `Retail Price`, `Total Quantity`, `Show Room`, `Godam`, `Total Cost`) VALUES (?,?,?,?,?,?,?,?,?,?)");
pst.setString(1, Id);
            pst.setString(2, ItemName);
           
            pst.setString(3, Size);
            pst.setString(5, WholeSale);
            pst.setString(6, RSale);
            pst.setString(4, CostPrice);
            pst.setInt(7, TotalQuantity);
            pst.setString(8, ShowRoom);
            pst.setString(9, Godam);
            pst.setDouble(10, TotalCost);
           
            JOptionPane.showMessageDialog(this, "Added successfully!");
            pst.executeUpdate();
             txtid.setText("");
            txtname.setText("");
           
            txtsize.setText("");
            txtwp.setText("");
            txtrp.setText("");
            txtcp.setText("");
            txtsr.setText("");
            txtgodam.setText("");
            
            tbl();
        } catch (SQLException ex) {
            Logger.getLogger(Wirefield.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnaddMouseClicked

    private void btnupdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnupdateMouseClicked
         try {
 String Id = txtid.getText();
            String ItemName = txtname.getText();
           
            String Size = txtsize.getText();
            String WholeSale = txtwp.getText();
            String RSale = txtrp.getText();
            String CostPrice = txtcp.getText();
            String ShowRoom = txtsr.getText();
            String Godam = txtgodam.getText();
            
            int TotalQuantity = Integer.parseInt(txtsr.getText()) + Integer.parseInt(txtgodam.getText());
            Double TotalCost = Double.parseDouble(txtcp.getText()) * TotalQuantity;
            pst = con.prepareStatement("UPDATE `wire` SET `Id`=?,`Size`=?,`Cost Price`=?,`Whole Price`=?,`Retail Price`=?,`Total Quantity`=?,`Show Room`=?,`Godam`=?,`Total Cost`=? WHERE `Name`=?");
           pst.setString(1, Id);
            pst.setString(10, ItemName);
             pst.setString(2, Size);
           
            pst.setString(4, WholeSale);
            pst.setString(5, RSale);
            pst.setString(3, CostPrice);
            pst.setInt(6, TotalQuantity);
            pst.setString(7, ShowRoom);
            pst.setString(8, Godam);
            pst.setDouble(9, TotalCost);
           
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Updated successfully!");
            btnupdate.setEnabled(true);
            txtid.setText("");
            txtname.setText("");
            
            txtsize.setText("");
            txtwp.setText("");
            txtrp.setText("");
            txtcp.setText("");
            txtsr.setText("");
            txtgodam.setText("");
           
            tbl();
            JFrame frame = new JFrame();
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        } catch (SQLException ex) {
            Logger.getLogger(Wirefield.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnupdateMouseClicked

    private void tblwMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblwMouseClicked
         d = (DefaultTableModel) tblw.getModel();
        int sIndex = tblw.getSelectedRow();
        String id = d.getValueAt(sIndex, 0).toString();
        txtid.setText(d.getValueAt(sIndex, 0).toString());
        txtname.setText(d.getValueAt(sIndex, 1).toString());
        txtsize.setText(d.getValueAt(sIndex, 2).toString());
        
         txtcp.setText(d.getValueAt(sIndex, 3).toString());
        txtwp.setText(d.getValueAt(sIndex, 4).toString());
        txtrp.setText(d.getValueAt(sIndex, 5).toString());
        txtsr.setText(d.getValueAt(sIndex, 7).toString());
        txtgodam.setText(d.getValueAt(sIndex, 8).toString());
         
        btnadd.setEnabled(true);
    }//GEN-LAST:event_tblwMouseClicked

    private void btncartMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btncartMouseClicked
System.out.println("Button clicked");  
        int selectedRow = tblw.getSelectedRow();
        if (selectedRow != -1) { // A row is selected  
            String id = tblw.getValueAt(selectedRow, 0).toString();
            String itemName = tblw.getValueAt(selectedRow, 1).toString();
            double price = Double.parseDouble(tblw.getValueAt(selectedRow, 10).toString());
            String quantityInput = JOptionPane.showInputDialog(this, "Enter quantity for " + itemName + ":");
        try {
            int quantity = Integer.parseInt(quantityInput);
            if (quantity < 1) {
                JOptionPane.showMessageDialog(this, "Invalid quantity. Please enter a positive number.");
            } else {
                double total = price * quantity;
              System.out.println(id+" " +itemName+" "+ price+" "+total);
               cart.addToCart(id, itemName, price, quantity, total); 
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid input. Please enter a valid quantity.");
        }
              
}                   // TODO add your handling code here:
    }//GEN-LAST:event_btncartMouseClicked

    private void btnbillMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnbillMouseClicked
 Cart cart=new Cart();
        cart.setVisible(true);          // TODO add your handling code here:
    }//GEN-LAST:event_btnbillMouseClicked

    private void lblptMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblptMouseClicked
PowerToolss pt=new PowerToolss();  
pt.setVisible(true);//        // TODO add your handling code here:
    }//GEN-LAST:event_lblptMouseClicked

    private void lblhtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblhtMouseClicked
Handtools ht=new Handtools(); 
ht.setVisible(true);//        // TODO add your handling code here:
    }//GEN-LAST:event_lblhtMouseClicked

    private void lblaccessMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblaccessMouseClicked
Accessories ac=new Accessories();
ac.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_lblaccessMouseClicked

    private void lblspMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblspMouseClicked
SpareParts sp=new SpareParts();
sp.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_lblspMouseClicked

    private void lblwireMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblwireMouseClicked
Wire w=new Wire();
w.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_lblwireMouseClicked

    private void btncustomerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btncustomerMouseClicked
Cus c=new Cus();
c.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_btncustomerMouseClicked

    private void btnwarningMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnwarningMouseClicked
Warning wra=new Warning();
wra.generateWarningReport();        // TODO add your handling code here:
    }//GEN-LAST:event_btnwarningMouseClicked

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
            java.util.logging.Logger.getLogger(Wirefield.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Wirefield.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Wirefield.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Wirefield.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Wirefield().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Id;
    private javax.swing.JLabel btnadd;
    private javax.swing.JLabel btnbill;
    private javax.swing.JLabel btncart;
    private javax.swing.JLabel btncustomer;
    private javax.swing.JLabel btnupdate;
    private javax.swing.JLabel btnwarning;
    private javax.swing.JLabel cp;
    private javax.swing.JLabel godam;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblaccess;
    private javax.swing.JLabel lblht;
    private javax.swing.JLabel lblpt;
    private javax.swing.JLabel lblptadd11;
    private javax.swing.JLabel lblptbill1;
    private javax.swing.JLabel lblptupdate;
    private javax.swing.JLabel lblsp;
    private javax.swing.JLabel lblwire;
    private java.awt.Menu menu1;
    private java.awt.Menu menu2;
    private java.awt.MenuBar menuBar1;
    private javax.swing.JLabel name;
    private javax.swing.JLabel rp;
    private javax.swing.JLabel size;
    private javax.swing.JLabel sr;
    private javax.swing.JTable tblw;
    private javax.swing.JTextField txtcp;
    private javax.swing.JTextField txtgodam;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtname;
    private javax.swing.JTextField txtrp;
    private javax.swing.JTextField txtsearch;
    private javax.swing.JTextField txtsize;
    private javax.swing.JTextField txtsr;
    private javax.swing.JTextField txtwp;
    private javax.swing.JLabel wp;
    // End of variables declaration//GEN-END:variables
}
