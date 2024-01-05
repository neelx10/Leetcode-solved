class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp=new int[nums.length];
        Arrays.fill(dp,1);
        int maxi=1;
        for(int i=0;i<nums.length;i++){
            for(int prev=0;prev<i;prev++){
                if(nums[i]>nums[prev] && 1+dp[prev]>dp[i]) dp[i]=dp[prev]+1; 
            }
            maxi=Math.max(maxi,dp[i]);
        }
        return maxi;
    }
}