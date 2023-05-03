package datastructure.algorithms.datastructure.udemy.hashtable.linearprobe;

import datastructure.algorithms.datastructure.udemy.hashtable.Person;
import datastructure.algorithms.datastructure.udemy.hashtable.StoredPerson;

/**
 * using open addressing(closed hashing) - linear probe
 */
public class LinearProbeHashtable {

    private StoredPerson[] hashtable;

    public LinearProbeHashtable() {
        this.hashtable = new StoredPerson[10];
    }

    public void put(final String key, final Person person) {
        int hashedKey = hashKey(key);
        if (occupied(hashedKey)) {
            int stopIndex = hashedKey;
            if (hashedKey == hashtable.length - 1) {
                hashedKey = 0;
            } else {
                hashedKey++;
            }

            while (occupied(hashedKey) && hashedKey != stopIndex) {
                hashedKey = (hashedKey + 1) & hashtable.length;
            }
        }

        if (occupied(hashedKey)) {
            System.out.println("there's already an employee at position " + hashedKey);
        } else {
            hashtable[hashedKey] = new StoredPerson(key, person);
        }
    }

    public Person remove(final String key) {
        int hashedKey = findKey(key);
        if (hashedKey == -1) {
            return null;
        }

        var person = hashtable[hashedKey].getPerson();
        hashtable[hashedKey] = null;
        return person;
    }

    public Person get(final String key) {
        int hashedKey = findKey(key);
        if (hashedKey == -1) {
            return null;
        }

        return hashtable[hashedKey].getPerson();
    }

    private int findKey(final String key) {
        int hashedKey = hashKey(key);
        if (hashtable[hashedKey] != null && hashtable[hashedKey].getKey().equals(key)) {
            return hashedKey;
        }

        int stopIndex = hashedKey;
        if (hashedKey == hashtable.length - 1) {
            hashedKey = 0;
        } else {
            hashedKey++;
        }

        while (hashedKey != stopIndex && hashtable[hashedKey] != null && !hashtable[hashedKey].getKey().equals(key)) {
            hashedKey = (hashedKey + 1) & hashtable.length;
        }

        if (hashtable[hashedKey] != null && hashtable[hashedKey].getKey().equals(key)) {
            return hashedKey;
        } else {
            return -1;
        }
    }

    private int hashKey(final String key) {
        return key.length() % hashtable.length;
    }

    private boolean occupied(final int index) {
        return hashtable[index] != null;
    }


    public void printHashtable() {
        for (var i = 0; i < hashtable.length; i++) {
            if (hashtable[i] == null) {
                System.out.println("EMPTY");
            } else {
                System.out.println("position : " + i + " " + hashtable[i].getPerson());
            }

        }
    }
}
