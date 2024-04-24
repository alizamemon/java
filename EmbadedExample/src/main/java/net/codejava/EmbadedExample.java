/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package net.codejava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class EmbadedExample {

    public static void main(String[] args) {
       String databaseURL = "jdbc:derby:E:/Derby/Bookstore";
       try {
       Connection connection = DriverManager.getConnection(databaseURL);
//       String sql = "CREATE TABLE books(names varchar(50), auther varchar(50), price int)";
       String sql= "INSERT INTO books(name,author,price)VALUES"
               + " ('Aliza', 'Dakhait hai',1522.59)";
       
           Statement statement= connection.createStatement();
           int rows = statement.executeUpdate(sql);
           
           if(rows > 0 ){
               System.out.println("A new book has been created. ");
           }
           String shutdownURL= "jdbc:derby:;shutdown=true";
           DriverManager.getConnection(shutdownURL);
       
} catch(SQLException ex){
        ex.printStackTrace();
}

}
}