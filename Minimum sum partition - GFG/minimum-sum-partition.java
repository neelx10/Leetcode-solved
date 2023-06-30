//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    int A[] = new int[n];
                    for(int i = 0;i<n;i++)
                        A[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minDifference(A,n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{

	public int minDifference(int nums[], int n) 
	{ 
	    // Your code goes here
        int totSum=0;
        for(int num:nums) totSum+=num;
        int target=totSum;
        boolean[][] dp=new boolean[n][target+1];

        for(int i=0;i<n;i++) dp[i][0]=true;
        if(nums[0]<=target) {dp[0][target]=true;}
        for(int i=1;i<n;i++){
            for(int k=1;k<=target;k++){
                boolean notTake=dp[i-1][k];
                boolean take=false;
                if(nums[i]<=k) take=dp[i-1][k-nums[i]];
                dp[i][k]=take || notTake;
            }
        }
        int ans=(int)1e9;
        for(int s1=0;s1<=totSum;s1++){
            if(dp[n-1][s1]==true){
                ans=Math.min(ans,Math.abs(s1-(totSum-s1)));
            }
        }
        return ans;
	} 
}
