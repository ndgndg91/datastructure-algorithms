package algorithms.codingtest.crema;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;


public class Crema2 {

    static int test(List<Integer> startingPos, List<Integer> speed){
        List<Double> priority = new ArrayList<>();
        for (int i = 0; i < startingPos.size(); i++) {
            priority.add(speed.get(i) / (double) startingPos.get(i));
        }
        for (double p : priority) {
            System.out.print(p + " ");
        }
        priority.sort(new Comparator<Double>() {
            @Override
            public int compare(Double o1, Double o2) {
                if (o1 == o2 )
                    return 0;
                return o1 < o2 ? 1 : -1;
            }
        });
        System.out.println();
        for (double p : priority) {
            System.out.print(p + " ");
        }
        System.out.println();
        for (int i = 0; i < priority.size(); i++) {
            System.out.println(1.0 / priority.get(i));
            if (1.0 / priority.get(i) < i+1)
                return i;
        }
        return startingPos.size();
    }
    public static int protectionTime(List<Integer> startingPos, List<Integer> speed) {
        int[] status = new int[startingPos.size()];
        int protectTime = 0;
        for (int i = 0; i < status.length; i++) {
            if (startingPos.get(i) == 1)
                status[i] = 1;
            else if (startingPos.get(i).equals(speed.get(i)))
                status[i] = 1;
            else{
                if (startingPos.get(i) % speed.get(i) == 0) {
                    status[i] = startingPos.get(i) / speed.get(i);
                } else {
                    status[i] = (startingPos.get(i) / speed.get(i)) + 1;
                }
            }
        }
        Arrays.sort(status);
        boolean failToProtect = true;
        for (int i = 0; i < status.length; i++) {
//            System.out.println(status[i] + " , " + status[i + 1]);
            System.out.println(status[i]);
            if (status[i] <= i) {
                protectTime = status[i];
                failToProtect = false;
                break;
            }
        }
        if (failToProtect)
            return startingPos.size();
        return protectTime;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int startingPosCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> startingPos = IntStream.range(0, startingPosCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        int speedCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> speed = IntStream.range(0, speedCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        int result = protectionTime(startingPos, speed);
//        int result = test(startingPos, speed);
        System.out.println("정답은?");
        System.out.println(result);
        bufferedReader.close();
    }
}
//3 4 3 1 3 3 2 1
//7 4 15 15 12 18 3 8 7 2 5 3 2 3 3 2