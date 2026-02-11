/*
 * Problem: 1922. Count Good Numbers
 *
 * Idea:
 * - Ek number good tab hota hai:
 *      Even index (0-based) → even digit (0,2,4,6,8) → 5 choices
 *      Odd index → prime digit (2,3,5,7) → 4 choices
 *
 * - Total positions = n
 *
 * ----------------------------------------------------
 * Key Observation:
 *
 * - Even positions count = (n + 1) / 2
 * - Odd positions count = n / 2
 *
 * - Total good numbers =
 *      5^(evenCount) * 4^(oddCount)
 *
 * - Since n bada ho sakta hai (up to 10^15),
 *   fast exponentiation use karna zaroori hai
 *
 * ----------------------------------------------------
 * Approach: Binary Exponentiation (Fast Power)
 *
 * - Divide and conquer technique
 * - a^b ko log(b) time me calculate karte hain
 *
 * ----------------------------------------------------
 * Algorithm:
 *
 * 1. Calculate:
 *      evenCount = (n + 1) / 2
 *      oddCount = n / 2
 *
 * 2. Compute:
 *      part1 = 5^evenCount  % M
 *      part2 = 4^oddCount   % M
 *
 * 3. Multiply:
 *      answer = (part1 * part2) % M
 *
 * 4. Return answer
 *
 * ----------------------------------------------------
 * Binary Exponentiation Logic:
 *
 * power(a, b):
 *      if b == 0 → return 1
 *
 *      half = power(a, b/2)
 *      result = (half * half) % M
 *
 *      if b is odd:
 *          result = (result * a) % M
 *
 *      return result
 *
 * ----------------------------------------------------
 * Dry Run:
 *
 * n = 4
 *
 * evenCount = 2
 * oddCount = 2
 *
 * answer = 5^2 * 4^2
 *         = 25 * 16
 *         = 400
 *
 * ----------------------------------------------------
 * Why It Works:
 *
 * - Har even position independent hai → 5 choices
 * - Har odd position independent hai → 4 choices
 * - Total combinations multiplication se milta hai
 * - Fast power ensures O(log n) time
 *
 * ----------------------------------------------------
 * Time Complexity:
 * O(log n)
 *
 * Space Complexity:
 * O(log n)  (recursive stack)
 *
 * ----------------------------------------------------
 * Pattern:
 * Math + Combinatorics + Binary Exponentiation
 */

class Solution {

    static final int M = 1000000007;

    public int countGoodNumbers(long n) {

        long evenCount = (n + 1) / 2;
        long oddCount = n / 2;

        long part1 = binaryExponentiation(5, evenCount);
        long part2 = binaryExponentiation(4, oddCount);

        return (int)((part1 * part2) % M);
    }

    public long binaryExponentiation(long a, long b) {

        if (b == 0) return 1;

        long half = binaryExponentiation(a, b / 2);
        long result = (half * half) % M;

        if (b % 2 == 1) {
            result = (result * a) % M;
        }

        return result;
    }
}
