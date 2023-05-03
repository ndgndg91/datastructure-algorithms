package datastructure.algorithms.datastructure.udemy.search;

/**
 * Data must be sorted
 */
public class Binary {

    public static void main(String[] args) {
        final var array = new int[]{-22, -15, 1, 7, 20, 35, 55};

        System.out.println(binarySearch(array, -22));
        System.out.println(binarySearch(array, 7));
        System.out.println(binarySearch(array, 35));
        System.out.println(binarySearch(array, 55));
        System.out.println(binarySearch(array, 8888));


        System.out.println(recursiveBinarySearch(array, -22));
        System.out.println(recursiveBinarySearch(array, 7));
        System.out.println(recursiveBinarySearch(array, 35));
        System.out.println(recursiveBinarySearch(array, 55));
        System.out.println(recursiveBinarySearch(array, 8888));
    }

    private static int binarySearch(final int[] array, final int value) {
        int start = 0;
        int end = array.length;

        while (start < end) {
            int midpoint = (start + end) / 2;
            if (array[midpoint] == value) {
                return midpoint;
            } else if (array[midpoint] < value) {
                start = midpoint + 1;
            } else {
                end = midpoint;
            }
        }

        return -1;
    }

    private static int recursiveBinarySearch(final int[] array, final int value) {
        return recursiveBinarySearch(array, 0, array.length, value);
    }

    private static int recursiveBinarySearch(final int[] array, int start, int end, int value) {
        if (start >= end) {
            return -1;
        }

        int midpoint = (start + end) / 2;
        if (array[midpoint] == value) {
            return midpoint;
        } else if (array[midpoint] < value) {
            return recursiveBinarySearch(array, midpoint + 1, end, value);
        } else {
            return recursiveBinarySearch(array, start, midpoint, value);
        }
    }
}
