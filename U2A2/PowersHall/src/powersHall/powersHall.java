package powersHall;

import java.util.Scanner;

public class powersHall {
    /*
        Purpose of this program is to take the users number and square, cube, or put it to the power
        of any number that the user also gives.
        If the user picks Option 4, (Exit) then the loop will end causing the program to finish
     */

    //=+=+=+=+=+ Global Variables +=+=+=+=+=
    public static Scanner keyInput = new Scanner(System.in); // Make a new Scanner object for all functions

    public static void option1() { // This function squares the number given by the user

        System.out.println("Type a number that you want to be squared.");
        System.out.print("Number: ");
        int number = keyInput.nextInt(); // Grab out number to be squared
        int newNumber = number;
        System.out.println("Squaring...");
        for (int i=0; i <= 0; i++) { // 0 because it only needs to be done once for squaring
            newNumber = newNumber * number; // Example: 2*2 = 4, so 4*2 is the same as saying 2*2*2
        }
        System.out.println();
        System.out.println("Finished!!");
        System.out.println("Your final number is: " + newNumber);

    }

    public static void option2() { // This function cubes the number given by the user
        System.out.println("Type a number that you want to be Cubed.");
        System.out.print("Number: ");
        int number = keyInput.nextInt(); // Grab out number to be squared
        int newNumber = number;
        System.out.println("Cubing...");
        for (int i=0; i <= 1; i++) { // 0 because it only needs to be done twice for Cubing
            newNumber = newNumber * number; // Example: 2*2 = 4, so 4*2 is the same as saying 2*2*2
        }
        System.out.println();
        System.out.println("Finished!!");
        System.out.println("Your final number is: " + newNumber);
    }

    public static void option3() { // This function will put the number given to the power of another number given
        System.out.println("Type a number in that will be put to a power.");
        System.out.print("Number: ");
        int number = keyInput.nextInt(); // Grab out number to be squared
        System.out.println("Type a power for the other number to be put to. (" + number + "^?)");
        System.out.print("Power: ");
        int power = keyInput.nextInt(); // Grab out number to be squared
        int newNumber = number;
        System.out.println("Powering...");
        for (int i=0; i <= power - 2; i++) { // Power is subtracted by 2 so that way it works properly when counting in the for loop
            newNumber = newNumber * number; // Example: 2*2 = 4, so 4*2 is the same as saying 2*2*2
        }
        System.out.println();
        System.out.println("Finished!!");
        System.out.println("Your final number is: " + newNumber);
    }

    public static void main(String[] args) {
        //Main Function
        while (true) { //Loop forever until the 4th option is selected
            System.out.println("Welcome to the powering program");
            System.out.println("This program can square, cube or put anything to the power of your choice");
            System.out.println();
            System.out.println("Here are the following options you can choose from:");
            System.out.println();
            System.out.println("1. Square any number of your choice (number^2)");
            System.out.println("2. Cube any number of your choice (number^3)");
            System.out.println("3. Put any number to the power of another number (number^?)");
            System.out.println("4. Exit");
            System.out.println();
            System.out.println("Select your option below. Type the number of your option and hit enter.");
            System.out.print("Your option: ");
            int choice = keyInput.nextInt(); //Grab our number provided by the user
            switch (choice) { //Figure out which number was selected and run that specific function
                case 1:
                    option1();
                    break;
                case 2:
                    option2();
                    break;
                case 3:
                    option3();
                    break;
                case 4:
                    System.out.println("Thank you for using this program. Bye"); //Exit the program by
                    return; //Returning and ending the main function. (The loop can't run if main() is not running)
                default: //If the number the user used was invalid, let them know
                    System.out.println("The number you provided was not a valid option. Please try again.");
                    break;
            }
        }


    }

}
