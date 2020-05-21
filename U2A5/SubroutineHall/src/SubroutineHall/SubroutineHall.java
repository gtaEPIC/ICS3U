package SubroutineHall;

import java.util.Scanner;

public class SubroutineHall {

    /*
    Multi-purpose program to do many different tasks.
     */

    public static Scanner keyInput = new Scanner(System.in);

    public static void rectangle() { // L*W to get the area of a rectangle
        System.out.print("Length: ");
        double length = keyInput.nextDouble();
        System.out.print("Height: ");
        double height = keyInput.nextDouble();
        System.out.println();
        System.out.println("The area if the rectangle is " + (length * height));
    }

    public static void gpe() { // m*g*h to get GPE in J
        System.out.print("Mass (kg): ");
        double mass = keyInput.nextDouble();
        System.out.print("Height (m): ");
        double height = keyInput.nextDouble();
        System.out.println();
        System.out.println("The GPE of the object you described has " + (mass * 9.8 * height) + " joules");
    }

    public static void kinetic() { // 0.5*m*v^2 to get kinetic energy
        System.out.print("Mass (kg): ");
        double mass = keyInput.nextDouble();
        System.out.print("Speed (m/s^2): ");
        double speed = keyInput.nextDouble();
        System.out.println();
        System.out.print("The amount of kinetic energy of the object you described has ");
        System.out.println((0.5 * mass * Math.pow(speed, 2)) + " joules");
    }

    public static String[] getNumbers() { // Asks user to input a bunch of numbers which are split into an array.
        System.out.println("Enter all the numbers and separate them with 1 space.");
        System.out.print("Numbers: ");
        keyInput.nextLine(); // keyInput.nextInt(); Does not clear Scanner's buffer.
        return keyInput.nextLine().split(" ");
    }

    public static void sum() { // Adds a list of numbers together
        String[] stringNumbers = getNumbers();
        int total = 0;
        for (int i = 0; i <= stringNumbers.length - 1; i++) {
            total += Integer.parseInt(stringNumbers[i]);
        }
        System.out.println();
        System.out.println("The sum is " + total);
    }

    public static void averages() { // Gets the average of a list of numbers.
        String[] stringNumbers = getNumbers();
        int total = 0;
        for (int i = 0; i <= stringNumbers.length - 1; i++) {
            total += Integer.parseInt(stringNumbers[i]);
        }
        System.out.println();
        System.out.println("The average for all " + stringNumbers.length + " number(s) provided is " + (total / stringNumbers.length));
    }

    public static void main(String[] args) { // Main Program
        System.out.println("Math time again!");
        while (true) {
            // Options
            System.out.println("Below are a few options you can choose from to complete different tasks");
            System.out.println("1. Determine the area of a rectangle.");
            System.out.println("2. Find the Gravitational Potential Energy (GPE) (Requires Mass and Height)");
            System.out.println("3. Find the Kinetic Energy of an object (Requires Mass and Speed)");
            System.out.println("4. Find the sum of a list of numbers");
            System.out.println("5. Find the average of a list of numbers.");
            System.out.println("6. Exit");

            switch (keyInput.nextInt()) { // Users input
                case 1:
                    rectangle();
                    break;
                case 2:
                    gpe();
                    break;
                case 3:
                    kinetic();
                    break;
                case 4:
                    sum();
                    break;
                case 5:
                    averages();
                    break;
                case 6:
                    System.out.println("Thanks for using this math program");
                    return; // Ends function completely
                default:
                    System.out.println("Invalid option, choose again...");
                    break;
            }
            System.out.println();
        }

    }

}
