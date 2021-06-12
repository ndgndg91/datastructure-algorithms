package algorithms.codewars;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PanagramChecker {
    public boolean check(String sentence) {
        return sentence.chars()
                .parallel()
                .filter(Character::isLetter)
                .mapToObj(Character::toLowerCase)
                .distinct()
                .count() == 26;
    }

    @Test
    public void test1() {
        String pangram1 = "The quick brown fox jumps over the lazy dog.";
        PanagramChecker pc = new PanagramChecker();
        assertEquals(true, pc.check(pangram1));
    }
    @Test
    public void test2() {
        String pangram2 = "You shall not pass!";
        PanagramChecker pc = new PanagramChecker();
        assertEquals(false, pc.check(pangram2));
    }
}
