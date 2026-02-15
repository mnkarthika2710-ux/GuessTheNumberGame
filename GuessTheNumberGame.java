import java.util.*;

public class GuessTheNumberGame {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int totalScore = 0;
        int rounds;

        System.out.println("===== Welcome to Guess The Number Game =====");
        System.out.print("Enter number of rounds you want to play: ");
        rounds = sc.nextInt();

        for (int round = 1; round <= rounds; round++) {

            int numberToGuess = random.nextInt(100) + 1; // 1 to 100
            int maxAttempts = 7;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("\n--- Round " + round + " ---");
            System.out.println("You have " + maxAttempts + " attempts to guess the number (1-100).");

            while (attempts < maxAttempts) {

                System.out.print("Enter your guess: ");
                int userGuess = sc.nextInt();
                attempts++;

                if (userGuess == numberToGuess) {
                    guessedCorrectly = true;
                    int points = (maxAttempts - attempts + 1) * 10;
                    totalScore += points;

                    System.out.println("🎉 Correct! You guessed the number in " + attempts + " attempts.");
                    System.out.println("You earned " + points + " points.");
                    break;
                }
                else if (userGuess < numberToGuess) {
                    System.out.println("Too low! Try again.");
                }
                else {
                    System.out.println("Too high! Try again.");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("❌ You've used all attempts.");
                System.out.println("The correct number was: " + numberToGuess);
            }
        }

        System.out.println("\n===== Game Over =====");
        System.out.println("Your Total Score: " + totalScore);
        System.out.println("Thank you for playing!");
    }
}