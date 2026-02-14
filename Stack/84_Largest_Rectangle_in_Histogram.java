/*
 * Problem: 84. Largest Rectangle in Histogram
 *
 * Given:
 * - int[] heights
 * - Each value represents bar height
 * - Width of each bar = 1
 *
 * Task:
 * - Find largest rectangle area possible
 *
 * -------------------------------------------------------
 * Core Idea:
 *
 * For every bar, we want:
 *      The widest rectangle where this bar
 *      is the SMALLEST height.
 *
 * That means we must find:
 *
 *      1. Previous Smaller Element (left boundary)
 *      2. Next Smaller Element (right boundary)
 *
 * Instead of computing separately,
 * we use a MONOTONIC INCREASING STACK.
 *
 * Stack stores INDEXES (not heights).
 *
 * -------------------------------------------------------
 * Why Increasing Stack?
 *
 * We maintain:
 *      heights[stack[0]] <= heights[stack[1]] <= ...
 *
 * When current height is smaller than top,
 * it means rectangle for stack top must end here.
 *
 * -------------------------------------------------------
 * Width Formula:
 *
 * After popping index:
 *
 *      height = heights[poppedIndex]
 *
 *      right boundary = i - 1
 *
 *      left boundary =
 *              stack.peek() + 1   (if stack not empty)
 *              0                  (if stack empty)
 *
 *      width = i - previousSmallerIndex - 1
 *
 * -------------------------------------------------------
 * Important Trick:
 *
 * Run loop till i <= n
 *
 * When i == n:
 *      Treat height as 0
 *      This forces stack to empty
 *      and compute remaining areas
 *
 * -------------------------------------------------------
 * Algorithm:
 *
 * 1. Initialize empty stack
 * 2. For i = 0 to n:
 *
 *      currentHeight =
 *          (i == n) ? 0 : heights[i]
 *
 *      While stack not empty AND
 *            heights[stack.peek()] > currentHeight:
 *
 *              h = heights[stack.pop()]
 *
 *              previousSmallerIndex =
 *                  stack.isEmpty() ? -1 : stack.peek()
 *
 *              width = i - previousSmallerIndex - 1
 *
 *              area = h * width
 *
 *              update max
 *
 *      Push i into stack
 *
 * 3. Return max
 *
 * -------------------------------------------------------
 * Example:
 *
 * Input:
 * [2,1,5,6,2,3]
 *
 * Output:
 * 10
 *
 * Rectangle:
 * height = 5
 * width = 2
 *
 * -------------------------------------------------------
 * Time Complexity:
 * O(n)
 *
 * Space Complexity:
 * O(n)
 *
 * Pattern:
 * Monotonic Increasing Stack
 * Previous Smaller + Next Smaller
 */

import java.util.Stack;

class Solution {

    public int largestRectangleArea(int[] heights) {

        Stack<Integer> stack = new Stack<>();
        int n = heights.length;
        int max = 0;

        for (int i = 0; i <= n; i++) {

            int currentHeight = (i == n) ? 0 : heights[i];

            while (!stack.isEmpty() && heights[stack.peek()] > currentHeight) {

                int h = heights[stack.pop()];

                int previousSmallerIndex =
                        stack.isEmpty() ? -1 : stack.peek();

                int width = i - previousSmallerIndex - 1;

                int area = h * width;

                max = Math.max(max, area);
            }

            stack.push(i);
        }

        return max;
    }
}
