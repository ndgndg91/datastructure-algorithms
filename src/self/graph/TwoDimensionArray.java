package self.graph;

import java.util.logging.Logger;

public class TwoDimensionArray {

    private static final Logger logger = Logger.getGlobal();

    public static void main(String[] args) {
        final var twoDimensionArray = new TwoDimensionArray();
        twoDimensionArray.solution(new int[][]{
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        });
    }

    int solution(int[][] t) {
        return 0;
    }
}
