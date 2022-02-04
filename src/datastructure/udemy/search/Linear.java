package datastructure.udemy.search;

public class Linear {

    public static void main(String[] args) {
        final var array = new int[]{20, 35, -15, 7, 55, 1, -22};

        System.out.println(linearSearch(array, -15));
        System.out.println(linearSearch(array, 1));
        System.out.println(linearSearch(array, 8888));
        System.out.println(linearSearch(array, -22));
    }

    private static int linearSearch(final int[] input, int value) {
        for (var i = 0; i < input.length; i++) {
            if (input[i] == value) {
                return i;
            }
        }

        return -1;
    }
}
