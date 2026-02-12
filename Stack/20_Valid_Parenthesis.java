/* 
 * Problem: 20. Valid Parentheses
 *
 * Given:
 * - A string s containing only:
 *      '(', ')', '{', '}', '[' and ']'
 *
 * Task:
 * - Return true if:
 *      Every opening bracket has a matching closing bracket
 *      Brackets close in correct order
 *
 * Example:
 * Input:  "()[]{}"
 * Output: true
 *
 * Input:  "(]"
 * Output: false
 *
 * -------------------------------------------------------
 * Core Idea:
 *
 * This is a classic Stack problem.
 *
 * Why Stack?
 * - Because brackets must close in reverse order.
 * - Last opened → First closed
 * - This is exactly LIFO behavior.
 *
 * -------------------------------------------------------
 * Strategy:
 *
 * 1. If length is odd → impossible → return false
 *
 * 2. Traverse string:
 *
 *      If opening bracket:
 *          Push into stack
 *
 *      If closing bracket:
 *          If stack empty → invalid
 *          Else:
 *              Pop and check if it matches
 *
 * 3. At the end:
 *      If stack is empty → valid
 *      Else → invalid
 *
 * -------------------------------------------------------
 * Why This Works?
 *
 * Example: "{[()]}"
 *
 * Push '{'
 * Push '['
 * Push '('
 * See ')'
 *      Pop '(' → matches
 * See ']'
 *      Pop '[' → matches
 * See '}'
 *      Pop '{' → matches
 *
 * Stack empty → valid
 *
 * -------------------------------------------------------
 * Algorithm:
 *
 * If length % 2 != 0 → return false
 *
 * Create empty stack
 *
 * For each character:
 *      If opening → push
 *      Else:
 *          If empty → return false
 *          Pop and check matching pair
 *          If not match → return false
 *
 * Return stack.isEmpty()
 *
 * -------------------------------------------------------
 * Time Complexity:
 * O(n)
 * (Single traversal)
 *
 * Space Complexity:
 * O(n)
 * (In worst case all characters are opening brackets)
 *
 * Pattern:
 * Stack + Matching Pairs + LIFO
 */

import java.util.Stack;

class Solution {
    public boolean isValid(String s) {

        // Odd length can never be valid
        if (s.length() % 2 != 0) {
            return false;
        }

        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            // If opening bracket → push
            if (ch == '(' || ch == '[' || ch == '{') {
                st.push(ch);
            } 
            else {
                // If stack empty → invalid
                if (st.isEmpty()) {
                    return false;
                }

                char top = st.pop();

                // Check matching pair
                if (ch == ')' && top != '(') {
                    return false;
                }

                if (ch == ']' && top != '[') {
                    return false;
                }

                if (ch == '}' && top != '{') {
                    return false;
                }
            }
        }

        // If stack empty → valid
        return st.isEmpty();
    }
}
