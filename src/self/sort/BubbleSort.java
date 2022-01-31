package self.sort;

/**
 * in-place 알고리즘
 * 시간복잡도 n 제곱
 * Stable Sort - 같은 값이라도 상대적인 순서가 유지된다.
 */
public class BubbleSort {

    public static void main(String[] args) {
        final var array = new int[]{20, 0, -20, 15, 5, -10};

        ArrayPrintable.printArray(array);
        System.out.println();

        asc(array);

        ArrayPrintable.printArray(array);
        System.out.println();

        desc(array);
    }

    private static void desc(final int[] array) {
        for (var unsortedIndex = 0; unsortedIndex < array.length; unsortedIndex++) {
            for (var i = array.length - 1; i > 0; i--) {
                if (array[i] > array[i - 1]) {
                    swap(array, i, i - 1);
                }
            }
        }
    }

    private static void asc(final int[] array) {
        for (var unsortedIndex = array.length - 1; unsortedIndex > 0; unsortedIndex--) {
            for (var i = 0; i < unsortedIndex; i++) {
                if (array[i] > array[i+1]) {
                    swap(array, i, i+1);
                }
            }
        }
    }

    private static void swap(int[] array, int i, int j) {
        var temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
