package north.pathfindingmazejava.datastructures;

/**
 * @author northernpike
 * @param <E>
 */
public class ArrayList<E> {
    private Object[] list;
    private int size;

    /**
     * ArrayList has an array where objects are stored.
     * Size keeps track on the current index of the array as well as the size of ArrayList.
     */
    public ArrayList() {
        this.list = new Object[1];
        size = 0;
    }
    
    /**
     * If the Object array is full we expand it otherwise simply add the object to the index of the current size of the list.
     * @param o
     */
    public void add(Object o) {
        if (list.length - 1 == size) {
            this.expand();
        }
        list[size] = o;
        size++;
    }
    
    /**
     * Creates new array that has more room in it and copies the values from the old list to the new list.
     */    
    private void expand() {
        Object[] newList = new Object[(size + size / 2 + 2)];
        for (int i = 0; i < list.length; i++) {
            newList[i] = list[i];
        }
        this.list = newList;
    }
    
    /**
     * looks trough the array if the object is in it.
     */
    public boolean contains(Object o) {
        for (int i = 0; i < size; i++) {
            if (list[i] == o) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * returns  the object at given index.
     */
    public Object get(int i) {
        return list[i];
    }
    
    /**
     * returns size of the ArrayList.
     */
    public int getSize() {
        return size;
    }
    
    /**
     * reverses the direction of the list.
     */
    public void reverse() {
        Object[] relist = new Object[list.length];        
        int j = size - 1;
        
        for (int i = 0; i < size; i++) {
            relist[i] = list[j];
            j--;
        }
        this.list = relist;
    }
}
