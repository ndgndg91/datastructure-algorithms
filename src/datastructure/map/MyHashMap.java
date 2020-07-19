package datastructure.map;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class MyHashMap<K, V> implements Map<K, V> {
    private static final float LOAD_FACTOR = 0.75F;
    private static final int INITIAL_CAPACITY = 16;
    private Node[] nodes;
    private int size;

    public MyHashMap(){
        this.size = 0;
        this.nodes = new Node[INITIAL_CAPACITY];
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
        int hash = hash(o);
        int index = index(o, hash);

        Node<K, V> first = nodes[index];
        while (true) {
            if (first == null) {
                return false;
            }

            if (first.hash == hash) {
                return true;
            }

            first = first.next;
        }
    }

    @Override
    public boolean containsValue(Object o) {
        if (size > 0) {
            for (Node<K, V> node : nodes) {
                for (Node<K, V> n = node; n != null; n = n.next) {
                    Object v;
                    if ((v = n.value) == o || o != null && o.equals(v)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    @Override
    public V get(Object key) {
        int hash = hash(key);
        int index = index(key, hash);

        Node<K, V> value;
        Node<K, V> first = nodes[index];
        while (true) {
            if (first == null) {
                return null;
            }

            if (first.hash == hash) {
                value = first;
                break;
            }

            first = first.next;
        }
        return value.value;
    }

    @Override
    public V put(K k, V v) {
        if (k == null || v == null) {
            return null;
        }

        float cf = (float) size / nodes.length;
        if (cf >= LOAD_FACTOR) {
            resize();
        }

        int hash = hash(k);
        int index = index(k, hash);

        if (nodes[index] == null) {
            nodes[index] = new Node<>(k, v, null, hash);
        } else  {
            Node<K, V> first = nodes[index];
            while (true) {
                if (first.next == null) {
                    first.next = new Node<>(k, v, null, hash);
                    break;
                }

                first = first.next;
            }
        }

        size++;
        return v;
    }

    private int index(Object key, int hash) {
        int index = 0;
        if (key != null) {
            index = hash & (nodes.length - 1);
        }

        return index;
    }

    private int hash(Object key) {
        int hash = 0;
        if (key != null) {
            hash = key.hashCode();
        }

        return hash;
    }

    private void resize() {
        int l = nodes.length * 2;
        Node<K, V>[] nn = new Node[l];
        for (int idx = 0; idx < nodes.length; idx++) {
            if (nodes[idx] == null) {
                continue;
            }

            if (nodes[idx].next != null) {
                nn[idx] = nodes[idx];
            } else {
                Node<K, V> h = nn[idx];
                for (Node<K, V> n = nodes[idx]; n.next != null; n = n.next) {
                    h.next = n;
                    h = n;
                }
            }
        }
    }

    @Override
    public V remove(Object o) {
        int hash = hash(o);
        int index = index(o, hash);

        Node<K, V> n = nodes[index];
        while (true) {
            Node<K, V> next = n.next;
            if (n.hash == hash) {
                nodes[index] = next;
                size--;
                return n.value;
            }

            if (next == null) {
                return null;
            }

            n = next;
        }
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> map) {

    }

    @Override
    public void clear() {
        if (size > 0) {
            size = 0;
            Arrays.fill(nodes, null);
        }
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

    private static class Node<K, V> implements Entry<K, V>{
        protected K key;
        protected V value;
        protected Node<K, V> next;
        protected int hash;

        public Node(K key, V value, Node<K, V> next, int hash) {
            this.key = key;
            this.value = value;
            this.next = next;
            this.hash = hash;
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
