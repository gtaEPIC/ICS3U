package saleShoppingHall;

import java.util.Scanner;

public class saleShoppingHall {

    public static void main(String[] args) {
        //Create new Scanner object for the user to enter in Text in the console
        Scanner keyedInput = new Scanner(System.in);

        //Ask and save the amount of money being spent
        System.out.print("Please enter the amount being spent: ");
        double spent = keyedInput.nextDouble();

        //Find a Discount that is eligible
        if (spent > 120) { //If the user spent more than $120 then they get the following discount
            System.out.println("You are getting a 40% Discount!");
            double saved = Math.round((spent * 0.40) * 100) / 100;
            System.out.println("You are saving $" + String.valueOf(saved));
            System.out.println("Your final total is $" + String.valueOf(Math.round((spent - saved) * 100) / 100));
        }else if (spent > 80) { //If the user didn't spent more that $120 but more than $80 then they get the following discount.
            System.out.println("You are getting a 30% Discount!");
            double saved = Math.round((spent * 0.30) * 100) / 100;
            System.out.println("You are saving $" + String.valueOf(saved));
            System.out.println("Your final total is $" + String.valueOf(Math.round((spent - saved) * 100) / 100));
        }else if (spent > 40) { //If the user didn't spend more than $80 but more than $40 then they get the following discount.
            System.out.println("You are getting a 20% Discount!");
            double saved = Math.round((spent * 0.20) * 100) / 100;
            System.out.println("You are saving $" + String.valueOf(saved));
            System.out.println("Your final total is $" + String.valueOf(Math.round((spent - saved) * 100) / 100));
        }else if (spent > 0) { //If they didn't spend more than $40 but they at least spent something then they get the following discount.
            System.out.println("You are getting a 10% Discount!");
            double saved = Math.round((spent * 0.10) * 100) / 100;
            System.out.println("You are saving $" + String.valueOf(saved));
            System.out.println("Your final total is $" + String.valueOf(Math.round((spent - saved) * 100) / 100));
        }else{ //If they didn't spend anything or they submitted a value less than 0 then say the following.
            System.out.println("Sorry but the amount you entered is not eligible for a discount.");
            System.out.println("Please enter an amount that is higher than $0");
        }

    }

}
