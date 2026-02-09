/*
 * Problem: 160. Intersection of Two Linked Lists
 *
 * Idea:
 * - Do singly linked lists di hui hain
 * - Check karna hai ki dono lists kahin intersect karti hain ya nahi
 * - Intersection ka matlab:
 *      same memory reference (node), NOT same value
 *
 * ----------------------------------------------------
 * Key Concept:
 *
 * - Pointer redirection
 * - Length difference ko automatically balance karna
 *
 * ----------------------------------------------------
 * Approach: Two Pointer Switching Technique
 *
 * - Dono pointers apni-apni list traverse karte hain
 * - List end pe pahunchne par dusri list se start kar dete hain
 * - Agar intersection hai, dono pointers same node pe milenge
 *
 * ----------------------------------------------------
 * Algorithm:
 *
 * 1. Initialize:
 *      tempA = headA
 *      tempB = headB
 *
 * 2. Traverse while:
 *      tempA != tempB
 *
 * 3. Move pointers:
 *      - Agar tempA == null:
 *            tempA = headB
 *        Else:
 *            tempA = tempA.next
 *
 *      - Agar tempB == null:
 *            tempB = headA
 *        Else:
 *            tempB = tempB.next
 *
 * 4. Loop ends when:
 *      - tempA == tempB
 *        (intersection node OR null)
 *
 * 5. Return:
 *      tempA
 *
 * ----------------------------------------------------
 * Dry Run:
 *
 * List A: 1 → 2 → 3
 *                  ↘
 *                    6 → 7
 *                  ↗
 * List B:       4 → 5
 *
 * First pass:
 * tempA travels A
 * tempB travels B
 *
 * Second pass:
 * tempA travels B
 * tempB travels A
 *
 * Both meet at:
 * Node 6
 *
 * ----------------------------------------------------
 * Why It Works:
 *
 * - Pointer switching se dono pointers equal distance cover karte hain
 * - Length difference automatically cancel ho jata hai
 * - Agar intersection nahi hai, dono null pe milenge
 *
 * ----------------------------------------------------
 * Time Complexity:
 * O(n + m)
 *
 * Space Complexity:
 * O(1)
 *
 * ----------------------------------------------------
 * Pattern:
 * Linked List + Two Pointer + Length Equalization
 */

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode tempA = headA;
        ListNode tempB = headB;

        while (tempA != tempB) {

            tempA = (tempA == null) ? headB : tempA.next;
            tempB = (tempB == null) ? headA : tempB.next;
        }

        return tempA; // intersection node or null
    }
}
