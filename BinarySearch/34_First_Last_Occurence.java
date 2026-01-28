/*
 * Problem: 34. Find First and Last Position of Element in Sorted Array
 *
 * Idea:
 * - Sorted array diya hai
 * - Target ke first aur last index find karne hain
 * - Agar target nahi mile → [-1, -1]
 *
 * ----------------------------------------------------
 * Approach: Modified Binary Search
 *
 * - Normal binary search se thoda tweak
 * - First occurrence ke liye:
 *      → target milne ke baad left side me search
 * - Last occurrence ke liye:
 *      → target milne ke baad right side me search
 *
 * ----------------------------------------------------
 * Algorithm:
 *
 * 1. First Occurrence:
 *      - Binary search lagao
 *      - Agar nums[mid] == target:
 *            ans = mid
 *            hi = mid - 1   (left me jao)
 *
 * 2. Last Occurrence:
 *      - Binary search lagao
 *      - Agar nums[mid] == target:
 *            ans = mid
 *            lo = mid + 1   (right me jao)
 *
 * 3. Final Answer:
 *      return [firstIndex, lastIndex]
 *
 * ----------------------------------------------------
 * Dry Run:
 *
 * nums = [5,7,7,8,8,10], target = 8
 *
 * First occurrence:
 *      mid hits 8 → store index → go left
 *      final first = 3
 *
 * Last occurrence:
 *      mid hits 8 → store index → go right
 *      final last = 4
 *
 * Output:
 *      [3, 4]
 *
 * ----------------------------------------------------
 * Why It Works:
 * - Binary search har step me range half karta hai
 * - Direction change karke first & last index milta hai
 *
 * ----------------------------------------------------
 * Time:  O(log n)
 * Space: O(1)
 *
 * ----------------------------------------------------
 * Pattern:
 * Binary Search on Answer / First-Last Occurrence
 */

class Solution {

    public int[] searchRange(int[] nums, int target) {
        int first = first_ele(nums, target);
        int second = second_ele(nums, target);
        return new int[]{first, second};
    }

    // First occurrence
    public int first_ele(int[] nums, int target) {
        int n = nums.length;
        int ans = -1;
        int lo = 0, hi = n - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (nums[mid] == target) {
                ans = mid;
                hi = mid - 1;   // left search
            } else if (nums[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return ans;
    }

    // Last occurrence
    public int second_ele(int[] nums, int target) {
        int n = nums.length;
        int ans = -1;
        int lo = 0, hi = n - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (nums[mid] == target) {
                ans = mid;
                lo = mid + 1;   // right search
            } else if (nums[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return ans;
    }
}
