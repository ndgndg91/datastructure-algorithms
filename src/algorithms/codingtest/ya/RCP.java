package algorithms.codingtest.ya;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RCP {

    public static void main(String[] args){
        RCP rcp = new RCP();
        int rsprs = rcp.solution("RSPRS");
        System.out.println(rsprs);
        int srr = rcp.solution("SRR");
        System.out.println(srr);
        int prprrpp = rcp.solution("PRPRRPP");
        System.out.println(prprrpp);
        int pppprrsssss = rcp.solution("PPPPRRSSSSS");
        System.out.println(pppprrsssss);
    }

    public int solution(String G) {
        // write your code in Java SE 8
        final var gestures = Arrays.stream(G.split("")).collect(Collectors.toList());
        var rScores = 0;
        var sScores = 0;
        var pScores = 0;
        for (var g : gestures) {
            if (g.equals("R")) {
                rScores += 1;
                pScores += 2;
            }

            if (g.equals("S")) {
                rScores += 2;
                sScores += 1;
            }

            if (g.equals("P")) {
                sScores += 2;
                pScores += 1;
            }
        }

        return Stream.of(rScores, sScores, pScores).max(Integer::compare).get();
    }
}
