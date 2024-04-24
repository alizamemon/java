import java.lang.Exception;
class InvalidRadiusException extends Exception {
        private double radius;
        public InvalidRadiusException(double radius){
                this.radius = radius;
        }
        public void printError(){
              System.out.println("Radius [" +  radius + "] is not valid");
        }
}
class Circle    {
        double x, y, r;

       public Circle (double centreX, double centreY, double radius ) throws InvalidRadiusException {
        if (radius <= 0 ) {
                throw new InvalidRadiusException(radius);
        }
        else {
                x = centreX ; 
                y = centreY;  
                r = radius;
        }      
       }
}
class CircleTest {
       public static void main(String[] args){
        try{
              Circle c1 = new Circle(10, 10,-1);
            System.out.println("Circle created");
        }
        catch(InvalidRadiusException e){
                e.printError();
        }
      }
}
