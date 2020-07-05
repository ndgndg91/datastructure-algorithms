package algorithms.baekjoon;

import java.util.Stack;

public class Combination {

    private static int[] case1 = {1, 2, 3, 4};
    private static boolean[] visited = new boolean[case1.length];
    private static int[] results = new int[case1.length];

    private static Stack<Integer> sResults = new Stack<>();
    public static void main(String[] args){
        DFS();
    }

    private static void DFS(){
        for(int i = 0; i < case1.length; i++){
            visited[i] = true;
            DFS(case1[i], 1);
            visited[i] = false;
        }
    }

    private static void DFS(int picked, int depth){
        results[depth - 1] = picked;
        if (depth == 4) {
            for (int i = 0; i < results.length; i++){
                System.out.print(results[i] + " ");
            }
            System.out.println();
        } else {
            for (int i = 0; i < case1.length; i++){
                if (visited[i])
                    continue;
                visited[i] = true;
                DFS(case1[i], depth+1);
                visited[i] = false;
            }
        }
    }

}
