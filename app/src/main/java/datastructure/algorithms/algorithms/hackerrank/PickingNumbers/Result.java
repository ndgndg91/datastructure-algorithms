package datastructure.algorithms.algorithms.hackerrank.PickingNumbers;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'pickingNumbers' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static int pickingNumbers(List<Integer> a) {
        // Write your code here
        Integer[] list = new Integer[a.size()];
        int idx = 0;
        for (int i = 0; i < a.size(); i++) {
            int cnt = 1;
            int plusOne = 0;
            int minusOne = 0;
            for (int j = 0; j < a.size(); j++) {
                if ( i == j)
                    continue;
                int tempDiff = a.get(i) - a.get(j);
                if (tempDiff == 0)
                    cnt++;
                if (tempDiff == 1)
                    plusOne++;
                if (tempDiff == -1)
                    minusOne++;
            }
            list[idx++] = cnt + Math.max(plusOne, minusOne);
        }
        Arrays.sort(list, Collections.reverseOrder());
        return list[0];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.pickingNumbers(a);
        System.out.println(result);

        bufferedReader.close();
    }

}


