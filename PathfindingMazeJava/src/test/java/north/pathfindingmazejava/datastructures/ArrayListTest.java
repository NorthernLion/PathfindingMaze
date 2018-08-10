package north.pathfindingmazejava.datastructures;

/**
 *
 * @author northernpike
 */

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class ArrayListTest {
    ArrayList<Integer> beforelist;
    Integer added;
    Integer added2;
    Integer added3;
    
    

    @Before
    public void setUp() {
        beforelist = new ArrayList<>();
        added = 1;
        added2 = 2;
        added3 = 3;
    }
    
    @Test
    public void testAdd() {
        beforelist.add(added);        
        assertEquals(added, beforelist.get(0));
    }
    
    @Test
    public void testManyAdd() {
        beforelist.add(added);
        beforelist.add(added3);
        beforelist.add(added2);        
        assertEquals(added, beforelist.get(0));
        assertEquals(added3, beforelist.get(1));
        assertEquals(added2, beforelist.get(2));
    }

    @Test 
    public void testGet() {
        beforelist.add(added2);
        beforelist.add(added);
        assertEquals(added2, beforelist.get(0));
        assertEquals(added, beforelist.get(1));
        
    }
    
    @Test
    public void testReverse() {
        beforelist.add(added);
        beforelist.add(added2);
        beforelist.add(added3);      
        ArrayList<Integer> afterlist = new ArrayList<>();
        afterlist.add(added3);
        afterlist.add(added2);
        afterlist.add(added);      
        afterlist.reverse();
        assertEquals(afterlist.get(0), beforelist.get(0));
        assertEquals(afterlist.get(1), beforelist.get(1));
        assertEquals(afterlist.get(2), beforelist.get(2));
    }

    @Test
    public void testSize() {
        beforelist.add(added);
        assertEquals(1, beforelist.getSize());
    }
    
    @Test
    public void testSizeWhenEmpty() {
        assertEquals(0, beforelist.getSize());
    }    
}