
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
        // If statements control what the board looks at what time
        if (game.getCurrentState().equals("instructions")) {
            g.setColor(Color.BLACK);
            g.setFont(new Font("Impact", Font.BOLD, 30));
            g.drawString("Instructions:", 200, 200);
            g.drawString("Fire the ball and try to get it", 250, 300);
            g.drawString("in the hole! The further you pull,", 250, 350);
            g.drawString("the more power you generate. Pull", 250, 400);
            g.drawString("in the opposite direction you want to go!", 250, 450);
            g.setColor(new Color(0x068306));
            g.fillRoundRect(250, 500, 500, 100, 10, 10);
            g.setColor(Color.WHITE);
            g.setFont(new Font("Impact", Font.BOLD, 50));
            g.drawString("START", 430, 570);
        }
        if (game.getCurrentState().equals("play")) {
            g.setColor(new Color(0x068306));
            g.fillRect(0, 0, 1000, 800);
            setUpPlay(game.getRound(), g);
            if (game.getIsDragged()) {
                g.setColor(Color.BLUE);
                g.drawLine((int) game.getBall().getX() + game.getBall().getBallWidth()/2, (int) game.getBall().getY() + game.getBall().getBallHeight()/2, (int) getMousePosition().getX(), (int) getMousePosition().getY());
            }
        }
        if (game.getCurrentState().equals("gameOver")) {
            // Draws game over, your score, and the white golf ball
            g.setColor(new Color(0x00BCFF));
            g.fillRect(0, 0, 1000, 800);
            g.setColor(Color.WHITE);
            g.setFont(new Font("Impact", Font.BOLD, 100));
            g.drawString("GAME OVER", 250, 200);
            g.setFont(new Font("Impact", Font.BOLD, 30));
            g.drawString("You took " + game.getScore() + "strokes!", 370, 300);
            g.drawImage(new ImageIcon("Resources/Golfball.png").getImage(), 350, 525, 300, 300, this);
        }

    }

    // Draws the hole, the ball, and the number of obstacles needed
    public void setUpPlay(int round, Graphics g) {
        game.getHole().draw(g);
        game.getBall().draw(g);
        for (int i = 0; i < game.getObstacles().size(); i++) {
            game.getObstacles().get(i).draw(g, round);
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
