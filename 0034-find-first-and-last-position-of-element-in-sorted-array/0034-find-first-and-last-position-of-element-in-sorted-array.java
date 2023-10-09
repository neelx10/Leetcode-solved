class Solution {
    public int firstOccurence(int[] nums,int target){
        int low=0,high=nums.length-1,ans=-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(nums[mid]==target){
                ans=mid;
                high=mid-1;
            }
            else if(nums[mid]>target) high=mid-1;
            else low=mid+1;
        }
        return ans;
    }

    public int lastOccurence(int[] nums,int target){
        int low=0,high=nums.length-1,ans=-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(nums[mid]==target){
                ans=mid;
                low=mid+1;
            }
            else if(nums[mid]>target) high=mid-1;
            else low=mid+1;
        }
        return ans;
    }

    public int[] searchRange(int[] nums, int target) {
        int first=firstOccurence(nums,target);
        if(first==-1) return new int[]{-1,-1};
        return new int[]{first,lastOccurence(nums,target)};
    }
}