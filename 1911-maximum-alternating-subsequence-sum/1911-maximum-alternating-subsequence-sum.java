class Solution {
    public long solve(int ind,int[] nums,int flag,long[][] dp){
        if(ind==nums.length) return 0;
        if(dp[ind][flag]!=-1) return dp[ind][flag];
        if(flag==0) dp[ind][flag]=Math.max(nums[ind]+solve(ind+1,nums,1,dp),solve(ind+1,nums,0,dp));
        else dp[ind][flag]=Math.max(-nums[ind]+solve(ind+1,nums,0,dp),solve(ind+1,nums,1,dp));
        return dp[ind][flag];
    }
    public long maxAlternatingSum(int[] nums) {
        long[][] dp=new long[nums.length][2];
        for(long[] r:dp) Arrays.fill(r,-1);
        return solve(0,nums,0,dp);
    }
}