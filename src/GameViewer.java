
//Hannah Bernthal - 2024

import javax.swing.*;
import java.awt.*;

public class GameViewer extends JFrame {
    private Game game;
    private final int WINDOW_WIDTH = 1000;
    private final int WINDOW_HEIGHT = 800;

    public GameViewer(Game game) {
        this.game = game;

        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setTitle("Mini Golf");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void paint(Graphics g) {
        if (game.getCurrentState().equals("instructions")) {
            g.setColor(Color.BLACK);
            g.setFont(new Font("font1", Font.ROMAN_BASELINE, 30));
            g.drawString("Instructions:", 110, 200);
            g.drawString("Fire the ball and try to get it", 130, 300);
            g.drawString("in the hole! The longer you", 130, 350);
            g.drawString("hold down, the more power you generate", 130, 400);
        }
        if (game.getCurrentState().equals("play")) {
            g.drawOval(100, 100, game.getBall().getBALL_WIDTH(), game.getBall().getBALL_HEIGHT());
        }

    }
}
