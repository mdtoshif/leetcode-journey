// Problem: Contains Duplicate (#217)
// Date: 19-04-2026

// Approach:
// Use HashSet to track elements
// If element already exists, return true
import java.util.*;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for(int i = 0 ; i < nums.length ; i++){
            if(!set.add(nums[i])){
                return true;
            }
        } 
        return false;
    }
            
}