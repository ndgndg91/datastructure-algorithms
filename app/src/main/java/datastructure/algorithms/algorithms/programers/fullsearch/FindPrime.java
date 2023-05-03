package datastructure.algorithms.algorithms.programers.fullsearch;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindPrime {
    private static final String numbers = "17";
    private static final String numbers2 = "011";

    private static final Set<Integer> primes = new HashSet<>();

    public static void main(String[] args) {
        solution(numbers);
    }

    public static int solution(String numbers) {
        int answer = 0;

        boolean[] visit = new boolean[numbers.length()];
        Arrays.fill(visit, false);

        for (int i = 0; i < numbers.length(); i++) {
            visit[i] = true;
            combination(visit, numbers, String.valueOf(numbers.charAt(i)));
            visit[i] = false;
        }

        return primes.size();
    }

    static void combination(boolean[] visit, String numbers, String num) {
        if (isPrime(num)) {
            primes.add(Integer.parseInt(num));
        }

        for (int i = 0; i < numbers.length(); i++) {
            if (visit[i]) continue;
            visit[i] = true;
            combination(visit, numbers, num + numbers.charAt(i));
            visit[i] = false;
        }
    }

    static boolean isPrime(String num){
        int i = Integer.parseInt(num);
        if (i < 2) return false;

        for (int n = 2; n <= i >>> 1; n++) {
            if (i % n == 0) return false;
        }

        return true;
    }
}
