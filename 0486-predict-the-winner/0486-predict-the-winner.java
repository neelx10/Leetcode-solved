class Solution {
    public int solve(int[] nums,int i,int j,int n,int[][] dp){
        if(i==j) return nums[i];
        if(dp[i][j]!=0) return dp[i][j];
        return dp[i][j]=Math.max(nums[i]-solve(nums,i+1,j,n,dp),nums[j]-solve(nums,i,j-1,n,dp));
    }
    public boolean PredictTheWinner(int[] nums) {
        int n=nums.length;
        int[][] dp=new int[n][n];
        //for(int[] r:dp) Arrays.fill(r,-1);
        return solve(nums,0,n-1,n,dp)>=0;
    }
}