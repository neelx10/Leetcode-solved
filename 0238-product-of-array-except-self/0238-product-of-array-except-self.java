class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int[] result=new int[n];
        int product=1;
        for(int i:nums) product*=i;
        for(int i=0;i<n;i++){
            if(nums[i]==0){
                int prod=1;
                for(int j=0;j<n;j++){
                    if(i!=j) prod*=nums[j];
                }
                result[i]=prod;
            }
            else result[i]=product/nums[i];
        }
        return result;
    }
}