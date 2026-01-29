/*
 * Problem: 33. Search in Rotated Sorted Array
 *
 * Idea:
 * - Sorted array ko rotate kar diya gaya hai
 * - Element search karna hai in O(log n)
 * - Har step pe ek half hamesha sorted hota hai
 *
 * ----------------------------------------------------
 * Approach: Modified Binary Search
 *
 * - Mid nikal kar check karo
 * - Identify karo kaunsa half sorted hai
 * - Target ke range ke hisaab se direction decide karo
 *
 * ----------------------------------------------------
 * Algorithm:
 *
 * 1. Initialize:
 *      st = 0
 *      end = n - 1
 *
 * 2. While st <= end:
 *      mid = st + (end - st) / 2
 *
 * 3. Agar nums[mid] == target:
 *      return mid
 *
 * 4. Check left half sorted hai ya nahi:
 *      agar nums[st] <= nums[mid]:
 *          left part sorted hai
 *
 *      - agar target nums[st] se nums[mid) ke beech:
 *            end = mid - 1
 *        else:
 *            st = mid + 1
 *
 * 5. Else (right half sorted):
 *      - agar target (nums[mid], nums[end] ke beech):
 *            st = mid + 1
 *        else:
 *            end = mid - 1
 *
 * 6. Agar loop khatam:
 *      return -1
 *
 * ----------------------------------------------------
 * Dry Run:
 *
 * nums = [4,5,6,7,0,1,2], target = 0
 *
 * mid = 3 → nums[mid] = 7
 * left sorted [4,5,6,7]
 * target not in left → move right
 *
 * mid = 5 → nums[mid] = 1
 * left sorted [0,1]
 * target in left → move left
 *
 * mid = 4 → nums[mid] = 0 → found
 *
 * ----------------------------------------------------
 * Why It Works:
 * - Rotated array me har time ek half sorted hota hai
 * - Sorted half se target ka range easily decide hota hai
 *
 * ----------------------------------------------------
 * Time:  O(log n)
 * Space: O(1)
 *
 * ----------------------------------------------------
 * Pattern:
 * Binary Search on Rotated Array
 */

class Solution {
    public int search(int[] nums, int target) {

        int n = nums.length;
        int st = 0, end = n - 1;

        while (st <= end) {
            int mid = st + (end - st) / 2;

            if (nums[mid] == target)
                return mid;

            // left part sorted
            if (nums[st] <= nums[mid]) {
                if (target >= nums[st] && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    st = mid + 1;
                }
            }
            // right part sorted
            else {
                if (target > nums[mid] && target <= nums[end]) {
                    st = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
}
