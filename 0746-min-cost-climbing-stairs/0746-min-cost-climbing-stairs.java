class Solution {
    //Space Optimized using two pointer
    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
        int prev1=cost[1];
        int prev2=cost[0];
        for(int i=2;i<=n;i++){
            if(i==n){return Math.min(prev1,prev2);}
            int cur=Math.min(prev1,prev2)+cost[i];
            prev2=prev1;
            prev1=cur;
        }
        return -1;
    }
}

