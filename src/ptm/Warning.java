package ptm;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import javax.swing.JOptionPane;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Warning {
    // Method to generate PDF report with stock warnings
    public void generateWarningReport() {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet tables = null;
        try {
            // Establish database connection
            con = DriverManager.getConnection("jdbc:mysql://localhost/ptm", "root", "");

            // Get metadata of database tables
            tables = con.getMetaData().getTables("ptm", null, null, new String[]{"TABLE"});
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream("stock_warnings.pdf"));
            document.open();

            List<String> warningTables = new ArrayList<>();

            while (tables.next()) {
                String tableName = tables.getString("TABLE_NAME");
                System.out.println(tableName);

                String query;
                if ("gear".equalsIgnoreCase(tableName) || "field".equalsIgnoreCase(tableName) || "accessories".equalsIgnoreCase(tableName)) {
                    query = "SELECT `Id`, `Name` FROM `" + tableName + "`  WHERE `Total Quantity` <= 1";

                } else if ("bearing".equalsIgnoreCase(tableName) || "bits".equalsIgnoreCase(tableName) || "body".equalsIgnoreCase(tableName) || "breakers".equalsIgnoreCase(tableName) || "carbon".equalsIgnoreCase(tableName) || "chisel".equalsIgnoreCase(tableName) || "chucknut".equalsIgnoreCase(tableName) || "handle".equalsIgnoreCase(tableName) || "hand tools".equalsIgnoreCase(tableName) || "keys".equalsIgnoreCase(tableName) || "others".equalsIgnoreCase(tableName) || "powertolls".equalsIgnoreCase(tableName) || "rotary hammer".equalsIgnoreCase(tableName) || "safe gaurd".equalsIgnoreCase(tableName) || "spare parts".equalsIgnoreCase(tableName) || "switch".equalsIgnoreCase(tableName) || "welding".equalsIgnoreCase(tableName) || "wire".equalsIgnoreCase(tableName)) {
                    query = "SELECT `Id`, `Name`  FROM `" + tableName + "` WHERE `Total Quantity` <= 3";
                } else {
                    continue; // Skip tables that don't need to be included in the warning report
                }

                pst = con.prepareStatement(query);
                try (ResultSet rs = pst.executeQuery()) {
                    if (rs.next()) {
                        warningTables.add(tableName);
                    }
                }
            }


            for (String tableName : warningTables) {
                document.add(new Paragraph("Stock Warnings for Table: " + tableName));

                String query = "SELECT * FROM `" + tableName + "` WHERE `Total Quantity` <= 1 OR `Total Quantity` <= 3";
                pst = con.prepareStatement(query);
                try (ResultSet rs = pst.executeQuery()) {

                    while (rs.next()) {
                        String id = rs.getString("Id");
                        String itemName = rs.getString("Name");

                        document.add(new Paragraph("ID: " + id));
                        document.add(new Paragraph("Name: " + itemName));
                        document.add(new Paragraph("\n"));
                    }
                }
                document.add(new Paragraph("\n"));
            }

            document.close();
            System.out.println("Warning report generated successfully.");

            // Open the generated PDF file
            Desktop.getDesktop().open(new File("stock_warnings.pdf"));

            // Display a message indicating successful PDF generation
            JOptionPane.showMessageDialog(null, "Warning report generated successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException | DocumentException | IOException e) {
            System.out.println("Error generating warning report: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error generating warning report: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        Warning warning = new Warning();
        warning.generateWarningReport();
    }
}
