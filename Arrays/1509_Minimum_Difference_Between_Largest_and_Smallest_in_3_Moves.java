/*
 * Problem: 1509. Minimum Difference Between Largest and Smallest Value in Three Moves
 *
 * Task:
 * You can change at most 3 elements in the array to any value.
 * Return the minimum possible difference between the largest
 * and smallest elements after at most 3 moves.
 *
 * ------------------------------------------------------------
 * Approach: Sorting + Greedy Observation
 *
 * Key Idea:
 * - After sorting, only the extreme elements matter
 * - In 3 moves, we can remove any combination of
 *   3 smallest or 3 largest elements
 *
 * ------------------------------------------------------------
 * Algorithm:
 *
 * 1. If array size <= 4, return 0
 *
 * 2. Sort the array
 *
 * 3. Try all 4 valid cases:
 *    - Remove 3 largest
 *    - Remove 2 largest + 1 smallest
 *    - Remove 1 largest + 2 smallest
 *    - Remove 3 smallest
 *
 * 4. Take the minimum difference among these cases
 *
 * ------------------------------------------------------------
 * Dry Run:
 *
 * nums = [5,3,2,4]
 * n = 4
 *
 * Since n <= 4 → return 0
 *
 * ---
 *
 * nums = [1,5,6,14,15]
 * After sort: [1,5,6,14,15]
 *
 * Cases:
 * 1) nums[1] - nums[0] = 14 - 1 = 13
 * 2) nums[2] - nums[1] = 6 - 5 = 1
 * 3) nums[3] - nums[2] = 14 - 6 = 8
 * 4) nums[4] - nums[3] = 15 - 14 = 1
 *
 * Answer = 1
 *
 * ------------------------------------------------------------
 * Why It Works:
 * - Only extreme values affect the final difference
 * - Sorting allows checking all valid 3-removal scenarios
 *
 * ------------------------------------------------------------
 * Time:  O(n log n)
 * Space: O(1)
 *
 * ------------------------------------------------------------
 * Pattern:
 * Sorting + Fixed Window Greedy
 */

import java.util.Arrays;

class Solution {
    public int minDifference(int[] nums) {

        int n = nums.length;
        if (n <= 4) return 0;

        Arrays.sort(nums);

        int ans = Integer.MAX_VALUE;

        ans = Math.min(ans, nums[n - 4] - nums[0]); // remove 3 largest
        ans = Math.min(ans, nums[n - 3] - nums[1]); // remove 2 largest, 1 smallest
        ans = Math.min(ans, nums[n - 2] - nums[2]); // remove 1 largest, 2 smallest
        ans = Math.min(ans, nums[n - 1] - nums[3]); // remove 3 smallest

        return ans;
    }
}
