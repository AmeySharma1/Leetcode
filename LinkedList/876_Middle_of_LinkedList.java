/*
 * Problem: 876. Middle of the Linked List
 *
 * Idea:
 * - Linked list ka middle node find karna hai
 * - Agar even number of nodes hain:
 *      → second middle return karna hai (as per problem statement)
 *
 * ----------------------------------------------------
 * Key Concept:
 *
 * - Two Pointer Technique (Slow & Fast Pointer)
 * - Slow pointer ek step move karta hai
 * - Fast pointer do steps move karta hai
 *
 * ----------------------------------------------------
 * Approach: Slow and Fast Pointer
 *
 * - Dono pointers ko head se start karte hain
 * - Jab fast list ke end tak pahunch jata hai,
 *   tab slow pointer middle pe hota hai
 *
 * ----------------------------------------------------
 * Algorithm:
 *
 * 1. Initialize:
 *      slow = head
 *      fast = head
 *
 * 2. Traverse while:
 *      fast != null AND fast.next != null
 *
 * 3. Move pointers:
 *      slow = slow.next        (1 step)
 *      fast = fast.next.next  (2 steps)
 *
 * 4. Loop ends when:
 *      - fast null ho jata hai (even length)
 *      - ya fast.next null ho jata hai (odd length)
 *
 * 5. Return:
 *      slow → middle node
 *
 * ----------------------------------------------------
 * Dry Run:
 *
 * Case 1: Odd length
 * List: 1 → 2 → 3 → 4 → 5
 *
 * Iteration 1:
 * slow = 2, fast = 3
 *
 * Iteration 2:
 * slow = 3, fast = 5
 *
 * Iteration 3:
 * fast.next == null → stop
 *
 * Output:
 * 3 (middle node)
 *
 * ------------------
 *
 * Case 2: Even length
 * List: 1 → 2 → 3 → 4 → 5 → 6
 *
 * Iteration 1:
 * slow = 2, fast = 3
 *
 * Iteration 2:
 * slow = 3, fast = 5
 *
 * Iteration 3:
 * slow = 4, fast = null → stop
 *
 * Output:
 * 4 (second middle)
 *
 * ----------------------------------------------------
 * Why While Condition is:
 * fast != null && fast.next != null
 *
 * - fast.next ko access karne se pehle
 *   fast null check zaroori hai
 * - Otherwise NullPointerException aa jayega
 *
 * ----------------------------------------------------
 * Why It Works:
 *
 * - Fast pointer 2x speed se move karta hai
 * - Jab fast end pe hota hai,
 *   slow exactly half distance cover kar chuka hota hai
 *
 * ----------------------------------------------------
 * Time Complexity:
 * O(n)
 *
 * Space Complexity:
 * O(1)
 *
 * ----------------------------------------------------
 * Pattern:
 * Linked List + Two Pointer Technique
 */

class Solution {
    public ListNode middleNode(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;          // 1 step
            fast = fast.next.next;    // 2 steps
        }

        return slow;
    }
}
