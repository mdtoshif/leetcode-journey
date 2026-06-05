// Problem: Happy Number (#202)
// Date: 05-06-2026

// Approach:
// Repeatedly replace the number with the sum of the
// squares of its digits.
//
// If the process reaches 1, the number is happy.
//
// If a previously seen sum appears again,
// we have entered a cycle and will never reach 1.
//
// Use a HashSet to track previously seen states.

// Example:
// 19
// 1² + 9² = 82
// 8² + 2² = 68
// 6² + 8² = 100
// 1² + 0² + 0² = 1
//
// Therefore, 19 is a Happy Number.

// Time Complexity: O(log n) per transformation
// Space Complexity: O(k)
// where k is the number of unique states before
// reaching 1 or entering a cycle.

import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean isHappy(int n) {

        Set<Integer> seen = new HashSet<>();

        int rem;
        int sum = 0;

        while (true) {

            rem = n % 10;
            sum += rem * rem;
            n /= 10;

            // Finished processing current number
            if (n == 0) {

                // Cycle detected
                if (!seen.add(sum)) {
                    return false;
                }

                // Happy Number found
                if (sum == 1) {
                    return true;
                }

                // Continue process with new number
                n = sum;
                sum = 0;
            }
        }
    }
}