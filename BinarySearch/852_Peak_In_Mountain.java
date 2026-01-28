/*
 * Problem: 852. Peak Index in a Mountain Array
 *
 * Idea:
 * - Mountain array diya hai
 * - Pehle strictly increasing, phir strictly decreasing
 * - Peak ka index find karna hai
 *
 * ----------------------------------------------------
 * Approach: Binary Search on Peak
 *
 * - Mid ko next element se compare karte hain
 * - Agar arr[mid] < arr[mid+1]:
 *      → peak right side me hai
 * - Else:
 *      → peak left ya mid ho sakta hai
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
 *      - agar arr[mid] < arr[mid+1]:
 *            st = mid + 1
 *
 *      - else:
 *            end = mid
 *
 * 4. Loop ends:
 *      st == end → peak index
 *
 * ----------------------------------------------------
 * Dry Run:
 *
 * arr = [0,2,5,3,1]
 *
 * mid = 2 → 5 > 3 → move left
 * end = 2
 *
 * mid = 1 → 2 < 5 → move right
 * st = 2
 *
 * st == end == 2
 *
 * Output:
 * 2
 *
 * ----------------------------------------------------
 * Why It Works:
 * - Mountain array me sirf ek peak hota hai
 * - Comparison se direction decide hota hai
 * - Binary search fast solution deta hai
 *
 * ----------------------------------------------------
 * Time:  O(log n)
 * Space: O(1)
 *
 * ----------------------------------------------------
 * Pattern:
 * Binary Search on Answer / Mountain Array
 */

class Solution {
    public int peakIndexInMountainArray(int[] arr) {

        int st = 0, end = arr.length - 1;

        while (st < end) {
            int mid = st + (end - st) / 2;

            if (arr[mid] < arr[mid + 1]) {
                st = mid + 1;      // move right
            } else {
                end = mid;         // move left (mid can be peak)
            }
        }

        return st; // peak index
    }
}
