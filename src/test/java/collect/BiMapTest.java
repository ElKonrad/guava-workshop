package collect;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class BiMapTest {

    @Test
    public void shouldInverseBiMap() {

        BiMap<Integer, String> biMap = HashBiMap.create();

        // when
        biMap.put(1, "Kowalski");
        biMap.put(2, "Nowak");
        biMap.put(3, "Wisniewski");

        BiMap<String, Integer> inversedBiMap = biMap.inverse();

        // then
        assertEquals(Integer.valueOf(1), inversedBiMap.get("Kowalski"));
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void shouldNotAllowToPutExistingValue() {

        BiMap<Integer, String> biMap = HashBiMap.create();

        biMap.put(1, "Kowalski");
        biMap.put(2, "Nowak");
        biMap.put(3, "Wisniewski");
    }

    @Test
    public void shouldAllowToPutExistingValueWithForcePut() {

        BiMap<Integer, String> biMap = HashBiMap.create();

        biMap.put(1, "Kowalski");
        biMap.put(2, "Nowak");
        biMap.put(3, "Wisniewski");
        biMap.forcePut(4, "Kowalski");

        assertEquals("Kowalski", biMap.get(4));
    }
}
