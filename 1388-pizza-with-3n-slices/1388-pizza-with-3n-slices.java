class Solution {
    public int maxSizeSlices(int[] slices) {
        int n = slices.length;
        int k = n / 3;

        int[][] dp1 = new int[n+1][k + 1];
        int[][] dp2 = new int[n+2][k + 1];
        
        for (int i = n-2; i>=0; i--) {
            for (int j = 1; j <= k; j++) {
                dp1[i][j]=Math.max(dp1[i+1][j],slices[i]+dp1[i+2][j-1]);
            }
        }

        for (int i = n-1; i>=1; i--) {
            for (int j = 1; j <= k; j++) {
                dp2[i][j]=Math.max(dp2[i+1][j],slices[i]+dp2[i+2][j-1]);
            }
        }
        
        return Math.max(dp1[0][k], dp2[1][k]);
    }
}




  