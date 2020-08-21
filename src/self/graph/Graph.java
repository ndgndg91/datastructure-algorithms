package self.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Graph {
    private List<Edge> edgeList;
    private Vertex[][] adjacencyMatrix;
    private List<List<Vertex>> adjacencyList;

    private Graph(){}

    public static Graph edgeListOf(){
        Graph graph = new Graph();
        graph.edgeList = new ArrayList<>();
        return graph;
    }

    public void addEdge(Edge edge) {
        this.edgeList.add(edge);
    }

    private static class Vertex {
        private final String name;

        Vertex(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Vertex vertex = (Vertex) o;
            return Objects.equals(name, vertex.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }
    }

    private static class Edge {
        private final Vertex a;
        private final Vertex b;

        Edge(Vertex a, Vertex b) {
            this.a = a;
            this.b = b;
        }

        public Vertex getA() {
            return a;
        }

        public Vertex getB() {
            return b;
        }
    }
}
