import java.awt.*;

//Hannah Bernthal - 2024
public class Ball {
    private final int BALL_WIDTH = 20;
    private final int BALL_HEIGHT = 20;
    private final int WINDOW_WIDTH = 1000;
    private final int WINDOW_HEIGHT = 800;
    private double x;
    private double y;
    private double dx;
    private double dy;

    public Ball() {
        dx = 0;
        dy = 0;
        x = 100;
        y = 100;
    }

    public double getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public double getY() {
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

    public void addXVelocity(int other) {
        dx += other;
    }
    public void addYVelocity(int other) {
        dy += other;
    }



    public void setXVelocity(double other) {
        dx = other;
    }
    public void setYVelocity(double other) {
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

    public void friction() {
        double magnitude = Math.sqrt((dx*dx) + (dy*dy));
        if (dx > 0) {
            dx = dx - (dx / magnitude) * .2;
            if (dx < 0) {
                dx = 0;
            }
        }
        else if (dx < 0) {
            dx = dx + (-dx / magnitude) * .2;
            if (dx > 0) {
                dx = 0;
            }
        }
        if (dy > 0) {
            dy = dy - (dy / magnitude) * .2;
            if (dy < 0) {
                dy = 0;
            }
        }
        else if (dy < 0) {
            dy = dy + (-dy / magnitude) * .2;
            if (dy > 0) {
                dy = 0;
            }
        }
    }

    public void bounce() {
        if (x > WINDOW_WIDTH - BALL_WIDTH) {
            dx *= -1;
            x = WINDOW_WIDTH - BALL_WIDTH;
        }
        else if (x < 0) {
            dx *= -1;
            x = 0;
        }
        else if (y > WINDOW_HEIGHT - BALL_HEIGHT) {
            dy *= -1;
            y = WINDOW_HEIGHT - BALL_HEIGHT;
        }
        else if (y < 20) {
            dy *= -1;
            y = 20;
        }

    }
    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillOval((int) x, (int) y, BALL_WIDTH, BALL_HEIGHT);
    }
}
