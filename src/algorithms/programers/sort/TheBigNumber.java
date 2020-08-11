package algorithms.programers.sort;

import java.util.*;
import java.util.stream.Collectors;

public class TheBigNumber {

//    문제 설명
//    0 또는 양의 정수가 주어졌을 때, 정수를 이어 붙여 만들 수 있는 가장 큰 수를 알아내 주세요.

//    예를 들어, 주어진 정수가 [6, 10, 2]라면 [6102, 6210, 1062, 1026, 2610, 2106]를 만들 수 있고, 이중 가장 큰 수는 6210입니다.

//    0 또는 양의 정수가 담긴 배열 numbers가 매개변수로 주어질 때, 순서를 재배치하여 만들 수 있는 가장 큰 수를 문자열로 바꾸어 return 하도록 solution 함수를 작성해주세요.

//    제한 사항
//    numbers의 길이는 1 이상 100,000 이하입니다.
//    numbers의 원소는 0 이상 1,000 이하입니다.
//    정답이 너무 클 수 있으니 문자열로 바꾸어 return 합니다.
//    입출력 예
//    [6, 10, 2]	6210
//    [3, 30, 34, 5, 9]	9534330

    private static final int[] array = {6, 10, 2};
    private static final int[] array2 = {3, 30, 34, 5, 9};
    private static final int[] array3 = {0, 0, 0, 0};

    private static final int result = 6210;
    private static final int result2 = 9534330;

    public static void main(String[] args) {
        solution(array3);
    }

    private static void solution(int[] numbers) {

        List<Item> items = Arrays.stream(numbers).mapToObj(Item::new).sorted().collect(Collectors.toList());
        String bigNumber = items.stream().map(i -> i.value).map(String::valueOf).collect(Collectors.joining());
        System.out.println(bigNumber);

        if (bigNumber.startsWith("0")) {
        }
    }

    private static class Item implements Comparable<Item>{
        final String value;

        Item(int value) {
            this.value = String.valueOf(value);
        }

        @Override
        public int compareTo(Item item) {
            return (item.value + this.value).compareTo(this.value + item.value);
        }
    }

}
