package algorithms.programers.gcdandlcm;

public class Solution {
    private static final int[] TEST1 = new int[]{3, 12};
    private static final int[] TEST2 = new int[]{2, 5};

    public static void main(String[] args){
        int[] solution = solution(TEST1[0], TEST1[1]);
        int[] solution2 = solution(TEST2[0], TEST2[1]);

        StringBuilder builder = new StringBuilder();
        builder.toString();
        for (int a : solution) {
            System.out.print(a + "\t");
        }

        System.out.println();
        for (int a : solution2) {
            System.out.print(a + "\t");
        }
    }

    private static int[] solution(int a, int b) {
        int gcd = getGCD(a, b);
        int lcm = getLCM(a, b, gcd);
        return new int[]{gcd, lcm};
    }

    private static int getGCD(int a, int b) {
        if (b == 0) return a;
        return getGCD(b, a%b);
    }

    private static int getLCM(int a, int b, int gcd) {
        return a * b / gcd;
    }


}
