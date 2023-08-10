//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int sum = sc.nextInt();
            int N = sc.nextInt();
            int coins[] = new int[N];
            for (int i = 0; i < N; i++) coins[i] = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.count(coins, N, sum));
        }
    }
}


// } Driver Code Ends


// User function Template for Java

class Solution {
    public long ways(int ind,int target,int[] coins,long[][] dp){
        if(ind==0){
            if(target%coins[ind]==0) return 1;
            else return 0;
        }
        if(dp[ind][target]!=-1) return dp[ind][target];
        long notTake=ways(ind-1,target,coins,dp);
        long take=0;
        if(coins[ind]<=target) take=ways(ind,target-coins[ind],coins,dp);
        return dp[ind][target]=take+notTake;
    }
    public long count(int coins[], int n, int amount) {
        // code here.
        long[][] dp=new long[n][amount+1];
        for(long[] row:dp) Arrays.fill(row,-1);
        return ways(n-1,amount,coins,dp);
    }
}