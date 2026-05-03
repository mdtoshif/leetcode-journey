// Problem: Search Insert Position (#35)
// Date: 03-05-2026

// Approach:
// Use binary search to find the target
// If found → return index
// If not found → return the position where it should be inserted (low pointer)

// Time Complexity: O(log n)
// Space Complexity: O(1)

class Solution {
    public int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while(low <= high){
            int mid = low + (high - low) / 2; // avoids overflow

            if(nums[mid] == target){
                return mid;
            } else if(nums[mid] < target){
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }
}