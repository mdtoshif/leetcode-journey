// Problem: Move Zeroes (#283)
// Date: 08-05-2026

// Approach:
// Use two pointers
// Move non-zero elements forward (overwrite)
// Fill remaining positions with zero

// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    public void moveZeroes(int[] nums) {
        int position = 0;

        // Move non-zero elements forward
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                nums[position++] = nums[i];
            }
        }

        // Fill remaining with zero
        for(int i = position; i < nums.length; i++){
            nums[i] = 0;
        }
    }
}