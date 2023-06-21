class Solution {
    public int minEatingSpeed(int[] nums, int h) {
        int end=1;
        for(int i:nums) end=Math.max(end,i);
        int start=1;
        while(start<=end){
            int mid=start + (end-start)/2;
            long time=0;
            for(int i:nums){
                time+=i/mid;
                if(i%mid!=0) time++;
            }
            if(time<=h) end=mid-1;
            else start=mid+1;
        }
        return start;
    }
}