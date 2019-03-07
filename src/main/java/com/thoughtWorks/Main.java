package main.java.com.thoughtWorks;

public class Main {
    public static void main(String[] args){
        System.out.println("helooo");
        createEdge();
    }
    private static void createEdge(){
        Graph graph = new Graph();
        createVertex(graph);
        graph.insertEdge("A", "B", 5);
        graph.insertEdge("B", "C", 4);
        graph.insertEdge("C", "D", 8);
        graph.insertEdge("D", "C", 8);
        graph.insertEdge("D", "E", 6);
        graph.insertEdge("A", "D", 5);
        graph.insertEdge("C", "E", 1);
        graph.insertEdge("E", "B", 3);
//        graph.insertEdge("A", "E", 7);

        System.out.println("From A to E" + graph.dijkstra("B", "B"));
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
