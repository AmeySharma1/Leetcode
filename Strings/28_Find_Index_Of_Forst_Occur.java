/*
 * Problem: 28. Find the Index of the First Occurrence in a String
 *
 * Idea:
 * - Do strings diye gaye hain:
 *      haystack (main string)
 *      needle (search string)
 *
 * - Hume find karna hai ki needle haystack me first time kis index par appear hota hai
 * - Agar needle exist nahi karta to -1 return karna hai
 *
 * Example:
 * haystack = "sadbutsad"
 * needle   = "sad"
 *
 * Output: 0
 *
 * ----------------------------------------------------
 * Key Observation:
 *
 * - Hume haystack ke har possible starting index se
 *   needle ko match karne ki koshish karni hai
 *
 * - Agar kisi index se poora needle match ho jaye
 *   to wahi answer hai
 *
 * ----------------------------------------------------
 * Approach: Brute Force String Matching
 *
 * - Outer loop haystack ke har possible starting index par chalega
 * - Inner loop needle ke characters ko compare karega
 *
 * - Agar mismatch ho jaye:
 *      next starting index try karte hain
 *
 * - Agar needle ke saare characters match ho gaye:
 *      current index return kar dete hain
 *
 * ----------------------------------------------------
 * Algorithm:
 *
 * 1. Let:
 *      m = haystack.length()
 *      n = needle.length()
 *
 * 2. Loop i from 0 → m - n:
 *
 *      Har index se substring match try karte hain
 *
 * 3. Inner loop j from 0 → n-1:
 *
 *      Compare:
 *      haystack[i + j] with needle[j]
 *
 *      Agar mismatch ho:
 *          break
 *
 * 4. Agar j == n-1 tak match ho gaya:
 *      return i
 *
 * 5. Agar poora haystack check ho gaya
 *      return -1
 *
 * ----------------------------------------------------
 * Dry Run:
 *
 * haystack = "hello"
 * needle   = "ll"
 *
 * m = 5
 * n = 2
 *
 * i = 0
 * "he" vs "ll" → mismatch
 *
 * i = 1
 * "el" vs "ll" → mismatch
 *
 * i = 2
 * "ll" vs "ll" → match
 *
 * Output:
 * 2
 *
 * ----------------------------------------------------
 * Why It Works:
 *
 * - Har possible starting position check kiya
 * - Needle ke saare characters match hone par
 *   immediately index return kar diya
 *
 * ----------------------------------------------------
 * Time Complexity:
 *
 * Worst Case:
 * O(m * n)
 *
 * Example worst case:
 * haystack = "aaaaaa"
 * needle   = "aaaab"
 *
 * ----------------------------------------------------
 * Space Complexity:
 *
 * O(1)
 *
 * ----------------------------------------------------
 * Pattern:
 * String Matching / Substring Search
 */

class Solution {
    public int strStr(String str1, String str2) {

        int m = str1.length();
        int n = str2.length();

        for (int i = 0; i <= m - n; i++) {

            for (int j = 0; j < n; j++) {

                if (str1.charAt(i + j) != str2.charAt(j)) {
                    break;
                }

                if (j == n - 1) {
                    return i;
                }
            }
        }

        return -1;
    }
}
