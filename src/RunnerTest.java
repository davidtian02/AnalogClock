import org.junit.Test;

import static org.junit.Assert.*;

public class RunnerTest {

    @Test
    public void calculateAngles_withNonZeroValue_shouldReturnAngles() {
        int time = 3609;
        float delta = 0.000001f;
        float expectedHourAngle = (float) (3609/(60f * 60 * 12) * 2 * Math.PI);
        float expectedMinuteAngle = (float) (9/(60f * 60) * 2 * Math.PI);
        float expectedSecondAngle = (float) (9/60f * 2 * Math.PI);

        float[] result = Runner.calculateAngles(time);

        assertEquals(expectedHourAngle, result[0], delta);
        assertEquals(expectedMinuteAngle, result[1], delta);
        assertEquals(expectedSecondAngle, result[2], delta);
    }

    @Test(expected = IllegalArgumentException.class)
    public void calculateAngles_withNegativeValue_shouldThrowException() {
        int time = -1;

        Runner.calculateAngles(time);

        // no - op
    }

    @Test
    public void calculateAngles_withOverFullCircle_shouldReturnBaseValue() {
        int time = 43210;
        float delta = 0.000001f;
        float expectedHourAngle = (float) (10/(60f * 60 * 12) * 2 * Math.PI);
        float expectedMinuteAngle = (float) (10/(60f * 60) * 2 * Math.PI);
        float expectedSecondAngle = (float) (10/60f * 2 * Math.PI);

        float[] result = Runner.calculateAngles(time);

        assertEquals(expectedHourAngle, result[0], delta);
        assertEquals(expectedMinuteAngle, result[1], delta);
        assertEquals(expectedSecondAngle, result[2], delta);
    }

    // ========================== testing seconds ==========================

    @Test
    public void calculateSecondHandAngle_withNonZeroValue_shouldReturnAngle() {
        int time = 1;
        float delta = 0.000001f;
        float expected = (float) (1/60f * 2 * Math.PI);

        float result = Runner.calculateSecondHandAngle(time);

        assertEquals(expected, result, delta);
    }

    @Test(expected = IllegalArgumentException.class)
    public void calculateSecondHandAngle_withNegativeValue_shouldThrowException() {
        int time = -1;

        Runner.calculateSecondHandAngle(time);

        // no - op
    }

    @Test
    public void calculateSecondHandAngle_withOverFullCircle_shouldReturnBaseValue() {
        int time1 = 60;
        int time2 = 62;
        float delta = 0.000001f;
        float expected1 = (float) (0/60f * 2 * Math.PI);
        float expected2 = (float) (2/60f * 2 * Math.PI);

        float result1 = Runner.calculateSecondHandAngle(time1);
        float result2 = Runner.calculateSecondHandAngle(time2);

        assertEquals(expected1, result1, delta);
        assertEquals(expected2, result2, delta);
    }

    // ========================== testing minutes ==========================

    @Test
    public void calculateMinuteHandAngle_withNonZeroValue_shouldReturnAngle() {
        int time1 = 1;
        int time2 = 60;
        float delta = 0.000001f;
        float expected1 = (float) ( 1/(60f * 60) * 2 * Math.PI);
        float expected2 = (float) (60/(60f * 60) * 2 * Math.PI);

        float result1 = Runner.calculateMinuteHandAngle(time1);
        float result2 = Runner.calculateMinuteHandAngle(time2);

        assertEquals(expected1, result1, delta);
        assertEquals(expected2, result2, delta);
    }

    @Test(expected = IllegalArgumentException.class)
    public void calculateMinuteHandAngle_withNegativeValue_shouldThrowException() {
        int time = -1;

        Runner.calculateMinuteHandAngle(time);

        // no - op
    }

    @Test
    public void calculateMinuteHandAngle_withOverFullCircle_shouldReturnBaseValue() {
        int time1 = 3600;
        int time2 = 3607;
        float delta = 0.000001f;
        float expected1 = (float) (0/(60f * 60) * 2 * Math.PI);
        float expected2 = (float) (7/(60f * 60) * 2 * Math.PI);

        float result1 = Runner.calculateMinuteHandAngle(time1);
        float result2 = Runner.calculateMinuteHandAngle(time2);

        assertEquals(expected1, result1, delta);
        assertEquals(expected2, result2, delta);
    }

    // ========================== testing hours ==========================

    @Test
    public void calculateHourHandAngle_withNonZeroValue_shouldReturnAngle() {
        int time1 = 1;
        int time2 = 3600; // one hour exact
        float delta = 0.000001f;
        float expected1 = (float) (   1/(60f * 60 * 12) * 2 * Math.PI);
        float expected2 = (float) (3600/(60f * 60 * 12) * 2 * Math.PI);

        float result1 = Runner.calculateHourHandAngle(time1);
        float result2 = Runner.calculateHourHandAngle(time2);

        assertEquals(expected1, result1, delta);
        assertEquals(expected2, result2, delta);
    }

    @Test(expected = IllegalArgumentException.class)
    public void calculateHourHandAngle_withNegativeValue_shouldThrowException() {
        int time = -1;

        Runner.calculateHourHandAngle(time);

        // no - op
    }

    @Test
    public void calculateHourHandAngle_withOverFullCircle_shouldReturnBaseValue() {
        int time1 = 43200; // one full circle of hours
        int time2 = 86410; // one day and 10 seconds
        float delta = 0.000001f;
        float expected1 = (float) ( 0/(60f * 60 * 12) * 2 * Math.PI);
        float expected2 = (float) (10/(60f * 60 * 12) * 2 * Math.PI);

        float result1 = Runner.calculateHourHandAngle(time1);
        float result2 = Runner.calculateHourHandAngle(time2);

        assertEquals(expected1, result1, delta);
        assertEquals(expected2, result2, delta);
    }
}