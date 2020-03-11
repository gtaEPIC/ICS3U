import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frmGuessingGameHall extends JFrame {
    //Auto generated form variables
    private JTextField txtGuess;
    private JButton btnRoll;
    private JLabel lblTitle;
    private JLabel lblGuess;
    private JLabel lblRoll;
    private JLabel lblRolled;
    private JLabel lblInfoRoll;
    private JLabel lblRolls;
    private JLabel lblInfoCorrectGuess;
    private JLabel lblInfoWrongGuess;
    private JLabel lblInfoPercent;
    private JLabel lblCorrectGuess;
    private JLabel lblWrongGuess;
    private JLabel lblPercent;
    private JLabel lblInfo;
    private JLabel lblInfo2;
    private JPanel pnlMain;

    //Game Variables
    int rolls = 0;
    int correct = 0;
    int wrong = 0;
    double percent = 0;

    //Function to refresh the text on the form for when the dice is rolled
    public void refresh() {

        lblRolls.setText(String.valueOf(rolls));
        lblCorrectGuess.setText(String.valueOf(correct));
        lblWrongGuess.setText(String.valueOf(wrong));
        lblPercent.setText(String.valueOf((int) percent) + "%");

    }

    public frmGuessingGameHall(String title) {
        //Form setup
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(pnlMain);
        this.pack();

        lblRolled.setText("-"); //Set the number rolled value label to nothing or -
        refresh(); //Change the (Place Holders) to their proper values


        btnRoll.addActionListener(new ActionListener() { //When roll button is pushed
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //Create random number and grab the guess the user entered
                int rand = (int) (Math.random() * 6) + 1; //I know there is a better way, but just in case we will use this
                int input = Integer.parseInt(txtGuess.getText());

                lblRolled.setText(String.valueOf(rand)); //Show what number was rolled from the dice

                rolls += 1; //Change the times the dice was rolled

                //Check if the guess was correct or wrong
                if (rand == input) {
                    correct += 1;
                }else{
                    wrong += 1;
                }

                percent = ((double) correct / (double) rolls) * 100 ; //Figure out the new percentage of correct guesses
                refresh(); //Make sure the labels on the form are updated

            }
        });
    }

    public static void main(String[] args) {
        //Create the form as a frame and display it
        JFrame frame = new frmGuessingGameHall("Dice Game");
        frame.setVisible(true);
    }
}
