class Solution {
    int[] delrow={-1,0,1,0,0};
    int[] delcol={0,-1,0,1,0};
    public int numIslands(char[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[][] visited=new int[m][n];
        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1' && visited[i][j]==0){
                    count++;
                    dfs(grid,visited,i,j,m,n);
                }
            }
        }
        return count;
    }
    
    public void dfs(char[][] grid,int[][] visited,int i,int j,int m,int n){
        for(int k=0;k<5;k++){
            int nrow=i+delrow[k];
            int ncol=j+delcol[k];
            if(nrow>=0 && nrow<m && ncol>=0 && ncol<n && grid[nrow][ncol]=='1' && visited[nrow][ncol]==0){
                visited[i][j]=1;
                dfs(grid,visited,nrow,ncol,m,n);
            }
        }
    }
}

