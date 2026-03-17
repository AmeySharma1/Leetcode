/*
 * Problem: 647. Palindromic Substrings
 *
 * Idea:
 * - Ek string s di hui hai
 *
 * - Hume count karna hai total substrings jo palindrome ho
 *
 * - Palindrome matlab:
 *      string jo reverse karne par same rahe
 *
 * Examples:
 *      "aba"
 *      "aa"
 *      "racecar"
 *
 * - Har character ek palindrome hota hai
 *
 * ----------------------------------------------------
 * Key Observation:
 *
 * - Har palindrome ka ek center hota hai
 *
 * 2 types ke centers hote hain:
 *
 * 1. Odd Length Palindrome
 *      Example: "aba"
 *      center = b
 *
 * 2. Even Length Palindrome
 *      Example: "abba"
 *      center = between bb
 *
 * - Har index ko center maan kar
 *   palindrome expand kar sakte hain
 *
 * ----------------------------------------------------
 * Approach: Expand Around Center
 *
 * Har index i ke liye:
 *
 * 1. Odd palindrome check karo
 *      left = i
 *      right = i
 *
 * 2. Even palindrome check karo
 *      left = i
 *      right = i + 1
 *
 * Agar characters match karte hain:
 *
 *      s[left] == s[right]
 *
 * to palindrome mil gaya
 *
 * phir expand karte hain
 *
 *      left--
 *      right++
 *
 * Jab tak match hota rahe tab tak expand karte rahenge
 *
 * ----------------------------------------------------
 * Algorithm:
 *
 * 1. Initialize:
 *
 *      count = 0
 *
 * 2. Loop through string:
 *
 *      for i = 0 → n-1
 *
 * 3. Odd length palindrome check:
 *
 *      count += countPalindromes(s, i, i)
 *
 * 4. Even length palindrome check:
 *
 *      count += countPalindromes(s, i, i + 1)
 *
 * 5. countPalindromes function:
 *
 *      while
 *      left >= 0
 *      right < s.length()
 *      s[left] == s[right]
 *
 *          count++
 *          left--
 *          right++
 *
 * 6. Return total count
 *
 * ----------------------------------------------------
 * Dry Run:
 *
 * s = "aaa"
 *
 * i = 0
 *
 * odd:
 * "a"
 *
 * even:
 * "aa"
 *
 * i = 1
 *
 * odd:
 * "a"
 * "aaa"
 *
 * even:
 * "aa"
 *
 * i = 2
 *
 * odd:
 * "a"
 *
 * Total palindromes:
 *
 * "a"
 * "a"
 * "a"
 * "aa"
 * "aa"
 * "aaa"
 *
 * Answer = 6
 *
 * ----------------------------------------------------
 * Why It Works:
 *
 * - Har palindrome ka center hota hai
 * - Har center se outward expand karte hain
 * - Jab characters match karte hain to palindrome milta hai
 * - Isse sab possible palindromes efficiently mil jate hain
 *
 * ----------------------------------------------------
 * Time Complexity:
 *
 * Outer loop: O(n)
 *
 * Expansion worst case: O(n)
 *
 * Total:
 *
 * O(n²)
 *
 * ----------------------------------------------------
 * Space Complexity:
 *
 * O(1)
 *
 * Koi extra data structure use nahi ho raha
 *
 * ----------------------------------------------------
 * Pattern:
 *
 * Expand Around Center
 */

class Solution {

    public int countSubstrings(String s) {

        int count = 0;

        for (int i = 0; i < s.length(); i++) {

            // Count palindromes with odd length
            count += countPalindromes(s, i, i);

            // Count palindromes with even length
            count += countPalindromes(s, i, i + 1);
        }

        return count;
    }

    private int countPalindromes(String s, int left, int right) {

        int count = 0;

        while (left >= 0 && right < s.length()
                && s.charAt(left) == s.charAt(right)) {

            count++;

            left--;
            right++;
        }

        return count;
    }
}
