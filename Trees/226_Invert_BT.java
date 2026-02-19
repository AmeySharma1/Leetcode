/*
 * Problem: 226. Invert Binary Tree
 *
 * Given:
 * - Root of a binary tree
 *
 * Task:
 * - Invert (mirror) the binary tree.
 *
 * Inversion means:
 * - Swap left and right child of every node.
 *
 * -------------------------------------------------------
 * Logic:
 *
 * - For every node:
 *      Swap left and right child
 * - Recursively invert left subtree
 * - Recursively invert right subtree
 *
 * This is simple DFS (Preorder traversal).
 *
 * -------------------------------------------------------
 * Dry Run:
 *
 * Original:
 *
 *        4
 *       / \
 *      2   7
 *     / \ / \
 *    1  3 6  9
 *
 * After Inversion:
 *
 *        4
 *       / \
 *      7   2
 *     / \ / \
 *    9  6 3  1
 *
 * -------------------------------------------------------
 * Pseudocode:
 *
 * function invertTree(root):
 *
 *      if root == null:
 *          return null
 *
 *      swap(root.left, root.right)
 *
 *      invertTree(root.left)
 *      invertTree(root.right)
 *
 *      return root
 *
 * -------------------------------------------------------
 * Time Complexity:
 * O(n)
 *
 * Space Complexity:
 * O(h)   (recursion stack)
 *
 * Pattern:
 * Tree + DFS + Swap Children
 *
 * -------------------------------------------------------
 * Code:
 */

class Solution {

    public TreeNode invertTree(TreeNode root) {

        if (root == null) return root;

        TreeNode l = root.left;
        TreeNode r = root.right;

        root.left = r;
        root.right = l;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}
