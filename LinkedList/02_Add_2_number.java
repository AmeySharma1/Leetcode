/*
 * Problem: 2. Add Two Numbers
 *
 * Idea:
 * - Do linked lists di hui hain jo numbers ko represent karti hain
 * - Digits reverse order me stored hain
 * - Dono numbers ka sum nikal kar ek nayi linked list return karni hai
 *
 * ----------------------------------------------------
 * Key Concept:
 *
 * - Digit by digit addition (jaise normal math addition)
 * - Carry ko track karna zaroori hai
 *
 * ----------------------------------------------------
 * Approach: Iterative Addition with Carry
 *
 * - Dummy node use karte hain result list ke liye
 * - Ek pointer result list build karta hai
 * - Jab tak l1 ya l2 exist karti hai, addition chalta rahega
 *
 * ----------------------------------------------------
 * Algorithm:
 *
 * 1. Initialize:
 *      result = new ListNode(0)   (dummy node)
 *      ptr = result
 *      carry = 0
 *
 * 2. Traverse while:
 *      l1 != null OR l2 != null
 *
 * 3. Calculate sum:
 *      sum = carry
 *
 *      - Agar l1 != null:
 *            sum += l1.val
 *            l1 = l1.next
 *
 *      - Agar l2 != null:
 *            sum += l2.val
 *            l2 = l2.next
 *
 * 4. Update:
 *      carry = sum / 10
 *      digit = sum % 10
 *
 * 5. Add digit to result list:
 *      ptr.next = new ListNode(digit)
 *      ptr = ptr.next
 *
 * 6. After loop:
 *      - Agar carry != 0:
 *            ptr.next = new ListNode(carry)
 *
 * 7. Return:
 *      result.next
 *
 * ----------------------------------------------------
 * Dry Run:
 *
 * l1 = 2 → 4 → 3
 * l2 = 5 → 6 → 4
 *
 * Iteration 1:
 * sum = 2 + 5 + 0 = 7
 * carry = 0
 * result = 7
 *
 * Iteration 2:
 * sum = 4 + 6 + 0 = 10
 * carry = 1
 * result = 0
 *
 * Iteration 3:
 * sum = 3 + 4 + 1 = 8
 * carry = 0
 * result = 8
 *
 * Result List:
 * 7 → 0 → 8
 *
 * ----------------------------------------------------
 * Why It Works:
 *
 * - Exactly school-level addition follow hoti hai
 * - Carry ko har step pe maintain kiya jata hai
 * - Dummy node edge cases simplify kar deta hai
 *
 * ----------------------------------------------------
 * Time Complexity:
 * O(max(n, m))
 *
 * Space Complexity:
 * O(max(n, m))   (result list)
 *
 * ----------------------------------------------------
 * Pattern:
 * Linked List + Math + Carry Handling
 */

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode result = new ListNode(0); // dummy node
        ListNode ptr = result;
        int carry = 0;

        while (l1 != null || l2 != null) {

            int sum = carry;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            carry = sum / 10;
            sum = sum % 10;

            ptr.next = new ListNode(sum);
            ptr = ptr.next;
        }

        if (carry != 0) {
            ptr.next = new ListNode(carry);
        }

        return result.next;
    }
}
