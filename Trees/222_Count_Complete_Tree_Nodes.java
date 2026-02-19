/*
 * Problem: 222. Count Complete Tree Nodes
 *
 * Given:
 * - Root of a binary tree
 *
 * Task:
 * - Return the total number of nodes in the tree.
 *
 * -------------------------------------------------------
 * Logic (Simple DFS):
 *
 * - If root is null → return 0
 * - Count current node (1)
 * - Recursively count left subtree
 * - Recursively count right subtree
 * - Return total
 *
 * This is plain preorder traversal counting.
 *
 * -------------------------------------------------------
 * Dry Run:
 *
 *        1
 *       / \
 *      2   3
 *     / \
 *    4   5
 *
 * count(1)
 * = 1
 * + count(2)
 * + count(3)
 *
 * count(2)
 * = 1
 * + count(4)
 * + count(5)
 *
 * Final Answer = 5
 *
 * -------------------------------------------------------
 * Pseudocode:
 *
 * function countNodes(root):
 *
 *      if root == null:
 *          return 0
 *
 *      leftCount = countNodes(root.left)
 *      rightCount = countNodes(root.right)
 *
 *      return 1 + leftCount + rightCount
 *
 * -------------------------------------------------------
 * Time Complexity:
 * O(n)
 *
 * Space Complexity:
 * O(h)   (recursion stack)
 *
 * Pattern:
 * Tree + DFS + Counting
 *
 * -------------------------------------------------------
 * Code:
 */

class Solution {

    public int countNodes(TreeNode root) {

        if (root == null) return 0;

        int count = 1;

        count += countNodes(root.left);
        count += countNodes(root.right);

        return count;
    }
}
