class Solution {
    public int solve(int[] nums,int i,int j,int n){
        if(i==j) return nums[i];
        return Math.max(nums[i]-solve(nums,i+1,j,n),nums[j]-solve(nums,i,j-1,n));
    }
    public boolean PredictTheWinner(int[] nums) {
        int n=nums.length;
        return solve(nums,0,n-1,n)>=0;
    }
}