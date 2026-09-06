/**
 * Problem: XOR Operation in an Array (#1486)
 * Date: 06-09-2026
 *
 * ------------------------------------------------------------
 * Approach: Bit Manipulation - XOR
 * ------------------------------------------------------------
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * ------------------------------------------------------------
 */

class Solution {
    public int xorOperation(int n, int start) {
        int xOr = start;

        for(int i = 1; i < n; i++) {
            xOr ^= (start + (2 * i));
        }

        return xOr;
    }
}