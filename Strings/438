import java.util.*;

/*
 * Problem: 438. Find All Anagrams in a String
 *
 * Idea:
 * - Do strings diye gaye hain:
 *
 *      s → main string
 *      p → pattern string
 *
 * - Hume s ke andar wo sab starting indices find karne hain
 *   jahan substring p ka anagram ho
 *
 * - Anagram ka matlab:
 *      same characters with same frequency
 *      order different ho sakta hai
 *
 * Example:
 *      "abc" → "bca", "cab", "acb"
 *
 * ----------------------------------------------------
 * Key Observation:
 *
 * - Agar substring ka character frequency
 *   pattern ke frequency ke equal ho
 *
 *      to wo anagram hai
 *
 * - Isliye:
 *
 *      freq array for p
 *      freq array for current window in s
 *
 * - Sliding window use karenge
 *   size = p.length()
 *
 * ----------------------------------------------------
 * Approach: Sliding Window + Frequency Arrays
 *
 * - Do arrays use karte hain:
 *
 *      pCount → pattern frequency
 *      sCount → current window frequency
 *
 * - Window size fix rahega:
 *
 *      p.length()
 *
 * - Har step par window update karenge
 *   aur frequency compare karenge
 *
 * ----------------------------------------------------
 * Algorithm:
 *
 * 1. Create two frequency arrays
 *
 *      int[] pCount = new int[26]
 *      int[] sCount = new int[26]
 *
 * 2. Pattern ke characters count karo
 *
 *      pCount[c - 'a']++
 *
 * 3. Traverse string s
 *
 *      for i = 0 → s.length()-1
 *
 * 4. Current character add karo
 *
 *      sCount[s[i] - 'a']++
 *
 * 5. Window maintain karo
 *
 *      Agar i >= p.length()
 *      to window se ek character remove karo
 *
 *      sCount[s[i - p.length()] - 'a']--
 *
 * 6. Ab compare karo:
 *
 *      Arrays.equals(pCount, sCount)
 *
 *      agar equal hai
 *      to index add karo
 *
 *      startIndex = i - p.length() + 1
 *
 * 7. Continue till end of string
 *
 * 8. Return result list
 *
 * ----------------------------------------------------
 * Dry Run:
 *
 * s = "cbaebabacd"
 * p = "abc"
 *
 * Window size = 3
 *
 * Windows:
 *
 * "cba" → anagram → index 0
 * "bae"
 * "aeb"
 * "eba"
 * "bab"
 * "aba"
 * "bac" → anagram → index 6
 *
 * Output:
 *
 * [0, 6]
 *
 * ----------------------------------------------------
 * Why It Works:
 *
 * - Sliding window constant size maintain karta hai
 * - Frequency arrays pattern aur window compare karte hain
 * - Agar frequencies match ho jaye
 *   to substring anagram hai
 *
 * ----------------------------------------------------
 * Time Complexity:
 *
 * Traversal:
 * O(n)
 *
 * Comparison:
 * O(26)
 *
 * Total:
 *
 * O(26 * n) ≈ O(n)
 *
 * ----------------------------------------------------
 * Space Complexity:
 *
 * O(26)
 *
 * Constant space for frequency arrays
 *
 * ----------------------------------------------------
 * Pattern:
 *
 * Sliding Window + Frequency Counting
 */

class Solution {

    public List<Integer> findAnagrams(String s, String p) {

        int[] pCount = new int[26];
        int[] sCount = new int[26];

        List<Integer> result = new ArrayList<>();

        // Count frequency of characters in p
        for (char c : p.toCharArray()) {
            pCount[c - 'a']++;
        }

        // Sliding window on string s
        for (int i = 0; i < s.length(); i++) {

            sCount[s.charAt(i) - 'a']++;

            // Remove character outside window
            if (i >= p.length()) {
                sCount[s.charAt(i - p.length()) - 'a']--;
            }

            // Compare frequency arrays
            if (Arrays.equals(pCount, sCount)) {
                result.add(i - p.length() + 1);
            }
        }

        return result;
    }
}
