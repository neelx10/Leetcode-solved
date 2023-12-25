class Solution {
    public int numDecodings(String s) {
        int n=s.length();
        int[] dp=new int[n+1];
        dp[n]=1;
        for(int i=n-1;i>=0;i--){
            if(!(s.charAt(i)=='0')){
                int ways=dp[i+1];
                if(i<s.length()-1 && (s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i+1) <= '6'))) ways+=dp[i+2];
                dp[i]=ways;
            }
        }
        return dp[0];
    }
}