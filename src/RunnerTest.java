import com.sun.javaws.exceptions.InvalidArgumentException;
import org.junit.Test;

import static org.junit.Assert.*;

public class RunnerTest {

    @Test
    public void calculateAngles() {

    }

    // ========================== testing seconds ==========================

    @Test
    public void calculateSecondHandAngle_withNonZeroValue_shouldReturnAngle() {
        int time = 1;
        float delta = 0.001f;
        float expected = (float) (1/60f * 2 * Math.PI);

        float result = Runner.calculateSecondHandAngle(time);

        assertEquals(expected, result, delta);
    }

    @Test(expected = InvalidArgumentException.class)
    public void calculateSecondHandAngle_withNegativeValue_shouldThrowException() {
        int time = -1;

        Runner.calculateSecondHandAngle(time);

        // no - op
    }

    @Test
    public void calculateSecondHandAngle_withOverFullCircle_shouldReturnBaseValue() {
        int time1 = 60;
        int time2 = 62;
        float delta = 0.001f;
        float expected1 = (float) (0/60f * 2 * Math.PI);
        float expected2 = (float) (2/60f * 2 * Math.PI);

        float result1 = Runner.calculateSecondHandAngle(time1);
        float result2 = Runner.calculateSecondHandAngle(time2);

        assertEquals(expected1, result1, delta);
        assertEquals(expected2, result2, delta);
    }

    // ========================== testing minutes ==========================

    @Test
    public void calculateMinuteHandAngle() {

    }

    @Test
    public void calculateHourHandAngle() {

    }
}