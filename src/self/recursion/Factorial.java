package self.recursion;

/**
 * 1! = 1 * 0! = 1
 * 2! = 2 * 1 = 2 * 1!
 * 3! = 3 * 2 * 1 = 3 * 2!
 * 4! = 4 * 3 * 2 * 1 = 4 * 3!
 * n! = n * (n-1)!
 */
public class Factorial {

    public static void main(String[] args) {
        int three = iterativeFactorial(3);
        System.out.println(three);

        int four = recursiveFactorial(4);
        System.out.println(four);
    }

    private static int recursiveFactorial(final int num) {
        if (num == 0) {
            return 1;
        }

        if (num == 1) {
            return 1;
        }

        return num * recursiveFactorial(num - 1);
    }

    private static int iterativeFactorial(final int num) {
        if (num == 0) {
            return 1;
        }

        int factorial = 1;
        for (var i = 1; i <= num; i++) {
            factorial *= i;
        }

        return factorial;
    }
}
