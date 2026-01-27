/*
 * Problem: 217. Contains Duplicate
 *
 * Statement:
 * You are given an integer array `nums`.
 *
 * Return true if any value appears at least twice in the array,
 * and return false if every element is distinct.
 *
 * ------------------------------------------------------------
 * APPROACH: HashSet (Duplicate Detection)
 *
 * Core Insight:
 *
 * - HashSet stores only UNIQUE elements
 * - If an element already exists in the set,
 *   it means a duplicate is found
 *
 * ------------------------------------------------------------
 * Step-by-Step Algorithm:
 *
 * 1. Create an empty HashSet
 *
 * 2. Traverse the array:
 *    a) If the current element already exists in the set:
 *         - Duplicate found
 *         - Return true immediately
 *
 *    b) Else:
 *         - Insert the element into the set
 *
 * 3. If traversal completes with no duplicates:
 *    - Return false
 *
 * ------------------------------------------------------------
 * Why This Works:
 *
 * - HashSet provides O(1) average time complexity
 *   for insert and lookup
 *
 * - Early exit ensures we stop as soon as a duplicate is detected
 *
 * ------------------------------------------------------------
 * Example Walkthrough:
 *
 * nums = [1,2,3,1]
 *
 * Steps:
 * - Add 1 → set = {1}
 * - Add 2 → set = {1,2}
 * - Add 3 → set = {1,2,3}
 * - 1 already exists → duplicate found → return true
 *
 * ------------------------------------------------------------
 * Edge Cases:
 *
 * - Empty array
 * - Array with one element
 * - All elements unique
 *
 * ------------------------------------------------------------
 * Time Complexity:
 *
 * - O(n) where n is the number of elements
 *
 * ------------------------------------------------------------
 * Space Complexity:
 *
 * - O(n) in the worst case (all unique elements)
 *
 * ------------------------------------------------------------
 * Pattern Recognition:
 *
 * This problem follows the:
 *   "Duplicate Detection using HashSet" pattern
 *
 * Commonly seen in:
 * - Array uniqueness checks
 * - Data validation problems
 */

class Solution {
    public boolean containsDuplicate(int[] nums) {

        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
        }

        return false;
    }
}
