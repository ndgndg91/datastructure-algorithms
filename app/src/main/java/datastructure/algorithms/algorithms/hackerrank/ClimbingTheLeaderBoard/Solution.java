package datastructure.algorithms.algorithms.hackerrank.ClimbingTheLeaderBoard;

import java.io.*;
import java.util.*;

public class Solution {

    // Complete the climbingLeaderboard function below.
    @SuppressWarnings("Duplicates")
    static int[] climbingLeaderboard(int[] scores, int[] alice) {
        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i < scores.length; i++){
            hs.add(scores[i]);
        }
        Integer[] arr = new Integer[hs.size()];
        arr = hs.toArray(arr);
        Arrays.sort(arr, Comparator.reverseOrder());

        int[] aliceRanks = new int[alice.length];
        for (int i = 0; i < alice.length; i++) {
            aliceRanks[i] = getRank(alice[i], arr, 0, arr.length);
            System.out.println(aliceRanks[i]);
        }
        return aliceRanks;
    }

    static int getRank(int aliceScore, Integer[] leaderBoard, int start, int end) {
        int half = (start + end)/2;
        if (start >= leaderBoard.length)
            return leaderBoard.length+1;
        if (end < start)
            return start+1;
        if (aliceScore > leaderBoard[half]) {
            return getRank(aliceScore, leaderBoard, start, half-1);
        } else if (aliceScore < leaderBoard[half]) {
            return getRank(aliceScore, leaderBoard, half+1, end);
        } else {
            return half+1;
        }
    }

    @SuppressWarnings("Duplicates")
    static int[] timeOut(int[] scores, int[] alice) {
        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i < scores.length; i++){
            hs.add(scores[i]);
        }
        Integer[] arr = new Integer[hs.size()];
        arr = hs.toArray(arr);
        Arrays.sort(arr, Comparator.reverseOrder());

        int[] aliceRanks = new int[alice.length];
        for (int i = 0; i < alice.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if(alice[i] > arr[j]) {
                    aliceRanks[i] = j + 1;
                    break;
                } else if (alice[i] == arr[j]) {
                    aliceRanks[i] = j + 1;
                    break;
                }
            }
            if (aliceRanks[i] == 0)
                aliceRanks[i] = arr.length+1;
        }
        for (int i : aliceRanks) {
            System.out.println(i);
        }
        return aliceRanks;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int scoresCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] scores = new int[scoresCount];

        String[] scoresItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < scoresCount; i++) {
            int scoresItem = Integer.parseInt(scoresItems[i]);
            scores[i] = scoresItem;
        }

        int aliceCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] alice = new int[aliceCount];

        String[] aliceItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < aliceCount; i++) {
            int aliceItem = Integer.parseInt(aliceItems[i]);
            alice[i] = aliceItem;
        }

        int[] result = timeOut(scores, alice);

        scanner.close();
    }
}
