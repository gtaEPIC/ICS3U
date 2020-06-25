package Data;

import java.io.*;
import java.util.Properties;
import java.util.Scanner;

public class Data {
    /*
    Purpose: Keeps a list of attendees and saves it to a file.
     */
    //Variables
    private static String[] names = {"Aron", "Bob", "Charlie", "Darek"};
    private static int[] age = {15, 14, 20, 55};
    private static boolean[] married = {false, false, false, true};
    private static Scanner keyInput = new Scanner(System.in);

    public static int nextInt() { // Created this knowing that Scanner.nextInt() and Scanner.next() will cause problems
        try {
            return Integer.parseInt(keyInput.next());
        }catch (Exception ex) {
            return 0;
        }
    }

    public static boolean save() { // Saves the current data
        File configFile = new File("attendees.list"); // Opens (or creates new) file
        try {
            Properties props = new Properties();
            // Create the arrays in a single string
            String namesArray = "";
            String ageArray = "";
            String marriedArray = "";
            for (int i = 0; i < names.length; i++) { // Add everything in the arrays into the string
                namesArray = namesArray + names[i];
                ageArray = ageArray + age[i];
                marriedArray = marriedArray + married[i];

                if (i != names.length - 1) { // Separates each part of the string so it can be loaded back into an array.
                    namesArray = namesArray + ", ";
                    ageArray = ageArray + ", ";
                    marriedArray = marriedArray + ", ";
                }
            }

            // Writes to the file
            props.setProperty("names", namesArray);
            props.setProperty("age", ageArray);
            props.setProperty("married", marriedArray);


            FileWriter writer = new FileWriter(configFile);
            props.store(writer, "Attendees List"); // Extra fancy stuff
            writer.close(); // Saves it
        } catch (Exception ex) { // In case it still fails
            System.out.println("Failed to save properly");
            return false; // Failed :(
        }
        return true; // Success!
    }

    public static boolean load() { // Attempts to load details from the save file
        File configFile = new File("attendees.list"); // Opens the file
        try {
            FileReader reader = new FileReader(configFile);
            Properties props = new Properties();
            props.load(reader); // Loads the file

            names = props.getProperty("names").split(", "); // Creates and rewrites the names array

            //These need more work because they are not supposed to be strings
            String[] ageString = props.getProperty("age").split(", ");
            String[] marriedString = props.getProperty("married").split(", ");

            // Allocates space for these new variables
            age = new int[ageString.length];
            married = new boolean[marriedString.length];

            for (int i = 0; i < ageString.length; i++) { // Goes through each variable and parses each one
                age[i] = Integer.parseInt(ageString[i]);
                married[i] = Boolean.parseBoolean(marriedString[i]);
            }

            reader.close(); // Close the file
        } catch (Exception ex) { // In case the file does not exist or other errors
            ex.printStackTrace();
            return false; // Failed :(
        }
        return true; // Success!
    }

    private static void listAttendees() { // Lists all the attendees so far.
        System.out.println("----- Attendees -----");
        for (int i = 0; i < names.length; i++) { // Goes through all the variables and prints them out
            System.out.print("Row: " + i + ", Name: " + names[i] + ", Age: " + age[i] + ", Married: ");
            if (married[i]) {
                System.out.println("Yes");
            }else{
                System.out.println("No");
            }
        }
        System.out.println("----- End of list -----");
    }

    private static void addAttendee() { // Adds an attendee to the list
        System.out.println("----- Add an attendee -----");
        System.out.print("Name: ");
        String newName = keyInput.next(); // Grab the new name
        System.out.print("Age: ");
        int newAge = nextInt(); // Grab the new age
        System.out.print("Married (yes/no): ");
        String response = keyInput.next();
        boolean newMarry;
        if (response.toLowerCase().equals("yes")) { // Figure out the answer
            newMarry = true;
        }else if (response.toLowerCase().equals("no")) {
            newMarry = false;
        }else{ // If an invalid response
            System.out.println("Invalid response");
            System.out.println("!!!!! Failed to create attendee !!!!!");
            System.out.println("Try again with a valid response");
            return;
        }
        //Shuffle the existing arrays around to allow more room; Keep track of the old array
        String[] oldNames = names;
        int[] oldAges = age;
        boolean[] oldMarry = married;
        //Create a new array with an extra space
        names = new String[names.length + 1];
        age = new int[age.length + 1];
        married = new boolean[married.length + 1];
        //Add the old data to the new
        for (int i = 0; i < oldNames.length; i++) {
            names[i] = oldNames[i];
            age[i] = oldAges[i];
            married[i] = oldMarry[i];
        }
        //Add new new data
        names[names.length - 1] = newName;
        age[age.length - 1] = newAge;
        married[married.length - 1] = newMarry;
        //Finished
        System.out.println("----- Attendee added -----");
        System.out.println("** Don't forget to save **");
    }

    private static void removeAttendee() { // Removes an attendee from the list
        System.out.println("----- Remove an Attendee -----");
        while (true) { // Loops until a row was given or was cancelled
            System.out.println("Type the Row the Attendee is on that you want to remove");
            System.out.println("Type List to show the list, or cancel to cancel");
            System.out.print("Row: ");
            String response = keyInput.next(); // Grab the users response
            if (response.toLowerCase().equals("list")) { // Checks for key words
                listAttendees();
            }else if (response.toLowerCase().equals("cancel")) {
                System.out.println("!!!!! Cancelled !!!!!");
                break;
            }else{ // If no keywords
                try {
                    int row = Integer.parseInt(response); // Find the row number
                    System.out.println("Removing...");
                    //Perform the same process as when adding but this time don't add one of the items.
                    String[] oldNames = names;
                    int[] oldAges = age;
                    boolean[] oldMarry = married;
                    //Create a new array with an extra space
                    names = new String[names.length - 1];
                    age = new int[age.length - 1];
                    married = new boolean[married.length - 1];
                    //Add the old data to the new
                    boolean skipped = false; // True when it has skipped over the row that is being deleted
                    for (int i = 0; i < oldNames.length; i++) {
                        if (skipped) { // If the item was skipped i is now out of sync, so -1
                            names[i - 1] = oldNames[i];
                            age[i - 1] = oldAges[i];
                            married[i - 1] = oldMarry[i];
                        }else if (i == row) { // If this is the item we are skipping, set skipped to true
                            skipped = true;
                        }else{ // If we haven't skipped it yet, i is still in sync
                            names[i] = oldNames[i];
                            age[i] = oldAges[i];
                            married[i] = oldMarry[i];
                        }
                    }
                    System.out.println("----- Finished deleting item -----");
                    break;
                } catch (Exception ex) {
                    System.out.println("!!!!! Error occurred. Please provide a valid response !!!!!");
                }
            }
        }
    }

    private static int[] addToResults(int[] resultRows, int number) { // Effectively adds a row number to a list (if it hasn't been added already)
        //Checks if the number was already added
        boolean alreadyExists = false;
        for (int resultRow : resultRows) {
            if (resultRow == number) {
                alreadyExists = true;
                break;
            }
        }
        if (alreadyExists) { // If the number is already in the list, return with no changes
            return resultRows;
        }
        // If it hasn't been added already, add more space to the list and add it in
        int[] newResultRows = new int[resultRows.length + 1];
        for (int i = 0; i < resultRows.length; i++) {
            newResultRows[i] = resultRows[i];
        }
        newResultRows[newResultRows.length - 1] = number;
        return newResultRows;
    }

    private static void findAttendee() { // Searches through the list using the keywords specified to return results
        System.out.println("----- Find an Attendee -----");
        System.out.println("Use key words (or numbers) to help locate someone on the list.");
        System.out.println("You can separate each word (or number) by a \",\" (Comma)");
        System.out.print("Search: ");
        String response = keyInput.next();
        String[] keys = response.split(","); // Grab and spit the key words into its own variable (technically)

        int[] resultRows = {}; // Create a blank result
        System.out.println("Searching...");
        for (String key : keys) { // Go through all the keys
            for (int i = 0; i < names.length; i++) { // Checks through names
                if (names[i].contains(key)) {
                    resultRows = addToResults(resultRows, i); // Adds this row number to the result
                }
            }
            for (int i = 0; i < age.length; i++) { // checks through the age
                if (String.valueOf(age[i]).contains(key)) {
                    resultRows = addToResults(resultRows, i); // Adds this row number to the result
                }
            }
        }
        //Search is complete at this point
        System.out.println("----- Results: " + resultRows.length + " -----");
        for (int result : resultRows) { // Spits out all of the results
            System.out.print("Row: " + result + ", Name: " + names[result] + ", Age: " + age[result] + ", Married: ");
            if (married[result]) {
                System.out.println("Yes");
            }else{
                System.out.println("No");
            }
        }
        System.out.println("----- End of Results -----");
    }

    private static void newList() { // Sets everything to blank basically
        names = new String[]{};
        age = new int[]{};
        married = new boolean[]{};
        System.out.println("!!!!! New blank list created !!!!!");
    }

    public static void main(String[] args) { // Main script
        if (load()) { // Attempts to load previous data that was saved
            System.out.println("A previous file was loaded. Here is the list:");
            listAttendees(); // If it was loaded, then spit out the list so the user knows what is what
        }else{
            System.out.println("No list was found yet, or an error occurred trying to load one.");
            System.out.println("A new list will be created when you save.");
            System.out.println("An example list has also been loaded."); //Its the default anyways
        }
        while (true) { // Loops until Exit
            System.out.println("Here is a list of options that you can do!");
            System.out.println();
            System.out.println("1. Print the list of attendees");
            System.out.println("2. Add a new attendee");
            System.out.println("3. Remove an attendee");
            System.out.println("4. Find a specific attendee");
            System.out.println("5. Create a new list (Deletes the old one)");
            System.out.println("6. Save");
            System.out.println("7. Exit");
            System.out.println();
            System.out.println("Select an option by typing the number of your choice");
            System.out.print("Choice: ");
            switch (nextInt()) { // Takes the users selection
                case 1:
                    listAttendees();
                    break;
                case 2:
                    addAttendee();
                    break;
                case 3:
                    removeAttendee();
                    break;
                case 4:
                    findAttendee();
                    break;
                case 5:
                    newList();
                    break;
                case 6:
                    if (save()) { // Attempts to save
                        System.out.println("Saved Successfully");
                    }else{
                        System.out.println("Failed to save successfully");
                    }
                    break;
                case 7:
                    System.out.println("Exiting, thanks for using the program.");
                    return;
                default:
                    System.out.println("Not a valid option. Use a number and select one of the options.");
                    break;
            }
        }
    }
}
