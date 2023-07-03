//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }
            Solution obj = new Solution();
            List<Integer> res = obj.LargestSubset(N, arr);
            int isValidSeq = 1, sz = res.size();
            for (int i = 0; i < sz; i++) {
                for (int j = i + 1; j < sz; j++) {
                    if ((res.get(i) % res.get(j) == 0) ||
                        (res.get(j) % res.get(i) == 0))
                        continue;
                    else {
                        isValidSeq = 0;
                        break;
                    }
                }
            }
            System.out.println(isValidSeq + " " + sz);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public List<Integer> LargestSubset(int size, int[] a) {
        // Code here
        int[] dp=new int[size];
        int maxi=1,lastind=0;
        int[] hash=new int[size];
        
        Arrays.sort(a);
        
        for(int ind=0;ind<size;ind++){
            dp[ind]=1;
            hash[ind]=ind;
            for(int prev=0;prev<ind;prev++){
                if(a[ind]%a[prev]==0 && 1+dp[prev]>dp[ind]){
                     dp[ind]=1+dp[prev];
                     hash[ind]=prev;
                }
            }
            if(dp[ind]>maxi){
                maxi=dp[ind];
                lastind=ind;
            }
        }
        
        List<Integer> list=new ArrayList<>();
        list.add(a[lastind]);
        while(hash[lastind]!=lastind){
            lastind=hash[lastind];
            list.add(0,a[lastind]);
        }
        return list;
    }
}
