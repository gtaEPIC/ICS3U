import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

public class SuperRPS extends JFrame{
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

    private Boolean gamePlaying = false;
    private int players[];
    private String gameInfo = "";

    public int remainingPlayers() {
        int remaining = 0;
        for (int state : players) {
            if (state != 0) {
                remaining++;
            }
        }
        return remaining;
    }

    public void findWinner() {
        for (int i=1; i <= players.length - 1; i++) {
            if (players[i] != 0) {
                players[i] = (int) (Math.random() * 3) + 1;
            }
        }
        gameInfo = "Game Info: ";
        roundCheck();
        lblGameInfo.setText(gameInfo);
        lblPlayers.setText("Players Remaining: " + remainingPlayers());
        if (remainingPlayers() <= 1) {
            int winner = 0;
            for (int i = 0; i < players.length; i++) {
                if (players[i] != 0) {
                    winner = i;
                    break;
                }
            }
            gameInfo = "Game Info: Game ended, computer " + winner + " won";
            String gameStatus = "Game Status: Finished, computer " + winner + " won";
            lblGameInfo.setText(gameInfo);
            lblGameStat.setText(gameStatus);
            lblPlayers.setText("Players Remaining: 0");
            gamePlaying = false;
            btnPaper.setEnabled(false);
            btnPaper.setText("Paper");
            btnStartGame.setEnabled(true);
        }else{
            gameInfo += "press the Continue button to start the next round.";
            lblGameInfo.setText(gameInfo);
            lblPlayers.setText("Players Remaining: " + remainingPlayers());
        }

    }

    public void roundCheck() {
        int rocks = 0;
        int papers = 0;
        int scissors = 0;
        for (int object : players) {
            if (object == 1) {
                rocks++;
            }else if (object == 2) {
                papers++;
            }else if (object == 3) {
                scissors++;
            }else if (object != 0) {
                System.out.println("ERROR: A player didn't select a proper choice.");
            }
        }
        boolean AllOne = rocks == papers && rocks == scissors;
        String output = "Last Selection: Rocks: " + rocks + " Papers: " + papers + " Scissors: " + scissors;
        System.out.println(output);
        lblLastSelection.setText(output);
        if (scissors >= papers && scissors != 0 && papers != 0 && !AllOne) {
            gameInfo += "Paper is out (S: " + scissors + " P: " + papers +"), ";
            for (int i=0; i < players.length; i++) {
                if (players[i] == 2) {
                    players[i] = 0;
                }
            }
        }
        if (rocks >= scissors && rocks != 0 && scissors != 0 && !AllOne) {
            gameInfo += "Scissors is out (R: " + rocks + " S: " + scissors +"), ";
            for (int i=0; i < players.length; i++) {
                if (players[i] == 3) {
                    players[i] = 0;
                }
            }
        }
        if (papers >= rocks && papers != 0 && rocks != 0 && !AllOne) {
            gameInfo += "Rocks is out (P: " + papers + " R: " + rocks +"), ";
            for (int i=0; i < players.length; i++) {
                if (players[i] == 1) {
                    players[i] = 0;
                }
            }
        }
        if (AllOne) {
            gameInfo += "Three Way Tie (" + rocks + ") so no one is out that round.";
        }
    }

    public void rps(int choice) {
        btnRock.setEnabled(false);
        btnPaper.setEnabled(false);
        btnScissors.setEnabled(false);
        players[0] = choice;
        gameInfo = "Game Info: ";
        roundCheck();
        if (remainingPlayers() <= 1){
            gamePlaying = false;
            String gameStatus = "Game Status: ";
            if (remainingPlayers() < 1) {
                gameInfo += "game ended, somehow no one won.";
                gameStatus += "Finished, no one won.";
            }else{
                if (players[0] != 0) {
                    gameInfo += "game ended, YOU WON!";
                    gameStatus += "Finished, You Won!";
                }else{
                    int winningComputer = 0;
                    for (int i = 0; i < players.length; i++) {
                        if (players[i] != 0) {
                            winningComputer = i;
                            break;
                        }
                    }
                    gameInfo += "game ended, computer " + winningComputer + " won";
                    gameStatus += "Finished, computer " + winningComputer + " won";
                }
            }
            lblGameInfo.setText(gameInfo);
            lblGameStat.setText(gameStatus);
            lblPlayers.setText("Players Remaining: 0");
            btnStartGame.setEnabled(true);
        } else if (players[0] == 0) {
            gameInfo += " you're out now :C, press the Continue button to start the next round.";
            lblGameInfo.setText(gameInfo);
            lblPlayers.setText("Players Remaining: " + remainingPlayers());
            btnPaper.setText("Continue");
            btnPaper.setEnabled(true);

        }else{
            gameInfo += " more than 1 player remaining. \nAwaiting your selection.";
            lblGameInfo.setText(gameInfo);
            lblPlayers.setText("Players Remaining: " + remainingPlayers());
            for (int i=1; i <= players.length - 1; i++) {
                if (players[i] != 0) {
                    players[i] = (int) (Math.random() * 3) + 1;
                }
            }
            players[0] = 4;
            btnRock.setEnabled(true);
            btnPaper.setEnabled(true);
            btnScissors.setEnabled(true);
        }
    }

    public SuperRPS(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(pnlMain);
        this.pack();
        btnStartGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int numComputers = Integer.parseInt(txtComputers.getText());
                if (!gamePlaying && numComputers > 0) {
                    gamePlaying = true;
                    btnStartGame.setEnabled(false);
                    players = new int[numComputers + 1];
                    for (int i=1; i <= numComputers; i++) {
                        players[i] = (int) (Math.random() * 3) + 1;
                    }
                    players[0] = 4;
                    lblGameStat.setText("Game Status: In Progress...");
                    lblPlayers.setText("Players Remaining: " + remainingPlayers());
                    lblGameInfo.setText("Game Info: Awaiting your selection.");
                    btnRock.setEnabled(true);
                    btnPaper.setEnabled(true);
                    btnScissors.setEnabled(true);
                }
            }
        });
        btnRock.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rps(1);
            }
        });
        btnPaper.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (players[0] != 0) {
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
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new SuperRPS("Super Rock Paper Scissors");
        frame.setVisible(true);
    }

}
