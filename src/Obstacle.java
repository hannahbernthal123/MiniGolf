//Hannah Bernthal - 2024
public class Obstacle {
    private int height;
    private int width;
    private int x;
    private int y;

    public Obstacle(int width, int height) {
        this.width = width;
        this.height = height;
        x = (int) (Math.random() * 1000);
        y = (int) (Math.random() * 800);
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
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


}
