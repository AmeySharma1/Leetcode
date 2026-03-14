/*
 * Problem: 49. Group Anagrams
 *
 * Idea:
 * - Ek array of strings diya gaya hai
 * - Hume unhe groups me divide karna hai jahan har group me
 *   anagrams ho
 *
 * Anagram matlab:
 * - Words jinke characters same ho
 * - Bas unka order different ho sakta hai
 *
 * Example:
 * "eat", "tea", "ate" → anagrams
 *
 * ----------------------------------------------------
 * Example:
 *
 * Input:
 * ["eat","tea","tan","ate","nat","bat"]
 *
 * Output:
 * [
 *  ["eat","tea","ate"],
 *  ["tan","nat"],
 *  ["bat"]
 * ]
 *
 * ----------------------------------------------------
 * Key Observation:
 *
 * - Agar kisi word ke characters sort kar diye jaye
 * - To uska sorted version sab anagrams ke liye same hoga
 *
 * Example:
 *
 * "eat" → "aet"
 * "tea" → "aet"
 * "ate" → "aet"
 *
 * Same key → same group
 *
 * ----------------------------------------------------
 * Approach: HashMap + Sorting
 *
 * - Ek HashMap use karte hain:
 *
 *      key   → sorted string
 *      value → list of anagrams
 *
 * - Har word ke characters sort karke key banate hain
 * - Fir us key ke corresponding list me word add kar dete hain
 *
 * ----------------------------------------------------
 * Algorithm:
 *
 * 1. Create:
 *      Map<String, List<String>> map
 *
 * 2. Traverse each word in strs:
 *
 *      word → char array me convert karo
 *
 *      chars = word.toCharArray()
 *
 *      sort(chars)
 *
 *      sortedWord = new String(chars)
 *
 * 3. Check:
 *
 *      agar map me sortedWord key exist nahi karti
 *          new ArrayList create karo
 *
 * 4. Add:
 *
 *      map.get(sortedWord).add(word)
 *
 * 5. End me:
 *
 *      map.values() ko list me convert karke return karo
 *
 * ----------------------------------------------------
 * Dry Run:
 *
 * strs = ["eat","tea","tan","ate","nat","bat"]
 *
 * Process:
 *
 * "eat" → "aet" → map["aet"] = ["eat"]
 *
 * "tea" → "aet" → map["aet"] = ["eat","tea"]
 *
 * "tan" → "ant" → map["ant"] = ["tan"]
 *
 * "ate" → "aet" → map["aet"] = ["eat","tea","ate"]
 *
 * "nat" → "ant" → map["ant"] = ["tan","nat"]
 *
 * "bat" → "abt" → map["abt"] = ["bat"]
 *
 * Output:
 * [
 * ["eat","tea","ate"],
 * ["tan","nat"],
 * ["bat"]
 * ]
 *
 * ----------------------------------------------------
 * Why It Works:
 *
 * - Sorted string ek unique signature ban jata hai
 *   jo sab anagrams ke liye same hota hai
 *
 * - HashMap fast grouping allow karta hai
 *
 * ----------------------------------------------------
 * Time Complexity:
 *
 * n = number of strings
 * k = average length of string
 *
 * Sorting each word:
 * O(k log k)
 *
 * Total:
 * O(n * k log k)
 *
 * ----------------------------------------------------
 * Space Complexity:
 *
 * O(n * k)
 *
 * HashMap + result storage
 *
 * ----------------------------------------------------
 * Pattern:
 * Hashing + String Sorting (Anagram Grouping)
 */

import java.util.*;

class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();

        for (String word : strs) {

            char[] chars = word.toCharArray();

            Arrays.sort(chars);

            String sortedWord = new String(chars);

            if (!map.containsKey(sortedWord)) {
                map.put(sortedWord, new ArrayList<>());
            }

            map.get(sortedWord).add(word);
        }

        return new ArrayList<>(map.values());
    }
}
