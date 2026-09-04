/**
 * Problem: Even and Odd Bits (#2595)
 * Date: 04-09-2026
 *
 * ------------------------------------------------------------
 * Approach: Bit Manipulation
 * ------------------------------------------------------------
 *
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 * ------------------------------------------------------------
 */

class Solution {
    public int[] evenOddBit(int n) {
        int check = 0;
        int[] ans = new int[2];

        while(n != 0) {
            if((n & 1) == 1) {   // odd --> means bit is set
                if((check & 1) == 0) ans[0]++; // even if increase
                else ans[1]++;
            }

            n = n >> 1;
            check++;
        }

        return ans;
    }
}