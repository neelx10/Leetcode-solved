class Solution {
    public int solve(int i,int j,String s1, String s2, int m,int n,int[][] dp){
        if(i==m && j==n) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        
        if(i==m) return dp[i][j]=s2.charAt(j)+solve(i,j+1,s1,s2,m,n,dp);
        if(j==n) return dp[i][j]=s1.charAt(i)+solve(i+1,j,s1,s2,m,n,dp);
        
        if(s1.charAt(i)==s2.charAt(j)) return dp[i][j]=solve(i+1,j+1,s1,s2,m,n,dp);
        return dp[i][j]=Math.min(s1.charAt(i)+solve(i+1,j,s1,s2,m,n,dp),s2.charAt(j)+solve(i,j+1,s1,s2,m,n,dp));
    }
    public int minimumDeleteSum(String s1, String s2) {
        int m=s1.length();
        int n=s2.length();
        int[][] dp=new int[1001][1001];
        for(int[] r:dp) Arrays.fill(r,-1);
        return solve(0,0,s1,s2,m,n,dp);
    }
}