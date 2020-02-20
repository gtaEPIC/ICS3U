package waterAndComputerHall;

import java.util.Scanner;

public class waterAndComputerHall {
    public static void main(String[] args) {
        Scanner keyedInput = new Scanner(System.in);
        final double TONS_OF_WATER = 1.5;
        int combos;

        System.out.println("How many computer/monitor combos do you own?");
        combos = keyedInput.nextInt();
        double tonsUsed = TONS_OF_WATER * combos;
        System.out.println("FACT: Did you know it takes 1.5 tons of water to manufacture one computer/monitor combo?");
        System.out.println("So this means that the number of computer/monitor combos you own had to use " + combos + " tons of water!");

    }
}
