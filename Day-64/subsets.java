/**
 * Problem: Subsets (#78)
 * Date: 13-08-2026
 *
 * ------------------------------------------------------------
 * Approach (Bit Manipulation)
 * ------------------------------------------------------------
 *
 * Observation:
 * - For an array of n elements, there are exactly 2^n subsets.
 * - Each element has two choices:
 *      0 -> Don't include the element
 *      1 -> Include the element
 *
 * - We can represent every subset using the binary
 *   representation of a number from 0 to 2^n - 1.
 *
 * Example:
 *
 * nums = [1, 2, 3]
 *
 * There are 2^3 = 8 subsets.
 *
 * Binary representation:
 *
 * 000 -> []
 * 001 -> [1]
 * 010 -> [2]
 * 011 -> [1,2]
 * 100 -> [3]
 * 101 -> [1,3]
 * 110 -> [2,3]
 * 111 -> [1,2,3]
 *
 * For every bit:
 *
 * bit = 0 -> Don't include nums[j]
 * bit = 1 -> Include nums[j]
 *
 * ------------------------------------------------------------
 *
 * Bit checking:
 *
 * (i & (1 << j)) != 0
 *
 * - 1 << j creates a number whose j-th bit is 1.
 * - ANDing it with i checks whether the j-th bit of i
 *   is also 1.
 *
 * ------------------------------------------------------------
 *
 * Time Complexity:
 * O(N * 2^N)
 *
 * - There are 2^N possible subsets.
 * - For every subset, we check N bits.
 *
 * ------------------------------------------------------------
 *
 * Space Complexity:
 * O(N * 2^N)
 *
 * - The answer itself contains 2^N subsets.
 * - Across all subsets, the total number of stored elements
 *   is O(N * 2^N).
 *
 * Auxiliary Space:
 * O(N)
 *
 * - The temporary subset and loop-related space, excluding
 *   the output list.
 *
 * ------------------------------------------------------------
 */

class Solution {

    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();

        int n = nums.length;

        // Total possible subsets = 2^n
        // (1 << n) means 2^n
        int totalSubsets = (1 << n) - 1;

        // Every number from 0 to 2^n - 1 represents
        // one unique subset.
        for (int i = 0; i <= totalSubsets; i++) {

            List<Integer> temp = new ArrayList<>();

            // Check every bit
            for (int j = 0; j <= n - 1; j++) {

                // If j-th bit is set, include nums[j]
                if ((i & (1 << j)) != 0) {
                    temp.add(nums[j]);
                }
            }

            ans.add(temp);
        }

        return ans;
    }
}