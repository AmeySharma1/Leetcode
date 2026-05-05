/*
 * Problem: 110. Balanced Binary Tree
 *
 * Given:
 * - Root of a binary tree
 *
 * Task:
 * - Return true if the tree is height-balanced.
 *
 * Balanced means:
 * - For every node,
 *   |height(left) - height(right)| ≤ 1
 *
 * -------------------------------------------------------
 * Logic:
 *
 * Instead of checking balance separately for every node
 * (which would be O(n²)),
 *
 * We:
 * - Compute height bottom-up
 * - If any subtree is unbalanced → return -1 immediately
 *
 * Trick:
 * - height() returns:
 *      normal height → if balanced
 *      -1 → if unbalanced
 *
 * If we ever get -1, we propagate it upward.
 *
 * -------------------------------------------------------
 * Dry Run:
 *
 * Example (Balanced):
 *
 *        3
 *       / \
 *      9  20
 *         / \
 *        15  7
 *
 * All height differences ≤ 1
 * → returns true
 *
 * Example (Unbalanced):
 *
 *        1
 *       /
 *      2
 *     /
 *    3
 *
 * Height difference > 1
 * → returns false
 *
 * -------------------------------------------------------
 * Pseudocode:
 *
 * function height(node):
 *
 *      if node == null:
 *          return 0
 *
 *      left = height(node.left)
 *      right = height(node.right)
 *
 *      if left == -1 OR right == -1:
 *          return -1
 *
 *      if |left - right| > 1:
 *          return -1
 *
 *      return 1 + max(left, right)
 *
 *
 * function isBalanced(root):
 *
 *      return height(root) != -1
 *
 * -------------------------------------------------------
 * Time Complexity:
 * O(n)
 *
 * Space Complexity:
 * O(h)  (recursion stack)
 *
 * Pattern:
 * Tree + DFS + Bottom-Up Height Check
 *
 * -------------------------------------------------------
 * Code:
 */

class Solution {
    public int height(TreeNode root){
        if(root==null) return 0;
        return 1+Math.max(height(root.left),height(root.right));
    }
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        int h1 = height(root.left);
        int h2 = height(root.right);
        if(Math.abs(h1-h2)>1) return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }
}
