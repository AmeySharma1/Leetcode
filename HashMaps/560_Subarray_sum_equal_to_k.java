/*
 * Problem: 560. Subarray Sum Equals K
 *
 * Statement:
 * Given an integer array `nums` and an integer `k`,
 * return the total number of continuous subarrays
 * whose sum equals to `k`.
 *
 * ------------------------------------------------------------
 * APPROACH: Prefix Sum + HashMap
 *
 * Core Insight:
 *
 * - Instead of checking all subarrays (O(n^2)),
 *   we use prefix sum to reduce the problem
 *
 * - If:
 *      prefixSum[j] - prefixSum[i] = k
 *
 *   Then:
 *      prefixSum[i] = prefixSum[j] - k
 *
 * - So for every prefix sum, we check if
 *   (currentSum - k) already exists
 *
 * ------------------------------------------------------------
 * Step-by-Step Algorithm:
 *
 * 1. Initialize:
 *      sum = 0
 *      count = 0
 *
 * 2. Create a HashMap:
 *      key   → prefix sum
 *      value → frequency of that sum
 *
 * 3. Put base case:
 *      map.put(0, 1)
 *      (handles subarrays starting from index 0)
 *
 * 4. Traverse array:
 *
 *    a) Add current element to sum
 *
 *    b) Check:
 *         val = sum - k
 *
 *         If val exists in map:
 *             - Add its frequency to count
 *
 *    c) Update map with current sum
 *
 * 5. Return count
 *
 * ------------------------------------------------------------
 * Why This Works:
 *
 * - We convert subarray problem into prefix sum difference
 *
 * - HashMap helps us find required prefix instantly
 *
 * - Frequency ensures multiple valid subarrays are counted
 *
 * ------------------------------------------------------------
 * Example Walkthrough:
 *
 * nums = [1,1,1], k = 2
 *
 * Steps:
 * - sum=1 → map={0:1,1:1}
 * - sum=2 → found (2-2=0) → count=1
 * - sum=3 → found (3-2=1) → count=2
 *
 * Answer = 2
 *
 * ------------------------------------------------------------
 * Edge Cases:
 *
 * - Negative numbers present
 * - k = 0
 * - Single element array
 * - Entire array forms valid subarray
 *
 * ------------------------------------------------------------
 * Time Complexity:
 *
 * - O(n)
 *
 * ------------------------------------------------------------
 * Space Complexity:
 *
 * - O(n)
 *
 * ------------------------------------------------------------
 * Pattern Recognition:
 *
 * This problem follows the:
 *   "Prefix Sum + HashMap" pattern
 *
 * Commonly seen in:
 * - Subarray sum problems
 * - Range sum queries
 * - Cumulative sum optimizations
 */

class Solution {
    public int subarraySum(int[] nums, int k) {

        int n = nums.length;
        int count = 0;
        int sum = 0;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for (int i = 0; i < n; i++) {

            sum = sum + nums[i];

            int val = sum - k;

            if (map.containsKey(val)) {
                count = count + map.get(val);
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}
