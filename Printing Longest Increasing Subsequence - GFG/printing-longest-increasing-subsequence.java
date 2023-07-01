//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG{
    public static void main(String args[]) throws IOException{
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int N=sc.nextInt();
            int []arr=new int[N];
            for(int i=0;i<N;i++){
                arr[i]=sc.nextInt();
            }
            Solution obj=new Solution();
            ArrayList<Integer>ans=obj.longestIncreasingSubsequence(N, arr);
            for(int i=0;i<ans.size();i++){
                System.out.print(ans.get(i)+" ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    public ArrayList<Integer> longestIncreasingSubsequence(int size, int a[]){
        // Code here
        int[] dp=new int[size];
        int maxi=1,lastind=0;
        int[] hash=new int[size];
        
        for(int ind=0;ind<size;ind++){
            dp[ind]=1;
            hash[ind]=ind;
            for(int prev=0;prev<ind;prev++){
                if(a[ind]>a[prev] && 1+dp[prev]>dp[ind]){
                     dp[ind]=1+dp[prev];
                     hash[ind]=prev;
                     if(dp[ind]>maxi){
                        maxi=Math.max(maxi,dp[ind]);
                        lastind=ind;
                     }
                }
            }
        }
        
        ArrayList<Integer> list=new ArrayList<>();
        list.add(a[lastind]);
        while(hash[lastind]!=lastind){
            lastind=hash[lastind];
            list.add(0,a[lastind]);
        }
        return list;
    }
}
