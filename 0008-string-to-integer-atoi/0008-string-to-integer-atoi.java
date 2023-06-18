class Solution {
    public boolean isDigit(char c){
        if(c=='+'||c=='-'||c=='.'||c==' '||(c-'0')>60) return false;
        else return true;
    }
    public int myAtoi(String s) {
        if(s.length()==0) return 0;
        int i=0;
        while(i<s.length() && s.charAt(i)==' ') i++;
        if(i==s.length()) return 0;
        boolean neg=false;
        long ans=0;
        if(s.charAt(i)=='-' || s.charAt(i)=='+'){
            if(s.charAt(i)=='-') neg=true;
            i++;
        }
        int max=Integer.MAX_VALUE;
        int min=Integer.MIN_VALUE;
        while(i<s.length()){
            if(!Character.isDigit(s.charAt(i))) break;
            ans=ans*10+(s.charAt(i++)-'0');
            if(neg==true && -1*ans<min) return min;
            if(neg==false && ans>max) return max;
        }
        return neg==true?(int)(-1*ans):(int)ans;
    }
}