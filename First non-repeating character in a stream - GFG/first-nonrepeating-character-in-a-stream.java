//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String A = br.readLine().trim();
            Solution ob = new Solution();
            String ans = ob.FirstNonRepeating(A);
            out.println(ans);
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution
{
    public String FirstNonRepeating(String A)
    {
        // code here
        Map<Character, Integer> map = new LinkedHashMap<>();
        StringBuilder res = new StringBuilder();

        for (char c : A.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
            boolean flag = false;
            for(char ch:map.keySet()) {
                if (map.get(ch) == 1) {
                    res.append(ch);
                    flag = true;
                    break;
                }
            }
            if (flag==false) res.append("#");
        }

        return res.toString();
    }
}