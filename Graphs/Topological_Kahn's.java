/* 
 * Problem: Topological Sort using BFS (Kahn's Algorithm)
 *
 * Given:
 * - Number of vertices V
 * - Directed edges[][] of graph
 *
 * Task:
 * - Return Topological Ordering
 *
 * -------------------------------------------------------
 * What is Topological Sort?
 *
 * A linear ordering of vertices such that:
 *
 * If:
 * u → v
 *
 * Then:
 * u appears before v
 *
 * -------------------------------------------------------
 * Important Condition:
 *
 * Topological Sort only works for:
 *
 * Directed Acyclic Graph (DAG)
 *
 * -------------------------------------------------------
 * Core Idea:
 *
 * We process nodes having:
 *
 * indegree = 0
 *
 * Meaning:
 * - no incoming edges
 * - no dependencies
 *
 * -------------------------------------------------------
 * What is Indegree?
 *
 * Indegree of a node:
 *
 * Number of incoming edges.
 *
 * Example:
 *
 * 0 → 1
 * 2 → 1
 *
 * indegree[1] = 2
 *
 * -------------------------------------------------------
 * Logic:
 *
 * 1. Build adjacency list
 *
 * 2. Compute indegree of every node
 *
 * 3. Push all nodes with indegree 0
 *    into queue
 *
 * 4. Perform BFS:
 *
 *      a) Remove node
 *      b) Add to answer
 *      c) Reduce indegree of neighbors
 *      d) If indegree becomes 0:
 *             push into queue
 *
 * -------------------------------------------------------
 * Why This Works?
 *
 * Node can appear in topological order
 * only after all its dependencies
 * are processed.
 *
 * indegree = 0 means:
 *
 * dependency finished
 *
 * -------------------------------------------------------
 * Dry Run:
 *
 * edges = [
 *   [5,2],
 *   [5,0],
 *   [4,0],
 *   [4,1],
 *   [2,3],
 *   [3,1]
 * ]
 *
 * Graph:
 *
 *      5 → 2 → 3 → 1
 *      ↓
 *      0
 *
 *      4 → 0
 *      ↓
 *      1
 *
 * --------------------------------
 * Initial Indegree:
 *
 * 0 = 2
 * 1 = 2
 * 2 = 1
 * 3 = 1
 * 4 = 0
 * 5 = 0
 *
 * Queue = [4,5]
 *
 * --------------------------------
 * Remove 4
 *
 * Reduce indegree:
 *
 * 0 → 1
 * 1 → 1
 *
 * --------------------------------
 * Remove 5
 *
 * Reduce indegree:
 *
 * 2 → 0
 * 0 → 0
 *
 * Queue = [2,0]
 *
 * --------------------------------
 * Continue BFS
 *
 * Final Topological Order:
 *
 * [4,5,2,3,1,0]
 *
 * -------------------------------------------------------
 * Pseudocode:
 *
 * function topoSort(V, edges):
 *
 *      create adjacency list
 *
 *      compute indegree[]
 *
 *      queue all nodes
 *      having indegree = 0
 *
 *      while queue not empty:
 *
 *          node = queue.remove()
 *
 *          add into answer
 *
 *          for neighbor:
 *
 *              indegree--
 *
 *              if indegree == 0:
 *                  queue.add(neighbor)
 *
 *      return answer
 *
 * -------------------------------------------------------
 * Time Complexity:
 *
 * O(V + E)
 *
 * Every node and edge processed once
 *
 * -------------------------------------------------------
 * Space Complexity:
 *
 * O(V + E)
 *
 * Queue + Adjacency List + Indegree Array
 *
 * -------------------------------------------------------
 * Pattern:
 *
 * Graph + BFS + Indegree + Kahn's Algorithm
 *
 * -------------------------------------------------------
 * Code:
 */

import java.util.*;

class Solution {

    public ArrayList<Integer> topoSort(int V, int[][] edges) {

        // Create adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {

            adj.add(new ArrayList<>());
        }

        // Build directed graph
        for (int edge[] : edges) {

            int u = edge[0];

            int v = edge[1];

            adj.get(u).add(v);
        }

        // Store indegree of every node
        int[] indegree = new int[V];

        // Calculate indegree
        for (int i = 0; i < V; i++) {

            for (int neigh : adj.get(i)) {

                indegree[neigh]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        // Push nodes with indegree 0
        for (int i = 0; i < V; i++) {

            if (indegree[i] == 0) {

                q.add(i);
            }
        }

        ArrayList<Integer> res = new ArrayList<>();

        // BFS traversal
        while (!q.isEmpty()) {

            int front = q.remove();

            res.add(front);

            // Traverse neighbors
            for (int neigh : adj.get(front)) {

                indegree[neigh]--;

                // Dependency resolved
                if (indegree[neigh] == 0) {

                    q.add(neigh);
                }
            }
        }

        return res;
    }
}
