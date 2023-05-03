package datastructure.algorithms.algorithms.codewars;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Dec2FactTest {

    @Test
    public void test11() {
        assertEquals(Dec2Fact.factorial(5), 120);
        assertEquals(Dec2Fact.dec2FactString(1001L), "1212210");
        assertEquals(Dec2Fact.factString2Dec("1212210"), 1001L);
    }

}