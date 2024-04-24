package myexception;
public class DivException extends Exception {
        DivException(){
        super("Div error Exception…");}

        DivException(String str){
        super(str);
        }
        @Override
        public String getMessage(){
              return super.getMessage();
        }
}

