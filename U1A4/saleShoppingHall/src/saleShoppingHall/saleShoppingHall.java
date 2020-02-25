package saleShoppingHall;

import java.util.Scanner;

public class saleShoppingHall {

    public static void main(String[] args) {

        Scanner keyedInput = new Scanner(System.in);

        System.out.print("Please enter the amount being spent: ");
        double spent = keyedInput.nextDouble();

        if (spent > 120) {
            System.out.println("You are getting a 40% Discount!");
            double saved = Math.round((spent * 0.40) * 100) / 100;
            System.out.println("You are saving $" + String.valueOf(saved));
            System.out.println("Your final total is $" + String.valueOf(Math.round((spent - saved) * 100) / 100));
        }else if (spent > 80) {
            System.out.println("You are getting a 30% Discount!");
            double saved = Math.round((spent * 0.30) * 100) / 100;
            System.out.println("You are saving $" + String.valueOf(saved));
            System.out.println("Your final total is $" + String.valueOf(Math.round((spent - saved) * 100) / 100));
        }else if (spent > 40) {
            System.out.println("You are getting a 20% Discount!");
            double saved = Math.round((spent * 0.20) * 100) / 100;
            System.out.println("You are saving $" + String.valueOf(saved));
            System.out.println("Your final total is $" + String.valueOf(Math.round((spent - saved) * 100) / 100));
        }else if (spent > 0) {
            System.out.println("You are getting a 10% Discount!");
            double saved = Math.round((spent * 0.10) * 100) / 100;
            System.out.println("You are saving $" + String.valueOf(saved));
            System.out.println("Your final total is $" + String.valueOf(Math.round((spent - saved) * 100) / 100));
        }else{
            System.out.println("Sorry but the amount you entered is not eligible for a discount.");
            System.out.println("Please enter an amount that is higher than $0");
        }

    }

}
