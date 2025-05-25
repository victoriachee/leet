/**
 * * 133. Clone Graph
 * URL: https://leetcode.com/problems/clone-graph/
 * !! MEDIUM
 * #DFS  #BFS
 *
 * Given a reference of a node in a connected undirected graph, return a deep copy of
 * the graph. Each node has a value (int) and a list (List[Node]) of neighbors.
 *
 * class Node { public int val; public List<Node> neighbors; }
 *
 * Example 1: [[2,4],[1,3],[2,4],[1,3]] -> [[2,4],[1,3],[2,4],[1,3]]
 *            (4 nodes, each connected to two others)
 * Example 2: []    -> []   (Empty graph)
 * Example 3: [[]]  -> [[]] (Graph with a single node having no neighbors)
 *
 * Constraints: 0 <= nodes <= 100, 1 <= Node.val <= 100, unique Node.val, no repeated
 * edges or self-loops, connected graph.
 *
 * @see
 *     https://leetcode.com/problems/clone-graph/solutions/3392096/image-explanation-bfs-dfs-colored-examples-code-c-java/
 */

package algos.Graph.Traversal;

import java.util.ArrayList;
import java.util.HashMap;

public class CloneGraph_DFS_HashMap {

   // Runtime: 28ms Beats 25.48% of users with Java
   public Node cloneGraph(Node node) {
      if (node == null) return null;
      final var copy = new Node(node.val); // Empty neighbors list
      final var copied = new HashMap<Integer, Node>();
      dfs(node, copy, copied);
      return copy;
   }

   /**
    * Deep clones the graph using DFS
    * @param real Original node
    * @param copy Copy of original Node
    * @param copied tracks copied (visited) nodes with val and node
    */
   private void dfs(Node realNode, Node copyNode, HashMap<Integer, Node> copied) {
      // Only explore neighbors of real node if it is unvisited (not already copied)
      if (!copied.containsKey(copyNode.val)) {
         // Mark node as copied, and add copy to list
         copied.put(copyNode.val, copyNode);

         // Explore all neighbors of unvisited real node to see if it is visited
         for (Node neighbor : realNode.neighbors) {
            // Get copy of real node's neighbor
            final var neighborCopy = copied.getOrDefault(neighbor.val, new Node(neighbor.val));

            // Update copy node's neighbors with copy of real neighbor/new node
            copyNode.neighbors.add(neighborCopy);

            // DFS recursively to visit all nodes that are uncopied
            dfs(neighbor, neighborCopy, copied);
         }
      }
   }

   public static void main(String[] args) {
      // Test cases
      CloneGraph_DFS_HashMap solution = new CloneGraph_DFS_HashMap();

      // Test case 1
      // Example 1
      Node node1 = new Node(1);
      Node node2 = new Node(2);
      Node node3 = new Node(3);
      Node node4 = new Node(4);
      node1.neighbors.add(node2);
      node1.neighbors.add(node4);
      node2.neighbors.add(node1);
      node2.neighbors.add(node3);
      node3.neighbors.add(node2);
      node3.neighbors.add(node4);
      node4.neighbors.add(node1);
      node4.neighbors.add(node3);
      // Test case 1
      Node result1 = solution.cloneGraph(node1);
      System.out.println("Original Graph:");
      GraphPrinter.printGraph(node1);
      System.out.println("Cloned Graph:");
      GraphPrinter.printGraph(result1);

      // Test case 2
      Node result2 = solution.cloneGraph(new Node());
      System.out.println("Original Graph:");
      GraphPrinter.printGraph(new Node());
      System.out.println("Cloned Graph:");
      GraphPrinter.printGraph(result2);

      // Test case 3
      Node result3 = solution.cloneGraph(new Node(1, new ArrayList<>()));
      System.out.println("Original Graph:");
      GraphPrinter.printGraph(new Node(1, new ArrayList<>()));
      System.out.println("Cloned Graph:");
      GraphPrinter.printGraph(result3);
   }
}
