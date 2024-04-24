package underageexception;
public class UnderAgeException extends Exception{
    UnderAgeException(){
        super("you are under age");
    }
    UnderAgeException(String message){
        super(message); //default exception handler ko msg jaega
    }     
    public static void main(String[] args) {
        int age=16;
  try{
        if(age<18){
            throw new UnderAgeException("baray hokar aao");
        }
        else{
            System.out.println("you can vote now");
        }
  }
        catch(UnderAgeException e){
                e.printStackTrace();
                }
        }
    }


