import java.util.*;

class ReservationSystem {

    static Scanner sc = new Scanner(System.in);

    static String storedPNR = "";
    static String passengerName;
    static int age;
    static String gender;
    static String trainNo;
    static String trainName;
    static String classType;
    static String date;
    static String from;
    static String to;

    // Login Method
    static boolean login() {
        System.out.println("===== LOGIN FORM =====");
        System.out.print("Enter Login ID: ");
        String id = sc.next();
        System.out.print("Enter Password: ");
        String pass = sc.next();

        if (id.equals("admin") && pass.equals("1234")) {
            System.out.println("Login Successful!\n");
            return true;
        } else {
            System.out.println("Invalid Login Details!");
            return false;
        }
    }

    // Reservation Method
    static void reservation() {
        System.out.println("===== RESERVATION FORM =====");

        System.out.print("Passenger Name: ");
        passengerName = sc.next();

        System.out.print("Age: ");
        age = sc.nextInt();

        System.out.print("Gender: ");
        gender = sc.next();

        System.out.print("Train Number: ");
        trainNo = sc.next();

        // Auto Train Name (Simple Logic)
        if (trainNo.equals("101"))
            trainName = "Chennai Express";
        else if (trainNo.equals("102"))
            trainName = "Mumbai Express";
        else
            trainName = "Unknown Train";

        System.out.println("Train Name: " + trainName);

        System.out.print("Class Type (Sleeper/AC): ");
        classType = sc.next();

        System.out.print("Date of Journey: ");
        date = sc.next();

        System.out.print("From: ");
        from = sc.next();

        System.out.print("To: ");
        to = sc.next();

        storedPNR = "PNR" + (int)(Math.random() * 10000);

        System.out.println("\nReservation Successful!");
        System.out.println("Your PNR Number is: " + storedPNR);
    }

    // Cancellation Method
    static void cancellation() {
        System.out.println("===== CANCELLATION FORM =====");
        System.out.print("Enter PNR Number: ");
        String pnr = sc.next();

        if (pnr.equals(storedPNR)) {
            System.out.println("\nPassenger Name: " + passengerName);
            System.out.println("Train Name: " + trainName);
            System.out.println("Date: " + date);

            System.out.print("\nConfirm Cancellation (yes/no): ");
            String confirm = sc.next();

            if (confirm.equalsIgnoreCase("yes")) {
                storedPNR = "";
                System.out.println("Ticket Cancelled Successfully!");
            } else {
                System.out.println("Cancellation Aborted!");
            }
        } else {
            System.out.println("Invalid PNR Number!");
        }
    }

    // Main Method
    public static void main(String[] args) {

        if (!login())
            return;

        while (true) {
            System.out.println("\n===== ONLINE RESERVATION SYSTEM =====");
            System.out.println("1. Reservation");
            System.out.println("2. Cancellation");
            System.out.println("3. Exit");
            System.out.print("Choose Option: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    reservation();
                    break;
                case 2:
                    cancellation();
                    break;
                case 3:
                    System.out.println("Thank You!");
                    System.exit(0);
                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}