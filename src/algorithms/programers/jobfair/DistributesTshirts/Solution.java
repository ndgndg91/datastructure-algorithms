package algorithms.programers.jobfair.DistributesTshirts;
class Solution {
    public int solution(int[] people, int[] tshirts) {
        int answer = 0;
        int answer2 = 0;
        boolean[] isDistributed = new boolean[tshirts.length];
        boolean[] isReceived = new boolean[people.length];
        if(true){
            for (int i = 0; i < people.length; i++) {
                for( int j = 0; j < tshirts.length; j++ ) {
                    if(people[i] <= tshirts[j] && !isDistributed[j] && !isReceived[i]){
                        isReceived[i] = true;
                        isDistributed[j] = true;
                        answer++;
                    }
                }
            }
        }else{
            for (int i = 0; i < people.length; i++) {
                for( int j = 0; j < tshirts.length; j++ ) {
                    if(people[i] == tshirts[j] && !isDistributed[j] && !isReceived[i]){
                        isReceived[i] = true;
                        isDistributed[j] = true;
                        answer2++;
                    }
                }
            }
        }
        return answer > answer2 ? answer : answer2;
    }
}