//{ Driver Code Starts
import java.util.*;
import java.io.*;

class GFG
 {
	public static void main (String[] args)
	 {
	  
	  //taking input using Scanner class
	  Scanner sc = new Scanner(System.in);
	  
	  //taking count of testcases
	  int t = sc.nextInt();
	  while(t-- > 0){
	      
	      //taking count of houses
	      int n = sc.nextInt();
	      int arr[] = new int[n];
	      
	      //inserting money present in 
	      //each house in the array
	      for(int i = 0; i<n; ++i)
	           arr[i] = sc.nextInt();
  	      
  	      //calling method FindMaxSum() of class solve
  	      System.out.println(new Solution().FindMaxSum(arr, n));
	 }
   }
}
// } Driver Code Ends


class Solution
{
    //Function to find the maximum money the thief can get.
    private int func(int[] arr,int n,int index,int prev,int[] dp){
        if(index<0) return 0;
        if(dp[index]!=-1) return dp[index];
        return dp[index]=Math.max(arr[index]+func(arr,n,index-2,index,dp),func(arr,n,index-1,prev,dp));
    }
    
    public int FindMaxSum(int arr[], int n)
    {
        // Your code here
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
        return func(arr,n,n-1,-1,dp);
    }
}