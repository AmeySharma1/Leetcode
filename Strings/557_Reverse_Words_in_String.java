/*
 * Problem: 557. Reverse Words in a String III
 *
 * Idea:
 * - Ek sentence diya gaya hai jisme words spaces se separated hain
 * - Hume har word ko individually reverse karna hai
 * - Lekin words ka order same rehna chahiye
 *
 * Example:
 * Input:  "Let's take LeetCode contest"
 * Output: "s'teL ekat edoCteeL tsetnoc"
 *
 * ----------------------------------------------------
 * Key Observation:
 *
 * - Words ka order change nahi karna
 * - Sirf har word ke characters reverse karne hain
 *
 * - Space ' ' ek natural boundary hai jo words ko separate karta hai
 *
 * ----------------------------------------------------
 * Approach: Two Pointer + In-place Reversal
 *
 * 1. String ko char array me convert karte hain
 *    taaki characters directly modify kiye ja sakein
 *
 * 2. Do pointers use karte hain:
 *      start → current word ka starting index
 *      end   → traversal pointer
 *
 * 3. Jab bhi:
 *      - space milta hai
 *      - ya string end hota hai
 *
 *    tab start se end-1 tak word reverse kar dete hain
 *
 * ----------------------------------------------------
 * Algorithm:
 *
 * 1. Convert string to char array:
 *      char[] chars = s.toCharArray()
 *
 * 2. Initialize:
 *      start = 0
 *
 * 3. Traverse using end pointer:
 *
 *      for end = 0 → length
 *
 *      Agar:
 *          end == length
 *          OR
 *          chars[end] == ' '
 *
 *      to:
 *          reverse(chars, start, end-1)
 *
 *          start = end + 1
 *
 * 4. End me:
 *      new String(chars) return karo
 *
 * ----------------------------------------------------
 * Dry Run:
 *
 * Input:
 * "God Ding"
 *
 * chars = [G o d _ D i n g]
 *
 * start = 0
 *
 * end = 3 → space
 * reverse(0,2)
 *
 * becomes:
 * "doG Ding"
 *
 * start = 4
 *
 * end = 8 (length)
 * reverse(4,7)
 *
 * becomes:
 * "doG gniD"
 *
 * Output:
 * "doG gniD"
 *
 * ----------------------------------------------------
 * Why It Works:
 *
 * - Space ko boundary ki tarah treat kiya
 * - Har boundary par ek word reverse kar diya
 * - Char array use karne se in-place modification possible hua
 *
 * ----------------------------------------------------
 * Time Complexity:
 *
 * O(n)
 *
 * n = length of string
 *
 * Har character maximum 2 times process hota hai
 *
 * ----------------------------------------------------
 * Space Complexity:
 *
 * O(n)
 *
 * Char array banane ke liye
 *
 * ----------------------------------------------------
 * Pattern:
 * Two Pointer + In-place String Reversal
 */

class Solution {

    public String reverseWords(String s) {

        // Convert string to char array
        char[] chars = s.toCharArray();

        int start = 0;
        int end;

        for (end = 0; end <= chars.length; end++) {

            // When we reach space or end of string
            if (end == chars.length || chars[end] == ' ') {

                reverse(chars, start, end - 1);

                // Move start to next word
                start = end + 1;
            }
        }

        return new String(chars);
    }

    // Helper method to reverse characters in-place
    private void reverse(char[] c, int start, int end) {

        while (start < end) {

            char temp = c[end];
            c[end] = c[start];
            c[start] = temp;

            start++;
            end--;
        }
    }
}
