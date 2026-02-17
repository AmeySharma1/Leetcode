/*
 * Problem: 104. Maximum Depth of Binary Tree
 *
 * Given:
 * - TreeNode root
 *
 * Task:
 * - Return the maximum depth (height) of the binary tree.
 *
 * Depth means:
 * - Number of nodes along the longest path
 *   from root down to the farthest leaf node.
 *
 * -------------------------------------------------------
 * What is happening?
 *
 * We need to calculate how tall the tree is.
 *
 * Two approaches:
 *
 * 1) DFS (Recursive)
 *    - Go to left subtree
 *    - Go to right subtree
 *    - Take max of both
 *
 * 2) BFS (Level Order)
 *    - Traverse level by level
 *    - Count number of levels
 *
 * -------------------------------------------------------
 * Core Idea:
 *
 * DFS:
 *      Height of node =
 *      1 + max(height(left), height(right))
 *
 * BFS:
 *      Each level traversal increases depth by 1.
 *
 * -------------------------------------------------------
 * Algorithm (DFS - Recursive):
 *
 * 1. If root == null → return 0
 *
 * 2. Recursively compute:
 *      leftDepth  = maxDepth(root.left)
 *      rightDepth = maxDepth(root.right)
 *
 * 3. Return:
 *      1 + max(leftDepth, rightDepth)
 *
 * -------------------------------------------------------
 * Algorithm (BFS - Iterative):
 *
 * 1. If root == null → return 0
 *
 * 2. Create queue and add root
 *
 * 3. depth = 0
 *
 * 4. While queue not empty:
 *
 *      size = queue.size()
 *
 *      Process all nodes of this level
 *      (size times)
 *
 *      Add left and right children to queue
 *
 *      depth++
 *
 * 5. Return depth
 *
 * -------------------------------------------------------
 * Example:
 *
 *        3
 *       / \
 *      9  20
 *         /  \
 *        15   7
 *
 * Levels:
 * Level 1 → 3
 * Level 2 → 9,20
 * Level 3 → 15,7
 *
 * Max Depth = 3
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

    public int maxDepthDFS(TreeNode root) {
        if (root == null) return 0;

        return 1 + Math.max(maxDepthDFS(root.left),
                            maxDepthDFS(root.right));
    }


    /* ================= BFS (Level Order) ================= */

    public int maxDepthBFS(TreeNode root) {

        if (root == null) return 0;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int depth = 0;

        while (!q.isEmpty()) {

            int size = q.size();

            while (size-- > 0) {

                TreeNode node = q.poll();

                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }

            depth++;
        }

        return depth;
    }
}
