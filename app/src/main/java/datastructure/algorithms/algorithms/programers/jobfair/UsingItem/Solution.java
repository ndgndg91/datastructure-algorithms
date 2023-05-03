package datastructure.algorithms.algorithms.programers.jobfair.UsingItem;

import java.util.ArrayList;
class Solution {
    @SuppressWarnings("Duplicates")
    public int[] solution(int[] healths, int[][] items) {
        boolean[] isUsed = new boolean[items.length];
        boolean[] isDiff = new boolean[healths.length];
        for (int i = 0; i < healths.length; i++) {
            for (int j = 0; j < items.length; j++) {
                if (healths[i] - items[j][1] >= 100 && !isUsed[j] && !isDiff[i]) {
                    isUsed[j] = true;
                    isDiff[i] = true;
                }
            }
        }
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < isUsed.length; i++) {
            if (isUsed[i]) {
                arr.add(i+1);
            }
        }
        int[] answer = new int[arr.size()];
        for (int i = 0; i <arr.size(); i++) {
            answer[i] = arr.get(i);
        }
        return answer;
    }
}
