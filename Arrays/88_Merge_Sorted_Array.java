/*
 * Problem: 88. Merge Sorted Array
 *
 * Statement:
 * You are given two sorted integer arrays:
 *   - nums1 of size (m + n), where the first m elements are valid
 *   - nums2 of size n
 *
 * You must merge nums2 into nums1 so that nums1 becomes
 * a single sorted array.
 *
 * Important:
 * - nums1 has enough space to hold elements of nums2
 * - You must modify nums1 in-place
 *
 * ------------------------------------------------------------
 * APPROACH: Three Pointers (Reverse Traversal)
 *
 * Key Insight:
 *
 * - nums1 already has extra space at the end
 * - If we merge from the front, elements may get overwritten
 * - So we merge from the BACK to keep data safe
 *
 * ------------------------------------------------------------
 * Step-by-Step Algorithm:
 *
 * 1. Initialize three pointers:
 *      i = m - 1          // last valid element in nums1
 *      j = n - 1          // last element in nums2
 *      k = m + n - 1      // last position in nums1
 *
 * 2. While both arrays have elements left:
 *
 *    a) Compare nums1[i] and nums2[j]
 *
 *    b) Place the larger value at nums1[k]
 *
 *    c) Move the corresponding pointer backward
 *
 *    d) Decrement k
 *
 * 3. If nums2 still has elements left:
 *    - Copy remaining elements into nums1
 *
 * 4. No need to handle remaining nums1 elements
 *    because they are already in correct position
 *
 * ------------------------------------------------------------
 * Why This Works:
 *
 * - We always place the largest remaining element at the end
 * - Backward merging avoids overwriting unprocessed elements
 * - Since both arrays are sorted, this greedy choice is optimal
 *
 * ------------------------------------------------------------
 * Example Walkthrough:
 *
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * Initial pointers:
 * i = 2 (nums1[i] = 3)
 * j = 2 (nums2[j] = 6)
 * k = 5
 *
 * Steps:
 * - Place 6 → nums1[5]
 * - Place 5 → nums1[4]
 * - Place 3 → nums1[3]
 * - Place 2 → nums1[2]
 * - Place 2 → nums1[1]
 *
 * Result:
 * nums1 = [1,2,2,3,5,6]
 *
 * ------------------------------------------------------------
 * Edge Cases:
 *
 * - nums2 is empty
 * - nums1 has no valid elements (m = 0)
 * - All elements in nums2 are smaller or larger
 *
 * ------------------------------------------------------------
 * Time Complexity:
 *
 * - O(m + n)
 *
 * ------------------------------------------------------------
 * Space Complexity:
 *
 * - O(1) extra space (in-place merge)
 *
 * ------------------------------------------------------------
 * Pattern Recognition:
 *
 * This problem follows the:
 *   "Reverse Two Pointer Merge" pattern
 *
 * Commonly used in:
 * - Merging sorted arrays
 * - In-place array modification problems
 */

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int i = m - 1;        // last valid element in nums1
        int j = n - 1;        // last element in nums2
        int k = m + n - 1;    // last index of nums1

        // merge from the back
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }

        // copy remaining nums2 elements (if any)
        while (j >= 0) {
            nums1[k] = nums2[j];
            j--;
            k--;
        }
    }
}
