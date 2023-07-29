public class Solution {
    public double solve(int A, int B,int[][] serves,double[][] dp) {
        if (A <= 0 && B <= 0) return 0.5;
        if (A <= 0) return 1.0;
        if (B <= 0) return 0.0;

        if (dp[A][B] != -1.0) return dp[A][B];

        double probability = 0.0;

        for (int[] p : serves) probability += 0.25 * solve(A - (int)p[0], B - (int)p[1],serves,dp);
        
        return dp[A][B] = probability;
    }

    public double soupServings(int n) {
        if (n >= 5000) return 1.0;     
        int[][] serves={{100,0},{75,25},{50,50},{25,75}};
        double[][] dp = new double[n+1][n+1];
        for(double[] r:dp) Arrays.fill(r,-1.0);
        return solve(n, n, serves, dp);
    }
}
