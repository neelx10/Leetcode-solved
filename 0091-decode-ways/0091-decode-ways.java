class Solution {
    public int numDecodings(String s) {
        int n=s.length();
        int next1=1,next2=0;
        for(int i=n-1;i>=0;i--){
            int curr=next1;
            if(i<s.length()-1 && (s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i+1) <= '6'))) curr+=next2;
            if(s.charAt(i)=='0') curr=0;
            next2=next1;
            next1=curr;
        }
        return next1;
    }
}