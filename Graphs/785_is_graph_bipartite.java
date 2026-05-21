/* 
 * Problem: 785. Is Graph Bipartite?
 *
 * Given:
 * - graph[][] representing an undirected graph
 *
 * graph[i] contains all neighbors of node i
 *
 * Task:
 * - Determine whether graph is Bipartite
 *
 * Return:
 * - true  → if graph is bipartite
 * - false → otherwise
 *
 * -------------------------------------------------------
 * What is a Bipartite Graph?
 *
 * A graph is bipartite if:
 *
 * We can divide all nodes into 2 groups
 * such that:
 *
 * - No adjacent nodes belong
 *   to same group
 *
 * OR
 *
 * Graph can be colored using
 * only 2 colors.
 *
 * -------------------------------------------------------
 * Core Idea:
 *
 * We use:
 *
 * 2-coloring technique
 *
 * Colors:
 *
 * 0 → First color
 * 1 → Second color
 *
 * Initially:
 *
 * -1 → uncolored
 *
 * -------------------------------------------------------
 * Important Observation:
 *
 * If two adjacent nodes
 * get same color:
 *
 * → graph is NOT bipartite
 *
 * -------------------------------------------------------
 * Logic:
 *
 * 1. Create color array
 *
 *      -1 → uncolored
 *
 * 2. Traverse every node
 *    (for disconnected graph)
 *
 * 3. Start BFS from uncolored node
 *
 * 4. Assign first color
 *
 * 5. Traverse neighbors:
 *
 *      a) If neighbor uncolored:
 *             assign opposite color
 *
 *      b) If neighbor has same color:
 *             return false
 *
 * -------------------------------------------------------
 * Why Opposite Color?
 *
 * Adjacent nodes must belong
 * to opposite sets.
 *
 * So:
 *
 * current = 1
 * neighbor = 0
 *
 * OR
 *
 * current = 0
 * neighbor = 1
 *
 * We use:
 *
 * 1 - color[curr]
 *
 * -------------------------------------------------------
 * Dry Run:
 *
 * graph =
 *
 * [
 *   [1,3],
 *   [0,2],
 *   [1,3],
 *   [0,2]
 * ]
 *
 * Graph:
 *
 *      0 ----- 1
 *      |       |
 *      |       |
 *      3 ----- 2
 *
 * --------------------------------
 * Start BFS from 0
 *
 * color[0] = 1
 *
 * Queue = [0]
 *
 * --------------------------------
 * Remove 0
 *
 * Neighbor 1 → color = 0
 * Neighbor 3 → color = 0
 *
 * Queue = [1,3]
 *
 * --------------------------------
 * Remove 1
 *
 * Neighbor 2 → color = 1
 *
 * Queue = [3,2]
 *
 * --------------------------------
 * Remove 3
 *
 * Neighbor 2 already color 1
 *
 * Opposite colors maintained
 *
 * Graph is bipartite
 *
 * -------------------------------------------------------
 * Non Bipartite Example:
 *
 * Triangle Graph:
 *
 *      0
 *     / \
 *    1---2
 *
 * While coloring:
 *
 * 0 = 1
 * 1 = 0
 * 2 = 0
 *
 * But:
 * 1 and 2 adjacent
 * AND same color
 *
 * → Not bipartite
 *
 * -------------------------------------------------------
 * Pseudocode:
 *
 * function isBipartite(graph):
 *
 *      color[] = -1
 *
 *      for every node:
 *
 *          if uncolored:
 *
 *              if bfs(node) == false:
 *                  return false
 *
 *      return true
 *
 * -------------------------------------------------------
 * BFS:
 *
 * function bfs(node):
 *
 *      queue.add(node)
 *
 *      color[node] = 1
 *
 *      while queue not empty:
 *
 *          curr = queue.remove()
 *
 *          for neighbor in graph[curr]:
 *
 *              if uncolored:
 *
 *                  assign opposite color
 *                  push into queue
 *
 *              else if same color:
 *
 *                  return false
 *
 *      return true
 *
 * -------------------------------------------------------
 * Time Complexity:
 *
 * O(V + E)
 *
 * Every node and edge visited once
 *
 * -------------------------------------------------------
 * Space Complexity:
 *
 * O(V)
 *
 * Queue + Color Array
 *
 * -------------------------------------------------------
 * Pattern:
 *
 * Graph + BFS + 2 Coloring
 *
 * -------------------------------------------------------
 * Code:
 */

import java.util.*;

class Solution {

    public boolean isBipartite(int[][] graph) {

        int n = graph.length;

        int[] color = new int[n];

        // -1 means uncolored
        Arrays.fill(color, -1);

        // Traverse disconnected components
        for (int i = 0; i < n; i++) {

            if (color[i] == -1) {

                if (!bfs(graph, i, color)) {

                    return false;
                }
            }
        }

        return true;
    }

    public boolean bfs(int[][] graph,
                       int node,
                       int[] color) {

        Queue<Integer> q = new LinkedList<>();

        q.add(node);

        // Assign first color
        color[node] = 1;

        while (!q.isEmpty()) {

            int curr = q.poll();

            // Traverse neighbors
            for (int neigh : graph[curr]) {

                // Uncolored neighbor
                if (color[neigh] == -1) {

                    // Assign opposite color
                    color[neigh] = 1 - color[curr];

                    q.add(neigh);
                }

                // Adjacent nodes have same color
                else if (color[neigh] == color[curr]) {

                    return false;
                }
            }
        }

        return true;
    }
}
