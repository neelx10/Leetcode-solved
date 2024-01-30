class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st=new Stack<>();
        for(String s:tokens){
            if(s.equals("+") ||s.equals("-") ||s.equals("*") ||s.equals("/")){
                int temp1=st.pop(),temp2=st.pop();
                if(s.equals("+")) st.push(temp2+temp1);
                else if(s.equals("-")) st.push(temp2-temp1);
                else if(s.equals("*")) st.push(temp2*temp1);
                else st.push(temp2/temp1);
            }
            else st.push(Integer.parseInt(s));
        }
        return st.pop();
    }
}