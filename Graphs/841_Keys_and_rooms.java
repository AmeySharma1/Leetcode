/* 
 * Problem: 841. Keys and Rooms
 *
 * Given:
 * - n rooms numbered from 0 to n-1
 * - Each room contains keys to other rooms
 *
 * rooms[i] = list of keys present in room i
 *
 * Initially:
 * - Room 0 is unlocked
 * - All other rooms are locked
 *
 * Task:
 * - Determine whether we can visit all rooms
 *
 * Return:
 * - true  → if all rooms can be visited
 * - false → otherwise
 *
 * -------------------------------------------------------
 * Core Idea:
 *
 * Each room acts like a graph node.
 *
 * Key inside room:
 * → represents an edge to another room.
 *
 * Example:
 *
 * Room 0 has key to room 1
 *
 * 0 → 1
 *
 * So the problem becomes:
 *
 * "Can we visit every node starting from node 0?"
 *
 * -------------------------------------------------------
 * Logic:
 *
 * We use BFS traversal.
 *
 * Steps:
 *
 * 1. Start from room 0
 * 2. Mark room 0 as visited
 * 3. Put room 0 into queue
 *
 * 4. While queue is not empty:
 *
 *      a) Remove current room
 *      b) Traverse all keys inside it
 *      c) If corresponding room not visited:
 *              mark visited
 *              push into queue
 *
 * 5. After BFS:
 *      Check whether every room was visited
 *
 * -------------------------------------------------------
 * Why BFS Works?
 *
 * BFS explores:
 *
 * Current room
 * → then all reachable rooms
 * → then rooms reachable from them
 *
 * Exactly like collecting keys and opening rooms.
 *
 * -------------------------------------------------------
 * Dry Run:
 *
 * rooms = [
 *   [1],
 *   [2],
 *   [3],
 *   []
 * ]
 *
 * Graph:
 *
 * 0 → 1 → 2 → 3
 *
 * --------------------------------
 * Start:
 *
 * Queue = [0]
 * Visited = [true,false,false,false]
 *
 * --------------------------------
 * Remove 0
 *
 * Key found = 1
 *
 * Queue = [1]
 * Visited = [true,true,false,false]
 *
 * --------------------------------
 * Remove 1
 *
 * Key found = 2
 *
 * Queue = [2]
 * Visited = [true,true,true,false]
 *
 * --------------------------------
 * Remove 2
 *
 * Key found = 3
 *
 * Queue = [3]
 * Visited = [true,true,true,true]
 *
 * --------------------------------
 * Remove 3
 *
 * Queue empty
 *
 * All rooms visited
 *
 * Answer = true
 *
 * -------------------------------------------------------
 * Pseudocode:
 *
 * function canVisitAllRooms(rooms):
 *
 *      create visited[]
 *
 *      perform bfs from room 0
 *
 *      for every room:
 *          if not visited:
 *              return false
 *
 *      return true
 *
 * -------------------------------------------------------
 * BFS:
 *
 * function bfs(rooms, visited):
 *
 *      create queue
 *
 *      add room 0
 *      visited[0] = true
 *
 *      while queue not empty:
 *
 *          room = queue.remove()
 *
 *          for key in rooms[room]:
 *
 *              if room not visited:
 *
 *                  visited[key] = true
 *                  queue.add(key)
 *
 * -------------------------------------------------------
 * Time Complexity:
 *
 * O(V + E)
 *
 * V = Number of rooms
 * E = Total number of keys
 *
 * Every room visited once
 * Every key processed once
 *
 * -------------------------------------------------------
 * Space Complexity:
 *
 * O(V)
 *
 * Queue + Visited array
 *
 * -------------------------------------------------------
 * Pattern:
 *
 * Graph Traversal + BFS + Visited Array
 *
 * -------------------------------------------------------
 * Code:
 */

class Solution {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {

        int n = rooms.size();

        boolean vis[] = new boolean[n];

        // Perform BFS from room 0
        bfs(rooms, vis);

        // Check if all rooms were visited
        for (int i = 0; i < n; i++) {

            if (vis[i] == false)
                return false;
        }

        return true;
    }

    public void bfs(List<List<Integer>> rooms, boolean[] vis) {

        Queue<Integer> q = new LinkedList<>();

        // Start from room 0
        q.add(0);

        vis[0] = true;

        while (!q.isEmpty()) {

            int front = q.remove();

            // Traverse all keys in current room
            for (int neigh : rooms.get(front)) {

                // If room not visited
                if (!vis[neigh]) {

                    q.add(neigh);

                    vis[neigh] = true;
                }
            }
        }
    }
}
