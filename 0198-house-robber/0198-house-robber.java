class Solution {
    public int solve(int ind,int[] nums,int[] dp){
        if(ind>=nums.length) return 0;
        if(dp[ind]!=-1) return dp[ind];
        return dp[ind]=Math.max(solve(ind+1,nums,dp),nums[ind]+solve(ind+2,nums,dp));
    }
    public int rob(int[] nums) {
        int[] dp=new int[nums.length+1];
        Arrays.fill(dp,-1);
        return solve(0,nums,dp);
    }
}