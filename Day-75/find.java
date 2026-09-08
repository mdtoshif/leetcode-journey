/**
 * Problem: Find Greatest Common Divisor of Array (#1979)
 * Date: 08-09-2026
 *
 * ------------------------------------------------------------
 * Approach: Finding Minimum & Maximum + Euclidean Algorithm
 *
 * Time Complexity:
 * O(n + log(max(nums)))
 *
 * O(n) to find minimum and maximum.
 * O(log(max(nums))) for the Euclidean Algorithm.
 *
 * Space Complexity: O(1)
 * ------------------------------------------------------------
 */

class Solution {
    public int findGCD(int[] nums) {
        int mini = Integer.MAX_VALUE;
        int maxi = Integer.MIN_VALUE;

        // Find minimum and maximum elements
        for(int elem : nums) {
            if(elem > maxi) {
                maxi = elem;
            }
            if(mini > elem) {
                mini = elem;
            }
        }

        // gcd(a, b)

        // Apply Euclidean Algorithm
        while(maxi > 0 && mini > 0) {
            if(maxi > mini) {
                maxi = maxi % mini;
            } else {
                mini = mini % maxi;
            }
        }

        // The non-zero value is the GCD
        if(maxi == 0) return mini;
        return maxi;
    }
}