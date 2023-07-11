class Solution {
    public int solve(int ind,int[] nums,int[] dp){
        if(ind==nums.length-1) return 0;
        if(ind>=nums.length) return (int)1e9;
        if(dp[ind]!=-1) return dp[ind];
        int minSteps=(int)1e9;
        for(int i=nums[ind];i>0;i--){
            minSteps=Math.min(minSteps,1+solve(ind+i,nums,dp));
        }
        return dp[ind]=minSteps;
    }
    public int jump(int[] nums) {
        int[] dp=new int[nums.length];
        Arrays.fill(dp,-1);
        return solve(0,nums,dp);
    }
}


