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
    
    static int palindromicPartition(String str)
    {
        // code here
        int n=str.length();
        int[] dp=new int[n+1];
        for(int i=n-1;i>=0;i--){
            int minSum=(int)1e9;
            for(int ind=i;ind<n;ind++){
                if(isPalindrome(i,ind,str)) minSum=Math.min(minSum,1+dp[ind+1]);
            }
            dp[i]=minSum;
        }
        return dp[0]-1;
    }
}