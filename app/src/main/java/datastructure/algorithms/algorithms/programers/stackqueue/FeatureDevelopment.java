package datastructure.algorithms.algorithms.programers.stackqueue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FeatureDevelopment {
    private static final int[] progresses = {93, 30, 55};
    private static final int[] speeds = {1, 30, 5};
    private static final int[] result = {2,1};

    public static void main(String[] args) {
        int[] solution = solution(progresses, speeds);
        for (int i : solution) {
            System.out.println(i);
        }
    }

    private static int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> features = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++) {
            features.add((100 - progresses[i]) % speeds[i] == 0 ?
                (100 - progresses[i]) / speeds[i] :
                (100 - progresses[i]) / speeds[i] + 1);
        }

        List<Integer> deploys = new ArrayList<>();
        int f = features.poll();
        int deploy = 1;
        while (!features.isEmpty()) {
            int n = features.poll();
            if (f >= n) {
                deploy++;
            } else {
                deploys.add(deploy);
                deploy = 1;
                f = n;
            }
        }

        deploys.add(deploy);

        int[] answer = new int[deploys.size()];
        for (int i = 0; i < deploys.size(); i++) {
            answer[i] = deploys.get(i);
        }

        return answer;
    }
}
