class Solution {
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        int[][] dp=new int[piles.size()+1][k+1];
        for(int i=piles.size()-1;i>=0;i--){
            for(int K=0;K<=k;K++){
                int notTake=dp[i+1][K];
                int sum=0,take=(int)-1e9;
                for(int j=0;j<Math.min(K,piles.get(i).size());j++){
                    sum+=piles.get(i).get(j);
                    take=Math.max(take,sum+dp[i+1][K-(j+1)]);
                }
                dp[i][K]=Math.max(take,notTake);
            }
        }
        return dp[0][k];
    }
}