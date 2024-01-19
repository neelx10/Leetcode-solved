class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n=matrix.length;
        int[][] dp=new int[n][n];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==0) dp[i][j]=matrix[0][j];
                else{
                    int u=matrix[i][j];
                    if(i>0) u+=dp[i-1][j];
                    else u+=(int)1e9;
                    
                    int dgl=matrix[i][j];
                    if(i>0 && j>0) dgl+=dp[i-1][j-1];
                    else dgl+=(int)1e9;

                    int dgr=matrix[i][j];
                    if(i>0 && j<n-1) dgr+=dp[i-1][j+1];
                    else dgr+=(int)1e9;

                    dp[i][j]=Math.min(u,Math.min(dgl,dgr));
                }
            }
        }
        
        int ans=(int)1e9;
        for(int i=0;i<n;i++) ans=Math.min(ans,dp[n-1][i]);
        return ans;
    }
}