class Solution {
    public int solve(int i,String s,Set<String> set, int n,int[] dp){
        if(i==n) return 0;
        if(dp[i]!=-1) return dp[i];
        StringBuilder sb=new StringBuilder();
        int mini=n;
        for(int ind=i;ind<n;ind++){
            sb.append(s.charAt(ind));
            int temp1=(set.contains(sb.toString()))?0:sb.length();
            int temp2=solve(ind+1,s,set,n,dp);
            mini=Math.min(mini,temp1+temp2);
        }
        return dp[i]=mini;
    }
    
    public int minExtraChar(String s, String[] dictionary) {
        int n=s.length();
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
        Set<String> set=new HashSet<>();
        for(String st:dictionary) set.add(st);
        return solve(0,s,set,n,dp);
    }
}