/*
 * Problem: 559. Maximum Depth of N-ary Tree
 *
 * Given:
 * - Node root
 *   (Each node can have multiple children)
 *
 * Task:
 * - Return the maximum depth of the N-ary tree.
 *
 * Depth means:
 * - Number of nodes along the longest path
 *   from root to the farthest leaf node.
 *
 * -------------------------------------------------------
 * What is happening?
 *
 * Unlike binary tree (2 children),
 * here each node can have multiple children.
 *
 * So instead of checking:
 *      left and right
 *
 * We:
 *      Iterate through all children
 *      Find maximum depth among them
 *
 * -------------------------------------------------------
 * Core Idea:
 *
 * DFS:
 *      For each child:
 *          compute its depth
 *      Take maximum
 *
 *      Return:
 *          1 + maximum child depth
 *
 * BFS:
 *      Traverse level by level
 *      Count number of levels
 *
 * -------------------------------------------------------
 * Algorithm (DFS - Recursive):
 *
 * 1. If root == null → return 0
 *
 * 2. maxDepth = 0
 *
 * 3. For each child in root.children:
 *        depth = maxDepth(child)
 *        maxDepth = max(maxDepth, depth)
 *
 * 4. Return maxDepth + 1
 *
 * -------------------------------------------------------
 * Algorithm (BFS - Iterative):
 *
 * 1. If root == null → return 0
 *
 * 2. Add root to queue
 *
 * 3. depth = 0
 *
 * 4. While queue not empty:
 *
 *        size = queue.size()
 *
 *        Process all nodes of this level
 *        Add all children to queue
 *
 *        depth++
 *
 * 5. Return depth
 *
 * -------------------------------------------------------
 * Example:
 *
 *        1
 *      / | \
 *     2  3  4
 *        |
 *        5
 *
 * Longest path:
 * 1 → 3 → 5
 *
 * Depth = 3
 *
 * -------------------------------------------------------
 * Time Complexity:
 * O(n)
 *
 * Space Complexity:
 * O(n)
 *
 * Pattern:
 * DFS + BFS (Level Order)
 *
 * -------------------------------------------------------
 * Code:
 */

import java.util.*;

class Solution {

    /* ================= DFS (Recursive) ================= */

    public int maxDepth(Node root) {

        if (root == null) return 0;

        int maxDepth = 0;

        for (Node child : root.children) {
            maxDepth = Math.max(maxDepth, maxDepth(child));
        }

        return maxDepth + 1;
    }


    /* ================= BFS (Iterative) ================= */

    public int maxDepthBFS(Node root) {

        if (root == null) return 0;

        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        int depth = 0;

        while (!q.isEmpty()) {

            int size = q.size();

            while (size-- > 0) {

                Node node = q.poll();

                for (Node child : node.children) {
                    q.offer(child);
                }
            }

            depth++;
        }

        return depth;
    }
}
