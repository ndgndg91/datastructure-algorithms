package algorithms.codingtest.st11;

import java.util.LinkedList;
import java.util.Queue;

public class Veterinarian {

    private static final Queue<String> PETS = new LinkedList<>();

    public void accept(String petName) {
        PETS.add(petName);
    }

    public String heal() {
        return PETS.poll();
    }

    public static void main(String[] args) {
        Veterinarian veterinarian = new Veterinarian();
        veterinarian.accept("Barkley");
        veterinarian.accept("Mittens");
        System.out.println(veterinarian.heal());
        System.out.println(veterinarian.heal());
    }
}
