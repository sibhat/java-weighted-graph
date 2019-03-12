package main.java.com.thoughtWorks;


import java.util.*;

public class Graph {

    private int length;
    private Map<String, ArrayList<Edge>> adjacentList;

    public Graph(ArrayList<String> data) {
        adjacentList = new HashMap<>();
        length = 0;
    }

    public Graph() {
        adjacentList = new HashMap<>();
        length = 0;
    }

    public boolean insertVertex(String vertex) {
        if (this.adjacentList.containsKey(vertex)) return false;
        ArrayList<Edge> emptyArray = new ArrayList<>();
        this.adjacentList.put(vertex, emptyArray);
        this.length++;
//        System.out.println("vertex value is " + vertex);

        return true;
    }

    public boolean insertEdge(String vertex1, String vertex2, Integer weight) {
        if (!this.adjacentList.containsKey(vertex1) || !this.adjacentList.containsKey(vertex2)) return false;
        ArrayList<Edge> currVertex1 = this.adjacentList.get(vertex1);
        Edge edge1 = new Edge(vertex2, weight);
        currVertex1.add(edge1);
        return true;
    }

    public ArrayList<String> dijkstra(String vertex1, String end) {
        ArrayList<String> path = new ArrayList<>();
        HashMap<String, String> previous = new HashMap<>();
        HashMap<String, Boolean> visited = new HashMap<>();
        HashMap<Object, Integer> shortDistance = new HashMap<>();
        PriorityQueue<Node> queue = new PriorityQueue<Node>(new Node());
        Node node;
        for (Map.Entry pair : this.adjacentList.entrySet()) {
            previous.put(pair.getKey().toString(), null);
            if (pair.getKey().equals(vertex1)) {
                shortDistance.put(pair.getKey(), 0);
                queue.add(new Node(pair.getKey().toString(), 0));
            } else {
                shortDistance.put(pair.getKey(), Integer.MAX_VALUE);
                queue.add(new Node(pair.getKey().toString(), Integer.MAX_VALUE));
            }
            System.out.println(pair.getKey() + " = " + pair.getValue());
        }
        System.out.println("shortDistance 1st is " + shortDistance);
        System.out.println("adjacentList is " + this.adjacentList);

        while (!queue.isEmpty()) {
            node = queue.poll();
//                System.out.println("curr node is " + node);

            if (!visited.containsKey(node.getNode())) {
                visited.put(node.getNode(), true);
                ArrayList<Edge> neighbor = this.adjacentList.get(node.getNode());
                for (Edge edge : neighbor) {
//                        System.out.println("edge is " + edge);
                    if (edge.getVertex().equals(end)) {
//                            String accNode = edge.getVertex();
                        String accNode = node.getNode();
                        path.add(edge.getVertex());
                        while (previous.containsKey(accNode)) {
                            path.add(accNode);
                            accNode = previous.get(accNode);
                        }
                        return reverse(path);
                    }
                    int total = edge.getWeight();
                    if (previous.containsKey(node.getNode())) {
                        total += shortDistance.get(node.getNode());
                    }
                    if (total < shortDistance.get(edge.getVertex())) {
                        shortDistance.put(edge.getVertex(), total);
                        previous.put(edge.getVertex(), node.getNode());
                        queue.add(new Node(edge.getVertex(), total));
                    }
//                        System.out.println("previous is " +previous);
                }
            }
        }
        return path;
    }

    int distanceRoutes(ArrayList<String> routes) {
        String end = routes.get(routes.size() - 1);
        String nodeElement = routes.get(0);

        int total = 0;
        int index = 0;
        while (index < routes.size()) {
            if (nodeElement.equals(end)) {
                break;
            }
            ArrayList<Edge> neighbors = this.adjacentList.get(nodeElement);
            String nextNode = routes.get(index + 1);
            boolean nextStopNotFound = true;
            for (Edge e : neighbors) {
                String currVertex = e.getVertex();
                if (currVertex.equals(nextNode)) {
                    total += e.getWeight();
                    nodeElement = currVertex;
                    nextStopNotFound = false;
                }
            }
            if (nextStopNotFound) {
                return -1;
            }
            index++;
        }
        return total;
    }

    int numberOfTrips(String start, String end, int maxStop) {
        ArrayList<ArrayList<String>> path = new ArrayList<ArrayList<String>>();
        ArrayList<String> heap = new ArrayList<>();
        heap.add(start);
        String currNodeString;
        ArrayList<Edge> currNodeNeighbors;
        ArrayList<String> currpath = new ArrayList<>();
        while (heap.size() > 0) {
            currNodeString = heap.remove(0);
            currpath.add(currNodeString);
            currNodeNeighbors = this.adjacentList.get(currNodeString);
            boolean currNodeDeadEnd = true;
            for (Edge e : currNodeNeighbors) {
                if (currpath.size() <= maxStop + 1) {
                    if (e.getVertex().equals(end)) {
                        path.add(currpath);
                        break;
                    }
                    heap.add(e.getVertex());
                    currNodeDeadEnd = false;
                }
            }
            if(currNodeDeadEnd){
                currpath.remove(currNodeString);
            }
        }
        return path.size();
    }

    private static ArrayList<String> reverse(ArrayList<String> e) {
        ArrayList<String> result = new ArrayList<>(e.size());
        int j = e.size() - 1;

        for (String b : e) {
            result.add(e.get(j));
            j--;
        }
        return result;
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
