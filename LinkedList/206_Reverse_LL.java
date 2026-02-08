/*
 * Problem: 206. Reverse Linked List
 *
 * Idea:
 * - Linked list ko reverse karna hai
 * - Sirf pointers change karne hain
 * - New nodes create nahi karne
 *
 * ----------------------------------------------------
 * Key Concept:
 *
 * - Pointer reversal
 * - Current node ka next pointer pichhe wale node ko point karega
 *
 * ----------------------------------------------------
 * Approach: Iterative Pointer Reversal
 *
 * - Teen pointers use karte hain:
 *      prev → previous node
 *      curr → current node
 *      next_node → next node ko temporarily store karne ke liye
 *
 * ----------------------------------------------------
 * Algorithm:
 *
 * 1. Edge Case:
 *      - Agar head == null ya head.next == null
 *        → return head
 *
 * 2. Initialize:
 *      curr = head
 *      prev = null
 *
 * 3. Traverse while:
 *      curr != null
 *
 * 4. Reverse pointers:
 *      next_node = curr.next
 *      curr.next = prev
 *
 * 5. Move forward:
 *      prev = curr
 *      curr = next_node
 *
 * 6. Return:
 *      prev (new head)
 *
 * ----------------------------------------------------
 * Dry Run:
 *
 * List: 1 → 2 → 3 → 4
 *
 * Iteration 1:
 * curr = 1, prev = null
 * 1.next = null
 *
 * Iteration 2:
 * curr = 2, prev = 1
 * 2.next = 1
 *
 * Iteration 3:
 * curr = 3, prev = 2
 * 3.next = 2
 *
 * Iteration 4:
 * curr = 4, prev = 3
 * 4.next = 3
 *
 * Result:
 * 4 → 3 → 2 → 1
 *
 * ----------------------------------------------------
 * Why It Works:
 *
 * - Har node ka direction ek-ek karke reverse hota hai
 * - next_node temporary store hone ki wajah se list break nahi hoti
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
 * Linked List + Pointer Manipulation
 */

class Solution {
    public ListNode reverseList(ListNode head) {

        // iterative
        if (head == null || head.next == null) {
            return head;
        }

        ListNode curr = head;
        ListNode prev = null;

        while (curr != null) {

            ListNode next_node = curr.next; // store next
            curr.next = prev;               // reverse link

            prev = curr;                    // move prev
            curr = next_node;               // move curr
        }

        return prev; // new head
    }
}
