/*
 * Problem: Binary Tree Traversals (Preorder, Inorder, Postorder)
 *
 * Question:
 * - Given the root of a binary tree,
 *   return its traversal.
 *
 * - Preorder  → Root → Left → Right
 * - Inorder   → Left → Root → Right
 * - Postorder → Left → Right → Root
 *
 * -------------------------------------------------------
 * What is happening?
 *
 * We are performing Depth First Search (DFS).
 *
 * The only difference between the three traversals
 * is the position where we process (add) the node value.
 *
 *      Preorder  → Process BEFORE children
 *      Inorder   → Process BETWEEN children
 *      Postorder → Process AFTER children
 *
 * -------------------------------------------------------
 * Core Idea:
 *
 * Recursive:
 *      Use natural DFS structure.
 *
 * Iterative:
 *      Use Stack to simulate recursion.
 *
 * -------------------------------------------------------
 * Algorithm (Recursive Structure):
 *
 * preorder(root):
 *      if null → return
 *      process root
 *      preorder(left)
 *      preorder(right)
 *
 * inorder(root):
 *      if null → return
 *      inorder(left)
 *      process root
 *      inorder(right)
 *
 * postorder(root):
 *      if null → return
 *      postorder(left)
 *      postorder(right)
 *      process root
 *
 * -------------------------------------------------------
 * Iterative Logic:
 *
 * Preorder:
 *      Use stack
 *      Push right first, then left
 *
 * Inorder:
 *      Go extreme left
 *      Use stack to backtrack
 *
 * Postorder:
 *      Use two stacks
 *      OR reverse preorder (Root Right Left)
 *
 * -------------------------------------------------------
 * Example:
 *
 * Tree:
 *         1
 *        / \
 *       2   3
 *
 * Preorder  → [1,2,3]
 * Inorder   → [2,1,3]
 * Postorder → [2,3,1]
 *
 * -------------------------------------------------------
 * Time Complexity:
 * O(n)
 *
 * -------------------------------------------------------
 * Space Complexity:
 * O(n)   (Recursion stack / explicit stack)
 *
 * -------------------------------------------------------
 * Pattern:
 * DFS (Depth First Search)
 */
import java.util.*;

class Solution {

    /* ================= PREORDER ================= */

    // Recursive
    public List<Integer> preorderRecursive(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preorder(root, list);
        return list;
    }

    private void preorder(TreeNode root, List<Integer> list) {
        if (root == null) return;

        list.add(root.val);
        preorder(root.left, list);
        preorder(root.right, list);
    }

    // Iterative
    public List<Integer> preorderIterative(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        if (root == null) return list;

        Stack<TreeNode> st = new Stack<>();
        st.push(root);

        while (!st.isEmpty()) {
            TreeNode node = st.pop();
            list.add(node.val);

            if (node.right != null) st.push(node.right);
            if (node.left != null) st.push(node.left);
        }

        return list;
    }


    /* ================= INORDER ================= */

    // Recursive
    public List<Integer> inorderRecursive(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        return list;
    }

    private void inorder(TreeNode root, List<Integer> list) {
        if (root == null) return;

        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }

    // Iterative
    public List<Integer> inorderIterative(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        TreeNode curr = root;

        while (curr != null || !st.isEmpty()) {

            while (curr != null) {
                st.push(curr);
                curr = curr.left;
            }

            curr = st.pop();
            list.add(curr.val);
            curr = curr.right;
        }

        return list;
    }


    /* ================= POSTORDER ================= */

    // Recursive
    public List<Integer> postorderRecursive(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        postorder(root, list);
        return list;
    }

    private void postorder(TreeNode root, List<Integer> list) {
        if (root == null) return;

        postorder(root.left, list);
        postorder(root.right, list);
        list.add(root.val);
    }

    // Iterative (Two Stack Method)
    class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            // move to the left
            if (node != null) {
                stack.push(node);
                node = node.left;
            }
            // move to the right
            else if (stack.peek().right != null) {
                node = stack.peek().right;
            } else {
                TreeNode temp = stack.pop();
                res.add(temp.val);
                while (!stack.isEmpty() && temp == stack.peek().right) {
                    temp = stack.pop();
                    res.add(temp.val);
                }
            }
        }
        return res;
    }
}
