package datastructure.udemy.hashtable.chained;


import datastructure.udemy.hashtable.Person;
import datastructure.udemy.hashtable.StoredPerson;

import java.util.Iterator;
import java.util.LinkedList;

public class ChainedHashtable {
    private LinkedList<StoredPerson>[] hashtable;

    public ChainedHashtable() {
        this.hashtable = new LinkedList[10];
        for (var i = 0; i < hashtable.length; i++) {
            hashtable[i] = new LinkedList<>();
        }
    }

    public void put(final String key, final Person person) {
        int hashedKey = hashKey(key);
        hashtable[hashedKey].add(new StoredPerson(key, person));
    }

    public Person get(final String key) {
        int hashedKey = hashKey(key);
        Iterator<StoredPerson> iterator = hashtable[hashedKey].iterator();
        StoredPerson p;
        while (iterator.hasNext()) {
            p = iterator.next();
            if (p.getKey().equals(key)) {
                return p.getPerson();
            }
        }

        return null;
    }

    public Person remove(final String key) {
        int hashedKey = hashKey(key);
        Iterator<StoredPerson> iterator = hashtable[hashedKey].iterator();
        StoredPerson p = null;
        int index = 0;
        while (iterator.hasNext()) {
            p = iterator.next();
            if (p.getKey().equals(key)) {
                break;
            }
            index++;
        }

        if (p == null || !p.getKey().equals(key)) {
            return null;
        } else {
            hashtable[hashedKey].remove(index);
            return p.getPerson();
        }
    }

    private int hashKey(final String key) {
//        return key.length() % hashtable.length;
        return Math.abs(key.hashCode() % hashtable.length);
    }

    public void printHashtable() {
        for (var i = 0; i < hashtable.length; i++) {
            if (hashtable[i].isEmpty()) {
                System.out.println("position : " + i + " Empty");
            } else {
                System.out.print("position : " + i + " ");
                for (StoredPerson storedPerson : hashtable[i]) {
                    System.out.print(storedPerson.getPerson());
                    System.out.print("->");
                }
                System.out.println("null");
            }
        }
    }
}
