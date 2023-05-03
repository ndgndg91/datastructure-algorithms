package datastructure.algorithms.algorithms.programers.skilltest3;

import java.util.*;

public class FirstMove {

    public static void main(String[] args) {
        int solution = solution("ULURRDLLU");
        int solution1 = solution("LULLLLLLU");

        System.out.println(solution);
        System.out.println(solution == 7);

        System.out.println(solution1);
        System.out.println(solution1 == 7);
    }

    private static int solution(String dirs) {
        User user = new User();
        String[] commands = dirs.split("");
        for (String command : commands) {
            Direction direction = Direction.valueOf(command);
            user.move(direction);
        }

        return user.history.size();
    }

    enum Direction {
        U,
        D,
        L,
        R;
    }

    static class User {
        Point current;
        Set<Movement> history;

        public User() {
            this.current = new Point(0,0);
            this.history = new HashSet<>();
        }

        public void move(Direction direction){
            switch (direction) {
                case D:
                    int down = current.y - 1;
                    if (down >= -5 && down <= 5) {
                        Point moveTo = new Point(this.current.x, down);
                        history.add(new Movement(current, moveTo));
                        this.current = moveTo;
                    }
                    break;
                case L:
                    int left = current.x - 1;
                    if (left >= -5 && left <= 5) {
                        Point moveTo = new Point(left, this.current.y);
                        history.add(new Movement(current, moveTo));
                        this.current = moveTo;
                    }
                    break;
                case R:
                    int right = current.x + 1;
                    if (right <= 5 && right >= -5) {
                        Point moveTo = new Point(right, this.current.y);
                        history.add(new Movement(current, moveTo));
                        this.current = moveTo;
                    }
                    break;
                case U:
                    int up = current.y + 1;
                    if (up <= 5 && up >= -5) {
                        Point moveTo = new Point(this.current.x, up);
                        history.add(new Movement(current, moveTo));
                        this.current = moveTo;
                    }
                    break;
            }
        }
    }
    static class Movement{
        Point a;
        Point b;

        public Movement(Point a, Point b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Movement movement = (Movement) o;
            return Objects.equals(a, movement.a) &&
                    Objects.equals(b, movement.b);
        }

        @Override
        public int hashCode() {
            return Objects.hash(a, b);
        }

        @Override
        public String toString() {
            return new StringJoiner(", ", Movement.class.getSimpleName() + "[", "]")
                    .add("a=" + a)
                    .add("b=" + b)
                    .toString();
        }
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x &&
                    y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public String toString() {
            return new StringJoiner(", ", Point.class.getSimpleName() + "[", "]")
                    .add("x=" + x)
                    .add("y=" + y)
                    .toString();
        }
    }
}
