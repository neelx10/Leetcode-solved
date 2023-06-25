class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        int next2=0,next1=nums[n-1];
        for(int ind=n-2;ind>=0;ind--){
            int temp=next1;
            next1=Math.max(next1,nums[ind]+next2);
            next2=temp;
        }
        return next1;
    }
}

