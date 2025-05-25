package algos.Graph.Traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _DFSExample2DArray {

   /**
    * Performs Depth-First Search (DFS) traversal on the given graph and prints the order of visited nodes.
    *
    * @param graph The adjacency matrix representation of the graph.
    * @param start The starting node for DFS traversal.
    */
   private static void dfsTraversal(int[][] graph, int start) {
      int numNodes = graph.length;
      boolean[] visited = new boolean[numNodes];

      System.out.println("DFS Traversal from Node " + start + ":");
      // Start DFS traversal from the specified node
      dfsRecursive(graph, start, visited);
      System.out.println();
   }

   /**
    * Helper function for recursive DFS traversal.
    *
    * @param graph   The adjacency matrix representation of the graph.
    * @param current The current node in DFS traversal.
    * @param visited An array to mark visited nodes.
    */
   private static void dfsRecursive(int[][] graph, int current, boolean[] visited) {
      visited[current] = true;
      System.out.print(current + " ");

      // Explore neighbors of the current node
      for (int neighbor = 0; neighbor < graph.length; neighbor++) {
         if (graph[current][neighbor] == 1 && !visited[neighbor]) {
            // Recursively visit the unvisited neighbor
            dfsRecursive(graph, neighbor, visited);
         }
      }
   }
   // --------------------------------------------------------------------
   /**
    * Performs Depth-First Search (DFS) traversal on the given graph using an iterative approach
    * and prints the order of visited nodes.
    *
    * @param graph The adjacency matrix representation of the graph.
    * @param start The starting node for DFS traversal.
    */
   private static void dfsTraversalIterative(int[][] graph, int start) {
      int numNodes = graph.length;
      boolean[] visited = new boolean[numNodes];
      Stack<Integer> stack = new Stack<>();

      System.out.println("DFS Traversal (Iterative) from Node " + start + ":");
      stack.push(start);

      while (!stack.isEmpty()) {
         int current = stack.pop();

         if (!visited[current]) {
            visited[current] = true;
            System.out.print(current + " ");

            // Explore neighbors of the current node in reverse order
            for (int neighbor = numNodes - 1; neighbor >= 0; neighbor--) {
               if (graph[current][neighbor] == 1 && !visited[neighbor]) {
                  // Push unvisited neighbors onto the stack
                  stack.push(neighbor);
               }
            }
         }
      }

      System.out.println();
   }
   // --------------------------------------------------------------------
   /**
    * Determines if there is a path from the start node to the destination node in the given graph using DFS.
    *
    * @param graph        The adjacency matrix representation of the graph.
    * @param start        The starting node.
    * @param destination  The destination node.
    * @return True if there is a path, false otherwise.
    */
   public static boolean hasPath(int[][] graph, int start, int destination) {
      int numNodes = graph.length;
      boolean[] visited = new boolean[numNodes];

      // Use DFS to check for a path
      return hasPathDFS(graph, start, destination, visited);
   }

   /**
    * Helper function for DFS to check if there is a path between two nodes.
    *
    * @param graph       The adjacency matrix representation of the graph.
    * @param current     The current node.
    * @param destination The destination node.
    * @param visited     An array to mark visited nodes.
    * @return True if there is a path, false otherwise.
    */
   private static boolean hasPathDFS(
      int[][] graph,
      int current,
      int destination,
      boolean[] visited
   ) {
      visited[current] = true;

      if (current == destination) {
         return true; // Path found
      }

      // Explore neighbors of the current node
      for (int neighbor = 0; neighbor < graph.length; neighbor++) {
         if (graph[current][neighbor] == 1 && !visited[neighbor]) {
            // Recursively check for a path from the neighbor to the destination
            if (hasPathDFS(graph, neighbor, destination, visited)) {
               return true;
            }
         }
      }

      return false; // No path found
   }
   // --------------------------------------------------------------------
   /**
    * Finds the number of connected components in the graph using Depth-First Search (DFS).
    *
    * @param graph The adjacency matrix representation of the graph.
    * @return The number of connected components.
    */
   public static int countConnectedComponents(int[][] graph) {
      int numNodes = graph.length;
      boolean[] visited = new boolean[numNodes];
      int connectedComponents = 0;

      for (int node = 0; node < numNodes; node++) {
         if (!visited[node]) {
            // Increment the count and perform DFS on unvisited nodes
            connectedComponents++;
            dfsRecursive(graph, node, visited);
         }
      }

      return connectedComponents;
   }
   // --------------------------------------------------------------------
   /**
    * Finds a topological ordering of nodes in a directed acyclic graph (DAG) using Depth-First Search (DFS).
    *
    * @param graph The adjacency matrix representation of the DAG.
    * @return A topological ordering of nodes.
    */
   public static List<Integer> topologicalOrder(int[][] graph) {
      int numNodes = graph.length;
      boolean[] visited = new boolean[numNodes];
      Stack<Integer> stack = new Stack<>();
      List<Integer> topOrder = new ArrayList<>();

      for (int node = 0; node < numNodes; node++) {
         if (!visited[node]) {
            // Perform DFS to populate the stack with topologically ordered nodes
            topologicalOrderDFS(graph, node, visited, stack);
         }
      }

      // Pop elements from the stack to get the topological order
      while (!stack.isEmpty()) {
         topOrder.add(stack.pop());
      }

      return topOrder;
   }

   /**
    * Helper function for DFS to perform topological ordering of nodes.
    *
    * @param graph   The adjacency matrix representation of the DAG.
    * @param current The current node.
    * @param visited An array to mark visited nodes.
    * @param stack   The stack for maintaining topological order.
    */
   private static void topologicalOrderDFS(
      int[][] graph,
      int current,
      boolean[] visited,
      Stack<Integer> stack
   ) {
      visited[current] = true;

      // Explore neighbors of the current node
      for (int neighbor = 0; neighbor < graph.length; neighbor++) {
         if (graph[current][neighbor] == 1 && !visited[neighbor]) {
            // Recursively perform DFS to obtain topological order
            topologicalOrderDFS(graph, neighbor, visited, stack);
         }
      }

      // Push the current node onto the stack after visiting all neighbors
      stack.push(current);
   }
   // --------------------------------------------------------------------
   /**
    * Checks if there is a cycle in an undirected graph using Depth-First Search (DFS).
    *
    * @param graph The adjacency matrix representation of the undirected graph.
    * @return True if there is a cycle, false otherwise.
    */
   private static boolean hasCycleUndirected(int[][] graph) {
      int numNodes = graph.length;
      boolean[] visited = new boolean[numNodes];

      for (int node = 0; node < numNodes; node++) {
         if (!visited[node]) {
            // Use DFS to detect cycles in each connected component
            if (hasCycleUndirectedDFS(graph, node, -1, visited)) {
               return true;
            }
         }
      }

      return false;
   }

   /**
    * Helper function for DFS to check for cycles in an undirected graph.
    *
    * @param graph   The adjacency matrix representation of the undirected graph.
    * @param current The current node.
    * @param parent  The parent node in the DFS traversal.
    * @param visited An array to mark visited nodes.
    * @return True if a cycle is detected, false otherwise.
    */
   private static boolean hasCycleUndirectedDFS(
      int[][] graph,
      int current,
      int parent,
      boolean[] visited
   ) {
      visited[current] = true;

      // Explore neighbors of the current node
      for (int neighbor = 0; neighbor < graph.length; neighbor++) {
         if (graph[current][neighbor] == 1) {
            if (!visited[neighbor]) {
               // If the neighbor is not visited, continue DFS
               if (hasCycleUndirectedDFS(graph, neighbor, current, visited)) {
                  return true;
               }
            } else if (neighbor != parent) {
               // If the neighbor is visited and not the parent, a cycle is found
               return true;
            }
         }
      }

      return false;
   }
   // --------------------------------------------------------------------
   /**
    * Checks if there is a cycle in a directed graph using Depth-First Search (DFS).
    *
    * @param graph The adjacency matrix representation of the directed graph.
    * @return True if there is a cycle, false otherwise.
    */
   private static boolean hasCycleDirected(int[][] graph) {
      int numNodes = graph.length;
      boolean[] visited = new boolean[numNodes];
      boolean[] recStack = new boolean[numNodes];

      for (int node = 0; node < numNodes; node++) {
         if (!visited[node]) {
            // Use DFS to detect cycles in each connected component
            if (hasCycleDirectedDFS(graph, node, visited, recStack)) {
               return true;
            }
         }
      }

      return false;
   }

   /**
    * Helper function for DFS to check for cycles in a directed graph.
    *
    * @param graph   The adjacency matrix representation of the directed graph.
    * @param current The current node.
    * @param visited An array to mark visited nodes.
    * @param recStack An array to keep track of nodes in the current recursion stack.
    * @return True if a cycle is detected, false otherwise.
    */
   private static boolean hasCycleDirectedDFS(
      int[][] graph,
      int current,
      boolean[] visited,
      boolean[] recStack
   ) {
      visited[current] = true;
      recStack[current] = true;

      // Explore neighbors of the current node
      for (int neighbor = 0; neighbor < graph.length; neighbor++) {
         if (graph[current][neighbor] == 1) {
            if (!visited[neighbor]) {
               // If the neighbor is not visited, continue DFS
               if (hasCycleDirectedDFS(graph, neighbor, visited, recStack)) {
                  return true;
               }
            } else if (recStack[neighbor]) {
               // If the neighbor is in the current recursion stack, a cycle is found
               return true;
            }
         }
      }

      // Remove the current node from the recursion stack after DFS
      recStack[current] = false;

      return false;
   }
   // --------------------------------------------------------------------
   /**
    * Example usage of DFS traversal functions.
    *
    * @param args Command line arguments (unused).
    */
   public static void main(String[] args) {
      int[][] graph = {
         { 0, 1, 1, 0, 0 },
         { 1, 0, 0, 1, 0 },
         { 1, 0, 0, 1, 1 },
         { 0, 1, 1, 0, 1 },
         { 0, 0, 1, 1, 0 },
      };

      int startNode = 0;
      int destinationNode = 3;

      // Demonstrate DFS traversal functions
      dfsTraversal(graph, startNode);
      dfsTraversalIterative(graph, startNode);
      // Demonstrate hasPath function
      boolean hasPath = hasPath(graph, startNode, destinationNode);
      System.out.println(
         "Path from Node " + startNode + " to Node " + destinationNode + ": " + hasPath
      );

      int[][] graph2 = {
         { 0, 1, 0, 0, 0 },
         { 0, 0, 1, 0, 0 },
         { 0, 0, 0, 1, 1 },
         { 1, 0, 0, 0, 0 },
         { 0, 0, 0, 1, 0 },
      };

      // Demonstrate countConnectedComponents function
      int connectedComponents = countConnectedComponents(graph2);
      System.out.println("Number of Connected Components: " + connectedComponents);

      // Demonstrate topologicalOrder function
      List<Integer> topOrder = topologicalOrder(graph2);
      System.out.println("Topological Order: " + topOrder);

      int[][] undirectedGraph = {
         { 0, 1, 1, 0, 0 },
         { 1, 0, 0, 1, 0 },
         { 1, 0, 0, 1, 1 },
         { 0, 1, 1, 0, 1 },
         { 0, 0, 1, 1, 0 },
      };

      /*
        Undirected Graph:  
        In an undirected graph, the edges have no direction. They simply connect two nodes, and the relationship is symmetric.
        If there is an edge between nodes A and B, it implies that there is also an edge between B and A.
        The edge is represented as an unordered pair {A, B}.
        A ---- B
        |      |
        C ---- D 
        Here, the edges are {A, B}, {A, C}, {B, D}, {C, D}.
        Undirected Graph:  
        In a directed graph, each edge has a direction. It goes from one node (the source) to another node (the target).
        The relationship is asymmetric. If there is a directed edge from A to B, it does not imply a directed edge from B to A unless specifically defined.
        The directed edge is represented as an ordered pair (A, B).
        A ---> B
        |      |
        v      v
        C ---> D
        Here, the directed edges are (A, B), (A, C), (B, D), (C, D).
       */

      int[][] directedGraph = {
         { 0, 1, 1, 0, 0 },
         { 0, 0, 0, 1, 0 },
         { 0, 0, 0, 1, 1 },
         { 0, 0, 0, 0, 1 },
         { 0, 0, 0, 0, 0 },
      };

      // Demonstrate hasCycleUndirected function
      boolean hasCycleUndirected = hasCycleUndirected(undirectedGraph);
      System.out.println("Undirected Graph Has Cycle: " + hasCycleUndirected);

      // Demonstrate hasCycleDirected function
      boolean hasCycleDirected = hasCycleDirected(directedGraph);
      System.out.println("Directed Graph Has Cycle: " + hasCycleDirected);
   }
}
