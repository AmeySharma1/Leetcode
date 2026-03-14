/*
 * Problem: 387. First Unique Character in a String
 *
 * Idea:
 * - Ek string s diya gaya hai
 * - Hume first character ka index return karna hai jo repeat nahi hota
 * - Agar koi unique character nahi hai to -1 return karna hai
 *
 * Example:
 * s = "leetcode"
 * l → unique
 *
 * Output: 0
 *
 * Example:
 * s = "loveleetcode"
 *
 * l → repeat
 * o → repeat
 * v → unique
 *
 * Output: 2
 *
 * ----------------------------------------------------
 * Key Observation:
 *
 * - Pehle characters ki frequency store karni padegi
 * - Fir string traverse karke first character dhundhna hai
 *   jiska frequency 1 ho
 *
 * ----------------------------------------------------
 * Approach 1: HashMap Frequency Counting
 *
 * - HashMap<Character,Integer> use karte hain
 * - Har character ki frequency store karte hain
 *
 * Steps:
 *
 * 1. String ko char array me convert karo
 * 2. HashMap me frequency store karo
 * 3. Fir dobara string traverse karo
 * 4. Agar frequency == 1 mile to index return karo
 *
 * ----------------------------------------------------
 * Approach 2: Frequency Array (Optimized)
 *
 * - Kyunki characters lowercase letters hain
 * - Hum direct 26 size ka array use kar sakte hain
 *
 * - arr[i] store karega:
 *      frequency of character (i + 'a')
 *
 * ----------------------------------------------------
 * Algorithm (Frequency Array):
 *
 * 1. Create:
 *      int arr[26]
 *
 * 2. First traversal:
 *      arr[s.charAt(i) - 'a']++
 *
 * 3. Second traversal:
 *      agar arr[s.charAt(i)-'a'] == 1
 *      return i
 *
 * 4. Agar koi unique character nahi mila
 *      return -1
 *
 * ----------------------------------------------------
 * Dry Run:
 *
 * s = "loveleetcode"
 *
 * frequencies:
 *
 * l = 2
 * o = 2
 * v = 1
 * e = 4
 * t = 1
 * c = 1
 * d = 1
 *
 * traverse:
 *
 * l → not unique
 * o → not unique
 * v → unique
 *
 * Output:
 * 2
 *
 * ----------------------------------------------------
 * Why It Works:
 *
 * - First pass frequency store karta hai
 * - Second pass first non-repeating character detect karta hai
 *
 * ----------------------------------------------------
 * Time Complexity:
 *
 * O(n)
 *
 * ----------------------------------------------------
 * Space Complexity:
 *
 * HashMap Approach → O(n)
 * Frequency Array → O(1)
 *
 * ----------------------------------------------------
 * Pattern:
 * String Frequency Counting / Hashing
 */

import java.util.HashMap;

class Solution {

    // ------------------------------
    // Method 1: HashMap Approach
    // ------------------------------
    public int firstUniqCharHashMap(String s) {

        char[] st = s.toCharArray();

        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : st) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < st.length; i++) {
            if (map.get(st[i]) == 1) {
                return i;
            }
        }

        return -1;
    }

    // ------------------------------
    // Method 2: Frequency Array
    // ------------------------------
    public int firstUniqChar(String s) {

        int[] arr = new int[26];

        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (arr[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }
}
