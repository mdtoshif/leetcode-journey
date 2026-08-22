/**
 * Problem: Combination Sum II (#40)
 * Day: 22-08-2026
 *
 * ------------------------------------------------------------
 * Approach (Optimal - Backtracking + Sorting)
 * ------------------------------------------------------------
 *
 * Observation:
 * - Each element can be used at most once.
 * - We sort the array so that duplicate elements become
 *   adjacent.
 * - At every recursive call, we iterate from 'ind'.
 * - If the current element is the same as the previous
 *   element AND we are at the same recursion level,
 *   skip it to avoid duplicate combinations.
 *
 * Important:
 *
 *     if(i > ind && arr[i] == arr[i-1]) continue;
 *
 * This means:
 * - i == ind:
 *      We are choosing the first element at this level.
 *      Duplicate is allowed here.
 *
 * - i > ind:
 *      We are trying another choice at the SAME level.
 *      If it is equal to the previous choice, skip it.
 *
 * Example:
 *
 * candidates = [1,1,2]
 * target = 2
 *
 * Without duplicate skipping:
 *
 * [1,1]
 * [1,1]   <- duplicate
 * [2]
 *
 * With the condition:
 *
 * [1,1]
 * [2]
 *
 * ------------------------------------------------------------
 *
 * Why do we use i + 1 in recursion?
 *
 * Unlike Combination Sum (#39), an element can only be
 * selected once.
 *
 * Therefore after selecting arr[i], we call:
 *
 *     findCombination(i + 1, ...)
 *
 * This moves to the next index and prevents reusing
 * arr[i].
 *
 * ------------------------------------------------------------
 *
 * Why do we use new ArrayList<>(ds)?
 *
 * 'ds' is the same mutable list used throughout the
 * backtracking process.
 *
 * When a valid combination is found, we need to save
 * the CURRENT state of ds.
 *
 * Therefore:
 *
 *     ans.add(new ArrayList<>(ds));
 *
 * creates a separate copy.
 *
 * If we did:
 *
 *     ans.add(ds);
 *
 * then ans would store a reference to the same list.
 * Later backtracking modifies ds, which would also modify
 * the combination stored in ans.
 *
 * ------------------------------------------------------------
 *
 * Time Complexity:
 * O(2^N) approximately for generating combinations,
 * plus O(N log N) for sorting.
 *
 * Since each possible subset can be explored, the
 * recursion tree can have up to 2^N states.
 *
 * Output construction can additionally require O(N)
 * work per combination.
 *
 * ------------------------------------------------------------
 *
 * Space Complexity:
 * O(N)
 *
 * Auxiliary recursion + current combination can go
 * up to O(N).
 *
 * The answer list itself requires additional output space.
 *
 * ------------------------------------------------------------
 */

class Solution {

    // ---------------- Optimal ----------------

    private void findCombination(
        int ind,
        int target,
        int[] arr,
        List<List<Integer>> ans,
        List<Integer> ds
    ) {

        // Valid combination found
        if (target == 0) {

            // Store a COPY of the current combination
            ans.add(new ArrayList<>(ds));

            return;
        }

        // Try every possible element from the current index
        for (int i = ind; i < arr.length; i++) {

            // Skip duplicates at the same recursion level
            if (i > ind && arr[i] == arr[i - 1])
                continue;

            // Since array is sorted, no later element
            // can satisfy the target either.
            if (arr[i] > target)
                break;

            // Pick current element
            ds.add(arr[i]);

            // Move to i + 1 because each element
            // can be used only once.
            findCombination(
                i + 1,
                target - arr[i],
                arr,
                ans,
                ds
            );

            // Backtrack
            ds.remove(ds.size() - 1);
        }
    }

    // ---------------- Brute ----------------

    /*
    private void findCombi(
        int i,
        int sum,
        int target,
        int[] arr,
        Set<List<Integer>> ans,
        List<Integer> ds
    ) {

        if (i == arr.length) {

            if (sum == target) {

                List<Integer> sortedDs =
                    new ArrayList<>(ds);

                Collections.sort(sortedDs);

                ans.add(sortedDs);
            }

            if (ds.isEmpty())
                return;

            return;
        }

        sum += arr[i];
        ds.add(arr[i]);

        findCombi(
            i + 1,
            sum,
            target,
            arr,
            ans,
            ds
        );

        sum -= arr[i];
        ds.remove(ds.size() - 1);

        findCombi(
            i + 1,
            sum,
            target,
            arr,
            ans,
            ds
        );
    }
    */

    public List<List<Integer>> combinationSum2(
        int[] candidates,
        int target
    ) {

        // ---------------- Brute ----------------

        /*
        Set<List<Integer>> ans = new HashSet<>();

        findCombi(
            0,
            0,
            target,
            candidates,
            ans,
            new ArrayList<>()
        );

        return new ArrayList<>(ans);
        */


        // ---------------- Optimal ----------------

        List<List<Integer>> ans = new ArrayList<>();

        // Sorting allows us to:
        // 1. Detect duplicates easily.
        // 2. Stop early when arr[i] > target.
        Arrays.sort(candidates);

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