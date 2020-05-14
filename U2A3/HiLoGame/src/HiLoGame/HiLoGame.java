package HiLoGame;

import java.util.Scanner;

public class HiLoGame {
    /*
    HiLo Game
    Description: This is a game more based on luck. Random numbers will be generated
    A number will be given to the user, they have to guess how many random numbers are
    Higher, Lower or the Same as the number they were given.
    At the end it tally's the score and show's the user while tallying.
    You can then say yes at the end if you want to play again.
     */

    public static void main(String[] args) {
        // Variables
        final int MIN = 1; // Lowest value the number can go
        final int MAX = 100; // Highest value the number can go
        final int TOTAL = 10; // Total numbers that will be generated
        Scanner keyInput = new Scanner(System.in);

        System.out.println("Welcome to the HiLo Game."); // Introduction
        System.out.println("Here is how to play:");
        System.out.println();
        System.out.println("The game will pick " + TOTAL + " numbers between " + MIN + " and " + MAX);
        System.out.println("The game will give you a number and ask");
        System.out.println("How many of the " + TOTAL + " numbers are higher, lower, or the same");
        System.out.println("Once you have answered, your score will be tallied");
        System.out.println();
        System.out.println("Time to play!!");

        while (true) { // Loop until the player does not want to play anymore

            System.out.println("Picking numbers");
            int [] numbers = new int[TOTAL]; // All the numbers the user has to guess higher or lower or same
            for (int i=0; i <= TOTAL - 1; i++) {
                numbers[i] = (int) (Math.random() * ((MAX - MIN) + 1)) + MIN; // Pick the number
            }
            int usersNumber = (int) (Math.random() * ((MAX - MIN) + 1)) + MIN; // Pick the users number

            int guessedNumbers = 0; // We'll keep track of how many numbers have been guessed.
            int higher = 0; // Users guess of how many numbers are higher
            int lower = 0; // Users guess of how many numbers are lower
            int same = 0; // Users guess of how many numbers are the same

            System.out.println("Numbers have all been guessed!");
            System.out.println("Your number is: " + usersNumber);
            System.out.println("We'll start with numbers that are higher than " + usersNumber);

            System.out.println("Total Numbers guessed: " + guessedNumbers + "/" + TOTAL);
            System.out.println((TOTAL - guessedNumbers) + " to go");

            boolean answeredCorrectly = false; // We'll keep asking if the user doesn't answer correctly

            while (!(answeredCorrectly)) { // Repeat until the user answered correctly
                System.out.print("How many numbers are higher than " + usersNumber + ": ");
                int guess = keyInput.nextInt(); // Grab our users guess
                if (guess > (TOTAL - guessedNumbers)) { // Check to see if they guessed more numbers than how many are left
                    System.out.println("You guessed too many numbers. The most you can guess is " + (TOTAL - guessedNumbers));
                }else if (guess < 0) { // Check to see that they aren't guessing negative numbers
                    System.out.println("You can't guess negative numbers");
                }else{ // If all above is clear
                    higher = guess; // Save our guess
                    guessedNumbers = guessedNumbers + guess; // Take away how many numbers were guessed
                    answeredCorrectly = true; // Exit the loop
                }
            }

            System.out.println("Next are numbers that are lower than " + usersNumber);
            System.out.println("Any remaining numbers after this will be marked as same.");
            System.out.println("Total Numbers guessed: " + guessedNumbers + "/" + TOTAL);
            System.out.println((TOTAL - guessedNumbers) + " to go");

            if (guessedNumbers != 0) {
                answeredCorrectly = false; // We'll keep asking if the user doesn't answer correctly

                while (!(answeredCorrectly)) { // Repeat until the user answered correctly
                    System.out.print("How many numbers are lower than " + usersNumber + ": ");
                    int guess = keyInput.nextInt(); // Grab our users guess
                    if (guess > (TOTAL - guessedNumbers)) { // Check to see if they guessed more numbers than how many are left
                        System.out.println("You guessed too many numbers. The most you can guess is " + (TOTAL - guessedNumbers));
                    }else if (guess < 0) {// Check to see that they aren't guessing negative numbers
                        System.out.println("You can't guess negative numbers");
                    }else{ // If all above is clear
                        lower = guess; // Save our guess
                        guessedNumbers = guessedNumbers + guess; // Take away how many numbers were guessed
                        same = TOTAL - guessedNumbers; // Since there is no point on asking the final question, we can just save it.
                        System.out.println("Guessed " + same + " numbers were the same as " + usersNumber);
                        answeredCorrectly = true; // Exit the loop
                    }
                }
            }

            //Tally Time

            System.out.println();
            System.out.println("Tally Time");
            System.out.println("For every number that you guessed is higher, lower, or the same correct, you get a point");
            System.out.println();
            int score = 0; // Users final score
            System.out.println("Guessed Numbers higher than " + usersNumber + ": " + higher);
            System.out.println("Guessed Numbers lower than " + usersNumber + ": " + lower);
            System.out.println("Guessed Numbers the same as " + usersNumber + ": " + same);
            System.out.println();
            System.out.println();

            for (int i=0; i <= (TOTAL - 1); i++) { // Loop through the numbers
                System.out.println();
                System.out.println("Current Score: " + score);
                System.out.println();
                System.out.print("Random number: " + numbers[i] + " Your Number: " + usersNumber + " | ");
                if (numbers[i] > usersNumber) { // If the number is higher than the users number
                    if (higher > 0) { // and they guessed enough numbers that were higher,
                        System.out.println("+1 Point!");
                        score++; // they get a point
                        higher--; // this goes down so that the next time it doesn't give them a point if the only guessed 1
                        System.out.println("Guesses Higher than " + usersNumber + " remaining: " + higher);
                    }else{ //if they guessed too little
                        System.out.println("No Point"); // No point is given
                        System.out.println("You guessed too little for numbers higher than " + usersNumber);
                    }
                }else if (numbers[i] < usersNumber) {  // If the number is higher than the users number
                    if (lower > 0) { // and they guessed enough numbers that were higher,
                        System.out.println("+1 Point!");
                        score++; // they get a point
                        lower--; // this goes down so that the next time it doesn't give them a point if the only guessed 1
                        System.out.println("Guesses Lower than " + usersNumber + " remaining: " + lower);
                    }else{ //if they guessed too little
                        System.out.println("No Point"); // No point is given
                        System.out.println("You guessed too little for numbers lower than " + usersNumber);
                    }
                }else if (numbers[i] == usersNumber) {  // If the number is higher than the users number
                    if (same > 0) { // and they guessed enough numbers that were higher,
                        System.out.println("+1 Point!");
                        score++; // they get a point
                        same--; // this goes down so that the next time it doesn't give them a point if the only guessed 1
                        System.out.println("Guesses the same as " + usersNumber + " remaining: " + same);
                    }else{ //if they guessed too little
                        System.out.println("No Point"); // No point is given
                        System.out.println("You guessed too little for numbers the same as " + usersNumber);
                    }
                }
            }
            System.out.println();
            System.out.println();
            System.out.println("Finished");
            System.out.println("Your score: " + score); // Display their final score
            System.out.println();
            System.out.println("Would you like to play again? If so type yes");
            String response = keyInput.next();
            if (!response.toLowerCase().equals("yes")) { // If the answer wasn't yes, Yes, yEs, yeS, etc.
                System.out.println("Your reply was not yes.");
                System.out.println("Thanks for playing!");
                return; // Ends main so nothing else will run
            }
            System.out.println("Playing again."); // Loop starts over again


        }

    }

}
