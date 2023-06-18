class Solution {
    int mod=(int)(1e9+7);
    int[] dr={-1,0,1,0};
    int[] dc={0,1,0,-1};
    public int solve(int[][] grid,int row,int col,int m,int n,int[][] dp){
        if(dp[row][col]!=0) return dp[row][col];
        int count=1;
        for(int i=0;i<4;i++){
            int nrow=row+dr[i];
            int ncol=col+dc[i];
            if(nrow>=0 && nrow<m && ncol>=0 && ncol<n && grid[nrow][ncol]>grid[row][col]){
                count=(count+solve(grid,nrow,ncol,m,n,dp)%mod)%mod;
            }
        }
        return dp[row][col]=count;
    }
    public int countPaths(int[][] grid) {
        int count=0;
        int m=grid.length,n=grid[0].length;
        int[][] dp=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                count=(count+solve(grid,i,j,m,n,dp)%mod)%mod;
            }
        }
        return count;
    }
}