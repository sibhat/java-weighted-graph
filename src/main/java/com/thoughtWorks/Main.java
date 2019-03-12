package main.java.com.thoughtWorks;

import java.util.ArrayList;

public class Main {
    private static MyFile file;
    private static ArrayList<String> data;

    public static void main(String[] args) {
        data = fileRead();
        Graph graph = new Graph();
        createVertex(graph, data);
    }

    private static ArrayList<String> fileRead() {
//        file = new MyFile(".\\test.txt");
        file = new MyFile("C:\\Users\\sibhat\\IdeaProjects\\ProblemOne\\src\\main\\java\\com\\thoughtWorks\\test.txt");
        return file.getData();

    }


    private static void createVertex(Graph graph, ArrayList<String> data) {
        String vertexLine = data.get(0);
        String[] arr = vertexLine.split(", ");
        for (String index : arr) {
            String vertex1 = index.substring(index.length() - 3, index.length() - 2);
            String vertex2 = index.substring(index.length() - 2, index.length() - 1);
            int edge = Integer.parseInt(index.substring(index.length() - 1));

            graph.insertVertex(vertex1);
            graph.insertVertex(vertex2);
            graph.insertEdge(vertex1, vertex2, edge);
        }
        System.out.println("From B to B" + graph.dijkstra("B", "B"));
        ArrayList<String> testDistance = new ArrayList<String>();
        testDistance.add("A");
        testDistance.add("E");
//        testDistance.add("B");
//        testDistance.add("C");
        testDistance.add("D");
//        testDistance.add("C");
        System.out.println("distanceRoutes A-E-D is: " + graph.distanceRoutes(testDistance));
        System.out.println("numberOfTrips from C-C is: " + graph.numberOfTrips("C", "C", 3));



    }
}
