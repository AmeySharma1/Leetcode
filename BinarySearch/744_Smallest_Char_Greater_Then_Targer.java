/*
 * Problem: 744. Find Smallest Letter Greater Than Target
 *
 * Idea:
 * - Sorted character array diya hai
 * - Target se strictly greater character chahiye
 * - Array circular hai:
 *      → agar end tak koi bada element na mile
 *      → answer = arr[0]
 *
 * ----------------------------------------------------
 * Approach: Modified Binary Search
 *
 * - Binary search lagate hain
 * - Jab bhi arr[mid] > target mile:
 *      → potential answer store karo
 *      → left side me better (smaller) answer dhundo
 *
 * ----------------------------------------------------
 * Algorithm:
 *
 * 1. Initialize:
 *      lo = 0, hi = n - 1
 *      ans = dummy character ('$')
 *
 * 2. While lo <= hi:
 *      mid = lo + (hi - lo) / 2
 *
 * 3. Conditions:
 *      - agar arr[mid] <= target:
 *            right side jao (lo = mid + 1)
 *
 *      - agar arr[mid] > target:
 *            ans = arr[mid]
 *            left side jao (hi = mid - 1)
 *
 * 4. Final check:
 *      - agar ans nahi mila:
 *            return arr[0]
 *      - warna return ans
 *
 * ----------------------------------------------------
 * Dry Run:
 *
 * arr = ['c','f','j'], target = 'd'
 *
 * mid = 'f' > 'd' → ans = 'f'
 * left search → no better answer
 *
 * Output:
 * 'f'
 *
 * Case 2:
 * arr = ['c','f','j'], target = 'j'
 *
 * koi char > 'j' nahi
 * Output:
 * 'c'  (circular property)
 *
 * ----------------------------------------------------
 * Why It Works:
 * - Binary search har step me range half karta hai
 * - Pehla greater element hi smallest greater hota hai
 * - Circular case alag se handle kiya
 *
 * ----------------------------------------------------
 * Time:  O(log n)
 * Space: O(1)
 *
 * ----------------------------------------------------
 * Pattern:
 * Binary Search + Upper Bound Concept
 */

class Solution {
    public char nextGreatestLetter(char[] arr, char target) {

        char ans = '$';
        int lo = 0;
        int hi = arr.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (arr[mid] <= target) {
                lo = mid + 1;
            } else {
                ans = arr[mid];
                hi = mid - 1;
            }
        }

        return (ans == '$') ? arr[0] : ans;
    }
}
