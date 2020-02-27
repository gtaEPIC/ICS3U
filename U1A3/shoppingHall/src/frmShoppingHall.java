import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frmShoppingHall extends JFrame {
    //Variables from form
    private JTextField txtKeyboard;
    private JTextField txtMouse;
    private JTextField txtMonitor;
    private JTextField txtCable;
    private JTextField txtRam;
    private JButton btnCalculate;
    private JPanel pnlMain;
    private JLabel lblTitle;
    private JLabel lblInfo1;
    private JLabel lblInfo2;
    private JLabel lblKeyboard;
    private JLabel lblMouse;
    private JLabel lblMonitor;
    private JLabel lblCable;
    private JLabel lblRam;
    private JLabel lblTax;
    private JLabel lblSubtotal;
    private JLabel lblGrandtotal;

    //Prices | this is in the main class so that way it can be accessed from anywhere inside the class
    private final double TAX = 0.13;
    private final double KEYBOARD_PRICE = 14.99;
    public final double MOUSE_PRICE = 14.99;
    public final double MONITOR_PRICE = 65.99;
    public final double CABLE_PRICE = 11.99;
    public final double RAM_PRICE = 59.99;

    public frmShoppingHall(String title) {
        //Setup form window
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(pnlMain);
        this.pack();

        //Changing the labels in the form so that they display the prices (This way you can easily change it here in the code)
        lblKeyboard.setText("Computer Keyboard ($" + String.valueOf(KEYBOARD_PRICE) + "):");
        lblMouse.setText("Computer Mouse ($" + String.valueOf(MOUSE_PRICE) + "):");
        lblMonitor.setText("Computer Monitor ($" + String.valueOf(MONITOR_PRICE) + "):");
        lblCable.setText("HDMI Cable ($" + String.valueOf(CABLE_PRICE) + "):");
        lblRam.setText("4 GB x2 RAM Cards ($" + String.valueOf(RAM_PRICE) + "):");
        lblTax.setText("Taxes (" + Math.round(TAX * 100) + "%): $0.00"); // Rounding is so that way it doesn't show 13.0%

        //When the button is pushed
        btnCalculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //Creating variables to save the quantity's the user inputted
                int qtyKeyboard = Integer.parseInt(txtKeyboard.getText());
                int qtyMouse = Integer.parseInt(txtMouse.getText());
                int qtyMonitor = Integer.parseInt(txtMonitor.getText());
                int qtyCable = Integer.parseInt(txtCable.getText());
                int qtyRam = Integer.parseInt(txtRam.getText());

                //Math time
                double subtotal = Math.round(((qtyKeyboard * KEYBOARD_PRICE) + (qtyMouse * MOUSE_PRICE) + (qtyMonitor * MONITOR_PRICE) + (qtyCable * CABLE_PRICE) + (qtyRam * RAM_PRICE)) * 100.0) / 100.0 ; //Add up all the prices | Rounding just in case
                double taxPrice = Math.round((subtotal * TAX) * 100.0) / 100.0; // Find out the tax
                double grandTotal = Math.round((subtotal + taxPrice) * 100.0) / 100.0; //Add the two together | Rounding just in case

                //Output
                lblTax.setText("Taxes (" + Math.round(TAX * 100) + "%): $" + taxPrice); // Rounding so it won't display 13.0%
                lblSubtotal.setText("Subtotal: $" + subtotal);
                lblGrandtotal.setText("Grand total: $" + grandTotal);

            }
        });
    }

    public static void main(String[] args) {
        //Create the from as and object and display it
        JFrame frame = new frmShoppingHall("Shopping");
        frame.setVisible(true);
    }
}
