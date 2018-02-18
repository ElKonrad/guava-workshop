package base;

import com.google.common.base.Joiner;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class JoinerTest {

    public static List<String> universities = Arrays.asList("Pollub", "UMCS", "KUL", "UP");
    public static List<String> universitiesWithNullValue = Arrays.asList("Pollub", "UMCS", null, "KUL", "UP");

    @Test
    public void shouldJoinWithCommas() {
        assertEquals("Pollub,UMCS,KUL,UP",
                Joiner.on(",").join(universities));
    }

    @Test(expected = NullPointerException.class)
    public void shouldThrowNullPointerException() {
        assertEquals("Pollub,UMCS,null,KUL,UP", Joiner.on(",").join(universitiesWithNullValue));
    }

    @Test
    public void shouldJoinWithCommasAndOmitNulls() {
        assertEquals("Pollub,UMCS,KUL,UP",
                Joiner.on(",").skipNulls().join(universitiesWithNullValue));
    }

    @Test
    public void shouldJoinWithCommasAndReplaceNullsWithWordNothing() {
        assertEquals("Pollub,UMCS,NONE,KUL,UP",
                Joiner.on(",").useForNull("NONE").join(universitiesWithNullValue));
    }
}
