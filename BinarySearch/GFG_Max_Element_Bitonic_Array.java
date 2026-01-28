/*
 * Problem: Find Maximum Element in Bitonic Array
 *
 * Idea:
 * - Array pehle strictly increasing hota hai
 * - Phir strictly decreasing
 * - Beech ka element hi maximum (peak) hota hai
 *
 * ----------------------------------------------------
 * Approach: Binary Search on Peak
 *
 * - Mid ko next element se compare karte hain
 * - Decide karte hain peak left me hai ya right me
 *
 * ----------------------------------------------------
 * Algorithm:
 *
 * 1. Initialize:
 *      low = 0
 *      high = n - 1
 *
 * 2. While low < high:
 *      mid = low + (high - low) / 2
 *
 * 3. Compare:
 *      - agar arr[mid] < arr[mid + 1]:
 *            peak right side me hai
 *            low = mid + 1
 *
 *      - else:
 *            peak mid ya left side me hai
 *            high = mid
 *
 * 4. Loop end:
 *      low == high → peak index
 *
 * 5. Return:
 *      arr[low]
 *
 * ----------------------------------------------------
 * Dry Run:
 *
 * arr = [1, 3, 8, 12, 4, 2]
 *
 * mid = 2 → arr[2]=8, arr[3]=12
 * 8 < 12 → move right
 *
 * mid = 3 → arr[3]=12, arr[4]=4
 * 12 > 4 → move left
 *
 * low == high == 3
 *
 * Output:
 * 12
 *
 * ----------------------------------------------------
 * Why It Works:
 * - Bitonic array me sirf ek hi peak hota hai
 * - Comparison se direction decide ho jata hai
 * - Binary search se fast solution milta hai
 *
 * ----------------------------------------------------
 * Time:  O(log n)
 * Space: O(1)
 *
 * ----------------------------------------------------
 * Pattern:
 * Binary Search on Answer / Peak Element
 */

class Solution {
    public int findMaximum(int[] arr) {

        int low = 0, high = arr.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] < arr[mid + 1]) {
                low = mid + 1;   // move right
            } else {
                high = mid;      // move left
            }
        }

        return arr[low]; // peak element
    }
}
