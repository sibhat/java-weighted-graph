package test.java.com.thoughtWorks;

import main.java.com.thoughtWorks.Graph;
import main.java.com.thoughtWorks.Person;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TestMain {
    @Test
    public void shouldCreateGraph(){
        Graph graph = new Graph();
        Person person = new Person();
        createVertex(graph);
        System.out.println("Graph value are "+ graph.toString());
        assertEquals(5, graph.getLength());

    }
    @Test
    public void shouldCreateEdge(){
        Graph graph = new Graph();
        createVertex(graph);
        graph.insertEdge("A", "B", 5);
        graph.insertEdge("A", "C", 3);
        graph.insertEdge("B", "D", 2);
        graph.insertEdge("D", "E", 2);
        graph.insertEdge("C", "D", 3);
        graph.dijkstra("A", "C");
        System.out.println("Graph value are "+ graph.toString());
        assertEquals(5, graph.getLength());
    }

    private void createVertex(Graph graph) {
        graph.insertVertex("A");
        graph.insertVertex("B");
        graph.insertVertex("C");
        graph.insertVertex("D");
        graph.insertVertex("E");
    }
}
