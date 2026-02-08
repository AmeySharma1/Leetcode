/*
 * Problem: 328. Odd Even Linked List
 *
 * Idea:
 * - Linked list ke nodes ko unke position ke basis pe rearrange karna hai
 * - Odd position wale nodes pehle aayenge
 * - Even position wale nodes baad me
 * - Node values change nahi karni
 *
 * ----------------------------------------------------
 * Key Concept:
 *
 * - Pointer rearrangement
 * - Do separate chains maintain karna (odd & even)
 *
 * ----------------------------------------------------
 * Approach: Two Pointer Chains (Odd & Even)
 *
 * - Odd pointer odd-position nodes ko track karta hai
 * - Even pointer even-position nodes ko track karta hai
 * - End me even list ko odd list ke end se connect kar dete hain
 *
 * ----------------------------------------------------
 * Algorithm:
 *
 * 1. Edge Case:
 *      - Agar head == null ya head.next == null
 *        → return head
 *
 * 2. Initialize:
 *      odd = head
 *      even = head.next
 *      evenHead = even   (even list ka starting point)
 *
 * 3. Traverse while:
 *      even != null AND even.next != null
 *
 * 4. Rearrange pointers:
 *      odd.next = even.next
 *      odd = odd.next
 *
 *      even.next = odd.next
 *      even = even.next
 *
 * 5. Attach even list at end of odd list:
 *      odd.next = evenHead
 *
 * 6. Return:
 *      head
 *
 * ----------------------------------------------------
 * Dry Run:
 *
 * List: 1 → 2 → 3 → 4 → 5
 *
 * Initial:
 * odd = 1
 * even = 2
 *
 * Iteration 1:
 * odd.next = 3
 * even.next = 4
 *
 * Odd List: 1 → 3
 * Even List: 2 → 4
 *
 * Iteration 2:
 * odd.next = 5
 * even.next = null
 *
 * Odd List: 1 → 3 → 5
 * Even List: 2 → 4
 *
 * Final Merge:
 * 1 → 3 → 5 → 2 → 4
 *
 * ----------------------------------------------------
 * Why It Works:
 *
 * - Odd aur even nodes ke beech relative order maintain rehta hai
 * - Sirf pointers change hote hain, nodes nahi
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
 * Linked List + Pointer Rearrangement
 */

class Solution {
    public ListNode oddEvenList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;

        while (even != null && even.next != null) {

            odd.next = even.next;
            odd = odd.next;

            even.next = odd.next;
            even = even.next;
        }

        // attach even list after odd list
        odd.next = evenHead;

        return head;
    }
}
