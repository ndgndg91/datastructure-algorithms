package algorithms.programers.fullsearch;

import java.util.Arrays;

public class Carpet {
    private static final int brown = 10;
    private static final int yellow = 2;
    private static final int[] size = {4,3};

    private static final int brown2 = 8;
    private static final int yellow2 = 1;
    private static final int[] size2 = {3,3};

    private static final int brown3 = 24;
    private static final int yellow3 = 24;
    private static final int[] size3 = {8,6};

    public static void main(String[] args) {
        int[] solution = solution(14, 4);
        boolean equals = Arrays.equals(new int[]{6, 3}, solution);
        System.out.println(equals);
    }

    public static int[] solution(int brown, int yellow) {
        int yellowWidth = 0;
        int yellowHeight= 0;
        for (int height = yellow; height >= yellow/height; height--) {
            if ( yellow % height != 0) continue;
            if (((yellow/height) * 2) + (height * 2) + 4 == brown) {
                yellowWidth = height;
                yellowHeight = yellow/height;
                break;
            }
        }

        System.out.println(yellowWidth+2);
        System.out.println(yellowHeight+2);
        return new int[]{yellowWidth+2, yellowHeight+2};
    }

}
