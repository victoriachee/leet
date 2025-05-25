package algos.Graph;
import java.util.*;

/**
 * Java program demonstrating depth-first search (DFS) traversal on an undirected graph.
 */
public class _DFSExampleUndirectedList {

    static class Graph {
        private final Map<Integer, List<Integer>> graph;

        public Graph() {
            this.graph = new HashMap<>();
        }

        public void addEdge(int u, int v) {
            graph.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            graph.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }

        public List<Integer> dfsTraversal() {
            List<Integer> result = new ArrayList<>();
            Set<Integer> visited = new HashSet<>();

            for (int node : graph.keySet()) {
                if (!visited.contains(node)) {
                    dfs(node, visited, result);
                }
            }

            return result;
        }

        private void dfs(int node, Set<Integer> visited, List<Integer> result) {
            visited.add(node);
            result.add(node);

            for (int neighbor : graph.getOrDefault(node, Collections.emptyList())) {
                if (!visited.contains(neighbor)) {
                    dfs(neighbor, visited, result);
                }
            }
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);
        graph.addEdge(4, 5);

        List<Integer> result = graph.dfsTraversal();
        System.out.println("DFS Traversal: " + result);
    }
}
