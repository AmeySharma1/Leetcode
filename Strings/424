/*
 * Problem: 424. Longest Repeating Character Replacement
 *
 * Idea:
 * - Ek string s di hui hai (uppercase letters)
 * - Ek integer k diya hai
 *
 * - Hum maximum k characters replace kar sakte hain
 *
 * - Hume longest substring find karni hai
 *   jise replace karke ek hi character se bana sakte hain
 *
 * Example:
 *      s = "AABABBA"
 *      k = 1
 *
 * - Hum ek character replace karke
 *   longest repeating substring bana sakte hain
 *
 * ----------------------------------------------------
 * Key Observation:
 *
 * - Agar ek window me characters different hain
 *   to unhe same banane ke liye replacements chahiye
 *
 * - Suppose window me:
 *
 *      windowLength = total characters
 *      maxFreq = most frequent character
 *
 * - Baaki characters replace karne padenge
 *
 *      replacements needed =
 *      windowLength - maxFreq
 *
 * - Agar replacements <= k
 *      to window valid hai
 *
 * - Agar replacements > k
 *      to window shrink karni padegi
 *
 * ----------------------------------------------------
 * Approach: Sliding Window + Frequency Array
 *
 * - freq[26] array use karte hain
 *   characters ki frequency track karne ke liye
 *
 * - Sliding window maintain karte hain
 *
 * Variables:
 *
 *      left → window start
 *      right → window end
 *      maxFreq → window me kisi character ki
 *                maximum frequency
 *
 * ----------------------------------------------------
 * Algorithm:
 *
 * 1. Create frequency array
 *
 *      freq[26]
 *
 * 2. Initialize:
 *
 *      left = 0
 *      maxFreq = 0
 *      maxWindow = 0
 *
 * 3. Traverse string using right pointer
 *
 * 4. Update frequency:
 *
 *      freq[s[right] - 'A']++
 *
 * 5. Update max frequency
 *
 *      maxFreq = max(maxFreq, freq[s[right] - 'A'])
 *
 * 6. Calculate window length
 *
 *      windowLength = right - left + 1
 *
 * 7. If replacements needed > k
 *
 *      windowLength - maxFreq > k
 *
 *      shrink window:
 *
 *      freq[s[left] - 'A']--
 *      left++
 *
 * 8. Update maximum window
 *
 *      maxWindow = max(maxWindow, windowLength)
 *
 * 9. Continue until end of string
 *
 * 10. Return maxWindow
 *
 * ----------------------------------------------------
 * Dry Run:
 *
 * s = "AABABBA"
 * k = 1
 *
 * Window grows:
 *
 * "A"
 * "AA"
 * "AAB"
 * "AABA"
 *
 * Valid because replacements <= 1
 *
 * Best window found:
 *
 * "AABA" → replace B with A
 *
 * Length = 4
 *
 * ----------------------------------------------------
 * Why It Works:
 *
 * - Sliding window dynamically substring track karta hai
 * - maxFreq batata hai ki kaunsa character dominate kar raha hai
 * - Baaki characters replace karke
 *   repeating substring ban sakti hai
 *
 * ----------------------------------------------------
 * Time Complexity:
 *
 * O(n)
 *
 * Har character ek baar window me enter aur exit hota hai
 *
 * ----------------------------------------------------
 * Space Complexity:
 *
 * O(26)
 *
 * Constant space for frequency array
 *
 * ----------------------------------------------------
 * Pattern:
 *
 * Sliding Window + Frequency Counting
 */

class Solution {

    public int characterReplacement(String s, int k) {

        int[] freq = new int[26];
        int left = 0;
        int maxFreq = 0;
        int maxWindow = 0;

        for (int right = 0; right < s.length(); right++) {

            // Update frequency
            freq[s.charAt(right) - 'A']++;

            // Update max frequency
            maxFreq = Math.max(maxFreq, freq[s.charAt(right) - 'A']);

            int windowLength = right - left + 1;

            // If replacements exceed k, shrink window
            if (windowLength - maxFreq > k) {

                freq[s.charAt(left) - 'A']--;
                left++;
            }

            windowLength = right - left + 1;
            maxWindow = Math.max(maxWindow, windowLength);
        }

        return maxWindow;
    }
}
