class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n=nums.length;
        long[][] dp=new long[n+1][2];
        for(int ind=n-1;ind>=0;ind--){
            for(int flag=1;flag>=0;flag--){
                if(flag==0) dp[ind][flag]=Math.max(nums[ind]+dp[ind+1][1],dp[ind+1][0]);
                else dp[ind][flag]=Math.max(-nums[ind]+dp[ind+1][0],dp[ind+1][1]);
            }
        }
        return dp[0][0];
    }
}