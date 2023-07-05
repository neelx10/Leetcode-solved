class Solution {
    public int longestSubarray(int[] nums) {
        int i=0,j=0;
        int last_zero_idx=-1;
        int res=0;
        while(j<nums.length){
            if(nums[j]==0){
                i=last_zero_idx+1;
                last_zero_idx=j;
            }
            res=Math.max(res,j-i);
            j++;
        }
        return res;
    }
}