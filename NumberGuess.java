import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class NumberGuess {
    public static void main(String[] args) {
        final int MIN = 1;
        final int MAX = 100;

        try (Scanner sc = new Scanner(System.in)) {
            int target = ThreadLocalRandom.current().nextInt(MIN, MAX + 1);
            System.out.println(target);
            int attempts = 0;

            System.out.println("🎲 Welcome to Number Guessing Game!");
            System.out.println("I'm thinking of a number between " + MIN + " and " + MAX + ". Guess it!");

            while (true) {
                System.out.print("Enter your guess: ");

                if (!sc.hasNextInt()) {
                    System.out.println("❌ Invalid input! Please enter a whole number.");
                    sc.next();
                    continue;
                }

                int guess = sc.nextInt();
                attempts++;

                if (guess < MIN || guess > MAX) {
                    System.out.println("⚠️ Guess must be between " + MIN + " and " + MAX + ".");
                    continue;
                }

                  else if (guess < target) {
                    System.out.println("📉 Too low! Try again.");
                } else if (guess > target) {
                    System.out.println("📈 Too high! Try again.");
                } else {
                    System.out.println("✅ Correct! You guessed it in " + attempts + " attempts.");
                    break;
                }
            }
        }
    }
}
