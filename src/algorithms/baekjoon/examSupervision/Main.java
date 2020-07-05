package algorithms.baekjoon.examSupervision;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int N = scn.nextInt();
        int[] peoples = new int[N];
        int[] abilities = new int[2];
        for (int i = 0; i < N; i++){
            peoples[i] = scn.nextInt();
        }
        for (int i = 0; i < 2; i++) {
            abilities[i] = scn.nextInt();
        }
        long result = goSupervise(peoples, abilities);
        System.out.println(result);
    }

    private static long goSupervise(int[] pArr, int[] aArr){
        int mainSupervisor = aArr[0];
        int subSupervisor = aArr[1];
        System.out.println("main :" +mainSupervisor);
        System.out.println("sub :" +subSupervisor);
        long answer = 0;
        for (int i = 0; i < pArr.length; i++) {
            pArr[i] -= mainSupervisor;
            answer += 1;
            if (pArr[i] > 0){
                if(pArr[i] % subSupervisor == 0){
                    System.out.println("pArr[i] / subSupervisor =" +pArr[i] / subSupervisor);
                    answer += pArr[i] / subSupervisor;
                }else{
                    System.out.println("(pArr[i] / subSupervisor) + 1 =" +((pArr[i] / subSupervisor) + 1));
                    answer += (pArr[i] / subSupervisor) + 1;
                }
            }
        }
        return answer;
    }
}