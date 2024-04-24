package myexception;
public class MyException extends Exception {
    MyException(){
    super("a < b in my Exception…");
    }

    MyException(String str){
    super(str);
    }

    @Override
        public String getMessage(){
              return super.getMessage();
        }
}