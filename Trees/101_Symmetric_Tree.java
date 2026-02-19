/*
 * Problem: 101. Symmetric Tree
 *
 * Given:
 * - Root of a binary tree
 *
 * Task:
 * - Return true if the tree is symmetric (mirror of itself).
 *
 * Symmetric means:
 * - Left subtree is mirror image of right subtree.
 *
 * -------------------------------------------------------
 * Logic:
 *
 * - Compare two nodes at a time.
 *
 * Mirror condition:
 *      1. Values must be equal
 *      2. Left of first == Right of second
 *      3. Right of first == Left of second
 *
 * This is recursive DFS comparison.
 *
 * -------------------------------------------------------
 * Dry Run:
 *
 *        1
 *       / \
 *      2   2
 *     / \ / \
 *    3  4 4  3
 *
 * Compare:
 * left(2) with right(2)  ✔
 * left.left(3) with right.right(3) ✔
 * left.right(4) with right.left(4) ✔
 *
 * Result → true
 *
 * -------------------------------------------------------
 * Pseudocode:
 *
 * function isMirror(p, q):
 *
 *      if p == null AND q == null:
 *          return true
 *
 *      if one of them is null:
 *          return false
 *
 *      if p.val != q.val:
 *          return false
 *
 *      return isMirror(p.left, q.right)
 *             AND
 *             isMirror(p.right, q.left)
 *
 *
 * function isSymmetric(root):
 *
 *      if root == null:
 *          return true
 *
 *      return isMirror(root.left, root.right)
 *
 * -------------------------------------------------------
 * Time Complexity:
 * O(n)
 *
 * Space Complexity:
 * O(h)   (recursion stack)
 *
 * Pattern:
 * Tree + DFS + Mirror Comparison
 *
 * -------------------------------------------------------
 * Code:
 */

class Solution {

    public boolean isSame(TreeNode p, TreeNode q){

        if (p == null && q == null) return true;

        if (p == null || q == null) return false;

        if (p.val != q.val) return false;

        return isSame(p.left, q.right) &&
               isSame(p.right, q.left);
    }

    public boolean isSymmetric(TreeNode root) {

        if (root == null) return true;

        return isSame(root.left, root.right);
    }
}
