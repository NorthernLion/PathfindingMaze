
package north.pathfindingmazejava.datastructures;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class HashMapTest {
    HashMap<Integer, String> map;
    
    @Before
    public void setUp() {
        map = new HashMap<>();
        map.put(1, "Tira");
        map.put(3, "Test");
        map.put(5, "FTW");
    }
    
    @Test
    public void testPutOver() {
        map.put(1, "Nope");
        assertEquals("Nope", map.get(1));
        map.put(1, "NopeBullet");
        assertEquals("NopeBullet", map.get(1));
    }
    
    @Test
    public void testWithHundredPuts() {
        for (int i = 0; i < 101; i++) {
            map.put(i, "" + i);
        }
        assertEquals("1", map.get(1));
        assertEquals("50", map.get(50));
        assertEquals("100", map.get(100));
    }
    
    @Test
    public void testGettingNonExistingKey() {
        assertEquals(null, map.get(25));
    }
    
}
