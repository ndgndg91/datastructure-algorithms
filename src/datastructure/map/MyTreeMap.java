package datastructure.map;

import java.util.*;

public class MyTreeMap<K, V> implements NavigableMap<K, V> {
    private int size;
    private TreeNode<K, V> root;
    private static final boolean RED = false;
    private static final boolean BLACK = true;

    @Override
    public Entry<K, V> lowerEntry(K k) {
        return null;
    }

    @Override
    public K lowerKey(K k) {
        return null;
    }

    @Override
    public Entry<K, V> floorEntry(K k) {
        return null;
    }

    @Override
    public K floorKey(K k) {
        return null;
    }

    @Override
    public Entry<K, V> ceilingEntry(K k) {
        return null;
    }

    @Override
    public K ceilingKey(K k) {
        return null;
    }

    @Override
    public Entry<K, V> higherEntry(K k) {
        return null;
    }

    @Override
    public K higherKey(K k) {
        return null;
    }

    @Override
    public Entry<K, V> firstEntry() {
        return null;
    }

    @Override
    public Entry<K, V> lastEntry() {
        return null;
    }

    @Override
    public Entry<K, V> pollFirstEntry() {
        return null;
    }

    @Override
    public Entry<K, V> pollLastEntry() {
        return null;
    }

    @Override
    public NavigableMap<K, V> descendingMap() {
        return null;
    }

    @Override
    public NavigableSet<K> navigableKeySet() {
        return null;
    }

    @Override
    public NavigableSet<K> descendingKeySet() {
        return null;
    }

    @Override
    public NavigableMap<K, V> subMap(K k, boolean b, K k1, boolean b1) {
        return null;
    }

    @Override
    public NavigableMap<K, V> headMap(K k, boolean b) {
        return null;
    }

    @Override
    public NavigableMap<K, V> tailMap(K k, boolean b) {
        return null;
    }

    @Override
    public Comparator<? super K> comparator() {
        return null;
    }

    @Override
    public SortedMap<K, V> subMap(K k, K k1) {
        return null;
    }

    @Override
    public SortedMap<K, V> headMap(K k) {
        return null;
    }

    @Override
    public SortedMap<K, V> tailMap(K k) {
        return null;
    }

    @Override
    public K firstKey() {
        return null;
    }

    @Override
    public K lastKey() {
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean containsKey(Object o) {
        return false;
    }

    @Override
    public boolean containsValue(Object o) {
        return false;
    }

    @Override
    public V get(Object o) {
        return null;
    }

    @Override
    public V put(K k, V v) {
        return null;
    }

    @Override
    public V remove(Object o) {
        return null;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> map) {

    }

    @Override
    public void clear() {
        size = 0;
        root = null;
    }

    @Override
    public Set<K> keySet() {
        return null;
    }

    @Override
    public Collection<V> values() {
        return null;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return null;
    }


    private static class TreeNode<K, V> implements Map.Entry<K, V> {
        K key;
        V value;
        TreeNode<K, V> left;
        TreeNode<K, V> right;
        TreeNode<K, V> parent;

        public TreeNode(K key, V value, TreeNode<K, V> left, TreeNode<K, V> right, TreeNode<K, V> parent) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
            this.parent = parent;
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
    }
}
