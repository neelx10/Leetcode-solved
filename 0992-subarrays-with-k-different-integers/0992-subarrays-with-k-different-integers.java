class Solution {
    public int solve(int[] nums,int k){
        int i=0,j=0,count=0;
        Map<Integer,Integer> map=new HashMap<>();
        while(i<nums.length){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            while(map.size()>k){
                map.put(nums[j],map.get(nums[j])-1);
                if(map.get(nums[j])==0) map.remove(nums[j]);
                j++;
            }
            count+=(i-j+1);
            i++;
        }
        return count;
    }
    
    public int subarraysWithKDistinct(int[] nums, int k) {
        return solve(nums,k)-solve(nums,k-1);
    }
}