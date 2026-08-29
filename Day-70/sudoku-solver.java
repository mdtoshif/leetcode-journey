/**
 * Problem: Sudoku Solver (#37)
 * Date: 29-08-2026
 *
 * ------------------------------------------------------------
 * Approach: Backtracking
 * ------------------------------------------------------------
 *
 * Time Complexity:
 * O(9^E)
 *
 * where E is the number of empty cells.
 *
 * In the worst case, every empty cell can try up to
 * 9 different digits.
 *
 * ------------------------------------------------------------
 *
 * Space Complexity:
 * O(E)
 *
 * - Recursion depth can reach the number of empty cells.
 *
 * ------------------------------------------------------------
 */

class Solution {

    // Check whether a character can be placed at board[row][col]
    private boolean canWeFill(
        int row,
        int col,
        char ch,
        char[][] board
    ) {

        // Check row, column and 3 x 3 box
        for (int i = 0; i < 9; i++) {

            // Check current row
            if (board[row][i] == ch)
                return false;

            // Check current column
            if (board[i][col] == ch)
                return false;

            // Check current 3 x 3 sub-grid
            if (board[
                    3 * (row / 3) + i / 3
                ][
                    3 * (col / 3) + i % 3
                ] == ch) {

                return false;
            }
        }

        return true;
    }

    // Recursively solve the Sudoku
    private boolean solve(char[][] board) {

        // Traverse the entire board
        for (int i = 0; i < board.length; i++) {

            for (int j = 0; j < board[0].length; j++) {

                // Found an empty cell
                if (board[i][j] == '.') {

                    // Try every possible digit
                    for (char ch = '1'; ch <= '9'; ch++) {

                        // Check whether this digit is valid
                        if (canWeFill(i, j, ch, board)) {

                            // Choose
                            board[i][j] = ch;

                            // Explore
                            if (solve(board) == true) {
                                return true;
                            }

                            // Undo choice if it leads to
                            // an unsolvable configuration
                            else {
                                board[i][j] = '.';
                            }
                        }
                    }

                    // No digit from 1-9 worked for this cell
                    return false;
                }
            }
        }

        // No empty cells remain
        // Sudoku is successfully solved
        return true;
    }

    public void solveSudoku(char[][] board) {

        solve(board);
    }
}