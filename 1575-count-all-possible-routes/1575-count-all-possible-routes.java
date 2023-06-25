class Solution {
    public int mod=(int)(1e9+7);
    public int solve(int[] locations, int start, int finish, int fuel,int[][] dp){
        if(fuel<0) return 0;
        if(dp[start][fuel]!=-1) return dp[start][fuel];
        int routes=0;
        if(start==finish) routes=1;   
        for(int i=0;i<locations.length;i++){
            if(i!=start){
                routes=(routes+solve(locations,i,finish,fuel-Math.abs(locations[i]-locations[start]),dp))%mod;
            }
        }
        return dp[start][fuel]=routes;
    }
    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        int[][] dp=new int[locations.length][fuel+1];
        for(int[] r:dp) Arrays.fill(r,-1);
        return solve(locations,start,finish,fuel,dp);
    }
}