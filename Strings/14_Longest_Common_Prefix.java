/*
 * Problem: 14. Longest Common Prefix
 *
 * Idea:
 * - Ek array of strings diya gaya hai
 * - Humein unka longest common prefix (LCP) find karna hai
 * - Prefix matlab starting characters jo sabhi strings me same hon
 *
 * Example:
 * "flower", "flow", "flight"
 * Common prefix = "fl"
 *
 * ----------------------------------------------------
 * Key Observation:
 *
 * - Agar strings ko lexicographically sort kar diya jaye
 * - To sabse different strings extremes par aayengi
 *
 * Example after sorting:
 * flight
 * flow
 * flower
 *
 * - Agar first aur last string ka prefix same hai
 * - To woh prefix sabhi middle strings me bhi hoga
 *
 * Isliye sirf:
 * first string
 * last string
 * compare karna kaafi hota hai
 *
 * ----------------------------------------------------
 * Approach: Sorting + Compare First and Last
 *
 * 1. Array ko lexicographically sort karo
 * 2. First aur last string uthao
 * 3. Dono strings ko character by character compare karo
 * 4. Jab tak characters match karte hain prefix banate raho
 *
 * ----------------------------------------------------
 * Algorithm:
 *
 * 1. Edge case check:
 *      agar array null ya empty ho
 *      return ""
 *
 * 2. Sort the array:
 *      Arrays.sort(strs)
 *
 * 3. First aur last string store karo:
 *      first = strs[0]
 *      last = strs[n-1]
 *
 * 4. Prefix string initialize karo
 *
 * 5. Loop through characters:
 *      agar first[i] == last[i]
 *          prefix me add karo
 *      warna break
 *
 * 6. Prefix return karo
 *
 * ----------------------------------------------------
 * Dry Run:
 *
 * Input:
 * ["flower","flow","flight"]
 *
 * After sorting:
 * ["flight","flow","flower"]
 *
 * first = "flight"
 * last  = "flower"
 *
 * Compare:
 *
 * f == f → prefix = "f"
 * l == l → prefix = "fl"
 * i != o → stop
 *
 * Output:
 * "fl"
 *
 * ----------------------------------------------------
 * Why It Works:
 *
 * - Sorting ke baad sabse different strings
 *   array ke start aur end me hoti hain
 *
 * - Agar unka prefix match karta hai
 *   to beech ki saari strings me bhi match karega
 *
 * ----------------------------------------------------
 * Time Complexity:
 *
 * Sorting: O(n log n)
 * Comparison: O(m)
 *
 * Overall: O(n log n)
 *
 * n = number of strings
 * m = length of smallest string
 *
 * ----------------------------------------------------
 * Space Complexity:
 *
 * O(1) extra space
 *
 * ----------------------------------------------------
 * Pattern:
 * String Sorting + Prefix Comparison
 */

import java.util.Arrays;

class Solution {
    public String longestCommonPrefix(String[] strs) {

        if (strs == null || strs.length == 0) {
            return "";
        }

        // Sort the array
        Arrays.sort(strs);

        // Get first and last strings
        String first = strs[0];
        String last = strs[strs.length - 1];

        // Store prefix
        String prefix = "";

        // Compare characters one by one
        for (int i = 0; i < first.length(); i++) {

            if (i >= last.length() || first.charAt(i) != last.charAt(i)) {
                break;
            }

            prefix += first.charAt(i);
        }

        return prefix;
    }
}
