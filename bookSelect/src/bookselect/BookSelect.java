package bookselect;
import java.sql.*;
public class BookSelect {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String url="jdbc:derby:E:/derby/insert;create=true";
        try {
            Connection conn = DriverManager.getConnection(url) ;
            System.out.println("database connected");
            
            String sql="SELECT FROM * books";
            Statement statement= conn.createStatement();
            ResultSet result=statement.executeQuery(sql);
            
            while(result.next()){
                int id =result.getInt("id");
                String title=result.getString("title");
                String author=result.getString("author");
                double price=result.getDouble("price");
                
                System.out.println("Book ID: " + id);
                System.out.println("Title: " + title);
                System.out.println("Author: " + author);
                System.out.println("Price: " + price);
                System.out.println();
            }
        } catch (SQLException ex) {
      ex.printStackTrace();
        }
            
          
             
            }
    }
    

