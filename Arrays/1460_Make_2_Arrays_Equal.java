/*
 * Problem: 1460. Make Two Arrays Equal by Reversing Sub-arrays
 *
 * Idea:
 * Two arrays can be made equal if they have the same
 * frequency of every element.
 *
 * ----------------------------------------------------
 * Approach: Frequency Map Comparison
 *
 * - Count occurrences of elements in both arrays
 * - If both maps are equal → possible
 *
 * ----------------------------------------------------
 * Algorithm:
 *
 * 1. Build frequency map for array t
 * 2. Build frequency map for array arr
 * 3. Compare both maps
 *
 * ----------------------------------------------------
 * Dry Run:
 *
 * t   = [1,2,3,4]
 * arr = [2,4,1,3]
 *
 * map1 = {1=1, 2=1, 3=1, 4=1}
 * map2 = {1=1, 2=1, 3=1, 4=1}
 *
 * map1.equals(map2) → true
 *
 * ----------------------------------------------------
 * Why It Works:
 * - Reversing subarrays does not change element counts
 * - Only frequency equality matters
 *
 * ----------------------------------------------------
 * Time:  O(n)
 * Space: O(n)
 *
 * ----------------------------------------------------
 * Pattern:
 * Frequency Counting / Hashing
 */

class Solution {
    public boolean canBeEqual(int[] t, int[] arr) {

        HashMap<Integer, Integer> map1 = new HashMap<>();
        for (int x : t) {
            map1.put(x, map1.getOrDefault(x, 0) + 1);
        }

        HashMap<Integer, Integer> map2 = new HashMap<>();
        for (int x : arr) {
            map2.put(x, map2.getOrDefault(x, 0) + 1);
        }

        return map1.equals(map2);
    }
}
