/*
 * Problem: 100. Same Tree
 *
 * Given:
 * - Two roots p and q of binary trees
 *
 * Task:
 * - Return true if both trees are identical.
 *
 * Identical means:
 * 1. Same structure
 * 2. Same node values
 *
 * -------------------------------------------------------
 * Logic:
 *
 * For every pair of nodes:
 *
 * 1. If both are null → true
 * 2. If one is null → false
 * 3. If values differ → false
 * 4. Recursively check:
 *        left with left
 *        right with right
 *
 * If all conditions satisfy → trees are same.
 *
 * -------------------------------------------------------
 * Dry Run:
 *
 * Tree 1:        Tree 2:
 *
 *     1              1
 *    / \            / \
 *   2   3          2   3
 *
 * Compare:
 * 1 == 1 ✔
 * 2 == 2 ✔
 * 3 == 3 ✔
 *
 * Result → true
 *
 * -------------------------------------------------------
 * Pseudocode:
 *
 * function isSameTree(p, q):
 *
 *      if p == null AND q == null:
 *          return true
 *
 *      if p == null OR q == null:
 *          return false
 *
 *      if p.val != q.val:
 *          return false
 *
 *      return isSameTree(p.left, q.left)
 *             AND
 *             isSameTree(p.right, q.right)
 *
 * -------------------------------------------------------
 * Time Complexity:
 * O(n)
 *
 * Space Complexity:
 * O(h)   (recursion stack)
 *
 * Pattern:
 * Tree + DFS + Structural Comparison
 *
 * -------------------------------------------------------
 * Code:
 */

class Solution {

    public boolean isSameTree(TreeNode p, TreeNode q) {

        if (p == null && q == null) return true;

        if (p == null || q == null) return false;

        if (p.val != q.val) return false;

        return isSameTree(p.left, q.left) &&
               isSameTree(p.right, q.right);
    }
}
