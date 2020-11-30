package maze;

import java.util.Objects;

public class Edge implements Comparable {
    private int weight = 0;
    private Vertex v1;
    private Vertex v2;

    public Edge(Vertex v1, Vertex v2) {
        this.v1 = v1;
        this.v2 = v2;
    }

    public Edge(int weight, Vertex v1, Vertex v2) {
        this.weight = weight;
        this.v1 = v1;
        this.v2 = v2;
    }

    public Vertex getV1() {
        return v1;
    }

    public Vertex getV2() {
        return v2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Edge)) return false;
        Edge edge = (Edge) o;
        return weight == edge.weight &&
                v1.equals(edge.v1) &&
                v2.equals(edge.v2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(weight, v1, v2);
    }

    @Override
    public int compareTo(Object o) {
        Edge edge = (Edge) o;
        return this.weight - edge.weight;
    }
}
