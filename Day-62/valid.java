/**
 * Problem: Find All Valid Strings of Length n (#3211)
 * Date: 11-08-2026
 * ------------------------------------------------------------
 * Approach: Recursion / Backtracking
 * ------------------------------------------------------------
 * Time Complexity:
 * O(2^n)
 *
 * There can be at most 2^n possible binary strings.
 * We generate only valid strings, but the upper bound is O(2^n).
 *
 * Since every generated string has length n, a strict
 * output-sensitive analysis is O(n * number_of_answers).
 *
 * Space Complexity:
 * O(n)
 *
 * Recursion depth is at most n.
 *
 * Additionally, the answer list itself requires space
 * proportional to the number of generated strings.
 *
 * ------------------------------------------------------------
 */

class Solution {

    private void generate(int n, String s, List ans) {

        // Base case:
        // A valid string of required length has been formed.
        if (s.length() == n) {
            ans.add(s);
            return;
        }

        // '1' can always be added.
        generate(n, s + "1", ans);

        // '0' can be added only if:
        // - the string is empty, OR
        // - the previous character is not '0'
        if (s.isEmpty() || s.charAt(s.length() - 1) != '0') {
            generate(n, s + "0", ans);
        }
    }

    public List<String> validStrings(int n) {

        List<String> ans = new ArrayList<>();

        generate(n, "", ans);

        return ans;
    }
}