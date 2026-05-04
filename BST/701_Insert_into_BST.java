/*
 * Problem: 701. Insert into a Binary Search Tree
 *
 * Given:
 * - Root of a BST
 * - Integer val
 *
 * Task:
 * - Insert val into BST
 * - Return root of updated tree
 *
 * BST Property:
 * - Left subtree values  < root
 * - Right subtree values > root
 *
 * -------------------------------------------------------
 * Logic:
 *
 * - Traverse tree using BST property.
 *
 * At each node:
 *
 * 1. If root is null:
 *      create new node and return
 *
 * 2. If val < root.val:
 *      go to left subtree
 *
 * 3. Else:
 *      go to right subtree
 *
 * - Insert at correct null position
 *
 * -------------------------------------------------------
 * Dry Run:
 *
 *        4
 *       / \
 *      2   7
 *
 * val = 5
 *
 * Step 1:
 * 5 > 4 → go right
 *
 * Step 2:
 * 5 < 7 → go left
 *
 * Step 3:
 * left of 7 is null → insert here
 *
 * Final Tree:
 *
 *        4
 *       / \
 *      2   7
 *         /
 *        5
 *
 * -------------------------------------------------------
 * Pseudocode:
 *
 * function insert(root, val):
 *
 *      if root == null:
 *          return new Node(val)
 *
 *      if val < root.val:
 *          root.left = insert(root.left, val)
 *
 *      else:
 *          root.right = insert(root.right, val)
 *
 *      return root
 *
 * -------------------------------------------------------
 * Time Complexity:
 * O(h)
 *
 * Space Complexity:
 * O(h)
 *
 * Pattern:
 * BST + Recursion
 *
 * -------------------------------------------------------
 * Code:
 */

class Solution {

    public TreeNode insertIntoBST(TreeNode root, int val) {

        if (root == null) return new TreeNode(val);

        if (val < root.val) {

            if (root.left == null) root.left = new TreeNode(val);
            else insertIntoBST(root.left, val);

        } else {

            if (root.right == null) root.right = new TreeNode(val);
            else insertIntoBST(root.right, val);
        }

        return root;
    }
}
