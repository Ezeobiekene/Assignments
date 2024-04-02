// Name: Ekene Ezeobi
// Class: CS 3305/W03
// Term: Spring 2023
// Instructor: Carla McManus
// Assignment: 12-ExtraCredit-1-Kruskal

import java.util.*;

public class KruskalsAlgorithm {
    private static class Edge implements Comparable<Edge> {
        int source, destination, weight;

        public Edge(int source, int destination, int weight) {// constructor for edge
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }

        public int compareTo(Edge compareEdge) { // compare two edges based on their weights
            return this.weight - compareEdge.weight;
        }
    }

    private static class Subset {
        int parent, rank;
    }

    private int vertices; // number of vertices in the graph
    private List<Edge> edges = new ArrayList<>();///  list to store all edges

    public KruskalsAlgorithm(int vertices) { // constructor for KruskalsAlgorithm
        this.vertices = vertices;
    }

    public void addEdge(int src, int dest, int weight) {//adding edge to grapgh
        Edge edge = new Edge(src, dest, weight);
        edges.add(edge);
    }

    private int find(Subset[] subsets, int i) { //method to find the set of an element i
        if (subsets[i].parent != i) {
            subsets[i].parent = find(subsets, subsets[i].parent);
        }
        return subsets[i].parent;
    }

    private void union(Subset[] subsets, int x, int y) { //method to do union of two sets x and y
        int xroot = find(subsets, x);
        int yroot = find(subsets, y);

        if (subsets[xroot].rank < subsets[yroot].rank) {
            subsets[xroot].parent = yroot;
        } else if (subsets[xroot].rank > subsets[yroot].rank) {
            subsets[yroot].parent = xroot;
        } else {
            subsets[yroot].parent = xroot;
            subsets[xroot].rank++;
        }
    }

    public void kruskalMST() { //kruskal algorithm method
        int totalWeight = 0;
        Edge[] result = new Edge[vertices];
        int e = 0;
        int i;
        for (i = 0; i < vertices; ++i) {
            result[i] = new Edge(0, 0, 0);
        }

        Collections.sort(edges); // Sort all the edges in ascending order of their weight

        Subset[] subsets = new Subset[vertices];
        for (i = 0; i < vertices; ++i) {
            subsets[i] = new Subset();
            subsets[i].parent = i;
            subsets[i].rank = 0;
        }

        i = 0;
        while (e < vertices - 1) {
            Edge nextEdge = edges.get(i++);
            int x = find(subsets, nextEdge.source);
            int y = find(subsets, nextEdge.destination);

            if (x != y) { //checking if the edge would cause a cycle
                result[e++] = nextEdge;
                totalWeight += nextEdge.weight;
                union(subsets, x, y);
            }
        }



        System.out.println("Edges in the constructed MST:"); //print the MST
        for (i = 0; i < e; ++i) {
            System.out.println((char) ('A' + result[i].source) + " -- " +
                    (char) ('A' + result[i].destination) + " == " +
                    result[i].weight);
        }
        System.out.println("Total weight of MST: " + totalWeight); //print the total weight of thee MST
    }

    public static void main(String[] args) {
        int V = 8; // Number of vertices in graph
        KruskalsAlgorithm graph = new KruskalsAlgorithm(V);

        //add the edges to the graph
        graph.addEdge(0, 2, 4);
        graph.addEdge(0, 5, 7);
        graph.addEdge(1, 4, 9);
        graph.addEdge(1, 7, 3);
        graph.addEdge(2, 3, 3);
        graph.addEdge(2, 5, 2);
        graph.addEdge(2, 6, 9);
        graph.addEdge(3, 4, 3);
        graph.addEdge(3, 6, 7);
        graph.addEdge(4, 6, 2);
        graph.addEdge(4, 7, 7);
        graph.addEdge(5, 6, 8);
        graph.addEdge(6, 7, 3);

        //call the Kruskal method on the graph
        graph.kruskalMST();
    }
}
