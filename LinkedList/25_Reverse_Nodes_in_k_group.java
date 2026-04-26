/*
 * Problem: 25. Reverse Nodes in k-Group
 *
 * Given:
 * - Head of linked list
 * - Integer k
 *
 * Task:
 * - Reverse every group of k nodes
 * - Remaining nodes (< k) should remain unchanged
 *
 * -------------------------------------------------------
 * Example:
 *
 * Input:
 * 1 → 2 → 3 → 4 → 5
 * k = 2
 *
 * Output:
 * 2 → 1 → 4 → 3 → 5
 *
 * -------------------------------------------------------
 * Core Idea:
 *
 * - Reverse linked list in chunks/groups of size k
 * - Use recursion to solve remaining list
 *
 * -------------------------------------------------------
 * Key Observation:
 *
 * Before reversing:
 * - Must confirm k nodes exist
 *
 * If less than k nodes remain:
 * - Return as it is
 *
 * -------------------------------------------------------
 * Recursive Strategy:
 *
 * 1. Check if k nodes available
 *
 * 2. Recursively reverse remaining list
 *
 * 3. Reverse current k nodes
 *
 * 4. Attach reversed group to recursive result
 *
 * -------------------------------------------------------
 * Algorithm:
 *
 * 1. Count k nodes
 *
 * 2. If fewer than k nodes:
 *      return head
 *
 * 3. Reverse remaining list recursively:
 *      prevNode = reverseKGroup(temp, k)
 *
 * 4. Reverse current group:
 *      Connect nodes one by one
 *
 * 5. Return new head of reversed group
 *
 * -------------------------------------------------------
 * Dry Run:
 *
 * Input:
 * 1 → 2 → 3 → 4 → 5
 * k = 2
 *
 * Step 1:
 * Reverse [1,2]
 *
 * Remaining:
 * 3 → 4 → 5
 *
 * Step 2:
 * Reverse [3,4]
 *
 * Remaining:
 * 5
 *
 * Final:
 * 2 → 1 → 4 → 3 → 5
 *
 * -------------------------------------------------------
 * Recursive Flow:
 *
 * reverseKGroup(1,2)
 *     reverseKGroup(3,2)
 *         reverseKGroup(5,2)
 *             return 5
 *
 * Reverse 3,4
 * Reverse 1,2
 *
 * -------------------------------------------------------
 * Why It Works:
 *
 * - Recursion handles future groups first
 * - Current group reversal becomes easy
 * - Proper linking preserved automatically
 *
 * -------------------------------------------------------
 * Time Complexity:
 * O(n)
 *
 * Space Complexity:
 * O(n/k)
 * (Recursive stack)
 *
 * -------------------------------------------------------
 * Pattern:
 * Linked List + Recursion + Reverse in Chunks
 */

class Solution {

    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode temp = head;
        int cnt = 0;

        // Step 1: Check if k nodes exist
        while (cnt < k) {

            if (temp == null) {
                return head;
            }

            temp = temp.next;
            cnt++;
        }

        // Step 2: Reverse remaining list recursively
        ListNode prevNode = reverseKGroup(temp, k);

        // Step 3: Reverse current k nodes
        temp = head;
        cnt = 0;

        while (cnt < k) {

            ListNode next = temp.next;

            temp.next = prevNode;
            prevNode = temp;

            temp = next;
            cnt++;
        }

        return prevNode;
    }
}
