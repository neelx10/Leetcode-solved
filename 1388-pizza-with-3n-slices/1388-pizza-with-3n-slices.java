class Solution {
    public int solve(int start,int end,int[] slices, int n,int[][] dp) {
        if(n==0 || start>end) return 0;
        if(dp[start][n]!=-1) return dp[start][n];
        return dp[start][n]=Math.max(solve(start+1,end,slices,n,dp),slices[start]+solve(start+2,end,slices,n-1,dp));
    }
    
    public int maxSizeSlices(int[] slices) {
        int n=slices.length;
        int[][] dp1=new int[n][n];
        for(int[] r:dp1) Arrays.fill(r,-1);
        int[][] dp2=new int[n][n];
        for(int[] r:dp2) Arrays.fill(r,-1);
        return Math.max(solve(0,n-2,slices,n/3,dp1),solve(1,n-1,slices,n/3,dp2));
    }
}




  