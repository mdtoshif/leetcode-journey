/**
 * Problem: Word Search (#79)
 * Date : 30-08-2026
 *
 * ------------------------------------------------------------
 * Approach: DFS + Backtracking
 * ------------------------------------------------------------
 *
 * Time Complexity:
 * O(N × M × 4^L)
 *
 * Space Complexity:
 * O(L)
 *
 * - Recursion depth can reach the length of the word.
 * - No separate visited[][] array is used.
 *
 * ------------------------------------------------------------
 */

class Solution {

    private boolean move(
        int i,
        int j,
        int n,
        int m,
        int currIndi,
        String word,
        char[][] board,
        int[] di,
        int[] dj
    ) {

        // All characters of the word have been matched
        if (currIndi == word.length()) {
            return true;
        }

        // Try all 4 directions
        for (int ind = 0; ind < 4; ind++) {

            int nexti = i + di[ind];
            int nextj = j + dj[ind];

            // Check whether the next cell is valid
            if (
                nexti < n &&
                nextj < m &&
                nexti >= 0 &&
                nextj >= 0 &&
                board[nexti][nextj] != '#' &&
                board[nexti][nextj] == word.charAt(currIndi)
            ) {

                // Store original character
                char temp = board[nexti][nextj];

                // Mark cell as visited
                board[nexti][nextj] = '#';

                // Explore next character
                if (
                    move(
                        nexti,
                        nextj,
                        n,
                        m,
                        currIndi + 1,
                        word,
                        board,
                        di,
                        dj
                    ) == true
                ) {
                    return true;
                }

                // Backtrack:
                // Restore the original character
                board[nexti][nextj] = temp;
            }
        }

        // No valid path found from this cell
        return false;
    }

    public boolean exist(char[][] board, String word) {

        int n = board.length;
        int m = board[0].length;

        // Direction vectors:
        // D -> (1,0)
        // L -> (0,-1)
        // R -> (0,1)
        // U -> (-1,0)
        int[] di = {1, 0, 0, -1};
        int[] dj = {0, -1, 1, 0};

        // Try every cell as a possible starting point
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {

                if (board[i][j] == word.charAt(0)) {

                    // Store original character
                    char temp = board[i][j];

                    // Mark starting cell as visited
                    board[i][j] = '#';

                    // Start searching for the remaining characters
                    if (
                        move(
                            i,
                            j,
                            n,
                            m,
                            1,
                            word,
                            board,
                            di,
                            dj
                        ) == true
                    ) {
                        return true;
                    }

                    // Backtrack:
                    // Restore starting cell
                    board[i][j] = temp;
                }
            }
        }

        return false;
    }
}