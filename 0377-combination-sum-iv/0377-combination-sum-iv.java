class Solution {
    public int ways(int[] nums,int target,int[] dp){
        if (target == 0) return 1;
        if(dp[target]!=-1) return dp[target];
        int count = 0;
        for (int num : nums){
            if (target >= num) count += ways(nums, target - num,dp);
        }
        return dp[target]=count;
    }
    
    public int combinationSum4(int[] nums, int target) {
        int[] dp=new int[target+1];
        Arrays.fill(dp,-1);
        return ways(nums,target,dp);
    }
}