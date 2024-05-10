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
    private double futureVel;
    private boolean isDragged;
    private String currentState;
    private ArrayList<Obstacle> obstacles;
    private int round;
    // Static variables
    private static final int SLEEP_TIME = 30;
    private static final int START_BUTTON_LEFT = 250;
    private static final int START_BUTTON_RIGHT = 750;
    private static final int OBSTACLE_MAX_WIDTH = 50;
    private static final int OBSTACLE_MAX_HEIGHT = 100;
    private static final int ROUND1_OBSTACLE_COUNT = 2;
    private static final int ROUND2_OBSTACLE_COUNT = 7;
    private static final int ROUND3_OBSTACLE_COUNT = 12;
    private static final int OBSTACLE_BOUNDS = 800;

    public Game() {
        round = 1;
        ball = new Ball();
        hole = new Hole((int) ((Math.random() * 800) + 100), (int) ((Math.random() * 600) + 100));
        obstacles = new ArrayList<Obstacle>();
        futureVel = 0;
        currentState = "instructions";
        window = new GameViewer(this);
        this.window.addMouseListener(this);
        this.window.addMouseMotionListener(this);
        isDragged = false;
        score = -1;

    }

    // Getters and setters
    public Ball getBall() {
        return ball;
    }

    public ArrayList<Obstacle> getObstacles() {
        return obstacles;
    }

    public Hole getHole() {
        return hole;
    }

    public int getRound() {
        return round;
    }

    public boolean getIsDragged() {
        return isDragged;
    }

    public int getScore() {
        return score;
    }

    public String getCurrentState() {
        return currentState;
    }

    // Mouselistener methods
    public void mousePressed(MouseEvent e) {
        score++;
        isDragged = true;
    }
    public void mouseReleased(MouseEvent e) {
        if (score != 0) {
            ball.setColor(Color.white);
            double diffX = e.getX() - ball.getX();
            double diffY = e.getY() - ball.getY();
            double distance = Math.sqrt((diffX * diffX) + (diffY * diffY));
            futureVel += 10 * distance;
            if (futureVel >= 20) {
                futureVel = 20;
            }
            ball.setXVelocity(-1 * (diffX / futureVel));
            ball.setYVelocity(-1 * (diffY / futureVel));
        }
        isDragged = false;
    }

    public void mouseClicked(MouseEvent e) {
        if (currentState.equals("instructions")) {
            if (e.getX() > START_BUTTON_LEFT && e.getX() < START_BUTTON_RIGHT && e.getY() > 500 && e.getY() < 600) {
                currentState = "play";
                generateObstacles();
                window.repaint();
            }
        }
    }
    public void mouseDragged(MouseEvent e) {
        // Ask the input event the current location (x and y position on the Frame) of the mouse
        int x = e.getX();
        int y = e.getY();
        // When the mouse is dragged, turn red so that they know power is loading up
        ball.setColor(new Color(0xFF686D));
    }
    public void mouseEntered(MouseEvent e) {
    }
    public void mouseExited(MouseEvent e) {
    }
    public void mouseMoved(MouseEvent e) {
    }


    public void generateObstacles() {
        if (round == 1) {
            for (int i = 0; i < ROUND1_OBSTACLE_COUNT; i++) {
                newObstacle(i);
            }
        }
        else if (round == 2) {
            for (int i = 0; i < ROUND2_OBSTACLE_COUNT; i++) {
                newObstacle(i);
            }
        }
        else {
            for (int i = 0; i < ROUND3_OBSTACLE_COUNT; i++) {
                newObstacle(i);
            }
        }
    }

    // Generates a singular new obstacle and checks that the X and Y are not covering the hole
    public void newObstacle(int i) {
        obstacles.add(new Obstacle((int) (Math.random() * OBSTACLE_MAX_WIDTH) + 30, (int) (Math.random() * OBSTACLE_MAX_HEIGHT) + 30, ((int) (Math.random() * OBSTACLE_BOUNDS) + 10), ((int) (Math.random() * OBSTACLE_BOUNDS) + 10), ball));
        while (obstacles.get(i).getX() < (hole.getX() + hole.getHoleWidth()) && obstacles.get(i).getX() > hole.getX() || obstacles.get(i).getY() < (hole.getY() + hole.getHoleHeight()) && obstacles.get(i).getY() > hole.getY()) {
            obstacles.set(i, new Obstacle((int) (Math.random() * OBSTACLE_MAX_WIDTH) + 10, (int) (Math.random() * OBSTACLE_MAX_HEIGHT) + 10, ((int) (Math.random() * OBSTACLE_BOUNDS) + 10), ((int) (Math.random() * OBSTACLE_BOUNDS) + 10), ball));
        }
    }

    public void hit() {
        // Checks if the ball is within both the x and the y of the hole
        // If so, it's a hit
        if (ball.getX() > hole.getX() && ball.getX() < (hole.getX() + hole.getHoleWidth())) {
            if (ball.getY() > hole.getY() && ball.getY() < (hole.getY() + hole.getHoleHeight())) {
                round++;
                if (round > 3) {
                    currentState = "gameOver";
                }
                reset();
            }
        }
    }

    // Reset method runs before every new round
    public void reset() {
        obstacles.clear();
        ball.setX(100);
        ball.setY(100);
        ball.setXVelocity(0);
        ball.setYVelocity(0);
        hole.setX((int) ((Math.random() * 600) + 300));
        hole.setY((int) ((Math.random() * 600) + 100));
        generateObstacles();
        window.repaint();
    }

    // Every 30 milliseconds, all of these methods are run
    public void actionPerformed(ActionEvent e) {
        window.repaint();
        ball.friction();
        ball.wallBounce();
        hit();
        for (int i = 0; i < obstacles.size(); i++) {
            obstacles.get(i).obstacleBounce();
        }
        ball.move();
    }

    public static void main(String[] args) {
        Game myGame = new Game();
        Timer clock = new Timer(SLEEP_TIME, myGame);
        clock.start();
    }

}
