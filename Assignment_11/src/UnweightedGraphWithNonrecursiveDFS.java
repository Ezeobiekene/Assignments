// Name: Ekene Ezeobi
// Class: CS 3305/W03
// Term: Spring 2023
// Instructor: Carla McManus
// Assignment: 11-Part-1-DFS

import java.util.*;

public class UnweightedGraphWithNonrecursiveDFS<V> extends UnweightedGraph<V>  {

    @Override
    public  Tree dfs(int v) {
        boolean[] isVisited = new boolean[getSize()];
        Stack<Integer> stack = new Stack<>(); //stack to manage the dfs
        List<Integer> searchOrder = new ArrayList<>(); //list to store search order
        int[] parent = new int[getSize()]; //array to store parent of each vertex
        for (int i = 0; i < parent.length; i++) {
            parent[i] = -1;
        }


        stack.push(v); //push the vertex passed into dfs into the stack (the starting point of the search)
        isVisited[v] = true;

        while (!stack.isEmpty()) {
            int current = stack.pop(); //current is the vertex popped from the stack
            searchOrder.add(current); //adding the popped item to keep track of the search order

            for (Edge e : neighbors.get(current)) {

                if (!isVisited[e.v]) { //if the vertex on the end of the edge has not been visited then...
                    parent[e.v] = current; //set the parent of the vertex e.v as current in the dfs tree
                    stack.push(e.v); //add the unvisited vertex to the stack to keep record of the vertex that need to be visited
                    isVisited[e.v] = true; //set isVisited to true
                }
            }
        }
        return new Tree(v, parent, searchOrder);
    }

    public static void main(String[] args) {
        //vertices from the textbook
        String[] vertices = {"Seattle", "San Francisco", "Los Angeles",
                "Denver", "Kansas City", "Chicago", "Boston", "New York",
                "Atlanta", "Miami", "Dallas", "Houston"};

        int[][] edges = {//edges from the textbook
                {0, 1}, {0, 3}, {0, 5},
                {1, 0}, {1, 2}, {1, 3},
                {2, 1}, {2, 3}, {2, 4}, {2, 10},
                {3, 0}, {3, 1}, {3, 2}, {3, 4}, {3, 5},
                {4, 2}, {4, 3}, {4, 5}, {4, 7}, {4, 8}, {4, 10},
                {5, 0}, {5, 3}, {5, 4}, {5, 6}, {5, 7},
                {6, 5}, {6, 7},
                {7, 4}, {7, 5}, {7, 6}, {7, 8},
                {8, 4}, {8, 7}, {8, 9}, {8, 10}, {8, 11},
                {9, 8}, {9, 11},
                {10, 2}, {10, 4}, {10, 8}, {10, 11},
                {11, 8}, {11, 9}, {11, 10}
        };

        Graph<String> graph = new UnweightedGraph<>(vertices, edges); //creating a graph

        //calling a depth first search on the created graph, starting from index 5
        UnweightedGraph<String>.Tree dfs = graph.dfs(5);

        //print out the searchOrder result from the DFS on the graph
        System.out.println(dfs.getSearchOrder());

        //print the resulting tree
        dfs.printTree();
    }
}
