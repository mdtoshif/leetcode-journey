/**
 * Problem: Letter Combinations of a Phone Number (#17)
 * Date: 26-08-2026
 *
 * ------------------------------------------------------------
 * Approach: Recursion + Backtracking
 *
 * ------------------------------------------------------------
 *
 * Time Complexity:
 * O(4^N * N)
 *
 * - Each digit can have at most 4 characters.
 * - There can be up to 4^N combinations.
 * - Each completed combination has N characters and
 *   requires O(N) work to store.
 *
 * Space Complexity:
 * O(N)
 *
 * - Recursion depth is N.
 * - The current string has at most N characters.
 *
 * Output Space:
 * O(4^N * N)
 *
 * - The returned answer itself can contain up to 4^N
 *   strings of length N.
 *
 * ------------------------------------------------------------
 */

class Solution {

    private void helper(
        int index,
        String s,
        String digits,
        List<String> ans,
        HashMap<Integer, String> hm
    ) {

        // All digits have been processed
        if (index >= digits.length()) {

            // Store the complete combination
            ans.add(s);

            return;
        }

        // Convert current character digit into an integer
        int number = digits.charAt(index) - '0';

        // Get characters mapped to the current digit
        String value = hm.get(number);

        // Try every possible character
        for (int i = 0; i < value.length(); i++) {

            // Choose
            s += value.charAt(i);

            // Explore next digit
            helper(
                index + 1,
                s,
                digits,
                ans,
                hm
            );

            // Backtrack
            // Remove the last character before trying
            // the next possibility.
            s = s.substring(0, s.length() - 1);
        }
    }

    public List<String> letterCombinations(String digits) {

        HashMap<Integer, String> hm = new HashMap<>();

        hm.put(0, "");
        hm.put(1, "");
        hm.put(2, "abc");
        hm.put(3, "def");
        hm.put(4, "ghi");
        hm.put(5, "jkl");
        hm.put(6, "mno");
        hm.put(7, "pqrs");
        hm.put(8, "tuv");
        hm.put(9, "wxyz");

        List<String> ans = new ArrayList<>();

        // Start recursion with an empty string
        helper(0, "", digits, ans, hm);

        return ans;
    }
}