public class PrimsAlgorithms {

    private static final int V = 8;  // Total number of nodes in the graph

    // Function to find the vertex with the minimum key value that has not been included in MST
    private int minKey(int[] key, Boolean[] mstSet) {
        int min = Integer.MAX_VALUE, minIndex = -1;

        for (int v = 0; v < V; v++) {
            if (!mstSet[v] && key[v] < min) {
                min = key[v];
                minIndex = v;
            }
        }
        return minIndex;
    }

    // Function to implement Prim's algorithm
    public void primMST(int[][] graph) {
        int[] parent = new int[V]; // Array to store the constructed MST
        int[] key = new int[V];    // Key values used to pick the minimum weight edge in the cut
        Boolean[] mstSet = new Boolean[V]; // To represent the vertices included in MST

        // Initialize all keys to infinity and mstSet[] as false
        for (int i = 0; i < V; i++) {
            key[i] = Integer.MAX_VALUE;
            mstSet[i] = false;
        }

        // Starting from node A, which is represented as index 0
        key[0] = 0;
        parent[0] = -1; // The root node does not have a parent

        for (int count = 0; count < V - 1; count++) {
            // Pick the minimum key vertex from the set of vertices not yet included in MST
            int u = minKey(key, mstSet);
            mstSet[u] = true; // Add the chosen vertex to the MST set

            // Update the key value and parent index of the adjacent vertices
            for (int v = 0; v < V; v++) {
                // Update the key only if graph[u][v] is smaller than key[v]
                if (graph[u][v] != 0 && !mstSet[v] && graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
            }
        }

        // Print the constructed MST
        printMST(parent, graph);
    }

    // Function to print the edges of the MST and the order in which they are visited
    private void printMST(int[] parent, int[][] graph) {
        int totalWeight = 0;
        System.out.println("Edge \tWeight");
        for (int i = 1; i < V; i++) {
            System.out.println((char) (parent[i] + 'A') + " - " + (char) (i + 'A') + "\t" + graph[i][parent[i]]);
            totalWeight += graph[i][parent[i]];
        }
        System.out.println("Total weight of MST: " + totalWeight);
        System.out.print("Order of nodes visited: A ");
        for (int i = 1; i < V; i++) {
            System.out.print((char) (parent[i] + 'A') + " ");
        }
    }

    public static void main(String[] args) {
        PrimsAlgorithms t = new PrimsAlgorithms();
        int[][] graph = {
                {0, 0, 4, 0, 0, 0, 0, 8},
                {0, 0, 8, 0, 0, 0, 0, 11},
                {4, 8, 0, 7, 0, 4, 0, 2},
                {0, 0, 7, 0, 9, 14, 0, 0},
                {0, 0, 0, 9, 0, 10, 0, 0},
                {0, 0, 4, 14, 10, 0, 2, 0},
                {0, 0, 0, 0, 0, 2, 0, 1},
                {8, 11, 2, 0, 0, 0, 1, 0}
        };

        t.primMST(graph);
    }
}
