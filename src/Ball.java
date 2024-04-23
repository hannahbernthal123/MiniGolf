//Hannah Bernthal - 2024
public class Ball {
    private final int BALL_WIDTH = 20;
    private final int BALL_HEIGHT = 20;
    private double velocity;

    public Ball() {
        double velocity = 0;
    }

    public double getVelocity() {
        return velocity;
    }

    public void setVelocity(double velocity) {
        this.velocity = velocity;
    }

    public int getBALL_WIDTH() {
        return BALL_WIDTH;
    }

    public int getBALL_HEIGHT() {
        return BALL_HEIGHT;
    }
}
