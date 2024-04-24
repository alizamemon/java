
package railwaymanagement;


class EconomyClass extends Train {
   int seatsLeft;
   EconomyClass(int trainNumber, String trainName, int totalSeats, int seatsReserved) {
      this.trainNumber = trainNumber;
      this.trainName = trainName;
      this.totalSeats = totalSeats;
      this.seatsReserved = seatsReserved;
      this.route = route;
      this.ticketPrice = ticketPrice;
      seatsLeft = totalSeats - seatsReserved;
   }
   void getTrainDetails() {
      System.out.println("Train Number: " + trainNumber);
      System.out.println("Train Name: " + trainName);
      System.out.println("Total Seats: " + totalSeats);
      System.out.println("Seats Reserved: " + seatsReserved);
      System.out.println("Seats Left: " + seatsLeft);
      System.out.println("Route: " + route);
      System.out.println("Ticket Price: $" + ticketPrice);
   }
   void reserveSeats(int seats) {
      if(seatsLeft >= seats) {
         seatsReserved += seats;
         seatsLeft -= seats;
         System.out.println(seats + " seats reserved successfully.");
      }
      else {
         System.out.println("Sorry, seats not available.");
          System.exit(0);
      }
      
   }

    @Override
    void updateRouteAndPrice(String route, double ticketPrice) {
        this.route = route;
        this.ticketPrice = ticketPrice;
    }
}