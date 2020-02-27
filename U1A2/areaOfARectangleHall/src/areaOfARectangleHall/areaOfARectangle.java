package areaOfARectangleHall;

import java.util.Scanner;


public class areaOfARectangle {

    public static void main(String[] args) {
        Scanner keyedInput = new Scanner(System.in);

        double length;
        double width;

        System.out.println("Hello! Please enter the length of a square you want to find the area for (Does not have to be a whole number):");
        length = keyedInput.nextDouble();
        System.out.println("Finally, please enter the width of the same square:");
        width = keyedInput.nextDouble();
        System.out.println("Perfect! Now I just go to calculate your math problem");
        double area = length * width;
        System.out.println("Ta da! All finished! The area of " + length + " x " + width + " is: " + area);

    }

}
