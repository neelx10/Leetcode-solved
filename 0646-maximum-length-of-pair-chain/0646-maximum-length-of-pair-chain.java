class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs,(a,b)->a[0]-b[0]);
        int n=pairs.length;
        int[] dp=new int[n];
        Arrays.fill(dp,1);
        int maxi=1;
        for(int ind=0;ind<n;ind++){
            for(int prev=0;prev<ind;prev++){
                if(pairs[ind][0]>pairs[prev][1] && 1+dp[prev]>dp[ind]) dp[ind]=1+dp[prev];
            }
            if(maxi<dp[ind]) maxi=dp[ind];
        }
        return maxi;
    }
}