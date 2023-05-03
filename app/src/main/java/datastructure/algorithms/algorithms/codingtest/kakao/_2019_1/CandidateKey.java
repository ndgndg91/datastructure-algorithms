package datastructure.algorithms.algorithms.codingtest.kakao._2019_1;

import java.util.ArrayList;

public class CandidateKey {
    private static boolean tf;
    private static ArrayList<Integer> columns;

    static class Column {
        int seq;
        String[] contents;
    }

    private static String[][] input = {
            {"100", "ryan", "music", "2"}
            , {"200", "apeach", "math", "2"}
            , {"300", "tube", "computer", "3"}
            , {"400", "con", "computer", "4"}
            , {"500", "muzi", "music", "3"}
            , {"600", "apeach", "music", "2"}
    };

    public static void main(String[] args) {
        solution(input);
    }

    public static int solution(String[][] relation) {
        columns = new ArrayList<>();
        boolean[] cols = new boolean[relation[0].length];
        int answer = 0;
        for (int i = 0; i < relation[0].length; i++) {
            String[] temp = new String[relation.length];
            for (int j = 0; j < relation.length; j++) {
                temp[j] = relation[j][i];
                System.out.print(relation[j][i] + " ");
            }
            boolean duplicate = checkCandidate(i, temp);
            System.out.println((i + 1) + " 번 째 컬럼은" + duplicate);
            if (!duplicate) {
                cols[i] = true;
                answer++;
            }
        }
        for (int i = 0; i < cols.length; i++) {
            if (cols[i])
                continue;
            cols[i] = true;
            DFS(i, 0, cols.length - 1, relation, cols);
            cols[i] = false;
        }
        return answer;
    }

    private static void DFS(int idx, int depth, int maxDepth, String[][] relation, boolean[] cols) {
        columns.add(idx);
        if (depth > maxDepth) {
            for (int i = 0; i < columns.size(); i++) {
                System.out.print(columns.get(i) + " ");
            }
            System.out.println();
            columns.clear();
            return;
        } else {
            for (int i = 0; i < relation[0].length; i++) {
                if (cols[i])
                    continue;
                cols[i] = true;
                DFS(i, depth + 1, maxDepth, relation, cols);
                cols[i] = false;
            }
        }

    }

    private static boolean checkCandidate(int idx, String[] arr) {
        boolean duplicate = false;
        for (int i = 0; i < arr.length; i++) {
            tf = false;
            goRecursive(arr[i], arr, i);
            if (tf) {
                duplicate = true;
                break;
            }
        }
        return duplicate;
    }

    private static void goRecursive(String str, String[] arr, int idx) {
        if (idx == arr.length - 1) {
            tf = false;
            return;
        } else {
            if (str.equals(arr[idx + 1])) {
                System.out.println("중복이네");
                tf = true;
                return;
            } else {
                goRecursive(str, arr, idx + 1);
            }
        }
    }
}
