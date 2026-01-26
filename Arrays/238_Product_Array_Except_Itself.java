/*
 * Problem: 238. Product of Array Except Self
 *
 * Idea:
 * - Har index par product chahiye
 *   except khud ke element ke
 * - Division allowed nahi hai
 *
 * ----------------------------------------------------
 * Approach: Prefix & Suffix Product Arrays
 *
 * - Prefix array: left side ka product
 * - Suffix array: right side ka product
 * - Answer[i] = prefix[i] * suffix[i]
 *
 * ----------------------------------------------------
 * Algorithm:
 *
 * 1. Create prefix array:
 *      pre[0] = 1
 *      pre[i] = pre[i-1] * nums[i-1]
 *
 * 2. Create suffix array:
 *      suf[n-1] = 1
 *      suf[i] = suf[i+1] * nums[i+1]
 *
 * 3. Build answer:
 *      ans[i] = pre[i] * suf[i]
 *
 * ----------------------------------------------------
 * Dry Run:
 *
 * nums = [1,2,3,4]
 *
 * prefix:
 * pre = [1,1,2,6]
 *
 * suffix:
 * suf = [24,12,4,1]
 *
 * ans:
 * [24,12,8,6]
 *
 * ----------------------------------------------------
 * Why It Works:
 * - Prefix gives left product
 * - Suffix gives right product
 * - Self element automatically excluded
 *
 * ----------------------------------------------------
 * Time:  O(n)
 * Space: O(n)
 *
 * ----------------------------------------------------
 * Pattern:
 * Prefix-Suffix Technique
 */

class Solution {
    public int[] productExceptSelf(int[] nums) {

        int n = nums.length;
        int[] pre = new int[n];
        int[] suf = new int[n];
        int[] ans = new int[n];

        pre[0] = 1;
        suf[n - 1] = 1;

        for (int i = 1; i < n; i++)
            pre[i] = pre[i - 1] * nums[i - 1];

        for (int i = n - 2; i >= 0; i--)
            suf[i] = suf[i + 1] * nums[i + 1];

        for (int i = 0; i < n; i++)
            ans[i] = pre[i] * suf[i];

        return ans;
    }
}
