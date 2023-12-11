class Solution {
    public int solve(int i,List<List<Integer>> piles,int k,int[][] dp){
        if(i==piles.size()) return 0;
        if(dp[i][k]!=0) return dp[i][k];
        int notTake=solve(i+1,piles,k,dp);
        int sum=0,take=(int)-1e9;
        for(int j=0;j<piles.get(i).size();j++){
            sum+=piles.get(i).get(j);
            if(k>=(j+1)) take=Math.max(take,sum+solve(i+1,piles,k-(j+1),dp));
        }
        return dp[i][k]=Math.max(take,notTake);
    }
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        int[][] dp=new int[piles.size()][k+1];
        return solve(0,piles,k,dp);
    }
}