// Problem: Add Digits (#258)
// Date: 06-05-2026

// Approach (Digital Root):
// Instead of repeatedly summing digits, use modulo 9 property.
// Sum of digits of a number is congruent to num % 9.
// Special case: multiples of 9 should return 9 (not 0).
// So we use: 1 + (num - 1) % 9

// Examples:
// num = 38 → 3+8=11 → 1+1=2
// Formula: 1 + (38 - 1) % 9 = 1 + 37 % 9 = 1 + 1 = 2

// num = 9 → expected 9
// Formula: 1 + (9 - 1) % 9 = 1 + 8 % 9 = 1 + 8 = 9

// num = 10 → 1+0 = 1
// Formula: 1 + (10 - 1) % 9 = 1 + 9 % 9 = 1 + 0 = 1

// Time Complexity: O(1)
// Space Complexity: O(1)

class Solution {
    public int addDigits(int num) {
        if(num == 0) return 0;
        return 1 + (num - 1) % 9;
    }
}