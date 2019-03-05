package main.java.com.thoughtWorks;

public class Edge {
    private String vertex;
    private Integer weight;

    public Edge(String node, Integer weight) {
        this.vertex = node;
        this.weight = weight;
    }

    public String getVertex() {
        return vertex;
    }

    public void setVertex(String node) {
        this.vertex = node;
    }

    public Integer getWeight() {
        return weight;
    }


    public void setWeight(Integer weight) {
        this.weight = weight;
    }
    @Override
    public String toString() {
        return "Edge{" +
                "vertex='" + vertex + '\'' +
                ", weight=" + weight +
                '}';
    }
}
