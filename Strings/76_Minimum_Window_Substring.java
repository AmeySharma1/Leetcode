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
 * - Frequency of characters bhi maintain karni hogi
 *
 * ----------------------------------------------------
 * Key Observation:
 *
 * - Sliding Window technique use karte hain
 * - Window expand karte hain using right pointer
 * - Jab valid window mil jaye (saare characters present)
 *   to window shrink karke minimum window detect karte hain
 *
 * ----------------------------------------------------
 * Approach: Sliding Window + Two Frequency Arrays
 *
 * Do arrays use karte hain:
 *
 * mapT → t ke characters ki required frequency
 * mapS → current window ki frequency
 *
 * contains(mapS, mapT) function check karta hai:
 * - kya current window t ke saare characters contain karta hai
 *
 * ----------------------------------------------------
 * Algorithm:
 *
 * 1. Create two arrays:
 *      mapS[256]
 *      mapT[256]
 *
 * 2. t ke characters ki frequency mapT me store karo
 *
 * 3. Initialize pointers:
 *      left = 0
 *      right = 0
 *
 * 4. Track:
 *      minLen = ∞
 *      minStart = 0
 *
 * 5. Traverse string using right pointer:
 *
 *      mapS[s[right]]++
 *
 * 6. Jab current window valid ho:
 *      contains(mapS, mapT) == true
 *
 *      windowSize = right - left + 1
 *
 *      agar windowSize < minLen
 *          update minLen
 *          update minStart
 *
 * 7. Window shrink karo:
 *
 *      mapS[s[left]]--
 *      left++
 *
 * 8. Continue until right pointer end tak na pahunch jaye
 *
 * 9. End me:
 *
 *      agar minLen update nahi hua
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
 * first valid window:
 * "ADOBEC"
 *
 * shrink karte hue better window milta hai:
 *
 * "BANC"
 *
 * Output:
 * "BANC"
 *
 * ----------------------------------------------------
 * Why It Works:
 *
 * - Sliding window dynamic substring maintain karta hai
 * - mapT required frequencies store karta hai
 * - mapS current window track karta hai
 * - contains() check karta hai ki window valid hai ya nahi
 *
 * ----------------------------------------------------
 * Time Complexity:
 *
 * Outer traversal: O(n)
 *
 * contains() check: O(256)
 *
 * Total:
 * O(256 * n) ≈ O(n)
 *
 * ----------------------------------------------------
 * Space Complexity:
 *
 * O(256)
 *
 * ----------------------------------------------------
 * Pattern:
 * Sliding Window + Frequency Arrays
 */

class Solution {

    public String minWindow(String s, String t) {

        int[] mapS = new int[256];
        int[] mapT = new int[256];

        // Store frequency of characters in t
        for (char ch : t.toCharArray()) {
            mapT[ch]++;
        }

        int left = 0, right = 0;
        int minLen = Integer.MAX_VALUE;
        int minStart = 0;

        for (; right < s.length(); right++) {

            mapS[s.charAt(right)]++;

            while (contains(mapS, mapT)) {

                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minStart = left;
                }

                mapS[s.charAt(left++)]--;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }

    // Function to check if current window satisfies requirement
    private boolean contains(int[] mapS, int[] mapT) {

        for (int i = 0; i < 256; i++) {

            if (mapT[i] > mapS[i]) {
                return false;
            }
        }

        return true;
    }
}
