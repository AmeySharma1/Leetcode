/*
 * Problem: 153. Find Minimum in Rotated Sorted Array
 *
 * Idea:
 * - Sorted array ko rotate kiya gaya hai
 * - Minimum element hi rotation point hota hai
 * - Array me duplicates nahi hote
 *
 * ----------------------------------------------------
 * Approach: Binary Search on Rotation Point
 *
 * - Mid ko end element se compare karte hain
 * - Decide karte hain minimum left me hai ya right me
 *
 * ----------------------------------------------------
 * Algorithm:
 *
 * 1. Initialize:
 *      st = 0
 *      end = n - 1
 *
 * 2. While st < end:
 *      mid = st + (end - st) / 2
 *
 * 3. Compare:
 *      - agar nums[mid] > nums[end]:
 *            minimum right side me hai
 *            st = mid + 1
 *
 *      - else:
 *            minimum mid ya left side me ho sakta hai
 *            end = mid
 *
 * 4. Loop end:
 *      st == end → minimum index
 *
 * 5. Return:
 *      nums[st]
 *
 * ----------------------------------------------------
 * Dry Run:
 *
 * nums = [4,5,6,7,0,1,2]
 *
 * mid = 3 → nums[mid]=7 > nums[end]=2
 * move right → st = 4
 *
 * mid = 5 → nums[mid]=1 <= nums[end]=2
 * move left → end = 5
 *
 * mid = 4 → nums[mid]=0 <= nums[end]=1
 * end = 4
 *
 * st == end == 4
 *
 * Output:
 * 0
 *
 * ----------------------------------------------------
 * Why It Works:
 * - Rotated sorted array me minimum ek unique point hota hai
 * - Comparison se sorted vs unsorted part identify hota hai
 *
 * ----------------------------------------------------
 * Time:  O(log n)
 * Space: O(1)
 *
 * ----------------------------------------------------
 * Pattern:
 * Binary Search on Rotated Array / Rotation Point
 */

class Solution {
    public int findMin(int[] nums) {

        int st = 0, end = nums.length - 1;

        while (st < end) {
            int mid = st + (end - st) / 2;

            if (nums[mid] > nums[end]) {
                st = mid + 1;
            } else {
                end = mid;
            }
        }

        return nums[st];
    }
}
