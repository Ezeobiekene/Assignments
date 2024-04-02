// Name: Ekene Ezeobi
// Class: CS 3305/W03
// Term: Spring 2023
// Instructor: Carla McManus
// Assignment: 12-Part-1-Prims


import java.util.*;

public class Graph {
    private int vertices; // Number of vertices in the graph
    private Integer[][] adjacencyMatrix; // Adjacency matrix representation of the graph

    // Constructor for Graph
    public Graph(int vertices, Integer[][] adjacencyMatrix) {
        this.vertices = vertices;
        this.adjacencyMatrix = adjacencyMatrix;
    }

    // Prims algorithm to find mst
    public void minimumSpanningTree() {

        // Array to store the MST
        int[] parent = new int[vertices];

        // key values for finding the minimum edge weight
        int[] key = new int[vertices];
        Boolean[] mstSet = new Boolean[vertices]; // the set of elements in the MST


        Arrays.fill(key, Integer.MAX_VALUE);
        Arrays.fill(mstSet, false);

        // Start with the first vertex
        key[0] = 0;
        parent[0] = -1;

        // The MST will have vertices equal to the number of vertices minus one
        for (int i = 0; i < vertices - 1; i++) {

            int u = minKey(key, mstSet);

            // Add the picked vertex to the MST Set
            mstSet[u] = true;

            // Update key and parent index of the adjacent vertices
            for (int v = 0; v < vertices; v++) {

                if (adjacencyMatrix[u][v] != null && !mstSet[v] && adjacencyMatrix[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = adjacencyMatrix[u][v];
                }
            }
        }

        // Print the MST
        printMST(parent);
    }


    private int minKey(int[] key, Boolean[] mstSet) { // method to find the vertex with the smallest key value that is not already in MST
        int min = Integer.MAX_VALUE, minIndex = -1;

        for (int v = 0; v < vertices; v++) {
            if (!mstSet[v] && key[v] < min) {
                min = key[v];
                minIndex = v;
            }
        }

        return minIndex;
    }


    private void printMST(int[] parent) {// method to print the MST
        int totalWeight = 0;
        System.out.println("Edge \tWeight");
        for (int i = 1; i < vertices; i++) {
            if (parent[i] != -1) {
                System.out.println((char) ('A' + parent[i]) + " - " +
                        (char) ('A' + i) + "\t" +
                        adjacencyMatrix[i][parent[i]]);
                totalWeight += adjacencyMatrix[i][parent[i]];
            }
        }
        System.out.println("Total weight of MST: " + totalWeight);
        System.out.print("Order of nodes visited: A ");
        for (int i = 1; i < vertices; i++) {
            System.out.print((char) (parent[i] + 'A') + " ");
        }
    }


    public static void main(String[] args) {
        Integer[][] matrix = {// the adjacency matrix to be calculated in the Prim algorithms
                {null, null, 4, null, null, 7, null, null},
                {null, null, null, null, 9, null, null, 3},
                {4, null, null, 3, null, 2, 9, null},
                {null, null, 3, null, 3, null, 7, null},
                {null, 9, null, 3, null, null, 2, 7},
                {7, null, 2, null, null, null, 8, null},
                {null, null, 9, 7, 2, 8, null, 3},
                {null, 3, null, null, 7, null, 3, null}
        };

        Graph g = new Graph(matrix.length, matrix);
        g.minimumSpanningTree();
    }
}
