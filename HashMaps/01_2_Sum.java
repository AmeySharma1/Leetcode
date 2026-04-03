/*
 * Problem: 1. Two Sum
 *
 * Statement:
 * You are given an integer array `nums` and an integer `target`.
 *
 * Return indices of the two numbers such that:
 *      nums[i] + nums[j] == target
 *
 * You may assume that each input has exactly one solution,
 * and you may not use the same element twice.
 *
 * Return the answer in any order.
 *
 * ------------------------------------------------------------
 * APPROACH: HashMap (Complement Lookup)
 *
 * Core Insight:
 *
 * - Instead of checking all pairs (O(n^2)),
 *   we store numbers in a HashMap
 *
 * - For each element, we check:
 *      "Have we already seen the number needed
 *       to complete the target?"
 *
 * ------------------------------------------------------------
 * Step-by-Step Algorithm:
 *
 * 1. Create a HashMap:
 *      key   → number
 *      value → index
 *
 * 2. Traverse the array:
 *
 *    a) Compute complement:
 *         complement = target - nums[i]
 *
 *    b) If complement exists in map:
 *         - We found the pair
 *         - Return current index and stored index
 *
 *    c) Else:
 *         - Store current number and index in map
 *
 * 3. Return result
 *
 * ------------------------------------------------------------
 * Why This Works:
 *
 * - HashMap allows O(1) lookup for complement
 *
 * - We check for solution while building the map,
 *   avoiding extra passes
 *
 * ------------------------------------------------------------
 * Example Walkthrough:
 *
 * nums = [2,7,11,15], target = 9
 *
 * Steps:
 * - i=0 → num=2 → complement=7 → not found → store {2:0}
 * - i=1 → num=7 → complement=2 → found → return [1,0]
 *
 * ------------------------------------------------------------
 * Edge Cases:
 *
 * - Exactly one solution always exists
 * - Negative numbers possible
 * - No need to handle duplicates separately
 *
 * ------------------------------------------------------------
 * Time Complexity:
 *
 * - O(n)
 *
 * ------------------------------------------------------------
 * Space Complexity:
 *
 * - O(n) for HashMap
 *
 * ------------------------------------------------------------
 * Pattern Recognition:
 *
 * This problem follows the:
 *   "Complement Lookup using HashMap" pattern
 *
 * Commonly seen in:
 * - Pair sum problems
 * - Target-based searches
 * - Frequency / lookup optimization problems
 */

class Solution {
    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> mp = new HashMap<>();
        int n = nums.length;

        int[] arr = {0, 0};

        for (int i = 0; i < n; i++) {

            int complement = target - nums[i];

            if (mp.containsKey(complement)) {
                arr[0] = i;
                arr[1] = mp.get(complement);
                return arr;
            }

            mp.put(nums[i], i);
        }

        return arr;
    }
}
