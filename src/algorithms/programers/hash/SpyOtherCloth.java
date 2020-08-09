package algorithms.programers.hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static java.util.stream.Collectors.*;

public class SpyOtherCloth {
    
    private static final String[][] TEST1 = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
    private static final String[][] TEST2 = {{"crow_maks", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}};

    public static void main(String[] args) {
        int variation = variation(TEST1);
        int variation2 = variation(TEST2);

        System.out.println(variation);
        System.out.println(variation2);
    }

    private static int variation(String[][] clothes){
        Map<String, Integer> all = new HashMap<>();

        for (String[] cloth : clothes) {
            String type = cloth[1];

            Integer itemCount = all.get(type);
            if (Objects.nonNull(itemCount)) all.put(type, itemCount + 1);
            if (Objects.isNull(itemCount)) all.put(type, 1);
        }

        return all.values().stream().reduce(1, (b, v) -> b * (v+1)) - 1;
    }

    private static int other(String[][] clothes){
        return Arrays.stream(clothes)
                .collect(groupingBy(p -> p[1], mapping(p -> p[0], counting())))
                .values()
                .stream()
                .reduce(1L, (b, c) -> b * (c + 1)).intValue() - 1;
    }
}
