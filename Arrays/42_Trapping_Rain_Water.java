/*
 * Problem: 42. Trapping Rain Water
 *
 * Idea:
 * Kisi index par pani tab rukega jab
 * uske left aur right me koi height usse badi ho.
 *
 * Water at i = min(leftMax, rightMax) - height[i]
 *
 * ----------------------------------------------------
 * Approach: Precompute Left Max & Right Max
 *
 * - Har index ke liye:
 *   left side ka maximum
 *   right side ka maximum
 * - Dono me se jo chhota hoga wahi water limit karega
 *
 * ----------------------------------------------------
 * Algorithm:
 *
 * 1. lmax[i] = max height from 0 to i
 * 2. rmax[i] = max height from i to n-1
 * 3. For each index i:
 *      water += min(lmax[i], rmax[i]) - arr[i]
 *
 * ----------------------------------------------------
 * Dry Run:
 *
 * arr = [4,2,0,3,2,5]
 *
 * lmax = [4,4,4,4,4,5]
 * rmax = [5,5,5,5,5,5]
 *
 * i=0 → min(4,5)-4 = 0
 * i=1 → min(4,5)-2 = 2
 * i=2 → min(4,5)-0 = 4
 * i=3 → min(4,5)-3 = 1
 * i=4 → min(4,5)-2 = 2
 * i=5 → min(5,5)-5 = 0
 *
 * total water = 9
 *
 * ----------------------------------------------------
 * Why It Works:
 * - Water level depends on shorter boundary
 * - Precomputing avoids repeated scans
 *
 * ----------------------------------------------------
 * Time:  O(n)
 * Space: O(n)
 *
 * ----------------------------------------------------
 * Pattern:
 * Prefix Max / Suffix Max
 */

class Solution {
    public int trap(int[] arr) {
        int n = arr.length;

        int[] lmax = new int[n];
        lmax[0] = arr[0];
        for (int i = 1; i < n; i++)
            lmax[i] = Math.max(lmax[i - 1], arr[i]);

        int[] rmax = new int[n];
        rmax[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--)
            rmax[i] = Math.max(rmax[i + 1], arr[i]);

        int ans = 0;
        for (int i = 0; i < n; i++)
            ans += Math.min(lmax[i], rmax[i]) - arr[i];

        return ans;
    }
}
