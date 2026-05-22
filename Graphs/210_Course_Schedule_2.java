/* 
 * Problem: 210. Course Schedule II
 *
 * Given:
 * - numCourses → total number of courses
 * - prerequisites[][] where:
 *
 *      [a, b]
 *
 * Means:
 *
 * To take course 'a'
 * you must first complete course 'b'
 *
 * So:
 *
 * b → a
 *
 * -------------------------------------------------------
 * Task:
 *
 * Return:
 * - Any valid order in which all courses
 *   can be completed
 *
 * If impossible:
 * - return empty array
 *
 * -------------------------------------------------------
 * Core Idea:
 *
 * This is:
 *
 * Topological Sorting Problem
 *
 * Because:
 *
 * Dependencies must come first.
 *
 * -------------------------------------------------------
 * Important Observation:
 *
 * If graph contains cycle:
 *
 * → valid ordering impossible
 *
 * Example:
 *
 * 0 → 1
 * 1 → 0
 *
 * Circular dependency
 *
 * -------------------------------------------------------
 * We Use:
 *
 * Kahn's Algorithm
 * (BFS Topological Sort)
 *
 * -------------------------------------------------------
 * Graph Construction:
 *
 * prerequisites[i] = [a, b]
 *
 * Means:
 *
 * b → a
 *
 * Because:
 * b must be completed before a
 *
 * -------------------------------------------------------
 * Logic:
 *
 * 1. Create adjacency list
 *
 * 2. Compute indegree of every node
 *
 * 3. Push all nodes with indegree 0
 *    into queue
 *
 * 4. Perform BFS:
 *
 *      a) Remove node
 *      b) Add into answer
 *      c) Reduce indegree of neighbors
 *      d) If indegree becomes 0:
 *             push into queue
 *
 * 5. After BFS:
 *
 *      if all nodes processed:
 *          return answer
 *
 *      else:
 *          cycle exists
 *          return empty array
 *
 * -------------------------------------------------------
 * Why Indegree 0?
 *
 * indegree = 0 means:
 *
 * No pending prerequisite
 *
 * So course can be taken immediately.
 *
 * -------------------------------------------------------
 * Dry Run:
 *
 * numCourses = 4
 *
 * prerequisites = [
 *   [1,0],
 *   [2,0],
 *   [3,1],
 *   [3,2]
 * ]
 *
 * Graph:
 *
 *      0
 *     / \
 *    1   2
 *     \ /
 *      3
 *
 * --------------------------------
 * Indegree:
 *
 * 0 = 0
 * 1 = 1
 * 2 = 1
 * 3 = 2
 *
 * Queue = [0]
 *
 * --------------------------------
 * Remove 0
 *
 * Answer = [0]
 *
 * Reduce indegree:
 *
 * 1 → 0
 * 2 → 0
 *
 * Queue = [1,2]
 *
 * --------------------------------
 * Remove 1
 *
 * Answer = [0,1]
 *
 * Reduce indegree:
 *
 * 3 → 1
 *
 * --------------------------------
 * Remove 2
 *
 * Answer = [0,1,2]
 *
 * Reduce indegree:
 *
 * 3 → 0
 *
 * Queue = [3]
 *
 * --------------------------------
 * Remove 3
 *
 * Answer = [0,1,2,3]
 *
 * Valid order found
 *
 * -------------------------------------------------------
 * Cycle Example:
 *
 * prerequisites = [
 *   [0,1],
 *   [1,0]
 * ]
 *
 * No node has indegree 0
 *
 * Queue empty
 *
 * Cannot process all nodes
 *
 * Return empty array
 *
 * -------------------------------------------------------
 * Pseudocode:
 *
 * function findOrder(numCourses, prerequisites):
 *
 *      create adjacency list
 *
 *      compute indegree[]
 *
 *      queue nodes with indegree 0
 *
 *      answer[]
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
 *      if processed nodes != numCourses:
 *          return empty array
 *
 *      return answer
 *
 * -------------------------------------------------------
 * Time Complexity:
 *
 * O(V + E)
 *
 * V = Courses
 * E = Prerequisites
 *
 * -------------------------------------------------------
 * Space Complexity:
 *
 * O(V + E)
 *
 * -------------------------------------------------------
 * Pattern:
 *
 * Graph + BFS + Topological Sort + Kahn's Algorithm
 *
 * -------------------------------------------------------
 * Code:
 */

import java.util.*;

class Solution {

    public int[] findOrder(int numCourses,
                           int[][] prerequisites) {

        // Create adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {

            adj.add(new ArrayList<>());
        }

        // Store indegree
        int[] indegree = new int[numCourses];

        // Build graph
        for (int[] pre : prerequisites) {

            int course = pre[0];

            int prerequisite = pre[1];

            // prerequisite → course
            adj.get(prerequisite).add(course);

            indegree[course]++;
        }

        Queue<Integer> q = new LinkedList<>();

        // Push nodes having indegree 0
        for (int i = 0; i < numCourses; i++) {

            if (indegree[i] == 0) {

                q.add(i);
            }
        }

        int[] ans = new int[numCourses];

        int index = 0;

        // Kahn's BFS
        while (!q.isEmpty()) {

            int curr = q.remove();

            ans[index++] = curr;

            // Traverse neighbors
            for (int neigh : adj.get(curr)) {

                indegree[neigh]--;

                if (indegree[neigh] == 0) {

                    q.add(neigh);
                }
            }
        }

        // Cycle exists
        if (index != numCourses) {

            return new int[0];
        }

        return ans;
    }
}
