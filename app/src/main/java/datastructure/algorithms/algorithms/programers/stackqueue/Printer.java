package datastructure.algorithms.algorithms.programers.stackqueue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.StringJoiner;

public class Printer {
//        1. 인쇄 대기목록의 가장 앞에 있는 문서(J)를 대기목록에서 꺼냅니다.
//        2. 나머지 인쇄 대기목록에서 J보다 중요도가 높은 문서가 한 개라도 존재하면 J를 대기목록의 가장 마지막에 넣습니다.
//        3. 그렇지 않으면 J를 인쇄합니다.

    private static final int[] priorities = {2, 1, 3, 2};
    private static final int location = 2;
    private static final int result = 1;

    private static final int[] priorities2 = {1, 1, 9, 1, 1, 1};
    private static final int location2 = 0;
    private static final int result2 = 5;

    public static void main(String[] args) {
        int solution = solution(priorities, location);
        System.out.println(solution);
        System.out.println(solution == result);

        int solution2 = solution(priorities2, location2);
        System.out.println(solution2);
        System.out.println(solution2 == result2);
    }

    private static int solution(int[] priorities, int location) {
        Stack<PrintTarget> stack = new Stack<>();
        Queue<PrintTarget> queue = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            queue.add(new PrintTarget(priorities[i], i));
        }

        boolean goLast = false;
        List<PrintTarget> orderedTargets = new ArrayList<>();
        while (!queue.isEmpty()) {
            PrintTarget target = queue.poll();
            for (PrintTarget t : queue) {
                if (target.weight < t.weight) {
                    goLast = true;
                    stack.push(target);
                    break;
                }
            }

            while (!stack.isEmpty()) {
                queue.add(stack.pop());
            }

            if (!goLast) orderedTargets.add(target);
            else goLast = false;
        }

        int answer = 0;
        for (int i = 0; i < orderedTargets.size(); i++) {
            if (orderedTargets.get(i).index == location) {
                answer = i + 1;
                break;
            }
        }

        return answer;
    }

    private static class PrintTarget{
        final int weight;
        final int index;

        public PrintTarget(int weight, int index) {
            this.weight = weight;
            this.index = index;
        }

        @Override
        public String toString() {
            return new StringJoiner(", ", PrintTarget.class.getSimpleName() + "[", "]")
                .add("weight=" + weight)
                .add("index=" + index)
                .toString();
        }
    }
}
