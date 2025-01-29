import java.util.*;

class Passenger {
    int PassengerId;
    String Name;
    int age;
    String Gender;
    String preferredBerth;
    String allotedBerth;

    Passenger(int PassengerId, String Name, int age, String Gender, String preferredBerth) {
        this.PassengerId = PassengerId;
        this.Name = Name;
        this.age = age;
        this.Gender = Gender;
        this.preferredBerth = preferredBerth;
        // this.allotedBerth = allotedBerth;

    }
}

class Train {
    int TrainNumber;
    String TrainName;
    int TotalSeats;
    int availableSeats;
    List<Passenger> passengers;

    Train(int TrainNumber, String TrainName, int TotalSeats, int availableSeats) {
        this.TrainNumber = TrainNumber;
        this.TrainName = TrainName;
        this.TotalSeats = TotalSeats;
        this.availableSeats = availableSeats;
        this.passengers = new ArrayList<>();
    }

}

class BookingSystem {
    Map<Integer, Train> trains = new HashMap<>();
    // ArrayList<Passenger> passengers;
    int PassengerCounter = 1;

    BookingSystem() {
        trains.put(101, new Train(101, "Express train", 5, 5));
    }

    // 4 Methods: 1-BookingTicket, 2-CheckAvailability,
    // 3-Cancellation,4-ChartPrepare

    void BookingTicket(int TrainNumber, String Name, int age, String Gender, String preferredberth) {

        Train train = trains.get(TrainNumber);

        if (train == null) {
            System.out.println("Train Number not found");
            return;
        }

        if (train.availableSeats > 0) {
            Passenger passenger = new Passenger(PassengerCounter++, Name, age, Gender, preferredberth);
            passenger.allotedBerth = preferredberth;
            train.passengers.add(passenger);
            train.availableSeats--;

        }

        else {
            System.out.println("Booking is rejected");
        }

    }

    void CheckAvailability(int TrainNumber) {
        Train train = trains.get(TrainNumber);

        if (train == null) {
            System.out.println("Train is not found");
        }

        else {
            System.out
                    .println("Train Name : " + train.TrainName + " - The Availability of Train : "
                            + train.availableSeats);
        }
    }

    void Cancellation(int TrainNumber, int PassengerId) {
        Train train = trains.get(TrainNumber);

        if (train == null) {
            System.out.println("Train is not found");
        }

        Passenger toCancel = null;

        for (Passenger p : train.passengers) {
            if (p.PassengerId == PassengerId) {
                toCancel = p;

            }

        }

        if (toCancel != null) {
            System.out.println("Passenger " + toCancel.Name + "is successfully removed");
            train.passengers.remove(toCancel);
            train.availableSeats++;

        }

    }

    void ChartPrepare(int TrainNumber) {
        Train train = trains.get(TrainNumber);

        if (train == null) {
            System.out.println("Train is not found");
            return;
        }

        System.out.println("The Chart For Train Boarding ");
        System.out.println("Passenger ID | " + " Name |" + " Age " + " | Gender ");

        if (train.passengers.isEmpty()) {
            System.out.println("No Bookings");

        }

        for (Passenger p : train.passengers) {

            System.out.println(p.PassengerId + " | " + p.Name + " | " + p.age + " | " + p.Gender + " | ");

        }
    }

}

public class RailwaySystem {

    public static void main(String[] args) {

        BookingSystem bookingSystem = new BookingSystem();
        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println(
                    "Enter 1- Booking ticket , 2- Cancellation, 3- Check Availablility, 4- Chart Preparing, 5-Quit ");
            System.out.println("Enter your Option :");
            int option = sc.nextInt();

            switch (option) {
                case 1:
                    // (int TrainNumber, String Name, int age, String Gender, String preferredberth)
                    // {

                    System.out.println("Enter the train number");
                    int TrainNumber = sc.nextInt();
                    System.out.println("Enter the name");
                    String Name = sc.next();
                    System.out.println("Enter the Age");
                    int age = sc.nextInt();
                    System.out.println("Enter the Gender");
                    String Gender = sc.next();
                    System.out.println("Enter the preferred Berth :");
                    String preferredBerth = sc.next();

                    bookingSystem.BookingTicket(TrainNumber, Name, age, Gender, preferredBerth);
                    break;

                case 2: {
                    System.out.println("Enter the train number");
                    TrainNumber = sc.nextInt();
                    System.out.println("Enter the PassengerID");
                    int PID = sc.nextInt();
                    bookingSystem.Cancellation(TrainNumber, PID);
                    break;
                }

                case 3: {
                    System.out.println("Enter the train number");
                    TrainNumber = sc.nextInt();
                    bookingSystem.CheckAvailability(TrainNumber);
                    break;
                }

                case 4: {
                    System.out.println("Enter the train number");
                    TrainNumber = sc.nextInt();
                    bookingSystem.ChartPrepare(TrainNumber);
                    break;
                }

                case 5: {
                    System.out.println("Railway Ticket System is quitting :");
                    sc.close();
                    System.exit(0);
                    break;
                }
                default: {
                    System.out.println("Enter the valid Input");
                }
            }

        }

    }
}
