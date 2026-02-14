/* 
 * Problem: 150. Evaluate Reverse Polish Notation
 *
 * Given:
 * - String[] tokens representing an expression in Reverse Polish Notation (RPN)
 *
 * Task:
 * - Evaluate the expression
 * - Return the result as integer
 *
 * Valid operators:
 *      "+", "-", "*", "/"
 *
 * Important:
 * - Division truncates toward zero.
 *
 * -------------------------------------------------------
 * What is Reverse Polish Notation (Postfix)?
 *
 * Infix:      2 + 3
 * Postfix:    2 3 +
 *
 * Infix:      (2 + 3) * 4
 * Postfix:    2 3 + 4 *
 *
 * Rule:
 * - Operator comes AFTER operands.
 *
 * -------------------------------------------------------
 * Core Idea:
 *
 * Use Stack because:
 * - Whenever we see a number → push
 * - Whenever we see an operator:
 *      Pop last two numbers
 *      Apply operation
 *      Push result back
 *
 * LIFO ensures correct operand order.
 *
 * -------------------------------------------------------
 * Very Important:
 *
 * Order matters for:
 *      subtraction
 *      division
 *
 * If stack contains:
 *      [a, b]
 *
 * And we see operator:
 *      First pop → b
 *      Second pop → a
 *
 * Operation must be:
 *      a op b
 *
 * NOT:
 *      b op a
 *
 * -------------------------------------------------------
 * Example:
 *
 * Input:
 * ["2","1","+","3","*"]
 *
 * Process:
 *
 * 2 → push [2]
 * 1 → push [2,1]
 * + → pop 1, pop 2 → 2+1=3 → push [3]
 * 3 → push [3,3]
 * * → pop 3, pop 3 → 3*3=9 → push [9]
 *
 * Output: 9
 *
 * -------------------------------------------------------
 * Algorithm:
 *
 * 1. Create empty stack
 *
 * 2. Traverse tokens:
 *
 *      If operator:
 *          b = pop()
 *          a = pop()
 *          push(a op b)
 *
 *      Else:
 *          push(Integer.parseInt(token))
 *
 * 3. Return stack.peek()
 *
 * -------------------------------------------------------
 * Time Complexity:
 * O(n)
 *
 * Space Complexity:
 * O(n)
 *
 * Pattern:
 * Stack + Expression Evaluation
 */

import java.util.Stack;

class Solution {
    public int evalRPN(String[] arr) {

        Stack<Integer> st = new Stack<>();

        for (String s : arr) {

            // Operator cases
            if (s.equals("+")) {

                int b = st.pop();
                int a = st.pop();
                st.push(a + b);
            }

            else if (s.equals("-")) {

                int b = st.pop();
                int a = st.pop();
                st.push(a - b);
            }

            else if (s.equals("*")) {

                int b = st.pop();
                int a = st.pop();
                st.push(a * b);
            }

            else if (s.equals("/")) {

                int b = st.pop();
                int a = st.pop();
                st.push(a / b);  // truncates toward zero
            }

            // Number case
            else {
                st.push(Integer.parseInt(s));
            }
        }

        return st.peek();
    }
}
