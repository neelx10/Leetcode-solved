class Solution {
    public long findCost(int idx,int[] cost,int[] nums){
        long ans=0L;
        for(int i=0;i<nums.length;i++) ans+=1L*Math.abs(nums[i]-idx)*cost[i];
        return ans;
    }
    public long minCost(int[] nums, int[] cost) {
        long ans=findCost(0,cost,nums);
        int start=(int)(1e6+1),end=0;
        for(int i:nums){
            end=Math.max(i,end);
            start=Math.min(i,start);
        }
        //binary search
        while(start<=end){
            int mid=start + (end-start)/2;
            long cost1=findCost(mid,cost,nums);
            long cost2=findCost(mid+1,cost,nums);
            ans=Math.min(cost1,cost2);
            if(cost2>cost1) end=mid-1;
            else start=mid+1;
        }
        return ans;
    }
}