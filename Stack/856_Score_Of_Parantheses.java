/*
 * Problem: 856. Score of Parentheses
 *
 * Given:
 * - A balanced parentheses string s
 *
 * Task:
 * - Compute its score
 *
 * -------------------------------------------------------
 * Scoring Rules:
 *
 * 1. "()" has score = 1
 *
 * 2. AB has score = score(A) + score(B)
 *      (Concatenation)
 *
 * 3. "(A)" has score = 2 * score(A)
 *      (Wrapping)
 *
 * -------------------------------------------------------
 * Examples:
 *
 * "()"        → 1
 * "(())"      → 2
 * "()()"      → 2
 * "(()(()))"  → 6
 *
 * -------------------------------------------------------
 * Core Idea:
 *
 * Use Stack to store previous scores
 * whenever we enter a new '(' level.
 *
 * Maintain:
 *      score → current level score
 *
 * -------------------------------------------------------
 * When we see:
 *
 * '(':
 *      Push current score
 *      Reset score to 0
 *
 * ')':
 *      If inside was empty → score = 1
 *      Else → score = 2 * score
 *
 *      Add previous score from stack
 *
 * Implementation trick:
 *      score = stack.pop() + max(2 * score, 1)
 *
 * Why?
 *      If score was 0 → means "()"
 *      So max(0,1) = 1
 *
 * -------------------------------------------------------
 * Algorithm:
 *
 * 1. Initialize:
 *      stack
 *      score = 0
 *
 * 2. Traverse string:
 *
 *      If '(':
 *          push(score)
 *          score = 0
 *
 *      If ')':
 *          score = stack.pop() + max(2 * score, 1)
 *
 * 3. Return score
 *
 * -------------------------------------------------------
 * Time Complexity:
 * O(n)
 *
 * Space Complexity:
 * O(n)
 *
 * Pattern:
 * Stack + Parenthesis Evaluation
 */

import java.util.Stack;

class Solution {

    public int scoreOfParentheses(String s) {

        Stack<Integer> st = new Stack<>();
        int score = 0;

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (ch == '(') {
                st.push(score);
                score = 0;
            }

            else {
                score = st.pop() + Math.max(2 * score, 1);
            }
        }

        return score;
    }
