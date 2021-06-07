package algorithms.codewars;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

    @Test
    public void testExample() {
        int[] exampleTest1 = {2,6,8,-10,3};
        int[] exampleTest2 = {206847684,1056521,7,17,1901,21104421,7,1,35521,1,7781};
        int[] exampleTest3 = {Integer.MAX_VALUE, 0, 1};
        assertEquals(3, FindOutlier.find(exampleTest1));
        assertEquals(206847684, FindOutlier.find(exampleTest2));
        assertEquals(0, FindOutlier.find(exampleTest3));
    }
}
