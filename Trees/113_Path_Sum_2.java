/*
 * Problem: 113. Path Sum II
 *
 * Given:
 * - Root of a binary tree
 * - Integer targetSum
 *
 * Task:
 * - Return all root-to-leaf paths
 *   where sum of node values equals targetSum.
 *
 * Return:
 * - List<List<Integer>>
 *
 * -------------------------------------------------------
 * Logic:
 *
 * Use DFS + Backtracking.
 *
 * For every node:
 *
 * 1. Add node value to current path
 * 2. Add node value to running sum
 * 3. If leaf node:
 *      check if sum == targetSum
 *      if yes → store path
 *
 * 4. Explore left subtree
 * 5. Explore right subtree
 *
 * 6. Backtrack:
 *      remove current node from path
 *
 * -------------------------------------------------------
 * Why Backtracking?
 *
 * - Same list is reused during recursion.
 * - After exploring one path,
 *   remove last node before returning.
 *
 * -------------------------------------------------------
 * Dry Run:
 *
 * targetSum = 22
 *
 *         5
 *        / \
 *       4   8
 *      /   / \
 *     11  13  4
 *    / \      / \
 *   7   2    5   1
 *
 * Valid Paths:
 *
 * 5 → 4 → 11 → 2 = 22
 * 5 → 8 → 4 → 5 = 22
 *
 * Output:
 * [[5,4,11,2],[5,8,4,5]]
 *
 * -------------------------------------------------------
 * Pseudocode:
 *
 * function helper(path, sum, root):
 *
 *      if root == null:
 *          return
 *
 *      sum += root.val
 *      add root.val to path
 *
 *      if leaf node:
 *
 *          if sum == target:
 *              store copy of path
 *
 *      helper(left)
 *      helper(right)
 *
 *      remove last element from path
 *
 * -------------------------------------------------------
 * Time Complexity:
 * O(n)
 *
 * Space Complexity:
 * O(h)
 *
 * Extra:
 * - Result list storage depends on number of paths
 *
 * Pattern:
 * Tree + DFS + Backtracking
 *
 * -------------------------------------------------------
 * Code:
 */

import java.util.*;

class Solution {

    List<List<Integer>> res = new ArrayList<>();

    public void helper(List<Integer> arr,
                       int sum,
                       TreeNode root,
                       int targetSum) {

        if (root == null) return;

        sum = sum + root.val;

        arr.add(root.val);

        if (root.left == null && root.right == null) {

            if (sum == targetSum) {
                res.add(new ArrayList<>(arr));
            }
        }

        helper(arr, sum, root.left, targetSum);

        helper(arr, sum, root.right, targetSum);

        // Backtracking
        arr.remove(arr.size() - 1);
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        int sum = 0;

        List<Integer> arr = new ArrayList<>();

        helper(arr, sum, root, targetSum);

        return res;
    }
}
