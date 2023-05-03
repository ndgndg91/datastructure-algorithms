package datastructure.algorithms.algorithms.codewars;

public class Persistence {

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
