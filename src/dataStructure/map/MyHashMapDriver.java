package dataStructure.map;

public class MyHashMapDriver {

    public static void main(String[] args) {
        MyHashMap<Integer, String> myHashMap = new MyHashMap<>();
        myHashMap.put(1, "남동길");

        System.out.println(myHashMap.get(1));

    }
}
