class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        int[] dp=new int[n+2];
        for(int ind=n-1;ind>=0;ind--) dp[ind]=Math.max(dp[ind+1],nums[ind]+dp[ind+2]);
        return dp[0];
    }
}