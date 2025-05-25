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

public class CloneGraph_DFS_Best {

   // Runtime: 25ms Beats 96.94% of users with Java
   HashMap<Node, Node> nodeCopy = new HashMap<>();

   public Node cloneGraph(Node node) {
      // Base condition
      if (node == null) return null;
      // If node visited, return copy & exit recursive call
      if (nodeCopy.containsKey(node)) return nodeCopy.get(node);
      // If node unvisited, add new copy
      nodeCopy.put(node, new Node(node.val));

      for (Node val : node.neighbors) { // Visit left and right neighbors
         /*
          * Connects 'copy' to its children recursively, calling dfs on the left child,
          * returning 'copy' and adding 'copy' neighbor when the child is already visited.
          * Children that are copied get more nested neighbors deeper into the call stack.
          * Goes deeper into the left and right child until all nodes are explored, then
          * recursively exits the call stack, adding copied child as neighbors.
          * Return a copy of the left child node with all connections, then call dfs on the
          * right child, connect to the right child copy with all connections, completing
          * the graph traversal.
          */
         nodeCopy.get(node).neighbors.add(cloneGraph(val));
      }

      return nodeCopy.get(node);
   }

   public static void main(String[] args) {
      // Test cases
      CloneGraph_DFS_Best solution = new CloneGraph_DFS_Best();

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
