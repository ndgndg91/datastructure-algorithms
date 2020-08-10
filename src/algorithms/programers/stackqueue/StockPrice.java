package algorithms.programers.stackqueue;


public class StockPrice {

    private static final int[] TEST1 = {1,2,3,2,3};
    private static final int[] RESULT1 = {4,3,1,1,0};

//    입출력 예 설명
//    1초 시점의 ₩1은 끝까지 가격이 떨어지지 않았습니다.
//    2초 시점의 ₩2은 끝까지 가격이 떨어지지 않았습니다.
//    3초 시점의 ₩3은 1초뒤에 가격이 떨어집니다. 따라서 1초간 가격이 떨어지지 않은 것으로 봅니다.
//    4초 시점의 ₩2은 1초간 가격이 떨어지지 않았습니다.
//    5초 시점의 ₩3은 0초간 가격이 떨어지지 않았습니다.

    public static void main(String[] args) {
        int[] solution = solution(TEST1);

        for (int i : solution) {
            System.out.println(i);
        }
    }

    private static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        int seconds = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i+1; j < prices.length; j++) {
                if (prices[i] <= prices[j]) seconds++;
                else if (prices[i] > prices[j]) {
                    seconds++;
                    break;
                }
            }

            answer[i] = seconds;
            seconds = 0;
        }

        return answer;
    }

}
