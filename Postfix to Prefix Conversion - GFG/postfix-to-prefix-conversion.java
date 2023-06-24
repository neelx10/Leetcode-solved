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
            String s = sc.next();
            Solution obj = new Solution();
            String ans = obj.postToPre(s);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static String postToPre(String post_exp) {
        // code here
        Stack<String> st=new Stack<>();
        for(char c:post_exp.toCharArray()){
            if(c>='a' && c<='z' || c>='A' && c<='Z') st.push(Character.toString(c));
            else{
                String first=st.pop();
                String second=st.pop();
                st.push(c+second+first);
            }
        }
        return st.pop();
    }
}
