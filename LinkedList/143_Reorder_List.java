/*
 * Problem: 143. Reorder List
 *
 * Given:
 * - Singly linked list
 *
 * Task:
 * - Reorder list in pattern:
 *
 *      L0 → Ln → L1 → Ln-1 → L2 → Ln-2 ...
 *
 * - Do NOT change node values
 * - Only change node links
 *
 * -------------------------------------------------------
 * Example:
 *
 * Input:
 * 1 → 2 → 3 → 4 → 5
 *
 * Output:
 * 1 → 5 → 2 → 4 → 3
 *
 * -------------------------------------------------------
 * Core Idea:
 *
 * Reordering can be divided into 3 steps:
 *
 * 1. Find middle of linked list
 * 2. Reverse second half
 * 3. Merge alternate nodes
 *
 * -------------------------------------------------------
 * Step 1: Find Middle
 *
 * Use Slow + Fast pointer
 *
 * - Slow moves 1 step
 * - Fast moves 2 steps
 *
 * Slow reaches middle
 *
 * -------------------------------------------------------
 * Step 2: Reverse Second Half
 *
 * Example:
 *
 * Before:
 * 1 → 2 → 3 → 4 → 5
 *
 * Middle = 3
 *
 * Second Half:
 * 4 → 5
 *
 * Reverse:
 * 5 → 4
 *
 * -------------------------------------------------------
 * Step 3: Merge Alternately
 *
 * First Half:
 * 1 → 2 → 3
 *
 * Second Half:
 * 5 → 4
 *
 * Merge:
 *
 * 1 → 5 → 2 → 4 → 3
 *
 * -------------------------------------------------------
 * Algorithm:
 *
 * 1. Find middle node
 *
 * 2. Reverse second half
 *
 * 3. Disconnect first half:
 *      slow.next = null
 *
 * 4. Merge:
 *      first → second → first → second
 *
 * -------------------------------------------------------
 * Dry Run:
 *
 * Input:
 * 1 → 2 → 3 → 4
 *
 * Middle:
 * 2
 *
 * Reverse second:
 * 4 → 3
 *
 * Merge:
 *
 * 1 → 4 → 2 → 3
 *
 * -------------------------------------------------------
 * Why It Works:
 *
 * - Middle splits list equally
 * - Reverse allows tail access in O(1)
 * - Alternate merge creates required order
 *
 * -------------------------------------------------------
 * Time Complexity:
 * O(n)
 *
 * Space Complexity:
 * O(1)
 *
 * -------------------------------------------------------
 * Pattern:
 * Linked List + Middle + Reverse + Merge
 */

class Solution {

    public void reorderList(ListNode head) {

        if (head == null || head.next == null) {
            return;
        }

        // Step 1: Find middle
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse second half
        ListNode secondHalf = reverse(slow.next);

        // Break connection
        slow.next = null;

        // Step 3: Merge both halves
        ListNode firstHalf = head;

        while (secondHalf != null) {

            ListNode temp1 = firstHalf.next;
            ListNode temp2 = secondHalf.next;

            firstHalf.next = secondHalf;
            secondHalf.next = temp1;

            firstHalf = temp1;
            secondHalf = temp2;
        }
    }

    // Reverse Linked List Function
    public ListNode reverse(ListNode head) {

        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {

            ListNode nextNode = curr.next;

            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }

        return prev;
    }
}
