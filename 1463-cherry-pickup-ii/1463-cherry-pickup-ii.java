class Solution {
    public int solve(int i,int j1,int j2,int[][] grid,int rows, int cols,int[][][] dp){
        if(j1<0 || j2<0 || j1==cols || j2==cols) return -1;
        if(i==rows-1){
            if(j1==j2) return grid[i][j1];
            else return grid[i][j1]+grid[i][j2];
        }
        if(dp[i][j1][j2]!=-1) return dp[i][j1][j2];
        int maxi=-1;
        for(int k=-1;k<=1;k++){
            for(int l=-1;l<=1;l++){
                if(j1==j2) maxi=Math.max(maxi,grid[i][j1]+solve(i+1,j1+k,j2+l,grid,rows,cols,dp));
                else maxi=Math.max(maxi,grid[i][j1]+grid[i][j2]+solve(i+1,j1+k,j2+l,grid,rows,cols,dp));
            }
        }
        return dp[i][j1][j2]=maxi;
    }
    public int cherryPickup(int[][] grid) {
        int rows=grid.length;
        int cols=grid[0].length;
        int[][][] dp=new int[rows][cols][cols];
        for(int[][] r:dp){
            for(int[] rr: r) Arrays.fill(rr,-1);
        }
        return solve(0,0,cols-1,grid,rows,cols,dp);
    }
}