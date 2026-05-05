// Problem: Majority Element (#169)
// Date: 05-05-2026

// Approach:
// Use Boyer-Moore Voting Algorithm
// Maintain a candidate and a count
// Same element → count++
// Different element → count--
// Majority element survives after all cancellations

// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    public int majorityElement(int[] nums) {
        int major = 0;
        int count = 0;

        for(int i = 0; i < nums.length; i++){
            if(count == 0){
                major = nums[i];
            }

            if(nums[i] == major){
                count++;
            } else {
                count--;
            }
        }

        return major;
    }
}