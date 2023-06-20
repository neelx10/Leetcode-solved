class Solution {
    public int[] getAverages(int[] nums, int k) {
        if(k==0) return nums;
        int n=nums.length;
        
        int[] avg=new int[n];
        Arrays.fill(avg,-1);
        if(2*k+1>n) return avg;
        
        long[] prefix=new long[n+1];
        for(int i=0;i<n;i++) prefix[i+1]=prefix[i]+nums[i];

        for(int i=k;i<n-k;i++){
            long sum=prefix[i+k+1]-prefix[i-k];
            avg[i]=(int)(sum/(2*k+1));
        }
        return avg;
    }
}