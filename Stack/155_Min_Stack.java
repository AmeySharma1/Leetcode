/* 
 * Problem: 155. Min Stack
 *
 * Design a stack that supports:
 *
 *      push(val)
 *      pop()
 *      top()
 *      getMin()
 *
 * All operations must run in O(1) time.
 *
 * -------------------------------------------------------
 * Core Idea:
 *
 * We use TWO stacks:
 *
 * 1️⃣ st   → Normal stack (stores all values)
 * 2️⃣ min  → Keeps track of minimum values
 *
 * Logic:
 *
 * push(val):
 *      Push into st
 *      If min is empty OR val <= currentMin
 *          Push into min
 *
 * pop():
 *      If popped element == min.peek()
 *          Pop from min also
 *
 * top():
 *      Return st.peek()
 *
 * getMin():
 *      Return min.peek()
 *
 * -------------------------------------------------------
 * Why Two Stacks?
 *
 * Because:
 * - We must get minimum in O(1)
 * - If we scan whole stack → O(n)
 * - Instead, maintain minimum history
 *
 * Example:
 *
 * push(5)  → min: [5]
 * push(3)  → min: [5, 3]
 * push(7)  → min: [5, 3]
 *
 * pop() removes 7 → min unchanged
 * pop() removes 3 → min also pops 3
 *
 * -------------------------------------------------------
 * Important Fixes in Your Code:
 *
 * ❌ Stack<nteger> → Typo
 * ❌ .top() does not exist in Java Stack
 *      Use .peek()
 * ❌ popi declared inside if → scope issue
 * ❌ Need <= instead of < for duplicate mins
 *
 * -------------------------------------------------------
 * Time Complexity:
 * push  → O(1)
 * pop   → O(1)
 * top   → O(1)
 * getMin→ O(1)
 *
 * Space Complexity:
 * O(n)
 *
 * Pattern:
 * Stack + Auxiliary Stack for Tracking Minimum
 */

import java.util.Stack;

class MinStack {

    Stack<Integer> st;
    Stack<Integer> min;

    public MinStack() {
        st = new Stack<>();
        min = new Stack<>();
    }
    
    public void push(int val) {

        st.push(val);

        // If new value is smaller or equal, push to min stack
        if (min.isEmpty() || val <= min.peek()) {
            min.push(val);
        }
    }
    
    public void pop() {

        if (!st.isEmpty()) {

            int popped = st.pop();

            // If popped element is current minimum
            if (!min.isEmpty() && popped == min.peek()) {
                min.pop();
            }
        }
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return min.peek();
    }
}
