package base;

import com.google.common.base.Strings;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class StringsTest {


    @Test
    public void shouldReturnTrueOnNullString() {
        assertTrue(Strings.isNullOrEmpty(null));
    }

    @Test
    public void shouldConvertNullToEmpty() {
        assertEquals("", Strings.nullToEmpty(null));
    }

    @Test
    public void shouldConvertEmptyToNull() {
        assertEquals(null, Strings.emptyToNull(""));
    }

    @Test
    public void shouldPadEnd() {

        assertEquals("12345***",
                Strings.padEnd("12345", 8, '*'));
    }

    @Test
    public void shouldPadStart() {
        assertEquals("***12345", Strings.padStart("12345", 8, '*'));
    }

    @Test
    public void shouldRepeatGivenString() {
        assertEquals("*****", Strings.repeat("*", 5));
    }
}
