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
            int [][]points=new int[N][3];
            for(int i=0;i<N;i++){
                for(int j=0;j<3;j++){
                    points[i][j]=sc.nextInt();
                }
            }
            Solution obj=new Solution();
            int res=obj.maximumPoints(points,N);
            System.out.println(res);
            
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    public int solve(int ind,int prev,int[][] points,int[][] dp){
        if(ind==points.length) return 0;
        if(dp[ind][prev]!=-1) return dp[ind][prev];
        int temp=0,point=0;
        for(int i=0;i<3;i++){
            if(i!=prev) point=points[ind][i]+solve(ind+1,i,points,dp);
            temp=Math.max(temp,point);
        }
        return dp[ind][prev]=temp;
    }
    public int maximumPoints(int points[][],int N){
        //code here
        int[][] dp=new int[N][4];
        for(int[] r:dp) Arrays.fill(r,-1);
        return solve(0,3,points,dp);
    }
}