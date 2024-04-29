
//Hannah Bernthal - 2024

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

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
        createBufferStrategy(2);
    }

    public void myPaint(Graphics g) {
        if (game.getCurrentState().equals("instructions")) {
            g.setColor(Color.BLACK);
            g.setFont(new Font("Impact", Font.BOLD, 30));
            g.drawString("Instructions:", 200, 200);
            g.drawString("Fire the ball and try to get it", 250, 300);
            g.drawString("in the hole! The longer you", 250, 350);
            g.drawString("hold down, the more power you generate", 250, 400);
            g.setColor(new Color(0x068306));
            g.fillRoundRect(250, 500, 500, 100, 10, 10);
            g.setColor(Color.WHITE);
            g.setFont(new Font("Impact", Font.BOLD, 50));
            g.drawString("START", 430, 570);
        }
        if (game.getCurrentState().equals("play")) {
            g.setColor(new Color(0x068306));
            g.fillRect(0, 0, 1000, 800);
            game.getHole().draw(g);
            game.getBall().draw(g);
            game.getObstacle().draw(g);
        }
        if (game.getCurrentState().equals("gameOver")) {
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, 1000, 800);
            g.setColor(Color.BLACK);
            g.setFont(new Font("Impact", Font.BOLD, 30));
            g.drawString("GAME OVER", 200, 200);
        }

    }

    public void paint(Graphics g) {
        BufferStrategy bf = this.getBufferStrategy();
        if (bf == null)
            return;
        Graphics g2 = null;
        try {
            g2 = bf.getDrawGraphics();
            myPaint(g2);
        }
        finally {
            g2.dispose();
        }
        bf.show();
        Toolkit.getDefaultToolkit().sync();
    }
}
