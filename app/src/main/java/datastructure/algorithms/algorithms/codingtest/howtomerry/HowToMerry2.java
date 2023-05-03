package datastructure.algorithms.algorithms.codingtest.howtomerry;

public class HowToMerry2 {
    public static int solution(int[][] board) {
        int answer = 0;
        if(board.length < 2 && board[0].length < 2){
            for(int i=0; i<board.length; i++){
                for(int j=0; j<board[0].length; j++){
                    answer = Math.max(answer, board[i][j]);
                }
            }
        }else {
            for (int i = 0; i < board.length - 1; i++) {
                for (int j = 0; j < board[i].length - 1; j++) {
                    if (board[i][j] >= 1)
                    board[i + 1][j + 1] = Math.min(Math.min(board[i][j + 1], board[i + 1][j]), board[i][j]) + 1;
                }
            }
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    answer = Math.max(answer, board[i][j]);
                }
            }
        }
        return answer * answer;
    }
    public static void main(String[] args) {
        int[][] case1 = {
                {0, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {0, 0, 1, 0}
        };
        int result = solution(case1);
        System.out.println(result);
    }
    @SuppressWarnings("Duplicates")
    public int solution2(int [][]board)
    {
        int answer = 0;
        if(board.length < 2 && board[0].length < 2){
            for(int i=0; i<board.length; i++){
                for(int j=0; j<board[0].length; j++){
                    answer = Math.max(answer, board[i][j]);
                }
            }
        }else{
            for(int i = 1 ; i < board.length ; i++){
                for(int j = 1;  j < board[0].length ; j++) {
                    if(board[i][j] == 1 ){
                        board[i][j] = Math.min(Math.min(board[i - 1][j],
                                board[i][j - 1]), board[i - 1][j - 1]) + 1;
                        answer = Math.max(answer, board[i][j]);
                    }
                }
            }
        }
        return answer*answer;
    }
}
