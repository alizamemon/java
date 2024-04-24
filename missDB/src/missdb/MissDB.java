package missdb;
import java.sql.*;
import java.sql.ResultSet;
import .JOptionPane;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.*;
public class Dmiss extends .JFrame {
static Statement statement;
ResultSet results;
int currow=0;
 Connection DBconn;
 static int rows;
public Db() {    
        initComponents();
    }
    private void jButton1ActionPerformed(.ActionEvent evt) {                                         
        try{
       Class.forName("org.apache.derby.jdbc.ClientDriver");
 String myDb = "jdbc:derby://localhost:1527/AddressBook";     
        DBconn  = DriverManager.getConnection(myDb, "App","a");
         jTextArea1.setText("Db connected");
         statement = DBconn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
               save.setEnabled(false);
       cancel.setEnabled(false);        }
                catch(Exception e){        e.printStackTrace();}
    }                                

    private void jButton2ActionPerformed(.ActionEvent evt) {                                         
  String  num = "";
		String address = "";
                String name="";
                 String email="";
                
try{
		String query = "SELECT * FROM contacts";
		results = statement.executeQuery(query);
                      rows= results.getRow();

		//output the resultset data
		if(results.first()){
name = results.getString(1);
address = results.getString(2);
        num = results.getString(3);
email = results.getString(4);
     System.out.println(email);
      nameText.setText(name);
    addressText.setText(address);
    phoneTxt.setText(num);
    emailTxt.setText(email);
  }   catch(Exception e){e.printStackTrace();}  }   }                                     

    private void jButton3ActionPerformed(.ActionEvent evt) {                                         
        // TODO add your handling code here:
        String name="";
        String address="";
         String email="";
                  String num="";
    try{    if(!results.isLast()){
      results.next();
			name = results.getString(1);
			address = results.getString(2);
                    System.out.println(name);
                         num = results.getString(3);
			email = results.getString(4);
                //jTextArea1.setText( name);   
        //   jTextArea1.setText(jTextArea1.getText()+"\n"+ name);
                         nameText.setText(name);
    addressText.setText(address);
    phoneTxt.setText(num);
    emailTxt.setText(email);
    }
  //jTextArea1.setText(name);
           }catch(Exception e){e.printStackTrace();}     
    }                                        

    private void jButton4ActionPerformed(.ActionEvent evt) {                                         
   String name="";
        String address="";
         String email="";
                  String num="";
    try{  
        if(!results.isFirst()){
                results.previous();
          
			name = results.getString(1);
			address = results.getString(2);
                    System.out.println(name);
                         num = results.getString(3);
			email = results.getString(4);
                      jTextArea1.setText( name);  
                    //jTextArea1.setText(jTextArea1.getText()+"\n"+ name);
                       nameText.setText(name);
    addressText.setText(address);
    phoneTxt.setText(num);
    emailTxt.setText(email);
    }
  //jTextArea1.setText(name);
           }catch(Exception e){e.printStackTrace();}          // TODO add your handling code here:
    }                                        

    private void jButton6ActionPerformed(.ActionEvent evt) {                                         
        // TODO add your handling code here:
        String name="";
        String address="";   String email="";
                  String num="";
    try{  
                       results.first();
          
			name = results.getString(1);
			address = results.getString(2);
                    System.out.println(name);
                         num = results.getString(3);
			email = results.getString(4);
                      jTextArea1.setText( name);  
                    //jTextArea1.setText(jTextArea1.getText()+"\n"+ name);
      nameText.setText(name);
    addressText.setText(address);
    phoneTxt.setText(num);
    emailTxt.setText(email);
  
           }catch(Exception e){e.printStackTrace();}     
    }                                        

    private void jButton5ActionPerformed(.ActionEvent evt) {                                         
        String name="";
        String address="";
         String email="";
                  String num="";
    try{  
        
                results.last();
          
			name = results.getString(1);
			address = results.getString(2);
                    System.out.println(name);
                         num = results.getString(3);
			email = results.getString(4);
                     // jTextArea1.setText( name);  
                    //jTextArea1.setText(jTextArea1.getText()+"\n"+ name);
    nameText.setText(name);
    addressText.setText(address);
    phoneTxt.setText(num);
    emailTxt.setText(email);
  
           }catch(Exception e){e.printStackTrace();}     // TODO add your handling code here:
    }                                        

    private void EditActionPerformed(.ActionEvent evt) {                                     
System.exit(0);        
    }                                    

    private void ClearActionPerformed(.ActionEvent evt) {                                      
        // TODO add your handling code here:
   Int res= JOptionPane.showConfirmDialog(this, " Do you Wanna Clear Data");
If(res==JOptionPane.YES_OPTION){
        nameText.setText("");
    addressText.setText("");
    phoneTxt.setText("");
    emailTxt.setText("");}
    }                                     

    private void UpdateActionPerformed(.ActionEvent evt) {                                       
                                        
        String name="";
        String address="";
         String email="";
                  String num="";
    try{  
	
   name= nameText.getText();
  address= addressText.getText();
   num= phoneTxt.getText();
  email=  emailTxt.getText();
  
  // updating data
    results.updateString( "name", name );
    results.updateString( "address", address );
    results.updateString( "phone", num );
  results.updateString( "email", email );
  
       
    
    results.updateRow( );
    
    JOptionPane.showMessageDialog(this, "Updated");
    ClearActionPerformed(evt);
    }catch(Exception e){e.printStackTrace();}   

// TODO add your handling code here:
    }                                      

    private void InsertActionPerformed(.ActionEvent evt) {                                       
try{
  
    currow=results.getRow();
        save.setEnabled(true);
          cancel.setEnabled(true);
   ClearActionPerformed(evt);
}catch(Exception e){e.printStackTrace();} 
// TODO add your handling code here:
    }                                      

    private void deleteActionPerformed(.ActionEvent evt) {                                       
try{
  JOptionPane.showConfirmDialog(null,
"Press Yes to Delete", "Press Yes to Delete", JOptionPane.YES_NO_OPTION);
    ClearActionPerformed(evt);
    results.deleteRow( ); 

 }catch(Exception e){e.printStackTrace();}    }                                      

    private void saveActionPerformed(.ActionEvent evt) {                                     
    StringBuffer val=new StringBuffer();
        String name="";
        String address="";
         String email="";
                  String num="";
    try{  
        
        // check Validation           
    boolean checkname=true,checkph=true,checkadd=true,checkemail=true;   
   name= nameText.getText();
  address= addressText.getText();
   num= phoneTxt.getText();
   email=emailTxt.getText();
   if(name.equals("")||email.equals("")||address.equals("")||num.equals("")){
   JOptionPane.showMessageDialog(null, " Enter all values plz");
   
   }
  if(!name.matches("^[a-zA-Z ]+$")){
      checkname=false;
  val.append("Enter the Only Character\n");
    val.append("\n");}
   if(!address.matches("^[a-zA-Z ]+$")){
      checkadd=false;
      val.append("Enter the Only Character in address\n");
      val.append("\n");
  }
  if(!num.matches("^\\d{3}-\\d{3}-\\d{4}$")){
      checkph=false;
      val.append("Enter the Only Character in address\n");
        val.append("\n");
  }
      
  if(!email.matches("^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$")){
      checkemail=false;
      val.append("Enter valid email address\n");
        val.append("\n");
  }
        System.out.println(val.toString());
        System.out.println("check name"+checkname);
            System.out.println("check add"+checkadd);
                System.out.println("check ph"+checkph);
                    System.out.println("check email"+checkemail);
  if(checkname==true&& checkemail==true&& checkph==true&& checkadd==true){
   jTextArea1.setText("");
    results.moveToInsertRow( );
  // updating data
    results.updateString( "name", name );
    results.updateString( "address", address );
    results.updateString( "phone", num );
  results.updateString( "email", email );
results.insertRow( );

    ClearActionPerformed(evt);
    save.setEnabled(false);
       cancel.setEnabled(false);
       
  }
  
  else{
  jTextArea1.setText(val.toString());
  
  }    }catch(Exception e){e.printStackTrace();}         
    }                                    

    private void cancelActionPerformed(..ActionEvent evt) {                                       
  
      String name="";
        String address="";
         String email="";
                  String num="";
    try{  
        
                results.absolute(currow);
          
			name = results.getString(1);
			address = results.getString(2);
                    System.out.println(name);
                         num = results.getString(3);
			email = results.getString(4);
                     // jTextArea1.setText( name);  
                    //jTextArea1.setText(jTextArea1.getText()+"\n"+ name);
    nameText.setText(name);
    addressText.setText(address);
    phoneTxt.setText(num);
    emailTxt.setText(email);
   save.setEnabled(false);
       cancel.setEnabled(false);
           }catch(Exception e){e.printStackTrace();}  
    }                                      
    private void jButton7ActionPerformed(.ActionEvent evt) {                                         
        try
        {String rep="C:\\Users\\laila\\Documents\\NetBeansProjects\\ExampleDb\\src\\report1.jrxml";
        JasperReport jasRep=JasperCompileManager.compileReport(rep);
        JasperPrint jasp=JasperFillManager.fillReport(jasRep, null, DBconn );
        JasperViewer.viewReport(jasp);
        }catch(Exception e){}
    }                                        
   public static void main(String args[]) {
        Queue.invokeLater(new Runnable() {
            public void run() {
                new Db().setVisible(true);
            }        });  }
    
    public void closeConnection() throws SQLException{
		results.close();
		statement.close();
		DBconn.close();
	}
    // Variables declaration - do not modify                     
    private .JButton Clear;
    private .JButton Edit;
    private .JButton Insert;
    private .JButton Update;
    private .JTextField addressText;
    private .JButton cancel;
    private .JButton delete;
    private .JTextField emailTxt;
    private .JButton jButton1;
    private .JButton jButton2;
    private .JButton jButton3;
    private .JButton jButton4;
    private .JButton jButton5;
    private .JButton jButton6;
    private .JButton jButton7;
    private .JLabel jLabel1;
    private .JLabel jLabel2;
    private .JLabel jLabel3;
    private .JLabel jLabel4;
    private .JPanel jPanel1;
    private .JPanel jPanel2;
    private .JPanel jPanel3;
    private .JPanel jPanel4;
    private .JScrollPane jScrollPane1;
    private .JTextArea jTextArea1;
    private .JTextField nameText;
    private .JTextField phoneTxt;
    private .JButton save;
    // End of variables declaration                   
}

