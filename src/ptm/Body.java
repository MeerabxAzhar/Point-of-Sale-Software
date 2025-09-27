package ptm;
import javax.swing.*;
import java.util.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import net.proteanit.sql.DbUtils;
public class Body extends javax.swing.JFrame {
Connection con;
    PreparedStatement pst;
    ResultSet rs;
    DefaultTableModel d;
    Cart cart=new Cart();
 public void tbl() {
        try {
            pst = con.prepareStatement("select * from `body`");
            rs = pst.executeQuery();
            ResultSetMetaData rsd = rs.getMetaData();
            d = (DefaultTableModel) tblbody.getModel();
            d.setRowCount(0);
            while (rs.next()) {
                Vector v = new Vector();
                 v.add(rs.getString("Id"));
                v.add(rs.getString("Name"));
                
                v.add(rs.getString("Model No"));
                v.add(rs.getString("Company"));
                v.add(rs.getString("Brand"));
                v.add(rs.getString("Cost Price"));
                v.add(rs.getString("Whole Price"));
                v.add(rs.getString("Retail Price"));
                
                v.add(rs.getString("Total Quantity"));
                v.add(rs.getString("Show Room"));
                v.add(rs.getString("Godam"));
                v.add(rs.getString("Total Cost"));
                v.add(rs.getString("Details"));
                d.addRow(v);
            }
             TableColumn column = tblbody.getColumnModel().getColumn(5);
        column.setMinWidth(0);
        column.setMaxWidth(0);
        column.setPreferredWidth(0);
        column.setResizable(false);
        } catch (SQLException ex) {
            Logger.getLogger(Body.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 public void Connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try {
                con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/ptm", "root", "");
            } catch (SQLException ex) {
                Logger.getLogger(Body.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Body.class.getName()).log(Level.SEVERE, null, ex);
        }}
    public Body() {
        initComponents();
        Connect();
        tbl();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblbody = new javax.swing.JTable();
        show = new javax.swing.JToggleButton();
        jPanel3 = new javax.swing.JPanel();
        btnbill = new javax.swing.JLabel();
        btnaddup = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtsearch = new javax.swing.JTextField();
        btncart = new javax.swing.JLabel();
        lblpt = new javax.swing.JLabel();
        lblht = new javax.swing.JLabel();
        lblaccess = new javax.swing.JLabel();
        lblsp = new javax.swing.JLabel();
        lblwire = new javax.swing.JLabel();
        btncustomer = new javax.swing.JLabel();
        btnwarning = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        btnarmature = new javax.swing.JLabel();
        btnfield = new javax.swing.JLabel();
        btngear = new javax.swing.JLabel();
        btnswitch = new javax.swing.JLabel();
        btnbearing = new javax.swing.JLabel();
        btncarbon = new javax.swing.JLabel();
        btnbody = new javax.swing.JLabel();
        btnrotary = new javax.swing.JLabel();
        btnnbreakers = new javax.swing.JLabel();
        btnothers = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblbody.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tblbody.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Name", "Model No.", "Company", "Brand", "Cost Price", "Whole Price", "Retail Price", "Total Quantity", "Show Room", "Godam", "Total Cost", "Details"
            }
        ));
        tblbody.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tblbody.setShowHorizontalLines(true);
        tblbody.setShowVerticalLines(true);
        jScrollPane2.setViewportView(tblbody);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 1000, 530));

        show.setText("SC");
        show.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showActionPerformed(evt);
            }
        });
        jPanel2.add(show, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 10, 50, 20));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 1000, 630));

        jPanel3.setBackground(new java.awt.Color(0, 51, 102));
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnbill.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnbill.setForeground(new java.awt.Color(255, 255, 255));
        btnbill.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-bill-24.png"))); // NOI18N
        btnbill.setText("Bill");
        btnbill.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnbillMouseClicked(evt);
            }
        });
        jPanel3.add(btnbill, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 80, 40));

        btnaddup.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnaddup.setForeground(new java.awt.Color(255, 255, 255));
        btnaddup.setText("Add/Update");
        btnaddup.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnaddupMouseClicked(evt);
            }
        });
        jPanel3.add(btnaddup, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 90, 40));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 70, -1, 630));

        jPanel1.setBackground(new java.awt.Color(0, 51, 102));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search_26px.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 30, 30, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-drill-64.png"))); // NOI18N
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 70, 60));

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

        btncart.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-shopping-cart-24.png"))); // NOI18N
        btncart.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btncartMouseClicked(evt);
            }
        });
        jPanel1.add(btncart, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 30, 40, 30));

        lblpt.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lblpt.setForeground(new java.awt.Color(255, 255, 255));
        lblpt.setText("Power Tools");
        lblpt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblptMouseClicked(evt);
            }
        });
        jPanel1.add(lblpt, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, 90, 20));

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

        lblsp.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lblsp.setForeground(new java.awt.Color(255, 255, 255));
        lblsp.setText("Spare Parts");
        lblsp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblspMouseClicked(evt);
            }
        });
        jPanel1.add(lblsp, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 30, 90, -1));

        lblwire.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lblwire.setForeground(new java.awt.Color(255, 255, 255));
        lblwire.setText("Wire");
        lblwire.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblwireMouseClicked(evt);
            }
        });
        jPanel1.add(lblwire, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 30, 90, -1));

        btncustomer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-user-24.png"))); // NOI18N
        btncustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btncustomerMouseClicked(evt);
            }
        });
        jPanel1.add(btncustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 30, -1, -1));

        btnwarning.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-warning-24.png"))); // NOI18N
        btnwarning.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnwarningMouseClicked(evt);
            }
        });
        jPanel1.add(btnwarning, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 30, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1240, 70));

        jPanel4.setBackground(new java.awt.Color(0, 51, 102));
        jPanel4.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnarmature.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnarmature.setForeground(new java.awt.Color(255, 255, 255));
        btnarmature.setText("Armature");
        btnarmature.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnarmatureMouseClicked(evt);
            }
        });
        jPanel4.add(btnarmature, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 70, 30));

        btnfield.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnfield.setForeground(new java.awt.Color(255, 255, 255));
        btnfield.setText("Field");
        btnfield.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnfieldMouseClicked(evt);
            }
        });
        jPanel4.add(btnfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 50, 30));

        btngear.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btngear.setForeground(new java.awt.Color(255, 255, 255));
        btngear.setText("Gear");
        btngear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btngearMouseClicked(evt);
            }
        });
        jPanel4.add(btngear, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 50, 30));

        btnswitch.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnswitch.setForeground(new java.awt.Color(255, 255, 255));
        btnswitch.setText("Switch");
        btnswitch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnswitchMouseClicked(evt);
            }
        });
        jPanel4.add(btnswitch, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 60, 30));

        btnbearing.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnbearing.setForeground(new java.awt.Color(255, 255, 255));
        btnbearing.setText("Bearing");
        btnbearing.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnbearingMouseClicked(evt);
            }
        });
        jPanel4.add(btnbearing, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 60, 30));

        btncarbon.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btncarbon.setForeground(new java.awt.Color(255, 255, 255));
        btncarbon.setText("Carbon");
        btncarbon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btncarbonMouseClicked(evt);
            }
        });
        jPanel4.add(btncarbon, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 60, 30));

        btnbody.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnbody.setForeground(new java.awt.Color(255, 255, 255));
        btnbody.setText("Body");
        btnbody.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnbodyMouseClicked(evt);
            }
        });
        jPanel4.add(btnbody, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 40, 30));

        btnrotary.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnrotary.setForeground(new java.awt.Color(255, 255, 255));
        btnrotary.setText("Rotary Hammer");
        btnrotary.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnrotaryMouseClicked(evt);
            }
        });
        jPanel4.add(btnrotary, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 120, 30));

        btnnbreakers.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnnbreakers.setForeground(new java.awt.Color(255, 255, 255));
        btnnbreakers.setText("Breakers");
        btnnbreakers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnnbreakersMouseClicked(evt);
            }
        });
        jPanel4.add(btnnbreakers, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 80, 30));

        btnothers.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnothers.setForeground(new java.awt.Color(255, 255, 255));
        btnothers.setText("Others");
        btnothers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnothersMouseClicked(evt);
            }
        });
        jPanel4.add(btnothers, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, 60, 30));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 140, 660));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtsearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtsearchKeyReleased
          String txt=txtsearch.getText();
          try {
              if(txt.matches("^[0-9]+$")){
            String query="SELECT * FROM `body` Where `Model No`="+txt;
                pst=con.prepareStatement(query);
              rs=pst.executeQuery();
              tblbody.setModel(DbUtils.resultSetToTableModel(rs));
              }
            else if (txt.matches("^[a-zA-Z0-9]+$")) {
    // Search by ID
    String query = "SELECT * FROM `body` WHERE `Id` = '" + txt + "'";
    pst = con.prepareStatement(query);
              rs=pst.executeQuery();
              tblbody.setModel(DbUtils.resultSetToTableModel(rs));
              }
               if(txt.matches("^[a-zA-Z]+$"))
              {
              String query="SELECT * FROM `body` Where `Item Name` LIKE '%"+txt+"%'";
                pst=con.prepareStatement(query);
              rs=pst.executeQuery();
              tblbody.setModel(DbUtils.resultSetToTableModel(rs));
              }
               if (txt.isEmpty()) {
    String query = "SELECT * FROM `body`";
    pst = con.prepareStatement(query);
    rs = pst.executeQuery();
    tblbody.setModel(DbUtils.resultSetToTableModel(rs));}
          } catch (SQLException ex) {
            Logger.getLogger(Body.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtsearchKeyReleased

    private void showActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showActionPerformed

        TableColumn hiddenColumn = tblbody.getColumnModel().getColumn(5);
        if (show.isSelected()) {
            // Show the hidden column
            hiddenColumn.setMinWidth(100);
            hiddenColumn.setMaxWidth(100);
            hiddenColumn.setPreferredWidth(100);
        } else {
            // Hide the hidden column
            hiddenColumn.setMinWidth(0);
            hiddenColumn.setMaxWidth(0);
            hiddenColumn.setPreferredWidth(0);
        }
    }//GEN-LAST:event_showActionPerformed

    private void btncartMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btncartMouseClicked
System.out.println("Button clicked");  
        int selectedRow = tblbody.getSelectedRow();
        if (selectedRow != -1) { // A row is selected  
            String id = tblbody.getValueAt(selectedRow, 0).toString();
            String itemName = tblbody.getValueAt(selectedRow, 1).toString();
            double price = Double.parseDouble(tblbody.getValueAt(selectedRow, 10).toString());
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
              
}                // TODO add your handling code here:
    }//GEN-LAST:event_btncartMouseClicked

    private void btnbillMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnbillMouseClicked
 Cart cart=new Cart();
        cart.setVisible(true);          // TODO add your handling code here:
    }//GEN-LAST:event_btnbillMouseClicked

    private void btnaddupMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnaddupMouseClicked
Bodyfields bdf=new Bodyfields();
bdf.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_btnaddupMouseClicked

    private void btnarmatureMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnarmatureMouseClicked
        SpareParts sp=new SpareParts();
        sp.setVisible(true);         // TODO add your handling code here:
    }//GEN-LAST:event_btnarmatureMouseClicked

    private void btnfieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnfieldMouseClicked
        Field f=new Field();
        f.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_btnfieldMouseClicked

    private void btngearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btngearMouseClicked
        Gear g=new Gear();
        g.setVisible(true);         // TODO add your handling code here:
    }//GEN-LAST:event_btngearMouseClicked

    private void btnswitchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnswitchMouseClicked
        Switch s=new Switch();
        s.setVisible(true);         // TODO add your handling code here:
    }//GEN-LAST:event_btnswitchMouseClicked

    private void btnbearingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnbearingMouseClicked
        Bearing bb=new Bearing();
        bb.setVisible(true);       // TODO add your handling code here:
    }//GEN-LAST:event_btnbearingMouseClicked

    private void btncarbonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btncarbonMouseClicked
        Carbon car=new Carbon();
        car.setVisible(true);          // TODO add your handling code here:
    }//GEN-LAST:event_btncarbonMouseClicked

    private void btnbodyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnbodyMouseClicked
        Body bo=new Body();
        bo.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_btnbodyMouseClicked

    private void btnrotaryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnrotaryMouseClicked
        RotaryHammer rh=new RotaryHammer();
        rh.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_btnrotaryMouseClicked

    private void btnnbreakersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnnbreakersMouseClicked
        Breakers br=new Breakers();
        br.setVisible(true);         // TODO add your handling code here:
    }//GEN-LAST:event_btnnbreakersMouseClicked

    private void btnothersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnothersMouseClicked
        Others ot=new Others();
        ot.setVisible(true);         // TODO add your handling code here:
    }//GEN-LAST:event_btnothersMouseClicked

    private void lblptMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblptMouseClicked
        PowerToolss pt=new PowerToolss();
        pt.setVisible(true);         // TODO add your handling code here:
    }//GEN-LAST:event_lblptMouseClicked

    private void lblhtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblhtMouseClicked
        Handtools ht=new Handtools();
        ht.setVisible(true);         // TODO add your handling code here:
    }//GEN-LAST:event_lblhtMouseClicked

    private void lblaccessMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblaccessMouseClicked
        Accessories ac=new Accessories();
        ac.setVisible(true);         // TODO add your handling code here:
    }//GEN-LAST:event_lblaccessMouseClicked

    private void lblspMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblspMouseClicked
        SpareParts sp=new SpareParts();
        sp.setVisible(true);          // TODO add your handling code here:
    }//GEN-LAST:event_lblspMouseClicked

    private void lblwireMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblwireMouseClicked
        Wire w=new Wire();
        w.setVisible(true);         // TODO add your handling code here:
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
            java.util.logging.Logger.getLogger(Body.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Body.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Body.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Body.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Body().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnaddup;
    private javax.swing.JLabel btnarmature;
    private javax.swing.JLabel btnbearing;
    private javax.swing.JLabel btnbill;
    private javax.swing.JLabel btnbody;
    private javax.swing.JLabel btncarbon;
    private javax.swing.JLabel btncart;
    private javax.swing.JLabel btncustomer;
    private javax.swing.JLabel btnfield;
    private javax.swing.JLabel btngear;
    private javax.swing.JLabel btnnbreakers;
    private javax.swing.JLabel btnothers;
    private javax.swing.JLabel btnrotary;
    private javax.swing.JLabel btnswitch;
    private javax.swing.JLabel btnwarning;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblaccess;
    private javax.swing.JLabel lblht;
    private javax.swing.JLabel lblpt;
    private javax.swing.JLabel lblsp;
    private javax.swing.JLabel lblwire;
    private javax.swing.JToggleButton show;
    private javax.swing.JTable tblbody;
    private javax.swing.JTextField txtsearch;
    // End of variables declaration//GEN-END:variables
}
