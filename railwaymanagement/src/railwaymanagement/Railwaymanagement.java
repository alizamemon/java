package railwaymanagement;
import java.util.*;

public class Railwaymanagement {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
      String[] routes = {"Route A", "Route B", "Route C", "Route D"};
      double[] ticketPrices = {50.0, 100.0, 75.0, 120.0};
           
      System.out.print("Enter passenger name: ");
      String passengerName = scanner.nextLine();
      System.out.print("Enter passenger age: ");
      int passengerAge = scanner.nextInt();
      scanner.nextLine(); 
      System.out.print("Enter passenger contact: ");
      int passengerPhoneNumber = scanner.nextInt();
      scanner.nextLine(); 
      
      
      Passenger passenger = new Passenger(passengerName, passengerAge, passengerPhoneNumber);
      
    Train economyTrain = new EconomyClass(123, "Economy Class", 100, 10);
    Train businessTrain = new BusinessClass(456, "Business Class", 50, 5);

    
    System.out.println("\nEconomy Class Details:");
    economyTrain.getTrainDetails();
    System.out.println();

    System.out.println("\nBusiness Class Details:");
    businessTrain.getTrainDetails();
    System.out.println();
    
  
 System.out.println("Available Routes:");
        for (int i = 0; i < routes.length; i++) {
            System.out.println((i + 1) + ". " + routes[i]);
        }
        System.out.print("Enter the route number to choose a route: ");
        int routeNumber = scanner.nextInt();
        scanner.nextLine();

        if (routeNumber < 1 || routeNumber > routes.length) {
            System.out.println("Invalid route number.");
        } else {
            String chosenRoute = routes[routeNumber - 1];
            double ticketPrice = ticketPrices[routeNumber - 1];
            System.out.println("Selected Route: " + chosenRoute);
            System.out.println("Ticket Price: $" + ticketPrice);

            economyTrain.updateRouteAndPrice(chosenRoute, ticketPrice);
            businessTrain.updateRouteAndPrice(chosenRoute, ticketPrice);
        }

boolean validChoice = false;
while (!validChoice) {
    
    System.out.print("\nSelect a Class (E for Economy, B for Business): ");
    String trainChoice = scanner.nextLine().toUpperCase();
    if (trainChoice.equals("E")) {
        System.out.print("Enter the number of seats to reserve on the Economy Train: ");
        int economySeatsToReserve = scanner.nextInt();
        scanner.nextLine(); 
        economyTrain.reserveSeats(economySeatsToReserve);
        validChoice = true;
    } else if (trainChoice.equals("B")) {
        System.out.print("Enter the number of seats to reserve on the Business Train: ");
        int businessSeatsToReserve = scanner.nextInt();
        scanner.nextLine(); 
        businessTrain.reserveSeats(businessSeatsToReserve);
        validChoice = true;
    } else {
        System.out.println("Invalid train choice.");
    }
}

    
    System.out.println("\nUpdated Economy Train Details:");
    economyTrain.getTrainDetails();
    System.out.println();

    System.out.println("\nUpdated Business Train Details:");
    businessTrain.getTrainDetails();
    System.out.println();

    
    System.out.print("Enter the compartment number to reserve (1 or 2): ");
    int compartmentNumber = scanner.nextInt();

    Compartment compartment1 = null;
    Compartment compartment2 = null;

    if (compartmentNumber == 1) {
        compartment1 = new Compartment(1, 4);
        compartment1.reserveCompartment();
    } else if (compartmentNumber == 2) {
        compartment2 = new Compartment(2, 6);
        compartment2.reserveCompartment();
    } else {
        System.out.println("Invalid compartment number.");
    }

    
    System.out.println("\nUpdated Compartment Reservation Status:");
    System.out.println("Compartment 1: " + (compartment1 != null && compartment1.isReserved ? "Reserved" : "Not Reserved"));
    System.out.println("Compartment 2: " + (compartment2 != null && compartment2.isReserved ? "Reserved" : "Not Reserved"));

    
System.out.print("\nDo you want to cancel reservation\npress 1 for compartment1\npress 2 for compartment2\npress 0 for exit\n");
int cancelCompartmentNumber = scanner.nextInt();

if (cancelCompartmentNumber == 1 && compartment1 != null) {
    System.out.print("confirm the cancellation for compartment 1(Y/N): ");
    String cancelChoice = scanner.next();

    if (cancelChoice.equalsIgnoreCase("Y")) {
        compartment1.cancelReservation();
    } else {
        System.out.println("Reservation not canceled for Compartment 1.");
    }
} else if (cancelCompartmentNumber == 2 && compartment2 != null) {
    System.out.print("confirm the cancellation for compartment 2(Y/N): ");
    String cancelChoice = scanner.next();

    if (cancelChoice.equalsIgnoreCase("Y")) {
        compartment2.cancelReservation();
    } else {
        System.out.println("Reservation not canceled for Compartment 2.");
    }
} else if (cancelCompartmentNumber == 0) {
    
    System.out.println("Skipping compartment reservation cancellation.");
} else {
    System.out.println("Invalid compartment number or reservation not found.");
}
    
    System.out.println("\nUpdated Compartment Reservation Status after cancellation:");
    System.out.println("Compartment 1: " + (compartment1 != null && compartment1.isReserved ? "Reserved" : "Not Reserved"));
    System.out.println("Compartment 2: " + (compartment2 != null && compartment2.isReserved ? "Reserved" : "Not Reserved"));

}
}