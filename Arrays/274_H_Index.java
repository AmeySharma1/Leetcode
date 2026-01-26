/*
 * Problem: 274. H-Index
 *
 * Idea:
 * Researcher ka h-index = max h such that
 * at least h papers have ≥ h citations.
 *
 * ----------------------------------------------------
 * Approach: Sorting + Greedy Check
 *
 * - Citations ko sort karo (ascending)
 * - Har index par check karo:
 *   remaining papers = n - i
 *   agar citations[i] ≥ (n - i) → h found
 *
 * ----------------------------------------------------
 * Algorithm:
 *
 * 1. Sort the citations array
 * 2. Traverse from left to right
 * 3. For each i:
 *      h = n - i
 *      if citations[i] ≥ h → return h
 * 4. If nothing found → return 0
 *
 * ----------------------------------------------------
 * Dry Run:
 *
 * citations = [3,0,6,1,5]
 * after sort = [0,1,3,5,6]
 *
 * i=0 → h=5 → 0 < 5 ❌
 * i=1 → h=4 → 1 < 4 ❌
 * i=2 → h=3 → 3 ≥ 3 ✅
 *
 * answer = 3
 *
 * ----------------------------------------------------
 * Why It Works:
 * - Sorting aligns citation counts with paper count
 * - First valid h is always the maximum possible
 *
 * ----------------------------------------------------
 * Time:  O(n log n)
 * Space: O(1)
 *
 * ----------------------------------------------------
 * Pattern:
 * Sorting + Greedy
 */

import java.util.Arrays;

class Solution {
    public int hIndex(int[] citations) {

        Arrays.sort(citations);
        int n = citations.length;

        for (int i = 0; i < n; i++) {
            int h = n - i;
            if (citations[i] >= h) {
                return h;
            }
        }
        return 0;
    }
}
