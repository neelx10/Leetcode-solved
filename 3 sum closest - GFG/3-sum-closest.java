//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int Arr[]= new int[N];
            for(int i = 0; i < N; i++)
                Arr[i] = Integer.parseInt(input_line[i]);
            int X = Integer.parseInt(read.readLine());
            
            Solution ob = new Solution();
            System.out.println(ob.closest3Sum(Arr, N, X));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    static int closest3Sum(int nums[], int n, int X)
    {
        // code here
        int diff=(int)1e9;
        int res=0;
        Arrays.sort(nums);
        for(int i=0;i<n-2;i++){
            int j=i+1,k=n-1;
            while(j<k){
                int temp=nums[i]+nums[j]+nums[k];
                if(temp==X) return temp;
                else if(temp>X) k--;
                else j++;
                if(Math.abs(X-temp)<diff){
                    diff=Math.abs(X-temp);
                    res=temp;
                }
            }
        }
        return res;
    }
}