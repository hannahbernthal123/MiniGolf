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
    private boolean isPressed;
    private boolean isDragged;
    private static final int SLEEP_TIME = 30;
    private String currentState;
    private ArrayList<Obstacle> obstacles;
    private int round;

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
        score = -1;
        isPressed = false;
        isDragged = false;
    }

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

    public int getScore() {
        return score;
    }

    public String getCurrentState() {
        return currentState;
    }

    public boolean getIsDragged() {
        return isDragged;
    }
    public void mousePressed(MouseEvent e) {
        isPressed = true;
        score++;

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
            isPressed = false;
            isDragged = false;
        }
    }

    public void mouseClicked(MouseEvent e) {
        //TODO no magic numbers and add Y values
        if (currentState.equals("instructions")) {
            if (e.getX() > 250 && e.getX() < 750) {
                currentState = "play";
                generateObstacles();
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
        isDragged = true;
    }

    public void mouseMoved(MouseEvent e) {


    }

    public void generateObstacles() {
        //TODO no magic numbers
        if (round == 1) {
            for (int i = 0; i < 2; i++) {
                obstacles.add(new Obstacle((int) (Math.random() * 50) + 10, (int) (Math.random() * 100) + 10, ((int) (Math.random() * 800) + 10), ((int) (Math.random() * 800) + 10), ball));
            }
        }
        else if (round == 2) {
            for (int i = 0; i < 7; i++) {
                obstacles.add(new Obstacle((int) (Math.random() * 50) + 10, (int) (Math.random() * 100) + 10, ((int) (Math.random() * 800) + 10), ((int) (Math.random() * 800) + 10), ball));
            }
        }
        else {
            for (int i = 0; i < 12; i++) {
                obstacles.add(new Obstacle((int) (Math.random() * 50) + 10, (int) (Math.random() * 100) + 10, ((int) (Math.random() * 800) + 10), ((int) (Math.random() * 800) + 10), ball));
            }
        }
    }
    public void hit() {
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

//    public void hit() {
//        double ballCenter = ball.getY() + ball.getBallHeight()/2;
//        if (ballCenter > hole.getX() && ballCenter < (hole.getX() + hole.getHoleWidth())) {
//            if (ballCenter > hole.getY() && ballCenter < (hole.getY() + hole.getHoleHeight())) {
//                round++;
//                if (round > 3) {
//                    currentState = "gameOver";
//                }
//                reset();
//            }
//        }
//    }

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
