class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp=new int[prices.length+1][2];
        for(int i=prices.length-1;i>=0;i--){
            for(int flag=1;flag>=0;flag--){
                if(flag==0) dp[i][flag]=Math.max(dp[i+1][0],-prices[i]+dp[i+1][1]);
                else dp[i][flag]=Math.max(dp[i+1][1],prices[i]+dp[i+1][0]);
            }
        }
        return dp[0][0];
    }
}