package algorithms.codewars;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Persistence {
    @Test
    void persist()  {
        assertEquals(3, persistence(39));
        assertEquals(0, persistence(4));
        assertEquals(2, persistence(25));
        assertEquals(4, persistence(999));
     }


    public static int persistence(long n) {
        var count = 0;
        while (n > 9) {
            n = reduce(n);
            count++;
        }

        return count;
    }

    static long reduce(long n) {
        var value = 1;
        for (var token : String.valueOf(n).split("")) {
            value *= Long.parseLong(token);
        }

        return value;
    }
}
