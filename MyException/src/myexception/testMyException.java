package myexception;

public class testMyException {
    public static void main(String[] args) {
        // TODO code application logic here
                int a=10,b=0;
        System.out.println("pakistan");
     try{  
   if(a<b) throw new MyException(); //if true throws exception
        divide(a,b);
     }
        catch(MyException e ){
            System.out.println("MyException Comes");
            System.out.println(""+e.toString());     
        } 
        catch(DivException e ){                         //at a time only one catch block executes
            System.out.println("DivException Comes");
            System.out.println(""+e.toString());     
            }
     finally{
         System.out.println("Close File");
     }
        System.out.println("hello Karachi");      
    }
        static void divide(int i,int j) throws DivException{ //exception is thrown before reaching 
       if(j==0) throw new DivException();
        System.out.println(""+i/j);
    }
    
}
