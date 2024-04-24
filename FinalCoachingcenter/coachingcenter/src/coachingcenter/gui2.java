
package coachingcenter;





import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import java.sql.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import net.proteanit.sql.DbUtils;


public class gui2 extends JFrame implements ActionListener{
    
    
        int i ;
            String s,p,c;
            
                ImageIcon i2=new ImageIcon("a.jpg");
    JLabel bac2=new JLabel("",i2,JLabel.CENTER);

            
    Font h=new Font("Arial",Font.BOLD,30);
            
    JLabel l6=new JLabel("COACHING CENTER");
    
    JLabel l11=new JLabel("NEW ADMISSION");
    JLabel l22=new JLabel("VIEW RECORD");
    JLabel l33=new JLabel("UPDATE RECORD");
    JLabel l44=new JLabel("DELETE RECORD");
    JLabel l55=new JLabel("SEARCH BOOKS");
   
    
    
    JButton b1=new JButton("NEW ADMISSION");
    JButton b2=new JButton("VIEW RECORD");
    JButton b3=new JButton("UPDATE RECORD");
    JButton b4=new JButton("DELETE RECORD");
    JButton b6=new JButton("LOGOUT");
    JButton b11=new JButton("OK"); //add book
    JButton b22=new JButton("Ok"); //update
    JButton b33=new JButton("Ok"); //delete
    
    JLabel l1=new JLabel("ID");
JLabel l2=new JLabel("STUDENT");
JLabel l3=new JLabel("CLASS");
JLabel l4=new JLabel("PHONE");
JLabel l7=new JLabel("ID"); //delete
JLabel l8=new JLabel("CLASS"); //search



JTextField f1=new JTextField();
JTextField f2=new JTextField();
JTextField f3=new JTextField();
JTextField f4=new JTextField();
JTextField f5=new JTextField();
JTextField f6=new JTextField(); //update

String[] clm={"ID","TITTLE","AUTHOR","PRICE","QUANTITY"};
    
JTable t1=new JTable();
JTable t2=new JTable();

    
    @Override
    public void actionPerformed(ActionEvent e) {
    
        Connection con = null;
       PreparedStatement pstmt;
       Statement stmt;
       int rr;
       ResultSet rs;
       
        if (e.getSource()==b1)
      {
          l11.setVisible(true);
          l22.setVisible(false);
          l33.setVisible(false);
          l44.setVisible(false);
          l55.setVisible(false);
          
          
          l8.setVisible(false);
          f6.setVisible(false);

              t1.setVisible(false);
              l1.setVisible(true);
              l2.setVisible(true);
              
              l3.setVisible(true);
              l4.setVisible(true);
             
              l7.setVisible(false);
              
         t2.setVisible(false);
              f1.setVisible(true);
              f2.setVisible(true);
              f3.setVisible(true);
              f4.setVisible(true);
              f5.setVisible(true);
              f6.setVisible(false);
              
              b11.setVisible(true);
              b33.setVisible(false);
        
    
    
    
    }
        if (e.getSource()==b11)
        {

            i=Integer.valueOf(f1.getText());
            s=f2.getText();
            c=f3.getText();
            p=f4.getText();
            
            
            
             try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con=(Connection)DriverManager.getConnection("jdbc:sqlserver://localhost\\SQLEXPRESS:1433;databaseName=coachingcenter;encrypt=true;trustServerCertificate=true", "engr", "engr");

            pstmt=con.prepareStatement("INSERT INTO record VALUES(?,?,?,?)");
            pstmt.setInt(1, i);
            pstmt.setString(2, s);
            pstmt.setString(3, c);
            pstmt.setString(4, p);
            rr=pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Successfully Added");
            f1.setText("");
            f2.setText("");
            f3.setText("");
            f4.setText("");
            
            
        }
        catch(Exception ae)
        {
            
        }

        }
        
        if (e.getSource()==b2)
        {
            b22.setVisible(false);
            l11.setVisible(false);
          l22.setVisible(true);
          l33.setVisible(false);
          l44.setVisible(false);
          l55.setVisible(false);
 
            
         t2.setVisible(false);
          l8.setVisible(false);
          f6.setVisible(false);
            t1.setVisible(true);
              l1.setVisible(false);
              l2.setVisible(false);
              l3.setVisible(false);
              l4.setVisible(false);
              l7.setVisible(false);
              
              f1.setVisible(false);
              f2.setVisible(false);
              f3.setVisible(false);
              f4.setVisible(false);
              f6.setVisible(false);
              
              b11.setVisible(false);
              b33.setVisible(false);
            
              
                           try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con=(Connection)DriverManager.getConnection("jdbc:sqlserver://localhost\\SQLEXPRESS:1433;databaseName=coachingcenter;encrypt=true;trustServerCertificate=true", "engr", "engr");
            stmt=con.createStatement();
              rs=stmt.executeQuery("SELECT * FROM record");
                      
              t1.setModel(DbUtils.resultSetToTableModel(rs));

        }
        catch(Exception ae)
        {
            
        }   
        }
 
        
        if (e.getSource()==b3)
        {
            l11.setVisible(false);
          l22.setVisible(false);
          l33.setVisible(true);
          l44.setVisible(false);
          l55.setVisible(false);
 
          l8.setVisible(false);
          f6.setVisible(false);
            t1.setVisible(false);
              l1.setVisible(true);
              l2.setVisible(true);
              l3.setVisible(true);
              l4.setVisible(true);
              l7.setVisible(false);
              
         t2.setVisible(false);
              f1.setVisible(true);
              f2.setVisible(true);
              f3.setVisible(true);
              f4.setVisible(true);
              f6.setVisible(false);
              
              b11.setVisible(false);
              b22.setVisible(false);
              b22.setVisible(false);
              l7.setVisible(false);
              f6.setVisible(false);
              b22.setVisible(true);
        b33.setVisible(false);
        
              
        }
        if (e.getSource()==b22)
        {
                   try
        {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    con = DriverManager.getConnection("jdbc:sqlserver://localhost\\SQLEXPRESS:1433;databaseName=coachingcenter;encrypt=true;trustServerCertificate=true", "engr", "engr");
    
    pstmt = con.prepareStatement("UPDATE record SET student=?, class=?, phone=? WHERE id=?");

    i = Integer.valueOf(f1.getText());
    s = f2.getText();
    c = f3.getText();
    p = f4.getText();

    pstmt.setInt(4, i);
    pstmt.setString(1, s);
    pstmt.setString(2, c);
    pstmt.setString(3, p);

    int rowsAffected = pstmt.executeUpdate();

    // Commit the changes (if not auto-committing)
    con.commit();
            JOptionPane.showMessageDialog(null, "Successfully Upadated");
            
f1.setText("");
            f2.setText("");
            f3.setText("");
            f4.setText("");
        }
        catch(Exception ae)
        {
            
        }  
   
        }

               if (e.getSource()==b4)
        {
            
            l11.setVisible(false);
          l22.setVisible(false);
          l33.setVisible(false);
          l44.setVisible(true);
          l55.setVisible(false);
 
            
         t2.setVisible(false);
          l8.setVisible(false);
          f6.setVisible(false);
            t1.setVisible(false);
              l1.setVisible(false);
              l2.setVisible(false);
              l3.setVisible(false);
              l4.setVisible(false);
              
              f1.setVisible(false);
              f2.setVisible(false);
              f3.setVisible(false);
              f4.setVisible(false);
              
              f6.setVisible(true);
              l7.setVisible(true);
              b22.setVisible(false);
              b33.setVisible(true);
              
              
              b11.setVisible(false);
            
            
          
        }
               if(e.getSource()==b33)
               {
                   
             try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con=(Connection)DriverManager.getConnection("jdbc:sqlserver://localhost\\SQLEXPRESS:1433;databaseName=coachingcenter;encrypt=true;trustServerCertificate=true", "engr", "engr");

            pstmt=con.prepareStatement("DELETE FROM record WHERE id=?");

            pstmt.setInt(1, Integer.valueOf(f6.getText()));
            rr=pstmt.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Successfully Deleted");
                        f6.setText("");
              rs=pstmt.executeQuery("SELECT * FROM record");

        }
        catch(Exception ae)
        {
            
        }   
            
        }
         
        if (e.getSource()==b6)
        {
            
            l11.setVisible(false);
          l22.setVisible(false);
          l33.setVisible(false);
          l44.setVisible(false);
          l55.setVisible(false);
 
            t1.setVisible(false);
          
         this.setVisible(false);
        }
    }
    
    
    gui2()
    {

        this.add(l1);
        this.add(l2);
        this.add(l3);
        this.add(l4);
        
        this.add(f1);                        
        this.add(f2);                        
        this.add(f3);                        
        this.add(f4);                        
        
         
              
        this.setBounds(50, 50, 1200, 650);
        this.setLayout(null);
        this.setVisible(true);
    
        this.setTitle("Management System");
     
        this.add(b11);
        b11.addActionListener(this);
        
        //delete
        b33.setBounds(700, 150, 90, 40);
        this.add(b33);
        b33.addActionListener(this);
        b33.setVisible(false);
        
       
        
        
        l7.setBounds(700, 90, 90, 40);
        this.add(l7);
        l11.setFont(h);
        l7.setVisible(false);


        // header
        l11.setBounds(650, 10, 250, 80);
        this.add(l11);
        l11.setVisible(false);
        l11.setFont(h);
                
        l22.setBounds(650, 10, 250, 80);
        this.add(l22);
        l22.setVisible(false);
        l22.setFont(h);
        
        l33.setBounds(650, 10, 300, 80);
        this.add(l33);
        l33.setVisible(false);
        l33.setFont(h);
                
        l44.setBounds(650, 10, 300, 80);
        this.add(l44);
        l44.setVisible(false);
        l44.setFont(h);
                
        l55.setBounds(650, 10, 250, 80);
        this.add(l55);
        l55.setVisible(false);
        l55.setFont(h);
        //header
                
        l8.setBounds(700, 90, 90, 40);
        this.add(l8);
        l8.setVisible(false);

        f6.setBounds(800, 90, 120, 40);
        this.add(f6);
        f6.setVisible(false);
           
        b22.setBounds(700, 420, 140, 40);
        this.add(b22);
        b22.setVisible(false);
        b22.addActionListener(this);
        
        l6.setBounds(70, 40, 700, 80);
        l6.setFont(h);
        this.add(l6);
        
              l1.setBounds(600, 120, 140, 40);
              l2.setBounds(600, 180, 140, 40);
              l3.setBounds(600, 240, 140, 40);
              l4.setBounds(600, 300, 140, 40);
              
              f1.setBounds(850, 120, 140, 40);
              f2.setBounds(850, 180, 140, 40);
              f3.setBounds(850, 240, 140, 40);
              f4.setBounds(850, 300, 140, 40);
              
              b11.setBounds(700, 420, 140, 40);
              
              l1.setVisible(false);
              l2.setVisible(false);
              
              l3.setVisible(false);
              l4.setVisible(false);
              
              f1.setVisible(false);
              f2.setVisible(false);
              f3.setVisible(false);
              f4.setVisible(false);
              
              b11.setVisible(false);

              this.add(t1);
           t1.setBounds(600, 130, 500, 350);
           t1.setVisible(false);

           this.add(t2);
           t2.setBounds(600, 180, 500, 300);
           t2.setVisible(false);
        
        b1.setBounds(220, 150, 140, 40);
        this.add(b1);
        b1.setAlignmentX(Component.CENTER_ALIGNMENT);
        b1.addActionListener(this);

        b2.setBounds(220, 210, 140, 40);
        this.add(b2);
        b2.setAlignmentX(Component.CENTER_ALIGNMENT);
        b2.addActionListener(this);

        b3.setBounds(220, 270, 140, 40);
        this.add(b3);
        b3.setAlignmentX(Component.CENTER_ALIGNMENT);
        b3.addActionListener(this);

        b4.setBounds(220, 330, 140, 40);
        this.add(b4);
        b4.setAlignmentX(Component.CENTER_ALIGNMENT);
        b4.addActionListener(this);

        b6.setBounds(220, 390, 140, 40);
        this.add(b6);
        b6.setAlignmentX(Component.CENTER_ALIGNMENT);
        b6.addActionListener(this);
     
        bac2.setBounds(0, 0, 1200,650);
        this.add(bac2);
        bac2.setVisible(true);
     

    }

    
}
