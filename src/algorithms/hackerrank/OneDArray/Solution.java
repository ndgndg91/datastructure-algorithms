package algorithms.hackerrank.OneDArray;

import java.util.*;

public class Solution {

    public static boolean canWin(int leap, int[] game, int currPosition) {
        // Return true if you can win the game; otherwise, return false.
        if ( currPosition + leap >= game.length || currPosition == game.length-1) return true;
        if ( currPosition < 0 || game[currPosition] == 1) return false;
        game[currPosition] = 1;
        return canWin(leap, game, currPosition+1) || canWin(leap, game, currPosition-1) || canWin(leap, game, currPosition+leap);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        while (q-- > 0) {
            int n = scan.nextInt();
            int leap = scan.nextInt();

            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }

            System.out.println( (canWin(leap, game, 0)) ? "YES" : "NO" );
        }
        scan.close();
    }
}