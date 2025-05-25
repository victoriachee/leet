package algos.Graph.Traversal;

import java.util.LinkedList;
import java.util.Queue;

public class _BFSExample2DArray {

   public static void main(String[] args) {
      // Example 1: Check if there is a path between two nodes
      int[][] graph0 = {
         { 0, 1, 1, 0, 0 },
         { 1, 0, 0, 1, 1 },
         { 1, 0, 0, 0, 1 },
         { 0, 1, 0, 0, 1 },
         { 0, 1, 1, 1, 0 },
      };
      int source1 = 0, destination1 = 3;
      System.out.println(
         "Is there a path from " +
         source1 +
         " to " +
         destination1 +
         "? " +
         hasPath(graph0, source1, destination1) +
         "\n"
      );

      int[][] exampleGraph = {
         { 0, 1, 0, 1, 0 },
         { 1, 0, 1, 1, 0 },
         { 0, 1, 0, 1, 1 },
         { 1, 1, 1, 0, 1 },
         { 0, 0, 1, 1, 0 },
      };

      // Check if the graph is connected
      boolean isConnected = isConnectedGraph(exampleGraph);
      System.out.println("Is Graph Connected: " + isConnected);

      // Find the shortest path between two nodes
      int shortestPath = shortestPathBFS(exampleGraph, 0, 4);
      System.out.println("Shortest Path between Node 0 and Node 4: " + shortestPath);

      // Example 1: BFS Traversal
      int[][] graph1 = {
         { 0, 1, 1, 0, 0 },
         { 1, 0, 0, 1, 1 },
         { 1, 0, 0, 0, 1 },
         { 0, 1, 0, 0, 1 },
         { 0, 1, 1, 1, 0 },
      };
      System.out.println("BFS Traversal:");
      bfsTraversal(graph1, 0);
      System.out.println("\n");

      // Example 2: Check if the graph is a tree
      int[][] graph2 = {
         { 0, 1, 0, 0, 0 },
         { 1, 0, 1, 0, 0 },
         { 0, 1, 0, 1, 1 },
         { 0, 0, 1, 0, 1 },
         { 0, 0, 1, 1, 0 },
      };
      System.out.println("Is the graph a tree? " + isTree(graph2) + "\n");

      // Example 3: Count Connected Components
      int[][] graph3 = {
         { 0, 1, 0, 1, 0 },
         { 1, 0, 0, 1, 0 },
         { 0, 0, 0, 0, 1 },
         { 1, 1, 0, 0, 0 },
         { 0, 0, 1, 0, 0 },
      };
      System.out.println("Number of Connected Components: " + countConnectedComponents(graph3));
   }
   // --------------------------------------------------------------------
   /**
    * Checks if there is a path between two nodes in a graph represented by an adjacency matrix.
    *
    * @param graph        The adjacency matrix representing the graph.
    * @param source       The source node.
    * @param destination  The destination node.
    * @return True if there is a path between the source and destination, false otherwise.
    */
   // Function to check if there is a path between two nodes
   private static boolean hasPath(int[][] graph, int source, int destination) {
      int numNodes = graph.length;
      boolean[] visited = new boolean[numNodes];

      LinkedList<Integer> queue = new LinkedList<>();
      visited[source] = true;
      queue.add(source);

      while (!queue.isEmpty()) {
         int current = queue.poll();

         for (int neighbor = 0; neighbor < numNodes; neighbor++) {
            if (graph[current][neighbor] == 1 && !visited[neighbor]) {
               if (neighbor == destination) {
                  return true; // Path found
               }
               visited[neighbor] = true;
               queue.add(neighbor);
            }
         }
      }

      return false; // No path found
   }
   // --------------------------------------------------------------------
   /**
    * Check if the given graph is connected using BFS.
    *
    * @param graph The adjacency matrix representing the graph.
    * @return True if the graph is connected, false otherwise.
    */
   public static boolean isConnectedGraph(int[][] graph) {
      int nodes = graph.length;
      boolean[] visited = new boolean[nodes];
      Queue<Integer> queue = new LinkedList<>();

      // Start BFS from the first node
      queue.offer(0);
      visited[0] = true;

      while (!queue.isEmpty()) {
         int currentNode = queue.poll();

         // Explore neighbors
         for (int neighbor = 0; neighbor < nodes; neighbor++) {
            if (graph[currentNode][neighbor] == 1 && !visited[neighbor]) {
               queue.offer(neighbor);
               visited[neighbor] = true;
            }
         }
      }

      // Check if all nodes are visited
      for (boolean nodeVisited : visited) {
         if (!nodeVisited) {
            return false; // Graph is not connected
         }
      }

      return true; // Graph is connected
   }
   // --------------------------------------------------------------------
   /**
    * Find the shortest path between two nodes in the graph using BFS.
    *
    * @param graph The adjacency matrix representing the graph.
    * @param start The starting node.
    * @param end   The destination node.
    * @return The length of the shortest path between start and end. Return -1 if no path exists.
    */
   public static int shortestPathBFS(int[][] graph, int start, int end) {
      int nodes = graph.length;
      boolean[] visited = new boolean[nodes];
      Queue<Integer> queue = new LinkedList<>();
      int[] distance = new int[nodes];

      // Start BFS from the start node
      queue.offer(start);
      visited[start] = true;

      while (!queue.isEmpty()) {
         int currentNode = queue.poll();

         // Explore neighbors
         for (int neighbor = 0; neighbor < nodes; neighbor++) {
            if (graph[currentNode][neighbor] == 1 && !visited[neighbor]) {
               queue.offer(neighbor);
               visited[neighbor] = true;
               distance[neighbor] = distance[currentNode] + 1;

               if (neighbor == end) {
                  return distance[neighbor]; // Found the shortest path
               }
            }
         }
      }

      return -1; // No path exists
   }
   // --------------------------------------------------------------------
   /**
    * Perform BFS traversal starting from a given node.
    *
    * @param graph The adjacency matrix representing the graph.
    * @param start The starting node.
    */
   public static void bfsTraversal(int[][] graph, int start) {
      int nodes = graph.length;
      boolean[] visited = new boolean[nodes];
      Queue<Integer> queue = new LinkedList<>();

      // Start BFS from the given node
      queue.offer(start);
      visited[start] = true;

      while (!queue.isEmpty()) {
         int currentNode = queue.poll();
         System.out.print(currentNode + " ");

         // Explore neighbors
         for (int neighbor = 0; neighbor < nodes; neighbor++) {
            if (graph[currentNode][neighbor] == 1 && !visited[neighbor]) {
               queue.offer(neighbor);
               visited[neighbor] = true;
            }
         }
      }
   }
   // --------------------------------------------------------------------
   /**
    * Check if the graph is a tree (acyclic and connected) using BFS.
    *
    * @param graph The adjacency matrix representing the graph.
    * @return True if the graph is a tree, false otherwise.
    */
   public static boolean isTree(int[][] graph) {
      int nodes = graph.length;
      boolean[] visited = new boolean[nodes];
      Queue<Integer> queue = new LinkedList<>();

      // Start BFS from the first node
      queue.offer(0);
      visited[0] = true;

      while (!queue.isEmpty()) {
         int currentNode = queue.poll();

         // Explore neighbors
         for (int neighbor = 0; neighbor < nodes; neighbor++) {
            if (graph[currentNode][neighbor] == 1) {
               if (visited[neighbor]) {
                  return false; // Cycle detected, not a tree
               } else {
                  queue.offer(neighbor);
                  visited[neighbor] = true;
               }
            }
         }
      }

      // Check if all nodes are visited
      for (boolean nodeVisited : visited) {
         if (!nodeVisited) {
            return false; // Graph is not connected, not a tree
         }
      }

      return true; // Graph is a tree
   }
   // --------------------------------------------------------------------
   /**
    * Find the number of connected components in the graph using BFS.
    *
    * @param graph The adjacency matrix representing the graph.
    * @return The number of connected components.
    */
   public static int countConnectedComponents(int[][] graph) {
      int nodes = graph.length;
      int components = 0;
      boolean[] visited = new boolean[nodes];
      Queue<Integer> queue = new LinkedList<>();

      for (int node = 0; node < nodes; node++) {
         if (!visited[node]) {
            // Start BFS from unvisited nodes to find connected components
            queue.offer(node);
            visited[node] = true;
            components++;

            while (!queue.isEmpty()) {
               int currentNode = queue.poll();

               // Explore neighbors
               for (int neighbor = 0; neighbor < nodes; neighbor++) {
                  if (graph[currentNode][neighbor] == 1 && !visited[neighbor]) {
                     queue.offer(neighbor);
                     visited[neighbor] = true;
                  }
               }
            }
         }
      }

      return components;
   }
}
