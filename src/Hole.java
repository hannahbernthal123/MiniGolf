import java.awt.*;

//Hannah Bernthal - 2024
public class Hole {
    private int x;
    private int y;
    private final int HOLE_WIDTH = 40;
    private final int HOLE_HEIGHT = 35;

    public Hole(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Getters and setters
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int other) {
        x = other;
    }

    public void setY(int other) {
        y = other;
    }

    public int getHoleWidth() {
        return HOLE_WIDTH;
    }

    public int getHoleHeight() {
        return HOLE_HEIGHT;
    }

    public void draw(Graphics g) {
        g.setColor(Color.BLACK);
        // Add minus 10 for depth effect
        g.fillOval(x, y, HOLE_WIDTH, HOLE_HEIGHT - 10);
        g.setColor(Color.WHITE);

        // Variables for drawing flag
        int topOfFlagY = y - 50;
        int topOfFlagX = x + 18;
        int[] flagXPoints = new int[]{topOfFlagX, topOfFlagX, topOfFlagX + 45};
        int[] flagYPoints = new int[]{topOfFlagY, topOfFlagY - 30, (topOfFlagY + topOfFlagY - 30) / 2};
        int numFlagPoints = 3;

        g.fillRect(topOfFlagX, topOfFlagY, 3, 60);
        g.setColor(Color.RED);
        g.fillPolygon(flagXPoints, flagYPoints, numFlagPoints);
    }
}
