/* 
 * Problem: 207. Course Schedule
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
 *
 * true  → if all courses can be finished
 * false → if impossible
 *
 * -------------------------------------------------------
 * Core Idea:
 *
 * This is a:
 *
 * Directed Graph Problem
 *
 * If graph contains cycle:
 *
 * → Courses depend on each other forever
 * → Impossible to finish all courses
 *
 * Example:
 *
 * 0 → 1
 * 1 → 0
 *
 * Circular dependency
 *
 * -------------------------------------------------------
 * Important Observation:
 *
 * If graph has NO cycle:
 * → Topological ordering exists
 * → All courses can be completed
 *
 * We use:
 *
 * Kahn's Algorithm (BFS Topological Sort)
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
 * b must be completed first
 *
 * -------------------------------------------------------
 * Logic:
 *
 * 1. Create adjacency list
 *
 * 2. Compute indegree of every course
 *
 * 3. Push all courses with indegree 0
 *    into queue
 *
 * 4. Perform BFS:
 *
 *      a) Remove course
 *      b) Count completed courses
 *      c) Reduce indegree of neighbors
 *      d) If indegree becomes 0:
 *             push into queue
 *
 * 5. After BFS:
 *
 *      if completedCourses == numCourses
 *          return true
 *
 *      else
 *          return false
 *
 * -------------------------------------------------------
 * Why Does This Work?
 *
 * Courses with indegree 0:
 *
 * → No prerequisites pending
 *
 * We complete them first.
 *
 * Gradually dependencies disappear.
 *
 * If cycle exists:
 * → Some courses never reach indegree 0
 *
 * -------------------------------------------------------
 * Dry Run:
 *
 * numCourses = 2
 *
 * prerequisites = [
 *   [1,0]
 * ]
 *
 * Graph:
 *
 * 0 → 1
 *
 * --------------------------------
 * Indegree:
 *
 * 0 = 0
 * 1 = 1
 *
 * Queue = [0]
 *
 * --------------------------------
 * Remove 0
 *
 * completed = 1
 *
 * Reduce indegree of 1:
 *
 * 1 → 0
 *
 * Queue = [1]
 *
 * --------------------------------
 * Remove 1
 *
 * completed = 2
 *
 * completed == numCourses
 *
 * Answer = true
 *
 * -------------------------------------------------------
 * Cycle Example:
 *
 * prerequisites = [
 *   [0,1],
 *   [1,0]
 * ]
 *
 * Graph:
 *
 * 0 ↔ 1
 *
 * Indegree:
 *
 * 0 = 1
 * 1 = 1
 *
 * No node has indegree 0
 *
 * Queue empty
 *
 * completed = 0
 *
 * Answer = false
 *
 * -------------------------------------------------------
 * Pseudocode:
 *
 * function canFinish(numCourses, prerequisites):
 *
 *      create adjacency list
 *
 *      compute indegree[]
 *
 *      queue all nodes
 *      having indegree 0
 *
 *      completed = 0
 *
 *      while queue not empty:
 *
 *          node = queue.remove()
 *
 *          completed++
 *
 *          for neighbor:
 *
 *              indegree--
 *
 *              if indegree == 0:
 *                  queue.add(neighbor)
 *
 *      return completed == numCourses
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
 * Graph + BFS + Kahn's Algorithm + Cycle Detection
 *
 * -------------------------------------------------------
 * Code:
 */

import java.util.*;

class Solution {

    public boolean canFinish(int numCourses,
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

        // Add courses having indegree 0
        for (int i = 0; i < numCourses; i++) {

            if (indegree[i] == 0) {

                q.add(i);
            }
        }

        int completedCourses = 0;

        // Kahn's BFS
        while (!q.isEmpty()) {

            int curr = q.remove();

            completedCourses++;

            // Traverse neighbors
            for (int neigh : adj.get(curr)) {

                indegree[neigh]--;

                if (indegree[neigh] == 0) {

                    q.add(neigh);
                }
            }
        }

        // If all courses completed
        return completedCourses == numCourses;
    }
}
