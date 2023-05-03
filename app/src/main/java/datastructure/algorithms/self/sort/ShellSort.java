package datastructure.algorithms.self.sort;

/**
 * variation of insertion sort
 * insertion sort chooses which element to insert using a gap of 1
 * shell sort starts out using a larger gap value
 * as the algorithm runs, the gap is reduced
 * goal is to reduce the amount of shifting required
 * as the algorithm progresses, the gap is reduced
 * the last gap value is always 1
 * a gap value of 1 is equivalent to insertion sort
 * so, the algorithm does some preliminary work (using gap values greater than 1), and then becomes insertion sort
 * by the time we get to insertion sort, the array has been partially sorted, so there's less shifting required
 * gap is calculated using (3 square k - 1) / 2
 * we set k based on the length of the array
 * we want the gap to be as close as possible to the length of the array we want to sort, without being greater thant the length
 * k = 1, gap = 1
 * k = 2, gap = 4
 * k = 3, gap = 13
 * k = 4, gap = 40
 * k = 5, gap = 121
 *
 * in-place algorithm
 * difficult to nail down the time complexity because it will depend on the gap. worst case square(n)
 * but it can perform much better than that
 * doesn't require as much shifting as insertion sort, so it usually performs better
 * unstable algorithm
 */
public class ShellSort {
    public static void main(String[] args) {
        final int[] array = new int[]{20, 35, -15, 7, 55, 1, -22};
        ArrayPrintable.printArray(array);
        System.out.println();

        asc(array);

        ArrayPrintable.printArray(array);
        System.out.println();

        desc(array);

        ArrayPrintable.printArray(array);
        System.out.println();

    }

    private static void desc(final int[] array) {
        for (var gap = array.length / 2; gap > 0; gap /= 2) {
            for (var i = gap; i < array.length; i++) {
                var newElement = array[i];
                var j = i;

                while (j >= gap && array[j - gap] < newElement) {
                    array[j] = array[j - gap];
                    j -= gap;
                }

                array[j] = newElement;
            }
        }
    }

    private static void asc(final int[] array) {
        for (var gap = array.length / 2; gap > 0; gap /= 2) {
            for (var i = gap; i < array.length; i++) {
                var newElement = array[i];
                var j = i;

                while (j >= gap && array[j - gap] > newElement) {
                    array[j] = array[j - gap];
                    j -= gap;
                }

                array[j] = newElement;
            }

        }
    }
}
