class Solution {
    public String reverseWords(String s) {
        StringBuilder sb=new StringBuilder();
        int i=0;
        int n=s.length();
        while(i<n){
            int j=i;
            while(j<n && s.charAt(j)!=' ') j++;
            StringBuilder str=new StringBuilder();
            str.append(s.substring(i,j)).reverse();
            if(j!=n) str.append(" ");
            sb.append(str);
            i=j+1;
        }
        return sb.toString();
    }
}