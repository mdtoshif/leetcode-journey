/**
 * Problem: String to Integer (atoi) (#8)
 * Date: 07-08-2026
 *
 * ------------------------------------------------------------
 * Approach (Recursive)
 * ------------------------------------------------------------
 *
 * Time Complexity:
 * O(N)
 *
 * - Each character is processed at most once.
 *
 * Space Complexity:
 * O(N)

 */

class Solution {

    private int helper(int i, String s, long num, int sign) {

        // Base case:
        // Stop when the string ends or a non-digit is found.
        if (i >= s.length() || !Character.isDigit(s.charAt(i))) {
            return (int)(sign * num);
        }

        // Add the current digit to the number
        num = num * 10 + (s.charAt(i) - '0');

        // Check for integer overflow
        if ((sign * num) <= Integer.MIN_VALUE)
            return Integer.MIN_VALUE;

        if ((sign * num) >= Integer.MAX_VALUE)
            return Integer.MAX_VALUE;

        // Process the next character recursively
        return helper(i + 1, s, num, sign);
    }

    public int myAtoi(String s) {

        // ---------------- Recursive Approach ----------------

        int i = 0;
        int sign = 1;

        // Skip leading spaces
        while (i < s.length() && s.charAt(i) == ' ') {
            i++;
        }

        // Determine the sign
        if (i < s.length() &&
            (s.charAt(i) == '-' || s.charAt(i) == '+')) {

            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }

        // Start recursive digit processing
        return helper(i, s, 0, sign);


        // ---------------- Iterative Approach ----------------
        /*
        int i = 0;
        int sign = 1;

        while (i < s.length() && s.charAt(i) == ' ') {
            i++;
        }

        if (i < s.length() &&
            (s.charAt(i) == '-' || s.charAt(i) == '+')) {

            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }

        long res = 0;

        while (i < s.length() && Character.isDigit(s.charAt(i))) {

            res = res * 10 + (s.charAt(i) - '0');

            if (sign * res < Integer.MIN_VALUE)
                return Integer.MIN_VALUE;

            if (sign * res > Integer.MAX_VALUE)
                return Integer.MAX_VALUE;

            i++;
        }

        return (int)(sign * res);
        */
    }
}