/**
 * Problem: Integer to Roman (#12)
 * Date: 31-08-2026
 *
 * ------------------------------------------------------------
 * Approach: Greedy
 * ------------------------------------------------------------
 *
 * Observation:
 * - Roman numerals can be constructed by repeatedly taking
 *   the largest possible Roman value.
 * - Therefore, we store Roman symbols and their corresponding
 *   values in descending order.
 *
 * Important special cases:
 *
 *     900 -> CM
 *     400 -> CD
 *      90 -> XC
 *      40 -> XL
 *       9 -> IX
 *       4 -> IV
 *
 * These are included directly in the arrays.
 *
 * ------------------------------------------------------------
 *
 * Example:
 *
 * num = 1994
 *
 * 1994 >= 1000
 *     -> append M
 *     -> num = 994
 *
 * 994 >= 900
 *     -> append CM
 *     -> num = 94
 *
 * 94 >= 90
 *     -> append XC
 *     -> num = 4
 *
 * 4 >= 4
 *     -> append IV
 *     -> num = 0
 *
 * Answer:
 *
 *     MCMXCIV
 *
 * ------------------------------------------------------------
 *
 * Why Greedy?
 *
 * At every step, we choose the largest Roman numeral value
 * that can fit into the remaining number.
 *
 * Because the symbols are arranged from largest to smallest,
 * once we cannot use the current value, we simply move to
 * the next smaller value.
 *
 * ------------------------------------------------------------
 *
 * Time Complexity:
 * O(1)
 *
 * There are only 13 Roman numeral symbols in the arrays,
 * and the input range is limited (1 <= num <= 3999).
 *
 * More precisely, the loop performs a constant number of
 * operations for this problem.
 *
 * ------------------------------------------------------------
 *
 * Space Complexity:
 * O(1)
 *
 * The arrays contain a fixed number of 13 elements and the
 * StringBuilder stores at most a constant number of Roman
 * characters for the allowed input range.
 *
 * ------------------------------------------------------------
 */

class Solution {

    public String intToRoman(int num) {

        // Roman symbols arranged from largest to smallest
        // including subtractive combinations.
        String[] sym = {
            "M", "CM", "D", "CD", "C", "XC",
            "L", "XL", "X", "IX", "V", "IV", "I"
        };

        // Corresponding values
        int[] val = {
            1000, 900, 500, 400, 100, 90,
            50, 40, 10, 9, 5, 4, 1
        };

        StringBuilder sb = new StringBuilder();

        // Greedily take the largest possible value
        for (int i = 0; i < sym.length; i++) {

            // Use the current Roman symbol as many times
            // as possible.
            while (num >= val[i]) {

                sb.append(sym[i]);
                num -= val[i];
            }
        }

        return sb.toString();
    }
}