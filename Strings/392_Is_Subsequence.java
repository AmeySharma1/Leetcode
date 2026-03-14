/*
 * Problem: 392. Is Subsequence
 *
 * Idea:
 * - Do strings diye gaye hain:
 *      s (chhoti string)
 *      t (badi string)
 *
 * - Check karna hai ki kya s, t ka subsequence hai
 *
 * Subsequence matlab:
 * - Characters ka order same hona chahiye
 * - Lekin beech me characters skip kar sakte hain
 *
 * Example:
 * s = "abc"
 * t = "ahbgdc"
 *
 * a → match
 * b → match
 * c → match
 *
 * Output: true
 *
 * ----------------------------------------------------
 * Key Observation:
 *
 * - Hume s ke characters ko t me order ke saath dhundhna hai
 * - Agar s ka har character sequentially mil jata hai
 *   to s subsequence hai
 *
 * ----------------------------------------------------
 * Approach: Two Pointer Technique
 *
 * - Ek pointer s ke liye (i)
 * - Ek pointer t ke liye (j)
 *
 * - Agar characters match kare:
 *      i++
 *
 * - Har step par:
 *      j++ (t ko traverse karte rahenge)
 *
 * - Agar i == s.length ho gaya
 *      matlab s ke saare characters mil gaye
 *
 * ----------------------------------------------------
 * Algorithm:
 *
 * 1. Initialize:
 *      i = 0
 *      j = 0
 *
 * 2. While:
 *      i < s.length AND j < t.length
 *
 * 3. Compare characters:
 *
 *      Agar s[i] == t[j]
 *          i++
 *
 *      Har iteration me:
 *          j++
 *
 * 4. Loop end:
 *
 *      Agar i == s.length
 *          return true
 *
 *      warna return false
 *
 * ----------------------------------------------------
 * Dry Run:
 *
 * s = "abc"
 * t = "ahbgdc"
 *
 * i=0 j=0
 * a == a → i=1
 *
 * i=1 j=1
 * b != h → j++
 *
 * i=1 j=2
 * b == b → i=2
 *
 * i=2 j=3
 * c != g → j++
 *
 * i=2 j=4
 * c != d → j++
 *
 * i=2 j=5
 * c == c → i=3
 *
 * i == s.length
 *
 * Output:
 * true
 *
 * ----------------------------------------------------
 * Why It Works:
 *
 * - t ko ek baar traverse karte hain
 * - Jab bhi matching character milta hai
 *   s ka pointer aage badha dete hain
 *
 * - Agar s ke saare characters mil gaye
 *   to subsequence confirm ho jata hai
 *
 * ----------------------------------------------------
 * Time Complexity:
 *
 * O(n)
 *
 * n = length of t
 *
 * ----------------------------------------------------
 * Space Complexity:
 *
 * O(1)
 *
 * ----------------------------------------------------
 * Pattern:
 * Two Pointer / Subsequence Checking
 */

class Solution {
    public boolean isSubsequence(String s, String t) {

        int i = 0;
        int j = 0;

        while (i < s.length() && j < t.length()) {

            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }

            j++;
        }

        return i == s.length();
    }
}
