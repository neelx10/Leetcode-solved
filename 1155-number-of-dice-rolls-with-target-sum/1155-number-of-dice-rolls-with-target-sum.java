class Solution {
    int mod=(int)(1e9+7);
    public int solve(int n,int k,int target,int[][] dp){
        if (target < 0) return 0;
        if (n == 0) return (target == 0) ? 1 : 0;
        if(dp[n][target]!=-1) return dp[n][target];
        int count = 0;
        for (int i = 1; i <= k; i++) count = (count + solve(n - 1, k, target - i,dp)) % mod;
        return dp[n][target]=count;
    }
    public int numRollsToTarget(int n, int k, int target) {
        int[][] dp=new int[n+1][target+1];
        for(int[] r:dp) Arrays.fill(r,-1);
        return solve(n,k,target,dp);
    }
}


