class Solution {
    public int bfs(int[][] grid,int m,int n,int i){
        int[] dr={-1,0,1};
        int[] dc={1,1,1};
        int steps=0;
        Queue<int[]> q=new LinkedList<>();
        int[][] visited=new int[m][n];
        visited[i][0]=1;
        q.offer(new int[]{i,0,0});
        while(!q.isEmpty()){
            int[] temp=q.poll();
            int row=temp[0];
            int col=temp[1];
            steps=temp[2];
            for(int k=0;k<3;k++){
                int nrow=row+dr[k];
                int ncol=col+dc[k];
                if(nrow>=0 && ncol>=0 && nrow<m && ncol<n && visited[nrow][ncol]==0 && grid[nrow][ncol]>grid[row][col]){
                    visited[nrow][ncol]=1;
                    q.add(new int[]{nrow,ncol,steps+1});
                }
            }
        }
        return steps;
    }
    
    public int maxMoves(int[][] grid) {
        int res=0;
        int m=grid.length;
        int n=grid[0].length;
        for(int i=0;i<m;i++) res=Math.max(res,bfs(grid,m,n,i));
        return res;
    }
}