/**
 * Problem: Single Number II (#137)
 * Date: 06-09-2026
 *
 * ------------------------------------------------------------
 * Approach: Bit Manipulation - Storing in Buckets
 * ------------------------------------------------------------
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * ------------------------------------------------------------
 */

class Solution {
    public int singleNumber(int[] nums) {
        // Optimal - II (Storing in Buckets)
        //[2,2,2,3]
        int ones = 0;
        int twos = 0;

        for(int i = 0; i < nums.length; i++) {
            // If the bit is not present in twos, keep it in ones
            ones = (ones ^ nums[i]) & ~twos;

            // If the bit is not present in ones, keep it in twos
            twos = (twos ^ nums[i]) & ~ones;
        }

        return ones;


        // Optimal - I
        // int n = nums.length;
        // Arrays.sort(nums);
        // for(int i = 1; i < n; i+=3) {
        //     if(nums[i] != nums[i-1]) return nums[i-1];
        // }
        // return nums[n-1];


        // Extreme Brute-Force
        // HashMap<Integer, Integer> hm = new HashMap<>();

        // for(int elem : nums) {
        //     hm.put(elem, hm.getOrDefault(elem, 0)+1);

        //     // "OR"
        //     // if(hm.containsKey(elem)) {
        //     //     hm.put(elem, hm.get(elem)+1);
        //     // }else{
        //     //     hm.put(elem, 1);
        //     // }
        // }

        // for(Map.Entry<Integer, Integer> e : hm.entrySet()) {
        //     if(e.getValue() == 1) return e.getKey();
        // }

        // return 0;
    }
}