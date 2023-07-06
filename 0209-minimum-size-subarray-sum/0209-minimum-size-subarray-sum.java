class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int i=0,j=0;
        int min=(int)1e9;
        int sum=0;
        while(j<nums.length){
            sum+=nums[j];
            while(sum>=target){
                min=Math.min(min,j-i+1);
                sum-=nums[i++];
            }
            j++;
        }
        return (min==(int)1e9)?0:min;
    }
}