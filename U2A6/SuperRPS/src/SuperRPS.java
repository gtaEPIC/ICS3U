import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

public class SuperRPS extends JFrame{
    // Form Variables
    private JLabel lblTitle;
    private JTextField txtComputers;
    private JPanel pnlMain;
    private JButton btnStartGame;
    private JButton btnScissors;
    private JButton btnRock;
    private JButton btnPaper;
    private JLabel lblInstructions1;
    private JLabel lblInstructions2;
    private JLabel lblInstructions3;
    private JLabel lblInstructions4;
    private JLabel lblInstructions5;
    private JLabel lblComputers;
    private JLabel lblGameStat;
    private JLabel lblPlayers;
    private JLabel lblGameInfo;
    private JLabel lblInstructions6;
    private JLabel lblLastSelection;

    //Game Variables
    private Boolean gamePlaying = false; // Is the game currently being played?
    private int players[]; // All the "Computers" and the user's selections
    private String gameInfo = ""; // This is created specifically in the class for ease of access across all methods.

    public int remainingPlayers() { // Counts how many players are still remaining (Not set to 0)
        int remaining = 0;
        for (int state : players) {
            if (state != 0) {
                remaining++;
            }
        }
        return remaining;
    }

    public void findWinner() { // Simulates a round without without using the users input. Used if the player is out.
        for (int i=1; i <= players.length - 1; i++) {
            if (players[i] != 0) {
                players[i] = (int) (Math.random() * 3) + 1; // Generate random number (1: Rock, 2: Paper, 3: Scissors)
            }
        }
        gameInfo = "Game Info: ";
        roundCheck(); // Check and remove who should be removed this round.
        lblGameInfo.setText(gameInfo); // Display some information (set from roundCheck())
        lblPlayers.setText("Players Remaining: " + remainingPlayers()); // Display how many players are remaining
        if (remainingPlayers() <= 1) { // Check for a winner
            int winner = 0;
            for (int i = 0; i < players.length; i++) { // Figure out which "Computer" won
                if (players[i] != 0) {
                    winner = i;
                    break;
                }
            }
            gameInfo = "Game Info: Game ended, computer " + winner + " won";
            String gameStatus = "Game Status: Finished, computer " + winner + " won";
            lblGameInfo.setText(gameInfo); // Display our information and reset for the next game
            lblGameStat.setText(gameStatus);
            lblPlayers.setText("Players Remaining: 0");
            gamePlaying = false; // Disable the game
            btnPaper.setEnabled(false);
            btnPaper.setText("Paper"); // Set this back to Paper so the user knows what button this is for
            btnStartGame.setEnabled(true);
        }else{ // If their is still no winner
            gameInfo += "press the Continue button to start the next round."; // Add instructions at the end of our text
            lblGameInfo.setText(gameInfo); // and submit it to the GUI
            lblPlayers.setText("Players Remaining: " + remainingPlayers());
        }

    }

    public void roundCheck() { // Checks for who should be removed and will remove them (sets their choice to 0)
        int rocks = 0; // The amount of "Rocks" that were selected
        int papers = 0; // The amount of "Papers" that were selected
        int scissors = 0; // The amount of "Scissors" that were selected
        for (int object : players) { // Counts all the selections
            if (object == 1) {
                rocks++;
            }else if (object == 2) {
                papers++;
            }else if (object == 3) {
                scissors++;
            }else if (object != 0) {
                System.out.println("ERROR: A player didn't select a proper choice."); // In case some bug happens
            }
        }
        boolean AllOne = rocks == papers && rocks == scissors; // Checks to see if everything was even (Causes no winner, but no remaining players)
        String output = "Last Selection: Rocks: " + rocks + " Papers: " + papers + " Scissors: " + scissors;
        System.out.println(output); // Spit out some information about what was picked.
        lblLastSelection.setText(output);
        if (scissors >= papers && scissors != 0 && papers != 0 && !AllOne) { // Checks to see if there is more or equal of Scissors
            gameInfo += "Paper is out (S: " + scissors + " P: " + papers +"), "; // against paper (Scissors beats paper)
            for (int i=0; i < players.length; i++) { // Removes the losers (Sets their choice to 0)
                if (players[i] == 2) {
                    players[i] = 0;
                }
            }
        }
        if (rocks >= scissors && rocks != 0 && scissors != 0 && !AllOne) { // Checks to see if there is more or equal of rocks
            gameInfo += "Scissors is out (R: " + rocks + " S: " + scissors +"), "; // against scissors (Rock beats Scissors)
            for (int i=0; i < players.length; i++) { // Removes the losers (Sets their choice to 0)
                if (players[i] == 3) {
                    players[i] = 0;
                }
            }
        }
        if (papers >= rocks && papers != 0 && rocks != 0 && !AllOne) { // Checks to see if there is more or equal of Papers
            gameInfo += "Rocks is out (P: " + papers + " R: " + rocks +"), "; // against rock (Paper beats Rock)
            for (int i=0; i < players.length; i++) { // Removes the losers (Sets their choice to 0)
                if (players[i] == 1) {
                    players[i] = 0;
                }
            }
        }
        if (AllOne) {
            gameInfo += "Three Way Tie (" + rocks + ") so no one is out that round."; // Notifies that there was a tie
        }
    }

    public void rps(int choice) { // Ran when the user selects Rock, Paper, or Scissors
        btnRock.setEnabled(false); // Sets the buttons to disabled so that way they can't be clicked
        btnPaper.setEnabled(false); // if the computer is still processing the last round
        btnScissors.setEnabled(false);
        players[0] = choice; // Sets the users choice so that roundCheck can do it's job.
        gameInfo = "Game Info: ";
        roundCheck();
        if (remainingPlayers() <= 1){ // Checks to see if there is a winner
            gamePlaying = false; // Disables the game since it's ending
            String gameStatus = "Game Status: ";
            if (remainingPlayers() < 1) { // In case some bug happens and no one actually won
                gameInfo += "game ended, somehow no one won.";
                gameStatus += "Finished, no one won.";
            }else{
                if (players[0] != 0) { // If the user is not set to Out (0) since that would be the only one above 0
                    gameInfo += "game ended, YOU WON!";
                    gameStatus += "Finished, You Won!";
                }else{ // If the user DIDN'T win
                    int winningComputer = 0;
                    for (int i = 0; i < players.length; i++) { // Find the computer that won
                        if (players[i] != 0) {
                            winningComputer = i;
                            break;
                        }
                    }
                    gameInfo += "game ended, computer " + winningComputer + " won";
                    gameStatus += "Finished, computer " + winningComputer + " won";
                }
            }
            lblGameInfo.setText(gameInfo); // Display the information and reset for the next game
            lblGameStat.setText(gameStatus);
            lblPlayers.setText("Players Remaining: 0");
            btnStartGame.setEnabled(true);
        } else if (players[0] == 0) { // If the user happened to get out
            gameInfo += " you're out now :C, press the Continue button to start the next round.";
            lblGameInfo.setText(gameInfo); // Display the round information and let them know they lost
            lblPlayers.setText("Players Remaining: " + remainingPlayers());
            btnPaper.setText("Continue"); // Change the center button to continue so the user can advance the rounds
            btnPaper.setEnabled(true);
        }else{ // If the user is still in the game after the round
            gameInfo += " more than 1 player remaining. \nAwaiting your selection.";
            lblGameInfo.setText(gameInfo); // Let them know that the game will be awaiting the users selection
            lblPlayers.setText("Players Remaining: " + remainingPlayers());
            for (int i=1; i <= players.length - 1; i++) { // Generate new numbers for the "Computers"
                if (players[i] != 0) {
                    players[i] = (int) (Math.random() * 3) + 1;
                }
            }
            players[0] = 4; // Set it 4 as in Not Selected yet
            btnRock.setEnabled(true); // Re-enable the buttons now that the game is ready
            btnPaper.setEnabled(true);
            btnScissors.setEnabled(true);
        }
    }

    public SuperRPS(String title) { // Button handling and GUI Setup
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(pnlMain);
        this.pack();
        btnStartGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { // Start game button was pushed
                int numComputers = Integer.parseInt(txtComputers.getText()); // Get the number of "Computers"
                if (!gamePlaying && numComputers > 0) { // Make sure there is no game already going on and that there is at last 1 "Computer"
                    gamePlaying = true; // Enable the game
                    btnStartGame.setEnabled(false);
                    players = new int[numComputers + 1]; // Setup the array
                    for (int i=1; i <= numComputers; i++) {
                        players[i] = (int) (Math.random() * 3) + 1; // Pick the random numbers
                    }
                    players[0] = 4;
                    lblGameStat.setText("Game Status: In Progress...");
                    lblPlayers.setText("Players Remaining: " + remainingPlayers());
                    lblGameInfo.setText("Game Info: Awaiting your selection."); // Let the user know they need to pick
                    btnRock.setEnabled(true); // and enable the buttons for the round
                    btnPaper.setEnabled(true);
                    btnScissors.setEnabled(true);
                }
            }
        });
        btnRock.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rps(1);
            } // Fires the function with the selection the user made
        });
        btnPaper.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (players[0] != 0) { // Checks to see if the user is out, if so then the button is being used as the continue button.
                    rps(2);
                }else{
                    findWinner();
                }
            }
        });
        btnScissors.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rps(3);
            } // Fires the function with the selection the user made
        });
    }

    public static void main(String[] args) {
        JFrame frame = new SuperRPS("Super Rock Paper Scissors"); // Creates the GUI
        frame.setVisible(true); // Displays the GUI
    }

}
