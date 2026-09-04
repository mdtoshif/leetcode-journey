/**
 * Problem: Divide Two Integers (#29)
 * Date: 04-09-2026
 *
 * ------------------------------------------------------------
 * Approach: Bit Manipulation
 * ------------------------------------------------------------
 *
 * Time Complexity: O(log |dividend| * log |dividend|)
 * Space Complexity: O(1)
 * ------------------------------------------------------------
 */

class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend == divisor) return 1;

        char sign = ((dividend < 0 && divisor > 0) || (dividend >0 && divisor<0)) ? '-' : '+';

        long ans = 0;
        long d = Math.abs((long)divisor); // denominator
        long n = Math.abs((long)dividend); // numerator

        while(n >= d) {
            int i = 0;

            while((d << (i+1)) <= n) {
                i++;
            }

            ans = ans + (1 << i);
            n-= (d<<i);
        }

        if(ans == (1<<31) && sign == '+') return Integer.MAX_VALUE;
        if(ans == (1<<31) && sign == '-') return Integer.MIN_VALUE;

        return (sign == '-') ? (int)(-ans) : (int)(ans);
    }
}