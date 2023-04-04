package coore.dataPanel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class ListPro extends JFrame{
    private Connection cursoConn;
    private JTable table;
    public ListPro(){
        super("Listing Admin data");
        setSize(new Dimension(800,800));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            cursoConn = DriverManager.getConnection("jdbc:mysql://localhost/sapcea?"+"user=root&password=");
            Statement stmt = cursoConn.createStatement();

            // Take data from the database
            ResultSet rs = stmt.executeQuery("SELECT * FROM provincia");

            // Create a JTable
            DefaultTableModel model = new DefaultTableModel();
            table = new JTable(model);

            // Add data to the JTable
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                model.addColumn(metaData.getColumnName(i));
            }
            while (rs.next()) {
                Object[] rowData = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    rowData[i-1] = rs.getObject(i);
                }
                model.addRow(rowData);
            }

            // Add the JTable to the JFrame
            JScrollPane scrollPane = new JScrollPane(table);
            add(scrollPane);

            // Close the database connection
            rs.close();
            stmt.close();
            cursoConn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


        setResizable(false);
        setLocationRelativeTo(null);
        list();
        setVisible(true);


    }
}
