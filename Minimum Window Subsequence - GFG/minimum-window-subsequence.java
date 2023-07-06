//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            sc.nextLine();
            String s1 = sc.next();
            String s2 = sc.next();
            Solution obj = new Solution();
            String ans = obj.minWindow(s1, s2);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static String minWindow(String s, String t) {
        // code here
        int i = 0;
        int ans = Integer.MAX_VALUE;
        int minPos = 0;
        
        while (i <= s.length()-t.length()) {
            if (s.charAt(i) == t.charAt(0)) {
                int k = i;
                int j = 0;
                while (k < s.length() && j < t.length()) {
                    if (s.charAt(k) == t.charAt(j)) {
                        k++;
                        j++;
                    } 
                    else k++;
                }
                if (j == t.length() && ans > k - i) {
                    ans = k - i;
                    minPos = i;
                }
            }
            i++;
        }
        if (ans != Integer.MAX_VALUE) return s.substring(minPos, minPos + ans);
        return "";
    }
}
