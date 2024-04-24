package exception;
public class Exception {

    public static void main(String[] args) {
        // TODO code application logic here
   
		int a,b;  float r;  a = 7;   b = 0;
		try{
		      r = a/b;
		      System.out.println("Result is: " + r);
		}
		catch(ArithmeticException e){
			System.out.println(" B is zero");
			throw e;
		}
                finally{
                        System.out.println("Program is complete");
	}
    }
}

