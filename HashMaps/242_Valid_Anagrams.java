/*
 * Problem: 242. Valid Anagram
 *
 * Statement:
 * Given two strings `s` and `t`,
 * return true if `t` is an anagram of `s`,
 * and false otherwise.
 *
 * An anagram means both strings contain
 * the same characters with the same frequency,
 * but possibly in different order.
 *
 * ------------------------------------------------------------
 * APPROACH: HashMap (Frequency Counting)
 *
 * Core Insight:
 *
 * - Count frequency of characters in string `s`
 * - Decrease frequency using string `t`
 *
 * - If both strings are anagrams,
 *   all counts will cancel out → map becomes empty
 *
 * ------------------------------------------------------------
 * Step-by-Step Algorithm:
 *
 * 1. Create a HashMap<Character, Integer>
 *
 * 2. Traverse string `s`:
 *      - Increase frequency of each character
 *
 * 3. Traverse string `t`:
 *      - Decrease frequency of each character
 *
 *      a) If frequency becomes 0:
 *           - Remove that character from map
 *
 * 4. At the end:
 *      - If map is empty → return true
 *      - Else → return false
 *
 * ------------------------------------------------------------
 * Why This Works:
 *
 * - Anagrams have identical frequency distribution
 *
 * - Increment (s) + Decrement (t) cancels out
 *
 * - Empty map ensures perfect match
 *
 * ------------------------------------------------------------
 * Example Walkthrough:
 *
 * s = "anagram", t = "nagaram"
 *
 * Steps:
 * - After processing s:
 *      {a=3, n=1, g=1, r=1, m=1}
 *
 * - After processing t:
 *      all counts cancel → map becomes {}
 *
 * → return true
 *
 * ------------------------------------------------------------
 * Edge Cases:
 *
 * - Different lengths → automatically false
 * - Empty strings
 * - Repeated characters
 *
 * ------------------------------------------------------------
 * Time Complexity:
 *
 * - O(n) where n = length of string
 *
 * ------------------------------------------------------------
 * Space Complexity:
 *
 * - O(1) (at most 26 characters for lowercase letters)
 *
 * ------------------------------------------------------------
 * Pattern Recognition:
 *
 * This problem follows the:
 *   "Frequency Counting using HashMap" pattern
 *
 * Commonly seen in:
 * - Anagram problems
 * - Character counting problems
 */

class Solution {
    public boolean isAnagram(String s, String t) {

        HashMap<Character, Integer> m = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            m.put(c, m.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            m.put(c, m.getOrDefault(c, 0) - 1);

            if (m.get(c) == 0)
                m.remove(c);
        }

        return m.isEmpty();
    }
}
