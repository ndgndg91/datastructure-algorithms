package datastructure.algorithms.algorithms.codewars;

public class PanagramChecker {
    public boolean check(String sentence) {
        return sentence.chars()
                .parallel()
                .filter(Character::isLetter)
                .mapToObj(Character::toLowerCase)
                .distinct()
                .count() == 26;
    }


}
