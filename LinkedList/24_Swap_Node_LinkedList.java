/*
 * Problem: 24. Swap Nodes in Pairs
 *
 * Idea:
 * - Linked list ke har 2 adjacent nodes ko swap karna hai
 * - Node ke values change nahi karni
 * - Sirf pointers manipulate karne hain
 *
 * ----------------------------------------------------
 * Key Concept:
 *
 * - Pointer manipulation in Singly Linked List
 * - Pair-wise swapping (2 nodes at a time)
 *
 * ----------------------------------------------------
 * Approach: Iterative Pointer Swapping
 *
 * - Har iteration me 2 nodes (first & second) ko swap karte hain
 * - Prev pointer previous swapped pair ko current pair se connect karta hai
 *
 * ----------------------------------------------------
 * Algorithm:
 *
 * 1. Edge Case:
 *      - Agar head == null ya head.next == null
 *        → return head
 *
 * 2. Initialize:
 *      first = head
 *      prev = null
 *
 * 3. Traverse while:
 *      first != null AND first.next != null
 *
 * 4. Identify pair:
 *      second = first.next
 *
 * 5. Swap pointers:
 *      first.next = second.next
 *      second.next = first
 *
 * 6. Fix previous connection:
 *      - Agar prev == null:
 *            head = second   (first swap)
 *      - Else:
 *            prev.next = second
 *
 * 7. Move pointers forward:
 *      prev = first
 *      first = first.next
 *
 * 8. Return:
 *      head
 *
 * ----------------------------------------------------
 * Dry Run:
 *
 * List: 1 → 2 → 3 → 4
 *
 * Iteration 1:
 * first = 1, second = 2
 *
 * Swap:
 * 1.next = 3
 * 2.next = 1
 *
 * head = 2
 *
 * List:
 * 2 → 1 → 3 → 4
 *
 * ------------------
 *
 * Iteration 2:
 * first = 3, second = 4
 *
 * Swap:
 * 3.next = null
 * 4.next = 3
 *
 * prev.next = 4
 *
 * List:
 * 2 → 1 → 4 → 3
 *
 * ----------------------------------------------------
 * Why It Works:
 *
 * - Har baar 2 nodes ka local swap hota hai
 * - Prev pointer previous pair ko next swapped pair se jod deta hai
 * - Pointer movement safe aur controlled rehta hai
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
 * Linked List + Pointer Manipulation
 */

class Solution {
    public ListNode swapPairs(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode first = head;
        ListNode prev = null;

        while (first != null && first.next != null) {

            ListNode second = first.next;

            // swap
            first.next = second.next;
            second.next = first;

            // connect previous pair
            if (prev == null) {
                head = second;
            } else {
                prev.next = second;
            }

            // move forward
            prev = first;
            first = first.next;
        }

        return head;
    }
}
