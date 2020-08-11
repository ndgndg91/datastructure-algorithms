package algorithms.programers.greedy;



class GymSuit {
    public static int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;
        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i] == reserve[j]) {
                    lost[i] = 0;
                    reserve[j] = 0;
                    answer++;
                }
            }
        }
        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i] == 0)
                    continue;
                if (Math.abs(lost[i] - reserve[j]) == 1) {
                    System.out.println(lost[i] + " , " + reserve[j]);
                    lost[i] = 0;
                    reserve[j] = 0;
                    answer++;
                }

            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] lost = { 1,2,3,4,5 };
        int[] reserve = { 1, 3, 5 };
        int result = solution(10, lost, reserve);
        System.out.println(result);
    }
}