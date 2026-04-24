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


/*
 * Problem: 160. Intersection of Two Linked Lists
 *
 * Given:
 * - Two singly linked lists
 * - Need to find intersection node
 *
 * Definition:
 * - Intersection means same memory reference
 * - NOT same value
 *
 * -------------------------------------------------------
 * Example:
 *
 * List A: 4 → 1
 *               ↘
 *                 8 → 4 → 5
 *               ↗
 * List B:    5 → 6 → 1
 *
 * Output:
 * Node with value 8
 *
 * -------------------------------------------------------
 * APPROACH 1: HashSet Method
 *
 * Idea:
 * - Store all nodes of List A in HashSet
 * - Traverse List B
 * - First node already present in set = intersection
 *
 * -------------------------------------------------------
 * Algorithm:
 *
 * 1. Traverse List A
 *      Store each node in HashSet
 *
 * 2. Traverse List B
 *      If node exists in HashSet:
 *          return node
 *
 * 3. If no match found:
 *      return null
 *
 * -------------------------------------------------------
 * Time Complexity:
 * O(n + m)
 *
 * Space Complexity:
 * O(n)
 *
 * -------------------------------------------------------
 * APPROACH 2: Length Difference Method
 *
 * Idea:
 * - Find lengths of both lists
 * - Move longer list ahead
 * - Then move both together
 * - First common node = intersection
 *
 * -------------------------------------------------------
 * Why This Works:
 *
 * Example:
 *
 * List A length = 7
 * List B length = 5
 *
 * Difference = 2
 *
 * Move List A ahead by 2 nodes
 *
 * Now both lists have equal remaining length
 *
 * -------------------------------------------------------
 * Algorithm:
 *
 * 1. Find length of both lists
 *
 * 2. Move longer list forward:
 *      until lengths become equal
 *
 * 3. Traverse both together:
 *      if headA == headB
 *          return node
 *
 * 4. Return null if not found
 *
 * -------------------------------------------------------
 * Time Complexity:
 * O(n + m)
 *
 * Space Complexity:
 * O(1)
 *
 * -------------------------------------------------------
 * Pattern:
 * Linked List + Length Alignment
 */

public class Solution {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        int lenA = getListLength(headA);
        int lenB = getListLength(headB);

        // Align both lists
        while (lenA > lenB) {
            headA = headA.next;
            lenA--;
        }

        while (lenB > lenA) {
            headB = headB.next;
            lenB--;
        }

        // Move together
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }

        return headA;
    }

    // Helper function to calculate length
    public int getListLength(ListNode head) {

        int length = 0;

        while (head != null) {
            length++;
            head = head.next;
        }

        return length;
    }
}

/*
 * -------------------------------------------------------
 * HASHSET VERSION
 * -------------------------------------------------------
 */

class Solution_HashSet {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        HashSet<ListNode> set = new HashSet<>();

        // Store List A nodes
        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }

        // Check List B
        while (headB != null) {

            if (set.contains(headB)) {
                return headB;
            }

            headB = headB.next;
        }

        return null;
    }
}
