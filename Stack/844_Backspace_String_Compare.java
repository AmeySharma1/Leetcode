/*
 * Problem: 844. Backspace String Compare
 *
 * Given:
 * - Two strings:
 *      s
 *      t
 *
 * Special Character:
 *      '#'
 *
 * Meaning:
 *      '#' = backspace
 *
 * Task:
 * - Return true if both strings become equal
 *   after applying backspace operations.
 *
 * -------------------------------------------------------
 * Example:
 *
 * Input:
 * s = "ab#c"
 * t = "ad#c"
 *
 * Process:
 *
 * s:
 * "ab#c"
 * → "ac"
 *
 * t:
 * "ad#c"
 * → "ac"
 *
 * Output:
 * true
 *
 * -------------------------------------------------------
 * Core Idea:
 *
 * Use Stack to simulate typing.
 *
 * Why Stack?
 *
 * Because:
 *      '#' removes last typed character
 *
 * This is exactly:
 *      LIFO behavior
 *
 * -------------------------------------------------------
 * Strategy:
 *
 * Build final string for both:
 *
 * For each character:
 *
 *      If '#':
 *          pop last character (if exists)
 *
 *      Else:
 *          push character
 *
 * After processing both strings:
 *
 *      Compare stacks
 *
 * -------------------------------------------------------
 * Algorithm:
 *
 * 1. Create two stacks:
 *      st1 for s
 *      st2 for t
 *
 * 2. Traverse s:
 *
 *      If '#':
 *          pop if stack not empty
 *
 *      Else:
 *          push character
 *
 * 3. Traverse t similarly
 *
 * 4. Compare sizes
 *
 * 5. Compare stack contents
 *
 * -------------------------------------------------------
 * Example:
 *
 * s = "a##c"
 *
 * Process:
 *
 * a → push
 * # → pop
 * # → ignore
 * c → push
 *
 * Final:
 * [c]
 *
 * -------------------------------------------------------
 * Time Complexity:
 * O(n + m)
 *
 * Space Complexity:
 * O(n + m)
 *
 * Pattern:
 * Stack Simulation + String Processing
 */

import java.util.Stack;

class Solution {

    public boolean backspaceCompare(String s, String t) {

        Stack<Character> st1 = new Stack<>();
        Stack<Character> st2 = new Stack<>();

        // Process first string
        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (ch == '#') {

                if (!st1.isEmpty()) {
                    st1.pop();
                }
            }

            else {
                st1.push(ch);
            }
        }

        // Process second string
        for (int i = 0; i < t.length(); i++) {

            char ch = t.charAt(i);

            if (ch == '#') {

                if (!st2.isEmpty()) {
                    st2.pop();
                }
            }

            else {
                st2.push(ch);
            }
        }

        // Sizes must match
        if (st1.size() != st2.size()) {
            return false;
        }

        // Compare character by character
        while (!st1.isEmpty() && !st2.isEmpty()) {

            if (st1.peek() != st2.peek()) {
                return false;
            }

            st1.pop();
            st2.pop();
        }

        return true;
    }
}
