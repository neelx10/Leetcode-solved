class Solution {
    public int solve(int[] days,int[] costs, int n,int idx,int[] dp){
        if(idx==n) return 0;
        if(dp[idx]!=0) return dp[idx];
            
        int cost1=costs[0]+solve(days,costs,n,idx+1,dp);
        
        int i=idx;
        while(i<n && days[i]<days[idx]+7) i++;
        int cost2=costs[1]+solve(days,costs,n,i,dp);
        
        i=idx;
        while(i<n && days[i]<days[idx]+30) i++;
        int cost3=costs[2]+solve(days,costs,n,i,dp);
        
        return dp[idx]=Math.min(cost1,Math.min(cost2,cost3));
    }
    public int mincostTickets(int[] days, int[] costs) {
        int n=days.length;
        int[] dp=new int[n];
        return solve(days,costs,n,0,dp);
    }
}