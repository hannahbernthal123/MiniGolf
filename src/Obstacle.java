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
        x = (int) (Math.random() * 1000);
        y = (int) (Math.random() * 800);
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

    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(200, 500, OBSTACLE_WIDTH, OBSTACLE_HEIGHT);
    }

}
