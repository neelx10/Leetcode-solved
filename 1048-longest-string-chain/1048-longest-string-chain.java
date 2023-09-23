class Solution {
    
    public boolean isValid(String cur,String prev){
        if(1+prev.length()!=cur.length()) return false;
        int first=0,second=0;
        while(first<cur.length()){
            if(second<prev.length() && cur.charAt(first)==prev.charAt(second)) second++;
            first++;
        }
        return first==cur.length() && second==prev.length();
    }

    public int longestStrChain(String[] words) {
        Arrays.sort(words,(a,b)->a.length()-b.length());
        int n=words.length;
        int[] dp=new int[n];
        Arrays.fill(dp,1);
        int ans=1;
        for(int ind=1;ind<n;ind++){
            for(int prev=0;prev<ind;prev++){
                if(isValid(words[ind],words[prev]) && 1+dp[prev]>dp[ind]) dp[ind]=1+dp[prev];
                ans=Math.max(dp[ind],ans);
            }
        }
        return ans;
    }
}