
package railwaymanagement;


public class Compartment {
   int compartmentNumber;
   int seatsPerCompartment;
   boolean isReserved;

   public Compartment(int compartmentNumber, int seatsPerCompartment) {
      this.compartmentNumber = compartmentNumber;
      this.seatsPerCompartment = seatsPerCompartment;
      this.isReserved = false; 
   }

   public void reserveCompartment() {
      if(!isReserved) {
         isReserved = true; 
         System.out.println("Compartment " + compartmentNumber + " reserved successfully.");
      }
      else {
         System.out.println("Sorry, compartment " + compartmentNumber + " is already reserved.");
      }
   }

   public void cancelReservation() {
      if(isReserved) {
         isReserved = false; 
         System.out.println("Reservation canceled for compartment " + compartmentNumber);
      }
      else {
         System.out.println("No reservation found for compartment " + compartmentNumber);
      }
   }
}
