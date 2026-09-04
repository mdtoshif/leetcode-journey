/**
 * Problem: Number of 1 Bits (#191)
 * Date: 04-09-2026
 *
 * ------------------------------------------------------------
 * Approach: Bit Manipulation
 * ------------------------------------------------------------
 *
 * Time Complexity: O(32) = O(1)
 * Space Complexity: O(1)
 * ------------------------------------------------------------
 */

class Solution {

    public int hammingWeight(int n) {

        int cnt = 0;

        while(n != 0) {

            // Check whether the rightmost bit is 1
            cnt += n & 1;

            // Move to the next bit
            n = n >> 1;
        }

        return cnt;
    }

}