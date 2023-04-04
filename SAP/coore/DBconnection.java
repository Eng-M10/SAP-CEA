package coore;

import javax.swing.*;
import java.sql.*;

public class DBconnection {
    Connection conn = null;
        public DBconnection(){
            try{

                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection("jdbc:mysql://localhost/joke?"+"user=root&password=");
            }catch(Exception exc){
                JOptionPane.showMessageDialog(null,""+exc.getMessage());
            }
        }

}
