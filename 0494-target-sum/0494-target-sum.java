//count partitions such that S1-S2=D(target)


class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n=nums.length;
        return countPartitions(n,nums,target);
    }
    public int countPartitions(int n,int[] nums,int target){
        int totSum=0;
        for(int num:nums) totSum+=num;
        int D=target;
        if(totSum-D<0 || (totSum-D)%2==1) return 0;
        int T=(totSum-D)/2;
        int ind=n-1;
        int[][] dp=new int[n][T+1];
        for(int[] row:dp) Arrays.fill(row,-1);
        return ways(ind,nums,T,n,dp);
    }
    public int ways(int ind,int[] nums,int T,int n,int[][] dp){
        if(dp[ind][T]!=-1) return dp[ind][T];
        if(ind==0){
            if(T==0 && nums[0]==0) return 2;
            if(T==0 || nums[0]==T) return 1;
            else return 0;
        }
        int notTake=ways(ind-1,nums,T,n,dp);
        int take=0;
        if(nums[ind]<=T) take=ways(ind-1,nums,T-nums[ind],n,dp);
        return dp[ind][T]=notTake+take;
    }
}