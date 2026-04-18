/*
 * Problem: 128. Longest Consecutive Sequence
 *
 * Statement:
 * Given an unsorted integer array `nums`,
 * return the length of the longest consecutive elements sequence.
 *
 * You must write an algorithm that runs in O(n) time.
 *
 * ------------------------------------------------------------
 * APPROACH: HashMap (Visited + Sequence Expansion)
 *
 * Core Insight:
 *
 * - Store all numbers in a HashMap
 * - Use a boolean flag to mark whether a number
 *   has already been visited in a sequence
 *
 * - From each number, expand both directions
 *   (left and right) to count full sequence
 *
 * ------------------------------------------------------------
 * Step-by-Step Algorithm:
 *
 * 1. Insert all elements into HashMap:
 *      key → number
 *      value → false (not visited)
 *
 * 2. Initialize longest_seq = 0
 *
 * 3. Traverse each number:
 *
 *    a) Start with curr_seq = 1
 *
 *    b) Expand forward:
 *         next = num + 1
 *         while next exists AND not visited:
 *             - increase curr_seq
 *             - mark next as visited
 *             - move forward
 *
 *    c) Expand backward:
 *         prev = num - 1
 *         while prev exists AND not visited:
 *             - increase curr_seq
 *             - mark prev as visited
 *             - move backward
 *
 *    d) Update longest_seq
 *
 * 4. Return longest_seq
 *
 * ------------------------------------------------------------
 * Why This Works:
 *
 * - Each number is processed only once due to "visited" marking
 *
 * - Avoids recomputation of sequences
 *
 * - Ensures overall O(n) complexity
 *
 * ------------------------------------------------------------
 * Example Walkthrough:
 *
 * nums = [100,4,200,1,3,2]
 *
 * Sequence found:
 * 1 → 2 → 3 → 4  → length = 4
 *
 * ------------------------------------------------------------
 * Edge Cases:
 *
 * - Empty array → return 0
 * - Single element → return 1
 * - All elements same
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
 *   "Hashing + Sequence Expansion" pattern
 *
 * Commonly seen in:
 * - Consecutive sequence problems
 * - Unsorted array optimization using hashing
 */

class Solution {
    public int longestConsecutive(int[] nums) {

        HashMap<Integer, Boolean> map = new HashMap<>();

        // Insert all elements as unvisited
        for (int num : nums) {
            map.put(num, false);
        }

        int longest_seq = 0;

        for (int num : nums) {

            int curr_seq = 1;

            // Expand forward
            int next_num = num + 1;
            while (map.containsKey(next_num) && map.get(next_num) == false) {
                curr_seq++;
                map.put(next_num, true);
                next_num++;
            }

            // Expand backward
            int prev_num = num - 1;
            while (map.containsKey(prev_num) && map.get(prev_num) == false) {
                curr_seq++;
                map.put(prev_num, true);
                prev_num--;
            }

            longest_seq = Math.max(longest_seq, curr_seq);
        }

        return longest_seq;
    }
}
