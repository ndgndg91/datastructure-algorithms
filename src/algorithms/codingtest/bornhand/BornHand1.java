package algorithms.codingtest.bornhand;

class BornHand1 {
    private static int[] combination = new int[3];
    private static int numberOfCase = 0;
    public static int solution(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        getAnswer(nums, visited);
        return numberOfCase;
    }

    public static void getAnswer(int[] nums, boolean[] visited){
        for (int i = 0; i < nums.length; i++) {
            makeForwardVisited(i, visited);
            DFS(i, 0, nums, visited);
            visited[i] = false;
        }
    }
    private static void DFS(int index, int depth, int[] nums, boolean[] visited) {
        combination[depth] = nums[index];
        if (depth == 2) {
            int result = 0;
            for(int i = 0; i < combination.length; i++) {
                // System.out.print(combination[i] + " ");
                result += combination[i];
            }
            // System.out.println();
            // System.out.println(result);
            // System.out.println(result + " 는 소수인가 ? : " + isPrime(result));
            // System.out.println();
            if (isPrime(result))
                numberOfCase++;
        } else {
            for (int i = index; i < nums.length; i++) {
                if (visited[i])
                    continue;
                visited[i] = true;
                DFS(i, depth + 1, nums, visited);
                visited[i] = false;
            }
        }
    }
    @SuppressWarnings("Duplicates")
    private static boolean isPrime(int n){
        boolean isPrime = true;
        double divisor = 2;
        double squareRoot = Math.sqrt(n);
        while (divisor <= squareRoot){
            if(n % divisor == 0){
                isPrime = false;
                break;
            }
            divisor++;
        }
        return isPrime;
    }

    private static void makeForwardVisited(int idx, boolean[] arr) {
        for (int i = idx; i > -1; i--) {
            arr[i] = true;
        }
    }
}
