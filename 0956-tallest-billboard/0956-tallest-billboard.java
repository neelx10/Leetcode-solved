class Solution {
    public int solve(int[] rods, int idx, int diff, int[][] dp, int sum) {
        if (idx == rods.length) {
            if (diff == 0) return 0;
            return (int) -1e9;
        }
        if (dp[idx][diff+sum] != -1) return dp[idx][diff+sum];
        int nothing = solve(rods, idx + 1, diff, dp, sum);
        int l1rod = rods[idx] + solve(rods, idx + 1, diff + rods[idx], dp, sum);
        int l2rod = rods[idx]+solve(rods, idx + 1, diff - rods[idx], dp, sum);
        return dp[idx][diff+sum] = Math.max(nothing, Math.max(l1rod, l2rod));
    }
    
    public int tallestBillboard(int[] rods) {
        int sum = 0;
        for (int i : rods) sum += i;
        int[][] dp = new int[rods.length + 1][2 * sum + 1];  // Adjust the size of dp array
        for (int[] r : dp) Arrays.fill(r, -1);
        return solve(rods, 0, 0, dp, sum) / 2;
    }
}
