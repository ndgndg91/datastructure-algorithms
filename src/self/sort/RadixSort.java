package self.sort;

/**
 * Makes assumptions about the data
 * data must have same radix and width
 * because of this, data must be integers or strings
 * sort based on each individual digit or letter position
 * start at the rightmost position
 * must use a stable sort algorithm at each stage
 *
 * Counting sort is often used as the sort algorithm for radix sort - must be stable counting sort
 * n time complexity - we're making assumptions about data we're sorting.
 * even so, it often runs slower than n log n algorithms because of the overhead involved
 * in-place depends on which sort algorithm you use
 * stable algorithm
 */
public class RadixSort {

    public static void main(String[] args) {
        final var radixArray = new int[]{4725, 4586, 1330, 8792, 1594, 5729};

        ArrayPrintable.printArray(radixArray);
        System.out.println();

        radixSort(radixArray, 10, 4);

        ArrayPrintable.printArray(radixArray);
        System.out.println();
    }

    private static void radixSort(int[] input, int radix, int width) {
        for (var i = 0; i < width; i++) {
            radixSingleSort(input, i, radix);
        }
    }

    private static void radixSingleSort(int[] input, int position, int radix) {
        var numItems = input.length;
        var countArray = new int[radix];

        for (var value: input) {
            int digit = getDigit(position, value, radix);
            countArray[digit]++;
        }

        // Adjust the count array
        for (var j = 1; j < radix; j++) {
            countArray[j] += countArray[j-1];
        }

        int[] temp = new int[numItems];
        for (var tempIndex = numItems - 1; tempIndex >= 0; tempIndex--) {
            temp[--countArray[getDigit(position, input[tempIndex], radix)]] = input[tempIndex];
        }

        for (var tempIndex = 0; tempIndex < numItems; tempIndex++) {
            input[tempIndex] = temp[tempIndex];
        }
    }

    private static int getDigit(int position, int value, int radix) {
        return value / (int) Math.pow(radix, position) % radix;
    }
}
