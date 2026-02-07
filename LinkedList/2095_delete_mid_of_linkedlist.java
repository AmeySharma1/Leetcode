/*
 * Problem: 2095. Delete the Middle Node of a Linked List
 *
 * Idea:
 * - Linked list ka middle node delete karna hai
 * - Agar list me sirf 1 node ho → null return karna hai
 *
 * ----------------------------------------------------
 * Key Concept:
 *
 * - Two Pointer Technique (Slow & Fast)
 * - Ek extra pointer (prev) rakhenge
 *   jo slow se ek step pichhe rahega
 *
 * ----------------------------------------------------
 * Approach: Slow, Fast & Previous Pointer
 *
 * - Slow pointer middle node tak pahunchta hai
 * - Fast pointer end tak pahunchta hai
 * - Prev pointer middle se pehle wale node ko track karta hai
 *
 * ----------------------------------------------------
 * Algorithm:
 *
 * 1. Edge Case:
 *      - Agar head == null ya head.next == null
 *        → return null
 *
 * 2. Initialize:
 *      slow = head
 *      fast = head
 *      prev = null
 *
 * 3. Traverse while:
 *      fast != null AND fast.next != null
 *
 * 4. Move pointers:
 *      prev = slow
 *      slow = slow.next        (1 step)
 *      fast = fast.next.next  (2 steps)
 *
 * 5. Delete middle node:
 *      prev.next = slow.next
 *      slow.next = null
 *
 * 6. Return:
 *      head
 *
 * ----------------------------------------------------
 * Dry Run:
 *
 * Case 1: Odd length
 * List: 1 → 2 → 3 → 4 → 5
 *
 * Iteration 1:
 * prev = 1, slow = 2, fast = 3
 *
 * Iteration 2:
 * prev = 2, slow = 3, fast = 5
 *
 * fast.next == null → stop
 *
 * Delete:
 * 2.next = 4
 *
 * Result:
 * 1 → 2 → 4 → 5
 *
 * ------------------
 *
 * Case 2: Even length
 * List: 1 → 2 → 3 → 4 → 5 → 6
 *
 * Iteration 1:
 * prev = 1, slow = 2, fast = 3
 *
 * Iteration 2:
 * prev = 2, slow = 3, fast = 5
 *
 * Iteration 3:
 * prev = 3, slow = 4, fast = null → stop
 *
 * Delete:
 * 3.next = 5
 *
 * Result:
 * 1 → 2 → 3 → 5 → 6
 *
 * ----------------------------------------------------
 * Why It Works:
 *
 * - Fast pointer 2x speed se move karta hai
 * - Slow pointer middle node pe pahunch jata hai
 * - Prev pointer ke through safely middle delete hota hai
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
    public ListNode deleteMiddle(ListNode head) {

        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // delete middle node
        prev.next = slow.next;
        slow.next = null;

        return head;
    }
}
