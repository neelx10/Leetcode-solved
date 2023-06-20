class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] == 1 || grid[n-1][n-1]==1) return -1;
        Queue<int[]> q=new LinkedList<>();
        q.offer(new int[]{0,0});
        grid[0][0]=-1;
        int path=0;
        while(!q.isEmpty()){
            path++;
            for(int i = q.size() - 1; i >= 0; i--){
                int[] temp=q.poll();
                int r=temp[0],c=temp[1];
                if(r == n-1 && c==n-1) return path;
                for(int drow=-1;drow<=1;drow++){
                    for(int dcol=-1;dcol<=1;dcol++){
                        int nrow=r+drow;
                        int ncol=c+dcol;
                        if(nrow>=0 && nrow<n && ncol>=0 && ncol<n && grid[nrow][ncol]==0){
                            grid[nrow][ncol]=-1;
                            q.offer(new int[]{nrow,ncol});
                        }
                    }
                }
            }
        }
        return -1;
    }
}





