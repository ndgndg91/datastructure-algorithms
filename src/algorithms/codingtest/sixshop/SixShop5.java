package algorithms.codingtest.sixshop;

import java.util.ArrayList;
import java.util.List;

public class SixShop5 {
    static int N;
    static long ans = 0;
    static boolean[][] arr;
    static boolean[] visit;

    //2 1 2
    //2 3 4
    static long solve(int n, List<Integer> a, List<Integer> b) {
        N = n;

        arr = new boolean[N + 1][N + 1];
        visit = new boolean[N + 1];

        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= N; j++) {
                arr[i][j] = true;
            }
        }

        for (int i = 0; i < a.size(); i++) {
            arr[a.get(i)][b.get(i)] = false;
            arr[b.get(i)][a.get(i)] = false;
        }

        for (int i = 0; i <= N; i++) {
            arr[i][i] = false;
        }

        for (int i = 1; i <= N; i++) { // bfs 도는 애들
            visit = new boolean[N + 1];
            visit[i] = true;
            bfs(i, i, i+"");
        }
        return ans;
    }

    static void bfs(int sn, int n, String s) {
        ans++;
        System.out.println(s);
        if (n >= N) {
            return;
        }

        if (check(sn, n + 1) && !visit[n + 1]) {
            visit[n + 1] = true;
            bfs(sn, n + 1, s + "," + (n + 1));
            visit[n + 1] = false;
        } else {
            return;
        }

    }

    static boolean check(int sn, int n) {
        for (int i = sn; i < n; i++) {
            if (!arr[i][n]) {
                return false;
            }
        }

        return true;
    }
    static long num = 0;
    static long angryAnimal(int n, List<Integer> a, List<Integer> b) {
        boolean[][] standard = new boolean[n+1][n+1];
        int small = 0;
        int big = 0;
        for (int i = 0; i < a.size(); i++ ){
            if (a.get(i).equals(b.get(i)))
                continue;
            if (a.get(i) > b.get(i)) {
                big = a.get(i);
                small = b.get(i);
            } else {
                big = b.get(i);
                small = a.get(i);
            }
            standard[small][big] = true;
        }
        for (int i = 1; i <= n; i++){
            getCnt(i, i, standard, n);
        }
        return num;
    }
    static void getCnt(int i, int mate, boolean[][] standard, int n){
        if (mate >= n+1)
            return;
        if (!standard[i][mate])
            num++;
        if (standard[i][mate])
            return;
        getCnt(i, mate+1, standard, n);
    }
    public static void main(String[] args) {
//        int cnt = 4;
//        int cnt = 5;
        int cnt = 7;
        ArrayList<Integer> listA = new ArrayList<>();
        ArrayList<Integer> listB = new ArrayList<>();
//        listA.add(2);
//        listA.add(1);
//        listA.add(2);
//        listB.add(2);
//        listB.add(3);
//        listB.add(4);

//        listA.add(2);
//        listA.add(1);
//        listA.add(2);
//        listB.add(2);
//        listB.add(3);
//        listB.add(5);

        listA.add(1);
        listA.add(2);
        listA.add(4);
        listA.add(2);
        listA.add(6);

        listB.add(4);
        listB.add(5);
        listB.add(7);
        listB.add(3);
        listB.add(7);

//        long result = solve(cnt, listA, listB);
        long result = angryAnimal(cnt, listA, listB);
        System.out.println(result);

    }
}
