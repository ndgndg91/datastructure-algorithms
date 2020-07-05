package algorithms.programers.JobFair.SumOfPrime;

import java.util.ArrayList;
class Solution {
    private static int[] combination = new int[3];
    private static int numberOfCase = 0;
    public int solution(int n) {
        ArrayList<Integer> primes = getPrime(n);
        boolean[] visited = new boolean[primes.size()];
        getAnswer(primes, visited, n);
        return numberOfCase;
    }

    public static void getAnswer(ArrayList<Integer> primes, boolean[] visited, int n){
        for (int i = 0; i < primes.size(); i++) {
            makeForwardVisited(i, visited);
            DFS(i, 0, primes, visited, n);
            visited[i] = false;
        }
    }
    private static void DFS(int index, int depth, ArrayList<Integer> primes, boolean[] visited, int n) {
        combination[depth] = primes.get(index);
        if (depth == 2) {
            int result = 0;
            for(int i = 0; i < combination.length; i++) {
                result += combination[i];
            }
            if(result == n) {
                numberOfCase++;
            }
        } else {
            for (int i = index; i < primes.size(); i++) {
                if (visited[i])
                    continue;
                visited[i] = true;
                DFS(i, depth + 1, primes, visited, n);
                visited[i] = false;
            }
        }
    }

    private static void makeForwardVisited(int idx, boolean[] arr) {
        for (int i = idx; i > -1; i--) {
            arr[i] = true;
        }
    }

    @SuppressWarnings("Duplicates")
    public static ArrayList<Integer> getPrime(int num) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        int i = 2; // i : 나눌 대상
        boolean isPrime = true;

        while (i <= num) {
            isPrime = true;

            for (int n = 2; n < i; n++) {
                if (i % n == 0) {
                    isPrime = false;
                }
                continue;
            }

            if (isPrime == true)
                arr.add(i);
            i++;
        }
        return arr;
    }
}