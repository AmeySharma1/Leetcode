/*
 * Problem: 21. Merge Two Sorted Lists
 *
 * Given:
 * - Two sorted linked lists list1 and list2
 *
 * Task:
 * - Merge them into one sorted linked list
 * - Return head of merged list
 *
 * ---------------------------------------------------
 * Core Idea:
 *
 * - Use Dummy Node technique
 * - Compare nodes one by one
 * - Attach smaller node to result list
 *
 * ---------------------------------------------------
 * Algorithm:
 *
 * 1. Create dummy node
 * 2. Maintain a pointer 'curr' for building result
 * 3. Compare list1 and list2:
 *      - Attach smaller node
 *      - Move that list pointer
 * 4. After loop:
 *      - Attach remaining nodes (if any)
 * 5. Return dummy.next
 *
 * ---------------------------------------------------
 * Why Dummy Node?
 *
 * - Avoid special case for head
 * - Cleaner implementation
 *
 * ---------------------------------------------------
 * Time Complexity:
 * O(n + m)
 *
 * Space Complexity:
 * O(1)
 *
 * Pattern:
 * Linked List + Dummy Node + Two Pointer
 */

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        ListNode temp1 = list1;
        ListNode temp2 = list2;

        // Compare both lists
        while (temp1 != null && temp2 != null) {

            if (temp1.val < temp2.val) {
                curr.next = temp1;
                temp1 = temp1.next;
            } else {
                curr.next = temp2;
                temp2 = temp2.next;
            }

            curr = curr.next;
        }

        // Attach remaining part
        if (temp1 != null) {
            curr.next = temp1;
        } else {
            curr.next = temp2;
        }

        return dummy.next;
    }
}
