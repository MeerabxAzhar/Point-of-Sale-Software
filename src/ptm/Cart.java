package ptm;

import com.itextpdf.text.Chunk;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
public class Cart extends javax.swing.JFrame {
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    DefaultTableModel d;
    String itemName;
    String id;
    double price;
    double total;
    private DefaultTableModel cartModel;
    public void tbl() {
        try {
            pst = con.prepareStatement("select * from `cart`");
            rs = pst.executeQuery();
            ResultSetMetaData rsd = rs.getMetaData();
            d = (DefaultTableModel) cart.getModel();
            d.setRowCount(0);
            while (rs.next()) {
                Vector v = new Vector();

                v.add(rs.getString("Product id"));
                v.add(rs.getString("Product name"));
                v.add(rs.getString("Product price"));
                v.add(rs.getString("Quantity"));
                v.add(rs.getInt("Total price"));
                d.addRow(v);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Cart.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Cart() {
        initComponents();
        Connect();
        tbl();
        cartModel = (DefaultTableModel) cart.getModel();
        double totalPrice = 0;
              for (int i = 0; i < cartModel.getRowCount(); i++) {
                   double value = Double.valueOf(cart.getValueAt(i, 4).toString());
         totalPrice += value ;    
            }
         System.out.println(totalPrice);
          jt.setText(Double.toString(totalPrice));
    }
    public void Connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try {
                con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/ptm", "root", "");
            } catch (SQLException ex) {
                Logger.getLogger(Cart.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Cart.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

private String getTableName(String id) throws SQLException {
    // List of all tables in the database
    List<String> tables = new ArrayList<>();
    ResultSet tablesResultSet = con.getMetaData().getTables("ptm", null, null, new String[]{"TABLE"});
    while (tablesResultSet.next()) {
        tables.add(tablesResultSet.getString("TABLE_NAME"));
    }

    // Check each table to see if the product ID exists
    for (String tableName : tables) {
        // Check if the table contains 'id' in its column names
        boolean containsIdColumn = false;
        ResultSet columnsResultSet = con.getMetaData().getColumns("ptm", null, tableName, null);
        while (columnsResultSet.next()) {
            if (columnsResultSet.getString("COLUMN_NAME").equalsIgnoreCase("id")) {
                containsIdColumn = true;
                break;
            }
        }

        if (!containsIdColumn) {
            // Skip tables that don't contain 'id'
            continue;
        }

        pst = con.prepareStatement("SELECT `Id` FROM `" + tableName + "` WHERE `Id` = ?");
        pst.setString(1, id);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            // Product found in this table
            return tableName;
        }
    }

    // Product not found in any table
    return null;
}

    public void addToCart(String id, String itemName, double price, int Quantity, double total) {
        
        DefaultTableModel cartModel = (DefaultTableModel) cart.getModel();
        cartModel.addRow(new Object[]{id, itemName, price, Quantity, total});
        try {
         // Determine the table from which the product is selected
        String tableName = getTableName(id);
        if (tableName == null) {
            System.out.println("Product not found in any showroom.");
            return;
        }

        // Retrieve current quantity of the product from the corresponding showroom table
        pst = con.prepareStatement("SELECT `Show Room` FROM `" + tableName + "` WHERE `Id` = ?");
        pst.setString(1, id);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            int currentQuantity = rs.getInt("Show Room");
            // Check if the requested quantity is available in the showroom
            if (currentQuantity >= Quantity) {
                // Subtract the requested quantity from the showroom quantity
                int updatedQuantity = currentQuantity - Quantity;
                // Update the showroom table with the new quantity
                pst = con.prepareStatement("UPDATE `" + tableName + "` SET `Show Room` = ? WHERE `Id` = ?");
                
                pst.setInt(1, updatedQuantity);
                pst.setString(2, id);
                int rowsUpdated = pst.executeUpdate();
                if (rowsUpdated > 0) {
                    System.out.println("Showroom quantity updated successfully.");
                } else {
                    System.out.println("Failed to update showroom quantity.");
                }
            } else {
                // Show a prompt indicating that the requested quantity is not available
                JOptionPane.showMessageDialog(this, "Requested quantity not available in showroom.");
            }
        } else {
            System.out.println("Product not found in showroom.");
        }
            pst = con.prepareStatement("INSERT INTO `cart`(`Product id`, `Product name`, `Product price`, `Quantity`, `Total price` ) VALUES (?,?,?,?,?)");
            pst.setString(1, id);
            pst.setString(2, itemName);          
            pst.setInt(4, Quantity);
            pst.setDouble(3, price);
            pst.setDouble(5, total);
            
            int rowsInserted = pst.executeUpdate();
            tbl();

            if (rowsInserted > 0) {
                System.out.println("Data inserted successfully into the database.");
            } else {
                System.out.println("Data insertion failed.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Cart.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        cart = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jt = new java.awt.Label();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 102));

        cart.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Product ID", "Product name", "Product price", "Quantity", "Total price"
            }
        ));
        cart.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cartMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(cart);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setText("Cart items");

        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jButton1.setText("Remove item from cart");
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

        jButton2.setText("Back");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setText("Grand Total Price:");

        jButton3.setBackground(new java.awt.Color(0, 0, 102));
        jButton3.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-bill-24.png"))); // NOI18N
        jButton3.setText("Print Bill");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jt.setFont(new java.awt.Font("Times New Roman", 1, 24));
        jt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jtMouseEntered(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 531, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 493, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(69, 69, 69)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton1)
                                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(120, 120, 120)
                                .addComponent(jt, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(246, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jButton2)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jt, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(72, 72, 72)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        try {
        d = (DefaultTableModel) cart.getModel();
        int selectIndex = cart.getSelectedRow();
        String productId = (String) d.getValueAt(selectIndex, 0); // Assuming product ID is in the first column

        // Retrieve the table name of the product
        String tableName = getTableName(productId);
        if (tableName == null) {
            JOptionPane.showMessageDialog(this, "Product not found in any showroom.");
            return;
        }

        // Retrieve the original quantity of the product
        pst = con.prepareStatement("SELECT `Show Room` FROM `" + tableName + "` WHERE `Id` = ?");
        pst.setString(1, productId);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            int originalQuantity = rs.getInt("Show Room");

            // Retrieve the quantity from the cart
            int quantityInCart = Integer.parseInt(d.getValueAt(selectIndex, 3).toString()); // Assuming quantity is in the fourth column

            // Update the quantity in the showroom
            int updatedQuantity = originalQuantity + quantityInCart;
            pst = con.prepareStatement("UPDATE `" + tableName + "` SET `Show Room` = ? WHERE `Id` = ?");
            pst.setInt(1, updatedQuantity);
            pst.setString(2, productId);
            int rowsUpdated = pst.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Quantity updated successfully in showroom.");
            } else {
                System.out.println("Failed to update quantity in showroom.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Product not found in showroom.");
        }

        // Delete the item from the cart
        pst = con.prepareStatement("DELETE FROM `cart` WHERE `Product id` = ?");
        pst.setString(1, productId);
        int rowsAffected = pst.executeUpdate();
        if (rowsAffected > 0) {
            JOptionPane.showMessageDialog(this, "Item removed from cart successfully!");
            tbl(); // Refresh the cart table
        } else {
            JOptionPane.showMessageDialog(this, "Failed to remove item from cart.");
        }
    } catch (SQLException ex) {
        Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked


    }//GEN-LAST:event_jButton2MouseClicked

    private void cartMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cartMouseClicked
        DefaultTableModel RecordTable = (DefaultTableModel) cart.getModel();
        int SelectedRows = cart.getSelectedRow();
    }//GEN-LAST:event_cartMouseClicked

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
 
  try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/ptm", "root", "");

            // Prompt user for customer name
            String customerName = JOptionPane.showInputDialog(null, "Enter customer name:");
            // Create PDF document
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream("bill.pdf"));
            document.open();

            // Add store details
           Font boldFont = new Font(Font.FontFamily.TIMES_ROMAN, 30, Font.BOLD);
            Paragraph storeName = new Paragraph("Quetta Power Tools - QPT", boldFont);
            storeName.setAlignment(Paragraph.ALIGN_CENTER);
            document.add(storeName);
            Chunk lineChunk = new Chunk("------------------------------------------------------");
            Font font = new Font();
            font.setSize(25); // Set the font size
            lineChunk.setFont(font);
            Paragraph separator = new Paragraph(lineChunk);
            separator.setAlignment(Element.ALIGN_CENTER);
            document.add(separator);

            Font stfont = new Font(Font.FontFamily.TIMES_ROMAN, 24, Font.BOLD);
            Paragraph storeType = new Paragraph("Hardware Store", stfont);
            storeType.setAlignment(Paragraph.ALIGN_CENTER);
            document.add(storeType);
            document.add(new Paragraph("\n"));
            document.add(new Paragraph("\n"));
            Paragraph country = new Paragraph("Pakistan - Gujrat");
            country.setAlignment(Paragraph.ALIGN_CENTER);
            document.add(country);
            Paragraph address = new Paragraph("Address: Shah Hussain Rd, Shah Hussain, Gujrat, Punjab, Pakistan");
            address.setAlignment(Paragraph.ALIGN_CENTER);
            document.add(address);
           Paragraph email = new Paragraph("Email: Quettapowertools@gmail.com");
            email.setAlignment(Paragraph.ALIGN_CENTER);
            document.add(email);
            // Generate transaction number
            Random rand = new Random();
            int transactionNumber = rand.nextInt(1000000); // Generate a random 6-digit number
            Paragraph transactionParagraph = new Paragraph("Transaction No: " + transactionNumber);
            transactionParagraph.setAlignment(Paragraph.ALIGN_CENTER);
            document.add(transactionParagraph);
            
            // Add customer name
            if (customerName != null && !customerName.isEmpty()) {
                Paragraph customerParagraph = new Paragraph("Customer: " + customerName);
                customerParagraph.setAlignment(Element.ALIGN_CENTER);
                document.add(customerParagraph);
                document.add(new Paragraph("\n"));
            }

            // Adding current date and time to the bill
LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
            String formattedDate = now.format(dateFormatter);
            String formattedTime = now.format(timeFormatter);

            Paragraph dateParagraph = new Paragraph("Transaction Date: " + formattedDate);
            dateParagraph.setAlignment(Element.ALIGN_CENTER);
            document.add(dateParagraph);

            Paragraph timeParagraph = new Paragraph("Transaction Time: " + formattedTime);
            timeParagraph.setAlignment(Element.ALIGN_CENTER);
            document.add(timeParagraph);

            document.add(new Paragraph("\n"));

            // Retrieve data from the database and populate the PDF
            String query = "SELECT `Product name`, `Product price`, `Total price`, `Quantity` FROM `cart`";
            PreparedStatement pst = con.prepareStatement(query);
            ResultSet rs = pst.executeQuery();

            double totalPrice = 0; // Initialize total price variable

            while (rs.next()) {
                String productName = rs.getString("Product name");
                int quantity = rs.getInt("Quantity");
                double price = rs.getDouble("Total price");

                Paragraph productNameParagraph = new Paragraph("Product Name: " + productName);
                productNameParagraph.setAlignment(Element.ALIGN_CENTER);
                document.add(productNameParagraph);
                Paragraph quantityParagraph = new Paragraph("Quantity: " + quantity);
                quantityParagraph.setAlignment(Element.ALIGN_CENTER);
                document.add(quantityParagraph);
                Paragraph priceParagraph = new Paragraph("Price: $" + price);
                priceParagraph.setAlignment(Element.ALIGN_CENTER);
                document.add(priceParagraph);
                document.add(new Paragraph("\n"));

                // Calculate total price
                totalPrice += price * quantity;
            }

            Paragraph totalPriceParagraph = new Paragraph("Total Price: $" + totalPrice);
            totalPriceParagraph.setAlignment(Element.ALIGN_CENTER);
            document.add(totalPriceParagraph);

            document.close();
            JOptionPane.showMessageDialog(null, "Bill generated successfully!");
            
            // Open the generated PDF using the default PDF viewer
            File file = new File("bill.pdf");
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().open(file);
            } else {
                JOptionPane.showMessageDialog(null, "PDF viewer not supported!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error generating bill: " + e.getMessage());
        } 
 try {
     
        // Delete all entries from the database
        pst = con.prepareStatement("DELETE FROM `cart`");
        pst.executeUpdate();
        System.out.println("All entries deleted successfully from the database.");
        
        // Clear the table in the GUI
        DefaultTableModel cartModel = (DefaultTableModel) cart.getModel();
        cartModel.setRowCount(0);
        System.out.println("Table cleared successfully.");
    } catch (SQLException ex) {
        Logger.getLogger(Cart.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_jButton3MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jtMouseEntered

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cart().setVisible(true);
              
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable cart;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private java.awt.Label jt;
    // End of variables declaration//GEN-END:variables
}
