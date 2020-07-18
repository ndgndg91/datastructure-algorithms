package datastructure;

public class SystemArrayCopyTest {
    public static void main(String[] args) {
        int[] from = { 1, 2, 3, 4, 5};
        int[] to = new int[10];
        int[] to_2 = new int[10];
        System.arraycopy(from, 0 , to, 0 ,5);
        for (int value : to) {
            System.out.print(value + " ");
        }
        System.out.println();
        System.arraycopy(from,1, to_2, 1+1, 4);
        for (int value : to_2) {
            System.out.print(value + " ");
        }
    }
}
