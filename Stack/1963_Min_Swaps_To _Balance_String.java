/* 
 * Problem: 1963. Minimum Number of Swaps to Make the String Balanced
 *
 * Given:
 * - A string s consisting of only '[' and ']'
 * - Number of '[' and ']' are equal
 *
 * Task:
 * - Return minimum number of swaps required
 *   to make the string balanced.
 *
 * A string is balanced if:
 *      Every '[' has a matching ']'
 *      Order is correct
 *
 * Example:
 * Input:  "][]["
 * Output: 1
 *
 * Input:  "]]][[["
 * Output: 2
 *
 * -------------------------------------------------------
 * Core Idea:
 *
 * We track unmatched opening brackets '['.
 *
 * Let:
 *      size → count of unmatched '['
 *
 * Traverse string:
 *
 * If '[':
 *      size++
 *
 * If ']':
 *      If size > 0:
 *          Match with previous '[' → size--
 *      Else:
 *          This ']' is currently unmatched
 *
 * After traversal:
 *      size = number of unmatched '['
 *
 * Important Observation:
 *
 * Each swap can fix TWO misplaced brackets.
 *
 * So required swaps = ceil(size / 2)
 *
 * Formula:
 *      (size + 1) / 2
 *
 * -------------------------------------------------------
 * Why This Works?
 *
 * Example: "]]][[["
 *
 * Step-by-step:
 *
 * ']' → size=0 (unmatched close)
 * ']' → size=0
 * ']' → size=0
 * '[' → size=1
 * '[' → size=2
 * '[' → size=3
 *
 * Final size = 3 unmatched '['
 *
 * Swaps needed:
 *      ceil(3 / 2) = 2
 *
 * Because one swap fixes two misplaced brackets.
 *
 * -------------------------------------------------------
 * Algorithm:
 *
 * 1. Initialize size = 0
 *
 * 2. Traverse string:
 *
 *      If '[':
 *          size++
 *
 *      Else ']':
 *          If size > 0:
 *              size--
 *
 * 3. Return (size + 1) / 2
 *
 * -------------------------------------------------------
 * Time Complexity:
 * O(n)
 *
 * Space Complexity:
 * O(1)
 *
 * Pattern:
 * Greedy + Bracket Balancing + Mathematical Insight
 */

class Solution {
    public int minSwaps(String s) {

        int size = 0;  // Unmatched '[' count

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (ch == '[') {
                size++;
            } 
            else {  // ']'
                if (size > 0) {
                    size--;  // Match with previous '['
                }
            }
        }

        // Each swap fixes two misplaced brackets
        return (size + 1) / 2;
    }
}
