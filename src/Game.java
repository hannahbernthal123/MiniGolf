import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

//Hannah Bernthal - 2024
public class Game implements MouseListener, MouseMotionListener, ActionListener {
    private GameViewer window;
    private int score;
    private Ball ball;
    private Hole hole;
    private static final int SLEEP_TIME = 30;
    private String currentState;
    private ArrayList<Obstacle> obstacles;

    public Game() {
        ball = new Ball();
        hole = new Hole((int) ((Math.random() * 800) + 100), (int) ((Math.random() * 600) + 100));
        currentState = "instructions";
        window = new GameViewer(this);
        this.window.addMouseListener(this);
        this.window.addMouseMotionListener(this);
        obstacles = new ArrayList<Obstacle>();
        score = 0;
    }

    public Ball getBall() {
        return ball;
    }
    public int getScore() {
        return score;
    }

    public String getCurrentState() {
        return currentState;
    }

    public void mousePressed(MouseEvent e) {

    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mouseClicked(MouseEvent e) {
        //TODO no magic numbers and add Y values
        if (currentState.equals("instructions")) {
            if (e.getX() > 250 && e.getX() < 750) {
                currentState = "play";
                window.repaint();
            }
        }
        else if (currentState.equals("play")) {
            ball.setXVelocity(1);
            ball.setYVelocity(1);
        }
    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }

    public void mouseDragged(MouseEvent e) {
        // Ask the input event the current location (x and y position on the Frame) of the mouse
        int x = e.getX();
        int y = e.getY();
    }

    public void mouseMoved(MouseEvent e) {

    }
    public void actionPerformed(ActionEvent e) {
        ball.move();
        window.repaint();
    }

    public static void main(String[] args) {
        Game myGame = new Game();
        Timer clock = new Timer(SLEEP_TIME, myGame);
        clock.start();
    }

}
