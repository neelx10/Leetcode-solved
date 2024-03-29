class Solution {
    private boolean solve(char[] s1, char[] s2, char[] s3, int i, int j,int m,int n,int N,Boolean[][] dp) {
        if (i+j == N) return (i == m && j == n);
        if (dp[i][j] != null) return dp[i][j];
        boolean flag1 = false, flag2 = false;
        if (i < m && s1[i] == s3[i+j]) flag1 = solve(s1, s2, s3, i + 1, j, m, n, N, dp);
        if (j < n && s2[j] == s3[i+j]) flag2 = solve(s1, s2, s3, i, j + 1, m, n, N, dp);
        return dp[i][j] = flag1 || flag2;
    }
    
    public boolean isInterleave(String s1, String s2, String s3) {
        int m=s1.length(),n=s2.length(),N=s3.length();
        if(m+n!=N) return false;
        Boolean[][] dp=new Boolean[m+1][n+1];
        return solve(s1.toCharArray(),s2.toCharArray(),s3.toCharArray(),0,0,m,n,N,dp);
    }
}