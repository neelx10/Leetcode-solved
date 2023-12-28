class Solution {
    public int getLengthOfOptimalCompression(String s, int k) {
        int n = s.length();
        int[][] dp = new int[n][k + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], 101);
        }

        return dfs(0, k, s, dp);
    }

    private int dfs(int i, int k, String s, int[][] dp) {
        int n = s.length();
        if (i + k >= n) {
            return 0;
        }
        if (k < 0) {
            return 101;
        }
        if (dp[i][k] != 101) {
            return dp[i][k];
        }

        int res = dfs(i + 1, k - 1, s, dp);
        int diff = 0, same = 0, length = 0;

        for (int j = i; j < n; j++) {
            if (k - diff < 0) {
                break;
            }
            if (s.charAt(i) == s.charAt(j)) {
                same++;
                if (same <= 2 || same == 10 || same == 100) {
                    length++;
                }
            } else {
                diff++;
            }
            res = Math.min(res, length + dfs(j + 1, k - diff, s, dp));
        }

        dp[i][k] = res;
        return res;
    }
}