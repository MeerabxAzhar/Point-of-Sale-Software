package ptm;

import javax.swing.*;
import java.util.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
public class Cus extends javax.swing.JFrame {
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
    public Cus() {
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
        jPanel3 = new javax.swing.JPanel();
        btnadd = new javax.swing.JLabel();

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

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 1030, 560));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 1050, 630));

        jPanel3.setBackground(new java.awt.Color(0, 51, 102));
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnadd.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnadd.setForeground(new java.awt.Color(255, 255, 255));
        btnadd.setText("Add/Update/Delete");
        btnadd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnaddMouseClicked(evt);
            }
        });
        jPanel3.add(btnadd, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 160, 40));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 70, 190, 630));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void tblcusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblcusMouseClicked
        
    }//GEN-LAST:event_tblcusMouseClicked

    private void btnaddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnaddMouseClicked
Customer c=new Customer();
c.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_btnaddMouseClicked

    private void maintenanceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_maintenanceMouseClicked
Mainten m=new Mainten();
m.setVisible(true);        // TODO add your handling code here:
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
            java.util.logging.Logger.getLogger(Cus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cus().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnadd;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel maintenance;
    private javax.swing.JTable tblcus;
    private javax.swing.JTextField txtsearch;
    // End of variables declaration//GEN-END:variables
}
