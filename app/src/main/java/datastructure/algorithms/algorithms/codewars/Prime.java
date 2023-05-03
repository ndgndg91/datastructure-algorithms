package datastructure.algorithms.algorithms.codewars;

public class Prime {
    public static boolean isPrime(int num) {
        if (num <= 1) return false;

        var sqrt = Math.round(Math.sqrt(num));
        var dividend = 2;
        while (dividend <= sqrt) {
            if (num % dividend == 0) {
                return false;
            }

            dividend++;
        }

        return true;
    }
}
