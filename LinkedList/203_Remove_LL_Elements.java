/*
 * Problem: 203. Remove Linked List Elements
 *
 * Given:
 * - Head of linked list
 * - Integer x
 *
 * Task:
 * - Remove all nodes whose value == x
 * - Return updated linked list
 *
 * -------------------------------------------------------
 * Example:
 *
 * Input:
 * head = 1 → 2 → 6 → 3 → 4 → 5 → 6
 * x = 6
 *
 * Output:
 * 1 → 2 → 3 → 4 → 5
 *
 * -------------------------------------------------------
 * Core Idea:
 *
 * - Traverse linked list once
 * - Remove nodes having value == x
 *
 * - Since head itself may need deletion,
 *   use Dummy Node
 *
 * -------------------------------------------------------
 * Why Dummy Node?
 *
 * Example:
 * head = 7 → 7 → 7
 * x = 7
 *
 * Without dummy:
 * - Head deletion complicated ho jata hai
 *
 * Dummy simplifies:
 * - Always delete using prev.next
 *
 * -------------------------------------------------------
 * Algorithm:
 *
 * 1. Create dummy node:
 *      dummy.next = head
 *
 * 2. Initialize:
 *      prev = dummy
 *      curr = head
 *
 * 3. Traverse list:
 *
 *      If curr.val == x:
 *          remove node
 *          prev.next = curr.next
 *
 *      Else:
 *          move prev forward
 *
 *      Move curr forward
 *
 * 4. Return:
 *      dummy.next
 *
 * -------------------------------------------------------
 * Dry Run:
 *
 * Input:
 * 1 → 2 → 6 → 3 → 6
 * x = 6
 *
 * Step:
 * remove first 6
 * remove second 6
 *
 * Result:
 * 1 → 2 → 3
 *
 * -------------------------------------------------------
 * Why It Works:
 *
 * - prev tracks last valid node
 * - curr checks current node
 * - Removal done safely without losing list
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
 * Linked List + Dummy Node + Deletion
 */

class Solution {
    public ListNode removeElements(ListNode head, int x) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode curr = head;

        while (curr != null) {

            if (curr.val == x) {
                prev.next = curr.next;
            } 
            else {
                prev = curr;
            }

            curr = curr.next;
        }

        return dummy.next;
    }
}
