
package booksupdate;
import java.sql.*;

public class BooksUpdate {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
            String url="jdbc:derby:E:/derby/insert;create=true";
        try {
            Connection conn=DriverManager.getConnection(url);
             System.out.println("database connected");
             
               
                String sql = "UPDATE books SET price= price + 20";
                Statement statement = conn.createStatement();
                int rowsAffected = statement.executeUpdate(sql);
                
                System.out.println(rowsAffected + " record(s) updated successfully.");
                
                statement.close();
                conn.close();
                
        } catch (SQLException ex) {
              ex.printStackTrace();
        }
           
    }
    
}
