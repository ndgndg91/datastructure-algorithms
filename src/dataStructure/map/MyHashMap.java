package dataStructure.map;

import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class MyHashMap<K, V> {
    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    private static final int MAXIMUM_CAPACITY = 1073741824;
    private Node<K, V>[] table;
    private Set<Map.Entry<K, V>> entrySet;
    int size;
    float loadFactor;

    public MyHashMap() {
        this.loadFactor = 0.75F;
        this.table = new Node[DEFAULT_INITIAL_CAPACITY];
    }

    static int hash(Object key) {
        int h;
        if (key == null) {
            return 0;
        } else {
            int hash = h = key.hashCode();
            return hash ^ h >>> 16;
        }
    }

    public V get(K key) {
        int hash = hash(key);
        int n = table.length;
        return table[n-1 & hash].value;
    }

    public V put(K key, V value) {
        Node<K, V>[] tab = table;
        int n = tab.length;

        Object p;
        int i = n - 1 & hash(key);
        p = tab[i];
        if (p == null) {
            tab[i] = new Node<>(hash(key), key, value, null);
        } else {

        }

        return value;
    }

    private static final class Node<K, V> implements Map.Entry<K, V> {
        final int hash;
        final K key;
        V value;
        Node<K, V> next;

        public Node(int hash, K key, V value, Node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
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
            V old = value;
            value = v;
            return old;
        }

        @Override
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }

            if (o instanceof Map.Entry) {
                Map.Entry<?, ?> e = (Map.Entry) o;
                return Objects.equals(this.key, e.getKey()) &&
                        Objects.equals(this.value, e.getValue());
            }

            return false;
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(this.key) ^ Objects.hashCode(this.value);
        }
    }
}
