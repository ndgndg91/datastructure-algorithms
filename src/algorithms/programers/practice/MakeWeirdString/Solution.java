package algorithms.programers.practice.MakeWeirdString;

class Solution {
    public static String solution(String s) {
        StringBuilder temp = new StringBuilder();
        for (int j = 0; j < s.length(); j++) {
            if (s.charAt(j) == 32) {
                temp.append(" ");
                continue;
            }
            if (j % 2 == 0) {
                if (s.charAt(j) >= 97 && s.charAt(j) <= 122)
                    temp.append((char) (s.charAt(j) - 32));
                else
                    temp.append(s.charAt(j));
            } else {
                if (s.charAt(j) >= 65 && s.charAt(j) <= 90)
                    temp.append((char) (s.charAt(j) + 32));
                else
                    temp.append(s.charAt(j));
            }

        }
        return temp.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println(solution("try hello world"));
    }
}