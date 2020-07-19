package datastructure.map;

import datastructure.map.test.Developer;

public class MyHashMapDriver {

    //TODO 동일한 hashcode 는 어떻게 처리할 것인가?
    public static void main(String[] args) {
        MyHashMap<String, Developer> devMap = new MyHashMap<>();
        Developer ndg = new Developer("ndg", 30, "MALE", "JAVA");
        Developer ljs = new Developer("ljs", 32, "MALE", "JAVA");
        Developer cyh = new Developer("cyh", 36, "MALE", "JAVA");
        Developer lks = new Developer("lks", 32, "MALE", "JAVA");

        devMap.put(ndg.getName(), ndg);
        devMap.put(ljs.getName(), ljs);
        devMap.put(cyh.getName(), cyh);
        devMap.put(lks.getName(), lks);

        printMyMap(devMap, ndg, ljs, cyh, lks);

        devMap.remove(ndg.getName());
        devMap.remove(ndg.getName());

        printMyMap(devMap, ndg, ljs, cyh, lks);

        Developer john = new Developer("john", 32, "MALE", "JAVA");
        Developer sara = new Developer("sara", 32, "FEMALE", "JAVA");
        Developer suzi = new Developer("suzi", 25, "FEMALE", "JAVA");
        Developer ari = new Developer("ari", 32, "FEMALE", "JAVA");
        Developer sue = new Developer("sue", 31, "FEMALE", "JAVA");
        Developer brian = new Developer("brian", 34, "MALE", "JAVA");
        Developer jin = new Developer("jin", 39, "MALE", "JAVA");
        Developer jane = new Developer("jane", 28, "FEMALE", "JAVA");
        Developer gil = new Developer("gil", 30, "MALE", "JAVA");

        devMap.put(john.getName(), john);
        devMap.put(sara.getName(), sara);
        devMap.put(suzi.getName(), suzi);
        devMap.put(ari.getName(), ari);
        devMap.put(sue.getName(), sue);
        devMap.put(brian.getName(), brian);
        devMap.put(jin.getName(), jin);
        devMap.put(jane.getName(), jane);
        devMap.put(gil.getName(), gil);

        printMyMap(devMap, ndg, ljs, cyh, lks, john, sara, suzi, sue, ari, sue, brian, jin, jane);

        devMap.clear();

        printMyMap(devMap, ndg, ljs, cyh, lks, john, sara, suzi, sue, ari, sue, brian, jin, jane);

    }

    private static void printMyMap(
            MyHashMap<String, Developer> devMap,
            Developer ... devs
    ){
        if (devs[0] == null) {
            return;
        }

        System.out.println("========================================================================");
        System.out.println(devMap.size());
        System.out.println(devMap.isEmpty());
        for (Developer dev : devs)
            System.out.println(devMap.get(dev.getName()));

        String containNdg = String.format("devMap contain %s Developer : %b", devs[0].getName(), devMap.containsKey(devs[0].getName()));
        String containRandom = String.format("devMap contain random Developer : %b", devMap.containsKey("random"));
        System.out.println(containNdg);
        System.out.println(containRandom);
        System.out.println("========================================================================");
    }
}
