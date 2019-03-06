package main.java.com.thoughtWorks;

import java.util.Comparator;

public class Node implements Comparator<Node> {
    private String node;
    private Integer weight;

    public Node() {
    }

    Node(String node, Integer weight) {
        this.node = node;
        this.weight = weight;
    }

    public String getNode() {
        return node;
    }

    public void setNode(String node) {
        this.node = node;
    }



    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @Override
    public int compare(Node node1, Node node2) {
        if (node1.weight < node2.weight)
            return -1;
        if (node1.weight > node2.weight)
            return 1;
        return 0;
    }
    @Override
    public String toString() {
        return "Node{" +
                "node='" + node + '\'' +
                ", weight=" + weight +
                '}';
    }
}