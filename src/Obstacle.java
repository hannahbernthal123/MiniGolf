import java.awt.*;

//Hannah Bernthal - 2024
public class Obstacle {
    private int OBSTACLE_WIDTH;
    private int OBSTACLE_HEIGHT;
    private int x;
    private int y;
    private Ball ball;

    public Obstacle(int width, int height, int x, int y, Ball ball) {
        OBSTACLE_WIDTH = width;
        OBSTACLE_HEIGHT = height;
        this.x = x;
        this.y = y;
        this.ball = ball;
    }

    // Getters and setters
    public int getHeight() {
        return OBSTACLE_HEIGHT;
    }

    public int getWidth() {
        return OBSTACLE_WIDTH;
    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void obstacleBounce() {
        // Format the following with initials --> bw = ball width, bx = ball x coordinate, etc.
        int bw = ball.getBallWidth();
        int bh = ball.getBallHeight();
        int bx = (int) ball.getX();
        int by = (int) ball.getY();
        int ow = this.getWidth();
        int oh = this.getHeight();
        int ox = this.getX();
        int oy = this.getY();


        // Hits the top of the obstacle
        if ((by > oy - bh) && (by + bh < oy + oh / 2) && (bx > ox) && (bx < ox + ow)) {
            // Flips Y, keeps X (bounces off at correct angle)
            ball.setYVelocity(ball.getYVelocity() * -1);
            //ball.setY(oy - bh);
        }
        // Hits the bottom of the obstacle
        else if (by < (oy + oh) && by > oy + oh / 2 && (bx > ox + 10 && bx < (ox + ow))) {
            ball.setYVelocity(ball.getYVelocity() * -1);
            //ball.setY(oy + oh);
        }
        // Hits the left side of the obstacle
        else if (bx > ox - bw && bx < ox + ow - bw && (by > oy + 10 && by < (oy + oh))) {
            // Flips X, keeps Y (bounces off at correct angle)
            ball.setXVelocity(ball.getXVelocity() * -1);
            //ball.setX(ox - bw);
        }
        // Hits the right side of the obstacle
        else if (bx < ox + ow + 1 && (bx > ox) && (by > oy && by < (oy + oh - 1))) {
            ball.setXVelocity(ball.getXVelocity() * -1);
            //ball.setX(ox + ow + 1);
        }
    }

    // Main draw method that calls smaller helper methods based on round
    public void draw(Graphics g, int round) {
        if (round == 1) {
            drawRound1(g);
        }
        else if (round == 2) {
            drawRound2(g);
        }
        else {
            drawRound3(g);
        }
    }

    // Three draw methods depending on what round it is --> different number of obstacles generate
    public void drawRound1(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(x, y, OBSTACLE_WIDTH, OBSTACLE_HEIGHT);
    }

    public void drawRound2(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(x, y, OBSTACLE_WIDTH, OBSTACLE_HEIGHT);
    }

    public void drawRound3(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(x, y, OBSTACLE_WIDTH, OBSTACLE_HEIGHT);
    }

}
