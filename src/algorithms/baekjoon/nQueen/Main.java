package algorithms.baekjoon.nQueen;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static int numberOfCase = 0;

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int N = scn.nextInt();
        int[][] nXn = new int[N][N];
        QueenNode[] queenNodes = new QueenNode[N];

        batchQueen(N, nXn, queenNodes);
        System.out.println(numberOfCase);
    }

    private static void batchQueen(int N, int[][] nXn, QueenNode[] queens) {
        for (int i = 0; i < N; i++) {
            queens[0] = new QueenNode(0, i);
            DFS(1, queens, nXn);
        }
    }

    private static void DFS(int depth, QueenNode[] queens, int[][] nXn) {
        if (depth == nXn.length) {
            numberOfCase++;
//            for (int i = 0; i < queens.length; i++) {
//                System.out.print(queens[i].y + "," + queens[i].x + " ");
//            }
//            System.out.println();
        } else {
            for (int j = 0; j < nXn.length; j++) {
                if (isPossible(depth, j, queens)) {
                    queens[depth] = new QueenNode(depth, j);
                    DFS(depth + 1, queens, nXn);
                }
            }

        }
    }

    private static boolean isPossible(int y, int x, QueenNode[] queens) {
        for (int i = 0; i < y; i++) {
            if (queens[i].y == y || queens[i].x == x || Math.abs(y - queens[i].y) == Math.abs(x - queens[i].x)) {
                return false;
            }
        }
        return true;
    }
}

class QueenNode {
    int y;
    int x;

    public QueenNode(int y, int x) {
        this.y = y;
        this.x = x;
    }
}
