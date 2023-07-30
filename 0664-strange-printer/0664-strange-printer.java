class Solution {
    private int solve(String s, int n, int left, int right,int[][] dp) {
        if (dp[left][right] != -1) return dp[left][right];
        dp[left][right] = n;
        int j = -1;
        for (int i = left; i < right; i++) {
            if (s.charAt(i) != s.charAt(right) && j == -1) j = i;
            if (j != -1) dp[left][right] = Math.min(dp[left][right], 1 + solve(s, n, j, i, dp) + solve(s, n, i + 1, right, dp));
        }
        if (j == -1) dp[left][right] = 0;
        return dp[left][right];
    }

    public int strangePrinter(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for(int[] r:dp) Arrays.fill(r,-1);
        return solve(s, n, 0, n - 1,dp)+1;
    }
}