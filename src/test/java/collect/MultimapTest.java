package collect;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import org.testng.annotations.Test;

import java.util.Collection;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MultimapTest {

    @Test
    public void shouldReturnEmptyCollection() {
        Multimap<String, String> multimap = ArrayListMultimap.create();

        Collection<String> kowalski = multimap.get("Kowalski");

        assertTrue(kowalski.isEmpty());
    }

    @Test
    public void shouldTestHowMultimapWorks() {

        // given
        Multimap<String, String> multimap = ArrayListMultimap.create();
        Map<String, Collection<String>> map = multimap.asMap();

        // when
        multimap.put("Kowalski", "Jan");
        multimap.put("Kowalski", "Piotr");
        multimap.put("Kowalski", "Piotr");
        multimap.put("Kowalski", "Krzysztof");
        multimap.put("Nowak", "Pawel");
        multimap.put("Nowak", "Adam");

        // then
        assertEquals(4, multimap.get("Kowalski").size());
        assertEquals(2, multimap.get("Nowak").size());
        assertEquals(6, multimap.keys().size()); // keys can have duplicates
    }
}
