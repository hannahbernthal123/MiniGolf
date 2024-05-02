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
    private Obstacle obstacle;
    private double futureVel;
    private boolean isPressed;
    private static final int SLEEP_TIME = 30;
    private String currentState;
    private ArrayList<Obstacle> obstacles;
    private int round;

    public Game() {
        round = 1;
        ball = new Ball();
        hole = new Hole((int) ((Math.random() * 800) + 100), (int) ((Math.random() * 600) + 100));
        obstacle = new Obstacle(70, 100);
        futureVel = 0;
        currentState = "instructions";
        window = new GameViewer(this);
        this.window.addMouseListener(this);
        this.window.addMouseMotionListener(this);
        obstacles = new ArrayList<Obstacle>();
        score = -1;
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
    public int getRound() {
        return round;
    }
    public int getScore() {
        return score;
    }

    public String getCurrentState() {
        return currentState;
    }

    public void mousePressed(MouseEvent e) {
        futureVel = 0;
        isPressed = true;
        score++;
        System.out.println(score);
    }

    public void mouseReleased(MouseEvent e) {
        ball.setColor(Color.white);
        double diffX = e.getX() - ball.getX();
        double diffY = e.getY() - ball.getY();
        double distance = Math.sqrt((diffX*diffX) + (diffY*diffY));
        ball.setXVelocity(-1*(diffX/distance*futureVel));
        ball.setYVelocity(-1*(diffY/distance*futureVel));
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
    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }

    public void mouseDragged(MouseEvent e) {
        // Ask the input event the current location (x and y position on the Frame) of the mouse
        int x = e.getX();
        int y = e.getY();
        ball.setColor(new Color(0xFF686D));
    }

    public void mouseMoved(MouseEvent e) {


    }

    public void hit() {
        if (ball.getX() > hole.getX() && ball.getX() < (hole.getX() + hole.getHoleWidth())) {
            if (ball.getY() > hole.getY() && ball.getY() < (hole.getY() + hole.getHoleHeight())) {
                round++;
                if (round > 3) {
                    currentState = "gameOver";
                }
                ball.setX(100);
                ball.setY(100);
                ball.setXVelocity(0);
                ball.setYVelocity(0);
                hole.setX((int) ((Math.random() * 600) + 300));
                hole.setY((int) ((Math.random() * 600) + 100));
                window.repaint();
            }
        }
    }

    public void obstacleBounce() {
        // Format the following with initials --> bw = ball width, bx = ball x coordinate, etc.
        int bw = ball.getBallWidth();
        int bh = ball.getBallHeight();
        int bx = (int) ball.getX();
        int by = (int) ball.getY();
        int ow = obstacle.getWidth();
        int oh = obstacle.getHeight();
        int ox = obstacle.getX();
        int oy = obstacle.getY();

        // Hits the top of the obstacle
        if ((by + bh) > oy && (bx > ox && bx < (ox + ow))) {
            // Flips Y, keeps X (bounces off at correct angle)
            ball.setYVelocity(ball.getYVelocity() * -1);
            ball.setY(oy - bh - 5);
        }
        // Hits the bottom of the obstacle
        else if (by < (oy + oh) && (bx > ox && bx < (ox + ow))) {
            ball.setYVelocity(ball.getYVelocity() * -1);
            ball.setY(oy + oh + 5);
        }
        // Hits the left side of the obstacle
//        else if ((bx + bw) > ox && (by > oy && by < (oy + oh))) {
//            // Flips X, keeps Y (bounces off at correct angle)
//            ball.setXVelocity(ball.getXVelocity() * -1);
//            ball.setX(ox - bw - 5);
//        }
//        // Hits the right side of the obstacle
         else if (bx < (ox + ow) && (bx > ox) && (by > oy && by < (oy + oh))) {
            ball.setXVelocity(ball.getXVelocity() * -1);
            ball.setX(ox + ow + bw + 5);
        }
    }
    public void actionPerformed(ActionEvent e) {
        window.repaint();
        if (isPressed) {
            futureVel += .5;
            if (futureVel >= 20) {
                futureVel = 20;
            }
        }
        ball.friction();
        ball.wallBounce();
        obstacleBounce();
        ball.move();
//        hit();
    }

    public static void main(String[] args) {
        Game myGame = new Game();
        Timer clock = new Timer(SLEEP_TIME, myGame);
        clock.start();
    }

}
