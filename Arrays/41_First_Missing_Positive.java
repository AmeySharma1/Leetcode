/*
 * Problem: 41. First Missing Positive
 *
 * Task:
 * Find the smallest missing positive integer in an unsorted array.
 *
 * Constraints:
 * - O(n) time
 * - O(1) extra space
 *
 * ------------------------------------------------------------
 * Approach: Pigeonhole + In-place Index Marking
 *
 * Key Idea:
 * - Missing number lies in range [1, n+1]
 * - Use array indices to mark presence via sign flipping
 *
 * ------------------------------------------------------------
 * Algorithm:
 *
 * 1. Replace all numbers <= 0 or > n with (n + 1)
 *
 * 2. For each number x:
 *    - If 1 <= x <= n, mark index (x - 1) as negative
 *
 * 3. First positive index → answer = index + 1
 *
 * 4. If none found, return (n + 1)
 *
 * ------------------------------------------------------------
 * Dry Run:
 *
 * nums = [3, 4, -1, 1]
 * n = 4
 *
 * Step 1 (normalize):
 * [3, 4, 5, 1]
 *
 * Step 2 (marking):
 * 3 → mark index 2 → [3, 4, -5, 1]
 * 4 → mark index 3 → [3, 4, -5, -1]
 * 1 → mark index 0 → [-3, 4, -5, -1]
 *
 * Step 3 (scan):
 * index 1 is positive → answer = 2
 *
 * ------------------------------------------------------------
 * Why It Works:
 * - Pigeonhole principle limits valid range
 * - Sign marking tracks presence without extra space
 *
 * ------------------------------------------------------------
 * Time:  O(n)
 * Space: O(1)
 *
 * ------------------------------------------------------------
 * Pattern:
 * Index-as-Hash / In-place Marking
 */

class Solution {
    public int firstMissingPositive(int[] nums) {

        int n = nums.length;

        // Step 1: normalize invalid values
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0 || nums[i] >= n + 1) {
                nums[i] = n + 1;
            }
        }

        // Step 2: mark presence
        for (int i = 0; i < n; i++) {
            int element = Math.abs(nums[i]);
            if (element == n + 1) continue;

            int seat = element - 1;
            if (nums[seat] > 0) {
                nums[seat] = -nums[seat];
            }
        }

        // Step 3: find first missing positive
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }

        return n + 1;
    }
}
