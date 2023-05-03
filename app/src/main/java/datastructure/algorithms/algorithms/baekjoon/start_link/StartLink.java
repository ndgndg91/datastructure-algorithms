package datastructure.algorithms.algorithms.baekjoon.start_link;


import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class StartLink {

    private static int N;
    private static int[][] S;

    private static int[] allMember;
    private static ArrayList<Integer> tempAllMember = new ArrayList<>();

    private static boolean[] visited;

    private static int[] beforeDividedTeam;


    private static int[] startTeam;
    private static int[] linkTeam;

    private static boolean[] startVisited;
    private static boolean[] linkVisited;

    private static int[] startCombi = new int[2];
    private static int[] linkCombi = new int[2];

    private static ArrayList<Integer> startAbilities = new ArrayList<>();
    private static ArrayList<Integer> linkAbilities = new ArrayList<>();

    private static ArrayList<Integer> diffBothTeam = new ArrayList<>();

    private static Stack<Integer> stack = new Stack<>();
    private static int escapeCondition = 0;

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        N = scn.nextInt();
        S = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                S[i][j] = scn.nextInt();
            }
        }
        scn.close();
        allMember = new int[N];
        visited = new boolean[N];
        beforeDividedTeam = new int[N / 2];
        startTeam = new int[N / 2];
        linkTeam = new int[N / 2];
        startVisited = new boolean[N / 2];
        linkVisited = new boolean[N / 2];
        allMember();
        DFS();
        for (int i = 0; i < linkAbilities.size(); i++){
            int start = startAbilities.get(i);
            int link = linkAbilities.get(i);
//            System.out.println("start : " + start);
//            System.out.println("link : " + link);
            int diff = 0;
            if ( start > link ) {
                diff = start - link;
            } else {
                diff = link - start;
            }
            diffBothTeam.add(diff);
        }

        int min = 100;
        for (int i = 0; i < diffBothTeam.size(); i++) {
            if (diffBothTeam.get(i) < min) {
                min = diffBothTeam.get(i);
            }
        }
        System.out.println(min);

    }

    private static void DFS_ability(int[] arr, boolean[] visit, int[] combination, ArrayList<Integer> abilities) {
        makeAllNoVisited(visit);
        for (int i = 0; i < arr.length; i++) {
            makeForwardVisited(i, visit);
            DFS_ability(i, 0, combination.length-1, arr, visit, combination, abilities);
            visit[i] = false;
        }
    }

    private static void DFS_ability(int idx, int depth, int maxDepth, int[] team, boolean[] visit, int[] combination, ArrayList<Integer> abilities) {
        combination[depth] = team[idx];
        if (depth == maxDepth) {
            escapeCondition++;
//            for (int i = 0; i < combination.length; i++) {
//                System.out.print(combination[i] + " ");
//            }
//            System.out.println();
            int ability1 = S[combination[0]-1][combination[1]-1];
            int ability2 = S[combination[1]-1][combination[0]-1];
            int sum = ability1 + ability2;
            stack.push(sum);
            if (escapeCondition == (team.length * (team.length-1)) / 2) {
//                System.out.println("들어오긴 하니?");
//                System.out.println(stack.isEmpty());
                int finalSum = 0;
                while (!stack.isEmpty()){
                    int tempAbility = stack.pop();
//                    System.out.println(tempAbility);
                    finalSum += tempAbility;
                }
                abilities.add(finalSum);
                escapeCondition = 0;
                stack.empty();
            }

        } else {
            for (int i = idx; i < team.length; i++) {
                if (visit[i])
                    continue;
                visit[i] = true;
                DFS_ability(i, depth + 1, maxDepth, team, visit, combination, abilities);
                visit[i] = false;
            }
        }
    }

    private static void allMember() {
        for (int i = 0; i < N; i++) {
            allMember[i] = i + 1;
            tempAllMember.add(i + 1);
        }
    }

    private static void makeForwardVisited(int idx, boolean[] arr) {
        for (int i = idx; i > -1; i--) {
            arr[i] = true;
        }
    }

    private static void makeAllNoVisited(boolean[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = false;
        }
    }

    private static void recoverTempAllMember() {
        tempAllMember.clear();
        for (int i = 0; i < allMember.length; i++) {
            tempAllMember.add(allMember[i]);
        }
    }

    private static void DFS() {
        for (int i = 0; i < allMember.length; i++) {
            makeForwardVisited(i, visited);
            DFS(i, 0);
            visited[i] = false;
        }
    }

    private static void DFS(int index, int depth) {
        beforeDividedTeam[depth] = allMember[index];
        if (depth == N / 2 - 1) {
            for (int i = 0; i < beforeDividedTeam.length; i++) {
                startTeam[i] = beforeDividedTeam[i];
                tempAllMember.remove(beforeDividedTeam[i]);
            }

            for (int i = 0; i < tempAllMember.size(); i++) {
                linkTeam[i] = tempAllMember.get(i);
            }
            DFS_ability(startTeam, startVisited, startCombi, startAbilities);
            DFS_ability(linkTeam, linkVisited, linkCombi, linkAbilities);
//            printBothTeam();
            recoverTempAllMember();
        } else {
            for (int i = index; i < allMember.length; i++) {
                if (visited[i])
                    continue;
                visited[i] = true;
                DFS(i, depth + 1);
                visited[i] = false;
            }

        }
    }

    private static void printBothTeam() {
        String lt = "";
        String st = "";
        for (int i = 0; i < N / 2; i++) {
            lt += linkTeam[i] + " ";
            st += startTeam[i] + " ";
        }
//        System.out.println("start team : " + st);
//        System.out.println("link team : " + lt);
    }

}
