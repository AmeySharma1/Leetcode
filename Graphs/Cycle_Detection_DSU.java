/* 
 * Problem:
 * Detect Cycle in Undirected Graph using DSU
 *
 * Given:
 * - Number of vertices V
 * - Adjacency List of undirected graph
 *
 * Task:
 * - Return true if graph contains cycle
 * - Otherwise return false
 *
 * -------------------------------------------------------
 * Core Idea:
 *
 * We use:
 *
 * DSU (Disjoint Set Union)
 *
 * Also called:
 *
 * Union Find
 *
 * -------------------------------------------------------
 * What Does DSU Do?
 *
 * DSU helps determine:
 *
 * Whether two nodes belong
 * to same connected component.
 *
 * -------------------------------------------------------
 * Important Observation:
 *
 * In an undirected graph:
 *
 * If two nodes already belong
 * to same component
 * AND we try connecting them again
 *
 * → cycle exists
 *
 * -------------------------------------------------------
 * Example:
 *
 * 0 ----- 1
 *  \     /
 *    2
 *
 * --------------------------------
 * Add edge (0,1)
 *
 * Different components
 *
 * Union them
 *
 * --------------------------------
 * Add edge (1,2)
 *
 * Different components
 *
 * Union them
 *
 * --------------------------------
 * Add edge (2,0)
 *
 * Both already connected
 *
 * Adding edge again forms cycle
 *
 * -------------------------------------------------------
 * DSU Operations:
 *
 * 1. find(x)
 *
 * Returns ultimate parent
 * of node x
 *
 * 2. union(u,v)
 *
 * Merges two components
 *
 * -------------------------------------------------------
 * Optimization Used:
 *
 * 1. Path Compression
 *
 * Makes future find() faster
 *
 * 2. Union by Rank
 *
 * Smaller tree attaches
 * below larger tree
 *
 * -------------------------------------------------------
 * Why u < v Check?
 *
 * Since graph is undirected:
 *
 * u → v
 * and
 * v → u
 *
 * both appear in adjacency list.
 *
 * To avoid processing same edge twice:
 *
 * process only when:
 *
 * u < v
 *
 * -------------------------------------------------------
 * Logic:
 *
 * 1. Initialize:
 *
 *      parent[i] = i
 *
 * 2. Traverse all edges
 *
 * 3. Find parents:
 *
 *      pu = find(u)
 *      pv = find(v)
 *
 * 4. If:
 *
 *      pu == pv
 *
 *      → cycle exists
 *
 * 5. Otherwise:
 *
 *      union(u,v)
 *
 * -------------------------------------------------------
 * Dry Run:
 *
 * Graph:
 *
 * 0 ----- 1
 *  \     /
 *    2
 *
 * --------------------------------
 * Initial:
 *
 * parent = [0,1,2]
 *
 * --------------------------------
 * Edge (0,1)
 *
 * find(0)=0
 * find(1)=1
 *
 * Different parents
 *
 * Union them
 *
 * parent = [0,0,2]
 *
 * --------------------------------
 * Edge (1,2)
 *
 * find(1)=0
 * find(2)=2
 *
 * Union them
 *
 * parent = [0,0,0]
 *
 * --------------------------------
 * Edge (2,0)
 *
 * find(2)=0
 * find(0)=0
 *
 * Same parent
 *
 * Cycle detected
 *
 * -------------------------------------------------------
 * Pseudocode:
 *
 * initialize parent[]
 * initialize rank[]
 *
 * for every edge:
 *
 *      pu = find(u)
 *      pv = find(v)
 *
 *      if pu == pv:
 *          return true
 *
 *      union(u,v)
 *
 * return false
 *
 * -------------------------------------------------------
 * Time Complexity:
 *
 * O(E * α(V))
 *
 * α(V) = Inverse Ackermann Function
 *
 * Nearly constant time
 *
 * -------------------------------------------------------
 * Space Complexity:
 *
 * O(V)
 *
 * parent[] + rank[]
 *
 * -------------------------------------------------------
 * Pattern:
 *
 * Graph + DSU + Union Find + Cycle Detection
 *
 * -------------------------------------------------------
 * Code:
 */

import java.util.*;

class Solution {

    int parent[];

    int rank[];

    // Find ultimate parent
    // with path compression
    public int find(int x) {

        if (parent[x] == x) {

            return x;
        }

        return parent[x] = find(parent[x]);
    }

    // Union by rank
    public void union(int u, int v) {

        int pu = find(u);

        int pv = find(v);

        // Already in same component
        if (pu == pv) {

            return;
        }

        // Attach smaller rank tree
        // below larger rank tree
        if (rank[pu] < rank[pv]) {

            parent[pu] = pv;
        }

        else if (rank[pv] < rank[pu]) {

            parent[pv] = pu;
        }

        else {

            parent[pv] = pu;

            rank[pu]++;
        }
    }

    public boolean detectCycle(int V,
                               ArrayList<ArrayList<Integer>> adj) {

        parent = new int[V];

        rank = new int[V];

        // Initialize DSU
        for (int i = 0; i < V; i++) {

            parent[i] = i;

            rank[i] = 0;
        }

        // Traverse all edges
        for (int u = 0; u < V; u++) {

            for (int v : adj.get(u)) {

                // Avoid duplicate edge processing
                if (u < v) {

                    int pu = find(u);

                    int pv = find(v);

                    // Same component
                    // → cycle exists
                    if (pu == pv) {

                        return true;
                    }

                    union(u, v);
                }
            }
        }

        return false;
    }
}
