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
                    int Arr[] = new int[n];
                    for(int i = 0;i<n;i++)
                        Arr[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.maxSumIS(Arr,n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
	public int maxSumIS(int a[], int size)  
	{  
	    //code here.
	    int[] dp=new int[size];
        int maxi=1;
        for(int ind=0;ind<size;ind++){
            dp[ind]=a[ind];
            for(int prev=0;prev<ind;prev++){
                if(a[ind]>a[prev] && a[ind]+dp[prev]>dp[ind]) dp[ind]=a[ind]+dp[prev];
            }
            maxi=Math.max(maxi,dp[ind]);
        }
        return maxi;
	}  
}