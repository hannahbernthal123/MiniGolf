import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

//Hannah Bernthal - 2024
public class Game implements MouseListener, MouseMotionListener, ActionListener {
    private GameViewer window;
    private int score;
    private Ball ball;
    private Hole hole;
    private Obstacle obstacle;
    private boolean gameOver;
    private boolean isPressed;
    private static final int SLEEP_TIME = 30;
    private String currentState;
    private ArrayList<Obstacle> obstacles;

    public Game() {
        ball = new Ball();
        hole = new Hole((int) ((Math.random() * 800) + 100), (int) ((Math.random() * 600) + 100));
        obstacle = new Obstacle(70, 100);
        currentState = "instructions";
        window = new GameViewer(this);
        this.window.addMouseListener(this);
        this.window.addMouseMotionListener(this);
        obstacles = new ArrayList<Obstacle>();
        score = 0;
        isPressed = false;
    }

    public Ball getBall() {
        return ball;
    }
    public Hole getHole() {
        return hole;
    }

    public Obstacle getObstacle() {
        return obstacle;
    }
    public int getScore() {
        return score;
    }

    public String getCurrentState() {
        return currentState;
    }

    public void mousePressed(MouseEvent e) {
        isPressed = true;
    }

    public void mouseReleased(MouseEvent e) {
        isPressed = false;
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
            ball.setXVelocity(10);
            ball.setYVelocity(10);
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

    public void hit() {
        if (ball.getX() > hole.getX() && ball.getX() < (hole.getX() + hole.getHoleWidth())) {
            if (ball.getY() > hole.getY() && ball.getY() < (hole.getY() + hole.getHoleHeight())) {
                gameOver = true;
                currentState = "gameOver";
            }
        }
    }
    public void actionPerformed(ActionEvent e) {
        window.repaint();
        ball.move();
        ball.bounce();
        ball.friction();
        hit();
    }

    public static void main(String[] args) {
        Game myGame = new Game();
        Timer clock = new Timer(SLEEP_TIME, myGame);
        clock.start();
    }

}
