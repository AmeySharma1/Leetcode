/*
 * Problem: 105. Construct Binary Tree from Preorder and Inorder Traversal
 *
 * Given:
 * - int[] preorder
 * - int[] inorder
 *
 * Task:
 * - Construct and return the binary tree.
 *
 * preorder:
 * - Root → Left → Right
 *
 * inorder:
 * - Left → Root → Right
 *
 * -------------------------------------------------------
 * Logic:
 *
 * Preorder always gives current root first.
 *
 * Steps:
 *
 * 1. Pick current root from preorder[idx]
 * 2. Find root position in inorder
 * 3. Left side of inorder → left subtree
 * 4. Right side of inorder → right subtree
 * 5. Recursively build tree
 *
 * Global idx:
 * - Tracks current preorder element.
 *
 * -------------------------------------------------------
 * Dry Run:
 *
 * preorder = [3,9,20,15,7]
 * inorder  = [9,3,15,20,7]
 *
 * idx = 0
 *
 * root = 3
 *
 * inorder split:
 *
 * left  = [9]
 * right = [15,20,7]
 *
 * Build recursively.
 *
 * Final Tree:
 *
 *        3
 *       / \
 *      9  20
 *         / \
 *        15  7
 *
 * -------------------------------------------------------
 * Pseudocode:
 *
 * idx = 0
 *
 * function solve(preorder, inorder, st, end):
 *
 *      if st > end:
 *          return null
 *
 *      rootValue = preorder[idx]
 *      create root
 *
 *      find root index in inorder
 *
 *      idx++
 *
 *      root.left =
 *          solve(st, rootIndex - 1)
 *
 *      root.right =
 *          solve(rootIndex + 1, end)
 *
 *      return root
 *
 * -------------------------------------------------------
 * Time Complexity:
 * O(n²)
 *
 * Why?
 * - For every node,
 *   linear search in inorder array.
 *
 * -------------------------------------------------------
 * Space Complexity:
 * O(h)
 *
 * Pattern:
 * Tree Construction + DFS + Divide & Conquer
 *
 * -------------------------------------------------------
 * Code:
 */

class Solution {

    int idx = 0;

    public TreeNode solve(int[] preorder,
                          int[] inorder,
                          int st,
                          int end) {

        if (st > end) {
            return null;
        }

        int rootval = preorder[idx];

        TreeNode root = new TreeNode(rootval);

        int i = st;

        for (; i <= end; i++) {
            if (inorder[i] == rootval) {
                break;
            }
        }

        idx++;

        root.left = solve(preorder, inorder, st, i - 1);

        root.right = solve(preorder, inorder, i + 1, end);

        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        int n = preorder.length;

        return solve(preorder, inorder, 0, n - 1);
    }
}
