/* 
 * Problem:
 * Detect Cycle in Directed Graph using Kahn's Algorithm
 *
 * Given:
 * - Number of vertices V
 * - Directed edges[][]
 *
 * Task:
 * - Return true if graph contains cycle
 * - Otherwise return false
 *
 * -------------------------------------------------------
 * Core Idea:
 *
 * Kahn's Algorithm performs:
 *
 * Topological Sorting using BFS
 *
 * Important Property:
 *
 * A Directed Graph can have
 * Topological Sort ONLY IF:
 *
 * graph has NO cycle
 *
 * -------------------------------------------------------
 * Key Observation:
 *
 * If cycle exists:
 *
 * Some nodes will NEVER get:
 *
 * indegree = 0
 *
 * Because:
 * they keep depending on each other.
 *
 * -------------------------------------------------------
 * Trick:
 *
 * Count how many nodes
 * are processed during Kahn's BFS.
 *
 * If:
 *
 * processedNodes == V
 * → No cycle
 *
 * Else:
 *
 * processedNodes < V
 * → Cycle exists
 *
 * -------------------------------------------------------
 * Why?
 *
 * In cycle:
 *
 * 0 → 1 → 2 → 0
 *
 * Indegree:
 *
 * 0 = 1
 * 1 = 1
 * 2 = 1
 *
 * No node has indegree 0
 *
 * Queue remains empty
 *
 * No node processed
 *
 * → Cycle exists
 *
 * -------------------------------------------------------
 * Logic:
 *
 * 1. Build adjacency list
 *
 * 2. Compute indegree[]
 *
 * 3. Push all nodes with indegree 0
 *
 * 4. Perform BFS:
 *
 *      a) Remove node
 *      b) Count processed node
 *      c) Reduce indegree of neighbors
 *      d) If indegree becomes 0:
 *             push into queue
 *
 * 5. After BFS:
 *
 *      if count == V:
 *          no cycle
 *
 *      else:
 *          cycle exists
 *
 * -------------------------------------------------------
 * Dry Run:
 *
 * Graph:
 *
 * 0 → 1 → 2
 * ↑       ↓
 * └───────┘
 *
 * --------------------------------
 * Indegree:
 *
 * 0 = 1
 * 1 = 1
 * 2 = 1
 *
 * No node with indegree 0
 *
 * Queue = []
 *
 * BFS never starts
 *
 * processed count = 0
 *
 * count < V
 *
 * Cycle exists
 *
 * -------------------------------------------------------
 * Another Example:
 *
 * 0 → 1 → 2
 *
 * Indegree:
 *
 * 0 = 0
 * 1 = 1
 * 2 = 1
 *
 * Queue = [0]
 *
 * Process all nodes
 *
 * count = 3
 *
 * count == V
 *
 * No cycle
 *
 * -------------------------------------------------------
 * Pseudocode:
 *
 * function isCyclic(V, edges):
 *
 *      create adjacency list
 *
 *      compute indegree[]
 *
 *      queue nodes with indegree 0
 *
 *      count = 0
 *
 *      while queue not empty:
 *
 *          node = queue.remove()
 *
 *          count++
 *
 *          for neighbor:
 *
 *              indegree--
 *
 *              if indegree == 0:
 *                  queue.add(neighbor)
 *
 *      if count == V:
 *          return false
 *
 *      return true
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
 * Graph + BFS + Kahn's Algorithm + Cycle Detection
 *
 * -------------------------------------------------------
 * Code:
 */

import java.util.*;

class Solution {

    public boolean isCyclic(int V, int[][] edges) {

        // Create adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {

            adj.add(new ArrayList<>());
        }

        // Build directed graph
        for (int[] edge : edges) {

            int u = edge[0];

            int v = edge[1];

            adj.get(u).add(v);
        }

        // Store indegree
        int[] indegree = new int[V];

        // Calculate indegree
        for (int i = 0; i < V; i++) {

            for (int neigh : adj.get(i)) {

                indegree[neigh]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        // Push nodes having indegree 0
        for (int i = 0; i < V; i++) {

            if (indegree[i] == 0) {

                q.add(i);
            }
        }

        int count = 0;

        // Kahn's BFS
        while (!q.isEmpty()) {

            int front = q.remove();

            count++;

            // Traverse neighbors
            for (int neigh : adj.get(front)) {

                indegree[neigh]--;

                if (indegree[neigh] == 0) {

                    q.add(neigh);
                }
            }
        }

        // If all nodes processed
        // → No cycle
        if (count == V) {

            return false;
        }

        // Otherwise cycle exists
        return true;
    }
}
