public class CarTest {

    // Task 3: Basic functionality tests

    private static void testTurbo() {

        Saab95 car1 = new Saab95();
        Saab95 car2 = new Saab95();

        car1.setTurboOff();
        car2.setTurboOn();

        car1.gas(0.5);
        car2.gas(0.5);

        boolean result =
                car1.getCurrentSpeed() < car2.getCurrentSpeed();

        reportResult(result, "Turbo test");
    }

    private static void testStartEngine() {

        Volvo240 car = new Volvo240();

        car.startEngine();

        boolean result = car.getCurrentSpeed() == 0.1;

        reportResult(result, "Start engine test");
    }

    private static void testStopEngine() {

        Saab95 car = new Saab95();

        car.startEngine();
        car.stopEngine();

        boolean result = car.getCurrentSpeed() == 0;

        reportResult(result, "Stop engine test");
    }

    private static void testGas() {

        Volvo240 car = new Volvo240();

        car.gas(0.5);

        boolean result = car.getCurrentSpeed() > 0;

        reportResult(result, "Gas test");
    }

    private static void testBrake() {

        Saab95 car = new Saab95();

        car.gas(0.5);

        double speedBefore = car.getCurrentSpeed();

        car.brake(0.5);

        boolean result = car.getCurrentSpeed() < speedBefore;

        reportResult(result, "Brake test");
    }

    private static void testChangeColor() {

        Volvo240 car = new Volvo240();

        car.setColor(java.awt.Color.BLUE);

        boolean result =
                car.getColor().equals(java.awt.Color.BLUE);

        reportResult(result, "Change color test");
    }

    // Movement tests

    private static void testMove() {

        Volvo240 car = new Volvo240();

        car.gas(0.5);
        car.move();

        boolean result = car.getY() > 0;

        reportResult(result, "Move North test");
    }

    private static void testMoveEast() {

        Saab95 car = new Saab95();

        car.turnRight();
        car.gas(0.5);
        car.move();

        boolean result = car.getX() > 0;

        reportResult(result, "Move East test");
    }

    private static void testTurnRight() {

        Volvo240 car = new Volvo240();

        car.turnRight();

        boolean result = car.getDirection() == Direction.EAST;

        reportResult(result, "Turn right test");
    }

    private static void testTurnLeft() {

        Saab95 car = new Saab95();

        car.turnLeft();

        boolean result = car.getDirection() == Direction.WEST;

        reportResult(result, "Turn left test");
    }

    // Task 4: Sanity checks

    private static void testGasDoesNotDecreaseSpeed() {

        Volvo240 car = new Volvo240();

        car.gas(0.5);
        double speedBefore = car.getCurrentSpeed();

        car.gas(0.5);
        double speedAfter = car.getCurrentSpeed();

        boolean result = speedAfter >= speedBefore;

        reportResult(result, "Gas does not decrease speed");
    }

    private static void testBrakeDoesNotIncreaseSpeed() {

        Saab95 car = new Saab95();

        car.gas(0.5);
        double speedBefore = car.getCurrentSpeed();

        car.brake(0.5);
        double speedAfter = car.getCurrentSpeed();

        boolean result = speedAfter <= speedBefore;

        reportResult(result, "Brake does not increase speed");
    }

    private static void testSpeedNotNegative() {

        Saab95 car = new Saab95();

        car.brake(1);

        boolean result = car.getCurrentSpeed() >= 0;

        reportResult(result, "Speed is not negative");
    }

    private static void testSpeedLimit() {

        Volvo240 car = new Volvo240();

        for (int i = 0; i < 200; i++) {
            car.gas(1);
        }

        boolean result =
                car.getCurrentSpeed() <= car.getEnginePower();

        reportResult(result, "Speed does not exceed engine power");
    }

    private static void testInvalidGas() {

        Saab95 car = new Saab95();

        boolean result = false;

        try {
            car.gas(1.5);
        } catch (IllegalArgumentException e) {
            result = true;
        }

        reportResult(result, "Invalid gas amount rejected");
    }

    private static void testInvalidBrake() {

        Volvo240 car = new Volvo240();

        boolean result = false;

        try {
            car.brake(-0.5);
        } catch (IllegalArgumentException e) {
            result = true;
        }

        reportResult(result, "Invalid brake amount rejected");
    }

    // Report test results

    private static void reportResult(boolean result, String testName) {

        if (result) {
            System.out.println("Test " + testName + " passed!");
        } else {
            System.out.println("Test " + testName + " failed!");
        }
    }

    public static void main(String[] args) {

        // Task 3 tests
        testTurbo();
        testStartEngine();
        testStopEngine();
        testGas();
        testBrake();
        testChangeColor();

        // Movement tests
        testMove();
        testMoveEast();
        testTurnRight();
        testTurnLeft();

        // Task 4 tests
        testGasDoesNotDecreaseSpeed();
        testBrakeDoesNotIncreaseSpeed();
        testSpeedNotNegative();
        testSpeedLimit();
        testInvalidGas();
        testInvalidBrake();
    }
}