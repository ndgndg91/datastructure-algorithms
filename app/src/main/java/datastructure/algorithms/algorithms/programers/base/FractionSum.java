package datastructure.algorithms.algorithms.programers.base;

public class FractionSum {

    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int numerator = numer1 * denom2 + denom1 * numer2;
        int denominator = denom1 * denom2;
        int gcd = calculateGCD(numerator, denominator);
        return new int[]{numerator / gcd, denominator / gcd};
    }

    private int calculateGCD(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return calculateGCD(b, a % b);
        }
    }

}
