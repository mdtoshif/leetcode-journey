/**
 * Problem: Minimum Bit Flips to Convert Number (#2220)
 * Date: 04-09-2026
 *
 * ------------------------------------------------------------
 * Approach: Bit Manipulation - XOR
 * ------------------------------------------------------------
 *
 * Time Complexity:
 * O(log(max(start, goal)))
 *
 * We check each bit of the XOR result.
 *
 * ------------------------------------------------------------
 *
 * Space Complexity:
 * O(1)
 *
 * ------------------------------------------------------------
 */

class Solution {

    public int minBitFlips(int start, int goal) {

        // XOR gives 1 wherever the bits are different
        int ans = start ^ goal;

        int cnt = 0;

        // Count the number of set bits
        while (ans != 0) {

            // Check the last bit
            cnt += (ans & 1);

            // Remove the last bit
            ans = ans >> 1;
        }

        return cnt;
    }
}