package Stages;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Stages {

    /*
    Purpose: Tests out the Try system + fill out a Test Log
     */

    public static Scanner keyInput = new Scanner(System.in); // Scanner

    public static void stage1() {
        while (true) { // Loops until a valid answer is given
            System.out.println("Please input a string longer than 6 characters");
            String text = keyInput.nextLine(); // Grab the users input
            if (text.length() > 6) { // Test
                break;
            }else{
                System.out.println("I said a string longer than 6 characters.");
            }
        }
        stage2();
    }

    public static void stage2() {
        while (true) { // Loops until a valid answer is given
            System.out.println("Please input a string containing the lowercase \"a\"");
            String text = keyInput.nextLine(); // Grab the users input
            if (text.contains("a")) {// Test
                break;
            }else{
                System.out.println("I said a string containing the lowercase \"a\"");
            }
        }
        stage3();
    }

    public static void stage3() {
        while (true) { // Loops until a valid answer is given
            System.out.println("Please input a string with a length between 5-15 characters and does not contain lowercase \"z\"");
            String text = keyInput.nextLine(); // Grab the users input
            if (!(text.length() >= 5 && text.length() <= 15)) { // Test
                System.out.println("I said a string between 5-15 characters.");
            }else if (text.contains("z")) { // Test again
                System.out.println("I said a string that also doesn't contain the lowercase \"z\"");
            }else{
                break;
            }
        }
        stage4();
    }

    public static void stage4() {
        while (true) { // Loops until a valid answer is given
            try {
                System.out.println("Please input an integer between 5-500");
                int number = Integer.parseInt(keyInput.next()); // Cannot use keyInput.nextInt() because it causes problems
                if (number >= 5 && number <= 500) { // Test
                    break;
                } else {
                    System.out.println("I said an integer between 5-500");
                }
            }catch (NumberFormatException exception) { // Fires if parseInt fails due to .next not a possible Int
                exception.printStackTrace(); // Might as well
                System.out.println("I said an INTEGER");
            }
        }
        stage5();
    }

    public static void stage5() {
        while (true) { // Loops until a valid answer is given
            try {
                System.out.println("Please input a negative integer");
                int number = Integer.parseInt(keyInput.next()); // Cannot use keyInput.nextInt() because it causes problems
                if (number < 0) { // Test
                    break;
                } else {
                    System.out.println("I said a negative integer");
                }
            }catch (NumberFormatException exception) { // Fires if parseInt fails due to .next not a possible Int
                exception.printStackTrace(); // Might as well
                System.out.println("I said an INTEGER");
            }
        }
        stage6();
    }

    public static void stage6() {
        while (true) { // Loops until a valid answer is given
            try {
                System.out.println("Please input a positive integer that is an odd number");
                int number = Integer.parseInt(keyInput.next()); // Cannot use keyInput.nextInt() because it causes problems
                if (number < 0) { // Test
                    System.out.println("I said a positive integer");
                }else if (number % 2 != 1) { // Test again
                    System.out.println("I said an odd number");
                } else {
                    break;
                }
            }catch (NumberFormatException exception) { // Fires if parseInt fails due to .next not a possible Int
                exception.printStackTrace(); // Might as well
                System.out.println("I said an INTEGER");
            }
        }
        congratulate();
    }

    public static void congratulate() {
        System.out.println("Congrats! You made it to the end");
    }

    public static void main(String[] args) {
        stage1(); // Start the 1st Stage
    }

}
