package datastructure.map;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class MyLinearMap<K, V> {
    private List<Entry<K, V>> entries = new ArrayList<>();

    private Entry<K, V> findEntry(Object target) {
        for (Entry<K, V> entry : entries) {
            if (Objects.equals(target, entry.getKey())) {
                return entry;
            }
        }

        return null;
    }
    
    public V put(K key, V value) {
        Entry<K, V> entry = findEntry(key);
        if (entry == null) {
            entries.add(new Entry<>(key, value));
            return null;
        } else {
            V oldValue = entry.getValue();
            entry.setValue(value);
            return oldValue;
        }
    }
    
    public V get(Object key) {
        Entry<K, V> entry = findEntry(key);
        if (entry == null) {
            return null;
        }
        
        return entry.getValue();
    }
    
    public V remove(Object key) {
        Entry<K, V> entry = findEntry(key);
        if (entry == null) {
            return null;
        } else  {
            V value = entry.getValue();
            entries.remove(entry);
            return value;
        }
    }
    
    private static class Entry<K, V> implements Map.Entry<K, V> {
        private K key;
        private V value;

        private Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V v) {
            value = v;
            return value;
        }
    }

}
