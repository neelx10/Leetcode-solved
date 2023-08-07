class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[2]-b[2]);
        pq.add(new int[]{0,0,grid[0][0]});
        boolean[][] vis = new boolean[n][n];
        int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};
        while(!pq.isEmpty()){
            int[] temp = pq.poll();
            int row=temp[0],col=temp[1],time=temp[2];
            if(row == n - 1 && col == n - 1) return time;
            if(vis[row][col] == false){
                vis[row][col] = true;
                for(int i = 0; i < 4; i++){
                    int nrow = row + dir[i][0];
                    int ncol = col + dir[i][1];
                    if(nrow>=0 && ncol>=0 && nrow < n && ncol < n && vis[nrow][ncol] == false){
                        pq.offer(new int[]{nrow, ncol, Math.max(time , grid[nrow][ncol])});
                    }
                } 
            }
        }
        return -1;
    }
}