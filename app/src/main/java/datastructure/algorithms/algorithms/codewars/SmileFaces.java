package datastructure.algorithms.algorithms.codewars;

import java.util.List;
import java.util.regex.Pattern;

public class SmileFaces {


    public static int countSmileys(List<String> arr) {
        // Just Smile :)
        final var smile = Pattern.compile("^[;|:][-|~]?[)|D]$");
        long count = arr.stream().filter(s -> smile.matcher(s).find()).count();
        return (int) count;
    }


}
