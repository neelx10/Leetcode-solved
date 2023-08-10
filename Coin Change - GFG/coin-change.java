//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int sum = sc.nextInt();
            int N = sc.nextInt();
            int coins[] = new int[N];
            for (int i = 0; i < N; i++) coins[i] = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.count(coins, N, sum));
        }
    }
}


// } Driver Code Ends


// User function Template for Java

class Solution {
    public long count(int coins[], int n, int amount) {
        // code here.
        long[] prev=new long[amount+1];
        prev[0]=1;
        for(int i=0;i<n;i++){
            for(int tar=0;tar<=amount;tar++){
                long notTake=prev[tar];
                long take=0;
                if(coins[i]<=tar) take=prev[tar-coins[i]];
                prev[tar]=take+notTake;
            }
        }
        return prev[amount];
    }
}