class Solution {
    private final int MOD = (int)(1e9+7);
    private long numberOfPlaylists(int i, int j, int k, int n, Long[][] dp) {
        // Base cases
        if (i == 0 && j == 0) return 1;
        if (i == 0 || j == 0) return 0;
        if (dp[i][j] != -1) return dp[i][j];
        dp[i][j] = (numberOfPlaylists(i - 1, j - 1, k, n,dp) * (n - j + 1)) % MOD;
        if (j > k) dp[i][j] += (numberOfPlaylists(i - 1, j, k, n,dp) * (j - k)) % MOD;
        return dp[i][j]%=MOD;
    }
    public int numMusicPlaylists(int n, int goal, int k) {
        Long[][] dp = new Long[goal + 1][n + 1];
        for(Long[] row : dp) Arrays.fill(row, -1L);
        return (int) (numberOfPlaylists(goal, n, k, n, dp));
    }
}