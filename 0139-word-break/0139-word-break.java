class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n=s.length();
        boolean[] dp=new boolean[n+1];
        dp[n]=true;
        for(int posi=n-1;posi>=0;posi--){
            StringBuilder temp=new StringBuilder();
            for(int i=posi;i<n;i++){
                temp=temp.append(s.charAt(i));
                if(wordDict.contains(temp.toString()) && dp[i+1]){
                    dp[posi]=true;
                    break;
                }
            }
        }
        return dp[0];
    }
}