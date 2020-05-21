import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UsingStringMethodsHall extends JFrame {

    /*
    Purpose: To explore some of the String Methods in java.
     */


    //GUI Variables
    private JTextField txtLength;
    private JButton btnLength;
    private JPanel pnlMain;
    private JLabel lblTitle;
    private JLabel lblInfo1;
    private JLabel lblInfo2;
    private JTextField txtIdentical2;
    private JTextField txtContains2;
    private JLabel lblReturnLength;
    private JTextField txtCaps;
    private JButton btnCaps;
    private JLabel lblReturnCaps;
    private JLabel lblInfo3;
    private JTextField txtCharacter;
    private JButton btnCharacter;
    private JLabel lblReturnCharacter;
    private JLabel lblInfo4;
    private JTextField txtIdentical1;
    private JButton btnIdentical;
    private JLabel lblReturnIdentical;
    private JLabel lblInfo5;
    private JTextField txtContains1;
    private JButton btnContains;
    private JLabel lblReturnContains;
    private JLabel lblInfo6;
    private JTextField txtPart;
    private JButton btnPart;
    private JLabel lblReturnPart;
    private JLabel lblInfo7;
    private JTextField txtReplace;
    private JButton btnReplace;
    private JLabel lblReturnReplace;

    public UsingStringMethodsHall(String title) {
        //Form setup
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(pnlMain);
        this.pack();

        btnLength.addActionListener(new ActionListener() { // Gets the length of the String
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = txtLength.getText();
                lblReturnLength.setText(String.valueOf(text.length()));
            }
        });
        btnCaps.addActionListener(new ActionListener() { // Converts all the characters to be in CAPS
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = txtCaps.getText();
                lblReturnCaps.setText(text.toUpperCase());
            }
        });
        btnCharacter.addActionListener(new ActionListener() { // Grabs the 4th character
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = txtCharacter.getText();
                lblReturnCharacter.setText(String.valueOf(text.charAt(3))); // A string starts with character 0
            }
        });
        btnIdentical.addActionListener(new ActionListener() { // Checks to see if two Strings are the same
            @Override
            public void actionPerformed(ActionEvent e) {
                String text1 = txtIdentical1.getText();
                String text2 = txtIdentical2.getText();
                lblReturnIdentical.setText(String.valueOf(text1.equals(text2)));
            }
        });
        btnContains.addActionListener(new ActionListener() { // Checks to see if String1 has String2
            @Override
            public void actionPerformed(ActionEvent e) {
                String text1 = txtContains1.getText();
                String text2 = txtContains2.getText();
                lblReturnContains.setText(String.valueOf(text1.contains(text2)));
            }
        });
        btnPart.addActionListener(new ActionListener() { // Grabs a section of the string
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = txtPart.getText();
                lblReturnPart.setText(text.substring(3,7)); // An string starts with character 0
            }
        });
        btnReplace.addActionListener(new ActionListener() { // Replaces a lowercase a with x
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = txtReplace.getText();
                lblReturnReplace.setText(text.replace("a", "x"));
            }
        });
    }

    public static void main(String[] args) { // Sets up the app and displays it
        JFrame frame = new UsingStringMethodsHall("Using String Methods");
        frame.setVisible(true);
    }
}
