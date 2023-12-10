class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int n=days.length;
        int[] dp=new int[n+1];
        for(int idx=n-1;idx>=0;idx--){
            int cost1=costs[0]+dp[idx+1];
        
            int i=idx;
            while(i<n && days[i]<days[idx]+7) i++;
            int cost2=costs[1]+dp[i];

            i=idx;
            while(i<n && days[i]<days[idx]+30) i++;
            int cost3=costs[2]+dp[i];

            dp[idx]=Math.min(cost1,Math.min(cost2,cost3));
        }
        return dp[0];
    }
}