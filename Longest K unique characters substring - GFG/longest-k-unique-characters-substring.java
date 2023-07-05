//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.longestkSubstr(s, k));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestkSubstr(String s, int k) {
        // code here
        Map<Character,Integer> map=new HashMap<>();
        int i=0,j=0,len=0;
        while(j<s.length()){
            char c=s.charAt(j);
            while(map.size()>k){
                char ch=s.charAt(i);
                map.put(ch,map.get(ch)-1);
                if(map.get(ch)==0) map.remove(ch);
                i++;
            }
            if(map.size()==k) len=Math.max(len,j-i);
            map.put(c,map.getOrDefault(c,0)+1);
            j++;
        }
        if(map.size()==k) len=Math.max(len,j-i);
        return (len==0)?-1:len;
    }
}