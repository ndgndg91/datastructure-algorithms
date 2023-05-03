package datastructure.algorithms.algorithms.codewars;

public class Kata {
    public static String createPhoneNumber(int[] numbers) {
        // Your code here!
        var first = new StringBuilder("(");
        var second = new StringBuilder();
        var third = new StringBuilder();
        for (var i = 0; i < numbers.length; i++) {
            if (i <= 2) {
                first.append(numbers[i]);
            } else if (i <= 5) {
                second.append(numbers[i]);
            } else {
                third.append(numbers[i]);
            }
        }

        return first + ") " + second + "-" + third;
    }


}
