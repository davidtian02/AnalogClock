import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        System.out.println("Please enter a time (in int format):");
        Scanner sc = new Scanner(System.in);
        int time = sc.nextInt();
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

        return (float) (((time % 60) / 60f) * 2 * Math.PI);
    }

    /**
     * same as seconds, but for minutes, so need to go at a much slower rate... 60x slower, in fact.
     * @param time in seconds, since epoch
     * @return the radian of the minutes hand
     */
    static float calculateMinuteHandAngle(int time) {
        validateInput(time);

        return (float) (((time % (60*60)) / (60*60f)) * 2 * Math.PI); // TODO apply some optimization on math here
    }

    /**
     * same as seconds, but for minutes, so need to go at a much slower rate... 60x slower, in fact.
     * @param time in seconds, since epoch
     * @return the radian of the minutes hand
     */
    static float calculateHourHandAngle(int time) {
        validateInput(time);

        return (float) (((time % (12*60*60)) / (12*60*60f)) * 2 * Math.PI);
    }

    /**
     * this method just checks if the input is valid
     *
     * @param time in seconds, since epoch
     */
    private static void validateInput(int time) {
        if (time < 0) {
            throw new IllegalArgumentException("Time can't be negative");
        }
    }
}
