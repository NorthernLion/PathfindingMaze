package north.pathfindingmazejava.datastructures;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author northernpike
 */
public class HashMap<K, V>  {
    private Entry<K, V>[] table;
    private int size;
    private ArrayList<K> set;

    public HashMap() {
        this.size = 20;
        this.table = new Entry[this.size];        
        this.set = new ArrayList<>();
    }    
    
    public void put(K key, V value){
        if (key == null) {
            return;
        }
        
        this.set.add(key);
        int hash = this.hash(key);
        
        Entry<K,V> newEntry = new Entry(key, value, null);
        if(table[hash] == null) { // There is no value at the hash so simply put the value in it.
            table[hash] = newEntry;
        } else { //A value was found at the hash so we will need to rehash.
            Entry<K, V> previous = null;
            Entry<K, V> current = table[hash];
            
            while(current != null) {
                if(current.getKey().equals(key)) { //Look untill we find the value that has the same key as the one we are trying to add
                    if(previous == null) { //Fixing the HashMap to display right Next values
                        newEntry.setNext(current.getNext());
                        table[hash] = newEntry;
                        return;
                    }
                    else { 
                        newEntry.setNext(current);
                        previous.setNext(newEntry);
                        return;
                    }
                }
                previous = current;
                current = current.getNext();
            }
            previous.setNext(newEntry);
        }
    }
    
    public V get(K key){
        int hash = this.hash(key);
        Entry e = table[hash];        
        while(e != null) { //We simply go trough whole hashMap with getNext() function
            if(e.getKey().equals(key)) {
                return (V) e.getValue();
            }
            e = e.getNext();
        }
        return null; //Nothing matching the key was found.
    }
    
    private int hash(K key) {
        return key.hashCode() % size;
    }
}
