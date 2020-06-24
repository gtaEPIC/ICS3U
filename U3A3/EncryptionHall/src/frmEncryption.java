import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frmEncryption extends JFrame {
    //GUI generated variables
    private JPanel pnlMain;
    private JTextField txtNormal;
    private JButton btnEncrypt;
    private JButton btnDecrypt;
    private JTextField txtEncrypt;

    public frmEncryption(String title) { // Creates the GUI
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(pnlMain);
        this.pack();
        btnEncrypt.addActionListener(new ActionListener() { // Encrypt button is pushed
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtNormal.getText().length() > 30) { // Checks to see if it is too long
                    txtEncrypt.setText("Message is too long. (30 Characters)");
                    return;
                }
                String message = "big" + txtNormal.getText() + "bog"; // Add extra text
                String reversed = "";
                for (int i = message.length() - 1 ; i >= 0 ; i--) { // Reverse it
                    reversed = reversed + message.charAt(i);
                }
                String shifted = "";
                int shift = 5;
                for (int i=0; i < reversed.length(); i++) { // Shift the characters
                    if (Character.isUpperCase(reversed.charAt(i)))
                    {
                        char ch = (char)(((int)reversed.charAt(i) + shift - 65) % 26 + 65);
                        shifted = shifted + ch;
                    }
                    else
                    {
                        char ch = (char)(((int)reversed.charAt(i) + shift - 97) % 26 + 97);
                        shifted = shifted + ch;
                    }
                }
                txtEncrypt.setText(shifted); // Display it
            }
        });
        btnDecrypt.addActionListener(new ActionListener() { // Decrypt button is pushed
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtEncrypt.getText().length() > 36) { // Check if the normal message is longer then 30
                    txtNormal.setText("Encrypted message is higher than the limit.");
                    return;
                }
                String message = txtEncrypt.getText(); // Grab the text
                String shifted = "";
                int shift = -5;
                for (int i=0; i < message.length(); i++) { // Shift the characters back
                    if (Character.isUpperCase(message.charAt(i)))
                    {
                        char ch = (char)(((int)message.charAt(i) + shift - 65) % 26 + 65);
                        shifted = shifted + ch;
                    }
                    else
                    {
                        char ch = (char)(((int)message.charAt(i) + shift - 97) % 26 + 97);
                        shifted = shifted + ch;
                    }
                }
                String reversed = "";
                for (int i = shifted.length() - 1 ; i >= 0 ; i--) { // Reverse them
                    reversed = reversed + shifted.charAt(i);
                }
                String finalMessage = reversed.substring(3, message.length() - 3); // And remove the extra bits of the message
                txtNormal.setText(finalMessage); // Display it
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new frmEncryption("Encryption"); // Creates the GUI
        frame.setVisible(true); // Displays the GUI
    }

}
