class Solution {
    public int solveOnlyForAlice(int[] piles,int whoseTurn,int i,int M,int n,int[][][] dp){
        if(i==n) return 0;
        if(dp[whoseTurn][i][M]!=0) return dp[whoseTurn][i][M];
        int stones=0;
        int result=(int)1e9;
        if(whoseTurn==1) result=-(int)1e9;
        else result=(int)1e9;
        for(int x=1;x<=Math.min(2*M,n-i);x++){
            stones+=piles[i+x-1];
            if(whoseTurn==1) result=Math.max(result,stones+solveOnlyForAlice(piles,0,i+x,Math.max(M,x),n,dp));
            else result=Math.min(result,solveOnlyForAlice(piles,1,i+x,Math.max(M,x),n,dp));
        }
        return dp[whoseTurn][i][M]=result;
    }
    public int stoneGameII(int[] piles) {
        int n=piles.length;
        int[][][] dp=new int[2][n+1][n+1];
        // for(int[][] r:dp){
        //     for(int[] rr:r) Arrays.fill(rr,-1);
        // }
        return solveOnlyForAlice(piles,1,0,1,n,dp);
    }
}