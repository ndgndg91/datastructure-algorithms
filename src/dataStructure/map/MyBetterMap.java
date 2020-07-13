package dataStructure.map;

import java.util.*;

public class MyBetterMap<K, V> implements Map<K, V> {
    private static final int DEFAULT_CAPACITY = 16;
    protected List<MyLinearMap<K, V>> maps;
    protected int size;

    public MyBetterMap(){
        this.maps = new ArrayList<>();
        for (int i = 0; i < DEFAULT_CAPACITY; i++) {
            maps.add(new MyLinearMap<>());
        }

        this.size = 0;
    }

    private MyLinearMap<K, V> chooseMap(Object key) {
        int index = 0;
        if (key != null) {
            index = Math.abs(key.hashCode()) & maps.size();
        }

        return maps.get(index);
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
    public V get(Object key) {
        MyLinearMap<K, V> chooseMap = chooseMap(key);
        return chooseMap.get(key);
    }

    @Override
    public V put(K k, V v) {
        MyLinearMap<K, V> chooseMap = chooseMap(k);
        V put = chooseMap.put(k, v);
        size++;
        return put;
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
}
