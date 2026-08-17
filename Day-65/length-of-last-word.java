/**
 * Problem: Length of Last Word (#58)
 * Date: 17-08-2026
 *
 * ------------------------------------------------------------
 * Approach (Optimal - Reverse Traversal)
 * ------------------------------------------------------------
 *
 * Time Complexity:
 * O(N)
 *
 * - In the worst case, we may traverse the entire string.
 *
 * Space Complexity:
 * O(1)
 *
 * - No extra data structure is used.
 *
 * ------------------------------------------------------------
 *
 * Alternative Approach:
 * - Remove leading/trailing spaces using strip().
 * - Split the string using spaces.
 * - Return the length of the last element.
 *
 * Time Complexity : O(N)
 * Space Complexity: O(N)
 *
 * ------------------------------------------------------------
 */

class Solution {

    public int lengthOfLastWord(String s) {

        // ---------------- Optimal Approach ----------------

        // Start from the last character
        int end = s.length() - 1;

        // Skip trailing spaces
        while (end >= 0 && s.charAt(end) == ' ') {
            end--;
        }

        // Start searching for the beginning of the last word
        int start = end;

        // Move backwards until a space is found
        while (start >= 0 && s.charAt(start) != ' ') {
            start--;
        }

        // Characters between start and end form the last word
        return end - start;


        // ---------------- Brute Force ----------------
        /*
        s = s.strip();

        String[] a = s.split(" ");

        return a[a.length - 1].length();
        */
    }
}