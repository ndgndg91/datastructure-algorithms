package dataStructure;

public class SystemArrayCopyTest {
    public static void main(String[] args) {
        int[] from = { 1, 2, 3, 4, 5};
        int[] to = new int[10];
        System.arraycopy(from, 0 , to, 0 ,5);
        for (int i = 0; i < from.length; i ++) {
            System.out.print(from[i] +" ");
        }
        System.out.println();
        for (int i = 0; i < to.length; i++) {
            System.out.print(to[i] + " ");
        }
        System.out.println();
    }
}
