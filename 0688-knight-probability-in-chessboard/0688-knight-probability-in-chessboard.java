class Solution {
    int[] dr={-2,-2,-1,1,2,2,1,-1};
    int[] dc={-1,1,2,2,1,-1,-2,-2};
    public double solve(int row, int col, int k,int n,double[][][] dp){
        if(row<0 || row>=n || col<0 || col>=n) return 0;
        if(k==0) return 1;
        
        if(dp[row][col][k]!=0) return dp[row][col][k];
        
        double result=0;
        for(int i=0;i<8;i++) result+=solve(row+dr[i],col+dc[i],k-1,n,dp);
        
        return dp[row][col][k]=result/8.0;
    }
    public double knightProbability(int n, int k, int row, int column) {
        double[][][] dp=new double[n][n][k+1];
        return solve(row,column,k,n,dp);
    }
}