import javax.swing.*;

public class guessingGameHall extends JFrame {
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

    public guessingGameHall(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(pnlMain);
        this.pack();


    }

    public static void main(String[] args) {
        JFrame frame = new guessingGameHall("Dice Game");
        frame.setVisible(true);
    }
}
