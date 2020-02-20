package areaOfACircleHall;

import java.util.Scanner;

public class areaOfACircleHall {
    public static void main(String[] args) {
        Scanner keyedInput = new Scanner(System.in);
        double radius;
        double pi = 3.14;

        System.out.println("Hello! To find the area of a circle, please enter the radius:");
        radius = keyedInput.nextDouble();
        System.out.println("Perfect! Now calculating...");
        radius = Math.pow(radius, 2);
        double area = radius * pi;
        System.out.println("Finished! The area of the circle is " + area);


    }
}
