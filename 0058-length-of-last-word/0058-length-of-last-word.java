class Solution {
    public int lengthOfLastWord(String s) {
        int n=s.length();
        int i=n-1;
        while(i>=0){
            if(s.charAt(i)!=' ') break;
            i--;
        }
        if(i<0) return n;
        int len=0;
        while(i>=0 && s.charAt(i)!=' '){
            len++;
            i--;
        }
        return len;
    }
}