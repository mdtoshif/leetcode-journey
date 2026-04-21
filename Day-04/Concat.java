// Problem: Concatenation of Array (#1929)
// Date: 21-04-2026

// Approach:
// Use modulo to repeat elements
// i % n cycles through original array twice

class Solution {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] ans = new int[2 * n];

        for(int i = 0; i < 2 * n; i++){
            ans[i] = nums[i % n];
        }

        return ans;
    }
}