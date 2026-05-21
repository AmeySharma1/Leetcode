/* 
 * Problem: 1971. Find if Path Exists in Graph
 *
 * Given:
 * - Number of nodes n
 * - edges[][] representing an undirected graph
 * - source node
 * - destination node
 *
 * Task:
 * - Determine whether a valid path exists
 *   from source to destination
 *
 * Return:
 * - true  → if path exists
 * - false → otherwise
 *
 * -------------------------------------------------------
 * Graph Representation:
 *
 * edges[i] = [u, v]
 *
 * Means:
 *
 * u ↔ v
 *
 * Since graph is undirected:
 * - u connected to v
 * - v connected to u
 *
 * -------------------------------------------------------
 * Core Idea:
 *
 * If destination becomes reachable
 * from source during traversal,
 * then path exists.
 *
 * We use:
 *
 * BFS Traversal
 *
 * -------------------------------------------------------
 * Logic:
 *
 * 1. Convert edges into adjacency list
 *
 * 2. Start BFS from source node
 *
 * 3. Traverse all reachable nodes
 *
 * 4. Mark visited nodes
 *
 * 5. After BFS:
 *
 *      if destination visited:
 *          return true
 *
 *      else:
 *          return false
 *
 * -------------------------------------------------------
 * Why Adjacency List?
 *
 * Efficient graph representation.
 *
 * adj.get(u)
 * → gives all neighbors of u
 *
 * -------------------------------------------------------
 * Dry Run:
 *
 * n = 6
 *
 * edges = [
 *   [0,1],
 *   [0,2],
 *   [3,5],
 *   [5,4],
 *   [4,3]
 * ]
 *
 * source = 0
 * destination = 5
 *
 * Graph:
 *
 *     0 --- 1
 *     |
 *     2
 *
 *     3 --- 4
 *      \   /
 *        5
 *
 * --------------------------------
 * BFS starts from 0
 *
 * Reachable nodes:
 * 0 → 1 → 2
 *
 * Destination 5 never visited
 *
 * Answer = false
 *
 * -------------------------------------------------------
 * Another Example:
 *
 * edges = [
 *   [0,1],
 *   [1,2],
 *   [2,3]
 * ]
 *
 * source = 0
 * destination = 3
 *
 * BFS:
 *
 * 0 → 1 → 2 → 3
 *
 * Destination reached
 *
 * Answer = true
 *
 * -------------------------------------------------------
 * Pseudocode:
 *
 * function validPath(n, edges, source, destination):
 *
 *      create adjacency list
 *
 *      for every edge:
 *          add both directions
 *
 *      create visited[]
 *
 *      bfs(source)
 *
 *      return visited[destination]
 *
 * -------------------------------------------------------
 * BFS:
 *
 * function bfs(adj, visited, source):
 *
 *      create queue
 *
 *      push source
 *      mark source visited
 *
 *      while queue not empty:
 *
 *          node = queue.remove()
 *
 *          for neighbor in adj[node]:
 *
 *              if not visited:
 *
 *                  mark visited
 *                  push neighbor
 *
 * -------------------------------------------------------
 * Time Complexity:
 *
 * O(V + E)
 *
 * V = Vertices
 * E = Edges
 *
 * Building adjacency list = O(E)
 * BFS traversal = O(V + E)
 *
 * -------------------------------------------------------
 * Space Complexity:
 *
 * O(V + E)
 *
 * Adjacency List + Queue + Visited Array
 *
 * -------------------------------------------------------
 * Pattern:
 *
 * Graph Traversal + BFS + Adjacency List
 *
 * -------------------------------------------------------
 * Code:
 */

import java.util.*;

class Solution {

    public boolean validPath(int n,
                             int[][] edges,
                             int source,
                             int destination) {

        // Create adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Build undirected graph
        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] vis = new boolean[n];

        // Perform BFS from source
        bfs(adj, vis, source);

        // If destination visited,
        // path exists
        return vis[destination];
    }

    public void bfs(ArrayList<ArrayList<Integer>> adj,
                    boolean[] vis,
                    int source) {

        Queue<Integer> q = new LinkedList<>();

        q.add(source);

        vis[source] = true;

        while (!q.isEmpty()) {

            int front = q.remove();

            // Traverse neighbors
            for (int neigh : adj.get(front)) {

                if (!vis[neigh]) {

                    vis[neigh] = true;

                    q.add(neigh);
                }
            }
        }
    }
}
