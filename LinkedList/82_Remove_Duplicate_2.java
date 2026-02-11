/*
 * Problem: 82. Remove Duplicates from Sorted List II
 *
 * Given:
 * - Sorted linked list
 *
 * Task:
 * - Remove ALL nodes that have duplicate numbers
 * - Only keep nodes that appear exactly once
 *
 * Example:
 * Input:  1 → 2 → 3 → 3 → 4 → 4 → 5
 * Output: 1 → 2 → 5
 *
 * -------------------------------------------------------
 * Core Idea:
 *
 * Since list is sorted:
 * - Duplicates will always appear consecutively
 *
 * Strategy:
 * - Use dummy node
 * - Maintain prev pointer:
 *      Points to last confirmed unique node
 *
 * - If duplicate sequence found:
 *      Skip entire sequence
 * - Else:
 *      Move prev forward
 *
 * -------------------------------------------------------
 * Why Dummy Node?
 *
 * - Handles edge case when head itself is duplicate
 *
 * -------------------------------------------------------
 * Algorithm:
 *
 * 1. Create dummy -> head
 * 2. prev = dummy
 *
 * 3. Traverse while head != null:
 *
 *      If duplicate found:
 *          Skip all nodes with same value
 *          prev.next = head.next
 *
 *      Else:
 *          Move prev forward
 *
 * 4. Move head forward
 *
 * 5. Return dummy.next
 *
 * -------------------------------------------------------
 * Time Complexity:
 * O(n)
 *
 * Space Complexity:
 * O(1)
 *
 * Pattern:
 * Linked List + Dummy Node + Skip Duplicate Block
 */

class Solution {
    public ListNode deleteDuplicates(ListNode head) {

        if (head == null) return null;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;

        while (head != null) {

            // Detect duplicate block
            if (head.next != null && head.val == head.next.val) {

                // Skip entire duplicate block
                while (head.next != null && head.val == head.next.val) {
                    head = head.next;
                }

                // Remove duplicates
                prev.next = head.next;
            } 
            else {
                // Valid unique node
                prev = prev.next;
            }

            head = head.next;
        }

        return dummy.next;
    }
}
