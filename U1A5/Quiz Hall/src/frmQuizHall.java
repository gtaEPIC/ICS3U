import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frmQuizHall extends JFrame{
    //Auto Generated Form Variables
    private JTextField txtAnswer;
    private JButton btnSubmit;
    private JLabel lblTitle;
    private JLabel lblHelp1;
    private JLabel lblHelp2;
    private JLabel lblHelp3;
    private JLabel lblHelp4;
    private JLabel lblTitleQuestions;
    private JLabel lblTitleAnswers;
    private JLabel lblQuestion;
    private JLabel lblAnswer1;
    private JLabel lblAnswer2;
    private JLabel lblAnswer3;
    private JLabel lblHelp5;
    private JLabel lblInfo;
    private JLabel lblStats;
    private JLabel lblCorrectInfo;
    private JLabel lblWrongInfo;
    private JLabel lblMarkInfo;
    private JLabel lblCorrect;
    private JLabel lblWrong;
    private JLabel lblMark;
    private JPanel pnlMain;

    //Quiz Variables
    //Constant Variables
    // ARRAY LAYOUT     { QUESTION,   Answer 1, Answer 2, Answer 3, The correct answer }
    final String[] Q1 = {"Q1. What is 2 + 2?", "8", "4", "6", "2"};
    final String[] Q2 = {"Q2: A character walks 20 m [E] and then 30 m [W]. What is the displacement?", "10m [W]", "30m [E]", "10m", "1"};
    final String[] Q3 = {"Q3: What year was Minecraft Launched?", "2012", "2009", "2003", "2"};
    final String[] Q4 = {"Q4: What car number won a race in the Nascar Cup Series race on March 8 2020?", "9", "47", "22", "3"};
    final String[] Q5 = {"Q5: Money can't buy you __________", "Anything", "Happiness", "Cars", "2"};

    //Non Constant
    int currentQuestion = 1;
    int correct = 0;
    int wrong = 0;

    //Function to set up any questions / text that need to be displayed all at once
    public void nextQuestion(String[] array) {

        lblQuestion.setText(array[0]);
        lblAnswer1.setText("A) " + array[1]);
        lblAnswer2.setText("B) " + array[2]);
        lblAnswer3.setText("C) " + array[3]);
        txtAnswer.setText("");

    }


    //Function used to find the answer to a specific question that was given.
    public String findAnswer(int Question) {
        switch (Question) {
            case 1:
                return Q1[Integer.parseInt(Q1[4])];
            case 2:
                return Q2[Integer.parseInt(Q2[4])];
            case 3:
                return Q3[Integer.parseInt(Q3[4])];
            case 4:
                return Q4[Integer.parseInt(Q4[4])];
            case 5:
                return Q5[Integer.parseInt(Q5[4])];
            default:
                return "Error: The question you were looking for does not exist";
        }
    }

    //Function that will find the letter corresponding to the correct answer
    public String findLetter(int Question) {
        switch (Question) {
            case 1:
                if (Q1[4] == "1") {
                    return "a";
                }else if (Q1[4] == "2") {
                    return "b";
                }else{
                    return "c";
                }
            case 2:
                if (Q2[4] == "1") {
                    return "a";
                }else if (Q2[4] == "2") {
                    return "b";
                }else{
                    return "c";
                }
            case 3:
                if (Q3[4] == "1") {
                    return "a";
                }else if (Q3[4] == "2") {
                    return "b";
                }else{
                    return "c";
                }
            case 4:
                if (Q4[4] == "1") {
                    return "a";
                }else if (Q4[4] == "2") {
                    return "b";
                }else{
                    return "c";
                }
            case 5:
                if (Q5[4] == "1") {
                    return "a";
                }else if (Q5[4] == "2") {
                    return "b";
                }else{
                    return "c";
                }
            default:
                return "";
        }
    }

    public frmQuizHall(String title) {
        //Form setup
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(pnlMain);
        this.pack();

        nextQuestion(Q1);

        //When the submit button is pushed
        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //Find the answer user submitted and grab the correct answer
                String input = txtAnswer.getText();
                String answer = findLetter(currentQuestion);

                //Check to see if the answer is correct. If so add 1 to correct, if not 1 to wrong
                if (input.toLowerCase().equals(answer.toLowerCase())) {
                    correct += 1;
                }else{
                    wrong += 1;
                }

                //Display what that answer was.
                lblInfo.setText("The correct answer was: " + findLetter(currentQuestion) + ")  " + findAnswer(currentQuestion));

                //Update Stats:
                lblCorrect.setText(String.valueOf(correct));
                lblWrong.setText(String.valueOf(wrong));

                double percent = (double) correct / currentQuestion * 100; //Calculate current mark

                lblMark.setText(String.valueOf((int) percent) + "%"); //Show that mark | (int) required to make sure its not a decimal

                currentQuestion += 1; //Change to the next question

                //Display what the next question is
                switch (currentQuestion) {
                    case 2:
                        nextQuestion(Q2);
                        break;
                    case 3:
                        nextQuestion(Q3);
                        break;
                    case 4:
                        nextQuestion(Q4);
                        break;
                    case 5:
                        nextQuestion(Q5);
                        break;
                    default:
                        //If there are no more questions, say no more and disable the submit button.
                        String[] temp = {"Finished! You have reached the end of the questions", "", "", ""};
                        nextQuestion(temp);
                        btnSubmit.setEnabled(false);
                        break;
                }
            }
        });
    }

    public static void main(String[] args) {
        //Setup window and display it
        JFrame frame = new frmQuizHall("Mini Quiz");
        frame.setVisible(true);
    }
}
