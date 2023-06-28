class Solution {
    public int solve(int i, int j, int[][] nums, int m, int n, int[][] dp) {
        if (i < 0 || j < 0 || i >= m || j >= n || nums[i][j] == 1) return 0;
        if (i == m - 1 && j == n - 1) return 1; 
        if (dp[i][j] != 0) return dp[i][j]; 
        return dp[i][j] = solve(i + 1, j, nums, m, n, dp) + solve(i, j + 1, nums, m, n, dp);
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        return solve(0, 0, obstacleGrid, m, n, dp);
    }
}
