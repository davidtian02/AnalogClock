public class Runner {
    public static void main(String[] args) {
        System.out.println("Hello");
    }

    /**
     * This function calculates the angles for each hand of an analog clock, for a time input.
     *
     * @param time in seconds, since epoch
     * @return an array of the angles, in radians, for each hand of an analog clock. [H, M, s] for hours, minutes, seconds
     */
    static float[] calculateAngles(int time) {
        return new float[]{0f, 0f, 0f};
    }

    /**
     * for 0 it should be 0. edge cases are negative numbers. also edge case that it can't be greater than current system time.
     * for 1 it should be 1/60 * (2*pi), as 60 seconds makes the full circle.
     * for 360, it should ideally say 0, since they are the same, so modulo as well.
     *
     * @param time
     * @return
     */
    static float calculateSecondHandAngle(int time) {
        return 0;
    }

    static float calculateMinuteHandAngle(int time) {
        return 0;
    }

    static float calculateHourHandAngle(int time) {
        return 0;
    }
}
