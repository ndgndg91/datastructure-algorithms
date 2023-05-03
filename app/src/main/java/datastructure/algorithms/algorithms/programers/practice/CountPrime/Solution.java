package datastructure.algorithms.algorithms.programers.practice.CountPrime;

class Solution {
    public static int solution(int n) {
        if ( n == 1)
            return 0;
        if ( n == 2)
            return 1;
        int answer = 0;
        for ( int i = 2; i <= n; i++) {
            if(isPrime(i))
                answer++;
        }
        return answer;
    }
    static boolean isPrime(int n){
        double root = Math.sqrt(n);
        int divisor = 2;
        while(divisor <= root) {
            if ( n % divisor == 0)
                return false;
            divisor++;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(solution(2));//1
        System.out.println(solution(3));//2
        System.out.println(solution(4));//2
        System.out.println(solution(5));//3
        System.out.println(solution(6));//3
        System.out.println(solution(7));//4
        System.out.println(solution(8));//4
        System.out.println(solution(9));//4
        System.out.println(solution(10));//4

    }
}