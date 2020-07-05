package algorithms.baekjoon.babyShark;

import java.util.*;

public class Main {
    static int[] dy = {-1, 0, 0, 1};
    static int[] dx = {0, -1, 1, 0};
    static int N;
    static Queue<Graph> queue = new LinkedList<>();

    static class Pair implements Comparable<Pair>{
        int y;
        int x;
        int distance;
        public Pair(int y, int x, int distance) {
            this.y = y;
            this.x = x;
            this.distance = distance;
        }
        @Override
        public int compareTo(Pair o) {
            if (this.distance < o.distance) {
                return -1;
            } else if (this.distance > o.distance) {
                return 1;
            }
            return 0;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "y=" + y +
                    ", x=" + x +
                    ", distance=" + distance +
                    '}';
        }
    }
    static class Graph {
        Pair root;
        LinkedList<Pair> adj;

        public Graph(int y , int x, int distance, int size, int[][] area){
            this.root = new Pair(y, x, distance);
            this.adj = new LinkedList<>();
            for (int i = 0; i < 4; i++) {
                if ((-1 < y + dy[i] && y + dy[i] < N) && (-1 < x + dx[i] && x + dx[i] < N)
                        && area[y+dy[i]][x+dx[i]] <= size)
                    this.adj.add(new Pair(y + dy[i], x + dx[i], distance + 1));
            }
        }
    }
    static class BabyShark {
        int y;
        int x;
        int eatCnt;
        int size;
        int moveCnt;
    }

    public static void main(String[] args) {
        BabyShark babyShark = new BabyShark();
        Scanner scn = new Scanner(System.in);
        N = scn.nextInt();
        int[][] area = new int[N][N];
        boolean[][] visited = new boolean[N][N];
        for (int i = 0; i < area.length; i++) {
            for (int j = 0; j < area.length; j++) {
                area[i][j] = scn.nextInt();
                if (area[i][j] == 9) {
                    babyShark.y = i;
                    babyShark.x = j;
                    babyShark.size= 2;
                    babyShark.eatCnt = 0;
                }
            }
        }
        scn.close();
        printArea(area);
        while (true) {
            int mealCnt = BFS(babyShark, area, visited);
            if (mealCnt == 0)
                break;
        }

        printArea(area);
        System.out.println(babyShark.moveCnt);
    }
    @SuppressWarnings("Duplicates")
    private static void printArea(int[][] area) {
        for (int i = 0; i < area.length; i++) {
            for (int j = 0; j < area.length; j++) {
                System.out.print(area[i][j]);
            }
            System.out.println();
        }
    }
    private static int BFS(BabyShark babyShark, int[][] area, boolean[][] visited) {
        queue.offer(new Graph(babyShark.y, babyShark.x, 0, babyShark.size, area));
        visited[babyShark.y][babyShark.x] = true;
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        while (!queue.isEmpty()) {
            Graph temp = queue.poll();
            for (int i = 0; i < temp.adj.size(); i++) {
                if (visited[temp.adj.get(i).y][temp.adj.get(i).x])
                    continue;
                visited[temp.adj.get(i).y][temp.adj.get(i).x] = true;
                if (area[temp.adj.get(i).y][temp.adj.get(i).x] != 0 && area[temp.adj.get(i).y][temp.adj.get(i).x] < babyShark.size)
                    pq.offer(temp.adj.get(i));
//                System.out.println("distance : " + temp.adj.get(i).distance +"\t" + temp.adj.get(i).y + " , " + temp.adj.get(i).x + "\t" + area[temp.adj.get(i).y][temp.adj.get(i).x]);
                queue.offer(new Graph(temp.adj.get(i).y, temp.adj.get(i).x, temp.adj.get(i).distance, babyShark.size, area));
            }
        }
        System.out.println("먹이들~~~~");
        for (Pair p : pq)
            System.out.println("distance : " + p.distance +"\t(" + p.y + " , " + p.x + ")\t" + area[p.y][p.x]);
        int mealCnt = pq.size();
        ArrayList<Pair> meals = new ArrayList<>();
        int shortestDis = 100;
        while (!pq.isEmpty()) {
            Pair temp = pq.poll();
            if (shortestDis >= temp.distance) {
                shortestDis = temp.distance;
                meals.add(temp);
            }
        }
        if (meals.size() > 0) {
            Pair meal = meals.get(0);
            for (int i = 1; i < meals.size(); i++) {
                if (meals.get(i).y < meal.y) {
                    meal = meals.get(i);
                } else if (meals.get(i).y == meal.y) {
                    if (meals.get(i).x < meal.x)
                        meal = meals.get(i);
                }
            }
            System.out.println("먹는 먹이 " + meal);
            if (null != meal)
                haveMeals(meal, babyShark, area);
            System.out.println("먹이 개수 : " + mealCnt);
        }
        pq.clear();
        resetVisit(visited);
        return mealCnt;
    }
    private static void haveMeals(Pair meal, BabyShark babyShark, int[][] area) {
        babyShark.moveCnt += meal.distance;
        area[babyShark.y][babyShark.x] = 0;
        area[meal.y][meal.x] = 9;
        babyShark.y = meal.y;
        babyShark.x = meal.x;
        babyShark.eatCnt += 1;
        if (babyShark.eatCnt == babyShark.size) {
            babyShark.size += 1;
            babyShark.eatCnt = 0;
        }
    }
    private static void resetVisit(boolean[][] visit) {
        for (int i = 0; i < visit.length; i++) {
            for (int j = 0; j < visit.length; j++) {
                visit[i][j] = false;
            }
        }
    }
}
