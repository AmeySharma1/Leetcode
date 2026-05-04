/*
 * Problem: 700. Search in a Binary Search Tree
 *
 * Given:
 * - Root of a Binary Search Tree (BST)
 * - Integer val
 *
 * Task:
 * - Return the node whose value == val
 * - If not found → return null
 *
 * BST Property:
 * - Left subtree values  < root
 * - Right subtree values > root
 *
 * -------------------------------------------------------
 * Logic:
 *
 * Use BST property to reduce search space.
 *
 * At each node:
 *
 * 1. If root is null → return null
 *
 * 2. If root.val == val → found → return root
 *
 * 3. If val < root.val:
 *      search in left subtree
 *
 * 4. If val > root.val:
 *      search in right subtree
 *
 * -------------------------------------------------------
 * Dry Run:
 *
 *        4
 *       / \
 *      2   7
 *     / \
 *    1   3
 *
 * val = 2
 *
 * Step 1:
 * 2 < 4 → go left
 *
 * Step 2:
 * root = 2 → found
 *
 * -------------------------------------------------------
 * Pseudocode:
 *
 * function searchBST(root, val):
 *
 *      if root == null:
 *          return null
 *
 *      if root.val == val:
 *          return root
 *
 *      if val < root.val:
 *          return searchBST(root.left, val)
 *
 *      else:
 *          return searchBST(root.right, val)
 *
 * -------------------------------------------------------
 * Time Complexity:
 * O(h)
 *
 * Space Complexity:
 * O(h)   (recursion stack)
 *
 * Pattern:
 * BST + Binary Search
 *
 * -------------------------------------------------------
 * Code:
 */

class Solution {

    public TreeNode searchBST(TreeNode root, int val) {

        if (root == null) return root;

        if (root.val == val) return root;

        if (val < root.val) return searchBST(root.left, val);

        if (val > root.val) return searchBST(root.right, val);

        return root;
    }
}
