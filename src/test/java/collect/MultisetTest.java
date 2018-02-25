package collect;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;
import org.testng.annotations.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class MultisetTest {

    @Test
    public void shouldAddElementTwoTimes() {

        Multiset<String> multiset = HashMultiset.create();

        multiset.add("java");
        multiset.add("java");

        assertEquals(2, multiset.count("java"));
        assertEquals(0, multiset.count("typescript"));
    }

    @Test
    public void shouldUserCustomAddRemoveAndSetCount() {

        // given
        Multiset<String> multiset = HashMultiset.create();

        // when
        multiset.add("java");
        multiset.add("java", 9);

        // then
        assertEquals(10, multiset.count("java"));


        // when
        multiset.remove("java", 5);

        // then
        assertEquals(5, multiset.count("java"));


        // when
        multiset.setCount("java", 3);

        // then
        assertEquals(3, multiset.count("java"));
    }


    @Test
    public void shouldRetainOnlySelectedKeys() {

        // given
        Multiset<String> multiset = HashMultiset.create();

        multiset.add("java");
        multiset.add("java");
        multiset.add("typescript");
        multiset.setCount("scala", 5);

        // when
        multiset.retainAll(Arrays.asList("scala", "typescript"));

        assertEquals(5, multiset.count("scala"));
        assertEquals(0, multiset.count("java"));
    }
}
