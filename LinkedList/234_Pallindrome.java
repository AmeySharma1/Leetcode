/*
 * Problem: 234. Palindrome Linked List
 *
 * Idea:
 * - Check karna hai ki linked list palindrome hai ya nahi
 * - Palindrome → left se aur right se same read hoti hai
 *
 * ----------------------------------------------------
 * Key Concept:
 *
 * - Two Pointer Technique (Slow & Fast)
 * - Linked List reversal
 * - Half-by-half comparison
 *
 * ----------------------------------------------------
 * Approach: Find Middle + Reverse Second Half + Compare
 *
 * - Pehle linked list ka middle nikalte hain
 * - Second half ko reverse karte hain
 * - First half aur reversed second half ko compare karte hain
 *
 * ----------------------------------------------------
 * Algorithm:
 *
 * 1. Edge Case:
 *      - Agar head == null ya head.next == null
 *        → return true
 *
 * 2. Find middle:
 *      slow = head
 *      fast = head
 *
 *      while fast != null AND fast.next != null:
 *          slow = slow.next
 *          fast = fast.next.next
 *
 * 3. Reverse second half:
 *      secondHalf = reverse(slow)
 *
 * 4. Compare both halves:
 *      firstHalf = head
 *
 *      while secondHalf != null:
 *          if firstHalf.val != secondHalf.val:
 *              return false
 *          firstHalf = firstHalf.next
 *          secondHalf = secondHalf.next
 *
 * 5. If all nodes matched:
 *      return true
 *
 * ----------------------------------------------------
 * Dry Run:
 *
 * List: 1 → 2 → 2 → 1
 *
 * Step 1 (Find Middle):
 * slow = 2 (3rd node)
 *
 * Step 2 (Reverse second half):
 * secondHalf = 1 → 2
 *
 * Step 3 (Compare):
 * 1 == 1 ✔
 * 2 == 2 ✔
 *
 * Output:
 * true
 *
 * ----------------------------------------------------
 * Why It Works:
 *
 * - Fast pointer 2x speed se move karta hai
 * - Slow pointer middle pe pahunch jata hai
 * - Second half reverse karke direct comparison possible hota hai
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
 * Linked List + Two Pointer + Reverse
 */

class Solution {

    // reverse linked list
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

    public boolean isPalindrome(ListNode head) {

        if (head == null || head.next == null) {
            return true;
        }

        // step 1: find middle
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // step 2: reverse second half
        ListNode secondHalf = reverse(slow);
        ListNode firstHalf = head;

        // step 3: compare both halves
        while (secondHalf != null) {

            if (firstHalf.val != secondHalf.val) {
                return false;
            }

            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        return true;
    }
}
