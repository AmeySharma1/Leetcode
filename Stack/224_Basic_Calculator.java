/*
 * Problem: 224. Basic Calculator
 *
 * Given:
 * - String s representing a valid expression
 *
 * Contains:
 *      digits
 *      '+'
 *      '-'
 *      '('
 *      ')'
 *      spaces
 *
 * Task:
 * - Evaluate expression
 * - Return result as integer
 *
 * -------------------------------------------------------
 * Important:
 *
 * - No * or /
 * - Only + and -
 * - Parentheses allowed
 * - Numbers may have multiple digits
 *
 * -------------------------------------------------------
 * Core Idea:
 *
 * Maintain:
 *      res   → current calculated result
 *      curr  → current number being built
 *      sign  → +1 or -1
 *
 * Use Stack to store:
 *      Previous result
 *      Previous sign
 *
 * Why?
 * Because when '(' appears,
 * we must save outer context.
 *
 * -------------------------------------------------------
 * When we see:
 *
 * Digit:
 *      Build number
 *
 * '+':
 *      Add previous number using sign
 *      Reset curr
 *      sign = +1
 *
 * '-':
 *      Add previous number using sign
 *      Reset curr
 *      sign = -1
 *
 * '(':
 *      Push current res
 *      Push current sign
 *      Reset res, sign, curr
 *
 * ')':
 *      Finalize current number
 *      Multiply result with sign from stack
 *      Add previous result from stack
 *
 * -------------------------------------------------------
 * Example:
 *
 * Input:
 * "1 + (2 - 3)"
 *
 * Process:
 *
 * 1 → curr=1
 * + → res=1
 * (
 * 2 → curr=2
 * - → res=2
 * 3 → curr=3
 * ) → res = 2-3 = -1
 *      res = previous_res + previous_sign * (-1)
 *
 * Output:
 * 0
 *
 * -------------------------------------------------------
 * Algorithm:
 *
 * 1. Initialize:
 *      stack
 *      res = 0
 *      curr = 0
 *      sign = 1
 *
 * 2. Traverse string:
 *
 *      If digit:
 *          build number
 *
 *      If '+' or '-':
 *          res += sign * curr
 *          update sign
 *          reset curr
 *
 *      If '(':
 *          push res
 *          push sign
 *          reset res, sign
 *
 *      If ')':
 *          res += sign * curr
 *          res *= stack.pop()   // sign
 *          res += stack.pop()   // previous result
 *
 * 3. After loop:
 *      res += sign * curr
 *
 * 4. Return res
 *
 * -------------------------------------------------------
 * Time Complexity:
 * O(n)
 *
 * Space Complexity:
 * O(n)
 *
 * Pattern:
 * Stack + Expression Evaluation + Parenthesis Handling
 */

import java.util.Stack;

class Solution {

    public int calculate(String s) {

        Stack<Integer> stack = new Stack<>();

        int res = 0;
        int curr = 0;
        int sign = 1;

        for (char c : s.toCharArray()) {

            if (Character.isDigit(c)) {
                curr = curr * 10 + (c - '0');
            }

            else if (c == '+') {
                res += curr * sign;
                sign = 1;
                curr = 0;
            }

            else if (c == '-') {
                res += curr * sign;
                sign = -1;
                curr = 0;
            }

            else if (c == '(') {
                stack.push(res);
                stack.push(sign);
                res = 0;
                sign = 1;
                curr = 0;
            }

            else if (c == ')') {
                res += curr * sign;
                curr = 0;

                res *= stack.pop();   // sign
                res += stack.pop();   // previous result
            }
        }

        res += sign * curr;   // this is important for handling case if string ends with a number instead of ')'
        return res;
    }
}
