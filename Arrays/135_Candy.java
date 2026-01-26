/*
 * Problem: 135. Candy
 *
 * Idea:
 * - Har child ko kam se kam 1 candy mile
 * - Agar rating zyada hai neighbor se,
 *   to candies bhi zyada honi chahiye
 *
 * ----------------------------------------------------
 * Approach: Two Pass Greedy
 *
 * - First pass (left → right):
 *   right neighbor ki rating zyada ho to candies badhao
 *
 * - Second pass (right → left):
 *   left neighbor ki rating zyada ho to candies adjust karo
 *
 * ----------------------------------------------------
 * Algorithm:
 *
 * 1. Sabko initially 1 candy do
 * 2. Left to right:
 *      if rating[i] > rating[i-1]
 *         candies[i] = candies[i-1] + 1
 * 3. Right to left:
 *      if rating[i-1] > rating[i]
 *         candies[i-1] = max(candies[i-1], candies[i] + 1)
 *      sum candies
 * 4. Return total candies
 *
 * ----------------------------------------------------
 * Dry Run:
 *
 * ratings = [1,0,2]
 *
 * init candies = [1,1,1]
 *
 * left → right:
 * i=1 → 0 > 1 ❌ → [1,1,1]
 * i=2 → 2 > 0 ✅ → [1,1,2]
 *
 * right → left:
 * i=2 → 0 > 2 ❌
 * i=1 → 1 > 0 ✅ → [2,1,2]
 *
 * total = 5
 *
 * ----------------------------------------------------
 * Why It Works:
 * - Left pass handles increasing slope
 * - Right pass handles decreasing slope
 * - max() ensures previous condition is not broken
 *
 * ----------------------------------------------------
 * Time:  O(n)
 * Space: O(n)
 *
 * ----------------------------------------------------
 * Pattern:
 * Greedy + Two Pass
 */

class Solution {
    public int candy(int[] ratings) {

        int n = ratings.length;
        int[] candies = new int[n];

        // step 1: give everyone 1 candy
        for (int i = 0; i < n; i++)
            candies[i] = 1;

        // step 2: left to right
        for (int i = 1; i < n; i++)
            if (ratings[i] > ratings[i - 1])
                candies[i] = candies[i - 1] + 1;

        // step 3: right to left + sum
        int cnt = 0;
        for (int i = n - 1; i > 0; i--) {
            if (ratings[i - 1] > ratings[i])
                candies[i - 1] = Math.max(candies[i - 1], candies[i] + 1);
            cnt += candies[i - 1];
        }

        return cnt + candies[n - 1];
    }
}
