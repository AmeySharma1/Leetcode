/* 
 * Problem: 802. Find Eventual Safe States
 *
 * Given:
 * - Directed graph[][] where:
 *
 * graph[i] = list of nodes
 * reachable from node i
 *
 * Task:
 * - Return all eventual safe nodes
 *
 * -------------------------------------------------------
 * What is a Safe Node?
 *
 * A node is safe if:
 *
 * Every possible path starting
 * from that node eventually
 * ends at a terminal node.
 *
 * -------------------------------------------------------
 * What is a Terminal Node?
 *
 * A node having:
 *
 * 0 outgoing edges
 *
 * Example:
 *
 * 5 → []
 *
 * Node 5 is terminal.
 *
 * -------------------------------------------------------
 * Unsafe Nodes:
 *
 * Nodes involved in cycle
 * OR
 * nodes leading to cycle
 *
 * are NOT safe.
 *
 * -------------------------------------------------------
 * Core Idea:
 *
 * Safe nodes are:
 *
 * Nodes that eventually reach
 * terminal nodes.
 *
 * We solve this using:
 *
 * Reverse Graph + Kahn's Algorithm
 *
 * -------------------------------------------------------
 * Important Trick:
 *
 * Instead of removing incoming edges,
 * we remove outgoing dependencies.
 *
 * So:
 *
 * Reverse all edges.
 *
 * -------------------------------------------------------
 * Why Reverse Graph?
 *
 * Original:
 *
 * u → v
 *
 * Reverse:
 *
 * v → u
 *
 * This allows us to:
 *
 * Start BFS from terminal nodes
 * and move backwards.
 *
 * -------------------------------------------------------
 * Important Observation:
 *
 * Terminal nodes are always safe.
 *
 * After removing them:
 *
 * Some other nodes may become safe.
 *
 * Similar to Topological Sort.
 *
 * -------------------------------------------------------
 * Logic:
 *
 * 1. Reverse the graph
 *
 * 2. Store outdegree using indegree[]
 *
 *      indegree[i]
 *      = outgoing edges count
 *
 * 3. Push terminal nodes
 *    (outdegree = 0)
 *
 * 4. Perform BFS:
 *
 *      a) Remove node
 *      b) Mark safe
 *      c) Reduce outdegree of parents
 *      d) If parent outdegree becomes 0:
 *             push into queue
 *
 * 5. Sort answer
 *
 * -------------------------------------------------------
 * Dry Run:
 *
 * graph =
 *
 * [
 *   [1,2],
 *   [2,3],
 *   [5],
 *   [0],
 *   [5],
 *   [],
 *   []
 * ]
 *
 * --------------------------------
 * Terminal nodes:
 *
 * 5,6
 *
 * Queue = [5,6]
 *
 * --------------------------------
 * Remove 5
 *
 * Nodes leading to 5:
 *
 * 2,4
 *
 * Reduce their outdegree
 *
 * 4 becomes 0
 *
 * Queue = [6,4]
 *
 * --------------------------------
 * Remove 4
 *
 * Safe node found
 *
 * Continue BFS...
 *
 * Final Safe Nodes:
 *
 * [2,4,5,6]
 *
 * -------------------------------------------------------
 * Why Cycle Nodes Never Become Safe?
 *
 * Cycle nodes always keep:
 *
 * outgoing dependency > 0
 *
 * So they never enter queue.
 *
 * -------------------------------------------------------
 * Pseudocode:
 *
 * function eventualSafeNodes(graph):
 *
 *      reverse graph
 *
 *      compute outdegree[]
 *
 *      queue terminal nodes
 *
 *      while queue not empty:
 *
 *          node = queue.remove()
 *
 *          mark safe
 *
 *          for parent in reverseGraph[node]:
 *
 *              outdegree[parent]--
 *
 *              if outdegree[parent] == 0:
 *                  queue.add(parent)
 *
 *      sort answer
 *
 *      return answer
 *
 * -------------------------------------------------------
 * Time Complexity:
 *
 * O(V + E)
 *
 * -------------------------------------------------------
 * Space Complexity:
 *
 * O(V + E)
 *
 * -------------------------------------------------------
 * Pattern:
 *
 * Graph + Reverse Graph + BFS + Kahn's Algorithm
 *
 * -------------------------------------------------------
 * Code:
 */

import java.util.*;

class Solution {

    public List<Integer> eventualSafeNodes(int[][] graph) {

        int n = graph.length;

        // Reverse graph
        List<List<Integer>> reverseGraph = new ArrayList<>();

        // Stores outgoing edge count
        int[] indegree = new int[n];

        for (int i = 0; i < n; i++) {

            reverseGraph.add(new ArrayList<>());
        }

        // Reverse graph construction
        // and calculate outdegree
        for (int i = 0; i < n; i++) {

            for (int neighbor : graph[i]) {

                reverseGraph.get(neighbor).add(i);

                indegree[i]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();

        // Terminal nodes
        for (int i = 0; i < n; i++) {

            if (indegree[i] == 0) {

                queue.add(i);
            }
        }

        List<Integer> safeNodes = new ArrayList<>();

        // Kahn's BFS
        while (!queue.isEmpty()) {

            int node = queue.poll();

            safeNodes.add(node);

            // Traverse parent nodes
            for (int neighbor : reverseGraph.get(node)) {

                indegree[neighbor]--;

                // Node becomes safe
                if (indegree[neighbor] == 0) {

                    queue.add(neighbor);
                }
            }
        }

        // Return nodes in sorted order
        Collections.sort(safeNodes);

        return safeNodes;
    }
}
