package algorithms.programers.skilltest3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Operation {

//    문제 설명
//    이중 우선순위 큐는 다음 연산을 할 수 있는 자료구조를 말합니다.
//
//    명령어	수신 탑(높이)
//    I 숫자	큐에 주어진 숫자를 삽입합니다.
//    D 1	큐에서 최댓값을 삭제합니다.
//            D -1	큐에서 최솟값을 삭제합니다.
//    이중 우선순위 큐가 할 연산 operations가 매개변수로 주어질 때, 모든 연산을 처리한 후 큐가 비어있으면 [0,0] 비어있지 않으면 [최댓값, 최솟값]을 return 하도록 solution 함수를 구현해주세요.
//
//    제한사항
//    operations는 길이가 1 이상 1,000,000 이하인 문자열 배열입니다.
//    operations의 원소는 큐가 수행할 연산을 나타냅니다.
//    원소는 “명령어 데이터” 형식으로 주어집니다.- 최댓값/최솟값을 삭제하는 연산에서 최댓값/최솟값이 둘 이상인 경우, 하나만 삭제합니다.
//    빈 큐에 데이터를 삭제하라는 연산이 주어질 경우, 해당 연산은 무시합니다.
//            입출력 예
//    operations	return
//            [I 16,D 1]	[0,0]
//            [I 7,I 5,I -5,D -1]	[7,5]
//    입출력 예 설명
//    16을 삽입 후 최댓값을 삭제합니다. 비어있으므로 [0,0]을 반환합니다.
//    7,5,-5를 삽입 후 최솟값을 삭제합니다. 최대값 7, 최소값 5를 반환합니다

    public static void main(String[] args) {
        int[] solution = solution(new String[]{"I 16", "D 1"});
        Arrays.stream(solution).forEach(s -> System.out.print(s+"\t"));

        System.out.println();
        int[] solution2 = solution(new String[]{"I 7","I 5","I -5","D -1"});
        Arrays.stream(solution2).forEach(s -> System.out.print(s+"\t"));
    }

    private static int[] solution(String[] operations) {
        var commands = Arrays.stream(operations).map(s -> {
            String[] split = s.split(" ");
            return new Command(split[0], Integer.parseInt(split[1]));
        }).collect(Collectors.toList());

        List<Integer> results = new ArrayList<>();
        for (var command : commands) {
            if (command.type == Command.Type.I) {
                results.add(command.value);
            }

            if (command.type == Command.Type.D) {
                if (command.value == -1) {
                    Integer min = Collections.min(results);
                    results.remove(min);
                }

                if (command.value == 1) {
                    Integer max = Collections.max(results);
                    results.remove(max);
                }

                if (command.value > 1) {
                    results.add(command.value);
                }
            }
        }

        if (results.isEmpty()) return new int[]{0,0};
        return new int[]{Collections.max(results), Collections.min(results)};
    }

    static class Command {
        private enum Type {
            I,
            D;
        }

        private final Type type;
        private final int value;

        public Command(String type, int value) {
            this.type = Type.valueOf(type);
            this.value = value;
        }

        public Type getType() {
            return type;
        }

        public int getValue() {
            return value;
        }
    }
}
