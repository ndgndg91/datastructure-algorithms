package algorithms.programers.greedy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LifeBoat {
    private static final int[] personWeights = {70, 50, 80, 50};
    private static final int maximumWeightOfBoat = 100;
    private static final int result = 3;

    private static final int[] personWeights2 = {70, 80, 50};
    private static final int maximumWeightOfBoat2 = 100;
    private static final int result2 = 3;

    public static void main(String[] args) {
    }

    private static int solution(int[] people, int limit) {
        int answer = 0;
        Boat lifeBoat = new Boat(limit);
        List<Person> persons = new LinkedList<>();
        for (int p : people) {
            persons.add(new Person(p));
        }




        return answer;
    }

    private static class Boat{
        final List<Person> passengers = new ArrayList<>();
        final int limit;

        public Boat(int limit) {
            this.limit = limit;
        }

        public void ride(Person person) {
            this.passengers.add(person);
        }

        public boolean isFull(){
            return passengers.size() == 2;
        }

        public boolean canRide(Person person){
            return passengers.size() < 2 &&
                    passengers.stream().map(p -> p.weight).reduce(0, (c, n) -> c += n) + person.weight <= limit;
        }
    }

    private static class Person {
        final int weight;

        public Person(int weight) {
            this.weight = weight;
        }
    }

}
