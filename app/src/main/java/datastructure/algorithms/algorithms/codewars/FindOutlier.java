package datastructure.algorithms.algorithms.codewars;

import java.util.ArrayList;

public class FindOutlier{
    static int find(int[] integers){
        var odds = new ArrayList<Integer>();
        var evens = new ArrayList<Integer>();
        for (var i = 0; i < integers.length; i++) {
            if (integers[i] % 2 == 0) {
                evens.add(integers[i]);
            } else {
                odds.add(integers[i]);
            }

            if (i > 2) {
                if (evens.size() == 1) {
                    return evens.get(0);
                }

                if (odds.size() == 1) {
                    return odds.get(0);
                }
            }
        }

        return 0;
    }


}
