class Solution {
    int[] dr={-1,0,1,0};
    int[] dc={0,1,0,-1};
    public int solve(int[][] grid,int row,int col,int m,int n,int[][] dp){
        if(dp[row][col]!=0) return dp[row][col];
        for(int i=0;i<4;i++){
            int nrow=row+dr[i];
            int ncol=col+dc[i];
            if(nrow>=0 && nrow<m && ncol>=0 && ncol<n && grid[nrow][ncol]>grid[row][col]){
                dp[row][col]=Math.max(dp[row][col],solve(grid,nrow,ncol,m,n,dp));
            }
        }
        return ++dp[row][col];
    }
    public int longestIncreasingPath(int[][] grid) {
        int maxi=0;
        int m=grid.length,n=grid[0].length;
        int[][] dp=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                maxi=Math.max(maxi,solve(grid,i,j,m,n,dp));
            }
        }
        return maxi;
    }
}







