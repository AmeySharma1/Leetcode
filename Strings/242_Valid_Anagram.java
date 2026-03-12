/*
 * Problem: 242. Valid Anagram
 *
 * Idea:
 * - Do strings s aur t diye gaye hain
 * - Check karna hai ki kya dono strings ek dusre ke anagram hain
 * - Anagram ka matlab: dono strings me same characters hone chahiye
 *   aur unki frequency bhi same honi chahiye
 *
 * ----------------------------------------------------
 * Key Observation:
 *
 * - Agar strings anagram hain to:
 *      frequency of every character in s
 *      == frequency of that character in t
 *
 * - Kyunki problem me lowercase letters ('a' to 'z') hain,
 *   hum 26 size ka frequency array use kar sakte hain
 *
 * ----------------------------------------------------
 * Approach: Frequency Counting
 *
 * - Ek integer array arr[26] banate hain
 * - Pehle string s ke characters ka count increase karte hain
 * - Phir string t ke characters ka count decrease karte hain
 *
 * - Agar dono strings same frequency share karte hain
 *   to final array ke saare values 0 honge
 *
 * ----------------------------------------------------
 * Algorithm:
 *
 * 1. Check length:
 *      agar s.length != t.length
 *      return false
 *
 * 2. Create frequency array:
 *      int arr[26]
 *
 * 3. Traverse string s:
 *      arr[s.charAt(i) - 'a']++
 *
 * 4. Traverse string t:
 *      arr[t.charAt(i) - 'a']--
 *
 * 5. Check frequency array:
 *      agar koi bhi value != 0
 *      return false
 *
 * 6. Agar sab 0 hain:
 *      return true
 *
 * ----------------------------------------------------
 * Dry Run:
 *
 * s = "anagram"
 * t = "nagaram"
 *
 * Frequency after s:
 * a=3, n=1, g=1, r=1, m=1
 *
 * After subtracting t:
 * saare counts 0 ho jate hain
 *
 * Output:
 * true
 *
 * Example 2:
 *
 * s = "rat"
 * t = "car"
 *
 * frequencies match nahi hoti
 *
 * Output:
 * false
 *
 * ----------------------------------------------------
 * Alternative Approach (Sorting):
 *
 * - Dono strings ko character array me convert karo
 * - Dono arrays sort karo
 * - Agar sorted arrays equal hain → anagram
 *
 * Time: O(n log n)
 *
 * ----------------------------------------------------
 * Why Frequency Method Better:
 *
 * - Sorting se faster hai
 * - Linear time me kaam ho jata hai
 *
 * ----------------------------------------------------
 * Time Complexity:
 * O(n)
 *
 * Space Complexity:
 * O(1)
 * (26 constant size array)
 *
 * ----------------------------------------------------
 * Pattern:
 * String Frequency Counting / Hashing
 */

class Solution {
    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length())
            return false;

        int[] arr = new int[26];

        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            arr[t.charAt(i) - 'a']--;
        }

        for (int check : arr) {
            if (check != 0)
                return false;
        }

        return true;
    }
}

// Another less optimal way but Time complexity: O(nlogn) due to sorting
import java.util.Arrays;

class Solution {
    public boolean isAnagram(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        
        Arrays.sort(sChars);
        Arrays.sort(tChars);
        
        return Arrays.equals(sChars, tChars);
    }
}
