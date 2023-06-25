class Solution {
    public int robbing(int[] nums,int start,int end,int[][] dp) {
        if(start>end) return 0;
        if (start == end) return nums[start];
        if(dp[start][end]!=-1) return dp[start][end];
        return dp[start][end]=Math.max(robbing(nums,start+1,end,dp),nums[start]+robbing(nums,start+2,end,dp));
    }
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1) return nums[0];
        int[][] dp=new int[n+1][n+1];
        for(int[] row:dp) Arrays.fill(row,-1);
        int start=0,end=nums.length-1;
        return Math.max(robbing(nums,start,end-1,dp),robbing(nums,start+1,end,dp));
    }
}