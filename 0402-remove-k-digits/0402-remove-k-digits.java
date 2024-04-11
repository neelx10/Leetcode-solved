class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<num.length();i++){
            while(!st.isEmpty() && num.charAt(st.peek())>num.charAt(i) && k>0){
                st.pop();
                k--;
            }
            st.push(i);
        }

        while(k>0){
            st.pop();
            k--;
        }

        StringBuilder sb=new StringBuilder();
        while(!st.isEmpty()){
            sb.append(num.charAt(st.pop()));
        }
        sb=sb.reverse();

        int i=0;
        while(i<sb.length() && sb.charAt(i)=='0') sb.deleteCharAt(i);

        if(sb.length()==0) sb.append('0');
        return sb.toString();
    }
}