class Solution {
    public int func(int n,int[] dp){
        if(n<=1) return 1;
        if(dp[n]!=0)return dp[n];
        return dp[n]=func(n-1,dp)+func(n-2,dp);
    }
    public int climbStairs(int n) {
        return func(n,new int[n+1]);
    }
}