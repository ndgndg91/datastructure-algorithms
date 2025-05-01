package datastructure.algorithms.algorithms.neetcode;

public class ValidSudoku {
    public static void main(String[] args) {
        var result = new ValidSudoku().isValidSudoku(new char[][]{
                {'1', '2', '.', '.', '3', '.', '.', '.', '.'},
                {'4', '.', '.', '5', '.', '.', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '.', '3'},
                {'5', '.', '.', '.', '6', '.', '.', '.', '4'},
                {'.', '.', '.', '8', '.', '3', '.', '.', '5'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '.', '.', '.', '.', '.', '2', '.', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '8'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        });
        System.out.println(result);

        // 00 01 02
        // 10 11 12
        // 20 21 22

        var result2 = new ValidSudoku().isValidSudoku(new char[][]{
                {'1', '2', '.', '.', '3', '.', '.', '.', '.'},
                {'4', '.', '.', '5', '.', '.', '.', '.', '.'},
                {'.', '9', '1', '.', '.', '.', '.', '.', '3'},
                {'5', '.', '.', '.', '6', '.', '.', '.', '4'},
                {'.', '.', '.', '8', '.', '3', '.', '.', '5'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '.', '.', '.', '.', '.', '2', '.', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '8'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        });
        System.out.println(result2);
    }

    public boolean isValidSudoku(char[][] board) {
        for (var i = 0; i < board.length; i++) {
            var horizontal = new int[10];
            var vertical = new int[10];
            for (var j = 0; j < board[i].length; j++) {
                if (board[i][j] == '.') continue;
                if (horizontal[Integer.parseInt(String.valueOf(board[i][j]))] == 0) {
                    horizontal[Integer.parseInt(String.valueOf(board[i][j]))] = 1;
                } else {
                    return false;
                }
            }

            for (var k = 0; k < board[i].length; k++) {
                if (board[k][i] == '.') continue;
                if (vertical[Integer.parseInt(String.valueOf(board[k][i]))] == 0) {
                    vertical[Integer.parseInt(String.valueOf(board[k][i]))] = 1;
                } else {
                    return false;
                }
            }
        }

        for (int row = 0; row < 9; row += 3) {
            for (int col = 0; col < 9; col += 3) {
                int[] square = new int[10];
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        char ch = board[row + i][col + j];
                        if (ch == '.') continue;
                        int num = ch - '0';
                        if (square[num] == 1) return false;
                        square[num] = 1;
                    }
                }
            }
        }
        return true;
    }
}
