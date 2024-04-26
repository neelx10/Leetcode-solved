class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int ans=(int)1e9;
        int n=matrix.length;
        int[][] dp=new int[n][n];
        for(int[] row:dp) Arrays.fill(row,-1);
        for(int k=0;k<n;k++){
            ans=Math.min(ans,mini(0,k,n,dp,matrix));
        }
        return ans;
    }
     public int mini(int i,int j,int n,int[][] dp,int[][] matrix){
        if(j<0 || j>=n) return (int)1e9;
        if(i==n-1) return matrix[n-1][j];
        if(dp[i][j]!=-1) return dp[i][j];
        int ans=(int)1e9;
        for(int k=0;k<n;k++){
            if(k!=j) ans=Math.min(matrix[i][j]+mini(i+1,k,n,dp,matrix),ans);
        }
        return dp[i][j]=ans;
    }
}


