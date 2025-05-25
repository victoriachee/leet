package algos.Graph.Traversal;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

class GraphPrinter {

   public static void printGraph(Node node) {
      if (node == null) {
         System.out.println("Graph is null.");
         return;
      }

      HashMap<Node, Integer> nodeIndexMap = new HashMap<>();
      assignIndexes(node, nodeIndexMap);

      List<Node> sortedNodes = new ArrayList<>(nodeIndexMap.keySet());
      sortedNodes.sort(Comparator.comparingInt(nodeIndexMap::get));

      for (Node currentNode : sortedNodes) {
         int index = nodeIndexMap.get(currentNode);
         System.out.print("Node " + index + " (Val: " + currentNode.val + ") -> Neighbors: ");
         for (Node neighbor : currentNode.neighbors) {
            System.out.print(nodeIndexMap.get(neighbor) + " ");
         }
         System.out.println();
      }
   }

   private static void assignIndexes(Node node, HashMap<Node, Integer> nodeIndexMap) {
      if (node == null || nodeIndexMap.containsKey(node)) {
         return;
      }

      nodeIndexMap.put(node, nodeIndexMap.size() + 1);
      for (Node neighbor : node.neighbors) {
         assignIndexes(neighbor, nodeIndexMap);
      }
   }
}
