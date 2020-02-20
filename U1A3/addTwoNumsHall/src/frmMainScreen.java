import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frmMainScreen extends JFrame{
    private JPanel mainPanel;
    private JTextField txtFirstNumber;
    private JTextField txtSecondNumber;
    private JButton btnAdd;
    private JPanel firstNumbers;
    private JPanel secondNumbers;
    private JPanel control;
    private JLabel lblFirstNum;
    private JLabel lblSecondNum;
    private JLabel lblAnswer;

    public frmMainScreen(String title) {
        //Setup form
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();


        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //Variables
                int num1;
                int num2;
                int answer;
                //Setting Variables
                num1 = Integer.parseInt(txtFirstNumber.getText());
                num2 = Integer.parseInt(txtSecondNumber.getText());
                //Creating answer
                answer = num1 + num2;
                //Displaying the answer
                lblAnswer.setText("Answer: " + String.valueOf(answer));

            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new frmMainScreen("Addition");
        frame.setVisible(true);
    }
}
