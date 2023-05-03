package datastructure.algorithms.algorithms.hackerrank;

import javax.management.Query;
import java.util.LinkedList;
import java.util.Queue;

public class Test4 {
    public static void main(String[] args) {
        int[][] testCase1 = {
                {0,1,1,1},
                {1,1,1,1},
                {1,1,1,1},
                {0,0,1,0}
        };
        int[][] testCase2 = {
                {0,0,1,1},
                {1,1,1,1}
        };
        int[][] testCase3 = {
                {0,1,1,1},
                {0,1,1,1},
                {0,1,1,1},
                {0,1,1,1}
        };
        int result = solution(testCase1);
        System.out.println(result);
    }

    public static int solution(int[][] board)
    {
        int max = 0;
        for(int i = 1 ; i < board.length ; i++){
            for(int j = 1;  j < board[0].length ; j++) {
                if(board[i][j] == 1 ){
                    board[i][j] = Math.min(Math.min(board[i - 1][j], board[i][j - 1]), board[i - 1][j - 1]) + 1;
                    max = Math.max(max, board[i][j]);
                }
                System.out.print(board[i][j] +" ");
            }
            System.out.println();
        }
        return max*max;
    }


}
