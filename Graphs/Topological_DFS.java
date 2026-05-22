/* 
 * Problem: Topological Sort using DFS
 *
 * Given:
 * - Number of vertices V
 * - Directed edges[][] of a DAG
 *
 * Task:
 * - Return Topological Ordering of graph
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
 * u appears BEFORE v
 *
 * -------------------------------------------------------
 * Important Condition:
 *
 * Topological Sort works ONLY for:
 *
 * Directed Acyclic Graph (DAG)
 *
 * If cycle exists:
 * → Topological ordering impossible
 *
 * -------------------------------------------------------
 * Core Idea:
 *
 * Using DFS:
 *
 * We push node into stack
 * AFTER visiting all its neighbors.
 *
 * Why?
 *
 * Because:
 *
 * Dependencies must come first.
 *
 * -------------------------------------------------------
 * Logic:
 *
 * 1. Convert edges into adjacency list
 *
 * 2. Traverse every node
 *
 * 3. Perform DFS:
 *
 *      a) Mark visited
 *
 *      b) Visit neighbors first
 *
 *      c) Push current node into stack
 *
 * 4. Pop stack to get topological order
 *
 * -------------------------------------------------------
 * Why Push After DFS?
 *
 * Example:
 *
 * 0 → 1 → 2
 *
 * DFS Flow:
 *
 * dfs(0)
 *   dfs(1)
 *      dfs(2)
 *
 * Push order:
 *
 * 2
 * 1
 * 0
 *
 * Stack Pop:
 *
 * 0 1 2
 *
 * Correct topological order
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
 * DFS Traversal:
 *
 * Push order:
 *
 * 0
 * 1
 * 3
 * 2
 * 5
 * 4
 *
 * Stack Pop:
 *
 * 4 5 2 3 1 0
 *
 * Valid Topological Order
 *
 * -------------------------------------------------------
 * Pseudocode:
 *
 * function topoSort(V, edges):
 *
 *      create adjacency list
 *
 *      for every edge:
 *          adj[u].add(v)
 *
 *      visited[]
 *      stack
 *
 *      for every node:
 *
 *          if unvisited:
 *              dfs(node)
 *
 *      pop stack into answer
 *
 * -------------------------------------------------------
 * DFS:
 *
 * function dfs(node):
 *
 *      mark visited
 *
 *      for neighbor in adj[node]:
 *
 *          if unvisited:
 *              dfs(neighbor)
 *
 *      push node into stack
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
 * O(V + E)
 *
 * Adjacency List + Stack + Recursion Stack
 *
 * -------------------------------------------------------
 * Pattern:
 *
 * Graph + DFS + Stack + Topological Sort
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

        boolean[] vis = new boolean[V];

        Stack<Integer> st = new Stack<>();

        // Traverse all components
        for (int i = 0; i < V; i++) {

            if (!vis[i]) {

                dfs(i, adj, vis, st);
            }
        }

        // Store final topological order
        ArrayList<Integer> res = new ArrayList<>();

        while (!st.isEmpty()) {

            res.add(st.pop());
        }

        return res;
    }

    public void dfs(int node,
                    ArrayList<ArrayList<Integer>> adj,
                    boolean[] vis,
                    Stack<Integer> st) {

        vis[node] = true;

        // Traverse neighbors
        for (int neigh : adj.get(node)) {

            if (!vis[neigh]) {

                dfs(neigh, adj, vis, st);
            }
        }

        // Push after visiting neighbors
        st.push(node);
    }
}
