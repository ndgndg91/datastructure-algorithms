package datastructure.algorithms.algorithms.baekjoon.watch;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class Watch {
    private static final int[][] case1 = {
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 1, 0, 6, 0},
            {0, 0, 0, 0, 0, 0}
    };
    private static final int[][] case2 ={
            {0,0,0,0,0,0},
            {0,2,0,0,0,0},
            {0,0,0,0,6,0},
            {0,6,0,0,2,0},
            {0,0,0,0,0,0},
            {0,0,0,0,0,5}
    };
    private static final int[][] case3 = {
            {1, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 0},
            {0, 0, 1, 0, 0, 0},
            {0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 1, 0},
            {0, 0, 0, 0, 0, 1}
    };
    private static final int[][] case4 = {
            {1, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 0},
            {0, 0, 1, 5, 0, 0},
            {0, 0, 5, 1, 0, 0},
            {0, 0, 0, 0, 1, 0},
            {0, 0, 0, 0, 0, 1}
    };
    private static final int[][] case5 = {
            {0, 1, 2, 3, 4, 5, 6}
    };
    private static final int[][] case6 = {
            {4, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 2, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 4}
    };

    private static class CCTV{
        int x;
        int y;
        int type;
        boolean visited[];

        public CCTV(int x, int y, int type) {
            this.x = x;
            this.y = y;
            this.type = type;
            this.visited = new boolean[4];
        }
    }

    private static int[] resultDirections;
    private static int numberOfCases = 0;
    private static int[][] room;
    private static int directions = 4;
    private static int cctvCnt = 0;//cctv 개수
    private static ArrayList<CCTV> allCCTV = new ArrayList<>();

    private static HashSet<Integer> resultZero = new HashSet<>();

    private static int height;
    private static int width;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        height = sc.nextInt();
        width = sc.nextInt();

        room = new int[height][width];

        for(int i=0; i<height; i++) {
            for(int j=0; j<width; j++) {
                room[i][j] = sc.nextInt();
                if(room[i][j] == 0 || room[i][j] == 6)
                    continue;
                allCCTV.add(new CCTV(i, j, room[i][j]));
            }
        }

//        for(int i=0; i<room.length; i++) {
//            for(int j=0; j<case4[i].length; j++) {
//                if(case4[i][j] == 0 || case4[i][j] == 6)
//                    continue;
//                allCCTV.add(new CCTV(i, j, case4[i][j]));
//            }
//        }

        cctvCnt = allCCTV.size();
        resultDirections = new int[cctvCnt];
        DFS();
//        System.out.println("경우의 수 : "+ numberOfCases);
        System.out.println(minZeroCnt(resultZero));
    }

    private static void DFS(){
        if (cctvCnt > 0) {
            for (int i = 0; i < directions; i++) {
                CCTV cctv = allCCTV.get(0);
                cctv.visited[i] = true;
                DFS_recursion(0, i);
            }
        } else {
            int zeroCnt = printRoomAndCountZero(room);
            resultZero.add(zeroCnt);
        }
    }

    private static void DFS_recursion(int depth, int direction){
        resultDirections[depth] = direction;
        if (depth == cctvCnt-1) {
            numberOfCases++;
//            System.out.println("경우의 수 : " +numberOfCases);
            for (int i = 0; i < resultDirections.length; i++){
                CCTV cctv = allCCTV.get(i);
                mark7(cctv.type, resultDirections[i], cctv.x, cctv.y);
            }
            int zeroCnt = printRoomAndCountZero(room);
            resultZero.add(zeroCnt);
            getBack7to0(room);
//            System.out.println();
        } else {
            for (int i = 0; i < directions; i++){
                CCTV cctv = allCCTV.get(depth + 1);
                if (cctv.visited[i])
                    continue;
                cctv.visited[i] = true;
                DFS_recursion(depth + 1, i);
                cctv.visited[i] = false;
            }
        }
    }

    private static int minZeroCnt(HashSet<Integer> set){
        int minVal = 100;
//        System.out.print("set : ");
        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            int val = (Integer)iterator.next();
//            System.out.print(val + " ");
            if(val < minVal)
                minVal = val;
        }
        return minVal;
    }

    private static int printRoomAndCountZero(int[][] arr){
        int cnt = 0;
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr[i].length; j++){
                if (arr[i][j] == 0)
                    cnt++;
//                System.out.print(arr[i][j] + " ");
            }
//            System.out.println();
        }
        return cnt;
    }

    private static void getBack7to0(int[][] arr){
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr[i].length; j++){
                if (arr[i][j] == 7)
                    arr[i][j] = 0;
            }
        }
    }

    private static void mark7(int cctvType, int direction, int x, int y){
        switch (cctvType) {
            case 1:
                switch (direction) {
                    case 0://up
                        mark7Up(x,y);
                        break;
                    case 1://right
                        mark7Right(x,y);
                        break;
                    case 2://down
                        mark7Down(x,y);
                        break;
                    case 3://left
                        mark7Left(x,y);
                        break;
                }
                break;
            case 2:
                switch (direction) {
                    case 0://up
                        mark7Up(x,y);
                        mark7Down(x,y);
                        break;
                    case 1://right
                        mark7Left(x,y);
                        mark7Right(x,y);
                        break;
                    case 2://down
                        mark7Up(x,y);
                        mark7Down(x,y);
                        break;
                    case 3://left
                        mark7Left(x,y);
                        mark7Right(x,y);
                        break;
                }
                break;
            case 3:
                switch (direction) {
                    case 0://up
                        mark7Up(x,y);
                        mark7Right(x,y);
                        break;
                    case 1://right
                        mark7Right(x,y);
                        mark7Down(x,y);
                        break;
                    case 2://down
                        mark7Down(x,y);
                        mark7Left(x,y);
                        break;
                    case 3://left
                        mark7Left(x,y);
                        mark7Up(x,y);
                        break;
                }
                break;
            case 4:
                switch (direction) {
                    case 0://up
                        mark7Left(x,y);
                        mark7Up(x,y);
                        mark7Right(x,y);
                        break;
                    case 1://right
                        mark7Up(x,y);
                        mark7Right(x,y);
                        mark7Down(x,y);
                        break;
                    case 2://down
                        mark7Right(x,y);
                        mark7Down(x,y);
                        mark7Left(x,y);
                        break;
                    case 3://left
                        mark7Down(x,y);
                        mark7Left(x,y);
                        mark7Up(x,y);
                        break;
                }
                break;
            case 5:
                switch (direction) {
                    case 0://up
                        mark7Up(x,y);
                        mark7Right(x,y);
                        mark7Left(x,y);
                        mark7Down(x,y);
                        break;
                    case 1://right
                        mark7Up(x,y);
                        mark7Right(x,y);
                        mark7Left(x,y);
                        mark7Down(x,y);
                        break;
                    case 2://down
                        mark7Up(x,y);
                        mark7Right(x,y);
                        mark7Left(x,y);
                        mark7Down(x,y);
                        break;
                    case 3://left
                        mark7Up(x,y);
                        mark7Right(x,y);
                        mark7Left(x,y);
                        mark7Down(x,y);
                        break;
                }
                break;
        }
    }

    @SuppressWarnings("Duplicates")
    private static void mark7Up(int x, int y) {
        for (int i = x-1; i > -1; i--){
            if(room[i][y] == 6)
                break;
            if(room[i][y] == 1 || room[i][y] == 2 || room[i][y] == 3 || room[i][y] == 4 || room[i][y] == 5)
                continue;
            room[i][y] = 7;
        }
    }
    @SuppressWarnings("Duplicates")
    private static void mark7Right(int x, int y) {
        for (int i = y+1; i < room[x].length; i++){
            if(room[x][i] == 6)
                break;
            if(room[x][i] == 1 || room[x][i] == 2 || room[x][i] == 3 || room[x][i] == 4 || room[x][i] == 5)
                continue;
            room[x][i] = 7;
        }
    }
    @SuppressWarnings("Duplicates")
    private static void mark7Down(int x, int y) {
        for (int i = x+1; i < room.length; i++){
            if(room[i][y] == 6)
                break;
            if(room[i][y] == 1 || room[i][y] == 2 || room[i][y] == 3 || room[i][y] == 4 || room[i][y] == 5)
                continue;
            room[i][y] = 7;
        }
    }
    @SuppressWarnings("Duplicates")
    private static void mark7Left(int x, int y) {
        for (int i = y-1; i > -1; i--){
            if(room[x][i] == 6)
                break;
            if(room[x][i] == 1 || room[x][i] == 2 || room[x][i] == 3 || room[x][i] == 4 || room[x][i] == 5)
                continue;
            room[x][i] = 7;
        }
    }

}
