package HW7;

import javax.swing.*;
import java.awt.*;

public class Settings extends JFrame {

    private Game game;
    private final int WP_X = game.WP_X + 50;
    private final int WP_Y = game.WP_Y + 50;
    private final int WP_W = game.WP_W - 100;
    private final int WP_H = game.WP_H - 100;
    private final int minFieldSize = 3;
    private final int maxFieldSize = 10;

    public Settings(Game game) throws HeadlessException {
        this.game = game;
        setBounds(WP_X, WP_Y, WP_W, WP_H);
        setTitle("Настройки");

        setLayout(new GridLayout(8, 1));

        add(new Label("Выберите параметры игры"));

        JRadioButton hi = new JRadioButton("Человек против компьютера", true);
        JRadioButton hh = new JRadioButton("Человек против человека");
        add(hi);
        add(hh);
        ButtonGroup rg = new ButtonGroup();
        rg.add(hi);
        rg.add(hh);

        add(new JLabel("Размер поля"));
        JSlider fieldSize = new JSlider(minFieldSize, maxFieldSize, minFieldSize);
        fieldSize.setMajorTickSpacing(1);
        fieldSize.setPaintTicks(true);
        fieldSize.setPaintLabels(true);
        add(fieldSize);

        add(new JLabel("Размер линии"));
        JSlider winnerLine = new JSlider(minFieldSize, minFieldSize, minFieldSize);
        winnerLine.setMajorTickSpacing(1);
        winnerLine.setPaintTicks(true);
        winnerLine.setPaintLabels(true);
        add(winnerLine);

        JButton buttonStartGame = new JButton("СТАРТ!");
        add(buttonStartGame);

        fieldSize.addChangeListener(e -> {
            winnerLine.setMaximum(fieldSize.getValue());
        });
        buttonStartGame.addActionListener(e -> {


            game.greedGame.startNewGame(hi.isSelected() ? 0 : 1, fieldSize.getValue(), winnerLine.getValue());
            setVisible(false);
        });

    }
}
