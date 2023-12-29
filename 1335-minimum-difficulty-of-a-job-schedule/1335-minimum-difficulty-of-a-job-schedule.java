class Solution {
    public int minDifficulty(int[] arr, int d) {
        int n=arr.length;
        if(n<d) return -1;
        int[][] dp=new int[n+1][d+1];
        int mx=arr[n-1];
        dp[n-1][1]=mx;
        for(int i=n-2;i>=0;i--){
            if(arr[i]>mx) mx=arr[i];
            dp[i][1]=mx;
        }
        for(int ind=n-1;ind>=0;ind--){
            for(int days=2;days<=d;days++){
                int maxi=arr[ind],ans=(int)1e9;
                for(int i=ind;i<=n-days;i++){
                    maxi=Math.max(maxi,arr[i]);
                    ans=Math.min(ans,maxi+dp[i+1][days-1]);
                }
                dp[ind][days]=ans;
            }
        }
        return dp[0][d];
    }
}