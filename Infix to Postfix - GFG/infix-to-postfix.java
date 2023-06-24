//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {

    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            System.out.println(
                new Solution().infixToPostfix(br.readLine().trim()));
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to convert an infix expression to a postfix expression.
    public static int Prec(char x)
    {
        if(x=='^') return 2;
        else if(x=='*' || x=='/') return 1;                        
        else if(x=='+' || x=='-') return 0;
        return -1;
    }
    public static String infixToPostfix(String exp) {
        // Your code here
        Stack<Character> st=new Stack<>();
        StringBuilder ans=new StringBuilder();
        for(char c:exp.toCharArray()){
            if(c=='(') st.push(c);
            else if(c==')'){
                while(!st.isEmpty() && st.peek()!='(') ans=ans.append(st.pop());
                if(!st.isEmpty()) st.pop();
            }
            else if(c=='+' || c=='-' || c=='*' || c=='/'||c=='^'){
                while(!st.isEmpty() && Prec(st.peek())>=Prec(c)) ans=ans.append(st.pop());
                st.push(c);
            }
            else ans=ans.append(c);
        }
        while(!st.isEmpty()) ans=ans.append(st.pop());
        return ans.toString();
    }
}










