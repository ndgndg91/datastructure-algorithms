package datastructure.algorithms.algorithms.programers.bruteforcesearch;

import java.util.*;
class MockExam {
    public int[] solution(int[] answers) {
        int[] scores = new int[3];
        int[][] mathGiveUp = {
                {1,2,3,4,5},
                {2,1,2,3,2,4,2,5},
                {3,3,1,1,2,2,4,4,5,5}
        };
        for ( int i = 0; i < answers.length; i++) {
            int _1type = i % 5;
            int _2type = i % 8;
            int _3type = i % 10;
            if (answers[i] == mathGiveUp[0][_1type]) scores[0]++;
            if (answers[i] == mathGiveUp[1][_2type]) scores[1]++;
            if (answers[i] == mathGiveUp[2][_3type]) scores[2]++;
        }
        int maxScore = Math.max(scores[0],Math.max(scores[1], scores[2]));
        ArrayList<Integer> results = new ArrayList<>();
        if (maxScore == scores[0]) results.add(1);
        if (maxScore == scores[1]) results.add(2);
        if (maxScore == scores[2]) results.add(3);
        int[] result = new int[results.size()];
        for (int i = 0; i < results.size(); i++) {
            result[i] = results.get(i);
        }
        return result;
    }
}