//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            String s = sc.next ();
            int k = sc.nextInt();
    		System.out.println (new Solution().substrCount (s, k));
        }
        
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    long solve(String S,int K){
        int[] hash=new int[26];
        long count=0;
        long ans=0;
        int i=0,j=0;
        while(j<S.length()){
            hash[S.charAt(j)-'a']++;
            if(hash[S.charAt(j)-'a']==1) count++;
            while(count>K){
                hash[S.charAt(i)-'a']--;
                if(hash[S.charAt(i)-'a']==0) count--;
                i++;
            }
            ans+=(j-i+1);
            j++;
        }
        return ans;
    }
    long substrCount (String S, int K) {
        // your code here
        return solve(S,K) - solve(S,K-1);
    }
}