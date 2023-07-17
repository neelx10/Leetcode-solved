//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String str = br.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.LongestRepeatingSubsequence(str);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int LongestRepeatingSubsequence(String str)
    {
        // code here
        int n=str.length();
        int[] prev=new int[n+1];
        int[] cur=new int[n+1];
        
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(i!=j && str.charAt(i-1)==str.charAt(j-1)) cur[j]=1+prev[j-1];
                else cur[j]=Math.max(prev[j],cur[j-1]);
            }
            prev=cur.clone();
        }
        return prev[n];
    }
}