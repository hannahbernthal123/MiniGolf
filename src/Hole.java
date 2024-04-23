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

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getHOLE_WIDTH() {
        return HOLE_WIDTH;
    }

    public int getHOLE_HEIGHT() {
        return HOLE_HEIGHT;
    }
}
