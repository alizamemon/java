/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Railway;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.DriverManager;
 /*
 * @author Aliza Nisar
 */
public class connect {
    
    
public static Connection connectdb() throws ClassNotFoundException, SQLException{
        try {
            Connection con=null;
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            con=DriverManager.getConnection("jdbc:derby:test;create=true","passenger","paseenger");
            return con;
        } catch (SQLException ex) {
            Logger.getLogger(connect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
