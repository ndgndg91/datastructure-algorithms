package datastructure.list.udemy.hashtable;

import datastructure.list.udemy.hashtable.Person;

public class StoredPerson {

    private String key;
    private Person person;

    public StoredPerson(String key, Person person) {
        this.key = key;
        this.person = person;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
