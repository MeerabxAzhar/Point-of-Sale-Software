package ptm;
import javax.swing.*;
import java.util.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
public class BearingFields extends javax.swing.JFrame {
Connection con;
    PreparedStatement pst;
    ResultSet rs;
    DefaultTableModel d;
    Cart cart=new Cart();
 public void tbl() {
        try {
            pst = con.prepareStatement("select * from `bearing`");
            rs = pst.executeQuery();
            ResultSetMetaData rsd = rs.getMetaData();
            d = (DefaultTableModel) tblb.getModel();
            d.setRowCount(0);
            while (rs.next()) {
                Vector v = new Vector();
                 v.add(rs.getString("Id"));
                v.add(rs.getString("Name"));
                v.add(rs.getString("Model No"));
                v.add(rs.getString("Company"));
                v.add(rs.getString("Brand"));
                v.add(rs.getString("C.P"));
                v.add(rs.getString("W.P"));
                v.add(rs.getString("R.P"));
                v.add(rs.getString("Total Quantity"));
                v.add(rs.getString("Show Room"));
                v.add(rs.getString("G.D"));
                v.add(rs.getString("T.C"));
                v.add(rs.getString("O.D"));
                v.add(rs.getString("I.D"));
                v.add(rs.getString("Width"));
                d.addRow(v);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BearingFields.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 public void Connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try {
                con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/ptm", "root", "");
            } catch (SQLException ex) {
                Logger.getLogger(BearingFields.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BearingFields.class.getName()).log(Level.SEVERE, null, ex);
        }}
    public BearingFields() {
        initComponents();
        Connect();
        tbl();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        name = new javax.swing.JLabel();
        mn = new javax.swing.JLabel();
        company = new javax.swing.JLabel();
        brand = new javax.swing.JLabel();
        cp = new javax.swing.JLabel();
        wp = new javax.swing.JLabel();
        rp = new javax.swing.JLabel();
        godam = new javax.swing.JLabel();
        txtname = new javax.swing.JTextField();
        txtmn = new javax.swing.JTextField();
        txtrp = new javax.swing.JTextField();
        txtcp = new javax.swing.JTextField();
        txtwp = new javax.swing.JTextField();
        txtsr = new javax.swing.JTextField();
        combobrand = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        lblptbill1 = new javax.swing.JLabel();
        lblptadd11 = new javax.swing.JLabel();
        lblptupdate = new javax.swing.JLabel();
        txtcompany = new javax.swing.JTextField();
        sr = new javax.swing.JLabel();
        od = new javax.swing.JLabel();
        width = new javax.swing.JLabel();
        id = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();
        txtwidth = new javax.swing.JTextField();
        txtgodam = new javax.swing.JTextField();
        txtod = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblb = new javax.swing.JTable();
        Id = new javax.swing.JLabel();
        txti = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        btnadd = new javax.swing.JLabel();
        btnupdate = new javax.swing.JLabel();
        btnbill = new javax.swing.JLabel();
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

        name.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        name.setText("Name");
        jPanel2.add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 70, -1));

        mn.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        mn.setText("Model No.");
        jPanel2.add(mn, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, 60, -1));

        company.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        company.setText("Company");
        jPanel2.add(company, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 10, 60, -1));

        brand.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        brand.setText("Brand");
        jPanel2.add(brand, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 10, 50, -1));

        cp.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        cp.setText("Cost Price");
        jPanel2.add(cp, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 50, 70, -1));

        wp.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        wp.setText("Whole Price");
        jPanel2.add(wp, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 50, 80, -1));

        rp.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        rp.setText("Retail Price");
        jPanel2.add(rp, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 70, -1));

        godam.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        godam.setText("Godam");
        jPanel2.add(godam, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 70, -1));

        txtname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnameActionPerformed(evt);
            }
        });
        jPanel2.add(txtname, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 160, -1));
        jPanel2.add(txtmn, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 10, 160, -1));
        jPanel2.add(txtrp, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, 160, -1));
        jPanel2.add(txtcp, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 50, 160, -1));
        jPanel2.add(txtwp, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 50, 160, -1));
        jPanel2.add(txtsr, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 50, 160, -1));

        combobrand.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Choose a Brand", " " }));
        jPanel2.add(combobrand, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 10, 160, -1));

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
        jPanel2.add(txtcompany, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 10, 160, -1));

        sr.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        sr.setText("Show Room");
        jPanel2.add(sr, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 50, -1, -1));

        od.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        od.setText("O.D");
        jPanel2.add(od, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 90, 50, -1));

        width.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        width.setText("Width");
        jPanel2.add(width, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 90, 70, -1));

        id.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        id.setText("I.D");
        jPanel2.add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 90, 70, -1));
        jPanel2.add(txtid, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 90, 160, -1));
        jPanel2.add(txtwidth, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 90, 160, -1));
        jPanel2.add(txtgodam, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, 160, -1));
        jPanel2.add(txtod, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 90, 160, -1));

        tblb.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tblb.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Name", "Model No.", "Company", "Brand", "C.P", "W.P", "R.P", "T.Q", "S.R", "G.D", "T.C", "O.D", "I.D", "Width"
            }
        ));
        tblb.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tblb.setShowHorizontalLines(true);
        tblb.setShowVerticalLines(true);
        tblb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblbMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblb);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 1000, 450));

        Id.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        Id.setText("Id");
        jPanel2.add(Id, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 40, 20));
        jPanel2.add(txti, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, 160, 20));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 1000, 630));

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

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 70, 100, 630));

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

    private void txtnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnameActionPerformed

    private void txtsearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtsearchKeyReleased
         String txt=txtsearch.getText();
          try {
              if(txt.matches("^[0-9]+$")){
            String query="SELECT * FROM `bearing` Where `Model No`="+txt;
                pst=con.prepareStatement(query);
              rs=pst.executeQuery();
              tblb.setModel(DbUtils.resultSetToTableModel(rs));
              }
            else if (txt.matches("^[a-zA-Z0-9]+$")) {
    // Search by ID
    String query = "SELECT * FROM `bearing` WHERE `Id` = '" + txt + "'";
    pst = con.prepareStatement(query);
              rs=pst.executeQuery();
              tblb.setModel(DbUtils.resultSetToTableModel(rs));
              }
               if(txt.matches("^[a-zA-Z]+$"))
              {
              String query="SELECT * FROM `bearing` Where `Name` LIKE '%"+txt+"%'";
                pst=con.prepareStatement(query);
              rs=pst.executeQuery();
              tblb.setModel(DbUtils.resultSetToTableModel(rs));
              }
               if (txt.isEmpty()) {
    String query = "SELECT * FROM `bearing`";
    pst = con.prepareStatement(query);
    rs = pst.executeQuery();
    tblb.setModel(DbUtils.resultSetToTableModel(rs));}
          }catch (SQLException ex) {
            Logger.getLogger(BearingFields.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtsearchKeyReleased

    private void tblbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblbMouseClicked
        d = (DefaultTableModel) tblb.getModel();
        int sIndex = tblb.getSelectedRow();
        String id = d.getValueAt(sIndex, 0).toString();
        txti.setText(d.getValueAt(sIndex, 0).toString());
        txtname.setText(d.getValueAt(sIndex, 1).toString());
        txtmn.setText(d.getValueAt(sIndex, 2).toString());
        txtcompany.setText(d.getValueAt(sIndex, 3).toString());
        combobrand.setSelectedItem(d.getValueAt(sIndex, 4).toString());
        txtcp.setText(d.getValueAt(sIndex, 5).toString());
        txtwp.setText(d.getValueAt(sIndex, 6).toString());
        txtrp.setText(d.getValueAt(sIndex, 7).toString());
        txtsr.setText(d.getValueAt(sIndex, 9).toString());
        txtgodam.setText(d.getValueAt(sIndex, 10).toString());
        txtod.setText(d.getValueAt(sIndex, 12).toString());
        txtid.setText(d.getValueAt(sIndex, 13).toString());
        txtwidth.setText(d.getValueAt(sIndex, 14).toString());
        btnadd.setEnabled(true);
    }//GEN-LAST:event_tblbMouseClicked

    private void btnaddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnaddMouseClicked
         try {
            String Id = txti.getText();
            String Name = txtname.getText();
            String Modelno = txtmn.getText();
            String Company = txtcompany.getText();
            String Brand = (String) combobrand.getSelectedItem();
            String CostPrice = txtcp.getText();
            String WholeSale = txtwp.getText();
            String RSale = txtrp.getText();
            String ShowRoom = txtsr.getText();
            String Godam = txtgodam.getText();
            String CoreID = txtod.getText();
            String CoreOD = txtid.getText();
            String CoreLength = txtwidth.getText();
            int TotalQuantity = Integer.parseInt(txtsr.getText()) + Integer.parseInt(txtgodam.getText());
            Double TotalCost = Double.parseDouble(txtcp.getText()) * TotalQuantity;
            pst = con.prepareStatement("INSERT INTO `bearing`(`Id`, `Name`, `Model No`, `Company`, `Brand`, `C.P`, `W.P`, `R.P`, `Total Quantity`, `Show Room`, `G.D`, `T.C`, `O.D`, `I.D`, `Width`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, Id);
            pst.setString(2, Name);
            pst.setString(3, Modelno);
            pst.setString(4, Company);
            pst.setString(5, Brand);
            pst.setString(6, CostPrice);
            pst.setString(7, WholeSale);
            pst.setString(8, RSale);
            pst.setInt(9, TotalQuantity);
            pst.setString(10, ShowRoom);
            pst.setString(11, Godam);
            pst.setDouble(12, TotalCost);
            pst.setString(13, CoreID);
            pst.setString(14, CoreOD);
            pst.setString(15, CoreLength);
            JOptionPane.showMessageDialog(this, "Added successfully!");
            pst.executeUpdate();
            txti.setText("");
            txtname.setText("");
            txtmn.setText("");
            txtcompany.setText("");
            combobrand.setSelectedItem("Choose a Brand");
            txtcp.setText("");
            txtwp.setText("");
            txtrp.setText("");
            txtsr.setText("");
            txtgodam.setText("");
            txtod.setText("");
            txtid.setText("");
            txtwidth.setText("");
            tbl();
        } catch (SQLException ex) {
            Logger.getLogger(BearingFields.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnaddMouseClicked

    private void btnupdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnupdateMouseClicked
          try {
  String Id = txti.getText();
            String Name = txtname.getText();
            String Modelno = txtmn.getText();
            String Company = txtcompany.getText();
            String Brand = (String) combobrand.getSelectedItem();
            String CostPrice = txtcp.getText();
            String WholeSale = txtwp.getText();
            String RSale = txtrp.getText();
            String ShowRoom = txtsr.getText();
            String Godam = txtgodam.getText();
            String CoreID = txtod.getText();
            String CoreOD = txtid.getText();
            String CoreLength = txtwidth.getText();
            int TotalQuantity = Integer.parseInt(txtsr.getText()) + Integer.parseInt(txtgodam.getText());
            Double TotalCost = Double.parseDouble(txtcp.getText()) * TotalQuantity;
            pst = con.prepareStatement("UPDATE `bearing` SET `Id`=?,`Name`=?,`Company`=?,`Brand`=?,`C.P`=?,`W.P`=?,`R.P`=?,`Total Quantity`=?,`Show Room`=?,`G.D`=?,`T.C`=?,`O.D`=?,`I.D`=?,`Width`=? WHERE `Model No`=?");
             pst.setString(1, Id);
            pst.setString(2, Name);
            pst.setString(15, Modelno);
            pst.setString(3, Company);
            pst.setString(4, Brand);
            pst.setString(5, CostPrice);
            pst.setString(6, WholeSale);
            pst.setString(7, RSale);
            pst.setInt(8, TotalQuantity);
            pst.setString(9, ShowRoom);
            pst.setString(10, Godam);
            pst.setDouble(11, TotalCost);
            pst.setString(12, CoreID);
            pst.setString(13, CoreOD);
            pst.setString(14, CoreLength);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Updated successfully!");
            btnupdate.setEnabled(true);
           txti.setText("");
            txtname.setText("");
            txtmn.setText("");
            txtcompany.setText("");
            combobrand.setSelectedItem("Choose a Brand");
            txtcp.setText("");
            txtwp.setText("");
            txtrp.setText("");
            txtsr.setText("");
            txtgodam.setText("");
            txtod.setText("");
            txtid.setText("");
            txtwidth.setText("");
            tbl();
            JFrame frame = new JFrame();
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        } catch (SQLException ex) {
            Logger.getLogger(BearingFields.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnupdateMouseClicked

    private void btncartMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btncartMouseClicked
System.out.println("Button clicked");  
        int selectedRow = tblb.getSelectedRow();
        if (selectedRow != -1) { // A row is selected  
            String id = tblb.getValueAt(selectedRow, 0).toString();
            String itemName = tblb.getValueAt(selectedRow, 1).toString();
            double price = Double.parseDouble(tblb.getValueAt(selectedRow, 10).toString());
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
              
}               // TODO add your handling code here:
    }//GEN-LAST:event_btncartMouseClicked

    private void btnbillMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnbillMouseClicked
 Cart cart=new Cart();
        cart.setVisible(true);          // TODO add your handling code here:
    }//GEN-LAST:event_btnbillMouseClicked

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
            java.util.logging.Logger.getLogger(BearingFields.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BearingFields.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BearingFields.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BearingFields.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BearingFields().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Id;
    private javax.swing.JLabel brand;
    private javax.swing.JLabel btnadd;
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
    private javax.swing.JLabel btnupdate;
    private javax.swing.JLabel btnwarning;
    private javax.swing.JComboBox<String> combobrand;
    private javax.swing.JLabel company;
    private javax.swing.JLabel cp;
    private javax.swing.JLabel godam;
    private javax.swing.JLabel id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
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
    private javax.swing.JLabel mn;
    private javax.swing.JLabel name;
    private javax.swing.JLabel od;
    private javax.swing.JLabel rp;
    private javax.swing.JLabel sr;
    private javax.swing.JTable tblb;
    private javax.swing.JTextField txtcompany;
    private javax.swing.JTextField txtcp;
    private javax.swing.JTextField txtgodam;
    private javax.swing.JTextField txti;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtmn;
    private javax.swing.JTextField txtname;
    private javax.swing.JTextField txtod;
    private javax.swing.JTextField txtrp;
    private javax.swing.JTextField txtsearch;
    private javax.swing.JTextField txtsr;
    private javax.swing.JTextField txtwidth;
    private javax.swing.JTextField txtwp;
    private javax.swing.JLabel width;
    private javax.swing.JLabel wp;
    // End of variables declaration//GEN-END:variables
}
