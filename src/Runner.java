import java.util.Scanner;

/**
 * This class will prompt the user for a time in Epoch, and return the angles of each hand of an analog clock (in radians)
 */
public class Runner {
    private static double FULL_CIRCLE_IN_RADIANS = 2 * Math.PI;
    private static int SECOND_HAND_MOVEMENT_RATE = 60;
    private static int MINUTE_HAND_MOVEMENT_RATE = 60 * SECOND_HAND_MOVEMENT_RATE;
    private static int HOUR_HAND_MOVEMENT_RATE = 12 * MINUTE_HAND_MOVEMENT_RATE;

    /**
     * Main method to run the application
     */
    public static void main(String[] args) {
        System.out.println("Please enter a time (in int format):");
        Scanner sc = new Scanner(System.in);
        int time;
        try {
            time = sc.nextInt();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Please enter a valid number.");
            return;
        }

        if (time < 0) {
            System.out.println("Please enter a non-negative number for time");
        } else {
            float[] angles = calculateAngles(time);
            System.out.println("H: " + angles[0] + ", M: " + angles[1] + ", S: " + angles[2]);
        }
    }

    /**
     * This function calculates the angles for each hand of an analog clock, for a time input.
     * Edge cases are negative numbers, and that it shouldn't be greater than current system time.
     *
     * @param time in seconds, since epoch
     * @return an array of the angles, in radians, for each hand of an analog clock. [H, M, s] for hours, minutes, seconds
     */
    static float[] calculateAngles(int time) {
        validateInput(time);

        return new float[]{calculateHourHandAngle(time), calculateMinuteHandAngle(time), calculateSecondHandAngle(time)};
    }

    /**
     * for 0 it should be 0.
     * for 1 it should be 1/60 * (2*pi), as 60 seconds makes the full circle.
     * for 360, it should ideally say 0, since they are the same, so modulo as well.
     *
     * @param time in seconds, since epoch
     * @return the radian of the seconds hand
     */
    static float calculateSecondHandAngle(int time) {
        validateInput(time);

        return calculateAngleForRate(time, SECOND_HAND_MOVEMENT_RATE);
    }

    /**
     * same as seconds, but for minutes, so need to go at a much slower rate... 60x slower, in fact.
     * @param time in seconds, since epoch
     * @return the radian of the minutes hand
     */
    static float calculateMinuteHandAngle(int time) {
        validateInput(time);

        return calculateAngleForRate(time, MINUTE_HAND_MOVEMENT_RATE);
    }

    /**
     * same as seconds, but for minutes, so need to go at a much slower rate... 60x slower, in fact.
     * @param time in seconds, since epoch
     * @return the radian of the minutes hand
     */
    static float calculateHourHandAngle(int time) {
        validateInput(time);

        return calculateAngleForRate(time, HOUR_HAND_MOVEMENT_RATE);
    }

    /**
     * This method just checks if the input is valid
     *
     * @param time in seconds, since epoch
     */
    private static void validateInput(int time) {
        if (time < 0) {
            throw new IllegalArgumentException("Time can't be negative");
        }
    }

    /**
     * This method is a general method used to calculate any hand that moves in relations to an analog clock.
     *
     * @param time in epoch
     * @param movementRate the rate at which the hand moves
     * @return the angle that the hand has moved
     */
    private static float calculateAngleForRate(int time, int movementRate) {
        return (float) (((time % movementRate) / ((float) movementRate)) * FULL_CIRCLE_IN_RADIANS);
    }
}
