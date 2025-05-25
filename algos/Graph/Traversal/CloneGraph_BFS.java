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
import java.util.LinkedList;
import java.util.Queue;

public class CloneGraph_BFS {

   // Runtime: 37ms Beats 7.27% of users with Java
   public Node cloneGraph(Node node) {
      if (node == null) return null;

      Node copy = new Node(node.val);
      HashMap<Node, Node> nodeCopy = new HashMap<>();
      nodeCopy.put(node, copy);

      Queue<Node> queue = new LinkedList<>();
      queue.offer(node);
      while (!queue.isEmpty()) {
         Node curr = queue.poll(); // Pop node from queue (e.g. {1})
         for (Node nb : curr.neighbors) { // Loop though neighbors of real node (e.g. <-> 2 <-> {1} <-> 4 <-> 3 <->)
            if (!nodeCopy.containsKey(nb)) { // Check if neighbor is visited (e.g. nodeCopy only has [1] at start)
               queue.offer(nb); // If not visited, add real neighbor to queue (e.g. queue {1} => {2} {4} => {3})
               nodeCopy.put(nb, new Node(nb.val)); // If not visited, copy (visit) neighbor (e.g. nodeCopy has [1] & [2] & [4])
            }

            // Update curr node's neighbors list with copy of neighbors
            nodeCopy.get(curr).neighbors.add(nodeCopy.get(nb));
            // copy[1]=>        2 <--[1]--> 4           => connect copy of 1 to copy of 2 & 4 with empty neighbours
            // copy[2]=> [3]<--[2]<->[1]--> 4           => connect copy of 2 to copy of existing 1 & 3 with empty neighbours
            // copy[4]=>  3 <--[2]<->[1]<->[4]-->[3]    => connect copy of 4 to copy of existing 1 & 3
            // copy[3]=>  3 <->[2]<->[1]<->[4]<->[3]<-> => connect copy of 3 to copy of existing 2 & 4

         }
      }
      return copy;
   }

   public static void main(String[] args) {
      // Test cases
      CloneGraph_BFS solution = new CloneGraph_BFS();

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

