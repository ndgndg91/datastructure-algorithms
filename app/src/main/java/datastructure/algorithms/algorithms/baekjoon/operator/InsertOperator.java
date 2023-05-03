package datastructure.algorithms.algorithms.baekjoon.operator;

import java.util.HashSet;
import java.util.Iterator;

public class InsertOperator {
    private static int[] number = {1, 2, 3, 4, 5, 6};
    private static String[] operator = {"+","-","*","/","+"};
    private static boolean[] visit = new boolean[5];
    private static String[] result = new String[5];
    private static int count = 0;

    private static int maxVal = 0;
    private static int minVal = 0;

    private static HashSet<Integer> afterCal = new HashSet<>();
    @SuppressWarnings("Duplicates")
    public static void main(String[] args){
        for (int i = 0; i < operator.length; i++) {
            visit[i] = true;
            DFS(operator, visit, operator.length, operator[i], 0);
            visit[i] = false;
        }
//        System.out.println(afterCal.size());

        Iterator iterator = afterCal.iterator();
        while (iterator.hasNext()){
            int thisVal = (Integer) iterator.next();
            if(minVal > thisVal){
                minVal = thisVal;
            }
            if(maxVal < thisVal){
                maxVal = thisVal;
            }
            System.out.println(thisVal);
        }

        System.out.println("최대값 : " + maxVal);
        System.out.println("최소값 : " + minVal);
    }
    @SuppressWarnings("Duplicates")
    public static void DFS(String[] op, boolean[] visited, int N, String start, int depth) {
        result[depth] = start;
        if (depth == N - 1) {
            int calculated = 0;
            for (int i = 0; i < N; i++){
                if ( i == 0){
                     calculated = number[0];
                } else {
                    switch (result[i]){
                        case "+":
                            calculated += number[i+1];
                            break;
                        case "-":
                            calculated -= number[i+1];
                            break;
                        case "*":
                            calculated *= number[i+1];
                            break;
                        case "/":
                            calculated /= number[i+1];
                            break;
                    }
                }
                System.out.print(result[i] + " ");
            }
            afterCal.add(calculated);
            System.out.println();
            return;
        }
        for (int i = 0; i < N; i++) {
            if (visited[i])
                continue;
            visited[i] = true;
            DFS(op, visited, N, op[i], depth + 1);
            visited[i] = false;
        }
    }

}
