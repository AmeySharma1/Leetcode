/*
 * Problem: 941. Valid Mountain Array
 *
 * Idea:
 * - Array pehle strictly increasing hona chahiye
 * - Phir ek peak aaye
 * - Uske baad strictly decreasing
 * - Peak first ya last index par nahi ho sakta
 *
 * ----------------------------------------------------
 * Approach: Single Pass (Two Slopes)
 *
 * - Pehle upward climb check karo
 * - Phir downward climb check karo
 * - End tak pohonch gaye → valid mountain
 *
 * ----------------------------------------------------
 * Algorithm:
 *
 * 1. Edge case:
 *      - Agar n < 3 → false
 *
 * 2. Initialize:
 *      i = 0
 *
 * 3. Climb Up:
 *      - Jab tak arr[i] < arr[i+1]
 *      - i++
 *
 * 4. Peak validation:
 *      - Agar i == 0 OR i == n-1 → false
 *
 * 5. Climb Down:
 *      - Jab tak arr[i] > arr[i+1]
 *      - i++
 *
 * 6. Final check:
 *      - Agar i == n-1 → true
 *      - Else → false
 *
 * ----------------------------------------------------
 * Dry Run:
 *
 * arr = [0,3,2,1]
 *
 * climb up:
 * 0 < 3 → i = 1
 *
 * peak index = 1 (valid)
 *
 * climb down:
 * 3 > 2 → i = 2
 * 2 > 1 → i = 3
 *
 * i == n-1 → true
 *
 * ----------------------------------------------------
 * Invalid Cases:
 *
 * [2,1]        → too short
 * [3,5,5]     → equal elements
 * [0,1,2,3]   → no downward
 * [3,2,1]     → no upward
 *
 * ----------------------------------------------------
 * Why It Works:
 * - Mountain array me sirf ek peak hota hai
 * - Strict inequality ensure karti hai proper shape
 *
 * ----------------------------------------------------
 * Time:  O(n)
 * Space: O(1)
 *
 * ----------------------------------------------------
 * Pattern:
 * Two Pointer / Single Pass / Mountain Pattern
 */

class Solution {
    public boolean validMountainArray(int[] arr) {

        int n = arr.length;
        if (n < 3) return false;

        int i = 0;

        // climb up
        while (i + 1 < n && arr[i] < arr[i + 1]) {
            i++;
        }

        // peak can't be first or last
        if (i == 0 || i == n - 1) return false;

        // climb down
        while (i + 1 < n && arr[i] > arr[i + 1]) {
            i++;
        }

        return i == n - 1;
    }
}
