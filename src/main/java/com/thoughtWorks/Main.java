package main.java.com.thoughtWorks;

public class Main {
    public static void main(String[] args){
        System.out.println("helooo");
        createEdge();
    }
    public static void createEdge(){
        Graph graph = new Graph();
        createVertex(graph);
        graph.insertEdge("A", "B", 5);
        graph.insertEdge("A", "C", 3);
        graph.insertEdge("B", "D", 2);
        graph.insertEdge("D", "E", 2);
        graph.insertEdge("C", "D", 3);
        graph.dijkstra("A", "C");
        System.out.println("Graph value are "+ graph.toString());
    }

    private static void createVertex(Graph graph) {
        graph.insertVertex("A");
        graph.insertVertex("B");
        graph.insertVertex("C");
        graph.insertVertex("D");
        graph.insertVertex("E");
    }
}
