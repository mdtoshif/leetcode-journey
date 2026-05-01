// Problem: Single Number (#136)
// Date: 2-05-2026

// Approach:
// Use XOR to cancel out duplicate numbers
// a ^ a = 0, so only the unique number remains

// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    public int singleNumber(int[] nums) {
        int x = 0;
        for(int num : nums){
            x ^= num;
        }
        return x;
    }
}