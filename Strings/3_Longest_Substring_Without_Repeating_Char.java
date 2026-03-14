/*
 * Problem: 3. Longest Substring Without Repeating Characters
 *
 * Idea:
 * - Ek string diya gaya hai
 * - Hume longest substring find karna hai jisme koi bhi character repeat na ho
 *
 * Example:
 * s = "abcabcbb"
 *
 * Possible substrings without repeating characters:
 * "abc" → length = 3
 * "bca" → length = 3
 * "cab" → length = 3
 *
 * Output: 3
 *
 * ----------------------------------------------------
 * Key Observation:
 *
 * - Agar substring me duplicate character aa jata hai
 *   to hume window ko shrink karna padta hai
 *
 * - Sliding Window technique use kar sakte hain
 *
 * ----------------------------------------------------
 * Approach: Sliding Window + HashSet
 *
 * - Do pointers use karte hain:
 *
 *      left  → window start
 *      right → window end
 *
 * - HashSet use karte hain window ke characters track karne ke liye
 *
 * Steps:
 *
 * 1. Right pointer expand karta hai window
 * 2. Agar duplicate milta hai
 *      to left pointer move karke duplicates remove karte hain
 *
 * 3. Har step par maximum window size track karte hain
 *
 * ----------------------------------------------------
 * Algorithm:
 *
 * 1. Create:
 *      HashSet<Character> set
 *
 * 2. Initialize:
 *      left = 0
 *      max_length = 0
 *
 * 3. Traverse using right pointer:
 *
 *      for right from 0 → n-1
 *
 *      while set contains s[right]
 *          remove s[left] from set
 *          left++
 *
 *      add s[right] to set
 *
 *      update max_length:
 *      max_length = max(max_length, right-left+1)
 *
 * 4. Return max_length
 *
 * ----------------------------------------------------
 * Dry Run:
 *
 * s = "abcabcbb"
 *
 * Window expansion:
 *
 * a → "a" → length 1
 * b → "ab" → length 2
 * c → "abc" → length 3
 *
 * next 'a' duplicate:
 *
 * remove 'a'
 * window becomes "bca"
 *
 * continue...
 *
 * longest = 3
 *
 * Output:
 * 3
 *
 * ----------------------------------------------------
 * Why It Works:
 *
 * - Sliding window ensure karta hai ki substring
 *   hamesha unique characters ka ho
 *
 * - HashSet duplicate detection fast banata hai
 *
 * ----------------------------------------------------
 * Time Complexity:
 *
 * O(n)
 *
 * Har character maximum 2 times process hota hai
 *
 * ----------------------------------------------------
 * Space Complexity:
 *
 * O(min(n, charset))
 *
 * charset ≈ 128 for ASCII
 *
 * ----------------------------------------------------
 * Pattern:
 * Sliding Window + HashSet
 */

import java.util.HashSet;
import java.util.Set;

class Solution {

    public int lengthOfLongestSubstring(String s) {

        Set<Character> set = new HashSet<>();

        int max_length = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {

            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }

            set.add(s.charAt(right));

            max_length = Math.max(max_length, right - left + 1);
        }

        return max_length;
    }
}
