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
    public V get(Object k) {
        if (k == null) {
            return null;
        }

        Comparable key = (Comparable) k;
        TreeNode<K, V> t = this.root;

        while (t != null) {
            int cmp = key.compareTo(t.key);
            if (cmp < 0) {
                t = t.left;
            } else  {
                if (cmp <= 0) {
                    return t.value;
                }

                t = t.right;
            }
        }

        return null;
    }

    @Override
    public V put(K k, V v) {
        TreeNode<K, V> t = this.root;
        TreeNode<K, V> parent;
        if (t == null) {
            this.root = new TreeNode<>(k, v, null);
            this.size = 1;
        } else {
            if (k == null) {
                throw new NullPointerException();
            }

            Comparable key = (Comparable) k;
            int cmp;

            do {
                parent = t;
                cmp = key.compareTo(t.key);
                if (cmp < 0) {
                    t = t.left;
                } else {
                    if (cmp <= 0) {
                        return t.setValue(v);
                    }

                    t = t.right;
                }
            } while (t != null);


            TreeNode<K, V> e = new TreeNode<>(k, v, parent);
            if (cmp < 0) {
                parent.left = e;
            } else {
                parent.right = e;
            }

//            TODO jdk TreeMap method 까기
//            this.fixAfterInsertion(e);
            this.size++;
        }

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

        public TreeNode(K key, V value, TreeNode<K, V> parent) {
            this.key = key;
            this.value = value;
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
