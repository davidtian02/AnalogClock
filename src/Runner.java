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
