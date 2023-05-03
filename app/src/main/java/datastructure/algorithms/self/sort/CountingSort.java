package datastructure.algorithms.self.sort;

/**
 * Makes assumptions about the data
 * doesn't use comparisons
 * counts the number of occurrences of each value
 * only works with non-negative discrete values (can't work with floats, strings)
 * values must be within a specific range
 *
 * Assume we have values between 1 and 10 inclusive
 * we have 10 possible values, so we create a counting array of length 10
 * traverse the input array from left to right
 * use the counting array to track how many of each value are in the input array
 * using the counts in the counting array, write the values in sorted order to the input array
 *
 * NOT an in-place algorithm
 * n time complexity
 * if we want the sort to be stable, we have todo some extra steps
 *
 * stable counting sort
 * requires extra steps
 * can calculate where values should be written back to the original array
 * writing the values into the array in backwards order ensures stability
 *
 */
public class CountingSort {

    public static void main(String[] args) {
        final var array = new int[]{2, 5, 9, 8, 2, 8, 7, 10, 4, 3};

        ArrayPrintable.printArray(array);
        System.out.println();

        countingSort(array, 1, 10);

        ArrayPrintable.printArray(array);
        System.out.println();
    }

    private static void countingSort(int[] input, int min, int max) {
        int[] countArray = new int[(max - min) + 1];

        for (int i = 0; i < input.length; i++)  {
            countArray[input[i] - min]++;
        }

        int j = 0;
        for (int i = min; i <= max; i++) {
            while (countArray[i - min] > 0) {
                input[j++] = i;
                countArray[i - min]--;
            }
        }
    }
}
