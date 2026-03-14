/*
 * Problem: 5. Longest Palindromic Substring
 *
 * Idea:
 * - Ek string s diya gaya hai
 * - Hume uska longest substring find karna hai jo palindrome ho
 *
 * Palindrome matlab:
 * - String reverse karne par bhi same rahe
 *
 * Example:
 * s = "babad"
 *
 * Possible palindromes:
 * "bab"
 * "aba"
 *
 * Output: "bab" or "aba"
 *
 * ----------------------------------------------------
 * Key Observation:
 *
 * - Har substring ko check kar sakte hain ki woh palindrome hai ya nahi
 * - Agar palindrome hai aur uski length current max se badi hai
 *   to answer update kar dete hain
 *
 * ----------------------------------------------------
 * Approach: Brute Force + Recursion (Palindrome Check)
 *
 * 1. Har possible substring generate karte hain
 * 2. Ek recursive function se check karte hain ki substring palindrome hai ya nahi
 *
 * ----------------------------------------------------
 * Palindrome Check Logic:
 *
 * solve(s, i, j)
 *
 * Base Case:
 *      agar i >= j
 *      return true
 *
 * Matching Case:
 *      agar s[i] == s[j]
 *      check inner substring:
 *      solve(i+1, j-1)
 *
 * Mismatch:
 *      return false
 *
 * ----------------------------------------------------
 * Algorithm:
 *
 * 1. Initialize:
 *      maxLen = 0
 *      startPoint = 0
 *
 * 2. Outer loop:
 *      i from 0 → n-1
 *
 * 3. Inner loop:
 *      j from i → n-1
 *
 * 4. Check:
 *      agar substring (i,j) palindrome hai
 *
 *      aur (j-i+1) > maxLen
 *
 *      to:
 *          maxLen update karo
 *          startPoint update karo
 *
 * 5. End me:
 *      s.substring(startPoint, startPoint + maxLen)
 *
 * ----------------------------------------------------
 * Dry Run:
 *
 * s = "babad"
 *
 * substrings:
 *
 * "b" → palindrome
 * "ba" → not
 * "bab" → palindrome (len=3)
 *
 * maxLen = 3
 *
 * "aba" → palindrome (len=3)
 *
 * Output:
 * "bab" or "aba"
 *
 * ----------------------------------------------------
 * Why It Works:
 *
 * - Har substring ko check kiya
 * - Recursive palindrome check inner characters compare karta hai
 *
 * ----------------------------------------------------
 * Time Complexity:
 *
 * Substrings = O(n²)
 * Palindrome check = O(n)
 *
 * Total:
 * O(n³)
 *
 * ----------------------------------------------------
 * Space Complexity:
 *
 * O(n) recursion stack
 *
 * ----------------------------------------------------
 * Pattern:
 * Brute Force + Recursion + Palindrome Checking
 */

class Solution {

    // Recursive function to check if substring is palindrome
    public boolean solve(String s, int i, int j) {

        if (i >= j) {
            return true;
        }

        if (s.charAt(i) == s.charAt(j)) {
            return solve(s, i + 1, j - 1);
        }

        return false;
    }

    public String longestPalindrome(String s) {

        int n = s.length();

        int maxLen = 0;
        int startPoint = 0;

        for (int i = 0; i < n; i++) {

            for (int j = i; j < n; j++) {

                if (solve(s, i, j)) {

                    if (j - i + 1 > maxLen) {
                        maxLen = j - i + 1;
                        startPoint = i;
                    }
                }
            }
        }

        return s.substring(startPoint, startPoint + maxLen);
    }
}
