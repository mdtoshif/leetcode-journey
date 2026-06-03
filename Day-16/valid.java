// Problem: Valid Palindrome (#125)
// Date: 03-06-2026

// Approach:
// Use two pointers:
// - One from the beginning
// - One from the end
//
// Ignore non-alphanumeric characters
// Compare characters in lowercase form
//
// Important:
// Use continue after skipping invalid characters
// so comparison happens only between valid characters

// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    public boolean isPalindrome(String s) {

        int i = 0;
        int j = s.length() - 1;

        while(i < j){

            // Skip invalid characters from left
            if(!Character.isLetterOrDigit(s.charAt(i))){
                i++;
                continue;
            }

            // Skip invalid characters from right
            if(!Character.isLetterOrDigit(s.charAt(j))){
                j--;
                continue;
            }

            // Compare characters ignoring case
            if(Character.toLowerCase(s.charAt(i)) !=
               Character.toLowerCase(s.charAt(j))){
                return false;
            }

            i++;
            j--;
        }

        return true;
    }
}