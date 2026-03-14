/*
 * Problem: 76. Minimum Window Substring
 *
 * Idea:
 * - Do strings diye gaye hain:
 *      s → main string
 *      t → target string
 *
 * - Hume s ka smallest substring find karna hai
 *   jo t ke saare characters contain kare
 *
 * - Characters ki frequency bhi important hai
 *
 * Example:
 *
 * s = "ADOBECODEBANC"
 * t = "ABC"
 *
 * Output:
 * "BANC"
 *
 * ----------------------------------------------------
 * Key Observation:
 *
 * - Hume smallest window find karna hai jisme
 *   t ke saare characters exist karein
 *
 * - Sliding Window technique perfect hai
 *
 * - Window expand karte hain jab tak required characters mil na jaye
 * - Fir window shrink karke minimum size find karte hain
 *
 * ----------------------------------------------------
 * Approach: Sliding Window + Frequency Array
 *
 * - Ek frequency array use karte hain
 *   jo t ke characters ki count store karta hai
 *
 * - requiredCount track karta hai
 *   ki kitne characters abhi match hone baaki hain
 *
 * Window Expansion:
 * - right pointer window expand karega
 *
 * Window Shrinking:
 * - jab saare characters mil jaye
 *   left pointer se window shrink karte hain
 *
 * ----------------------------------------------------
 * Algorithm:
 *
 * 1. Edge case:
 *      agar t.length > s.length
 *      return ""
 *
 * 2. Frequency array create karo:
 *      int freq[128]
 *
 * 3. t ke characters ka frequency store karo
 *
 * 4. Initialize:
 *      requiredCount = t.length
 *      i = 0 (left pointer)
 *      j = 0 (right pointer)
 *      minWindowSize = ∞
 *      start = 0
 *
 * 5. Traverse s using j pointer:
 *
 *      char ch = s[j]
 *
 *      agar freq[ch] > 0
 *          requiredCount--
 *
 *      freq[ch]--
 *
 * 6. Jab requiredCount == 0
 *      matlab valid window mil gaya
 *
 *      windowSize = j - i + 1
 *
 *      agar windowSize < minWindowSize
 *          update minWindowSize
 *          update start
 *
 * 7. Window shrink karo:
 *
 *      leftChar = s[i]
 *
 *      freq[leftChar]++
 *
 *      agar freq[leftChar] > 0
 *          requiredCount++
 *
 *      i++
 *
 * 8. j++ karke window expand karte raho
 *
 * 9. End me:
 *      agar minWindowSize update nahi hua
 *          return ""
 *
 *      warna substring return karo
 *
 * ----------------------------------------------------
 * Dry Run:
 *
 * s = "ADOBECODEBANC"
 * t = "ABC"
 *
 * First valid window:
 * "ADOBEC"
 *
 * Shrink karte hue better window milta hai:
 *
 * "BANC"
 *
 * Output:
 * "BANC"
 *
 * ----------------------------------------------------
 * Why It Works:
 *
 * - Sliding window dynamic window maintain karta hai
 * - requiredCount ensure karta hai ki
 *   t ke saare characters present hain
 * - Window shrink karke minimum substring detect hota hai
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
 * O(1)
 *
 * Frequency array size constant (128 ASCII)
 *
 * ----------------------------------------------------
 * Pattern:
 * Sliding Window + Frequency Counting
 */

class Solution {

    public String minWindow(String s, String t) {

        if (t.length() > s.length()) return "";

        int[] freq = new int[128];

        // store frequency of characters in t
        for (char c : t.toCharArray()) {
            freq[c]++;
        }

        int requiredCount = t.length();

        int i = 0, j = 0;

        int minWindowSize = Integer.MAX_VALUE;
        int start = 0;

        while (j < s.length()) {

            char ch = s.charAt(j);

            if (freq[ch] > 0) {
                requiredCount--;
            }

            freq[ch]--;

            // shrink window
            while (requiredCount == 0) {

                int windowSize = j - i + 1;

                if (windowSize < minWindowSize) {
                    minWindowSize = windowSize;
                    start = i;
                }

                char leftChar = s.charAt(i);

                freq[leftChar]++;

                if (freq[leftChar] > 0) {
                    requiredCount++;
                }

                i++;
            }

            j++;
        }

        if (minWindowSize == Integer.MAX_VALUE) {
            return "";
        }

        return s.substring(start, start + minWindowSize);
    }
}
