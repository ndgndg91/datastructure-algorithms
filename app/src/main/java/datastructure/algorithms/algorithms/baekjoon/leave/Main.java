package datastructure.algorithms.algorithms.baekjoon.leave;


import java.util.Scanner;

public class Main {
    private static int result = 0;
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int N = scn.nextInt();
        int[] takenTime = new int[N];
        int[] benefits = new int[N];
        for (int i = 0; i < N; i++) {
            takenTime[i] = scn.nextInt();
            benefits[i] = scn.nextInt();
        }
        scn.close();
        goRecursive(0, 0, N, takenTime, benefits);
        System.out.println(result);
    }

    private static void goRecursive(int depth, int benefit, int N, int[] takenTime, int[] benefits) {
        if (depth == N) {
            result = Math.max(result,benefit);
//            System.out.println(result);
            return;
        }

        goRecursive(depth + 1, benefit, N, takenTime, benefits);
        if (depth + takenTime[depth] <= N)
            goRecursive(depth + takenTime[depth], benefit + benefits[depth], N, takenTime, benefits);
    }
}

