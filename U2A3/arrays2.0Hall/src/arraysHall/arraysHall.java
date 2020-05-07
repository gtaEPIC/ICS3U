package arraysHall;

import java.util.Scanner;

public class arraysHall {

    public static void main(String[] args) {
        /*
        This program tells you who your second, third and fourth friend is
         */

        Scanner keyedInput = new Scanner (System.in);

        int repeats = 5; // How many times a friend has to be entered in

        String [] friends = new String [repeats];

        System.out.println("Enter the names of " + repeats + " friends:");
        for (int i = 0; i <= repeats -1 ; i = i + 1)
        {
            friends[i] = keyedInput.nextLine(); // Store friend's name and store it in the array
        }

        System.out.println("The second, third, and fourth names listed were:");
        System.out.println("Second: " + friends[1]); // Second Friend
        System.out.println("Third: " + friends[2]); // Third Friend
        System.out.println("Fourth: " + friends[3]); // Fourth Friend

    }

}
