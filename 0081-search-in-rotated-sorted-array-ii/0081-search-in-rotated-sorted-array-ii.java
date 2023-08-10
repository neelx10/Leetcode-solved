class Solution {
    public boolean search(int[] nums, int target) {
        int n=nums.length;
        if(n==1) return nums[0]==target;
        int start=0,end=n-1;
        while(start<=end){
            int mid=(start+end)/2;
            if(nums[mid]==target) return true;
            else if(nums[start]>nums[mid]){
                if(nums[end]>=target && target>nums[mid]) start=mid+1;
                else end=mid-1;
            }
            else if(nums[mid]>nums[start]){
                if(nums[start]<=target && target<nums[mid]) end=mid-1;
                else start=mid+1;
            }
            else start++;
        }
        return false;
    }
}