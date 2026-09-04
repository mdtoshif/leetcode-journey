/**
 * Problem: Counting Bits (#338)
 * Date: 04-09-2026
 *
 * ------------------------------------------------------------
 * Approach: Bit Manipulation - Brian Kernighan's Algorithm
 * ------------------------------------------------------------
 *
 * Time Complexity:
 * O(n log n) in the worst case
 *
 * Space Complexity:
 * O(n) for the answer array
 * ------------------------------------------------------------
 */

class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n+1];

        for(int i = 0; i <= n; i++) {
            int cnt = 0;
            int num = i;

            while(num != 0) {
                // Removes the rightmost set bit
                num = num & (num - 1);
                cnt++;
            }

            ans[i] = cnt;
        }

        return ans;
    }
}