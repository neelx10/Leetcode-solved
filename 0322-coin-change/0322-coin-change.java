class Solution {
    public int solve(int[] coins,int target,int i,int[][] dp){
        if(i==0) return (target%coins[0]==0)?target/coins[0]:(int)1e9;
        if(dp[target][i]!=-1) return dp[target][i];
        return dp[target][i]=Math.min((target>=coins[i])?1+solve(coins,target-coins[i],i,dp):(int)1e9,solve(coins,target,i-1,dp));
    }
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int[][] dp=new int[amount+1][n];
        for(int[] r:dp) Arrays.fill(r,-1);
        int temp=solve(coins,amount,n-1,dp);
        return (temp>=(int)1e9)?-1:temp;
    }
}