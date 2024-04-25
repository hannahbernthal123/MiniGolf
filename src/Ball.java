import java.awt.*;

//Hannah Bernthal - 2024
public class Ball {
    private final int BALL_WIDTH = 20;
    private final int BALL_HEIGHT = 20;
    private int x;
    private int y;
    private double dx;
    private double dy;

    public Ball() {
        dx = 0;
        dy = 0;
        x = 100;
        y = 100;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public double getXVelocity() {
        return dx;
    }
    public double getYVelocity() {
        return dy;
    }

    public void setXVelocity(int other) {
        dx = other;
    }
    public void setYVelocity(int other) {
        dy = other;
    }

    public int getBallWidth() {
        return BALL_WIDTH;
    }

    public int getBallHeight() {
        return BALL_HEIGHT;
    }

    public void move() {
        x += dx;
        y += dy;
    }

    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillOval(x, y, BALL_WIDTH, BALL_HEIGHT);
    }
}
