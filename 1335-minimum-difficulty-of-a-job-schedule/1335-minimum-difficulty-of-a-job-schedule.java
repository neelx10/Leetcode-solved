class Solution {
    public int solve(int ind,int days,int[] arr,int n,int[][] dp){
        if(days==1){
            int maxi=arr[ind];
            for(int i=ind;i<arr.length;i++) maxi=Math.max(maxi,arr[i]);
            return maxi;
        }
        if(dp[ind][days]!=-1) return dp[ind][days];

        int maxi=arr[ind],ans=(int)1e9;
        for(int i=ind;i<=n-days;i++){
            maxi=Math.max(maxi,arr[i]);
            ans=Math.min(ans,maxi+solve(i+1,days-1,arr,n,dp));
        }
        return dp[ind][days]=ans;
    }

    public int minDifficulty(int[] jobDifficulty, int d) {
        int n=jobDifficulty.length;
        if(n<d) return -1;
        int[][] dp=new int[n+1][d+1];
        for(int[] row:dp) Arrays.fill(row,-1);
        return solve(0,d,jobDifficulty,n,dp);
    }
}