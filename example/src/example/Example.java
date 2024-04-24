
package example;
class derived{
    public void getdetails(){
        System.out.println("derived class");
    }
}
publicclass test extends derived{
    public void getdetails(){
        System.out.println("test class");
        super.getdetails();
    }
}
public class Example {
    public static void main(String[] args) {
        derived obj=new test();
        obj.getdetails();
    }
    
}
