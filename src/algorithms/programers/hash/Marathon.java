package algorithms.programers.hash;

import java.util.*;

public class Marathon {
    private static final String[] PARTICIPANT1 = new String[]{"leo", "kiki", "eden"};
    private static final String[] PARTICIPANT2 = new String[]{"marina", "josipa", "nikola", "vinko", "filipa"};
    private static final String[] PARTICIPANT3 = new String[]{"mislav", "stanko", "mislav", "ana"};

    private static final String[] COMPLETE1 = new String[]{"eden", "kiki"};
    private static final String[] COMPLETE2 = new String[]{"josipa", "filipa", "marina", "nikola"};
    private static final String[] COMPLETE3 = new String[]{"stanko", "ana", "mislav"};

    public static void main(String[] args) {
        String result = noComplete(PARTICIPANT1, COMPLETE1);
        System.out.println(result);

        String result2 = noComplete(PARTICIPANT2, COMPLETE2);
        System.out.println(result2);

        String result3 = noComplete(PARTICIPANT3, COMPLETE3);
        System.out.println(result3);
    }

    private static String noComplete(String[] participant, String[] completion){
        Map<String, Integer> participants = new HashMap<>();
        for (String p : participant) {
            if (Objects.nonNull(participants.get(p))) participants.put(p, participants.get(p) + 1);
            if (Objects.isNull(participants.get(p))) participants.put(p, 1);
        }

        for (String c : completion) {
            if (Objects.nonNull(participants.get(c))) participants.put(c, participants.get(c) - 1);
        }

        return participants.entrySet().stream().filter(e -> e.getValue() > 0).findFirst().orElseThrow().getKey();
    }
}
