
package uu;
class derived{
    public void getdetails(){
        System.out.println("derived class");
    }
}
class test extends derived{
    public void getdetails(){
        System.out.println("test class");
        super.getdetails();
    }
}
public class Uu {
    public static void main(String[] args) {
        derived obj=new test();
        obj.getdetails();
    }
    
}

