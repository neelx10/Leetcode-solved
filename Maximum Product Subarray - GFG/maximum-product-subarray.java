//{ Driver Code Starts
import java.io.*;
import java.util.*;

  public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            String[] inputLine = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            System.out.println(new Solution().maxProduct(arr, n));
        }
    }
}

// } Driver Code Ends


class Solution {
    // Function to find maximum product subarray
    long maxProduct(int[] arr, int n) {
        // code here
        long maxLeft = arr[0];
	    long maxRight = arr[0];
	    
	    boolean zeroPresent = false;
	    
	    long prod = 1;
	    
	    for(int i:arr) {
	        prod *= i;
	        if(i == 0) {
	            zeroPresent = true;
	            prod = 1;
	            continue;
	        }
	        maxLeft = Math.max(maxLeft,prod);
	    }
	    
	    prod = 1;
	    
	    for(int j=arr.length-1;j>=0;j--) {
	        prod *= arr[j];
	        if(arr[j] == 0) {
	            zeroPresent = true;
	            prod = 1;
	            continue;
	        }
	        maxRight = Math.max(maxRight,prod);
	    }
	    
	    if(zeroPresent) return Math.max(Math.max(maxLeft,maxRight),0);
	    return Math.max(maxLeft,maxRight);  
    }
}