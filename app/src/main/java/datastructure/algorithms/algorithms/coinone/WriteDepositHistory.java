package datastructure.algorithms.algorithms.coinone;

import java.util.ArrayList;
import java.util.List;

/**
 * 프로그래밍1: 입금내역 기록하기
 * 입금 내역만 표시되는 통장을 개설했습니다. 이 통장은 입금과 출금 모두 가능하지만, 거래 내역에는 입금 내용만 표시됩니다.
 * 이 통장에 입금 또는 출금을 할 때는 다음과 같은 규칙을 따릅니다.
 * 입금한 금액은 입금 순서대로 통장에 표시됩니다.
 * 입금 내용마다 나누어서 표시됩니다.
 * 출금할 때는 가장 마지막에 입금한 내용부터 하나씩 삭제하며 출금액을 맞춥니다.
 * 출금액을 맞춘 후 남은 액수를(1원 이상 남은 경우) 가장 마지막에 입금한 내역으로 추가합니다.
 * 예를 들어 입출금 내용이 다음과 같은 경우
 * [500원 입금, 1000원 입금, 300원 출금, 200원 입금, 400원 출금, 100원 입금, 100원 출금]
 * 통장에 기록되는 내용은 다음과 같습니다.
 * 제한사항
 * deposit의 길이는 1 이상 1,000 이하입니다.
 * deposit의 원소는 -1,000,000 이상 1,000,000 이하인 0이 아닌 정수입니다.
 * 양수는 입금 내용, 음수는 출금 내용을 나타냅니다.
 * 통장에 입금된 금액보다 큰 금액을 출금하는 경우는 없습니다.
 * 정답으로 return 하는 배열 길이가 1 이상인 경우만 입력으로 주어집니다.
 */
public class WriteDepositHistory {

    public int[] solution(int[] deposit) {
        var result = new ArrayList<Integer>();
        for (int d : deposit) {
            if (d > 0) {
                result.add(d);
            } else {
                withdraw(result, d);
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    private List<Integer> withdraw(List<Integer> results, int amount) {
        var lastAmount = results.get(results.size() - 1);
        var result =  lastAmount + amount;
        if (result == 0) {
            results.remove(results.size() - 1);
            return results;
        } else if (result > 0) {
            results.remove(results.size() - 1);
            results.add(result);
            return results;
        } else {
            results.remove(results.size() - 1);
            return withdraw(results, result);
        }
    }
}
