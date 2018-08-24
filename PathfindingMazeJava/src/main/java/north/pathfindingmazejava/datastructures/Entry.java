package north.pathfindingmazejava.datastructures;

/**
 *
 * @author northernpike
 * @param <K>
 * @param <V>
 */
public class Entry<K, V> {
    private K key;
    private V value;
    private Entry<K, V> next;

    /**
     *
     * @param key key where entry is found at.
     * @param value value at the given key.
     * @param next the Entry that is next.
     */
    public Entry(K key, V value, Entry<K, V> next) {
        this.key = key;
        this.value = value;
        this.next = next;
    }
    
    public K getKey() {
        return key;
    }

    Entry<K, V> getNext() {
        return next;
    }

    public V getValue() {
        return value;
    }

    public void setNext(Entry<K, V> next) {
        this.next = next;
    }
    
}
