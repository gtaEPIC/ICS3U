import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TypeCasting extends JFrame{
    // GUI generated Variables
    private JPanel pnlMain;
    private JButton btnConvert1;
    private JTextField txtConvert1;
    private JTextField txtConvert2;
    private JTextField txtConvert3;
    private JTextField txtConvert4;
    private JTextField txtConvert5;
    private JTextField txtConvert6;
    private JButton btnConvert2;
    private JButton btnConvert3;
    private JButton btnConvert4;
    private JButton btnConvert5;
    private JButton btnConvert6;
    private JLabel lblCastReturn1;
    private JLabel lblCastReturn2;
    private JLabel lblCastReturn3;
    private JLabel lblCastReturn4;
    private JLabel lblCastReturn5;
    private JLabel lblCastReturn6;

    public TypeCasting(String title) { // Button handling and GUI Setup
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(pnlMain);
        this.pack();
        btnConvert1.addActionListener(new ActionListener() { // Whole number -> int -> Double
            @Override
            public void actionPerformed(ActionEvent e) {
                int number = Integer.parseInt(txtConvert1.getText()); // Grab and store
                lblCastReturn1.setText(String.valueOf((double) number)); // Convert into double (and convert to
                // string because of swing) and display
            }
        });
        btnConvert2.addActionListener(new ActionListener() { // Decimal Number -> Double -> Int
            @Override
            public void actionPerformed(ActionEvent e) {
                double number = Double.parseDouble(txtConvert2.getText()); // Grab and store
                lblCastReturn2.setText(String.valueOf((int) number)); // Convert into int (and convert to
                // string because of swing) and display
            }
        });
        btnConvert3.addActionListener(new ActionListener() { // A single character -> Char -> String
            @Override
            public void actionPerformed(ActionEvent e) {
                char character = txtConvert3.getText().charAt(0); // Grab and store
                lblCastReturn3.setText(String.valueOf(character)); // Convert into string and display
            }
        });
        btnConvert4.addActionListener(new ActionListener() { // Name -> String -> Char (first letter)
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = txtConvert4.getText(); // Grab and store
                lblCastReturn4.setText(String.valueOf(text.charAt(0))); // Convert into char (and convert back to
                // string because of swing) and display
            }
        });
        btnConvert5.addActionListener(new ActionListener() { // Whole number -> String -> int
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = String.valueOf(Integer.parseInt(txtConvert5.getText())); // Grab and store
                lblCastReturn5.setText(String.valueOf(Integer.parseInt(text))); // Convert into int (and convert back to
                // string because of swing) and display
            }
        });
        btnConvert6.addActionListener(new ActionListener() { // Decimal number -> String -> Double
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = String.valueOf(Double.valueOf(txtConvert6.getText())); // Grab and store
                lblCastReturn6.setText(String.valueOf(Double.valueOf(text))); // Convert into int (and convert back to
                // string because of swing) and display
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new TypeCasting("More Numbers!!"); // Creates the GUI
        frame.setVisible(true); // Displays the GUI
    }
}
