package datastructure.algorithms.algorithms.codewars;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersistenceTest {
    @Test
    void persist()  {
        assertEquals(3, Persistence.persistence(39));
        assertEquals(0, Persistence.persistence(4));
        assertEquals(2, Persistence.persistence(25));
        assertEquals(4, Persistence.persistence(999));
    }

}