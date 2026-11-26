import java.awt.*;

public abstract class Car implements Movable {

    private int nrDoors;
    private double enginePower;
    private double currentSpeed;
    private Color color;
    private String modelName;
    private double x;
    private double y;
    private Direction direction;

    public Car(int nrDoors, Color color, double enginePower, String modelName) {
        this.nrDoors = nrDoors;
        this.color = color;
        this.enginePower = enginePower;
        this.modelName = modelName;
        this.currentSpeed = 0;
        x = 0;
        y = 0;
        direction = Direction.NORTH;
    }

    public int getNrDoors() {
        return nrDoors;
    }

    public double getEnginePower() {
        return enginePower;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public Color getColor() {
        return color;
    }

    public String getModelName() {
        return modelName;
    }

    public void setColor(Color clr) {
        color = clr;
    }

    public void startEngine() {
        currentSpeed = 0.1;
    }

    public void stopEngine() {
        currentSpeed = 0;
    }

    @Override
    public void move() {

        switch (direction) {

            case NORTH:
                y += currentSpeed;
                break;

            case EAST:
                x += currentSpeed;
                break;

            case SOUTH:
                y -= currentSpeed;
                break;

            case WEST:
                x -= currentSpeed;
                break;
        }
    }

    @Override
    public void turnLeft() {

        switch (direction) {

            case NORTH:
                direction = Direction.WEST;
                break;

            case WEST:
                direction = Direction.SOUTH;
                break;

            case SOUTH:
                direction = Direction.EAST;
                break;

            case EAST:
                direction = Direction.NORTH;
                break;
        }
    }

    @Override
    public void turnRight() {

        switch (direction) {

            case NORTH:
                direction = Direction.EAST;
                break;

            case EAST:
                direction = Direction.SOUTH;
                break;

            case SOUTH:
                direction = Direction.WEST;
                break;

            case WEST:
                direction = Direction.NORTH;
                break;
        }
    }

    protected abstract double speedFactor();

    private void incrementSpeed(double amount) {
        currentSpeed += speedFactor() * amount;

        if (currentSpeed > enginePower) {
            currentSpeed = enginePower;
        }
    }

    private void decrementSpeed(double amount) {
        currentSpeed -= speedFactor() * amount;

        if (currentSpeed < 0) {
            currentSpeed = 0;
        }
    }

    public void gas(double amount) {
        if (!(amount >= 0 && amount <= 1)) {
            throw new IllegalArgumentException(
                    "Gas amount must be between 0 and 1"
            );
        }

        incrementSpeed(amount);
    }

    public void brake(double amount) {
        if (!(amount >= 0 && amount <= 1)) {
            throw new IllegalArgumentException(
                    "Brake amount must be between 0 and 1"
            );
        }

        decrementSpeed(amount);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public Direction getDirection() {
        return direction;
    }
}