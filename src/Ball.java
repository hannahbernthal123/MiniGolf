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
    private Color color;

    public Ball() {
        dx = 0;
        dy = 0;
        x = 100;
        y = 100;
        color = Color.white;
    }

    public double getX() {
        return x;
    }

    // Getters and setters
    public void setX(int x) {
        this.x = x;
    }

    public void setColor(Color color) {
        this.color = color;
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


    // Makes the ball move based on the velocity
    public void move() {
        x += dx;
        y += dy;
    }

    public void friction() {
        // Calculate the magnitude of how far ball should move based on pythagorean theorem
        double magnitude = Math.sqrt((dx*dx) + (dy*dy));

        // Constantly decrease velocity until 0
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

    // Makes the ball bounce off of the walls
    public void wallBounce() {
        if (x > WINDOW_WIDTH - BALL_WIDTH) {
            // Flip the x velocity so that the y stays moving the same way and the x changes direction
            dx *= -1;
            // Reset position to the edge so that it doesn't bounce forever
            x = WINDOW_WIDTH - BALL_WIDTH;
        }
        else if (x < 0) {
            dx *= -1;
            x = 0;
        }
        else if (y > WINDOW_HEIGHT - BALL_HEIGHT) {
            // Flip the y velocity so that the x stays moving the same way and the y changes direction
            dy *= -1;
            // Reset position to the edge so that it doesn't bounce forever
            y = WINDOW_HEIGHT - BALL_HEIGHT;
        }
        else if (y < 20) {
            dy *= -1;
            y = 20;
        }
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval((int) x, (int) y, BALL_WIDTH, BALL_HEIGHT);
    }
}
