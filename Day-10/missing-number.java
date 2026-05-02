// Problem: Missing Number (#268)
// Date: 02-05-2026

// Approach 1 (Mathematical):
// Use sum formula n(n+1)/2 and subtract actual sum

// Approach 2 (XOR):
// XOR all numbers from 0 to n and array elements
// duplicates cancel out → missing number remains

// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {

    // Approach 1: Sum Formula
    public int missingNumberSum(int[] nums) {
        int n = nums.length;
        int total = n * (n + 1) / 2;

        int sum = 0;
        for(int num : nums){
            sum += num;
        }

        return total - sum;
    }

    // Approach 2: XOR
    public int missingNumberXOR(int[] nums) {
        int x = 0;

        // XOR of array
        for(int num : nums){
            x ^= num;
        }

        // XOR of 0 to n
        for(int i = 0; i <= nums.length; i++){
            x ^= i;
        }

        return x;
    }
}