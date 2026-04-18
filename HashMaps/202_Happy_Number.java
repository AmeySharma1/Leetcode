/*
 * Problem: 202. Happy Number
 *
 * Statement:
 * Write an algorithm to determine if a number `n` is a happy number.
 *
 * A happy number is defined as:
 *
 * - Starting with any positive integer
 * - Replace the number by the sum of the squares of its digits
 * - Repeat the process until:
 *      a) It becomes 1 → (happy number)
 *      b) It enters a cycle → (not a happy number)
 *
 * Return true if `n` is a happy number, else return false.
 *
 * ------------------------------------------------------------
 * APPROACH: HashSet (Cycle Detection)
 *
 * Core Insight:
 *
 * - If the process ever repeats a number,
 *   it means we are stuck in a cycle
 *
 * - Use a HashSet to track previously seen numbers
 *
 * ------------------------------------------------------------
 * Step-by-Step Algorithm:
 *
 * 1. Create a HashSet to store visited numbers
 *
 * 2. Loop indefinitely:
 *
 *    a) Compute sum of squares of digits of n
 *
 *    b) If sum == 1:
 *         - Return true (happy number)
 *
 *    c) If sum already exists in set:
 *         - Cycle detected → return false
 *
 *    d) Else:
 *         - Add sum to set
 *         - Update n = sum
 *
 * ------------------------------------------------------------
 * Why This Works:
 *
 * - There are only limited possible sums for digits
 *
 * - If we don't reach 1, we must fall into a cycle
 *
 * - HashSet efficiently detects repetition
 *
 * ------------------------------------------------------------
 * Example Walkthrough:
 *
 * n = 19
 *
 * Steps:
 * - 1² + 9² = 82
 * - 8² + 2² = 68
 * - 6² + 8² = 100
 * - 1² + 0² + 0² = 1 → happy
 *
 * ------------------------------------------------------------
 * Edge Cases:
 *
 * - n = 1 → already happy
 * - Small numbers entering cycle (like 2, 3, 4)
 *
 * ------------------------------------------------------------
 * Time Complexity:
 *
 * - O(log n) per iteration
 * - Overall small constant due to cycle bound
 *
 * ------------------------------------------------------------
 * Space Complexity:
 *
 * - O(log n) for storing seen numbers
 *
 * ------------------------------------------------------------
 * Pattern Recognition:
 *
 * This problem follows the:
 *   "Cycle Detection using HashSet" pattern
 *
 * Commonly seen in:
 * - Repeated transformation problems
 * - Linked list cycle detection variants
 */

class Solution {
    public boolean isHappy(int n) {

        HashSet<Integer> set = new HashSet<>();

        while (true) {

            int sum = 0;

            // Calculate sum of squares of digits
            while (n != 0) {
                int digit = n % 10;
                sum = sum + digit * digit;
                n = n / 10;
            }

            if (sum == 1)
                return true;

            n = sum;

            if (set.contains(n))
                return false;

            set.add(n);
        }
    }
}
