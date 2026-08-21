/**
 * Problem: Combination Sum (#39)
 * Day: 22-08-2026

 *
 * ------------------------------------------------------------
 * Approach: Recursion + Backtracking

 *
 * Example:
 *
 * candidates = [2, 3, 6, 7]
 * target = 7
 *
 * Possible valid combinations:
 *
 * [2, 2, 3]
 * [7]
 *
 * ------------------------------------------------------------
 *
 * Time Complexity:
 * O(2^T)
 *
 * where T is the target (more precisely, the recursion tree
 * depends on the candidate values).
 *
 * ------------------------------------------------------------
 *
 * Space Complexity:
 * O(T)
 *
 * Auxiliary recursion/backtracking depth is proportional to
 * the maximum number of elements that can be selected.
 *
 * Output space is additional and can be larger.
 *
 * ------------------------------------------------------------
 */

class Solution {

    private void findCombination(
        int i,
        int sum,
        int[] arr,
        List<List<Integer>> ans,
        List<Integer> combi
    ) {

        // Base case
        if (i == arr.length) {

            // Valid combination found
            if (sum == 0) {

                // Store a COPY because combi is modified
                // later during backtracking.
                ans.add(new ArrayList<>(combi));
            }

            return;
        }

        // Pick the current element
        //
        // Stay at the same index because the same candidate
        // can be picked multiple times.
        if (arr[i] <= sum) {

            combi.add(arr[i]);

            findCombination(
                i,
                sum - arr[i],
                arr,
                ans,
                combi
            );

            // Backtrack:
            // Remove the element before exploring the
            // "don't pick" choice.
            combi.remove(combi.size() - 1);
        }

        // Don't pick the current element
        findCombination(
            i + 1,
            sum,
            arr,
            ans,
            combi
        );
    }

    public List<List<Integer>> combinationSum(
        int[] candidates,
        int target
    ) {

        List<List<Integer>> ans = new ArrayList<>();

        findCombination(
            0,
            target,
            candidates,
            ans,
            new ArrayList<>()
        );

        return ans;
    }
}