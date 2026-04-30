/*
 * Problem: 236. Lowest Common Ancestor of a Binary Tree
 *
 * Given:
 * - Root of a binary tree
 * - Two nodes p and q
 *
 * Task:
 * - Return the Lowest Common Ancestor (LCA) of p and q.
 *
 * Lowest Common Ancestor:
 * - The lowest node in the tree that has both
 *   p and q as descendants.
 *
 * -------------------------------------------------------
 * Logic:
 *
 * Use DFS recursion.
 *
 * For every node:
 *
 * 1. If current node is null → return null
 * 2. If current node is p or q → return current node
 * 3. Search left subtree
 * 4. Search right subtree
 *
 * Cases:
 *
 * - If left != null AND right != null
 *      → current node is LCA
 *
 * - If only one side returns non-null
 *      → propagate that node upward
 *
 * -------------------------------------------------------
 * Dry Run:
 *
 *        3
 *       / \
 *      5   1
 *     / \ / \
 *    6  2 0  8
 *      / \
 *     7   4
 *
 * p = 5
 * q = 1
 *
 * At node 3:
 * left returns 5
 * right returns 1
 *
 * Since both non-null:
 * LCA = 3
 *
 * -------------------------------------------------------
 * Pseudocode:
 *
 * function LCA(root, p, q):
 *
 *      if root == null:
 *          return null
 *
 *      if root == p OR root == q:
 *          return root
 *
 *      left = LCA(root.left, p, q)
 *      right = LCA(root.right, p, q)
 *
 *      if left != null AND right != null:
 *          return root
 *
 *      if left != null:
 *          return left
 *
 *      return right
 *
 * -------------------------------------------------------
 * Time Complexity:
 * O(n)
 *
 * Space Complexity:
 * O(h)
 *
 * Pattern:
 * Tree + DFS + Divide & Conquer
 *
 * -------------------------------------------------------
 * Code:
 */

class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        // Base case
        if (root == null || root == p || root == q) {
            return root;
        }

        // Search in left subtree
        TreeNode left = lowestCommonAncestor(root.left, p, q);

        // Search in right subtree
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // If both found
        if (left != null && right != null) {
            return root;
        }

        // Return whichever side found node
        return (left != null) ? left : right;
    }
}
