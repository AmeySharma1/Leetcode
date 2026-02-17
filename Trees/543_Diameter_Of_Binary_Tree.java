/*
 * Problem: 543. Diameter of Binary Tree
 *
 * Given:
 * - Root of a binary tree
 *
 * Task:
 * - Return the diameter of the tree.
 *
 * Diameter:
 * - Length of the longest path between any two nodes.
 * - Measured in number of EDGES.
 *
 * -------------------------------------------------------
 * Logic:
 *
 * - For every node:
 *      Find height of left subtree
 *      Find height of right subtree
 *
 * - Diameter passing through that node =
 *      leftHeight + rightHeight
 *
 * - Keep updating global maximum diameter.
 *
 * - Return height to parent:
 *      1 + max(leftHeight, rightHeight)
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
 * Heights:
 * Node 4 → 1
 * Node 5 → 1
 * Node 2 → 2
 *
 * At node 2:
 * left = 1
 * right = 1
 * diameter = 2
 *
 * At node 1:
 * left = 2
 * right = 1
 * diameter = 3  ← final answer
 *
 * Longest path:
 * 4 → 2 → 1 → 3
 *
 * -------------------------------------------------------
 * Pseudocode:
 *
 * diameter = 0
 *
 * function helper(node):
 *      if node == null:
 *          return 0
 *
 *      left = helper(node.left)
 *      right = helper(node.right)
 *
 *      diameter = max(diameter, left + right)
 *
 *      return 1 + max(left, right)
 *
 * call helper(root)
 * return diameter
 *
 * -------------------------------------------------------
 * Time Complexity:
 * O(n)
 *
 * Space Complexity:
 * O(h)  (recursion stack)
 *
 * Pattern:
 * Tree + DFS + Height Calculation
 *
 * -------------------------------------------------------
 * Code:
 */

class Solution {

    int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        diameter_helper(root);
        return diameter;
    }

    public int diameter_helper(TreeNode root) {

        if (root == null) return 0;

        int left_tree = diameter_helper(root.left);
        int right_tree = diameter_helper(root.right);

        diameter = Math.max(diameter, left_tree + right_tree);

        return 1 + Math.max(left_tree, right_tree);
    }
}
