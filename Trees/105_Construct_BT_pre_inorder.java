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
 * -------------------------------------------------------
 * What is happening?
 *
 * Preorder gives the ROOT first.
 *
 * Inorder tells:
 *      Left of root  → left subtree
 *      Right of root → right subtree
 *
 * So:
 *      Pick root from preorder
 *      Split inorder
 *      Recursively build left and right
 *
 * -------------------------------------------------------
 * Core Idea:
 *
 * - Use HashMap for inorder index lookup.
 * - Use pointer to track preorder index.
 * - Always build left subtree first.
 *
 * -------------------------------------------------------
 * Algorithm:
 *
 * 1. Store inorder elements in HashMap.
 *
 * 2. Maintain preorder index pointer.
 *
 * 3. helper(left, right):
 *
 *      If left > right → return null
 *
 *      curr = preorder[index]
 *      index++
 *
 *      Create node
 *
 *      inorderIndex = map.get(curr)
 *
 *      node.left  = helper(left, inorderIndex - 1)
 *      node.right = helper(inorderIndex + 1, right)
 *
 *      return node
 *
 * -------------------------------------------------------
 * Example:
 *
 * preorder = [3,9,20,15,7]
 * inorder  = [9,3,15,20,7]
 *
 * Tree formed:
 *
 *        3
 *       / \
 *      9  20
 *         /  \
 *        15   7
 *
 * -------------------------------------------------------
 * Time Complexity:
 * O(n)
 *
 * Space Complexity:
 * O(n)
 *
 * Pattern:
 * Tree Construction
 *
 * -------------------------------------------------------
 * Code:
 */

import java.util.HashMap;

class Solution {

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        int[] index = {0};

        return helper(preorder, 0, preorder.length - 1, map, index);
    }

    private TreeNode helper(int[] preorder,
                            int left,
                            int right,
                            HashMap<Integer, Integer> map,
                            int[] index) {

        if (left > right) return null;

        int curr = preorder[index[0]];
        index[0]++;

        TreeNode node = new TreeNode(curr);

        int inorderIndex = map.get(curr);

        node.left = helper(preorder, left, inorderIndex - 1, map, index);
        node.right = helper(preorder, inorderIndex + 1, right, map, index);

        return node;
    }
}
