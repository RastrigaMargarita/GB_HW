package HW7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class GreedGame extends JPanel {
    private Game game;

    //private int mode;
    private int fieldSize;
    private boolean isInit;
    private int colWidth;
    private int colHeight;
    private int humanturn;
    JDialog messageToUser;
    private Label label;

    public GreedGame(Game game) {
        this.game = game;
        setBackground(new Color(110, 200, 250));

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                onMouseClick(e);
            }
        });

        label = new Label();
        label.setFont(new Font("Arial", Font.PLAIN, 40));

        setVisible(true);
    }

    private void onMouseClick(MouseEvent e) {
        int clX = e.getX() / colWidth;
        int clY = e.getY() / colHeight;

        if (Logic.status == 0) {
            if (humanturn == 0) {
                Logic.humanTurn(clX, clY);
                Logic.go();
                repaint();
            } else {
                if (humanturn % 2 != 0) {
                    Logic.humanTurn(clX, clY);
                    Logic.go1();

                } else {
                    Logic.human2Turn(clX, clY);
                    Logic.go2();
                }
                humanturn += 1;
                repaint();
            }

            if ((Logic.status == 1) && (humanturn == 0)) {
                label.setText("Вы выиграли!");

                messageToUser.add(label);
                messageToUser.setVisible(true);
            } else if ((Logic.status == 1) && (humanturn > 0)) {
                label.setText("Первый игрок выиграл!");

                messageToUser.add(label);
                messageToUser.setVisible(true);
            } else if ((Logic.status == 2) && (humanturn == 0)) {
                label.setText("Вы проиграли!");

                messageToUser.add(label);
                messageToUser.setVisible(true);
            } else if ((Logic.status == 2) && (humanturn > 0)) {
                label.setText("Второй игрок выиграл!");

                messageToUser.add(label);
                messageToUser.setVisible(true);
            } else if (Logic.status == 3) {

                label.setText("Ничья!");
                messageToUser.add(label);
                messageToUser.setVisible(true);
            }
        }
    }

    private void drawX(Graphics g, int clX, int clY) {
        ((Graphics2D) g).setStroke(new BasicStroke(15));
        g.setColor(Color.PINK);

        g.drawLine(colWidth * clX + 20, colHeight * clY + 20, colWidth * (clX + 1) - 20, colHeight * (clY + 1) - 20);
        g.drawLine(colWidth * clX + 20, colHeight * (clY + 1) - 20, colWidth * (clX + 1) - 20, colHeight * clY + 20);
    }

    private void drawO(Graphics g, int clX, int clY) {
        ((Graphics2D) g).setStroke(new BasicStroke(15));
        g.setColor(Color.BLUE);
        g.drawOval(colWidth * clX + 20, colHeight * clY + 20, colWidth - 40, colHeight - 40);
    }

    public void startNewGame(int mode, int fieldSize, int winline) {
        //this.mode = mode;
        this.fieldSize = fieldSize;

        this.isInit = true;
        Logic.DOTS_TO_WIN = winline;
        Logic.SIZE = fieldSize;
        Logic.initMap();
        repaint();

        humanturn = mode;

        messageToUser = new JDialog(game, "Конец игры", true);
        messageToUser.setBounds(game.WP_X + 100, game.WP_Y + 100, 500, 100);
        messageToUser.setFont(new Font("Arial", Font.PLAIN, 50));
        messageToUser.setVisible(false);
    }

    ;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (!isInit) {
            //return;
        } else {
            int panelWidth = getWidth();
            int panelHeight = getHeight();
            colWidth = panelWidth / fieldSize;
            colHeight = panelHeight / fieldSize;
            g.setColor(Color.DARK_GRAY);
            for (int i = 1; i < fieldSize; i++) {
                g.drawLine(0, i * colHeight, panelWidth, i * colHeight);
            }
            for (int i = 1; i < fieldSize; i++) {
                g.drawLine(i * colWidth, 0, i * colWidth, panelHeight);
            }

            for (int i = 0; i < fieldSize; i++) {
                for (int j = 0; j < fieldSize; j++) {
                    if (Logic.map[i][j] == Logic.DOT_X) {
                        drawX(g, j, i);
                    } else if (Logic.map[i][j] == Logic.DOT_O) {
                        drawO(g, j, i);
                    }
                }
            }
        }
    }
}
