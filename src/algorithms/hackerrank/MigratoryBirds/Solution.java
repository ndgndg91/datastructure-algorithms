package algorithms.hackerrank.MigratoryBirds;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

public class Solution {

    // Complete the migratoryBirds function below.
    static int migratoryBirds(List<Integer> arr) {
        int[] typeCnt = new int[5];
        for ( int i = 0; i < arr.size(); i++ ) {
            switch (arr.get(i)){
                case 1:
                    typeCnt[0]++;
                    break;
                case 2:
                    typeCnt[1]++;
                    break;
                case 3:
                    typeCnt[2]++;
                    break;
                case 4:
                    typeCnt[3]++;
                    break;
                case 5:
                    typeCnt[4]++;
                    break;
            }
        }
        int maxType = 1;
        int maxCnt = typeCnt[0];
        for (int i = 1; i < typeCnt.length; i++) {
            if (maxCnt < typeCnt[i]) {
                maxCnt = typeCnt[i];
                maxType = i+1;
            }
        }
        return maxType;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = migratoryBirds(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
