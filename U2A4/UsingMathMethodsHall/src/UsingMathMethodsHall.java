import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UsingMathMethodsHall extends JFrame {
    /*
    Purpose of this program: You can use a wide variety of methods provided in the Math class.
     */


    // GUI Variables
    private JPanel pnlMain;
    private JTextField txtLarge1;
    private JButton btnLarge;
    private JTextField txtLarge2;
    private JLabel lblReturnLarge;
    private JTextField txtSmall1;
    private JTextField txtSmall2;
    private JButton btnSmall;
    private JLabel lblReturnSmall;
    private JTextField txtPower1;
    private JTextField txtPower2;
    private JButton btnPower;
    private JLabel lblReturnPower;
    private JTextField txtHypotenuse1;
    private JTextField txtHypotenuse2;
    private JButton btnHypotenuse;
    private JLabel lblReturnHypotenuse;
    private JTextField txtRoundUp;
    private JButton btnRoundUp;
    private JLabel lblReturnRoundUp;
    private JTextField txtRoundDown;
    private JButton btnRoundDown;
    private JLabel lblReturnRoundDown;
    private JTextField txtSquareRoot;
    private JButton btnSquareRoot;
    private JLabel lblReturnSquareRoot;
    private JTextField txtRadians;
    private JButton btnRadians;
    private JLabel lblReturnRadians;
    private JLabel lblTitle;
    private JLabel lblInfo1;
    private JLabel lblInfo2;
    private JLabel lblInfo3;
    private JLabel lblInfo4;
    private JLabel lblInfo5;
    private JLabel lblInfo6;
    private JLabel lblInfo7;
    private JLabel lblInfo8;

    public UsingMathMethodsHall(String title) {
        //Form setup
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(pnlMain);
        this.pack();

        // BUTTONS
        btnLarge.addActionListener(new ActionListener() { // Find Largest of 2 numbers
            @Override
            public void actionPerformed(ActionEvent e) {
                int number1 = Integer.parseInt(txtLarge1.getText());
                int number2 = Integer.parseInt(txtLarge2.getText());
                lblReturnLarge.setText(String.valueOf(Math.max(number1, number2)));
            }
        });

        btnSmall.addActionListener(new ActionListener() { // Find Smallest of 2 numbers
            @Override
            public void actionPerformed(ActionEvent e) {
                int number1 = Integer.parseInt(txtSmall1.getText());
                int number2 = Integer.parseInt(txtSmall2.getText());
                lblReturnSmall.setText(String.valueOf(Math.min(number1, number2)));
            }
        });
        btnPower.addActionListener(new ActionListener() { // Put the power of the second number to the first
            @Override
            public void actionPerformed(ActionEvent e) {
                int number1 = Integer.parseInt(txtPower1.getText());
                int number2 = Integer.parseInt(txtPower2.getText());
                lblReturnPower.setText(String.valueOf(Math.pow(number1, number2)));
            }
        });
        btnHypotenuse.addActionListener(new ActionListener() { // Find the Hypotenuse with 2 numbers
            @Override
            public void actionPerformed(ActionEvent e) {
                double number1 = Double.parseDouble(txtHypotenuse1.getText());
                double number2 = Double.parseDouble(txtHypotenuse2.getText());
                lblReturnHypotenuse.setText(String.valueOf(Math.hypot(number1, number2)));
            }
        });
        btnRoundUp.addActionListener(new ActionListener() { // Round up a number
            @Override
            public void actionPerformed(ActionEvent e) {
                double number = Double.parseDouble(txtRoundUp.getText());
                lblReturnRoundUp.setText(String.valueOf(Math.ceil(number)));
            }
        });
        btnRoundDown.addActionListener(new ActionListener() { // Round down a number
            @Override
            public void actionPerformed(ActionEvent e) {
                double number = Double.parseDouble(txtRoundDown.getText());
                lblReturnRoundDown.setText(String.valueOf(Math.floor(number)));
            }
        });
        btnSquareRoot.addActionListener(new ActionListener() { // Square Root a number
            @Override
            public void actionPerformed(ActionEvent e) {
                int number = Integer.parseInt(txtSquareRoot.getText());
                lblReturnSquareRoot.setText(String.valueOf(Math.sqrt(number)));
            }
        });
        btnRadians.addActionListener(new ActionListener() { // Convert an angle to radians.
            @Override
            public void actionPerformed(ActionEvent e) {
                int angle = Integer.parseInt(txtRadians.getText());
                lblReturnRadians.setText(String.valueOf(Math.toRadians(angle)));
            }
        });
    }

    public static void main(String[] args) { // Main function so setup and display the app
        JFrame frame = new UsingMathMethodsHall("Using Math Methods");
        frame.setVisible(true);
    }
}
