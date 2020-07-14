package dataStructure.map;

import dataStructure.map.test.Developer;

public class MyHashMapDriver {

    public static void main(String[] args) {
        MyHashMap<String, Developer> devMap = new MyHashMap<>();
        Developer ndg = new Developer("ndg", 30, "MALE", "JAVA");
        Developer ndg2 = new Developer("ndg", 30, "MALE", "JAVA");
        Developer ljs = new Developer("ljs", 32, "MALE", "JAVA");
        Developer cyh = new Developer("cyh", 36, "MALE", "JAVA");
        Developer lks = new Developer("lks", 32, "MALE", "JAVA");

        devMap.put(ndg.getName(), ndg);
        devMap.put(ndg2.getName(), ndg2);
        devMap.put(ljs.getName(), ljs);
        devMap.put(cyh.getName(), cyh);
        devMap.put(lks.getName(), lks);
        devMap.put(null, null);

        printMyMap(devMap, ndg, ndg2, ljs, cyh, lks);

        devMap.clear();

        printMyMap(devMap, ndg, ndg2, ljs, cyh, lks);
    }

    private static void printMyMap(
            MyHashMap<String, Developer> devMap,
            Developer ... devs
    ){
        if (devs[0] == null) {
            return;
        }

        System.out.println(devMap.size());
        System.out.println(devMap.isEmpty());
        for (Developer dev : devs)
            System.out.println(devMap.get(dev.getName()));

        String containNdg = String.format("devMap contain %s Developer : %b", devs[0].getName(), devMap.containsKey(devs[0].getName()));
        String containRandom = String.format("devMap contain random Developer : %b", devMap.containsKey("random"));
        System.out.println(containNdg);
        System.out.println(containRandom);
    }
}
