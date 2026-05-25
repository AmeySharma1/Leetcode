/* 
 * Problem: 743. Network Delay Time
 *
 * Given:
 * - edges[][] where:
 *
 *      [u, v, w]
 *
 * Means:
 *
 * u → v takes w time
 *
 * - V   → total number of nodes
 * - src → starting node
 *
 * Task:
 * - Find minimum time required for
 *   signal to reach all nodes
 *
 * Return:
 * - Maximum shortest distance
 * - OR -1 if some node unreachable
 *
 * -------------------------------------------------------
 * Core Idea:
 *
 * We need:
 *
 * Shortest time from source
 * to every node.
 *
 * This is:
 *
 * Single Source Shortest Path Problem
 *
 * -------------------------------------------------------
 * We Use:
 *
 * Dijkstra's Algorithm
 *
 * Because:
 *
 * - Graph has positive weights
 * - Need shortest distances
 *
 * -------------------------------------------------------
 * Graph Representation:
 *
 * edges[i] = [u, v, w]
 *
 * Means:
 *
 * u → v with weight w
 *
 * -------------------------------------------------------
 * Important Observation:
 *
 * Network delay time =
 *
 * Maximum shortest distance
 *
 * Because:
 *
 * Signal must reach EVERY node.
 *
 * Last node receiving signal
 * determines total delay.
 *
 * -------------------------------------------------------
 * Logic:
 *
 * 1. Build adjacency list
 *
 * 2. Initialize:
 *
 *      dist[] = INF
 *
 * 3. Source distance = 0
 *
 * 4. Use Min Heap:
 *
 *      {distance, node}
 *
 * 5. Perform Dijkstra:
 *
 *      a) Remove minimum distance node
 *
 *      b) Traverse neighbors
 *
 *      c) Relax edges
 *
 * 6. Find maximum distance
 *
 * 7. If any node unreachable:
 *      return -1
 *
 * -------------------------------------------------------
 * What is Relaxation?
 *
 * If:
 *
 * current distance + edge weight
 *
 * gives shorter path,
 * update distance.
 *
 * -------------------------------------------------------
 * Dry Run:
 *
 * edges = [
 *   [2,1,1],
 *   [2,3,1],
 *   [3,4,1]
 * ]
 *
 * src = 2
 *
 * Graph:
 *
 *      2
 *     / \
 *    1   3
 *         \
 *          4
 *
 * --------------------------------
 * Initial:
 *
 * dist = [INF,INF,0,INF,INF]
 *
 * PQ = [(0,2)]
 *
 * --------------------------------
 * Remove (0,2)
 *
 * Update:
 *
 * dist[1] = 1
 * dist[3] = 1
 *
 * PQ = [(1,1),(1,3)]
 *
 * --------------------------------
 * Remove (1,3)
 *
 * Update:
 *
 * dist[4] = 2
 *
 * --------------------------------
 * Final Distances:
 *
 * 1 → 1
 * 2 → 0
 * 3 → 1
 * 4 → 2
 *
 * Maximum = 2
 *
 * Answer = 2
 *
 * -------------------------------------------------------
 * Why Priority Queue?
 *
 * Dijkstra always processes:
 *
 * node having minimum distance first.
 *
 * Min Heap helps efficiently.
 *
 * -------------------------------------------------------
 * Pseudocode:
 *
 * function networkDelayTime(edges,V,src):
 *
 *      build adjacency list
 *
 *      dist[] = INF
 *
 *      dist[src] = 0
 *
 *      minHeap ← {0,src}
 *
 *      while heap not empty:
 *
 *          remove minimum distance node
 *
 *          for neighbors:
 *
 *              if shorter path found:
 *
 *                  update distance
 *
 *                  push into heap
 *
 *      find maximum distance
 *
 *      if unreachable node:
 *          return -1
 *
 *      return maximum distance
 *
 * -------------------------------------------------------
 * Time Complexity:
 *
 * O((V + E) log V)
 *
 * -------------------------------------------------------
 * Space Complexity:
 *
 * O(V + E)
 *
 * -------------------------------------------------------
 * Pattern:
 *
 * Graph + Shortest Path + Dijkstra + Min Heap
 *
 * -------------------------------------------------------
 * Code:
 */

import java.util.*;

class Solution {

    public int networkDelayTime(int[][] edges,
                                int V,
                                int src) {

        // Create adjacency list
        ArrayList<ArrayList<int[]>> adj =
                new ArrayList<>();

        for (int i = 0; i <= V; i++) {

            adj.add(new ArrayList<>());
        }

        // Build directed weighted graph
        for (int[] edge : edges) {

            int u = edge[0];

            int v = edge[1];

            int w = edge[2];

            adj.get(u).add(new int[]{v, w});
        }

        // Distance array
        int[] dist = new int[V + 1];

        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[src] = 0;

        // Min Heap -> {distance, node}
        PriorityQueue<int[]> pq =
                new PriorityQueue<>(
                        (a, b) -> a[0] - b[0]
                );

        pq.add(new int[]{0, src});

        // Dijkstra Algorithm
        while (!pq.isEmpty()) {

            int[] curr = pq.remove();

            int d = curr[0];

            int node = curr[1];

            // Traverse neighbors
            for (int[] neigh : adj.get(node)) {

                int adjNode = neigh[0];

                int wt = neigh[1];

                // Relaxation step
                if (dist[node] + wt < dist[adjNode]) {

                    dist[adjNode] =
                            dist[node] + wt;

                    pq.add(
                            new int[]{
                                    dist[adjNode],
                                    adjNode
                            }
                    );
                }
            }
        }

        int max = 0;

        // Find maximum shortest distance
        for (int i = 1; i <= V; i++) {

            // Unreachable node
            if (dist[i] == Integer.MAX_VALUE) {

                return -1;
            }

            max = Math.max(max, dist[i]);
        }

        return max;
    }
}
