class Solution {
    private int[] countZeroesOnes(String str) {
        int[] count = new int[2];
        for (char c : str.toCharArray()) {
            if (c == '0') count[0]++;
            else count[1]++;
        }
        return count;
    }
    
    public int findMaxForm(String[] strs, int m, int n) {
        int[][][] dp = new int[strs.length + 1][m + 1][n + 1];

        for (int ind = strs.length - 1; ind >= 0; ind--) {
            int[] temp = countZeroesOnes(strs[ind]);
            for (int zeros = 0; zeros <= m; zeros++) {
                for (int ones = 0; ones <= n; ones++) {
                    int notTake = dp[ind + 1][zeros][ones];
                    int take = 0;
                    if (zeros >= temp[0] && ones >= temp[1]) take = 1 + dp[ind + 1][zeros - temp[0]][ones - temp[1]];
                    dp[ind][zeros][ones] = Math.max(notTake, take);
                }
            }
        }

        return dp[0][m][n];
    }
}
