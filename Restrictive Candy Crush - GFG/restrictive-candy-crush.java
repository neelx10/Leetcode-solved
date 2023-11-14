//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.math.*;
import java.io.*;

class FastReader{ 
	BufferedReader br; 
	StringTokenizer st; 

	public FastReader(){ 
		br = new BufferedReader(new InputStreamReader(System.in)); 
	} 

	String next(){ 
		while (st == null || !st.hasMoreElements()){ 
			try{ st = new StringTokenizer(br.readLine()); } catch (IOException  e){ e.printStackTrace(); } 
		} 
		return st.nextToken(); 
	} 

	String nextLine(){ 
		String str = ""; 
		try{ str = br.readLine(); } catch (IOException e) { e.printStackTrace(); } 
		return str; 
	} 
} 

class Gfg
{
    public static void main(String args[])
    {
        FastReader sc = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(sc.next());
        while(t-- > 0)
        {
            int k = Integer.parseInt(sc.next());
            String s = sc.next();
            Solution T = new Solution();
            out.println(T.reduced_String(k, s));
        }
        out.flush();
    }
}

// } Driver Code Ends




//User function Template for Java

/*
    Note: Use StringBuilder/StringBuffer class for String concatenation(if any).
    While using String class, on each concatenation a new copy of the string is created, so that 
    the overall complexity is O(n^2) . Fortunately in Java we could solve this with a StringBuffer/StringBuffer, 
    which has O(1) complexity for each append.
*/
class Pair{
    char ch;
    int count;
    Pair(char ch,int i){
        this.ch=ch;
        this.count=i;
    }
}

class Solution
{
    public static String reduced_String(int k, String s)
    {
        if (k == 1) return "";
        // Your code goes here
        Stack<Pair> st = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(!st.isEmpty() && st.peek().ch==s.charAt(i)){
                Pair cp =st.pop();
                cp.count+=1;
                if(cp.count!=k) st.push(new Pair(cp.ch,cp.count));
            }
            else st.push(new Pair(s.charAt(i),1));
        }
        StringBuilder ans = new StringBuilder();
        while (st.size() > 0) {
            Pair temp=st.pop();
            char c = temp.ch;
            int cnt = temp.count;
            while (cnt-- > 0) ans.append(c);
        }
        return ans.reverse().toString();
    }
}