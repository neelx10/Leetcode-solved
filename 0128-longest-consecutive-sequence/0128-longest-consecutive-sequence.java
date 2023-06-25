class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0) return 0;
        Arrays.sort(nums);
        int maxi=1;
        int curr=0;
        int small=(int)-1e9;
        for(int num:nums){
            if(num-1==small){
                curr++;
                small=num;
            }
            else if(num!=small){
                curr=1;
                small=num;
            }
            maxi=Math.max(maxi,curr);
        }
        return maxi;
    }
}