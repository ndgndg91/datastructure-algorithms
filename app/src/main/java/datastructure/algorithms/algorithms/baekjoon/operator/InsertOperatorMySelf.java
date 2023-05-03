package datastructure.algorithms.algorithms.baekjoon.operator;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

//+ - * /
public class InsertOperatorMySelf {
    private static int max = 0;
    private static int min = 0;
    private static int[] sequence;
    private static String[] operators;
    private static boolean[] isVisit;

    private static String[] resultOp;
    private static HashSet<Integer> resultSet = new HashSet<>();

    private static int[] resultArr = new int[2];

    private static int oIdx = 0;

    @SuppressWarnings("Duplicates")
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
//        System.out.print("수열의 개수 ? :");
        int numCnt = Integer.parseInt(scn.nextLine());
        String sequenceStr = scn.nextLine();
        String[] sequencesString = sequenceStr.split(" ");
        sequence = new int[sequencesString.length];
        for (int i = 0; i < numCnt; i++) {
            sequence[i] = Integer.parseInt(sequencesString[i]);
        }

//        System.out.println(sequence.length);
        operators = new String[sequence.length - 1];
        isVisit = new boolean[sequence.length - 1];
        resultOp = new String[sequence.length - 1];
//        System.out.println(operators.length);
//        System.out.println(isVisit.length);
//        System.out.print("연산자를 입력 하세요 : ");
        String operatorStr = scn.nextLine();
        String[] operatorsString = operatorStr.split(" ");

        insertOp("+", operators, Integer.parseInt(operatorsString[0]));
        insertOp("-", operators, Integer.parseInt(operatorsString[1]));
        insertOp("*", operators, Integer.parseInt(operatorsString[2]));
        insertOp("/", operators, Integer.parseInt(operatorsString[3]));

//        for (String s : operators) {
//            System.out.print(s + " ");
//        }
//        System.out.println();

        for (int i = 0; i < operators.length; i++) {
            isVisit[i] = true;
            DFS(operators, isVisit, operators[i], operators.length, 0);
            isVisit[i] = false;
        }


        if (operators.length > 1) {
            Iterator iterator = resultSet.iterator();
            int firstVal = (Integer) iterator.next();
            max = firstVal;
            min = firstVal;
            while (iterator.hasNext()) {
                int thisVal = (Integer) iterator.next();
                if (min > thisVal) {
                    min = thisVal;
                }
                if (max < thisVal) {
                    max = thisVal;
                }
//            System.out.println(thisVal);
            }

            System.out.println(max);
            System.out.println(min);
        } else {
            System.out.println(resultArr[0]);
            System.out.println(resultArr[1]);
        }


    }

    private static void insertOp(String type, String[] op, int time) {
        for (int i = 0; i < time; i++) {
            op[oIdx] = type;
            oIdx++;
        }
    }

    @SuppressWarnings("Duplicates")
    private static void DFS(String[] op, boolean[] visit, String start, int last, int depth) {
        resultOp[depth] = start;
        if (depth == last - 1) {
            int calculated = sequence[0];
            for (int i = 0; i < last; i++) {
                if (last == 1) {
                    switch (resultOp[i]) {
                        case "+":
                            calculated += sequence[i + 1];
                            break;
                        case "-":
                            calculated -= sequence[i + 1];
                            break;
                        case "*":
                            calculated *= sequence[i + 1];
                            break;
                        case "/":
                            calculated /= sequence[i + 1];
                            break;
                    }
                    resultArr[0] = calculated;
                    resultArr[1] = calculated;
                } else {
                    switch (resultOp[i]) {
                        case "+":
                            calculated += sequence[i + 1];
                            break;
                        case "-":
                            calculated -= sequence[i + 1];
                            break;
                        case "*":
                            calculated *= sequence[i + 1];
                            break;
                        case "/":
                            calculated /= sequence[i + 1];
                            break;
                    }
                }
//                System.out.print(resultOp[i] + " ");
            }
//            System.out.println(calculated);
            resultSet.add(calculated);
//            System.out.println();
        } else {
            for (int i = 0; i < last; i++) {
                if (visit[i])
                    continue;
                visit[i] = true;
                DFS(op, visit, op[i], last, depth + 1);
                visit[i] = false;
            }
        }
    }

}
