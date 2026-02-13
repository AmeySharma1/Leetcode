/* 
 * Problem: 225. Implement Stack using Queues
 *
 * Design a stack using only standard queue operations:
 *      add()      → insert at back
 *      remove()   → remove from front
 *      peek()
 *      isEmpty()
 *
 * -------------------------------------------------------
 * Core Idea:
 *
 * Stack → LIFO (Last In First Out)
 * Queue → FIFO (First In First Out)
 *
 * We must simulate LIFO using FIFO.
 *
 * Trick:
 * After pushing a new element,
 * rotate the queue so that the new element comes to the front.
 *
 * That way:
 * - The most recently added element is always at front
 * - So pop() becomes O(1)
 *
 * -------------------------------------------------------
 * How push Works:
 *
 * Suppose queue = [1, 2, 3]
 *
 * push(4):
 *      Step 1: add 4 → [1, 2, 3, 4]
 *      Step 2: rotate first 3 elements:
 *
 *          remove 1 → add back → [2,3,4,1]
 *          remove 2 → add back → [3,4,1,2]
 *          remove 3 → add back → [4,1,2,3]
 *
 * Final queue:
 *      [4,1,2,3]
 *
 * Now 4 is at front → behaves like stack top
 *
 * -------------------------------------------------------
 * Algorithm:
 *
 * push(x):
 *      q.add(x)
 *      rotate previous elements (size-1 times)
 *
 * pop():
 *      return q.remove()
 *
 * top():
 *      return q.peek()
 *
 * empty():
 *      return q.isEmpty()
 *
 * -------------------------------------------------------
 * Time Complexity:
 *
 * push  → O(n)   (rotation)
 * pop   → O(1)
 * top   → O(1)
 * empty → O(1)
 *
 * Space Complexity:
 * O(n)
 *
 * Pattern:
 * Queue Simulation + Rotation Trick
 */

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {

    private Queue<Integer> q;

    public MyStack() {
        q = new LinkedList<>();
    }

    public void push(int x) {

        // Step 1: Add new element
        q.add(x);

        // Step 2: Rotate previous elements
        for (int i = 1; i < q.size(); i++) {
            q.add(q.remove());
        }
    }

    public int pop() {
        return q.remove();
    }

    public int top() {
        return q.peek();
    }

    public boolean empty() {
        return q.isEmpty();
    }
}
