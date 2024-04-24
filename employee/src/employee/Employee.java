package employee;
import java.sql.*;
public class Employee {

    public static void main(String[] args) throws ClassNotFoundException {
        // TODO code application logic here
        String url="jdbc:derby:E:/derby/employee;create=true";
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            Connection conn=DriverManager.getConnection(url); 
            System.out.println("database connected");
            
            
              Statement statement = conn.createStatement();
            
            // Step 4: Execute a query
            String sql = "SELECT * FROM employee";
            ResultSet rs = statement.executeQuery(sql);
            
            // Step 5: Process the result set
            while (rs.next()) {
                // Retrieve data by column name
                int id = rs.getInt("id");
                int salary = rs.getInt("salary");
              
                
                // Print the data
                System.out.println("id " + id + ", salary: " + salary);
            }
            
            // Step 6: Close the resources
            rs.close();
            statement.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
       
    }
    
}
