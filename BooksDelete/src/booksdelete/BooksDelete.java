package booksdelete;
import java.sql.*;
public class BooksDelete {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            String url="jdbc:derby:E:/derby/insert;create=true";
            Connection conn=DriverManager.getConnection(url);
            System.out.println("database connected");
            
            String sql = "DELETE FROM books WHERE id = ?";
            PreparedStatement statement =conn.prepareStatement(sql);
            
            int bookIdToDelete = 6;
            statement.setInt(1, bookIdToDelete);
            
            int rowsAffected = statement.executeUpdate();

            // Check the number of affected rows
            if (rowsAffected > 0) {
                System.out.println(rowsAffected + " record(s) deleted successfully.");
            } else {
                System.out.println("No records deleted.");
            }
       
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
}
