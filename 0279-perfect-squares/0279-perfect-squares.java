class Solution {
    public int numSquares(int n) {
        int[] dp=new int[n+1];
        for(int num=1;num<=n;num++){
            int mini=n;
            for(int i=1;i*i<=num;i++) mini=Math.min(mini,1+dp[num-i*i]);
            dp[num]=mini;
        }
        return dp[n];
    }
}