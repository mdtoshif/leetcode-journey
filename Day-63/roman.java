/**
 * Problem: Roman to Integer (#13)
 * Date: 13-08-2026
 *
 * ------------------------------------------------------------
 * Approach (HashMap + Comparison)
 * ------------------------------------------------------------
 *
 * Observation:
 * - Store the value of each Roman numeral in a HashMap.
 * - Traverse the string from left to right.
 * - Compare the current Roman numeral with the next one.
 *
 * Rules:
 *
 * 1. If current value < next value:
 *      subtract current value.
 *
 *      Example:
 *      IV = -1 + 5 = 4
 *
 * 2. Otherwise:
 *      add current value.
 *
 *      Example:
 *      VI = 5 + 1 = 6
 *
 * - The last character is always added separately because
 *   the main loop compares every character with its next
 *   character.
 *
 * ------------------------------------------------------------
 *
 * Example:
 *
 * Input:
 * "MCMIV"
 *
 * M = 1000
 * C < M  -> -100
 * M = 1000
 * I < V  -> -1
 * V = 5
 *
 * Answer:
 * 1000 - 100 + 1000 - 1 + 5 = 1904
 *
 * ------------------------------------------------------------
 *
 * Time Complexity:
 * O(N)
 *
 * - Each character is processed once.
 *
 * Space Complexity:
 * O(1)
 *
 * - The HashMap contains only 7 Roman numeral characters.
 *
 * ------------------------------------------------------------
 *
 * Alternative Approach:
 * - Process one or two characters at a time.
 * - If the current value is smaller than the next value,
 *   directly add the difference and skip both characters.
 *
 * Time Complexity : O(N)
 * Space Complexity: O(1)
 *
 * ------------------------------------------------------------
 */

class Solution {

    public int romanToInt(String s) {

        // Store Roman numeral values
        HashMap<Character, Integer> roman = new HashMap<>();

        roman.put('I', 1);
        roman.put('V', 5);
        roman.put('X', 10);
        roman.put('L', 50);
        roman.put('C', 100);
        roman.put('D', 500);
        roman.put('M', 1000);

        int sum = 0;

        // Compare current character with the next character
        for (int i = 0; i < s.length() - 1; i++) {

            if (roman.get(s.charAt(i)) < roman.get(s.charAt(i + 1))) {

                // Subtract when a smaller value comes before
                // a larger value.
                sum -= roman.get(s.charAt(i));

            } else {

                // Otherwise, add the current value.
                sum += roman.get(s.charAt(i));
            }
        }

        // Add the final Roman numeral separately
        return sum + roman.get(s.charAt(s.length() - 1));


        // ---------------- My Approach ----------------
        /*
        HashMap<Character, Integer> hm = new HashMap<>();

        hm.put('I', 1);
        hm.put('V', 5);
        hm.put('X', 10);
        hm.put('L', 50);
        hm.put('C', 100);
        hm.put('D', 500);
        hm.put('M', 1000);

        int sum = 0;
        int i = 0;

        while (i < s.length()) {

            if ((i + 1 < s.length()) &&
                (hm.get(s.charAt(i)) < hm.get(s.charAt(i + 1)))) {

                sum = sum +
                      (hm.get(s.charAt(i + 1)) -
                       hm.get(s.charAt(i)));

                i += 2;

            } else {

                sum += hm.get(s.charAt(i));
                i++;
            }
        }

        return sum;
        */
    }
}