package HW7;

import javax.swing.*;
import java.awt.*;

public class Game extends JFrame {
    static final int WP_X = 300;
    static final int WP_Y = 300;
    static final int WP_W = 450;
    static final int WP_H = 450;

    GreedGame greedGame;


    public Game() {
        setTitle("XO");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(WP_X, WP_Y, WP_W, WP_H);
        Font gameFont = new Font("Arial", Font.BOLD, 25);

        Settings settings = new Settings(this);
        greedGame = new GreedGame(this);

        JPanel buttonsPanel = new JPanel(new GridLayout(1, 2));

        JButton buttonNewGame = new JButton("Новая игра");
        buttonNewGame.setFont(gameFont);
        buttonsPanel.add(buttonNewGame);

        JButton buttonExitGame = new JButton("Выйти");
        buttonExitGame.setFont(gameFont);
        buttonsPanel.add(buttonExitGame);

        add(greedGame, BorderLayout.CENTER);
        add(buttonsPanel, BorderLayout.SOUTH);
        setVisible(true);

        buttonNewGame.addActionListener(e -> {
            settings.setVisible(true);
        });
    }
}
