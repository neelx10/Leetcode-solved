class Solution {
    private boolean check(char[] s1, char[] s2, char[] s3, int i, int j, int k,int m,int n,int N,Boolean[][][] dp) {
        if (k == N) return (i == m && j == n);
        if (dp[i][j][k] != null) return dp[i][j][k];
        boolean option1 = false, option2 = false;
        if (i < m && s1[i] == s3[k]) option1 = check(s1, s2, s3, i + 1, j, k + 1, m, n, N, dp);
        if (j < n && s2[j] == s3[k]) option2 = check(s1, s2, s3, i, j + 1, k + 1, m, n, N, dp);
        return dp[i][j][k] = option1 || option2;
    }
    
    public boolean isInterleave(String s1, String s2, String s3) {
        int m=s1.length(),n=s2.length(),N=s3.length();
        Boolean[][][] dp=new Boolean[m+1][n+1][N+1];
        return check(s1.toCharArray(),s2.toCharArray(),s3.toCharArray(),0,0,0,m,n,N,dp);
    }
}