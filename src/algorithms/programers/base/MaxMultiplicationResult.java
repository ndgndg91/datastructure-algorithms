package algorithms.programers.base;

import java.util.*;
import java.util.stream.Collectors;

public class MaxMultiplicationResult {

    public static void main(String[] args) {
        int[] test = test(10);
        int[] test1 = test(14);

        Arrays.stream(test).forEach(n -> System.out.print(n + "\t"));
        System.out.println();
        Arrays.stream(test1).forEach(n -> System.out.print(n + "\t"));
    }

    public static int[] test(int n){
        List<String> numbers = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            String num = Integer.toString(n, i);
            numbers.add(num);
        }

        List<Result> results = new ArrayList<>();
        for (int i = 0; i < numbers.size(); i++) {
            int multiplyResult = Arrays.stream(numbers.get(i).split(""))
                    .map(Integer::parseInt)
                    .filter(a -> a > 0)
                    .reduce(1, (b, c) -> b * c);
            Result result = new Result(i + 1, multiplyResult);
            results.add(result);
        }

        Map<Integer, List<Result>> grouping = results.stream().collect(Collectors.groupingBy(result -> result.result));
        Collections.sort(results);
        Result max = Collections.max(results);

        List<Result> maxResults = grouping.get(max.result);
        int result = max.result;
        int base = maxResults.stream().mapToInt(r -> r.base).max().orElseThrow();
        return new int[]{base, result};
    }

    static class Result implements Comparable<Result>{
        Integer base;
        Integer result;

        Result(int base, int result){
            this.base = base;
            this.result = result;
        }

        @Override
        public int compareTo(Result result) {
            if (this.result == result.result) return 0;
            return this.result > result.result ? 1 : -1;
        }

        @Override
        public String toString() {
            return new StringJoiner(", ", Result.class.getSimpleName() + "[", "]")
                    .add("base=" + base)
                    .add("result=" + result)
                    .toString();
        }
    }
}
