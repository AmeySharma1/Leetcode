/*
 * Problem: 103. Binary Tree Zigzag Level Order Traversal
 *
 * Given:
 * - Root of a binary tree
 *
 * Task:
 * - Return zigzag level order traversal.
 *
 * Zigzag:
 * - Even level  → Left to Right
 * - Odd level   → Right to Left
 *
 * -------------------------------------------------------
 * Logic:
 *
 * Use BFS (Level Order Traversal).
 *
 * - Traverse tree level by level.
 * - Maintain level number.
 *
 * If:
 *      level % 2 == 0
 *          add normally
 *
 * Else:
 *      add at front
 *
 * LinkedList is used because:
 *      addFirst() and addLast() are O(1)
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
 * Level 0:
 * [3]
 *
 * Level 1:
 * [20,9]
 *
 * Level 2:
 * [15,7]
 *
 * Output:
 * [[3],[20,9],[15,7]]
 *
 * -------------------------------------------------------
 * Pseudocode:
 *
 * function zigzagLevelOrder(root):
 *
 *      if root == null:
 *          return empty list
 *
 *      queue.add(root)
 *      level = 0
 *
 *      while queue not empty:
 *
 *          size = queue.size()
 *          create LinkedList arr
 *
 *          repeat size times:
 *
 *              node = queue.poll()
 *
 *              if even level:
 *                  arr.addLast(node.val)
 *              else:
 *                  arr.addFirst(node.val)
 *
 *              add children
 *
 *          add arr to result
 *          level++
 *
 * -------------------------------------------------------
 * Time Complexity:
 * O(n)
 *
 * Space Complexity:
 * O(n)
 *
 * Pattern:
 * Tree + BFS + Zigzag Traversal
 *
 * -------------------------------------------------------
 * Code:
 */

import java.util.*;

class Solution {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> list = new ArrayList<>();

        if (root == null) return list;

        q.add(root);

        int level = 0;

        while (!q.isEmpty()) {

            int size = q.size();

            LinkedList<Integer> arr = new LinkedList<>();

            while (size-- > 0) {

                TreeNode node = q.poll();

                if (level % 2 == 0) {
                    arr.addLast(node.val);
                } else {
                    arr.addFirst(node.val);
                }

                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }

            list.add(arr);
            level++;
        }

        return list;
    }
}
