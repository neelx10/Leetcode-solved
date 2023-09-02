class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        int n=s.length();
        int[] dp=new int[n+1];
        Set<String> set=new HashSet<>();
        for(String st:dictionary) set.add(st);
        for(int i=n-1;i>=0;i--){
            StringBuilder sb=new StringBuilder();
            int mini=n;
            for(int ind=i;ind<n;ind++){
                sb.append(s.charAt(ind));
                int temp1=(set.contains(sb.toString()))?0:sb.length();
                int temp2=dp[ind+1];
                mini=Math.min(mini,temp1+temp2);
            }
            dp[i]=mini;
        }
        return dp[0];
    }
}