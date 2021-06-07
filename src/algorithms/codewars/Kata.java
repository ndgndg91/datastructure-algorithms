package algorithms.codewars;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Kata {
    public static String createPhoneNumber(int[] numbers) {
        // Your code here!
        var first = new StringBuilder("(");
        var second = new StringBuilder();
        var third = new StringBuilder();
        for (var i = 0; i < numbers.length; i++) {
            if (i <= 2) {
                first.append(numbers[i]);
            } else if (i <= 5) {
                second.append(numbers[i]);
            } else {
                third.append(numbers[i]);
            }
        }

        return first + ") " + second + "-" + third;
    }

    @Test
    public void tests() {
        assertEquals("(123) 456-7890", Kata.createPhoneNumber(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 0}));
    }
}
