/*
 * Problem: 1021. Remove Outermost Parentheses
 *
 * Given:
 * - A valid parentheses string s
 *
 * Task:
 * - Remove outermost parentheses
 *   from every primitive substring.
 *
 * -------------------------------------------------------
 * Core Idea:
 *
 * Use Stack to track nesting depth.
 *
 * Outer parentheses are:
 *
 *      First '(' when stack empty
 *      Last ')' when stack becomes empty
 *
 * So:
 *
 * '(':
 *      Add only if stack already contains something
 *
 * ')':
 *      Pop first
 *      Add only if stack still has something
 *
 * -------------------------------------------------------
 * Strategy:
 *
 * Maintain:
 *      stack → depth tracker
 *      answer string
 *
 * -------------------------------------------------------
 * Dry Run:
 *
 * Input:
 * "(()())(())"
 *
 * Step-by-step:
 *
 * ch='('
 * stack empty → outer '(' → skip
 * push '('
 *
 * ch='('
 * stack not empty → add '('
 * push
 *
 * ans = "("
 *
 * ch=')'
 * pop
 * stack not empty → add ')'
 *
 * ans = "()"
 *
 * ch='('
 * stack not empty → add '('
 * push
 *
 * ans = "()("
 *
 * ch=')'
 * pop
 * stack not empty → add ')'
 *
 * ans = "()()"
 *
 * ch=')'
 * pop
 * stack empty → outer ')' → skip
 *
 * Primitive 1 completed
 *
 * Continue second primitive "(())"
 *
 * Final:
 * "()()()"
 *
 * -------------------------------------------------------
 * Algorithm:
 *
 * 1. Traverse string
 *
 * 2. If '(':
 *      If stack not empty:
 *          append
 *      push
 *
 * 3. If ')':
 *      pop
 *      If stack not empty:
 *          append
 *
 * 4. Return answer
 *
 * -------------------------------------------------------
 * Time Complexity:
 * O(n)
 *
 * Space Complexity:
 * O(n)
 *
 * Pattern:
 * Stack + Parentheses Depth Tracking
 */

import java.util.Stack;

class Solution {

    public String removeOuterParentheses(String s) {

        Stack<Character> st = new Stack<>();
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (ch == '(') {

                if (!st.isEmpty()) {
                    ans.append(ch);
                }

                st.push(ch);
            }

            else {

                st.pop();

                if (!st.isEmpty()) {
                    ans.append(ch);
                }
            }
        }

        return ans.toString();
    }
}
