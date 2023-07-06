//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            //br.readLine();
            String s;
            s = br.readLine();
            
            Solution obj = new Solution();
            int res = obj.countSubstring(s);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int countSubstring(String s) {
        // code here
        int[] count=new int[3];
        int i=0,j=0,ans=0;
        int n=s.length();
        while(j<n){
            count[s.charAt(j)-'a']++;
            while(count[0]>0 && count[1]>0 && count[2]>0){
                ans+=(n-j);
                count[s.charAt(i++)-'a']--;
            }
            j++;
        }
        return ans;
    }
}
        
