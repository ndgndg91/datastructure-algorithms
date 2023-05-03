package datastructure.algorithms.self.sort;

/**
 * in-place 알고리즘
 * 시간복잡도 n 제곱
 * swap 이 bubble sort 만큼 빈번하게 일어나지 않는다.
 * Unstable Algorithm 로 같은 값이라도 index 앞에 있다면 먼저 selection 되어서 상대적 정렬이 무시된다.
 */
public class SelectionSort {

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

    private static void desc(final int[] array) {
        for (var lastUnsortedIndex = 0; lastUnsortedIndex < array.length; lastUnsortedIndex++) {
            int largestIndex = array.length - 1;
            for (var i = array.length - 1; i >= lastUnsortedIndex; i--) {
                if (array[i] > array[largestIndex]) {
                    largestIndex = i;
                }
            }

            swap(array, largestIndex, lastUnsortedIndex);
        }
    }

    private static void asc(final int[] array) {
        for (var lastUnsortedIndex = array.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--) {
            int largestIndex = 0;
            for (var i = 0; i <= lastUnsortedIndex; i++) {
                if (array[i] > array[largestIndex]) {
                    largestIndex = i;
                }
            }

            swap(array, largestIndex, lastUnsortedIndex);
        }
    }

    private static void swap(final int[] array, int i, int j) {
        if (i == j) return;
        final var temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
