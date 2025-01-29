import java.util.*;

class Taxi {

    int TaxiId;
    String currentLocation;
    int nextAvailableTime;
    int earnings;

    Taxi(int TaxiId) {
        this.TaxiId = TaxiId;
        this.currentLocation = "A";
        this.nextAvailableTime = 0;
        this.earnings = 0;

    }

    boolean isAvailable(int pickuptime) {
        return pickuptime >= this.nextAvailableTime;
    }

    void allocateTaxi(String PickupPoint, String dropPoint, int pickupTime) {
        int travelTime = Math.abs(getIndex(PickupPoint) - getIndex(dropPoint)) * 1;
        this.nextAvailableTime = pickupTime + travelTime;

    }

    void updateEarnings(int amount) {
        this.earnings += amount;
    }

    int getIndex(String point) {
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
    int BookingId;
    int customerID;
    String pickupPoint;
    String dropPoint;
    int pickupTime;
    int dropTime;
    int amount;

    Booking(int BookingId, int customerID, String PickupPoint, String dropPoint, int pickupTime) {
        this.BookingId = BookingId;
        this.customerID = customerID;
        this.pickupPoint = PickupPoint;
        this.dropPoint = dropPoint;
        this.pickupTime = pickupTime;
        calculateDropTime();
        calculateFare();

    }

    void calculateDropTime() {
        int travelTime = Math.abs(getIndex(pickupPoint) - getIndex(dropPoint)) * 1;
        dropTime = pickupTime + travelTime;

    }

    void calculateFare() {
        int distance = Math.abs(getIndex(pickupPoint) - getIndex(dropPoint)) * 1;

        if (distance <= 5) {
            amount = 100;

        }

        else {
            amount = 100 + (distance - 5) * 10;
            amount = amount;
        }

    }

    int getIndex(String point) {
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

    Taxi findAvailableTaxi(String PickupPoint, String dropPoint, int pickupTime) {
        for (Taxi taxi : taxis) {

            if (taxi.isAvailable(pickupTime) && taxi.currentLocation.equals(PickupPoint)) {
                return taxi;
            }
        }
        for (Taxi taxi : taxis) {
            if (taxi.isAvailable(pickupTime)) {
                return taxi;
            }

        }
        return null;
    }

    Booking createBooking(int customerID, String pickupPoint, String dropPoint, int pickupTime) {
        Taxi AvailableTaxi = findAvailableTaxi(pickupPoint, dropPoint, pickupTime);
        if (AvailableTaxi != null) {
            Booking booking = new Booking(bookingIDCounter++, customerID, pickupPoint, dropPoint, pickupTime);
            AvailableTaxi.allocateTaxi(pickupPoint, dropPoint, pickupTime);
            AvailableTaxi.updateEarnings(booking.amount);
            bookings.add(booking);
            return booking;
        }
        return null;
    }

    void displayTaxiDetails() {

        for (Taxi taxi : taxis) {
            System.out.println("TaxiId : " + taxi.TaxiId + "Taxi earings : " + taxi.earnings);

            for (Booking booking : bookings) {
                if (booking.BookingId == taxi.TaxiId) {
                    System.out.println("Booking Id :" + booking.BookingId + " Customer ID : " + booking.customerID +
                            "Pickup : " + booking.pickupPoint + " Drop : " + booking.dropPoint + "PickupTime : "
                            + booking.pickupTime +
                            "DropTime : " + booking.dropTime + " Amount : " + booking.amount);
                }
            }
        }

    }
}

public class TaxiBookingSystem {
    public static void main(String[] args) {
        TaxiService taxiService = new TaxiService(4);

        Booking booking1 = taxiService.createBooking(2, "A", "B", 9);
        if (booking1 != null) {
            System.out.println("Taxi - : " + booking1.BookingId + "is allotted");

        }

        else {
            System.out.println("Booking is rejected");
        }
        taxiService.displayTaxiDetails();

    }

}