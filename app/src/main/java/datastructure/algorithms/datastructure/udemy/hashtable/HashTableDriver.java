package datastructure.algorithms.datastructure.udemy.hashtable;

import datastructure.algorithms.datastructure.udemy.hashtable.chained.ChainedHashtable;
import datastructure.algorithms.datastructure.udemy.hashtable.linearprobe.LinearProbeHashtable;
import datastructure.algorithms.datastructure.udemy.hashtable.rehash.RehashingLinearProbeHashtable;
import datastructure.algorithms.datastructure.udemy.hashtable.simple.SimpleHashtable;


public class HashTableDriver {

    public static void main(String[] args) {
//        driveSimpleHashtable();
//        driveLinearProbeHashtable();
//        driveRehashingLinearProbeHashtable();
        driveChainedHashtable();
    }

    private static void driveSimpleHashtable() {
        var ht = new SimpleHashtable();
        ht.put("giri", new Person("giri", 32)); // 4
        ht.put("john", new Person("john", 50)); // 4 need open addressing - liner probing
        ht.put("doe", new Person("doe", 30)); // 3
        ht.put("wilson", new Person("wilson", 30)); // 6
        ht.put("hello", new Person("hello", 50)); // 5

        ht.printHashtable();

        System.out.println(ht.get("hello"));
    }

    private static void driveLinearProbeHashtable() {
        var ht = new LinearProbeHashtable();
        ht.put("giri", new Person("giri", 32)); // 4
        ht.put("john", new Person("john", 50)); // 4 need open addressing - liner probing
        ht.put("doe", new Person("doe", 30)); // 3
        ht.put("wilson", new Person("wilson", 30)); // 6
        ht.put("hello", new Person("hello", 50)); // 5

        ht.printHashtable();

        System.out.println(ht.get("hello"));
        System.out.println(ht.get("giri"));
        System.out.println(ht.get("john"));

        ht.remove("giri");
        ht.remove("wilson");

        ht.printHashtable();
    }

    private static void driveRehashingLinearProbeHashtable() {
        var ht = new RehashingLinearProbeHashtable();
        ht.put("giri", new Person("giri", 32)); // 4
        ht.put("john", new Person("john", 50)); // 4 need open addressing - liner probing
        ht.put("doe", new Person("doe", 30)); // 3
        ht.put("wilson", new Person("wilson", 30)); // 6
        ht.put("hello", new Person("hello", 50)); // 5

        ht.printHashtable();

        System.out.println(ht.get("hello"));
        System.out.println(ht.get("giri"));
        System.out.println(ht.get("john"));

        ht.remove("giri");
        ht.remove("wilson");

        ht.printHashtable();
    }

    private static void driveChainedHashtable() {
        var ht = new ChainedHashtable();
        ht.put("giri", new Person("giri", 32)); // 4
        ht.put("john", new Person("john", 50)); // 4 need open addressing - liner probing
        ht.put("doe", new Person("doe", 30)); // 3
        ht.put("wilson", new Person("wilson", 30)); // 6
        ht.put("hello", new Person("hello", 50)); // 5

        ht.printHashtable();

        System.out.println(ht.get("hello"));
        System.out.println(ht.get("giri"));
        System.out.println(ht.get("john"));

        ht.remove("giri");
        ht.remove("wilson");

        ht.printHashtable();
    }
}
