import java.util.*;

class Taxi {
    int taxiID;
    String currentLocation;
    int nextAvailableTime;
    int earnings;

    Taxi(int taxiID) {
        this.taxiID = taxiID;
        this.currentLocation = "A"; // Initially stationed at A
        this.nextAvailableTime = 0; // Initially available at time 0
        this.earnings = 0;
    }

    boolean isAvailable(int time) {
        return time >= this.nextAvailableTime;
    }

    void allocateTaxi(String pickupPoint, String dropPoint, int pickupTime) {
        // Calculate travel time (assuming 15 kms between each point, 60 mins per 15kms)
        int travelTime = Math.abs(getIndex(dropPoint) - getIndex(pickupPoint)) * 60;
        this.nextAvailableTime = pickupTime + travelTime;
    }

    void updateEarnings(int amount) {
        this.earnings += amount;
    }

    private int getIndex(String point) {
        switch (point) {
            case "A":
                return 0;
            case "B":
                return 1;
            case "C":
                return 2;
            case "D":
                return 3;
            case "E":
                return 4;
            case "F":
                return 5;
            default:
                return -1;
        }
    }
}

class Booking {
    int bookingID;
    int customerID;
    String pickupPoint;
    String dropPoint;
    int pickupTime;
    int dropTime;
    int amount;
    int taxiID;

    Booking(int bookingID, int customerID, String pickupPoint, String dropPoint, int pickupTime, int taxiID) {
        this.bookingID = bookingID;
        this.customerID = customerID;
        this.pickupPoint = pickupPoint;
        this.dropPoint = dropPoint;
        this.pickupTime = pickupTime;
        this.taxiID = taxiID;
        calculateFare();
        calculateDropTime();
    }

    void calculateFare() {
        int distance = Math.abs(getIndex(dropPoint) - getIndex(pickupPoint)) * 15; // Distance in kms
        if (distance <= 5) {
            amount = 100;
        } else {
            amount = 100 + (distance - 5) * 10;
        }
    }

    void calculateDropTime() {
        int travelTime = Math.abs(getIndex(dropPoint) - getIndex(pickupPoint)) * 1;
        dropTime = pickupTime + travelTime;
    }

    private int getIndex(String point) {
        switch (point) {
            case "A":
                return 0;
            case "B":
                return 1;
            case "C":
                return 2;
            case "D":
                return 3;
            case "E":
                return 4;
            case "F":
                return 5;
            default:
                return -1;
        }
    }
}

class TaxiService {
    List<Taxi> taxis = new ArrayList<>();
    List<Booking> bookings = new ArrayList<>();
    int bookingIDCounter = 1;

    TaxiService(int numTaxis) {
        for (int i = 1; i <= numTaxis; i++) {
            taxis.add(new Taxi(i));
        }
    }

    Taxi findAvailableTaxi(int pickupTime, String pickupPoint, String dropPoint) {
        for (Taxi taxi : taxis) {
            if (taxi.isAvailable(pickupTime) && taxi.currentLocation.equals(pickupPoint)) {
                return taxi;
            }
        }

        // If no taxi is free at the pickup point, check the nearest point
        for (Taxi taxi : taxis) {
            if (taxi.isAvailable(pickupTime)) {
                return taxi;
            }
        }
        return null; // No taxi available
    }

    Booking createBooking(int customerID, String pickupPoint, String dropPoint, int pickupTime) {
        Taxi availableTaxi = findAvailableTaxi(pickupTime, pickupPoint, dropPoint);
        if (availableTaxi != null) {
            Booking booking = new Booking(bookingIDCounter++, customerID, pickupPoint, dropPoint, pickupTime,
                    availableTaxi.taxiID);
            availableTaxi.allocateTaxi(pickupPoint, dropPoint, pickupTime);
            availableTaxi.updateEarnings(booking.amount);
            bookings.add(booking);
            return booking;

        }
        return null;
    }

    void displayTaxiDetails() {
        for (Taxi taxi : taxis) {
            System.out.println("Taxi No: " + taxi.taxiID + " Total Earnings: Rs. " + taxi.earnings);
            for (Booking booking : bookings) {
                if (booking.taxiID == taxi.taxiID) { // Match bookings to this taxi
                    System.out.println("Booking ID: " + booking.bookingID + " Customer ID: " + booking.customerID +
                            " From: " + booking.pickupPoint + " To: " + booking.dropPoint +
                            " PickupTime: " + booking.pickupTime + " DropTime: " + booking.dropTime + " Amount: "
                            + booking.amount);
                }
            }
        }
    }

}

public class CallTaxiBookingApp {
    public static void main(String[] args) {
        TaxiService taxiService = new TaxiService(4); // Create 4 taxis

        // Test 1
        Booking booking1 = taxiService.createBooking(1, "A", "B", 9);
        if (booking1 != null) {
            System.out.println("Taxi-" + booking1.bookingID + " is allotted.");
        } else {
            System.out.println("Booking rejected.");
        }

        // Test 2
        Booking booking2 = taxiService.createBooking(2, "B", "D", 9);
        if (booking2 != null) {
            System.out.println("Taxi-" + booking2.bookingID + " is allotted.");
        } else {
            System.out.println("Booking rejected.");
        }

        // Test 3
        Booking booking3 = taxiService.createBooking(3, "B", "C", 12);
        if (booking3 != null) {
            System.out.println("Taxi-" + booking3.bookingID + " is allotted.");
        } else {
            System.out.println("Booking rejected.");
        }

        Booking booking4 = taxiService.createBooking(1, "B", "D", 13);
        if (booking4 != null) {
            System.out.println("Taxi-" + booking4.bookingID + " is allotted.");
        } else {
            System.out.println("Booking rejected.");
        }

        // Display Taxi Details
        taxiService.displayTaxiDetails();
    }
}
