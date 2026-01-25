/*
 * Problem: 442. Find All Duplicates in an Array
 *
 * Statement:
 * You are given an integer array `nums` of length n where:
 *   - 1 ≤ nums[i] ≤ n
 *   - Each integer appears once or twice
 *
 * Return all elements that appear exactly twice.
 *
 * You must solve it in:
 * - O(n) time
 * - Without using extra space (excluding output list)
 *
 * ------------------------------------------------------------
 * APPROACH: In-place Index Marking (Sign Flipping)
 *
 * Core Insight:
 *
 * - Since values are in range [1, n], each value maps to
 *   a unique index: value → value - 1
 *
 * - We use the SIGN of elements to mark visitation
 *
 * ------------------------------------------------------------
 * Step-by-Step Algorithm:
 *
 * 1. Initialize an empty list `result`
 *
 * 2. Traverse the array:
 *
 *    a) Let num = abs(nums[i])
 *
 *    b) Compute mapped index:
 *         index = num - 1
 *
 *    c) If nums[index] is NEGATIVE:
 *         - This number has been seen before
 *         - Add num to result
 *
 *    d) Else:
 *         - Mark it as visited by flipping its sign
 *
 * 3. Return result
 *
 * ------------------------------------------------------------
 * Why This Works:
 *
 * - Each number points to a unique index
 * - First visit → mark index negative
 * - Second visit → detect negative → duplicate found
 *
 * ------------------------------------------------------------
 * Example Walkthrough:
 *
 * nums = [4,3,2,7,8,2,3,1]
 *
 * Steps:
 * - 4 → mark index 3
 * - 3 → mark index 2
 * - 2 → mark index 1
 * - 7 → mark index 6
 * - 8 → mark index 7
 * - 2 → index 1 already negative → duplicate
 * - 3 → index 2 already negative → duplicate
 *
 * Result:
 * [2,3]
 *
 * ------------------------------------------------------------
 * Edge Cases:
 *
 * - No duplicates
 * - All elements duplicated
 * - Minimum size array
 *
 * ------------------------------------------------------------
 * Time Complexity:
 *
 * - O(n)
 *
 * ------------------------------------------------------------
 * Space Complexity:
 *
 * - O(1) extra space (output excluded)
 *
 * ------------------------------------------------------------
 * Pattern Recognition:
 *
 * This problem follows the:
 *   "Index as Hash / In-place Marking" pattern
 *
 * Seen in:
 * - Find missing numbers
 * - First missing positive
 * - Detect duplicates without extra space
 */

class Solution {
    public List<Integer> findDuplicates(int[] nums) {

        List<Integer> arr = new ArrayList<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {

            int num = Math.abs(nums[i]);
            int seat = num - 1;

            if (nums[seat] < 0) {
                arr.add(num);
            } else {
                nums[seat] = -nums[seat];
            }
        }
        return arr;
    }
}
