package algorithms.codingtest.bornhand;

class BornHand2 {
    boolean solution(String s) {
        int bracket = 0;
        for (int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(')
                bracket++;
            if(s.charAt(i) == ')')
                bracket--;
            if (bracket < 0)
                return false;
        }
        if(bracket != 0)
            return false;
        return true;
    }
}