package datastructure.algorithms.algorithms.codingtest.crema;

import java.io.*;
import java.util.*;
import java.util.stream.*;

import static java.util.stream.Collectors.toList;


public class Crema4 {
    /*
     * Complete the 'getTimes' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY time
     *  2. INTEGER_ARRAY direction
     */
    @SuppressWarnings("Duplicates")
    static List<Integer> getTimes(List<Integer> time, List<Integer> direction) {
        // Write your code here
        Integer[] arr = new Integer[time.size()];
        Queue<Integer> exit = new LinkedList<>();
        Queue<Integer> enter = new LinkedList<>();
        boolean isBeforeUsed = false;
        boolean isExit = false;
        boolean isEnter = false;
        int peopleCnt = time.size();
        int second = 0;
        int startIdx = 0;
        while (peopleCnt > 0) {
            for (int i = startIdx; i < time.size(); i++) {
                if (time.get(i) == second)
                    if (direction.get(i) == 0) { // enter
                        enter.offer(i);
                    } else { // exit
                        exit.offer(i);
                    }
                else {
                    startIdx = i;
                    break;
                }
            }
            if (exit.isEmpty() && enter.isEmpty()) {
                isBeforeUsed = false;
                second++;
                continue;
            }
            if (!isBeforeUsed) {
                if (!exit.isEmpty()) {
                    arr[exit.poll()] = second;
                    isBeforeUsed = true;
                    isExit = true;
                    isEnter = false;
                    peopleCnt--;
                    second++;
                } else {
                    arr[enter.poll()] = second;
                    isBeforeUsed = true;
                    isExit = false;
                    isEnter = true;
                    peopleCnt--;
                    second++;
                }
            } else {
                if (isEnter) {
                    if (!enter.isEmpty()) {
                        arr[enter.poll()] = second;
                        isBeforeUsed = true;
                        isExit = false;
                        isEnter = true;
                        peopleCnt--;
                        second++;
                    } else {
                        arr[exit.poll()] = second;
                        isBeforeUsed = true;
                        isExit = true;
                        isEnter = false;
                        peopleCnt--;
                        second++;
                    }
                }
                if (isExit) {
                    if (!exit.isEmpty()) {
                        arr[exit.poll()] = second;
                        isBeforeUsed = true;
                        isExit = true;
                        isEnter = false;
                        peopleCnt--;
                        second++;
                    } else {
                        if (!enter.isEmpty()) {
                            arr[enter.poll()] = second;
                            isBeforeUsed = true;
                            isExit = false;
                            isEnter = true;
                            peopleCnt--;
                            second++;
                        }
                    }
                }
            }
        }
        return new ArrayList<>(Arrays.asList(arr));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int timeCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> time = IntStream.range(0, timeCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        int directionCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> direction = IntStream.range(0, directionCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = getTimes(time, direction);
//        List<Integer> result = test(time, direction);

        for (Integer i : result)
            System.out.println(i);
        bufferedReader.close();
    }
}
