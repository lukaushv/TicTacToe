import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;
import java.util.Random;

public class TicTacToe implements ActionListener {

    JFrame frame = new JFrame();
    JPanel t_panel = new JPanel();
    JPanel bt_panel = new JPanel();

    JLabel textfield = new JLabel();

    JButton[] Jb_array = new JButton[9];

    int chance_flag = 0;
    Random random = new Random();
    boolean player_one_move;

    public TicTacToe(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.getContentPane().setBackground(new Color(50, 50, 50));
        frame.setTitle("Tic Tac Toe");
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        textfield.setBackground(new Color(120, 20, 124));
        textfield.setForeground(new Color(25, 255, 0));
        textfield.setFont(new Font("Ink Free", Font.BOLD, 75));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setText("Tic Tac Toe");
        textfield.setOpaque(true);
        t_panel.setLayout(new BorderLayout());
        t_panel.setBounds(0, 0, 800, 100);
        bt_panel.setLayout(new GridLayout(3, 3));
        bt_panel.setBackground(new Color(150, 150, 150));
        for (int i = 0; i < 9; i++) {
            Jb_array[i] = new JButton();
            bt_panel.add(Jb_array[i]);
            Jb_array[i].setFont(new Font("Ink Free", Font.BOLD, 120));
            Jb_array[i].setFocusable(false);
            Jb_array[i].addActionListener(this);
        }

        t_panel.add(textfield);
        frame.add(t_panel, BorderLayout.NORTH);
        frame.add(bt_panel);
        StartGame();
    }

    public void StartGame(){
        try {
            textfield.setText("Loading...");
            Thread.sleep(3000);
            textfield.setText("Whore");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        if(random.nextInt(10)%2 == 0){
            player_one_move = true;
            textfield.setText("X goes first");
        }else {
            player_one_move = false;
            textfield.setText("O goes first");
        }
    }

    public void GameOver(String s) {
        chance_flag = 0;
        Object[] options = {"Restart","Exit"};
        int n = JOptionPane.showOptionDialog(frame, "Game Over\n"+s,"Game Over",
                JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
        if(n == 0){
            frame.dispose();
            new TicTacToe();
        }else {
            frame.dispose();
        }
    }
            /*JButton[][] combos =  {
            {Jb_array[0],Jb_array[1],Jb_array[2]},
            {Jb_array[3],Jb_array[4],Jb_array[5]},
            {Jb_array[6],Jb_array[7],Jb_array[8]},
            {Jb_array[0],Jb_array[3],Jb_array[6]},
            {Jb_array[1],Jb_array[4],Jb_array[7]},
            {Jb_array[2],Jb_array[5],Jb_array[8]},
            {Jb_array[0],Jb_array[4],Jb_array[8]},
            {Jb_array[2],Jb_array[4],Jb_array[6]},
            };*/

    public void MatchCheck() {
        if ((Jb_array[0].getText() == "X") && (Jb_array[1].getText() == "X") && (Jb_array[2].getText() == "X")) {
            xWins(0, 1, 2);
        }
        else if ((Jb_array[0].getText() == "X") && (Jb_array[4].getText() == "X") && (Jb_array[8].getText() == "X")) {
            xWins(0, 4, 8);
        }
        else if ((Jb_array[0].getText() == "X") && (Jb_array[3].getText() == "X") && (Jb_array[6].getText() == "X")) {
            xWins(0, 3, 6);
        }
        else if ((Jb_array[1].getText() == "X") && (Jb_array[4].getText() == "X") && (Jb_array[7].getText() == "X")) {
            xWins(1, 4, 7);
        }
        else if ((Jb_array[2].getText() == "X") && (Jb_array[4].getText() == "X") && (Jb_array[6].getText() == "X")) {
            xWins(2, 4, 6);
        }
        else if ((Jb_array[2].getText() == "X") && (Jb_array[5].getText() == "X") && (Jb_array[8].getText() == "X")) {
            xWins(2, 5, 8);
        }
        else if ((Jb_array[3].getText() == "X") && (Jb_array[4].getText() == "X") && (Jb_array[5].getText() == "X")) {
            xWins(3, 4, 5);
        }
        else if ((Jb_array[6].getText() == "X") && (Jb_array[7].getText() == "X") && (Jb_array[8].getText() == "X")) {
            xWins(6, 7, 8);
        }

        else if ((Jb_array[0].getText() == "O") && (Jb_array[1].getText() == "O") && (Jb_array[2].getText() == "O")) {
            oWins(0, 1, 2);
        }
        else if ((Jb_array[0].getText() == "O") && (Jb_array[3].getText() == "O") && (Jb_array[6].getText() == "O")) {
            oWins(0, 3, 6);
        }
        else if ((Jb_array[0].getText() == "O") && (Jb_array[4].getText() == "O") && (Jb_array[8].getText() == "O")) {
            oWins(0, 4, 8);
        }
        else if ((Jb_array[1].getText() == "O") && (Jb_array[4].getText() == "O") && (Jb_array[7].getText() == "O")) {
            oWins(1, 4, 7);
        }
        else if ((Jb_array[2].getText() == "O") && (Jb_array[4].getText() == "O") && (Jb_array[6].getText() == "O")) {
            oWins(2, 4, 6);
        }
        else if ((Jb_array[2].getText() == "O") && (Jb_array[5].getText() == "O") && (Jb_array[8].getText() == "O")) {
            oWins(2, 5, 8);
        }
        else if ((Jb_array[3].getText() == "O") && (Jb_array[4].getText() == "O") && (Jb_array[5].getText() == "O")) {
            oWins(3, 4, 5);
        } else if ((Jb_array[6].getText() == "O") && (Jb_array[7].getText() == "O") && (Jb_array[8].getText() == "O")) {
            oWins(6, 7, 8);
        }
        else if(chance_flag==9) {
            textfield.setText("Match Tie");
            GameOver("Match Tie");
        }
    }

    public void xWins(int x1, int x2, int x3) {
        Jb_array[x1].setBackground(Color.GREEN);
        Jb_array[x2].setBackground(Color.GREEN);
        Jb_array[x3].setBackground(Color.GREEN);
        for (int i = 0; i < 9; i++) {
            Jb_array[i].setEnabled(false);
        }
        textfield.setText("X wins");
        GameOver("X Wins");
    }
    public void oWins(int x1, int x2, int x3) {
        Jb_array[x1].setBackground(Color.GREEN);
        Jb_array[x2].setBackground(Color.GREEN);
        Jb_array[x3].setBackground(Color.GREEN);
        for (int i = 0; i < 9; i++) {
            Jb_array[i].setEnabled(false);
        }
        textfield.setText("O Wins");
        GameOver("O Wins");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 9; i++) {
            if (e.getSource() == Jb_array[i]) {
                if (player_one_move) {
                    if (Jb_array[i].getText() == "") {
                        Jb_array[i].setForeground(new Color(255, 0, 0));
                        Jb_array[i].setText("X");
                        player_one_move = false;
                        textfield.setText("O turn");
                        chance_flag++;
                        MatchCheck();
                    }
                } else {
                    if (Jb_array[i].getText() == "") {
                        Jb_array[i].setForeground(new Color(0, 0, 255));
                        Jb_array[i].setText("O");
                        player_one_move = true;
                        textfield.setText("X turn");
                        chance_flag++;
                        MatchCheck();
                    }
                }
            }
        }
    }
}