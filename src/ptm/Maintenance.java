package ptm;

import java.util.Date;
import javax.swing.*;
import java.util.*;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

public class Maintenance extends javax.swing.JFrame {

    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    DefaultTableModel d;

    public void tbl() {
        try {
            pst = con.prepareStatement("select * from `maintenance info`");
            rs = pst.executeQuery();
            ResultSetMetaData rsd = rs.getMetaData();
            d = (DefaultTableModel) tblmi.getModel();
            d.setRowCount(0);
            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getString("Id"));
                v.add(rs.getString("Name"));
                v.add(rs.getString("phone"));
                v.add(rs.getString("Mobile"));
                v.add(rs.getString("Bill"));
                v.add(rs.getString("Parts Detail"));
                v.add(rs.getString("Date of Birth"));
                v.add(rs.getString("Date of Maintenance"));
                v.add(rs.getString("Date of Delivery"));
                v.add(rs.getString("Status"));
                d.addRow(v);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Maintenance() {
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
                Logger.getLogger(Maintenance.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Maintenance.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtsearch = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        customer = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblmi = new javax.swing.JTable();
        name = new javax.swing.JLabel();
        phone = new javax.swing.JLabel();
        mn = new javax.swing.JLabel();
        status = new javax.swing.JLabel();
        pd = new javax.swing.JLabel();
        dob = new javax.swing.JLabel();
        txtname = new javax.swing.JTextField();
        txtmn = new javax.swing.JTextField();
        txtstatus = new javax.swing.JTextField();
        txtpd = new javax.swing.JTextField();
        txtphone = new javax.swing.JTextField();
        bill = new javax.swing.JLabel();
        dom = new javax.swing.JLabel();
        dod = new javax.swing.JLabel();
        txtbill = new javax.swing.JTextField();
        Id = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();
        txtdod = new com.toedter.calendar.JDateChooser();
        txtdob = new com.toedter.calendar.JDateChooser();
        txtdom = new com.toedter.calendar.JDateChooser();
        jPanel3 = new javax.swing.JPanel();
        btnadd = new javax.swing.JLabel();
        btndelete = new javax.swing.JLabel();
        btnupdate = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 51, 102));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        customer.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        customer.setForeground(new java.awt.Color(255, 255, 255));
        customer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-user-24.png"))); // NOI18N
        customer.setText("Customer");
        customer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                customerMouseClicked(evt);
            }
        });
        jPanel1.add(customer, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 30, 100, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1240, 70));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblmi.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tblmi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Name", "Phone", "Mobile", "Bill", "Parts Detail", "Date of Birth", "Date of Maintenance", "Date of Delivery", "Status"
            }
        ));
        tblmi.setShowHorizontalLines(true);
        tblmi.setShowVerticalLines(true);
        tblmi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblmiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblmi);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 1030, 430));

        name.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        name.setText("Name");
        jPanel2.add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 50, -1));

        phone.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        phone.setText("Phone ");
        jPanel2.add(phone, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 10, 70, -1));

        mn.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        mn.setText("Mobile No.");
        jPanel2.add(mn, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 10, 80, -1));

        status.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        status.setText("Status");
        jPanel2.add(status, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 90, 90, -1));

        pd.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        pd.setText("Parts Detail");
        jPanel2.add(pd, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 50, 70, -1));

        dob.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        dob.setText("Date of Birth");
        jPanel2.add(dob, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 50, 80, -1));
        jPanel2.add(txtname, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 180, -1));
        jPanel2.add(txtmn, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 10, 180, -1));
        jPanel2.add(txtstatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 90, 180, -1));
        jPanel2.add(txtpd, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 50, 180, -1));
        jPanel2.add(txtphone, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 10, 180, -1));

        bill.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        bill.setText("Bill");
        jPanel2.add(bill, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, 50, -1));

        dom.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        dom.setText("Date of Maintenance");
        jPanel2.add(dom, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 120, -1));

        dod.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        dod.setText("Date of Delivery");
        jPanel2.add(dod, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 90, 100, -1));
        jPanel2.add(txtbill, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 50, 180, -1));

        Id.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        Id.setText("Id");
        jPanel2.add(Id, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, 40, -1));
        jPanel2.add(txtid, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 130, 180, -1));
        jPanel2.add(txtdod, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 90, 180, -1));
        jPanel2.add(txtdob, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 50, 180, -1));
        jPanel2.add(txtdom, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, 180, -1));

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

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 70, 190, 630));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnaddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnaddMouseClicked
        try {
            String Id = txtid.getText();
            String Name = txtname.getText();
            String Phone = txtphone.getText();
            String Mobile = txtmn.getText();
            String Bill = txtbill.getText();
            String PartsDetail = txtpd.getText();
            String Status = txtstatus.getText();
            pst = con.prepareStatement("INSERT INTO `maintenance info`(`Id`,`Name`, `Phone`, `Mobile`, `Bill`, `Parts Detail`, `Date of Birth`, `Date of maintenance`, `Date of Delivery`, `Status`) VALUES (?,?,?,?,?,?,?,?,?,?)");
pst.setString(1, Id);
            pst.setString(2, Name);
            pst.setString(3, Phone);
            pst.setString(4, Mobile);
            pst.setString(5, Bill);
            pst.setString(6, PartsDetail);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String Dob = sdf.format(txtdob.getDate());
            String Dom = sdf.format(txtdom.getDate());
            String Dod = sdf.format(txtdod.getDate());
            pst.setString(7, Dob);
            pst.setString(8, Dom);
            pst.setString(9, Dod);
            pst.setString(10, Status);
            JOptionPane.showMessageDialog(this, "Added successfully!");
            pst.executeUpdate();
            txtid.setText("");
            txtname.setText("");
            txtphone.setText("");
            txtmn.setText("");
            txtbill.setText("");
            txtpd.setText("");
            txtdob.setDate(null);
            txtdom.setDate(null);
            txtdod.setDate(null);
            txtstatus.setText("");
            tbl();
        } catch (SQLException ex) {
            Logger.getLogger(Maintenance.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnaddMouseClicked

    private void btnupdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnupdateMouseClicked
        try {
            String Id = txtid.getText();
            String Name = txtname.getText();
            String Phone = txtphone.getText();
            String Mobile = txtmn.getText();
            String Bill = txtbill.getText();
            String PartsDetail = txtpd.getText();
            String Status = txtstatus.getText();

            pst = con.prepareStatement("UPDATE `maintenance info` SET `Id`=?,`Phone`=?,`Mobile`=?,`Bill`=?,`Parts Detail`=?,`Date of Birth`=?,`Date of maintenance`=?,`Date of Delivery`=?,`Status`=? WHERE `Name`=?");
            
            pst.setString(1, Id);
            pst.setString(2, Phone);
            pst.setString(3, Mobile);
            pst.setString(4, Bill);
            pst.setString(5, PartsDetail);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String Dob = sdf.format(txtdob.getDate());
            String Dom = sdf.format(txtdom.getDate());
            String Dod = sdf.format(txtdod.getDate());
            pst.setString(6, Dob);
            pst.setString(7, Dom);
            pst.setString(8, Dod);
            pst.setString(9, Status);
            pst.setString(10, Name);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Updated successfully!");
            btnupdate.setEnabled(true);
             txtid.setText("");
            txtname.setText("");
            txtphone.setText("");
            txtmn.setText("");
            txtbill.setText("");
            txtpd.setText("");
            txtdob.setDate(null);
            txtdom.setDate(null);
            txtdod.setDate(null);
            txtstatus.setText("");
            tbl();
            JFrame frame = new JFrame();
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        } catch (SQLException ex) {
            Logger.getLogger(Maintenance.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnupdateMouseClicked

    private void tblmiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblmiMouseClicked

        try {
            d = (DefaultTableModel) tblmi.getModel();
            int sIndex = tblmi.getSelectedRow();
            String id = d.getValueAt(sIndex, 0).toString();
            txtid.setText(d.getValueAt(sIndex, 0).toString());
            txtname.setText(d.getValueAt(sIndex, 1).toString());
            txtphone.setText(d.getValueAt(sIndex, 2).toString());
            txtmn.setText(d.getValueAt(sIndex, 3).toString());
            txtbill.setText(d.getValueAt(sIndex, 4).toString());
            txtpd.setText(d.getValueAt(sIndex, 5).toString());
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse((String) d.getValueAt(sIndex, 6).toString());
            txtdob.setDate(date);
            Date dom = new SimpleDateFormat("yyyy-MM-dd").parse((String) d.getValueAt(sIndex, 7).toString());
            txtdom.setDate(date);
            Date dod = new SimpleDateFormat("yyyy-MM-dd").parse((String) d.getValueAt(sIndex, 8).toString());
            txtdod.setDate(date);
            txtstatus.setText(d.getValueAt(sIndex, 9).toString());
            btnadd.setEnabled(true);
        } catch (ParseException ex) {
            Logger.getLogger(Maintenance.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_tblmiMouseClicked

    private void btndeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btndeleteMouseClicked
        try{
            d=(DefaultTableModel)tblmi.getModel();
            int selectIndex=tblmi.getSelectedRow();
            String N=txtname.getText();
            pst=con.prepareStatement("DELETE FROM `maintenance info` WHERE `Name`=?");
            pst.setString(1, N);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Deleted successfully!");
            btnadd.setEnabled(true);
            txtid.setText("");
             txtname.setText("");
            txtphone.setText("");
            txtmn.setText("");
            txtbill.setText("");
            txtpd.setText("");
            txtdob.setDate(null);
            txtdom.setDate(null);
            txtdod.setDate(null);
            txtstatus.setText("");
            tbl();
        }
        catch(SQLException ex)
        {
            Logger.getLogger(Maintenance.class.getName()).log(Level.SEVERE,null,ex);
        }
    }//GEN-LAST:event_btndeleteMouseClicked

    private void txtsearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtsearchKeyReleased
            String txt=txtsearch.getText();
          try {
             if (txt.matches("^[a-zA-Z0-9]+$")) {
    // Search by ID
    String query = "SELECT * FROM `maintenance info` WHERE `Id` = '" + txt + "'";
    pst = con.prepareStatement(query);
              rs=pst.executeQuery();
              tblmi.setModel(DbUtils.resultSetToTableModel(rs));
              }
               if(txt.matches("^[a-zA-Z]+$"))
              {
              String query="SELECT * FROM `maintenance info` Where `Name` LIKE '%"+txt+"%'";
                pst=con.prepareStatement(query);
              rs=pst.executeQuery();
              tblmi.setModel(DbUtils.resultSetToTableModel(rs));
              }
               if (txt.isEmpty()) {
    String query = "SELECT * FROM `maintenance info`";
    pst = con.prepareStatement(query);
    rs = pst.executeQuery();
    tblmi.setModel(DbUtils.resultSetToTableModel(rs));}
          } catch (SQLException ex) {
                Logger.getLogger(Maintenance.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_txtsearchKeyReleased

    private void customerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_customerMouseClicked
Cus c=new Cus();
c.setVisible(true);         // TODO add your handling code here:
    }//GEN-LAST:event_customerMouseClicked

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
            java.util.logging.Logger.getLogger(Maintenance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Maintenance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Maintenance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Maintenance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Maintenance().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Id;
    private javax.swing.JLabel bill;
    private javax.swing.JLabel btnadd;
    private javax.swing.JLabel btndelete;
    private javax.swing.JLabel btnupdate;
    private javax.swing.JLabel customer;
    private javax.swing.JLabel dob;
    private javax.swing.JLabel dod;
    private javax.swing.JLabel dom;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel mn;
    private javax.swing.JLabel name;
    private javax.swing.JLabel pd;
    private javax.swing.JLabel phone;
    private javax.swing.JLabel status;
    private javax.swing.JTable tblmi;
    private javax.swing.JTextField txtbill;
    private com.toedter.calendar.JDateChooser txtdob;
    private com.toedter.calendar.JDateChooser txtdod;
    private com.toedter.calendar.JDateChooser txtdom;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtmn;
    private javax.swing.JTextField txtname;
    private javax.swing.JTextField txtpd;
    private javax.swing.JTextField txtphone;
    private javax.swing.JTextField txtsearch;
    private javax.swing.JTextField txtstatus;
    // End of variables declaration//GEN-END:variables
}
