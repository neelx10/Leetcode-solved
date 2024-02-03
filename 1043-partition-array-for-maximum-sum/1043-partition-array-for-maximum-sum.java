class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n=arr.length;
        int[] dp=new int[n+1];
        //dp[n]=0;   //base_case
        for(int i=n-1;i>=0;i--){
            int max=Integer.MIN_VALUE,len=0,big=Integer.MIN_VALUE;
            for(int ind=i;ind<Math.min(n,i+k);ind++){
            len++;
            big=Math.max(big,arr[ind]);
            int sum=big*len+dp[ind+1];
            max=Math.max(max,sum);
        }
        dp[i]=max;
        }
        return dp[0];
    }
}