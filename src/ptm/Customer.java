package ptm;

import javax.swing.*;
import java.util.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
public class Customer extends javax.swing.JFrame {
 Connection con;
    PreparedStatement pst;
    ResultSet rs;
    DefaultTableModel d;
Cart cart=new Cart();
    public void tbl() {
        try {
            pst = con.prepareStatement("select * from customer");
            rs = pst.executeQuery();
            ResultSetMetaData rsd = rs.getMetaData();
            d = (DefaultTableModel) tblcus.getModel();
            d.setRowCount(0);
            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getString("Id"));
                v.add(rs.getString("Name"));
                v.add(rs.getString("phone"));
                v.add(rs.getString("Address"));
                v.add(rs.getString("Occupation"));
                v.add(rs.getString("City"));
                v.add(rs.getString("Purchase"));
                d.addRow(v);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Customer() {
        initComponents();
          Connect();
        tbl();
    }
 public void Connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try {
                con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/ptm", "root", "");
            } catch (SQLException ex) {
                Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        maintenance = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtsearch = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblcus = new javax.swing.JTable();
        Id = new javax.swing.JLabel();
        phone = new javax.swing.JLabel();
        address = new javax.swing.JLabel();
        occu = new javax.swing.JLabel();
        city = new javax.swing.JLabel();
        purchase = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();
        txtaddress = new javax.swing.JTextField();
        txtoccu = new javax.swing.JTextField();
        txtcity = new javax.swing.JTextField();
        txtpurchase = new javax.swing.JTextField();
        txtphone = new javax.swing.JTextField();
        name = new javax.swing.JLabel();
        txtname = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        btnadd = new javax.swing.JLabel();
        btnupdate = new javax.swing.JLabel();
        btndelete = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 51, 102));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        maintenance.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        maintenance.setForeground(new java.awt.Color(255, 255, 255));
        maintenance.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-more-details-30.png"))); // NOI18N
        maintenance.setText("Maintenance Info ");
        maintenance.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                maintenanceMouseClicked(evt);
            }
        });
        jPanel1.add(maintenance, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 30, 160, -1));

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
        jPanel1.add(txtsearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 30, 210, -1));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search_26px.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 30, 30, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1240, 70));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblcus.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tblcus.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Name", "Phone", "Address", "Occupation", "City", "Purchase"
            }
        ));
        tblcus.setShowHorizontalLines(true);
        tblcus.setShowVerticalLines(true);
        tblcus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblcusMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblcus);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 1030, 480));

        Id.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        Id.setText("Id");
        jPanel2.add(Id, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 40, -1));

        phone.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        phone.setText("Phone ");
        jPanel2.add(phone, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 30, 60, -1));

        address.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        address.setText("Address");
        jPanel2.add(address, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 30, 70, -1));

        occu.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        occu.setText("Occupation");
        jPanel2.add(occu, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 70, -1));

        city.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        city.setText("City");
        jPanel2.add(city, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 80, 40, -1));

        purchase.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        purchase.setText("Purchase");
        jPanel2.add(purchase, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 80, 50, -1));
        jPanel2.add(txtid, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 180, -1));
        jPanel2.add(txtaddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 30, 180, -1));
        jPanel2.add(txtoccu, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 180, -1));
        jPanel2.add(txtcity, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 80, 180, -1));
        jPanel2.add(txtpurchase, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 80, 180, -1));
        jPanel2.add(txtphone, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 30, 180, -1));

        name.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        name.setText(" Name");
        jPanel2.add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 30, 60, -1));
        jPanel2.add(txtname, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 30, 180, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 1050, 630));

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
        jPanel3.add(btnadd, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 130, 40));

        btnupdate.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnupdate.setForeground(new java.awt.Color(255, 255, 255));
        btnupdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-available-updates-26.png"))); // NOI18N
        btnupdate.setText("Update");
        btnupdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnupdateMouseClicked(evt);
            }
        });
        jPanel3.add(btnupdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 130, 40));

        btndelete.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btndelete.setForeground(new java.awt.Color(255, 255, 255));
        btndelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-trash-26.png"))); // NOI18N
        btndelete.setText("Delete");
        btndelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btndeleteMouseClicked(evt);
            }
        });
        jPanel3.add(btndelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 110, 40));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 70, 190, 630));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnaddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnaddMouseClicked
          try {
              String Id = txtid.getText();
            String Name = txtname.getText();
            String Phone = txtphone.getText();
            String Address = txtaddress.getText();
            String Occupation = txtoccu.getText();
            String City = txtcity.getText();
            String Purchase = txtpurchase.getText();
            pst = con.prepareStatement("INSERT INTO `customer`(`Id`,`Name`, `Phone`, `Address`, `Occupation`, `City`, `Purchase`) VALUES (?,?,?,?,?,?,?)");
 pst.setString(1, Id);
            pst.setString(2, Name);
            pst.setString(3, Phone);
            pst.setString(4, Address);
            pst.setString(5, Occupation);
            pst.setString(6, City);
            pst.setString(7, Purchase);
            JOptionPane.showMessageDialog(this, "Added successfully!");
            pst.executeUpdate();
            txtid.setText("");
            txtname.setText("");
            txtphone.setText("");
            txtaddress.setText("");
            txtoccu.setText("");
            txtcity.setText("");
            txtpurchase.setText("");    
            tbl();
        } catch (SQLException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnaddMouseClicked

    private void btnupdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnupdateMouseClicked
        try {
String Id = txtid.getText();
String Name = txtname.getText();
            String Phone = txtphone.getText();
            String Address = txtaddress.getText();
            String Occupation = txtoccu.getText();
            String City = txtcity.getText();
            String Purchase = txtpurchase.getText();
           
            pst = con.prepareStatement("UPDATE `customer` SET `Id`=?,`Phone`=?,`Address`=?,`Occupation`=?,`City`=?,`Purchase`=? WHERE `Name`=?");
           pst.setString(7, Name);
           pst.setString(1, Id);
            pst.setString(2, Phone);
            pst.setString(3, Address);
            pst.setString(4, Occupation);
            pst.setString(5, City);
            pst.setString(6, Purchase);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Updated successfully!");
            btnupdate.setEnabled(true);
           txtid.setText("");
           txtname.setText("");
            txtphone.setText("");
            txtaddress.setText("");
            txtoccu.setText("");
            txtcity.setText("");
            txtpurchase.setText("");
            tbl();
            JFrame frame = new JFrame();
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        } catch (SQLException ex) {
            Logger.getLogger(PTAdd.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnupdateMouseClicked

    private void btndeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btndeleteMouseClicked
          try{
            d=(DefaultTableModel)tblcus.getModel();
            int selectIndex=tblcus.getSelectedRow();
            String N=txtname.getText();
            pst=con.prepareStatement("DELETE FROM `customer` WHERE `Name`=?");
            pst.setString(1, N);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Deleted successfully!");
            btnadd.setEnabled(true);
             txtid.setText("");
             txtname.setText("");
            txtphone.setText("");
            txtaddress.setText("");
            txtoccu.setText("");
            txtcity.setText("");
            txtpurchase.setText("");
            tbl();
        }
        catch(SQLException ex)
        {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE,null,ex);
        }
    }//GEN-LAST:event_btndeleteMouseClicked

    private void tblcusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblcusMouseClicked
    d = (DefaultTableModel) tblcus.getModel();
        int sIndex = tblcus.getSelectedRow();
        String id = d.getValueAt(sIndex, 0).toString();
        
        txtid.setText(d.getValueAt(sIndex, 0).toString());
        txtname.setText(d.getValueAt(sIndex, 1).toString());
        txtphone.setText(d.getValueAt(sIndex, 2).toString());
        txtaddress.setText(d.getValueAt(sIndex, 3).toString());
        txtoccu.setText(d.getValueAt(sIndex, 4).toString());
        txtcity.setText(d.getValueAt(sIndex, 5).toString());
        txtpurchase.setText(d.getValueAt(sIndex, 6).toString());
        btnadd.setEnabled(true);
    }//GEN-LAST:event_tblcusMouseClicked

    private void txtsearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtsearchKeyReleased
        String txt=txtsearch.getText();
          try {
             if (txt.matches("^[a-zA-Z0-9]+$")) {
    // Search by ID
    String query = "SELECT * FROM `customer` WHERE `Id` = '" + txt + "'";
    pst = con.prepareStatement(query);
              rs=pst.executeQuery();
              tblcus.setModel(DbUtils.resultSetToTableModel(rs));
              }
               if(txt.matches("^[a-zA-Z]+$"))
              {
              String query="SELECT * FROM `customer` Where `Name` LIKE '%"+txt+"%'";
                pst=con.prepareStatement(query);
              rs=pst.executeQuery();
              tblcus.setModel(DbUtils.resultSetToTableModel(rs));
              }
               if (txt.isEmpty()) {
    String query = "SELECT * FROM `customer`";
    pst = con.prepareStatement(query);
    rs = pst.executeQuery();
    tblcus.setModel(DbUtils.resultSetToTableModel(rs));}
          }
 catch (SQLException ex) {
                Logger.getLogger(Cus.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_txtsearchKeyReleased

    private void maintenanceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_maintenanceMouseClicked
Mainten m=new Mainten();
m.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_maintenanceMouseClicked

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
            java.util.logging.Logger.getLogger(Customer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Customer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Customer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Customer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Customer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Id;
    private javax.swing.JLabel address;
    private javax.swing.JLabel btnadd;
    private javax.swing.JLabel btndelete;
    private javax.swing.JLabel btnupdate;
    private javax.swing.JLabel city;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel maintenance;
    private javax.swing.JLabel name;
    private javax.swing.JLabel occu;
    private javax.swing.JLabel phone;
    private javax.swing.JLabel purchase;
    private javax.swing.JTable tblcus;
    private javax.swing.JTextField txtaddress;
    private javax.swing.JTextField txtcity;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtname;
    private javax.swing.JTextField txtoccu;
    private javax.swing.JTextField txtphone;
    private javax.swing.JTextField txtpurchase;
    private javax.swing.JTextField txtsearch;
    // End of variables declaration//GEN-END:variables
}
