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
import java.util.Arrays;

public class CloneGraph_DFS_IntArray {

   // Runtime: 29ms Beats 13.34% of users with Java
   public Node cloneGraph(Node node) {
      if (node == null) return null; // if the actual node is empty there is nothing to copy, so return null
      Node copy = new Node(node.val); // create a new node , with same value as the root node(given node)
      Node[] visited = new Node[101]; // in this question we will create an array of Node(not boolean) why ?,
      // because i have to add all the adjacent nodes of particular vertex, whether
      // it's visited or not, so in the Node[] initially null is stored, if that
      // node is visited, we will store the respective node at the index, and can
      // retrieve that easily.
      Arrays.fill(visited, null); // initially store null at all places
      dfs(node, copy, visited); // make a dfs call for traversing all the vertices of the root node
      return copy; // in the end return the copy node
   }

   public void dfs(Node node, Node copy, Node[] visited) {
      visited[copy.val] = copy; // store the current node at it's val index which will tell us that
      // this node is now visited

      // now traverse for the adjacent nodes of root node
      for (Node n : node.neighbors) {
         // check whether that node is visited or not
         // if it is not visited, there must be null
         if (visited[n.val] == null) {
            // so now if it not visited, create a new node
            Node newNode = new Node(n.val);
            // add this node as the neighbor of the prev copied node
            copy.neighbors.add(newNode);
            // make dfs call for this unvisited node to discover whether it's adjacent
            // nodes are explored or not
            dfs(n, newNode, visited);
         } else {
            // if that node is already visited, retrieve that node from visited array
            // and add it as the adjacent node of prev copied node THIS IS THE POINT WHY
            // WE USED NODE[] INSTEAD OF BOOLEAN[] ARRAY
            copy.neighbors.add(visited[n.val]);
         }
      }
   }

   public static void main(String[] args) {
      // Test cases
      CloneGraph_DFS_IntArray solution = new CloneGraph_DFS_IntArray();

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
