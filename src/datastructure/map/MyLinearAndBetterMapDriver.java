package datastructure.map;

public class MyLinearAndBetterMapDriver {

    public static void main(String[] args) {
        MyLinearMap<Integer, String> myLinearMap = new MyLinearMap<>();
        myLinearMap.put(1, "남동길");
        myLinearMap.put(128, "남동길쓰!");

        System.out.println(myLinearMap.get(1));
        System.out.println(myLinearMap.get(2));
        System.out.println(myLinearMap.get(128));

        MyBetterMap<Long, String> myBetterMap = new MyBetterMap<>();
        myBetterMap.put(1L, "기리");
        myBetterMap.put(256L, "풔킨해요");

        System.out.println(myBetterMap.get(1L));
        System.out.println(myBetterMap.get(2L));
        System.out.println(myBetterMap.get(256L));
    }
}
