package datastructure.algorithms.algorithms.codingtest.kakao._2019_1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class OpenChat {
    private static String[] input = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
    public static void main(String[] args) {
        String[] output = solution(input);
        for (String s : output) {
            System.out.println(s);
        }
    }
    public static String[] solution(String[] record) {
        Map<String, String> users = new HashMap<>();
        ArrayList<String> answer = new ArrayList<>();
        int length = 0;
        for (int i = 0; i < record.length; i++) {
            String[] temp = record[i].split(" ");
            if (temp.length > 2)
                users.put(temp[1], temp[2]);
            if(!temp[0].equals("Change"))
                length++;
        }
        String[] returnAnswer = new String[length];
        for (int i = 0; i < record.length; i++) {
            String[] temp = record[i].split(" ");
            String nick = users.get(temp[1])+"님이 ";
            String suffix = "";
            if (temp[0].equals("Enter")) {
                suffix = "들어왔습니다.";
            } else if (temp[0].equals("Leave")) {
                suffix = "나갔습니다.";
            }
            if (!temp[0].equals("Change"))
               answer.add(nick+suffix);
        }
        answer.toArray(returnAnswer);
        return returnAnswer;
    }
}
