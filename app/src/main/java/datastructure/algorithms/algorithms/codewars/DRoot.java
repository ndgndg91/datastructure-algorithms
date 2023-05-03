package datastructure.algorithms.algorithms.codewars;

import java.util.Arrays;

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


}
