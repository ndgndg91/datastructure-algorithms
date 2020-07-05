package algorithms.baekjoon;

public class NotAllowDupli {
    private static boolean[] visited = new boolean[26];
    private static String[] alpha = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K",
                                "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U",
                                "V", "W", "X", "Y", "Z"};
    private static int cnt = 0;
    private static String[] hobby = new String[10];
    public static void main(String[] args) {
        DFS();
        System.out.println(cnt);
    }

    private static void makeForwardVisited(int idx, boolean[] arr) {
        for (int i = idx; i > -1; i--) {
            arr[i] = true;
        }
    }

    private static void DFS() {
        for (int i = 0; i < alpha.length; i++) {
            makeForwardVisited(i, visited);
            DFS(i, 0);
            visited[i] = false;
        }
    }

    private static void DFS(int index, int depth) {
//        hobby[depth] = alpha[index];
        if (depth == 9) {
//            for (String s : hobby)
//                System.out.print(s + " ");
            cnt++;
//            System.out.println();
        } else {
            for (int i = index; i < alpha.length; i++) {
                if (visited[i])
                    continue;
                visited[i] = true;
                DFS(i, depth + 1);
                visited[i] = false;
            }
        }
    }
}
