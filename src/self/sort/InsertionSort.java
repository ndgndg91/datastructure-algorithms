package self.sort;

/**
 * in-place 알고리즘
 * 시간복잡도 n 제곱
 * Stable 알고리즘 - less then equals
 */
public class InsertionSort {

    public static void main(String[] args) {
        final var array = new int[]{20, 35, -15, 7, 55, 1, -22};
        ArrayPrintable.printArray(array);
        System.out.println();

        desc(array);

        ArrayPrintable.printArray(array);
        System.out.println();

        asc(array);

        ArrayPrintable.printArray(array);
    }

    private static void desc(final int[] array) {
        for (var firstUnsortedIndex = array.length - 2; firstUnsortedIndex >= 0; firstUnsortedIndex--) {
            var newElement = array[firstUnsortedIndex];

            int i;
            for (i = firstUnsortedIndex; i < array.length && array[i + 1] > newElement; i++) {
                array[i] = array[i + 1];
            }

            array[i] = newElement;
        }
    }

    private static void asc(final int[] array) {
        for (var firstUnsortedIndex = 1; firstUnsortedIndex < array.length; firstUnsortedIndex++) {
            var newElement = array[firstUnsortedIndex];

            int i;
            for (i = firstUnsortedIndex; i > 0 && array[i - 1] > newElement; i--)  {
                array[i] = array[i - 1];
            }

            array[i] = newElement;
        }
    }
}
