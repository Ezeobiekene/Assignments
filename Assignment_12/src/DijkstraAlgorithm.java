// Name: Ekene Ezeobi
// Class: CS 3305/W03
// Term: Spring 2023
// Instructor: Carla McManus
// Assignment: 12-ExtraCredit-2-Dijkstra

import java.util.Arrays;

public class DijkstraAlgorithm {
    private static final int NO_PARENT = -1;
    private static final int INF = Integer.MAX_VALUE;

    private static void dijkstra(int[][] adjacencyMatrix, int startVertex) { //dijkstra algorithm method
        int numVertices = adjacencyMatrix.length;
        int[] shortestDistances = new int[numVertices];
        boolean[] added = new boolean[numVertices];

        // initialize all distances as infinite and added[] as false
        Arrays.fill(shortestDistances, INF);
        Arrays.fill(added, false);

        shortestDistances[startVertex] = 0;

        int[] parents = new int[numVertices];
        parents[startVertex] = NO_PARENT;

        for (int i = 1; i < numVertices; i++) { // find the shortest path for all vertices
            int nearestVertex = -1;
            int shortestDistance = INF;
            for (int vertexIndex = 0; vertexIndex < numVertices; vertexIndex++) {
                if (!added[vertexIndex] && shortestDistances[vertexIndex] < shortestDistance) {
                    nearestVertex = vertexIndex;
                    shortestDistance = shortestDistances[vertexIndex];
                }
            }

            added[nearestVertex] = true;

            for (int vertexIndex = 0; vertexIndex < numVertices; vertexIndex++) {// update value of the adjacent vertices of the picked vertex
                int edgeDistance = adjacencyMatrix[nearestVertex][vertexIndex];

                if (edgeDistance > 0 && ((shortestDistance + edgeDistance) < shortestDistances[vertexIndex])) {
                    parents[vertexIndex] = nearestVertex;
                    shortestDistances[vertexIndex] = shortestDistance + edgeDistance;
                }
            }
        }

        printResult(startVertex, shortestDistances, parents);
    }

    private static void printResult(int startVertex, int[] distances, int[] parents) { //print the results
        System.out.println("Vertex\t Distance\tPath");

        for (int vertexIndex = 0; vertexIndex < distances.length; vertexIndex++) {
            if (vertexIndex != startVertex) {
                System.out.print("\n" + vertexIndex + " \t\t ");
                System.out.print(distances[vertexIndex] + "\t\t");
                printPath(vertexIndex, parents);
            }
        }
    }

    private static void printPath(int currentVertex, int[] parents) {
        if (currentVertex == NO_PARENT) {
            return;
        }
        printPath(parents[currentVertex], parents);
        System.out.print(currentVertex + " ");
    }

    public static void main(String[] args) {
        String[] vertices = {//vertices from the textbook
                "Seattle", "San Francisco", "Los Angeles", "Denver", "Kansas City",
                "Chicago", "Boston", "New York", "Atlanta", "Miami", "Dallas", "Houston"
        };

        int[][] edges = { //edges from the text book
                {0, 1, 807}, {0, 3, 1331}, {0, 5, 2097},
                {1, 0, 807}, {1, 2, 381}, {1, 3, 1267},
                {2, 1, 381}, {2, 3, 1015}, {2, 4, 1663}, {2, 10, 1435},
                {3, 0, 1331}, {3, 1, 1267}, {3, 2, 1015}, {3, 4, 599}, {3, 5, 1003},
                {4, 2, 1663}, {4, 3, 599}, {4, 5, 533}, {4, 7, 1260}, {4, 8, 864}, {4, 10, 496},
                {5, 0, 2097}, {5, 3, 1003}, {5, 4, 533}, {5, 6, 983}, {5, 7, 787},
                {6, 5, 983}, {6, 7, 214},
                {7, 4, 1260}, {7, 5, 787}, {7, 6, 214}, {7, 8, 888},
                {8, 4, 864}, {8, 7, 888}, {8, 9, 661}, {8, 10, 781}, {8, 11, 810},
                {9, 8, 661}, {9, 11, 1187},
                {10, 2, 1435}, {10, 4, 496}, {10, 8, 781}, {10, 11, 239},
                {11, 8, 810}, {11, 9, 1187}, {11, 10, 239} };


        // create adjacency matrix
        int[][] adjacencyMatrix = new int[vertices.length][vertices.length];
        for (int[] edge : edges) {
            adjacencyMatrix[edge[0]][edge[1]] = edge[2];
            adjacencyMatrix[edge[1]][edge[0]] = edge[2]; // undirected graph
        }

        // San Francisco has index 1 in the vertices array
        dijkstra(adjacencyMatrix, 1);
    }
}
