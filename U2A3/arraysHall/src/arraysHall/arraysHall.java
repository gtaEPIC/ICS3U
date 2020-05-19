package arraysHall;

import java.util.Scanner;

public class arraysHall {
    /*
    Adds 20 numbers together.
     */

    public static void main(String[] args) {
        Scanner keyedInput = new Scanner(System.in);

        int repeat = 20; // This is how many numbers the user has to input.

        int [] numbers = new int [repeat];
        int total = 0;

        System.out.println("Enter " + repeat + " integers and they will be added together:");
        for (int i = 0; i <= repeat - 1; i = i + 1)
        {
            numbers[i] = keyedInput.nextInt(); // Grab a number the user inputted and store it in the array
        }


        for (int i = 0; i <= repeat - 1; i = i + 1)
        {
            total = total + numbers[i]; // Add the numbers together
        }

        System.out.println("The sum of those numbers is:");
        System.out.println(total);
    }


}
