//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int N = sc.nextInt();
            int K = sc.nextInt();

            Solution ob = new Solution();
            int ans = ob.kvowelwords(N,K);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    private static final int mod = (int)(1e9+7);
    private static int tmp;
    private static int find(int N, int K,Integer[][] dp){
        if(N == 0) return 1;
        if(dp[N][K] != null) return dp[N][K];
        int count = 0;
        for(char c = 'a'; c <= 'z'; c++){
            if(c=='a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'){
               if(K > 0) count = (count + find(N-1, K-1,dp)) % mod;
            }
            else count = (count + find(N-1, tmp,dp)) % mod;
        }
        return dp[N][K] = count;
    }
    
    public int kvowelwords(int N,int K){
        // code here
        Integer[][] dp = new Integer[N+1][K+1];
        tmp = K;
        return find(N, K, dp);
    }
}
