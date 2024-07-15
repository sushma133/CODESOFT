package numbergame;
// Importing the required libraries
import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {

    // Method to handle the guessing game logic
    static boolean guessing(int numToGuess, Scanner sc, int maxAttempts) {
        int numberOfAttempts = 0;
        boolean hasGuessedCorrectly = false;

        while (!hasGuessedCorrectly && numberOfAttempts < maxAttempts) {
            // Asking for the user's guess
            System.out.println("Enter your guess:");
            int userGuess = sc.nextInt();
            numberOfAttempts++;

            // Compare the user's guess with the generated number
            if (userGuess < numToGuess) {
                System.out.println("Too Low!");
            } else if (userGuess > numToGuess) {
                System.out.println("Too High!");
            } else {
                System.out.println("Correct! The number was " + numToGuess);
                hasGuessedCorrectly = true;
            }
        }

        if (!hasGuessedCorrectly) {
            System.out.println("Sorry, you've used all " + maxAttempts + " attempts. The number was " + numToGuess + ".");
        }

        return hasGuessedCorrectly; // Return whether the user guessed correctly
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Create a Scanner to read user input
        Random random = new Random(); // Create a Random object to generate random numbers

        boolean playAgain = true; // Flag to control whether the game should continue
        int totalAttempts = 0; // To track the total number of attempts
        int roundsWon = 0; // To track the number of rounds won

        while (playAgain) { // Loop to keep playing the game as long as playAgain is true
            int numToGuess = random.nextInt(100) + 1; // Generate a new random number between 1 and 100
            int maxAttempts = 3; // Set the maximum number of attempts allowed

            boolean won = guessing(numToGuess, sc, maxAttempts); // Play the guessing game
            totalAttempts += maxAttempts; // Update total attempts

            if (won) {
                roundsWon++; // Increment rounds won if the user guessed correctly
            }

            // Ask the player if they want to play again
            System.out.println("Want to play again?");
            System.out.println("1. YES");
            System.out.println("2. Exit");

            int secondChance = sc.nextInt(); // Read the player's choice

            // If the player doesn't choose to play again, set playAgain to false to end the loop
            if (secondChance != 1) {
                playAgain = false;
                System.out.println("Thank you for playing!"); // Say goodbye
            }
        }

        // Display the user's score
        System.out.println("Your Score:");
        System.out.println("Total Rounds Won: " + roundsWon);
        System.out.println("Total Attempts: " + totalAttempts);

        sc.close(); // Close the scanner to clean up resources
    }
}
