package datastructure.algorithms.self.graph;

import java.util.*;

public class Graph{
    private final Map<Vertex, List<Vertex>> adjVertices;

    protected Graph(){
        this.adjVertices = new HashMap<>();
    }

    protected void addVertex(Object value) {
        adjVertices.putIfAbsent(new Vertex(value), new ArrayList<>());
    }

    protected void removeVertex(String value) {
        Vertex v = new Vertex(value);
        adjVertices.values().forEach(e -> e.remove(v));
        adjVertices.remove(new Vertex(value));
    }

    protected void addEdge(Object a, Object b) {
        Vertex v1 = new Vertex(a);
        Vertex v2 = new Vertex(b);
        adjVertices.putIfAbsent(v1, new ArrayList<>());
        adjVertices.putIfAbsent(v2, new ArrayList<>());
        adjVertices.get(v1).add(v2);
        adjVertices.get(v2).add(v1);
    }

    protected void removeEdge(String value1, String value2) {
        Vertex v1 = new Vertex(value1);
        Vertex v2 = new Vertex(value2);
        List<Vertex> eV1 = adjVertices.get(v1);
        List<Vertex> eV2 = adjVertices.get(v2);
        if (eV1 != null)
            eV1.remove(v2);
        if (eV2 != null)
            eV2.remove(v1);
    }

    protected List<Vertex> getAdjVertices(Vertex vertex) {
        return adjVertices.get(vertex);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Graph.class.getSimpleName() + "[", "]")
                .add("adjVertices=" + adjVertices)
                .toString();
    }

    protected static class Vertex {
        protected final Object value;

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
