//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String str = in.readLine();
            Solution ob = new Solution();
            System.out.println(ob.palindromicPartition(str));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static boolean isPalindrome(int i, int j,String str){
        while(i<=j){
            if(str.charAt(i)!=str.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
    
    static int solve(int i,String str,int n,int[] dp){
        if(i==n) return 0;
        if(dp[i]!=-1) return dp[i];
        int minSum=(int)1e9;
        for(int ind=i;ind<n;ind++){
            if(isPalindrome(i,ind,str)) minSum=Math.min(minSum,1+solve(ind+1,str,n,dp));
        }
        return dp[i]=minSum;
    }
    
    static int palindromicPartition(String str)
    {
        // code here
        int n=str.length();
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
        return solve(0,str,n,dp)-1;
    }
}