package north.pathfindingmazejava.datastructures;

public class Entry<K, V> {
    private K key;
    private V value;
    private Entry<K, V> next;

    public Entry(K key, V value, Entry<K, V> next) {
        this.key = key;
        this.value = value;
        this.next = next;
    }

    public K getKey() {
        return key;
    }

    public Entry<K, V> getNext() {
        return next;
    }

    public V getValue() {
        return value;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public void setNext(Entry<K, V> next) {
        this.next = next;
    }

    public void setValue(V value) {
        this.value = value;
    }
    
    
}
