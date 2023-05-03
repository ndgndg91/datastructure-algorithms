package datastructure.algorithms.self.graph;

import java.util.*;

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

        graph.addEdge(10,100);
        depthFirstTraversal(graph, new Graph.Vertex(0));
        breadthFirstTraversal(graph, new Graph.Vertex(0));
    }

    private static Set<Graph.Vertex> depthFirstTraversal(Graph graph, Graph.Vertex root) {
        Set<Graph.Vertex> visited = new LinkedHashSet<>();
        Deque<Graph.Vertex> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Graph.Vertex vertex = stack.pop();
            if (!visited.contains(vertex)) {
                visited.add(vertex);
                stack.clear();
                for (Graph.Vertex v : graph.getAdjVertices(vertex)) {
                    if (visited.contains(v)) continue;
                    stack.push(v);
                }
            }
        }
        return visited;
    }

    private static Set<Graph.Vertex> breadthFirstTraversal(Graph graph, Graph.Vertex root) {
        Set<Graph.Vertex> visited = new LinkedHashSet<>();
        Queue<Graph.Vertex> queue = new LinkedList<>();
        queue.add(root);
        visited.add(root);
        while (!queue.isEmpty()) {
            Graph.Vertex vertex = queue.poll();
            for (Graph.Vertex v : graph.getAdjVertices(vertex)) {
                if (!visited.contains(v)) {
                    visited.add(v);
                    queue.add(v);
                }
            }
        }
        return visited;
    }

}
