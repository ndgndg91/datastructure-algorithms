package self.binarysearch;

public class BinarySearch {

    private static final int[] PRIMES = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37,
            41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97};

    public static void main(String[] args) {
        int result = doSearch(PRIMES, 73);
        System.out.println("Found prime at index " + result);
        assert result == 20;

        int notFound = doSearch(PRIMES, 100);
        System.out.println("Found prime at index " + notFound);
        assert notFound == 20;
    }

    /**
     * Returns either the index of the location in the array,
     * or -1 if the array did not contain the targetValue
     */
    private static int doSearch(int[] array, int targetValue){
        int l = 0;
        int r = array.length - 1;
        int guess = 0;
        while (l <= r) {
            int mid = (l + r) >>> 1;
            guess = array[mid];

            if (guess == targetValue) return mid;

            if (guess < targetValue) l = mid+1;
            if (guess > targetValue) r = mid-1;

        }

        return -1;
    }
}
