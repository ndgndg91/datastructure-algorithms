package algorithms.programers.divisorsum;

public class Solution {
    private static final int TEST1 = 10;
    private static final int TEST2 = 15;
    private static final int TEST3 = 20;

    public static void main(String[] args) {
        int solutionOne = solution(TEST1);
        int solutionTwo = solution(TEST2);
        int solutionThree = solution(TEST3);

        System.out.println(solutionOne);
        System.out.println(solutionTwo);
        System.out.println(solutionThree);
    }

    private static int solution(int n) {
        int m = n / 2;
        int sum = 0;
        for (int i = 1; i <= m; i++) {
            if (n % i == 0){
                sum += i;
            }
        }

        return sum + n;
    }
}
