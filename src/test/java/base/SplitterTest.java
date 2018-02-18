package base;

import com.google.common.base.CharMatcher;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class SplitterTest {

    @Test
    public void shouldSplitOnSemicolons() {

        Iterable<String> iterable = Splitter.on(";")
                                            .split("Pollub;UMCS;KUL;UP");
        List<String> splittedList = Lists.newArrayList(iterable);

        assertEquals(4, splittedList.size());
        assertEquals("KUL", splittedList.get(2));
    }

    @Test
    public void shouldSplitUsingCharMatcher() {

        Iterable<String> iterable = Splitter.on(CharMatcher.inRange('3', '5'))
                                            .split("Pollub1UMCS3KUL5UP");
        List<String> splittedList = Lists.newArrayList(iterable);

        assertEquals(3, splittedList.size());
        assertEquals("Pollub1UMCS", splittedList.get(0));
        assertEquals("KUL", splittedList.get(1));
        assertEquals("UP", splittedList.get(2));
    }

    @Test
    public void shouldSplitAndOmitEmptyElementsAndWhitespaces() throws Exception {
        Iterable<String> iterable = Splitter.on(";")
                                            .omitEmptyStrings()
                                            .trimResults()
                                            .split("Pollub;;UMCS;KUL;UP");
        List<String> splittedList = Lists.newArrayList(iterable);

        assertEquals(4, splittedList.size());
        assertEquals("UMCS", splittedList.get(1));

    }
}
