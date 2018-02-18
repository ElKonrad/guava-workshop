import com.google.common.primitives.Ints;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PrimitivesTest {

    final int[] array = new int[]{3, 2, 1, 100, -200};
    final int[] array2 = new int[]{10, 20, 30};

    @Test
    public void shouldFindGivenNumberInArray() {
        assertTrue(Ints.contains(array, 2));
    }

    @Test
    public void shouldFindIndexOfGivenNumber() {
        assertEquals(2, Ints.indexOf(array, 1));
    }

    @Test
    public void shouldConcatArrays() {
        assertEquals(array.length + array2.length,
                Ints.concat(array, array2).length);
    }

    @Test
    public void shouldFindMaxAndMinInArray() {
        assertEquals(-200, Ints.min(array));
        assertEquals(100, Ints.max(array));
    }
}
