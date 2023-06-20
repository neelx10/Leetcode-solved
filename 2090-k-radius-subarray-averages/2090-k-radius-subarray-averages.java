class Solution {
    public int[] getAverages(int[] nums, int k) {
        if(k==0) return nums;
        int n=nums.length;
        
        int[] avg=new int[n];
        Arrays.fill(avg,-1);
        int len=2*k+1;
        if(len>n) return avg;
        
        long winSum=0;
        for(int i=0;i<len;i++) winSum+=nums[i];
        avg[k]=(int)(winSum/(2*k+1));
        
        for(int i=len;i<n;i++){
            winSum=winSum+nums[i]-nums[i-2*k-1];
            avg[i-k]=(int)(winSum/(2*k+1));
        }
        return avg;
    }
}