/*
 * Problem: 86. Partition List
 *
 * Given:
 * - Head of a linked list
 * - Integer x
 *
 * Task:
 * - Partition list such that:
 *      All nodes < x come before nodes >= x
 * - Maintain original relative order
 *
 * -------------------------------------------------------
 * Core Idea:
 *
 * - Use two dummy lists:
 *      1. small list  (values < x)
 *      2. big list    (values >= x)
 *
 * - Traverse original list once
 * - Attach nodes to respective lists
 * - Connect small list to big list
 *
 * -------------------------------------------------------
 * Why Dummy Nodes?
 *
 * - Avoid edge case handling for head
 * - Clean separation logic
 *
 * -------------------------------------------------------
 * Algorithm:
 *
 * 1. Create:
 *      smallDummy
 *      bigDummy
 *
 * 2. Maintain:
 *      small_ptr
 *      big_ptr
 *
 * 3. Traverse original list:
 *      if val < x:
 *          attach to small list
 *      else:
 *          attach to big list
 *
 * 4. Connect:
 *      small_ptr.next = bigDummy.next
 *
 * 5. Important:
 *      big_ptr.next = null
 *      (To avoid cycle)
 *
 * 6. Return:
 *      smallDummy.next
 *
 * -------------------------------------------------------
 * Time Complexity:
 * O(n)
 *
 * Space Complexity:
 * O(1)
 *
 * Pattern:
 * Linked List + Two Dummy Lists + Stable Partition
 */

class Solution {
    public ListNode partition(ListNode head, int x) {

        ListNode small = new ListNode(0);
        ListNode big = new ListNode(0);

        ListNode small_ptr = small;
        ListNode big_ptr = big;

        ListNode temp = head;

        while (temp != null) {

            if (temp.val < x) {
                small_ptr.next = temp;
                small_ptr = small_ptr.next;
            } else {
                big_ptr.next = temp;
                big_ptr = big_ptr.next;
            }

            temp = temp.next;
        }

        // Connect both lists
        small_ptr.next = big.next;

        // Very important to avoid cycle
        big_ptr.next = null;

        return small.next;
    }
}
