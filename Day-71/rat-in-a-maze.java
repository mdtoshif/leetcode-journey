/**
 * Problem: Rat in a Maze (GFG)
 * Date : 30-08-2026
 * ------------------------------------------------------------
 * Approach: Backtracking + DFS
 *
 * ------------------------------------------------------------
 *
 * Time Complexity:
 * O(4^(N²))
 *
 * In the worst case, from each cell we may try up to
 * 4 possible directions.
 *
 * Here the grid contains N² cells.
 *
 * This is a theoretical upper bound; visited[][] greatly
 * prunes paths that revisit cells.
 *
 * ------------------------------------------------------------
 *
 * Space Complexity:
 * O(N²)
 *
 * - visited[][] takes O(N²).
 * - Recursion depth can be O(N²) in the worst case.
 *
 * Output space is additional.
 *
 * ------------------------------------------------------------
 */

class Solution {

    private void move(
        int i,
        int j,
        String s,
        int[][] maze,
        int[][] visited,
        ArrayList<String> ans,
        int n,
        int[] di,
        int[] dj
    ) {

        // Destination reached
        if (i == n - 1 && j == n - 1) {
            ans.add(s);
            return;
        }

        // Direction order: Down, Left, Right, Up
        String dir = "DLRU";

        // Try all four possible directions
        for (int ind = 0; ind < 4; ind++) {

            int nexti = i + di[ind];
            int nextj = j + dj[ind];

            // Check whether the next cell is valid
            if (
                nexti < n &&
                nextj < n &&
                nexti >= 0 &&
                nextj >= 0 &&
                visited[nexti][nextj] != 1 &&
                maze[nexti][nextj] == 1
            ) {

                // Mark current cell as visited
                visited[i][j] = 1;

                // Explore the next cell
                move(
                    nexti,
                    nextj,
                    s + dir.charAt(ind),
                    maze,
                    visited,
                    ans,
                    n,
                    di,
                    dj
                );

                // Backtrack:
                // Allow this cell to be used by another path
                visited[i][j] = 0;
            }
        }
    }

    public ArrayList<String> ratInMaze(int[][] maze) {

        int n = maze.length;

        ArrayList<String> ans = new ArrayList<>();

        // Direction vectors:
        // D -> (1,0)
        // L -> (0,-1)
        // R -> (0,1)
        // U -> (-1,0)
        int[] di = {1, 0, 0, -1};
        int[] dj = {0, -1, 1, 0};

        int[][] visited = new int[n][n];

        // Start only if source cell is open
        if (maze[0][0] == 1) {
            move(
                0,
                0,
                "",
                maze,
                visited,
                ans,
                n,
                di,
                dj
            );
        }

        return ans;
    }
}