
package coachingcenter;


import java.sql.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.Connection;

import javax.swing.*;


public class gui1 extends JPanel implements ActionListener{
    JLabel l1=new JLabel("WELCOME TO COACHING CENTRE");
JLabel l2=new JLabel("Username");
    JTextField f1=new JTextField("");
    JLabel l3=new JLabel("Password");
    JPasswordField f2=new JPasswordField("");
    JButton b1=new JButton("SIGN IN");
       Font h=new Font("Arial",Font.BOLD,30);
  
    ImageIcon i=new ImageIcon("a.jpg");
    JLabel bac=new JLabel("" ,i ,JLabel.CENTER);
   
     String n;
   String p;
 
     @Override
    public void actionPerformed(ActionEvent e) {
       Connection con;
       PreparedStatement pstmt;
       Statement stmt;
       int rr;
       ResultSet rs;

        if (e.getSource()==b1)
      {
          System.out.println("Button triggered");
        n=f1.getText();
        p=f2.getText();
          System.out.println(n);
       
          System.out.println(p);
        
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con=(Connection)DriverManager.getConnection("jdbc:sqlserver://localhost\\SQLEXPRESS:1433;databaseName=coachingcenter;encrypt=true;trustServerCertificate=true", "engr", "engr");
            stmt=con.createStatement();
            rs=stmt.executeQuery("SELECT * FROM login");

            boolean flag=false;
            System.out.println(rs);
            while (rs.next())
            {
                if (rs.getString(3).equalsIgnoreCase(n) && rs.getString(4).equalsIgnoreCase(p))
                {
                    flag=true;
                    break;
                }
        
            }
        
              
            if (flag==true)
            {
                gui2 ob=new gui2();
            }
            else 
            {
                JOptionPane.showMessageDialog(null, "INVALID USER");
            }
        }


        catch (Exception ae)
        {
            System.out.println("Exception Thrown"+ae);
            JOptionPane.showMessageDialog(null, "Connection Not Establish");
        }
        f1.setText("");
        f2.setText("");
        
      }

    }
    gui1()
    {
        
        this.setLayout(null);
        this.setVisible(true);

        bac.setBounds(-25, 0, 825,700);
        this.add(bac);
        bac.setVisible(true);



        l1.setBounds(150, 70, 700, 100);
        l1.setFont(h);
        bac.add(l1);
        
        l2.setBounds(220, 250, 80, 40);
        bac.add(l2);
        
        f1.setBounds(360, 250, 130, 40);
        bac.add(f1);
        
        l3.setBounds(220, 350, 80, 40);
        bac.add(l3);
        
        f2.setBounds(360, 350, 130, 40);
        bac.add(f2);
        
        b1.setBounds(290, 450, 80, 40);
        bac.add(b1);
        b1.addActionListener(this);
        
    }

  

}