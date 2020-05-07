package arraysHall;

public class arraysHall {
    /*
    Adds numbers, and gets the average of those numbers.
     */


    public static void main(String[] args) {

        double [ ] marks = {34.7, 54.1, 34.8, 99.6, 43.6, 43.2, 65.8, 44.8, 88.6}; // Marks
        double total=0;
        double average;

        System.out.println("These are the marks:");
        for (int i = 0; i <= marks.length - 1; i= i + 1) // Prints the marks
        {
            System.out.println(marks[i]);
        }

        for (int i = 0; i <= marks.length - 1; i= i + 1) // Tally's the marks
        {
            total = total + marks[i];
        }

        average = total/marks.length; // Figures the average of the marks

        average = average * 10;
        average = Math.round(average); // Rounds the marks
        average = average/10;

        System.out.println("The average mark is:");
        System.out.println(average); // Spits out the marks

    }

}
