/*
 * Problem: 350. Intersection of Two Arrays II
 *
 * Statement:
 * Given two integer arrays `nums1` and `nums2`,
 * return an array of their intersection.
 *
 * Each element in the result must appear as many times
 * as it shows in both arrays.
 *
 * You may return the result in any order.
 *
 * ------------------------------------------------------------
 * APPROACH 1: HashMap (Frequency Counting)
 *
 * Core Insight:
 *
 * - Count frequency of elements in nums1
 * - Traverse nums2 and match elements using the map
 *
 * ------------------------------------------------------------
 * Step-by-Step Algorithm:
 *
 * 1. Build a frequency map from nums1
 *
 * 2. Traverse nums2:
 *    a) If element exists in map with count > 0:
 *         - Add to result
 *         - Decrease its count
 *
 * 3. Convert result list to array
 *
 * ------------------------------------------------------------
 * APPROACH 2: Two Pointers (Sorting)
 *
 * Core Insight:
 *
 * - Sort both arrays
 * - Use two pointers to find common elements
 *
 * ------------------------------------------------------------
 * Step-by-Step Algorithm:
 *
 * 1. Sort nums1 and nums2
 *
 * 2. Initialize two pointers i and j
 *
 * 3. While both pointers are within bounds:
 *
 *    a) If nums1[i] == nums2[j]:
 *         - Add to result
 *         - Move both pointers
 *
 *    b) If nums1[i] < nums2[j]:
 *         - Move i
 *
 *    c) Else:
 *         - Move j
 *
 * 4. Convert result list to array
 *
 * ------------------------------------------------------------
 * Why This Works:
 *
 * - HashMap ensures correct frequency tracking
 *
 * - Two pointer approach leverages sorted order
 *   to efficiently find matches
 *
 * ------------------------------------------------------------
 * Example Walkthrough:
 *
 * nums1 = [1,2,2,1]
 * nums2 = [2,2]
 *
 * Output = [2,2]
 *
 * ------------------------------------------------------------
 * Edge Cases:
 *
 * - One or both arrays empty
 * - No common elements
 * - All elements same
 *
 * ------------------------------------------------------------
 * Time Complexity:
 *
 * Approach 1:
 *   O(n + m)
 *
 * Approach 2:
 *   O(n log n + m log m)
 *
 * ------------------------------------------------------------
 * Space Complexity:
 *
 * Approach 1:
 *   O(min(n, m))
 *
 * Approach 2:
 *   O(1) (excluding result)
 *
 * ------------------------------------------------------------
 * Pattern Recognition:
 *
 * This problem follows:
 *   - Frequency Counting using HashMap
 *   - Two Pointer (Sorted Arrays) pattern
 *
 * Common in:
 * - Intersection problems
 * - Duplicate handling
 */

class Solution {

    // ------------------ APPROACH 1: HashMap ------------------
    public int[] intersect(int[] nums1, int[] nums2) {

        Map<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> arr = new ArrayList<>();

        // Build frequency map
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Traverse nums2
        for (int num : nums2) {
            if (map.getOrDefault(num, 0) > 0) {
                arr.add(num);
                map.put(num, map.get(num) - 1);
            }
        }

        // Convert list to array
        int[] ans = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            ans[i] = arr.get(i);
        }

        return ans;
    }

    // ------------------ APPROACH 2: Two Pointers ------------------
    public int[] intersectTwoPointer(int[] nums1, int[] nums2) {

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0, j = 0;
        ArrayList<Integer> result = new ArrayList<>();

        while (i < nums1.length && j < nums2.length) {

            if (nums1[i] == nums2[j]) {
                result.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }

        int[] ans = new int[result.size()];
        for (int k = 0; k < result.size(); k++) {
            ans[k] = result.get(k);
        }

        return ans;
    }
}
