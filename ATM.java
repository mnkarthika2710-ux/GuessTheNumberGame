import java.util.Scanner;

public class ATM {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        User user = new User("user123", "1234", 10000.0); // Default user

        System.out.println("===== Welcome to ATM =====");

        System.out.print("Enter User ID: ");
        String userId = sc.nextLine();

        System.out.print("Enter PIN: ");
        String pin = sc.nextLine();

        if (user.authenticate(userId, pin)) {
            System.out.println("\nLogin Successful!");
            ATMOperations operations = new ATMOperations(user);
            operations.showMenu();
        } else {
            System.out.println("Invalid User ID or PIN!");
        }
    }
}