package self.graph;

import java.util.Arrays;

public class GraphDriver {
    
    private static final int[][] EDGES = { {0,1}, {0,6}, {0,8}, {1,4}, {1,6}, {1,9}, {2,4}, {2,6}, {3,4}, {3,5},
            {3,8}, {4,5}, {4,9}, {7,8}, {7,9} };

    public static void main(String[] args) {
        Graph graph = new Graph();
        Arrays.stream(EDGES).forEach(e -> graph.addEdge(e[0], e[1]));

        System.out.println(graph);
        graph.addVertex(100);
        graph.addVertex(10);

        System.out.println(graph);
    }


}
