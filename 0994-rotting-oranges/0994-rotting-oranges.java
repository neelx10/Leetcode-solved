class Pair{
    int row;
    int col;
    int time;
    public Pair(int row,int col,int time){
        this.row=row;
        this.col=col;
        this.time=time;
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        Queue<Pair> q=new LinkedList<>();
        int[][] visited=new int[m][n];
        int freshOranges=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1) freshOranges++;
                else if(grid[i][j]==2){
                    visited[i][j]=1;
                    q.add(new Pair(i,j,0));                           //0 --> time
                }
            }
        }

        int count=0;
        int minTime=0;
        int[] delr={-1,0,1,0};
        int[] delc={0,1,0,-1};
        while(!q.isEmpty()){
            int r=q.peek().row;
            int c=q.peek().col;
            int t=q.peek().time;
            minTime=Math.max(minTime,t);
            q.poll();
            for(int i=0;i<4;i++){
                int nrow=r+delr[i];
                int ncol=c+delc[i];
                if (nrow >= 0 && nrow < m && ncol >= 0 && ncol < n && visited[nrow][ncol] == 0 && grid[nrow][ncol] == 1){
                    visited[nrow][ncol]=1;
                    q.add(new Pair(nrow,ncol,t+1));
                    count++;
                }
            }
        }

        if(count!=freshOranges) return -1;
        return minTime;
    }
}