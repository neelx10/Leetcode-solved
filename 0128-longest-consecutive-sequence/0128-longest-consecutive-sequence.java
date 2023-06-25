class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0) return 0;
        int maxi=1;
        Set<Integer> set=new HashSet<>();
        for(int i:nums) set.add(i);
        for(int num:nums){
            //only deal with the smallest element of a sequence
            if(!set.contains(num-1)){
                int count=1;
                while(set.contains(num+1)){
                    num=num+1;
                    count=count+1;
                }
                maxi=Math.max(maxi,count);
            }
        }
        return maxi;
    }
}