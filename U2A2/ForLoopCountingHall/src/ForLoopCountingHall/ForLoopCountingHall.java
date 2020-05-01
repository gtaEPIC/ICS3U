package ForLoopCountingHall;

import java.util.Scanner;

public class ForLoopCountingHall {

    public static void main(String[] args) {
        Scanner keyInput = new Scanner(System.in);
        System.out.println("");
        System.out.println("=+=+=+=+=+ Welcome to Cool Counter Program +=+=+=+=+=");
        System.out.println("");
        System.out.println("Below are a few options that you can pick from to count from, and by");
        System.out.println("");
        System.out.println("These options are:");
        System.out.println("1. Count from 0 to 10 by 1's");
        System.out.println("2. Count from 100 to 0 by 10's");
        System.out.println("3. Count from 50 to 500 by 50's");
        System.out.println("4. Count from 6000 to 1000 by 1000's");
        System.out.println("Make your choice below by entering the option number.");
        System.out.print("Your choice: ");
        int choice = keyInput.nextInt();
        switch (choice) {
            case 1:
                System.out.println("You wanted to count from 0 to 10 by 1's");
                System.out.println("");
                System.out.println("=+=+=+=+=+ Counting +=+=+=+=+=");
                System.out.println("");
                for (int i = 0; i <= 10; i++) { //We can use ++ in this scenario only because it does up by 1
                    System.out.println(i);
                }
                break;
            case 2:
                System.out.println("You wanted to count from 100 to 0 by 10's");
                System.out.println("");
                System.out.println("=+=+=+=+=+ Counting +=+=+=+=+=");
                System.out.println("");
                for (int i = 100; i >= 0; i = i - 10) {
                    System.out.println(i);
                }
                break;
            case 3:
                System.out.println("You wanted to count from 50 to 500 by 50's");
                System.out.println("");
                System.out.println("=+=+=+=+=+ Counting +=+=+=+=+=");
                System.out.println("");
                for (int i = 50; i <= 500; i = i + 50) { //We can use ++ in this scenario only because it does up by 1
                    System.out.println(i);
                }
                break;
            case 4:
                System.out.println("You wanted to count from 6000 to 1000 by 1000's");
                System.out.println("");
                System.out.println("=+=+=+=+=+ Counting +=+=+=+=+=");
                System.out.println("");
                for (int i = 6000; i >= 1000; i = i - 1000) { //We can use ++ in this scenario only because it does up by 1
                    System.out.println(i);
                }
                break;
            default:
                System.out.println("Hmm, seems the option you gave was an invalid option. Please try again");
                return;
        }
        System.out.println("");
        System.out.println("=+=+=+=+=+ Finished +=+=+=+=+=");
        System.out.println("Well, my job is completed. Thanks for using this counter.");
    }

}
