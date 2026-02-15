/*
 * Problem: 946. Validate Stack Sequences
 *
 * Given:
 * - int[] pushed
 * - int[] popped
 *
 * Task:
 * - Return true if popped sequence is valid
 *   stack pop order of pushed sequence.
 *
 * -------------------------------------------------------
 * What is happening?
 *
 * We simulate the real stack process.
 *
 * We:
 *      Push elements from "pushed"
 *      Pop whenever top matches "popped"
 *
 * If we can match entire popped array,
 * then sequence is valid.
 *
 * -------------------------------------------------------
 * Core Idea:
 *
 * Use a stack to simulate operations.
 *
 * Maintain two pointers:
 *
 *      i → index for pushed
 *      j → index for popped
 *
 * -------------------------------------------------------
 * Algorithm:
 *
 * 1. Create empty stack
 *
 * 2. For each element in pushed:
 *
 *      Push pushed[i]
 *
 *      While:
 *          stack not empty
 *          AND stack.peek() == popped[j]
 *
 *          Pop from stack
 *          j++
 *
 * 3. After processing all pushes:
 *
 *      If stack empty → valid
 *      Else → invalid
 *
 * -------------------------------------------------------
 * Example:
 *
 * pushed = [1,2,3,4,5]
 * popped = [4,5,3,2,1]
 *
 * Process:
 *
 * push 1
 * push 2
 * push 3
 * push 4 → match → pop
 * push 5 → match → pop
 * match 3 → pop
 * match 2 → pop
 * match 1 → pop
 *
 * stack empty → true
 *
 * -------------------------------------------------------
 * Time Complexity:
 * O(n)
 *
 * Space Complexity:
 * O(n)
 *
 * Pattern:
 * Stack Simulation
 */

import java.util.Stack;

class Solution {

    public boolean validateStackSequences(int[] pushed, int[] popped) {

        Stack<Integer> st = new Stack<>();
        int j = 0;

        for (int i = 0; i < pushed.length; i++) {

            st.push(pushed[i]);

            while (!st.isEmpty() && j < popped.length
                    && st.peek() == popped[j]) {

                st.pop();
                j++;
            }
        }

        return st.isEmpty();
    }
}
