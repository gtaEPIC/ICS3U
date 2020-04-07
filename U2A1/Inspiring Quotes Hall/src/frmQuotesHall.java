import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frmQuotesHall extends JFrame {
    private JButton btnQuote;
    private JLabel lblTitle;
    private JLabel lblQuoteInfo;
    private JLabel lblQuote;
    private JPanel pnlMain;

    public frmQuotesHall(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(pnlMain);
        this.pack();

        btnQuote.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int random = (int) (Math.random() * 8) + 1;
                switch (random) {
                    case 1:
                        lblQuote.setText("Do what is right, not what is easy nor what is popular.");
                        break;
                    case 2:
                        lblQuote.setText("Pursue what catches your heart, not what catches your eyes.");
                        break;
                    case 3:
                        lblQuote.setText("Start each day with a positive thought and a grateful heart.");
                        break;
                    case 4:
                        lblQuote.setText("Be brave to stand for what you believe in even if you stand alone.");
                        break;
                    case 5:
                        lblQuote.setText("Do not fear failure but rather fear not trying.");
                        break;
                    case 6:
                        lblQuote.setText("Never lose hope. Storms make people stronger and never last forever.");
                        break;
                    case 7:
                        lblQuote.setText("The way to get started is to quit talking and begin doing.");
                        break;
                    case 8:
                        lblQuote.setText("Don't be pushed around by the fears in your mind. Be led by the dreams in your heart.");
                        break;
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new frmQuotesHall("Quotes");
        frame.setVisible(true);
    }
}
