// Problem: Running Sum of 1D Array (#1480)
// Date: 20-04-2026

// Approach:
// Update array in-place by adding previous element
// Each element becomes sum of itself + previous sum

class Solution {
    public int[] runningSum(int[] nums) {
        for(int i = 1; i < nums.length; i++){
            nums[i] = nums[i] + nums[i - 1];
        }
        return nums;
    }
}