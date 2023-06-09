class Solution {
    public int minLength(String s) {
        StringBuilder sb=new StringBuilder();
        for(char c:s.toCharArray()){
            int n=sb.length();
            if(n==0) sb.append(c);
            else{
                if(c=='B' && sb.charAt(n-1)=='A') sb.deleteCharAt(n-1);
                else if(c=='D' && sb.charAt(n-1)=='C') sb.deleteCharAt(n-1);
                else sb.append(c);
            }
        }
        return sb.length();
    }
}