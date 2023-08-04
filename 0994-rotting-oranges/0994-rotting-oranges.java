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
        int n=grid.length;
        int m=grid[0].length;
        int[][] visited=new int[n][m];
        int fresh=0;
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1) fresh++;
                else if(grid[i][j]==2){
                    visited[i][j]=1;
                    q.offer(new int[]{i,j});
                }
            }
        }
        
        int[] dr={-1,0,1,0};
        int[] dc={0,1,0,-1};
        int count=0;
        int time=0;
        while(!q.isEmpty()){
            int len=q.size();
            time++;
            while(len-- > 0){
                int[] temp=q.poll();
                int row=temp[0];
                int col=temp[1];
                for(int i=0;i<4;i++){
                    int nrow=row+dr[i];
                    int ncol=col+dc[i];
                    if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && visited[nrow][ncol]==0 && grid[nrow][ncol]==1){
                        visited[nrow][ncol]=1;
                        count++;
                        q.offer(new int[]{nrow,ncol});
                    }
                }
            }
        }
        return (count!=fresh)?-1:(time==0)?0:time-1;
    }
}