package CreateYourOwnAdventureHall;

import java.util.Scanner;

public class CreateYourOwnAdventureHall {
    public static Scanner keyInput = new Scanner(System.in);
    public static Boolean hasMoney = true;

    public static void wastedMoneyChoice() {
        hasMoney = false;
        System.out.println("What do you do? Choices:");
        System.out.println("(Unplug) the lamp and plug it back in, Try turning on and (off) the lamp");
        System.out.print("Your selection: ");
        String selection = keyInput.next();
        switch (selection.toLowerCase()) {
            case "unplug":
                unplugTheBulb();
                break;
            case "off":
                turnOnAndOffTheBulb();
                break;
            default:
                System.out.println("Hmm, the key you were trying to use wasn't an option");
                System.out.println("Please try again");
                purchaseBulb();
                break;
        }
    }

    public static void purchaseBulb() {
        System.out.println("");
        System.out.println("You went and purchased a brand to bulb for your lamp!");
        System.out.println("You unscrewed the bulb and screwed the new one in.");
        System.out.println("Except nothing happened. The Lamp is still not on, and now you are low on money.");
        System.out.println("");
        wastedMoneyChoice();

    }

    public static void waitForBulb() {
        System.out.println("");
        System.out.println("You waited, and waited.");
        System.out.println("You eventually got bored and purchased some pizza.");
        System.out.println("Nothing happened. The Lamp is still not on, and now you are low on money.");
        System.out.println("");
        wastedMoneyChoice();
    }

    public static void progressionChoice() {
        System.out.println("Nothing happened, but while you were by the cord, you noticed it was broken!");
        System.out.println("You look over at your cat that totally looks innocent.");
        System.out.println("So innocent that you totally do not want to (throw) the cat outside!");
        System.out.println("");
        System.out.println("What do you do? Choices:");
        System.out.println("Attempt to (fix) the cord with what you have, or look for a spare cord and (replace) it");
        String selection = keyInput.next();
        switch (selection.toLowerCase()) {
            case "throw":
                System.out.println("Why would you throw your cat outside!?");
                System.out.println("I don't know why you would do that but I will not allow that");
                System.out.println("Pick again >:(");
                progressionChoice();
                break;
            case "fix":
                System.out.println("You spent hours trying to fix the cable.");
                System.out.println("Finally it was the moment of truth");
                System.out.println("You go to slowly plug it into the wall, both you acn your cat starring at it.");
                System.out.println("Finally it goes into the wall, sparks start flying from the cord!");
                System.out.println("The lamp explodes a little bit and now it is for sure broken.");
                if (hasMoney) {
                    System.out.println("Luckily, you still have money in your pockets!");
                    System.out.println("You went to IKEA and bought a brand new lamp!");
                    System.out.println("Now it won't be so dark next time.");
                }else{
                    System.out.println("You had the idea of going to IKEA to buy a new lamp,");
                    System.out.println("But you spent the money you had on something else :/");
                    System.out.println("Looks as if you'll be sitting in the dark room till you get enough money.");
                }
                break;
            case "replace":
                System.out.println("You looked around in bins that you had, and found a spare cord!");
                System.out.println("Using the small knowledge about electronics, you somehow manage to replace the cord");
                System.out.println("You plugged it in and it works!!");
                System.out.println("Now you can enjoy the nice lit up area.");
        }
    }

    public static void unplugTheBulb() {
        System.out.println("");
        System.out.println("You unplugged and plugged in the lamp.");
        progressionChoice();
    }

    public static void turnOnAndOffTheBulb() {
        System.out.println("");
        System.out.println("You went and turned off and on the lamp.");
        progressionChoice();
    }

    public static void callARepairman() {
        System.out.println("You called a repairman to fix your lamp.");
        System.out.println("He fixed it, now it works. So you left it at that for the day.");
        System.out.println("But that was an easy story that you picked. Pick a different one now");
        mainSelection();
    }

    public static void goToIKEA() {
        System.out.println("You went to IKEA and bought a new lamp.");
        System.out.println("It works. So you left it at that for the day.");
        System.out.println("But that was an easy story that you picked. Pick a different one now");
        mainSelection();
    }

    public static void mainSelection() {
        System.out.println("");
        System.out.println("How to make a selection:");
        System.out.println("When prompted, you will be given a few selections to choose from");
        System.out.println("Each selection will contain a key word in (brackets)");
        System.out.println("Type that key word in and hit enter to make that selection.");
        System.out.println("");
        System.out.println("What will you do? Choices:");
        System.out.println("(Purchase) a new light bulb, (Wait) for it to turn back on,");
        System.out.println("(Unplug) the lamp and plug it back in, Try turning on and (off) the lamp");
        System.out.println("Call a (Repairman) to fix the lamp, or go to (IKEA) and buy a new one.");
        System.out.print("Your selection: ");
        String selection = keyInput.next();
        switch (selection.toLowerCase()) {
            case "purchase":
                purchaseBulb();
                break;
            case "wait":
                waitForBulb();
                break;
            case "unplug":
                unplugTheBulb();
                break;
            case "off":
                turnOnAndOffTheBulb();
                break;
            case "repairman":
                callARepairman();
                break;
            case "ikea":
                goToIKEA();
                break;
            default:
                System.out.println("Hmm, the key you were trying to use wasn't an option");
                System.out.println("Please try again");
                mainSelection();
                break;
        }
    }

    public static void main(String[] args) {
        System.out.println("One day during these lonely times");
        System.out.println("You grab a book and sit down to read it.");
        System.out.println("A little while later, your lamp goes out!");
        mainSelection();
    }

}
