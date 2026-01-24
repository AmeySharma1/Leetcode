/*
 * Problem: 27. Remove Element
 *
 * Statement:
 * You are given an integer array `nums` and an integer `val`.
 *
 * You must remove all occurrences of `val` in-place and return
 * the number of elements that are NOT equal to `val`.
 *
 * Important:
 * - Do NOT use extra space for another array
 * - The order of remaining elements does not matter
 *
 * ------------------------------------------------------------
 * APPROACH: Two Pointers (Overwrite / Slow-Fast Pointer)
 *
 * Core Insight:
 *
 * - Maintain one pointer to track the position where the next
 *   valid (non-val) element should be placed
 *
 * - Traverse the array and overwrite unwanted elements
 *
 * ------------------------------------------------------------
 * Step-by-Step Algorithm:
 *
 * 1. Initialize:
 *      index = 0     // position for next valid element
 *
 * 2. Traverse the array using pointer i:
 *
 *    a) If nums[i] != val:
 *         - Copy nums[i] to nums[index]
 *         - Increment index
 *
 *    b) If nums[i] == val:
 *         - Skip it
 *
 * 3. After traversal:
 *    - index represents the count of valid elements
 *
 * 4. Return index
 *
 * ------------------------------------------------------------
 * Why This Works:
 *
 * - All valid elements are compacted at the front
 * - Overwriting is safe because we only write forward
 * - No extra memory is used
 *
 * ------------------------------------------------------------
 * Example Walkthrough:
 *
 * nums = [3,2,2,3], val = 3
 *
 * Iteration:
 * i=0 → 3 == val → skip
 * i=1 → 2 != val → nums[0]=2
 * i=2 → 2 != val → nums[1]=2
 * i=3 → 3 == val → skip
 *
 * Result:
 * nums = [2,2,_,_]
 * return = 2
 *
 * ------------------------------------------------------------
 * Edge Cases:
 *
 * - All elements equal to val
 * - No element equals val
 * - Single element array
 *
 * ------------------------------------------------------------
 * Time Complexity:
 *
 * - O(n)
 *
 * ------------------------------------------------------------
 * Space Complexity:
 *
 * - O(1) (in-place)
 *
 * ------------------------------------------------------------
 * Pattern Recognition:
 *
 * This problem follows the:
 *   "In-place Array Filtering" pattern
 *
 * Seen in:
 * - Removing duplicates
 * - Array compaction problems
 */

class Solution {
    public int removeElement(int[] nums, int val) {

        int index = 0;   // slow pointer

        for (int i = 0; i < nums.length; i++) {   // fast pointer
            if (nums[i] != val) {
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }
}
