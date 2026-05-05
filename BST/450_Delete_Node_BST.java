/*
 * Problem: 450. Delete Node in a BST
 *
 * Given:
 * - Root of a Binary Search Tree (BST)
 * - Integer key
 *
 * Task:
 * - Delete the node with value = key
 * - Return the updated BST root
 *
 * BST Property:
 * - Left subtree values  < root
 * - Right subtree values > root
 *
 * -------------------------------------------------------
 * Logic:
 *
 * 1. Traverse tree using BST property to find the node.
 *
 * 2. Once found, handle 3 cases:
 *
 *    Case 1: Leaf Node
 *        → Simply delete (return null)
 *
 *    Case 2: One Child
 *        → Replace node with its child
 *
 *    Case 3: Two Children
 *        → Find inorder predecessor (max in left subtree)
 *        → Replace root value with predecessor value
 *        → Delete that predecessor node recursively
 *
 * -------------------------------------------------------
 * Dry Run:
 *
 *        5
 *       / \
 *      3   6
 *     / \   \
 *    2   4   7
 *
 * key = 3
 *
 * Node 3 has two children
 *
 * Inorder predecessor = 2
 *
 * Replace 3 → 2
 * Delete node 2 from left subtree
 *
 * Final Tree:
 *
 *        5
 *       / \
 *      2   6
 *       \   \
 *        4   7
 *
 * -------------------------------------------------------
 * Pseudocode:
 *
 * function delete(root, key):
 *
 *      if root == null:
 *          return null
 *
 *      if key < root.val:
 *          root.left = delete(root.left, key)
 *
 *      else if key > root.val:
 *          root.right = delete(root.right, key)
 *
 *      else:
 *          // node found
 *
 *          if leaf:
 *              return null
 *
 *          if one child:
 *              return that child
 *
 *          // two children
 *          pred = max(root.left)
 *          root.val = pred.val
 *          root.left = delete(root.left, pred.val)
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
 * BST + Recursion + Inorder Predecessor
 *
 * -------------------------------------------------------
 * Code:
 */

class Solution {

    public TreeNode deleteNode(TreeNode root, int key) {

        if (root == null) return null;

        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        }
        else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        }
        else {
            // Case 1: Leaf Node
            if (root.left == null && root.right == null) return null;

            // Case 2: One Child
            if (root.left == null) return root.right;
            else if (root.right == null) return root.left;

            // Case 3: Two Children
            TreeNode IS = findPredecessor(root.left);
            root.val = IS.val;
            root.left = deleteNode(root.left, IS.val);
        }

        return root;
    }

    public TreeNode findPredecessor(TreeNode root) {

        while (root.right != null) {
            root = root.right;
        }

        return root;
    }
}
