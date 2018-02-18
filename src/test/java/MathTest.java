import com.google.common.math.IntMath;
import org.junit.Test;

import java.math.RoundingMode;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MathTest {

    @Test
    public void shouldDivideWithRoundingMode() {

        int roundedUp = IntMath.divide(6, 4, RoundingMode.HALF_UP);
        int roundedDown = IntMath.divide(6, 4, RoundingMode.HALF_DOWN);

        assertEquals(2, roundedUp);
        assertEquals(1, roundedDown);
    }

    @Test
    public void shouldCalculateFactorial() {
        int factorial = IntMath.factorial(3);

        assertEquals(1 * 2 * 3, factorial);
    }

    @Test
    public void shouldCalculateGreatestCommonDivisor() {
        int gcd = IntMath.gcd(15, 10);

        assertEquals(5, gcd);
    }

    @Test
    public void shouldCalculateLogarithms() {

        // when
        int log2Result = IntMath.log2(17, RoundingMode.HALF_UP);
        int log10Result = IntMath.log10(100, RoundingMode.UNNECESSARY);

        // then
        assertEquals(4, log2Result);
        assertEquals(2, log10Result);
    }

    @Test
    public void otherTest() {
        assertTrue(IntMath.isPrime(7));
        assertEquals(8, IntMath.pow(2,3));
        assertEquals(3, IntMath.sqrt(10, RoundingMode.FLOOR));
    }
}
