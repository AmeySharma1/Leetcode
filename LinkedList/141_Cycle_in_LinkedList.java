/*
 * Problem: 141. Linked List Cycle
 *
 * Idea:
 * - Check karna hai ki linked list me cycle hai ya nahi
 * - Cycle ka matlab:
 *      koi node dobara kisi previous node ko point kar rahi ho
 *
 * ----------------------------------------------------
 * Key Concept:
 *
 * - Floyd’s Cycle Detection Algorithm
 * - Also known as Tortoise and Hare algorithm
 *
 * ----------------------------------------------------
 * Approach: Slow & Fast Pointer
 *
 * - Slow pointer 1 step move karta hai
 * - Fast pointer 2 steps move karta hai
 * - Agar cycle hai, to dono pointers kabhi na kabhi milenge
 *
 * ----------------------------------------------------
 * Algorithm:
 *
 * 1. Edge Case:
 *      - Agar head == null ya head.next == null
 *        → return false
 *
 * 2. Initialize:
 *      slow = head
 *      fast = head
 *
 * 3. Traverse while:
 *      fast != null AND fast.next != null
 *
 * 4. Move pointers:
 *      slow = slow.next
 *      fast = fast.next.next
 *
 * 5. Check:
 *      - Agar slow == fast:
 *            cycle detected → return true
 *
 * 6. Loop ends:
 *      - Agar fast null ho jaye
 *        → cycle nahi hai
 *
 * 7. Return:
 *      false
 *
 * ----------------------------------------------------
 * Dry Run:
 *
 * List: 3 → 2 → 0 → -4
 *            ↑       |
 *            └───────┘
 *
 * Iteration 1:
 * slow = 2, fast = 0
 *
 * Iteration 2:
 * slow = 0, fast = 2
 *
 * Iteration 3:
 * slow = -4, fast = -4  → meet
 *
 * Output:
 * true
 *
 * ----------------------------------------------------
 * Why It Works:
 *
 * - Fast pointer slow se zyada speed se move karta hai
 * - Cycle hone par fast kabhi na kabhi slow ko pakad leta hai
 * - Agar cycle nahi hoti, fast null pe pahunch jata hai
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
 * Linked List + Two Pointer (Cycle Detection)
 */

public class Solution {
    public boolean hasCycle(ListNode head) {

        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }
}
