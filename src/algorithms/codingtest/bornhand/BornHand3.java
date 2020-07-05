package algorithms.codingtest.bornhand;

class BornHand3
{
    @SuppressWarnings("Duplicates")
    public int solution(int [][]board)
    {
        int max = 0;
        if(board.length < 2 && board[0].length < 2){
            for(int i=0; i<board.length; i++){
                for(int j=0; j<board[0].length; j++){
                    max = Math.max(max, board[i][j]);
                }
            }
        }else{
            for(int i = 1 ; i < board.length ; i++){
                for(int j = 1;  j < board[0].length ; j++) {
                    if(board[i][j] == 1 ){
                        board[i][j] = Math.min(Math.min(board[i - 1][j],
                                board[i][j - 1]), board[i - 1][j - 1]) + 1;
                        max = Math.max(max, board[i][j]);
                    }
                }
            }
        }
        return max*max;
    }
}