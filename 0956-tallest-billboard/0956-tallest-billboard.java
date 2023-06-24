class Solution {
    int[][] dp=new int[21][10003];
    public int solve(int[] rods,int idx, int diff){
        if(idx==rods.length){
            if(diff==0) return 0;
            return (int)-1e9;
        }
        if(dp[idx][diff+5000]!=-1) return dp[idx][diff+5000];
        int nothing=solve(rods,idx+1,diff);
        int l1rod=rods[idx]+solve(rods,idx+1,diff+rods[idx]);
        int l2rod=rods[idx]+solve(rods,idx+1,diff-rods[idx]);
        return dp[idx][diff+5000]=Math.max(nothing,Math.max(l1rod,l2rod));
    }
    public int tallestBillboard(int[] rods) {
        for(int[] r:dp) Arrays.fill(r,-1);
        return solve(rods,0,0)/2;
    }
}