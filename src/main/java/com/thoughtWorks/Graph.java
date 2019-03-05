package main.java.com.thoughtWorks;


import java.util.*;

public class Graph {
    private class Node{
        private String node;
        private Integer weight;

        public Node(String node, Integer weight) {
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
    }
    private int length;
    private Map<String, ArrayList<Edge>> adjacentList;

    public Graph() {
        adjacentList = new HashMap<>();
        length = 0;
    }

    public boolean insertVertex(String vertex) {
        if (this.adjacentList.containsKey(vertex)) return false;
        ArrayList<Edge> emptyArray = new ArrayList<Edge>();
        this.adjacentList.put(vertex, emptyArray);
        this.length++;
        System.out.println("vertex value is " + vertex);

        return true;
    }

    public boolean insertEdge(String vertex1, String vertex2, Integer weight) {
        if (!this.adjacentList.containsKey(vertex1) || !this.adjacentList.containsKey(vertex2)) return false;
        ArrayList<Edge> currVertex1 = this.adjacentList.get(vertex1);
        Edge edge1 = new Edge(vertex2, weight);
        currVertex1.add(edge1);
        return true;
    }

    public ArrayList<String> dijkstra(String vertex1, String vertex2) {
        ArrayList<String> path = new ArrayList<>();
        HashMap<String, String> previous = new HashMap<>();
        HashMap<String, Boolean> visited = new HashMap<>();
        HashMap<Object, Integer> shortDistance = new HashMap<>();
        PriorityQueue<Node> queue = new PriorityQueue<Node>();
        Node node;
        Iterator it = adjacentList.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            if(pair.getKey() == vertex1){
                shortDistance.put(pair.getKey(), 0);
                queue.add(new Node(pair.getKey().toString(), 0));
            }else{
                queue.add(new Node(pair.getKey().toString(), Integer.MAX_VALUE));
            }
            System.out.println(pair.getKey() + " = " + pair.getValue());
            it.remove(); // avoids a ConcurrentModificationException
        }

        while (!queue.isEmpty()){
            node = queue.poll();
            System.out.println(node);
        }


        return path;
    }


    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public Map<String, ArrayList<Edge>> getAdjacentList() {
        return adjacentList;
    }


    @Override
    public String toString() {
        return "Graph{" +
                "values=" + adjacentList +
                '}';
    }

}
