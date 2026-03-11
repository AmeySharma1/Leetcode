/*
 * Problem: 1009. Complement of Base 10 Integer
 *
 * Idea:
 * - Kisi number ka bitwise complement nikalna hai
 * - Matlab har bit flip karni hai:
 *      0 → 1
 *      1 → 0
 *
 * Example:
 * 5 → binary = 101
 * complement = 010 → decimal = 2
 *
 * ----------------------------------------------------
 * Approach: Mask + XOR
 *
 * Steps:
 * 1. Number me kitne bits hain find karo
 * 2. Utne bits ka mask banao jisme sab bits 1 ho
 * 3. Original number ko mask ke saath XOR karo
 *
 * XOR flip property:
 *      1 ^ 1 = 0
 *      0 ^ 1 = 1
 *
 * ----------------------------------------------------
 * Algorithm:
 *
 * 1. Find number of bits:
 *      bits = floor(log2(n)) + 1
 *
 * 2. Create mask with all 1s:
 *      mask = (1 << bits) - 1
 *
 * Example:
 * n = 5 → bits = 3
 * mask = (1<<3) - 1 = 111
 *
 * 3. XOR with mask:
 *      answer = n ^ mask
 *
 * ----------------------------------------------------
 * Dry Run:
 *
 * n = 5
 *
 * binary:
 * n     = 101
 * mask  = 111
 *
 * XOR:
 * 101 ^ 111 = 010
 *
 * Output:
 * 2
 *
 * ----------------------------------------------------
 * Why It Works:
 * - Mask me sab bits 1 hain
 * - XOR operation bits flip kar deta hai
 *
 * ----------------------------------------------------
 * Time:  O(1)
 * Space: O(1)
 *
 * ----------------------------------------------------
 * Pattern:
 * Bit Manipulation / XOR Mask Technique
 */

class Solution {
    public int bitwiseComplement(int n) {

        int bits = (int)(Math.log(n) / Math.log(2)) + 1;

        int mask = (1 << bits) - 1;

        return n ^ mask;
    }
}
