package datastructure.algorithms.algorithms.programers.base;

public class SharePizza2 {

    public int solution(int n) {
        int pizzaPiece = 6;
        if (n % pizzaPiece == 0) {
            return n / pizzaPiece;
        }

        int pan = 1;
        while((pan * pizzaPiece) % n != 0) {
            pan++;
        }
        return pan;
    }
}
