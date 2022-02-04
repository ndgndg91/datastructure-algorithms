package datastructure.udemy.hashtable.simple;

import datastructure.udemy.hashtable.Person;

/**
 * does not handle hash collision
 */
public class SimpleHashtable {

    private Person[] hashtable;

    public SimpleHashtable() {
        this.hashtable = new Person[10];
    }

    public void put(final String key, final Person person) {
        int hashedKey = hashKey(key);
        if (hashtable[hashedKey] != null) {
            System.out.println("there's already an employee at position " + hashedKey);
        } else {
            hashtable[hashedKey] = person;
        }
    }

    public Person get(final String key) {
        int hashedKey = hashKey(key);
        return hashtable[hashedKey];
    }

    private int hashKey(final String key) {
        return key.length() % hashtable.length;
    }

    public void printHashtable() {
        for (var person : hashtable) {
            System.out.println(person);
        }
    }
}
