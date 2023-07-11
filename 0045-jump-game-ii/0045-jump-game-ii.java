class Solution {
    public int jump(int[] nums) {
        int n=nums.length;
        int[] dp=new int[n];
        Arrays.fill(dp,(int)1e9);
        dp[n-1]=0;
        for(int ind=n-2;ind>=0;ind--){
            for(int i=1;i<=nums[ind] && ind+i<n ;i++) dp[ind]=Math.min(dp[ind],1+dp[ind+i]);
        }
        return dp[0];
    }
}




