/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package books;
import java.sql.*;
/**
 *
 * @author Aliza Nisar
 */
public class Books {

    
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            String url="jdbc:derby:E:/derby/insert;create=true";
            Connection conn=DriverManager.getConnection(url);
            System.out.println("database connected");
            
            String sql="INSERT INTO books(id,title,author,price)VALUES"+
                    "(7,'oop','kioio',30.99)";
            Statement statement=conn.createStatement();
            int rows= statement.executeUpdate(sql);
            
            if(rows > 0){
                System.out.println("A new book has been inserted");
            }
              
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
 
    }
    
}
