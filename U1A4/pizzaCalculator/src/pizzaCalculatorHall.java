import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class pizzaCalculatorHall extends JFrame {
    //Variables generated from Form
    private JLabel picPizzaImg;
    private JPanel pnlMain;
    private JTextField txtDiameter;
    private JButton btnCalculate;
    private JLabel lblSubtotal;
    private JLabel lblTaxes;
    private JLabel lblGT;
    private JLabel lblFun;
    private JLabel lblTitle;
    private JLabel lblInfo1;
    private JLabel lblInfo2;
    private JLabel lblCosts;
    private JLabel lblLabour;
    private JLabel lblRent;
    private JLabel lblCpD;
    private JLabel lblTax;

    //Constant Variables
    public final double LABOUR_COST = 0.75;
    public final double RENT_COST = 0.99;
    public final double COST = 0.50;
    public final double TAX = 0.13;

    //Main window
    public pizzaCalculatorHall(String title) {
        //Setup program window with pnlMain
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(pnlMain);
        this.pack();

        //Setup cost labels
        lblLabour.setText("Labour: $" + String.valueOf(LABOUR_COST));
        lblRent.setText("Rent: $" + String.valueOf(RENT_COST));
        lblCpD.setText("Cost / Diameter in cm: $" + String.valueOf(COST));
        lblTax.setText("Tax: " + String.valueOf(TAX) + "%");

        //When Calculate button is pushed
        btnCalculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //Get the diameter the user has entered
                int diameter = Integer.parseInt(txtDiameter.getText());

                //Find out what fun text should be sent back
                if (diameter > 40) { //If diameter is bigger than 40cm
                    lblFun.setText("Whoa, big pizza! You might need a truck to get this home!");
                }else if (diameter > 20) { //If less than 40cm but bigger than 20cm
                    lblFun.setText("This will be delicious");
                }else if (diameter < 15 && diameter > 1) { //If still not, then within 15-1 cm
                    lblFun.setText("We are going to make you a cute little pizza!");
                }else{ //if STILL not then reset text to Pizza time
                    lblFun.setText("Pizza Time");
                }

                //Calculate Subtotal
                double preCost = (diameter * COST) + LABOUR_COST + RENT_COST;
                lblSubtotal.setText("Subtotal: $" + String.valueOf( (double) Math.round(preCost * 100) / 100)); //Round and display Subtotal | (double) is included to make sure the number is a DOUBLE

                //Find tax and display tax
                double tax = preCost * TAX;
                lblTaxes.setText("Taxes: $" + String.valueOf( (double) Math.round(tax * 100) / 100)); // (double) is included to make sure the number is a DOUBLE

                //Find grand total and display it
                double total = preCost + tax;
                lblGT.setText("Grand Total: $" + String.valueOf( (double) Math.round(total * 100) / 100)); // (double) is included to make sure the number is a DOUBLE
            }
        });
    }

    static public void main(String[] args) {
        //Create frame as object and display it
        JFrame frame = new pizzaCalculatorHall("Pizza Calculator");
        frame.setVisible(true);
    }

}
