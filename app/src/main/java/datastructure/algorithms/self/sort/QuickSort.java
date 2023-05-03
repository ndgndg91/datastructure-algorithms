package datastructure.algorithms.self.sort;

/**
 * Divide and conquer algorithm
 * recursive algorithm
 * uses a pivot element to partition the array into two parts
 * Elements < pivot to its left, elements > pivot to its right
 * Pivot will then be in its correct sorted position
 *
 * Process is now repeated for the left array and right array
 * Eventually, every element has been the pivot, so every element will be in its correct sorted position
 * As with merge sort, we'll end up partitioning the array into a series of 1-element arrays
 * Does this in-place (unlike merge sort)
 *
 * n log n base 2 - we're repeatedly partitioning the array into two halves
 * unstable algorithm
 */
public class QuickSort {

    public static void main(String[] args) {
        final int[] array = new int[]{20, 35, -15, 7, 55, 1, -22};

        ArrayPrintable.printArray(array);
        System.out.println();

        quickSortAsc(array, 0, array.length);

        ArrayPrintable.printArray(array);
        System.out.println();
    }


    private static void quickSortAsc(int[] input, int start, int end) {
        if (end - start < 2) {
            return;
        }

        int pivotIndex = partitionAsc(input, start, end);
        quickSortAsc(input, start, pivotIndex);
        quickSortAsc(input, pivotIndex + 1, end);
    }

    private static int partitionAsc(int[] input, int start, int end) {
        // This is using the first element as the pivot
        var pivot = input[start];
        var i = start;
        var j = end;

        while (i < j) {

            // NOTE; empty loop body
            while (i < j && input[--j] >= pivot);
            if (i < j) {
                input[i] = input[j];
            }

            // NOTE; empty loop body
            while (i < j && input[++i] <= pivot);
            if (i < j) {
                input[j] = input[i];
            }
        }

        input[j] = pivot;
        return j;
    }
}
