/*
 * Problem: 61. Rotate List
 *
 * Given:
 * - Head of a linked list
 * - Integer k
 *
 * Task:
 * - Rotate list to the right by k places
 *
 * Example:
 * Input: 1 → 2 → 3 → 4 → 5 , k = 2
 * Output: 4 → 5 → 1 → 2 → 3
 *
 * -------------------------------------------------------
 * Core Idea:
 *
 * 1. Find length of list
 * 2. Reduce k using modulo (k = k % length)
 * 3. Find new tail (length - k - 1)
 * 4. Break list at that point
 * 5. Connect old tail to old head
 *
 * -------------------------------------------------------
 * Algorithm:
 *
 * 1. Edge case:
 *      if head == null or single node → return head
 *
 * 2. Find size of list
 *
 * 3. k = k % size
 *      If k == 0 → return head
 *
 * 4. Move pointer to:
 *      size - k - 1  (new tail)
 *
 * 5. newHead = newTail.next
 *    Break connection:
 *      newTail.next = null
 *
 * 6. Traverse to end of newHead
 *    Connect last node to old head
 *
 * 7. Return newHead
 *
 * -------------------------------------------------------
 * Time Complexity:
 * O(n)
 *
 * Space Complexity:
 * O(1)
 *
 * Pattern:
 * Linked List + Length Calculation + Pointer Manipulation
 */

class Solution {
    public ListNode rotateRight(ListNode head, int k) {

        if (head == null || head.next == null) 
            return head;

        // Step 1: Find size
        ListNode temp = head;
        int size = 0;

        while (temp != null) {
            size++;
            temp = temp.next;
        }

        // Step 2: Reduce k
        k = k % size;
        if (k == 0) return head;

        // Step 3: Find new tail
        ListNode prev = head;
        for (int i = 0; i < size - k - 1; i++) {
            prev = prev.next;
        }

        // Step 4: Break and reconnect
        ListNode newHead = prev.next;
        prev.next = null;

        ListNode curr = newHead;
        while (curr.next != null) {
            curr = curr.next;
        }

        curr.next = head;

        return newHead;
    }
}
