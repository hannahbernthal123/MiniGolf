import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

//Hannah Bernthal - 2024
public class Game implements MouseListener, MouseMotionListener {
    private GameViewer window;
    private int score;
    private Ball b;
    private Hole hole;

    private boolean gameIsStarted;
    private String currentState;
    private ArrayList<Obstacle> obstacles;

    public Game() {
        b = new Ball();
        hole = new Hole((int) ((Math.random() * 800) + 100), (int) ((Math.random() * 600) + 100));
        currentState = "instructions";
        gameIsStarted = false;
        window = new GameViewer(this);
        this.window.addMouseListener(this);
        this.window.addMouseMotionListener(this);
        obstacles = new ArrayList<Obstacle>();
        score = 0;
    }

    public Ball getBall() {
        return b;
    }
    public int getScore() {
        return score;
    }

    public void play() {
        //TODO when they click the start button, start
    }

    public void turn() {
        window.repaint();
        currentState = "play";
    }

    public String getCurrentState() {
        return currentState;
    }

    public static void printInstructions() {
        System.out.println("Instructions: Fire the ball and try to get it in the hole! The longer you hold down, the more power you generate");
    }

    public void mousePressed(MouseEvent e) {

        window.repaint();

        // For demo purposes only
        System.out.println("mousePressed event handler executed.");
    }

    public void mouseReleased(MouseEvent e) {
        // For demo purposes only
        System.out.println("mouseReleased event handler executed.");
    }

    public void mouseClicked(MouseEvent e) {
        //TODO create the button and say if its within the width and the height, run play
        if (e.getX() < BUTTON WIDTH)
    }

    public void mouseEntered(MouseEvent e) {
        // For demo purposes only
        System.out.println("mouseEntered event handler executed.");
    }

    public void mouseExited(MouseEvent e) {
        // For demo purposes only
        window.repaint();
        System.out.println("mouseExited event handler executed.");
    }

    public void mouseDragged(MouseEvent e) {
        // Have the ball follow the dragging mouse
        // Print to terminal for demo purposes only
        System.out.println("\t\t\texecuting mouseDragged event handler");

        // Ask the input event the current location (x and y position on the Frame) of the mouse
        int x = e.getX();
        int y = e.getY();

        // If the ball is clicked

    }

    public void mouseMoved(MouseEvent e) {
        // For demo purposes only
        System.out.println("\t\t\texecuting mouseMoved event handler");
    }




    public static void main(String[] args) {
        Game myGame = new Game();
        myGame.play();
    }
}
