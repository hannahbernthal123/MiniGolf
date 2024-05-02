import java.awt.*;

//Hannah Bernthal - 2024
public class Obstacle {
    private int OBSTACLE_WIDTH;
    private int OBSTACLE_HEIGHT;
    private int x;
    private int y;

    public Obstacle(int width, int height) {
        OBSTACLE_WIDTH = width;
        OBSTACLE_HEIGHT = height;
        x = (int) ((Math.random() * 800) + OBSTACLE_WIDTH);
        y = ((int) (Math.random() * 600) + OBSTACLE_HEIGHT);
    }

    public int getHeight() {
        return OBSTACLE_HEIGHT;
    }

    public void setHeight(int height) {
        this.OBSTACLE_HEIGHT = height;
    }

    public int getWidth() {
        return OBSTACLE_WIDTH;
    }

    public void setWidth(int width) {
        this.OBSTACLE_WIDTH = width;
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
