/*
 * Problem: 102. Binary Tree Level Order Traversal
 *
 * Given:
 * - Root of a binary tree
 *
 * Task:
 * - Return level order traversal of the tree.
 *
 * Level Order:
 * - Traverse nodes level by level
 * - Left to right at each level
 *
 * Return:
 * - List<List<Integer>>
 *
 * -------------------------------------------------------
 * Logic:
 *
 * Use BFS (Breadth First Search).
 *
 * - Queue helps process nodes level by level.
 *
 * For every level:
 *      1. Store queue size
 *      2. Process exactly those many nodes
 *      3. Add their children into queue
 *      4. Store current level values
 *
 * -------------------------------------------------------
 * Dry Run:
 *
 *        3
 *       / \
 *      9  20
 *         / \
 *        15  7
 *
 * Queue = [3]
 *
 * Level 1:
 * [3]
 *
 * Queue = [9,20]
 *
 * Level 2:
 * [9,20]
 *
 * Queue = [15,7]
 *
 * Level 3:
 * [15,7]
 *
 * Output:
 * [[3],[9,20],[15,7]]
 *
 * -------------------------------------------------------
 * Pseudocode:
 *
 * function levelOrder(root):
 *
 *      create result list
 *
 *      if root == null:
 *          return result
 *
 *      create queue
 *      add root
 *
 *      while queue not empty:
 *
 *          size = queue.size()
 *          create currentLevel list
 *
 *          repeat size times:
 *
 *              node = queue.poll()
 *              add node value
 *
 *              if left exists:
 *                  add left child
 *
 *              if right exists:
 *                  add right child
 *
 *          add currentLevel to result
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
 * Tree + BFS + Level Order Traversal
 *
 * -------------------------------------------------------
 * Code:
 */

import java.util.*;

class Solution {

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        if (root == null) return list;

        q.offer(root);

        while (!q.isEmpty()) {

            int size = q.size();
            ArrayList<Integer> arr = new ArrayList<>();

            while (size-- > 0) {

                TreeNode node = q.poll();

                arr.add(node.val);

                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }

            list.add(arr);
        }

        return list;
    }
}
