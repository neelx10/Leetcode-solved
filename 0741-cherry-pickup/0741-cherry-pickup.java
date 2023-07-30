class Solution {
    public int solve(int i1, int j1, int i2, int[][] grid, int n, int[][][] dp) {
        int j2 = i1 + j1 - i2; 
        if (i1 >= n || i2 >= n || j1 >= n || j2 >= n || grid[i1][j1] == -1 || grid[i2][j2] == -1) return (int) -1e9;
        if (i1 == n - 1 && j1 == n - 1) return grid[i1][j1];
        if (dp[i1][j1][i2] != 0) return dp[i1][j1][i2];

        int value = 0;
        if (i1 == i2 && j1 == j2) value += grid[i1][j1];
        else value += grid[i1][j1] + grid[i2][j2];

        int f1 = solve(i1, j1 + 1, i2, grid, n, dp);
        int f2 = solve(i1 + 1, j1, i2, grid, n, dp);
        int f3 = solve(i1 + 1, j1, i2 + 1, grid, n, dp);
        int f4 = solve(i1, j1 + 1, i2 + 1, grid, n, dp);

        value += Math.max(Math.max(f1, f2), Math.max(f3, f4));
        return dp[i1][j1][i2] = value;
    }

    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int[][][] dp = new int[n][n][n];
        return Math.max(0, solve(0, 0, 0, grid, n, dp));
    }
}




