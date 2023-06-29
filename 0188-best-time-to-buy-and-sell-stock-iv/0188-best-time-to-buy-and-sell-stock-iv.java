class Solution {
    public int maxProfit(int k, int[] prices) {
        int n=prices.length;
        int[][] dp = new int[n+1][2*k+1];
        for(int ind=n-1;ind>=0;ind--){
            for(int cap=2*k - 1;cap>=0;cap--){
                if(cap%2==0) dp[ind][cap]=Math.max(dp[ind+1][cap],-prices[ind]+dp[ind+1][cap+1]);
                else dp[ind][cap]=Math.max(dp[ind+1][cap],prices[ind]+dp[ind+1][cap+1]);
            }
        }
        return dp[0][0];
    }
}