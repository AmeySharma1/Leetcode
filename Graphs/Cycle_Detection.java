/* 
 * Problem:
 * Detect Cycle in an Undirected Graph using BFS
 *
 * Given:
 * - Number of vertices V
 * - edges[][] representing undirected graph
 *
 * Task:
 * - Return true if graph contains cycle
 * - Otherwise return false
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
 *
 * adj[u].add(v)
 * adj[v].add(u)
 *
 * -------------------------------------------------------
 * Core Idea:
 *
 * During BFS:
 *
 * If we encounter:
 *
 * - an already visited neighbor
 * - AND it is not the parent
 *
 * → cycle exists
 *
 * -------------------------------------------------------
 * Why Parent Needed?
 *
 * In undirected graph:
 *
 * u ↔ v
 *
 * While standing at v,
 * visiting u again is normal.
 *
 * That is NOT a cycle.
 *
 * So:
 *
 * visited neighbor != parent
 * → actual cycle
 *
 * -------------------------------------------------------
 * Logic:
 *
 * 1. Convert edges into adjacency list
 *
 * 2. Traverse every component
 *
 * 3. Start BFS from unvisited node
 *
 * 4. Store:
 *      current node
 *      parent node
 *
 * 5. If visited neighbor found
 *    and neighbor != parent:
 *
 *      cycle detected
 *
 * -------------------------------------------------------
 * Dry Run:
 *
 * edges = [
 *   [0,1],
 *   [1,2],
 *   [2,0]
 * ]
 *
 * Graph:
 *
 *      0
 *     / \
 *    1---2
 *
 * --------------------------------
 * Start BFS from 0
 *
 * Queue = [(0,-1)]
 *
 * --------------------------------
 * Remove (0,-1)
 *
 * Push:
 * (1,0)
 * (2,0)
 *
 * --------------------------------
 * Remove (1,0)
 *
 * Neighbor 2 already visited
 * AND 2 != parent(0)
 *
 * Cycle found
 *
 * -------------------------------------------------------
 * Pseudocode:
 *
 * function isCycle(V, edges):
 *
 *      create adjacency list
 *
 *      for every edge:
 *          add both directions
 *
 *      create visited[]
 *
 *      for every node:
 *
 *          if unvisited:
 *
 *              if bfs(node):
 *                  return true
 *
 *      return false
 *
 * -------------------------------------------------------
 * BFS:
 *
 * function bfs(start):
 *
 *      queue ← (node,parent)
 *
 *      mark visited
 *
 *      while queue not empty:
 *
 *          remove front
 *
 *          for neighbors:
 *
 *              if unvisited:
 *                  push into queue
 *
 *              else if neighbor != parent:
 *                  return true
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
 * Graph + BFS + Parent Tracking
 *
 * -------------------------------------------------------
 * Code:
 */

import java.util.*;

class Solution {

    public boolean isCycle(int V, int[][] edges) {

        // Create adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {

            adj.add(new ArrayList<>());
        }

        // Build undirected graph
        for (int edge[] : edges) {

            int u = edge[0];

            int v = edge[1];

            adj.get(u).add(v);

            adj.get(v).add(u);
        }

        boolean[] vis = new boolean[V];

        // Traverse all components
        for (int i = 0; i < V; i++) {

            if (!vis[i]) {

                if (bfs(i, vis, adj)) {

                    return true;
                }
            }
        }

        return false;
    }

    public boolean bfs(int start,
                       boolean[] vis,
                       ArrayList<ArrayList<Integer>> adj) {

        Queue<int[]> q = new LinkedList<>();

        // {node, parent}
        q.add(new int[]{start, -1});

        vis[start] = true;

        while (!q.isEmpty()) {

            int[] front = q.remove();

            int curr = front[0];

            int parent = front[1];

            // Traverse neighbors
            for (int neigh : adj.get(curr)) {

                // Unvisited neighbor
                if (!vis[neigh]) {

                    vis[neigh] = true;

                    q.add(new int[]{neigh, curr});
                }

                // Visited and not parent
                else if (neigh != parent) {

                    return true;
                }
            }
        }

        return false;
    }
}










/* 
 * Problem:
 * Detect Cycle in an Undirected Graph using DFS
 *
 * Given:
 * - Number of vertices V
 * - edges[][] representing graph
 *
 * Task:
 * - Return true if graph contains cycle
 * - Else return false
 *
 * -------------------------------------------------------
 * Core Idea:
 *
 * During DFS:
 *
 * If neighbor already visited
 * AND neighbor is not parent
 *
 * → cycle exists
 *
 * -------------------------------------------------------
 * Logic:
 *
 * 1. Convert edges into adjacency list
 *
 * 2. Traverse every disconnected component
 *
 * 3. Perform DFS from unvisited node
 *
 * 4. During DFS:
 *
 *      if neighbor unvisited:
 *          recursively DFS
 *
 *      else if neighbor != parent:
 *          cycle found
 *
 * -------------------------------------------------------
 * Dry Run:
 *
 * Graph:
 *
 *      0
 *     / \
 *    1---2
 *
 * DFS(0,-1)
 *
 * → DFS(1,0)
 *
 * → DFS(2,1)
 *
 * Neighbor 0 already visited
 * AND 0 != parent(1)
 *
 * Cycle exists
 *
 * -------------------------------------------------------
 * Pseudocode:
 *
 * function isCycle(V, edges):
 *
 *      create adjacency list
 *
 *      for every edge:
 *          add both directions
 *
 *      visited[]
 *
 *      for every node:
 *
 *          if unvisited:
 *
 *              if dfs(node,parent):
 *                  return true
 *
 *      return false
 *
 * -------------------------------------------------------
 * DFS:
 *
 * function dfs(node,parent):
 *
 *      mark visited
 *
 *      for neighbor in adj[node]:
 *
 *          if unvisited:
 *
 *              if dfs(neighbor,node):
 *                  return true
 *
 *          else if neighbor != parent:
 *
 *              return true
 *
 *      return false
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
 * Recursion stack + adjacency list
 *
 * -------------------------------------------------------
 * Pattern:
 *
 * Graph + DFS + Parent Tracking
 *
 * -------------------------------------------------------
 * Code:
 */

import java.util.*;

class Solution {

    public boolean isCycle(int V, int[][] edges) {

        // Create adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {

            adj.add(new ArrayList<>());
        }

        // Build undirected graph
        for (int[] edge : edges) {

            int u = edge[0];

            int v = edge[1];

            adj.get(u).add(v);

            adj.get(v).add(u);
        }

        boolean[] vis = new boolean[V];

        // Handle disconnected graph
        for (int i = 0; i < V; i++) {

            if (!vis[i]) {

                if (dfs(i, -1, vis, adj)) {

                    return true;
                }
            }
        }

        return false;
    }

    public boolean dfs(int node,
                       int parent,
                       boolean[] vis,
                       ArrayList<ArrayList<Integer>> adj) {

        vis[node] = true;

        // Traverse neighbors
        for (int neigh : adj.get(node)) {

            // Unvisited neighbor
            if (!vis[neigh]) {

                if (dfs(neigh, node, vis, adj)) {

                    return true;
                }
            }

            // Visited and not parent
            else if (neigh != parent) {

                return true;
            }
        }

        return false;
    }
}
