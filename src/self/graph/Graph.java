package self.graph;

import java.util.*;

public class Graph{
    private final Map<Vertex, List<Vertex>> adjVertices;

    public Graph(){
        this.adjVertices = new HashMap<>();
    }

    static Set<Object> depthFirstTraversal(Graph graph, String root) {
        Set<Object> visited = new LinkedHashSet<>();
        Stack<Object> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Object vertex = stack.pop();
            if (!visited.contains(vertex)) {
                visited.add(vertex);
                for (Vertex v : graph.getAdjVertices(vertex)) {
                    stack.push(v.value);
                }
            }
        }
        return visited;
    }

    static Set<Object> breadthFirstTraversal(Graph graph, String root) {
        Set<Object> visited = new LinkedHashSet<>();
        Queue<Object> queue = new LinkedList<>();
        queue.add(root);
        visited.add(root);
        while (!queue.isEmpty()) {
            Object vertex = queue.poll();
            for (Vertex v : graph.getAdjVertices(vertex)) {
                if (!visited.contains(v.value)) {
                    visited.add(v.value);
                    queue.add(v.value);
                }
            }
        }
        return visited;
    }

    void addVertex(Object value) {
        adjVertices.putIfAbsent(new Vertex(value), new ArrayList<>());
    }

    void removeVertex(String label) {
        Vertex v = new Vertex(label);
        adjVertices.values().forEach(e -> e.remove(v));
        adjVertices.remove(new Vertex(label));
    }

    public void addEdge(Object a, Object b) {
        Vertex v1 = new Vertex(a);
        Vertex v2 = new Vertex(b);
        adjVertices.putIfAbsent(v1, new ArrayList<>());
        adjVertices.putIfAbsent(v2, new ArrayList<>());
        adjVertices.get(v1).add(v2);
        adjVertices.get(v2).add(v1);
    }

    void removeEdge(String label1, String label2) {
        Vertex v1 = new Vertex(label1);
        Vertex v2 = new Vertex(label2);
        List<Vertex> eV1 = adjVertices.get(v1);
        List<Vertex> eV2 = adjVertices.get(v2);
        if (eV1 != null)
            eV1.remove(v2);
        if (eV2 != null)
            eV2.remove(v1);
    }

    List<Vertex> getAdjVertices(Object value) {
        return adjVertices.get(new Vertex(value));
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Graph.class.getSimpleName() + "[", "]")
                .add("adjVertices=" + adjVertices)
                .toString();
    }

    private static class Vertex {
        private final Object value;

        Vertex(Object value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Vertex vertex = (Vertex) o;
            return Objects.equals(value, vertex.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(value);
        }

        @Override
        public String toString() {
            return new StringJoiner(", ", Vertex.class.getSimpleName() + "[", "]")
                    .add("value=" + value)
                    .toString();
        }
    }
}
