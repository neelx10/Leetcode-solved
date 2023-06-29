class Solution {
    public int maxi(int ind,int n,int[] prices,int cap,int[][] dp,int k){
        if(ind==n || cap==2*k) return 0;
        if(dp[ind][cap]!=-1) return dp[ind][cap];
        if(cap%2==0) dp[ind][cap]=Math.max(maxi(ind+1,n,prices,cap,dp,k),-prices[ind]+maxi(ind+1,n,prices,cap+1,dp,k));
        else dp[ind][cap]=Math.max(maxi(ind+1,n,prices,cap,dp,k),prices[ind]+maxi(ind+1,n,prices,cap+1,dp,k));
        return dp[ind][cap];
    }
    public int maxProfit(int k, int[] prices) {
        int n=prices.length;
        int[][] dp = new int[n][2*k];
        for (int[] row : dp) Arrays.fill(row, -1);
        return maxi(0,n,prices,0,dp,k);
    }
}