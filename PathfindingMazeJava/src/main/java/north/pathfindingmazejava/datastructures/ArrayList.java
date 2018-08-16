package north.pathfindingmazejava.datastructures;

public class ArrayList<E> {
    private Object[] list;
    private int size;

    public ArrayList() {
        this.list = new Object[1];
        size = 0;
    }
    
    public void add(Object o) {
        if (list.length - 1 == size) {
            this.expand();
        }
        list[size] = o;
        size++;
    }
    
    private void expand() {
        Object[] newList = new Object[(size + size / 2 + 2)];
        for (int i = 0; i < list.length; i++) {
            newList[i] = list[i];
        }
        this.list = newList;
    }    
    
    public Object get(int i) {
        return list[i];
    }
    
    public int getSize() {
        return size;
    }
    
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
