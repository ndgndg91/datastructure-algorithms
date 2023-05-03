package datastructure.algorithms.algorithms.codingtest.kakao._2019_1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FailRate {
    private static int[] stages = {1,2,3,4,5,6,7,7,6,5,4,5,9,9,9,9,9,12,13,14,15,11,8,8,6,4,3,2,8,7,8};
    private static int N = 15;
    public static void main(String[] args) {
        int[] answer = solution(N, stages);
        for (int i = 0; i < answer.length; i++) {
            System.out.println(answer[i]);
        }
    }
    static class StageFailInfo implements Comparable<StageFailInfo> {
        double rate;
        int stage;
        public StageFailInfo(int stage, double rate) {
            this.stage = stage;
            this.rate = rate;
        }
        @Override
        public int compareTo(StageFailInfo o) {
            if (this.rate > o.rate) {
                return -1;
            } else if (this.rate < o.rate) {
                return 1;
            } else if (this.rate == o.rate) {
                if (this.stage < o.stage) {
                    return -1;
                } else if (this.stage > o.stage) {
                    return 1;
                }
            }
            return 0;
        }
    }
    public static int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        List<StageFailInfo> pq = new ArrayList<>();
        double reachCnt = stages.length;
        int stage = 0;
        while(stage < N){
            stage++;
            double notClear = 0;
            for ( int i = 0; i < stages.length; i++) {
                if(stages[i] == stage)
                    notClear++;
            }
            pq.add(new StageFailInfo(stage, notClear/reachCnt));
            reachCnt -= notClear;
        }
        Collections.sort(pq);
        for (int i = 0; i < pq.size(); i++) {
            answer[i] = pq.get(i).stage;
        }
        return answer;
    }
}
