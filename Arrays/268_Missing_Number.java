/*
 * Problem: 268. Missing Number
 *
 * Idea:
 * - Array me numbers 0 se n tak hone chahiye
 * - Ek number missing hai
 * - XOR ka property use karenge
 *
 * ----------------------------------------------------
 * XOR Properties:
 *
 * 1. a ^ a = 0
 * 2. a ^ 0 = a
 * 3. XOR commutative & associative hota hai
 *
 * Matlab:
 * - Same numbers cancel ho jate hain
 * - Sirf missing number bachega
 *
 * ----------------------------------------------------
 * Approach: XOR Trick
 *
 * - Pehle 1 se n tak sabka XOR karo
 * - Fir array ke saare elements ka XOR karo
 * - Same elements cancel ho jayenge
 * - Missing number bachega
 *
 * ----------------------------------------------------
 * Algorithm:
 *
 * 1. Initialize:
 *      ans = 0
 *
 * 2. XOR all numbers from 1 to n:
 *      for i = 1 to n:
 *          ans ^= i
 *
 * 3. XOR all array elements:
 *      for each num in nums:
 *          ans ^= num
 *
 * 4. Return ans
 *
 * ----------------------------------------------------
 * Dry Run:
 *
 * nums = [3,0,1]
 *
 * n = 3
 *
 * XOR 1..3:
 * ans = 1 ^ 2 ^ 3
 *
 * XOR with array:
 * ans ^= 3 ^ 0 ^ 1
 *
 * Cancel pairs:
 * (1^1), (3^3)
 *
 * Remaining:
 * 2
 *
 * Output:
 * 2
 *
 * ----------------------------------------------------
 * Why It Works:
 * - Har number 1..n do baar appear hota hai
 * - Missing number ek baar hi appear hota hai
 * - XOR duplicate cancel kar deta hai
 *
 * ----------------------------------------------------
 * Time:  O(n)
 * Space: O(1)
 *
 * ----------------------------------------------------
 * Pattern:
 * Bit Manipulation / XOR Cancellation Trick
 */

public class Solution {
    public int missingNumber(int[] nums) {

        int n = nums.length;
        int ans = 0;

        // XOR from 1 to n
        for (int i = 1; i <= n; i++) {
            ans ^= i;
        }

        // XOR all array elements
        for (int i = 0; i < nums.length; i++) {
            ans ^= nums[i];
        }

        return ans;
    }
}
