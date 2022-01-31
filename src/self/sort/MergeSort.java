package self.sort;

/**
 * divide and conquer algorithm
 * recursive algorithm
 * two phases: splitting and merging
 * splitting phase leads to faster sorting during the merging phase
 * splitting is logical. we don't create new arrays
 *
 * splitting phase
 * start with an unsorted array.
 * divide the array into two arrays, which are unsorted.
 * the first array is the left array, and the second array is the right array
 * split the left and right arrays into two arrays each
 * keep splitting until all the arrays have only one element each - these arrays are sorted
 *
 * merging phase
 * merge every left/right pair of sibling arrays into a sorted array
 * after the first merge, we'll have a bunch of 2-element sorted arrays
 * then merge those sorted arrays (left/right siblings) to end up with a bunch of 4-element sorted arrays
 * repeat until you have a single sorted array
 * not in-place. uses temporary arrays
 *
 * merging process
 * we merge sibling left and right arrays
 * we create a temporary array large enough to hold all the elements in the arrays we're merging
 * we set i to the first index of the left array, and j to the first index of the right array
 * we compare left[i] to right[j]. if left is smaller, we copy it to the temp array and increment i by 1.
 * if right is smaller, we copy it to the temp array and increment j by 1.
 * we repeat this process until all elements in the two arrays have been processed
 * at this point, the temporary array contains the merged values in sorted order
 * we then copy this temporary array back to the original input array, at the correct positions
 * if the left array is at positions x to y, and the right array is at positions y + 1 to z, then after the copy,
 * positions x to z will be sorted in the original array
 *
 * Not an in-place algorithm
 * n log n base 2. we're repeatedly dividing the array in half during the splitting phase
 * stable algorithm
 *
 * memory issue - there's a lot of temporary array instances created.
 * stack example
 *              mergeSort(a, 1, 2) mergeSort(a, 2, 3)   mergeSort(a, 3, 4), mergeSort(a, 4, 5)	mergeSort(a, 5, 6) mergeSort(6, 7)
 *    mergeSort(a, 0, 1)    mergeSort(a, 1, 3),				mergeSortAsc(a, 3, 5) 	                mergeSortAsc(a, 5, 7)
 *               mergeSort(a, 0, 3),								        mergeSort(a, 3, 7)
 *                                              mergeSort(a, 0, 7)
 *                                                  asc(a, 0, 7)
 */
public class MergeSort {

    public static void main(String[] args) {
        final var array = new int[]{20, 35, -15, 7, 55, 1, -22};

        ArrayPrintable.printArray(array);
        System.out.println();

        asc(array);

        ArrayPrintable.printArray(array);
        System.out.println();

        desc(array);

        ArrayPrintable.printArray(array);
    }

    private static void asc(final int[] array) {
        mergeSortAsc(array, 0, array.length);
    }

    private static void mergeSortAsc(int[] input, int start, int end) {
        if (end - start < 2) {
            return;
        }

        var mid = (start + end) / 2;
        mergeSortAsc(input, start, mid);
        mergeSortAsc(input, mid, end);
        mergeAsc(input, start, mid, end);
    }

    private static void mergeAsc(int[] input, int start, int mid, int end) {
        if (input[mid - 1] < input[mid]) {
            return;
        }

        var i = start;
        var j = mid;
        var tempIndex = 0;

        var temp = new int[end - start];
        while (i < mid && j < end) {
            if (input[i] <= input[j]) {
                temp[tempIndex++] = input[i++];
            } else {
                temp[tempIndex++] = input[j++];
            }
        }

        System.arraycopy(input, i, input, start + tempIndex, mid - i);
        System.arraycopy(temp, 0, input, start, tempIndex);
    }

    private static void desc(final int[] array) {
        mergeSortDesc(array, 0, array.length);
    }

    private static void mergeSortDesc(int[] input, int start, int end) {
        if (end - start < 2) {
            return;
        }

        var mid = (start + end) / 2;
        mergeSortDesc(input, start, mid);
        mergeSortDesc(input, mid, end);
        mergeDesc(input, start, mid, end);
    }

    private static void mergeDesc(int[] input, int start, int mid, int end) {
        if (input[mid - 1] > input[mid]) {
            return;
        }

        var i = start;
        var j = mid;
        var tempIndex = 0;

        var temp = new int[end - start];
        while (i < mid && j < end) {
            if (input[i] <= input[j]) {
                temp[tempIndex++] = input[j++];
            } else {
                temp[tempIndex++] = input[i++];
            }
        }

        System.arraycopy(input, i, input, start + tempIndex, mid - i);
        System.arraycopy(temp, 0, input, start, tempIndex);

    }
}
