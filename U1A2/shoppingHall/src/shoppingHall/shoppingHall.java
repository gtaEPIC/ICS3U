package shopping;

import java.util.Scanner;

public class shopping {
    public static void main(String[] args) {
        //Prices
        final double USB_PRICES = 19.99;
        final double KEYBOARD_PRICES = 49.99;
        final double MOUSE_PRICES = 25.99;
        final double TAX = 1.13;
        //Initialize other variables
        Scanner keyInput = new Scanner(System.in);
        int usbAmount;
        int keyboardAmount;
        int mouseAmount;
        double subtotal;

        //Program
        System.out.println("Welcome to the line shop where you order via this console. In case you never installed a web browser.");
        System.out.println("You will be asked to input the quantity of the item you would like to purchase.");
        System.out.println("Here are the three items with the prices:");
        System.out.println("1. USB Storage Device - $" + USB_PRICES);
        System.out.println("2. Keyboard - $" + KEYBOARD_PRICES);
        System.out.println("3. Computer Mouse - $" + MOUSE_PRICES);
        System.out.println("Now for the first item. How many USB Storage Devices for $" + USB_PRICES + " would you like to buy:");
        usbAmount = keyInput.nextInt();
        System.out.println("Cool! Next, how many Keyboards for $" + KEYBOARD_PRICES + " would you like to buy:");
        keyboardAmount = keyInput.nextInt();
        System.out.println("Alright! Last one, how many Computer Mouse's for $" + MOUSE_PRICES + " would you like to buy:");
        mouseAmount = keyInput.nextInt();
        System.out.println("Perfect! Time to calculate your total.");
        subtotal = (usbAmount * USB_PRICES) + (keyboardAmount * KEYBOARD_PRICES) + (mouseAmount * MOUSE_PRICES);
        double total = subtotal * TAX;
        System.out.printf("Your final total after tax is $%.2f %n", total);
    }
}
