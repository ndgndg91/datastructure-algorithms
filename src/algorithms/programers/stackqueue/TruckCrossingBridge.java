package algorithms.programers.stackqueue;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TruckCrossingBridge {

    private static final int bridge_length1 = 2;
    private static final int weight1 = 10;
    private static final int[] truck_weights1 = {7,4,5,6};
    private static final int result1 = 8;

    private static final int bridge_length2 = 100;
    private static final int weight2 = 100;
    private static final int[] truck_weights2 = {10};
    private static final int result2 = 101;

    private static final int bridge_length3 = 100;
    private static final int weight3 = 100;
    private static final int[] truck_weights3 = {10,10,10,10,10,10,10,10,10,10};
    private static final int result3 = 110;

    public static void main(String[] args) {
        int solution = solution(bridge_length1, weight1, truck_weights1);
        System.out.println(solution);
        System.out.println(solution == result1);

        int solution2 = solution(bridge_length2, weight2, truck_weights2);
        System.out.println(solution2);
        System.out.println(solution2 == result2);

        int solution3 = solution(bridge_length3, weight3, truck_weights3);
        System.out.println(solution3);
        System.out.println(solution3 == result3);
    }

    private static int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;
        Bridge bridge = new Bridge(bridge_length, weight);
        Queue<Truck> waitingTrucks = new LinkedList<>();
        for (int i : truck_weights) {
            waitingTrucks.add(new Truck(i));
        }

        if (waitingTrucks.size() == 1) {
            return bridge.length + 1;
        }

        while (!bridge.trucksOnMe.isEmpty() || !waitingTrucks.isEmpty()) {
            time++;

            if (!bridge.trucksOnMe.isEmpty() && bridge.trucksOnMe.get(0).position == bridge_length) {
                bridge.trucksOnMe.remove(0);
            }

            Truck waiting = waitingTrucks.peek();
            if (waiting != null && bridge.canEnter(waiting)) {
                bridge.enter(waitingTrucks.poll());
            }

            for (int i = 0; i < bridge.trucksOnMe.size(); i++) {
                bridge.trucksOnMe.get(i).position++;
            }
        }

        return time;
    }

    private static class Bridge {
        public final int length;
        public final int weight;
        public final List<Truck> trucksOnMe = new LinkedList<>();

        public Bridge(int length, int weight) {
            this.length = length;
            this.weight = weight;
        }

        public boolean canEnter(Truck truck) {
            int sum = trucksOnMe.stream().mapToInt(t -> t.weight).sum() + truck.weight;
            return weight - sum >= 0;
        }

        public void enter(Truck truck) {
            this.trucksOnMe.add(truck);
        }
    }

    private static class Truck {
        public final int weight;
        public int position = 0;

        public Truck(int weight) {
            this.weight = weight;
        }
    }
}
