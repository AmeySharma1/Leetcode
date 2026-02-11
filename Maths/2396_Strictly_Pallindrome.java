/*
 * Problem: 2396. Strictly Palindromic Number
 *
 * Definition:
 * A number n is strictly palindromic if:
 * For every base b where 2 <= b <= n - 2,
 * the representation of n in base b is a palindrome.
 *
 * -------------------------------------------------------
 * Key Mathematical Observation:
 *
 * For any n >= 4:
 * In base (n - 2),
 *
 * n = 12  (in base n - 2)
 *
 * Proof:
 * n = (n - 2) * 1 + 2
 *
 * So representation becomes:
 * "12"
 *
 * Which is NOT a palindrome.
 *
 * Therefore:
 * No number n >= 4 can be strictly palindromic.
 *
 * -------------------------------------------------------
 * Conclusion:
 *
 * Answer is always FALSE.
 *
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 *
 * Pattern:
 * Math Observation + Base Conversion Trick
 */

class Solution {
    public boolean isStrictlyPalindromic(int n) {
        return false;
    }
}
