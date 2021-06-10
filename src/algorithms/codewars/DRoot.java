package algorithms.codewars;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DRoot {
    public static int digital_root(int n) {
        // ...
        while (n > 9) {
            n = Arrays.stream(String.valueOf(n).split(""))
                    .map(Integer::parseInt)
                    .reduce(0, Integer::sum);
        }

        return n;
    }

    @Test
    public void Test1() {
        assertEquals(7, DRoot.digital_root(16));
    }
    @Test
    public void Test2() {
        assertEquals(6, DRoot.digital_root(456));
    }
}
