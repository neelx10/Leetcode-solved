//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String s = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.distinctSubsequences(s));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int distinctSubsequences(String str) {
        // code here
        int mod=(int)Math.pow(10,9)+7;
        int n=str.length();
        if(n==0) return 1;
        HashMap<Character,Integer> map = new HashMap<>();
        int dp[] = new int[n+1];
        dp[0] = 1; dp[1]=2;
        map.put(str.charAt(0),0);
        for(int i=2; i<=n; i++){
            dp[i]=(2*dp[i-1])%mod;
            if(map.containsKey(str.charAt(i-1))){
                dp[i]=(dp[i]-dp[map.get(str.charAt(i-1))])%mod;
                if(dp[i]<0) dp[i]+=mod;
            }
            map.put(str.charAt(i-1),i-1);
        }
        return dp[n];
    }
}