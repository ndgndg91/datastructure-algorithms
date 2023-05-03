package datastructure.algorithms.algorithms.codingtest.howtomerry;


public class HowToMerry1 {
    public static int solution(int n, int m) {
        int result = 0;
        while (n < m) {
            if (isPalindrome(n)) {
                result++;
            }
            n++;
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(solution(100, 300));
    }


    static boolean isPalindrome(int input) {
        if(input % 10 == 0) {
            return false;
        }

        int revertedHalf = 0;
        while(input > revertedHalf) {
            revertedHalf = revertedHalf * 10 + input % 10;
            input /= 10;
        }
        return input == revertedHalf || input == revertedHalf/10;
    }
}
