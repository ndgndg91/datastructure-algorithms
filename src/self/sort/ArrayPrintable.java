package self.sort;

public interface ArrayPrintable {
    static void printArray(final int[] array) {
        for (var value : array) {
            System.out.print(value + "\t");
        }
    }
}
