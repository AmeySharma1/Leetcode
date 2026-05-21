/* 
 * Problem: 1254. Number of Closed Islands
 *
 * Given:
 * - A 2D grid containing:
 *
 *      0 → Land
 *      1 → Water
 *
 * Task:
 * - Count the number of closed islands
 *
 * Closed Island:
 * - A group of connected land cells (0s)
 * - Completely surrounded by water (1s)
 * - Must NOT touch grid boundary
 *
 * -------------------------------------------------------
 * Core Idea:
 *
 * We perform DFS on every unvisited land cell.
 *
 * During DFS:
 *
 * - If traversal touches boundary
 *      → island is NOT closed
 *
 * - If traversal remains inside boundaries
 *      → island is closed
 *
 * -------------------------------------------------------
 * Important Observation:
 *
 * If DFS goes OUTSIDE the grid:
 * → island touches boundary
 * → return false
 *
 * If current cell is water:
 * → it does not affect closure
 * → return true
 *
 * -------------------------------------------------------
 * Logic:
 *
 * 1. Traverse every cell
 *
 * 2. If land found:
 *
 *      perform DFS
 *
 * 3. DFS checks:
 *
 *      a) Out of boundary
 *             → return false
 *
 *      b) Water cell
 *             → return true
 *
 *      c) Mark current land visited
 *
 *      d) Explore all 4 directions
 *
 *      e) If ALL directions return true
 *             → closed island
 *
 * -------------------------------------------------------
 * Why AND Operation?
 *
 * Closed island means:
 *
 * EVERY direction must remain enclosed.
 *
 * If even one direction touches boundary:
 * → whole island becomes open
 *
 * So:
 *
 * left && right && up && down
 *
 * -------------------------------------------------------
 * Dry Run:
 *
 * grid =
 *
 * 1 1 1 1 1
 * 1 0 0 1 1
 * 1 0 0 1 1
 * 1 1 1 1 1
 *
 * --------------------------------
 * Start DFS from (1,1)
 *
 * Explore:
 *
 * (1,1)
 * (1,2)
 * (2,1)
 * (2,2)
 *
 * DFS never touches boundary
 *
 * Result:
 * true
 *
 * Closed island count = 1
 *
 * -------------------------------------------------------
 * Another Example:
 *
 * grid =
 *
 * 0 0 1
 * 0 1 1
 * 1 1 1
 *
 * DFS from (0,0)
 *
 * Traversal goes outside boundary
 *
 * return false
 *
 * Not a closed island
 *
 * -------------------------------------------------------
 * Pseudocode:
 *
 * function closedIsland(grid):
 *
 *      count = 0
 *
 *      for every cell:
 *
 *          if land:
 *
 *              if dfs(cell) == true:
 *                  count++
 *
 *      return count
 *
 * -------------------------------------------------------
 * DFS:
 *
 * function dfs(i, j):
 *
 *      if outside grid:
 *          return false
 *
 *      if water:
 *          return true
 *
 *      mark visited
 *
 *      left  = dfs(left)
 *      right = dfs(right)
 *      up    = dfs(up)
 *      down  = dfs(down)
 *
 *      return left && right && up && down
 *
 * -------------------------------------------------------
 * Time Complexity:
 *
 * O(rows × cols)
 *
 * Every cell visited once
 *
 * -------------------------------------------------------
 * Space Complexity:
 *
 * O(rows × cols)
 *
 * Recursive DFS stack in worst case
 *
 * -------------------------------------------------------
 * Pattern:
 *
 * Graph Traversal + DFS + Matrix
 *
 * -------------------------------------------------------
 * Code:
 */

class Solution {

    public int closedIsland(int[][] grid) {

        int rows = grid.length;

        int cols = grid[0].length;

        int count = 0;

        // Traverse entire grid
        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                // Start DFS from unvisited land
                if (grid[i][j] == 0 && dfs(grid, i, j)) {

                    count++;
                }
            }
        }

        return count;
    }

    public boolean dfs(int[][] grid, int i, int j) {

        int rows = grid.length;

        int cols = grid[0].length;

        // Island touches boundary
        if (i < 0 || j < 0 || i >= rows || j >= cols) {

            return false;
        }

        // Water cell
        if (grid[i][j] == 1) {

            return true;
        }

        // Mark land as visited
        grid[i][j] = 1;

        // Explore all 4 directions
        boolean left  = dfs(grid, i, j - 1);

        boolean right = dfs(grid, i, j + 1);

        boolean up    = dfs(grid, i - 1, j);

        boolean down  = dfs(grid, i + 1, j);

        // Island closed only if
        // all directions are closed
        return left && right && up && down;
    }
}
