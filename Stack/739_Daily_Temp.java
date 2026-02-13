/* 
 * Problem: 739. Daily Temperatures
 *
 * Given:
 * - An array temperatures[]
 *
 * Task:
 * - For each day, return how many days you have to wait
 *   until a warmer temperature.
 * - If no warmer day exists → return 0.
 *
 * Example:
 * Input:
 * [73,74,75,71,69,72,76,73]
 *
 * Output:
 * [1,1,4,2,1,1,0,0]
 *
 * -------------------------------------------------------
 * Core Idea:
 *
 * This is a classic:
 *      Next Greater Element problem
 *
 * Instead of finding next greater value,
 * we find distance to next greater value.
 *
 * We use a:
 *      Monotonic Decreasing Stack
 *
 * Stack stores:
 *      Indices (not temperatures)
 *
 * Why indices?
 * Because we must compute:
 *      distance = nextIndex - currentIndex
 *
 * -------------------------------------------------------
 * Strategy (Right to Left Traversal):
 *
 * We traverse from right → left because:
 * - Future warmer days are on right
 *
 * For each index i:
 *
 * 1. Pop elements from stack
 *      while current temp >= temp at stack top
 *
 * 2. If stack empty:
 *      No warmer day → result[i] = 0
 *
 * 3. Else:
 *      result[i] = st.peek() - i
 *
 * 4. Push current index into stack
 *
 * -------------------------------------------------------
 * Why Monotonic Stack Works?
 *
 * Stack always maintains:
 *      Increasing temperatures (from top to bottom)
 *
 * So top always gives:
 *      Next warmer day
 *
 * -------------------------------------------------------
 * Dry Run:
 *
 * temperatures = [73,74,75,71,69,72,76,73]
 *
 * Start from right:
 *
 * i=7 (73)
 *      stack empty → result=0
 *      push 7
 *
 * i=6 (76)
 *      pop 73
 *      stack empty → result=0
 *      push 6
 *
 * i=5 (72)
 *      72 < 76 → result = 6-5 = 1
 *      push 5
 *
 * Continue similarly...
 *
 * -------------------------------------------------------
 * Time Complexity:
 * O(n)
 *
 * Each element pushed once
 * Each element popped once
 *
 * Space Complexity:
 * O(n)
 *
 * Pattern:
 * Monotonic Stack + Next Greater Element
 */

import java.util.Stack;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

        int n = temperatures.length;

        Stack<Integer> st = new Stack<>();
        int[] result = new int[n];

        // Traverse from right to left
        for (int i = n - 1; i >= 0; i--) {

            // Remove all smaller or equal temperatures
            while (!st.isEmpty() && 
                   temperatures[i] >= temperatures[st.peek()]) {
                st.pop();
            }

            // If no warmer day
            if (st.isEmpty()) {
                result[i] = 0;
            }
            else {
                result[i] = st.peek() - i;
            }

            // Push current index
            st.push(i);
        }

        return result;
    }
}
