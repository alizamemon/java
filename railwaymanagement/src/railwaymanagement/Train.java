package railwaymanagement;


abstract class Train {
   int trainNumber;
   String trainName;
   int totalSeats;
   int seatsReserved;
   String route;
   double ticketPrice;
   abstract void getTrainDetails();
   abstract void reserveSeats(int seats);
   abstract void updateRouteAndPrice(String route, double ticketPrice);
}
