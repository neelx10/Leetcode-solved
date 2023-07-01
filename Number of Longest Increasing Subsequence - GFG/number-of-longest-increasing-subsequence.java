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
            int res=obj.NumberofLIS(N, arr);
            System.out.println(res);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    public int NumberofLIS(int size, int a[]){
        // Code here
        int[] dp=new int[size];
        int[] count=new int[size];
        int maxi=1;
        for(int ind=0;ind<size;ind++){
            dp[ind]=1;
            count[ind]=1;
            for(int prev=0;prev<ind;prev++){
                if(a[ind]>a[prev] && 1+dp[prev]>dp[ind]){
                     dp[ind]=1+dp[prev];
                     count[ind]=count[prev];
                }
                else if(a[ind]>a[prev] && 1+dp[prev]==dp[ind]) count[ind]+=count[prev];
            }
            maxi=Math.max(maxi,dp[ind]);
        }
        
        int ans=0;
        for(int i=0;i<size;i++){
            if(dp[i]==maxi) ans+=count[i];
        }
        return ans;
    }
}