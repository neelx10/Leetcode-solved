class Solution {
    public int candy(int[] nums) {
        int n=nums.length;
        int[] arr=new int[n];
        Arrays.fill(arr,1);
        //left
        for(int i=1;i<n;i++){
            if(nums[i]>nums[i-1]) arr[i]=arr[i-1]+1;
        }
        //right and combining together
        int sum=arr[n-1];
        for(int i=n-2;i>=0;i--){
            if(nums[i]>nums[i+1]) arr[i]=Math.max(arr[i],arr[i+1]+1);
            sum+=arr[i];
        }
        return sum;
    }
}