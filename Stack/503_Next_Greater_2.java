/*
 * Problem: 503. Next Greater Element II
 *
 * Given:
 * - Circular integer array nums[]
 *
 * Task:
 * - For every element,
 *   find next greater element.
 *
 * - If no greater element exists → return -1
 *
 * -------------------------------------------------------
 * What is Circular Array?
 *
 * Circular means:
 *      After last index,
 *      traversal continues from beginning.
 *
 * Example:
 *
 * nums = [1,2,1]
 *
 * For last 1:
 *      next greater = 2
 *
 * Output:
 * [2,-1,2]
 *
 * -------------------------------------------------------
 * Core Idea:
 *
 * This is:
 *      Next Greater Element + Circular Array
 *
 * Use:
 *      Monotonic Decreasing Stack
 *
 * Stack stores:
 *      Values (not indexes)
 *
 * -------------------------------------------------------
 * Trick for Circular Array:
 *
 * Traverse array twice.
 *
 * Why?
 *
 * Because:
 *      Elements at end may find answer at beginning.
 *
 * So loop runs:
 *
 *      from (2*n - 1) → 0
 *
 * Access actual index using:
 *
 *      i % n
 *
 * -------------------------------------------------------
 * Monotonic Stack Property:
 *
 * Stack maintains:
 *      decreasing order
 *
 * Top always gives:
 *      nearest greater element
 *
 * -------------------------------------------------------
 * Strategy:
 *
 * Traverse from right → left
 *
 * For each element:
 *
 *      Remove smaller/equal values
 *
 *      If stack empty:
 *          no greater → -1
 *
 *      Else:
 *          stack.peek() = next greater
 *
 * Push current element.
 *
 * -------------------------------------------------------
 * Dry Run:
 *
 * Input:
 * [1,2,1]
 *
 * n = 3
 *
 * Traverse:
 *
 * i=5 → nums[2]=1
 * stack empty
 * push 1
 *
 * stack = [1]
 *
 * ----------------
 *
 * i=4 → nums[1]=2
 *
 * pop 1
 * stack empty
 * push 2
 *
 * stack = [2]
 *
 * ----------------
 *
 * i=3 → nums[0]=1
 *
 * top=2 > 1
 * push 1
 *
 * stack = [2,1]
 *
 * ----------------
 *
 * Now filling answers
 *
 * i=2 → nums[2]=1
 *
 * pop 1
 * top=2
 *
 * res[2] = 2
 *
 * ----------------
 *
 * i=1 → nums[1]=2
 *
 * pop 2
 * stack empty
 *
 * res[1] = -1
 *
 * ----------------
 *
 * i=0 → nums[0]=1
 *
 * top=2
 *
 * res[0] = 2
 *
 * Final:
 *
 * [2,-1,2]
 *
 * -------------------------------------------------------
 * Algorithm:
 *
 * 1. Create empty stack
 * 2. Traverse from (2*n -1) → 0
 *
 *      While stack not empty
 *            AND current >= stack.peek():
 *
 *            pop
 *
 *      If i < n:
 *          fill answer
 *
 *      Push current element
 *
 * 3. Return result
 *
 * -------------------------------------------------------
 * Time Complexity:
 * O(n)
 *
 * Each element pushed once
 * Each popped once
 *
 * Space Complexity:
 * O(n)
 *
 * Pattern:
 * Monotonic Stack + Circular Array
 */

import java.util.Stack;

class Solution {

    public int[] nextGreaterElements(int[] nums) {

        Stack<Integer> st = new Stack<>();

        int n = nums.length;
        int[] res = new int[n];

        for (int i = 2 * n - 1; i >= 0; i--) {

            int current = nums[i % n];

            while (!st.isEmpty() && current >= st.peek()) {
                st.pop();
            }

            if (i < n) {

                if (st.isEmpty()) {
                    res[i] = -1;
                }

                else {
                    res[i] = st.peek();
                }
            }

            st.push(current);
        }

        return res;
    }
}
