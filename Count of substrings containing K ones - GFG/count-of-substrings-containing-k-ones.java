//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String input[] = read.readLine().trim().split(" ");
            String s = input[0];
            int k = Integer.parseInt(input[1]);
            Solution ob = new Solution();
            System.out.println(ob.countOfSubstringWithKOnes(s, k));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    private long atmost(String s,int x){
        int i=0,j=0,count=0;
        long res=0;
        while(j<s.length()){
            char c=s.charAt(j);
            if(c=='1') count++;
            while(i<=j && count>x){
                if(s.charAt(i)=='1') count--;
                i++;
            }
            res+=(j-i+1);
            j++;
        }
        return res;
    }
    
    long countOfSubstringWithKOnes(String S, int K){
        //  code here
        return atmost(S,K)-atmost(S,K-1);
    }
}