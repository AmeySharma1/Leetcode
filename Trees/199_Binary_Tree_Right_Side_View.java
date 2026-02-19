/*
 * Problem: 199. Binary Tree Right Side View
 *
 * Given:
 * - Root of a binary tree
 *
 * Task:
 * - Return the values of the nodes visible from the right side.
 *
 * Right side view:
 * - At each level, only the rightmost node is visible.
 *
 * -------------------------------------------------------
 * Logic (BFS - Level Order Traversal):
 *
 * - Traverse level by level using a queue.
 * - For each level:
 *      Process all nodes.
 *      The last node processed at that level
 *      will be the rightmost node.
 * - Add that node’s value to result.
 *
 * -------------------------------------------------------
 * Dry Run:
 *
 *        1
 *       / \
 *      2   3
 *       \   \
 *        5   4
 *
 * Level 1 → 1
 * Level 2 → 3
 * Level 3 → 4
 *
 * Output: [1, 3, 4]
 *
 * -------------------------------------------------------
 * Pseudocode:
 *
 * function rightSideView(root):
 *
 *      if root == null:
 *          return empty list
 *
 *      create queue
 *      add root
 *
 *      while queue not empty:
 *
 *          size = queue.size()
 *
 *          for i in range(size):
 *
 *              node = queue.poll()
 *
 *              add left child to queue
 *              add right child to queue
 *
 *              if i == size - 1:
 *                  add node.val to result
 *
 *      return result
 *
 * -------------------------------------------------------
 * Time Complexity:
 * O(n)
 *
 * Space Complexity:
 * O(n)
 *
 * Pattern:
 * Tree + BFS + Level Order
 *
 * -------------------------------------------------------
 * Code:
 */

import java.util.*;

class Solution {

    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {

            int size = q.size();

            while (size-- > 0) {

                TreeNode node = q.poll();

                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);

                if (size == 0) res.add(node.val);
            }
        }

        return res;
    }
}
