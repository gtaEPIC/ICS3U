import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frmCourseAverageHall extends JFrame {
    //Create variables from the form
    private JTextField txtCourse1;
    private JTextField txtCourse2;
    private JTextField txtCourse3;
    private JTextField txtCourse4;
    private JButton btnCalculate;
    private JLabel lblTitle;
    private JLabel lblInfo;
    private JLabel lblCourse1;
    private JLabel lblCourse2;
    private JLabel lblCourse3;
    private JLabel lblCourse4;
    private JLabel lblAverage;
    private JPanel pnlMain;

    public frmCourseAverageHall(String title){
        //Setup form window
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(pnlMain);
        this.pack();

        btnCalculate.addActionListener(new ActionListener() {
            //When button is pushed
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //Create variables
                int course1;
                int course2;
                int course3;
                int course4;
                int average;

                //Grab the text label values
                course1 = Integer.parseInt(txtCourse1.getText());
                course2 = Integer.parseInt(txtCourse2.getText());
                course3 = Integer.parseInt(txtCourse3.getText());
                course4 = Integer.parseInt(txtCourse4.getText());

                //Doing the math
                average = (course1 + course2 + course3 + course4) / 4;

                //Spit out the average
                lblAverage.setText("Average mark: " + String.valueOf(average) + "%");


            }
        });
    }

    public static void main(String[] args) {
        //Create the form as an object and display it
        JFrame frame = new frmCourseAverageHall("Course Average Calculator");
        frame.setVisible(true);


    }
}
