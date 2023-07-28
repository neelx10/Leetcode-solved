class Solution {
    public boolean PredictTheWinner(int[] nums) {
        int n=nums.length;
        int[][] dp=new int[n][n];
        
        for(int i=n-1;i>=0;i--){
            for(int j=0;j<n;j++){
                if(i==j) dp[i][j]=nums[i];
                else{
                    if(j>=1 && i<n-1) dp[i][j]=Math.max(nums[i]-dp[i+1][j],nums[j]-dp[i][j-1]);
                }
            }
        }
        return dp[0][n-1]>=0;
    }
}