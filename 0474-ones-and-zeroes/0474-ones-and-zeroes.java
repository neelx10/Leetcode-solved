class Solution {
    public int solve(int ind,String[] strs, int m, int n,Map<Integer,int[]> map,int[][][] dp){
        if (ind == strs.length || (m == 0 && n == 0)) return 0;
        if(dp[ind][m][n]!=-1) return dp[ind][m][n];
        int notTake=solve(ind+1,strs,m,n,map,dp);
        int take=0;
        int[] temp=map.get(ind);
        if(temp[0]<=m && temp[1]<=n) take=1+solve(ind+1,strs,m-temp[0],n-temp[1],map,dp);
        return dp[ind][m][n]=Math.max(notTake,take);
    }
    public int findMaxForm(String[] strs, int m, int n) {
        int[][][] dp=new int[strs.length][m+1][n+1];
        for(int[][] r:dp){
            for(int[] row:r) Arrays.fill(row,-1);
        }
        Map<Integer,int[]> map=new HashMap<>();
        for(int i=0;i<strs.length;i++){
            int zeros=0,ones=0;
            for(char c:strs[i].toCharArray()){
                if(c=='0') zeros++;
                else ones++;
            }
            map.put(i,new int[]{zeros,ones});
        }
        return solve(0,strs,m,n,map,dp);
    }
}