/*
 * Problem: 901. Online Stock Span
 *
 * Design a class:
 *      StockSpanner
 *
 * Method:
 *      int next(int price)
 *
 * Task:
 * - For each day's price,
 *   return the span of that price.
 *
 * -------------------------------------------------------
 * What is Span?
 *
 * Span = number of consecutive days
 *        (including today)
 *        where price <= today's price.
 *
 * -------------------------------------------------------
 * Example:
 *
 * Prices:
 * [100, 80, 60, 70, 60, 75, 85]
 *
 * Output:
 * [1, 1, 1, 2, 1, 4, 6]
 *
 * Explanation:
 *
 * 100 → 1
 * 80  → 1
 * 60  → 1
 * 70  → 2  (60,70)
 * 60  → 1
 * 75  → 4  (60,70,60,75)
 * 85  → 6
 *
 * -------------------------------------------------------
 * Core Idea:
 *
 * Use MONOTONIC DECREASING STACK
 *
 * Stack stores:
 *      [price, span]
 *
 * Why store span?
 * Because when popping smaller prices,
 * we can directly accumulate their span.
 *
 * -------------------------------------------------------
 * Algorithm:
 *
 * For each next(price):
 *
 *      span = 1
 *
 *      While stack not empty
 *            AND stack.peek().price <= price:
 *
 *            span += stack.pop().span
 *
 *      Push {price, span}
 *
 *      Return span
 *
 * -------------------------------------------------------
 * Time Complexity:
 * Amortized O(1) per call
 * Overall O(n)
 *
 * Space Complexity:
 * O(n)
 *
 * Pattern:
 * Monotonic Stack (Decreasing)
 */

import java.util.Stack;

class StockSpanner {

    private Stack<int[]> stack;

    public StockSpanner() {
        stack = new Stack<>();
    }

    public int next(int price) {

        int span = 1;

        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            span += stack.pop()[1];
        }

        stack.push(new int[]{price, span});

        return span;
    }
}
