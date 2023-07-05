class Solution {
    public int longestSubarray(int[] nums) {
        int maxLen=0;
        int countzero=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                countzero++;
                int count=0;
                for(int j=0;j<nums.length;j++){
                    if(i==j) continue;
                    if(nums[j]==0){
                        maxLen=Math.max(maxLen,count);
                        count=0;
                    }
                    else count++;
                }
                maxLen=Math.max(maxLen,count);
            }
        }
        if(countzero==0) return nums.length-1;
        return maxLen;
    }
}