import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class frmMoreNumbersHall extends JFrame {
    // GUI Generated Variables
    private JTextField txtFact;
    private JButton btnFact;
    private JPanel pnlMain;
    private JLabel lblTitle;
    private JLabel lblInfo1;
    private JLabel lblInfo2;
    private JTextField txtPrime;
    private JLabel lblInfo3;
    private JTextField txtFibo;
    private JButton btnPrime;
    private JButton btnFibo;
    private JLabel lblFactReturn;
    private JLabel lblPrimeReturn;
    private JLabel lblFiboReturn;

    public String factorial(int fact) {
        for (int i = fact - 1; i > 1; i--) {
            fact = fact * i; // Calculate
        }
        return String.valueOf(fact);
    }

    public String findPrime(int prime) {
        boolean isPrime = true; // Set isPrime to true in case prime % i never equals 0
        for (int i = 2; i < prime / 2; i++) {
            if (prime % i == 0) { // Calculate
                isPrime = false;
                break;
            }
        }
        if (isPrime) { // Return answer
            return "It's a prime number!";
        }else{
            return "It's not a prime number!";
        }
    }

    public String findFibo(int fibo) {
        int t1 = 0; // Xn-1
        int t2 = 1; // Xn-2
        for (int i = 1; i < fibo; i++) {
            int sum = t1 + t2; // Calculate
            t1 = t2;
            t2 = sum;
        }
        return String.valueOf(t1); // Return answer
    }

    public frmMoreNumbersHall(String title) { // Button handling and GUI Setup
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(pnlMain);
        this.pack();
        btnFact.addActionListener(new ActionListener() { // Factorial Button is pushed
            @Override
            public void actionPerformed(ActionEvent e) {
                lblFactReturn.setText(factorial(Integer.parseInt(txtFact.getText())));
            }
        });
        btnPrime.addActionListener(new ActionListener() { // Prime button is pushed
            @Override
            public void actionPerformed(ActionEvent e) {
                lblPrimeReturn.setText(findPrime(Integer.parseInt(txtPrime.getText())));
            }
        });
        btnFibo.addActionListener(new ActionListener() { // The Fibonacci button is pushed
            @Override
            public void actionPerformed(ActionEvent e) {
                lblFiboReturn.setText(findFibo(Integer.parseInt(txtFibo.getText())));
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new frmMoreNumbersHall("More Numbers!!"); // Creates the GUI
        frame.setVisible(true); // Displays the GUI
    }
}
