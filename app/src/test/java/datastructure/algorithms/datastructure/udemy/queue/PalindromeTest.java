package datastructure.algorithms.datastructure.udemy.queue;

import org.junit.jupiter.api.Test;

import static datastructure.algorithms.datastructure.udemy.queue.Palindrome.checkForPalindrome;
import static datastructure.algorithms.datastructure.udemy.queue.Palindrome.checkPalindrome;
import static org.junit.jupiter.api.Assertions.*;

class PalindromeTest {

    @Test
    public void palindrome() {
        assertTrue(checkForPalindrome("abccba"));
        // true
        assertTrue(checkForPalindrome("Was it a car or a cat i saw"));
        // true
        assertTrue(checkForPalindrome("I did, did I?"));
        // false
        assertFalse(checkForPalindrome("hello"));
        // true
        assertTrue(checkForPalindrome("Dont't nod"));
        // false
        assertFalse(checkForPalindrome("fdsjlewrgh"));
    }

    @Test
    public void palindrome2() {
        assertTrue(checkPalindrome("abccba"));
        // true
        assertTrue(checkPalindrome("Was it a car or a cat i saw"));
        // true
        assertTrue(checkPalindrome("I did, did I?"));
        // false
        assertFalse(checkPalindrome("hello"));
        // true
        assertTrue(checkPalindrome("Dont't nod"));
        // false
        assertFalse(checkPalindrome("fdsjlewrgh"));
    }

}