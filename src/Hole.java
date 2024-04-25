import java.awt.*;

public class Hole {
    private boolean hasBeenHit;
    private int x;
    private int y;
    private final int HOLE_WIDTH = 50;
    private final int HOLE_HEIGHT = 50;

    public Hole(int x, int y) {
        this.x = x;
        this.y = y;
        hasBeenHit = false;
    }

    public boolean isHasBeenHit() {
        return hasBeenHit;
    }

    public void setHasBeenHit(boolean hasBeenHit) {
        this.hasBeenHit = hasBeenHit;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getHoleWidth() {
        return HOLE_WIDTH;
    }

    public int getHoleHeight() {
        return HOLE_HEIGHT;
    }

    public void draw(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillOval(x, y, HOLE_WIDTH, HOLE_HEIGHT);
    }
}
