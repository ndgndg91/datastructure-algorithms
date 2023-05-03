package datastructure.algorithms.algorithms.baekjoon.beadEscape;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    static class InObject {
        int y;
        int x;
        int originY;
        int originX;
        String type;
    }

    private static HashSet<Integer> results = new HashSet<>();

    public static void main(String[] args) {
        InObject red = new InObject();
        InObject blue = new InObject();
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        String[][] ground = new String[n][m];
        for (int i = 0; i < n; i++) {
            String[] temp = scn.next().split("");
            for (int j = 0; j < m; j++) {
                if (temp[j].equals("R")) {
                    red.y = i;
                    red.x = j;
                    red.originY = i;
                    red.originX = j;
                    red.type = "R";
                } else if (temp[j].equals("B")) {
                    blue.y = i;
                    blue.x = j;
                    blue.originY = i;
                    blue.originX = j;
                    blue.type = "B";
                }
                ground[i][j] = temp[j];
            }
        }
        scn.close();
//        moveBeads(3, ground, red, blue);
//        printGround(ground);
//        moveBeads(2, ground, red, blue);
//        printGround(ground);
//        moveBeads(1, ground, red, blue);
//        printGround(ground);
//        moveBeads(2, ground, red, blue);
//        printGround(ground);
//        moveBeads(3, ground, red ,blue);
//        printGround(ground);
//        if (checkBeads(red) && !checkBeads(blue)) {
//            System.out.println("빨간구슬만 빠졌다");
//            resetEvery(red, blue, ground, true, 5);
//            printGround(ground);
//        } else if (checkBeads(blue)) {
//            System.out.println("파란구슬이 빠졌다");
//            resetEvery(red, blue, ground, true, 5);
//            printGround(ground);
//        }
        int[] directions = new int[10];
        for (int i = 0; i < 4; i++) {
            DFS(0, i, ground, red, blue, directions);
        }

        if (results.size() == 1) {
            System.out.println(-1);
        } else {
            int minValue = 11;
            Iterator<Integer> iterator = results.iterator();
            while (iterator.hasNext()) {
                int temp = iterator.next();
                System.out.println(temp);
                if (temp != -1 && minValue > temp)
                    minValue = temp;
            }
            System.out.println(minValue);
        }
    }

    private static void DFS(int depth, int direction, String[][] ground, InObject red, InObject blue, int[] directions) {
        directions[depth] = direction;
        if (depth == 9) {
            for (int i = 0; i < directions.length; i++) {
                moveBeads(directions[i], ground, red, blue);
                if (checkBeads(red) && !checkBeads(blue)) {
                    resetEvery(red, blue, ground, true, i+1);
                    return;
                } else if (checkBeads(blue)) {
                    resetEvery(red, blue, ground, false, i+1);
                    return;
                }
            }
            resetEvery(red, blue, ground, false, 0);
            return;
        }
        for (int i = 0; i < 4; i++) {
            if (directions[depth] == i)
                continue;
            if (Math.abs(directions[depth] - i) == 2)
                continue;
            DFS(depth + 1, i, ground, red, blue, directions);
        }
    }

    private static void resetEvery(InObject red, InObject blue, String[][] ground, boolean tf, int cnt) {
        if (tf) {
            results.add(cnt);
        } else {
            results.add(-1);
        }
        resetBeads(red, ground);
        resetBeads(blue, ground);
    }

    private static void printGround(String[][] ground) {
        for (int i = 0; i < ground.length; i++) {
            for (int j = 0; j < ground[i].length; j++) {
                System.out.print(ground[i][j]);
            }
            System.out.println();
        }
    }

    private static void resetBeads(InObject bead, String[][] ground) {
        if (bead.y == 0 && bead.x == 0) {
            ground[bead.y][bead.x] = "#";
        } else {
            ground[bead.y][bead.x] = ".";
        }
        bead.y = bead.originY;
        bead.x = bead.originX;
        ground[bead.y][bead.x] = bead.type;
    }

    private static boolean checkBeads(InObject bead) {
        boolean isFall = false;
        if (bead.y == 0 && bead.x == 0)
            isFall = true;
        return isFall;
    }

    private static void moveBeads(int direction, String[][] ground, InObject red, InObject blue) {
        switch (direction) {
            case 0://up
                if (red.y - blue.y < 0) {
                    moveBeadUp(ground, red);
                    moveBeadUp(ground, blue);
                } else {
                    moveBeadUp(ground, blue);
                    moveBeadUp(ground, red);
                }
                break;
            case 1://right
                if (red.x - blue.x < 0) {
                    moveBeadRight(ground, blue);
                    moveBeadRight(ground, red);
                } else {
                    moveBeadRight(ground, red);
                    moveBeadRight(ground, blue);
                }
                break;
            case 2://down
                if (red.y - blue.y > 0) {
                    moveBeadDown(ground, red);
                    moveBeadDown(ground, blue);
                } else {
                    moveBeadDown(ground, blue);
                    moveBeadDown(ground, red);
                }
                break;
            case 3://left
                if (red.x - blue.x < 0) {
                    moveBeadLeft(ground, red);
                    moveBeadLeft(ground, blue);
                } else {
                    moveBeadLeft(ground, blue);
                    moveBeadLeft(ground, red);
                }
                break;
        }
    }

    private static void moveBeadDown(String[][] ground, InObject bead) {
        if (ground[bead.y + 1][bead.x].equals(".")) {
            ground[bead.y][bead.x] = ".";
            ground[bead.y + 1][bead.x] = bead.type;
            bead.y += 1;
            moveBeadDown(ground, bead);
        } else if (ground[bead.y + 1][bead.x].equals("#")) {
            return;
        } else if (ground[bead.y + 1][bead.x].equals("O")) {
            fallIntoHole(ground, bead);
            return;
        }
    }

    private static void moveBeadUp(String[][] ground, InObject bead) {
        if (ground[bead.y - 1][bead.x].equals(".")) {
            ground[bead.y][bead.x] = ".";
            ground[bead.y - 1][bead.x] = bead.type;
            bead.y -= 1;
            moveBeadUp(ground, bead);
        } else if (ground[bead.y - 1][bead.x].equals("#")) {
            return;
        } else if (ground[bead.y - 1][bead.x].equals("O")) {
            fallIntoHole(ground, bead);
            return;
        }
    }

    private static void moveBeadRight(String[][] ground, InObject bead) {
        if (ground[bead.y][bead.x + 1].equals(".")) {
            ground[bead.y][bead.x] = ".";
            ground[bead.y][bead.x + 1] = bead.type;
            bead.x += 1;
            moveBeadRight(ground, bead);
        } else if (ground[bead.y][bead.x + 1].equals("#")) {
            return;
        } else if (ground[bead.y][bead.x + 1].equals("O")) {
            fallIntoHole(ground, bead);
            return;
        }
    }

    private static void moveBeadLeft(String[][] ground, InObject bead) {
        if (ground[bead.y][bead.x - 1].equals(".")) {
            ground[bead.y][bead.x] = ".";
            ground[bead.y][bead.x - 1] = bead.type;
            bead.x -= 1;
            moveBeadLeft(ground, bead);
        } else if (ground[bead.y][bead.x - 1].equals("#")) {
            return;
        } else if (ground[bead.y][bead.x - 1].equals("O")) {
            fallIntoHole(ground, bead);
            return;
        }
    }

    private static void fallIntoHole(String[][] ground, InObject bead) {
//        if (bead.type == "R")
//            System.out.println("빨간 색 빠짐");
//        if (bead.type == "B")
//            System.out.println("파란 색 빠짐");
        ground[bead.y][bead.x] = ".";
        bead.x = 0;
        bead.y = 0;
    }
}